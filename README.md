# Improved JavaLife for Joel Roggeman
## Profiling
I started by running the JavaLife program with a large (20x20) board, a seed
that I typed randomly, a percentage around 30%, and a few million iterations (to
keep it running).  After starting VisualVM and hooking it up to the process, I
started up the CPU sampler and looked at which methods were taking up the most
time.  As was quite apparent from the first screenshot, the `toString()` method
was taking up a huge majority of the wall clock time.

## Refactoring
As such, I looked into the `toString()` method to see what the problem was.  I
noticed that to build up the `String` representation of the world, a string was
initialized and then added to in the following manner:

    String toReturn = "I like ";
    toReturn += "cats";

In Java, however, strings are immutable, so any string "addition" is implicitly
converted to the following:

    // This...
    toReturn += "cats";

    // ... becomes this:
    toReturn = new StringBuilder().append(toReturn).append("cats").toString();

This isn't a problem for smaller programs, but when it's done repeatedly, it
becomes quite ineffecient, because the strings aren't modified, but rather
recreatd each time, with the additional overhead of having the one-use-only
`StringBuilder`.  As it turns out, not only did `toString()` have multiple
instances of this, it was even done within a double `for` loop, and since this
method is called with each of the iterations, we end up with a massive number of
wasted allocations of `StringBuilder` and unnecessary re-allocation of `String`
objects.

So, I basically went through the method and replaced every instance of creating
or appending to a string with an equivalent statement using a `StringBuffer`, an
immutable class that would be instantiated once for the method, added to, and
would return a single `String` object at the end.

## What to Test
Determining what to test was interesting as always, as there weren't really
explicit requirements (other than examples of what the method should return).
After a bit of experimentation, I decided on a few requirements of my own.
Since it was consistent between runs of `toString()`, I decided to test to
ensure that there each row and column of the grid had appropriate numbers
labelling them.  So, for example, I would test to make sure that the first line
of output was `0123...`, and would test that a similar number was at the
beginning of each line.

Aside from that, I decided that there wasn't a reasonable way to test the board
output without comparing it directly with expected output.  So, I ran a few trials
of game beforehand, with board sizes both below and above 10 (different sizes +
modular arithmetic in the column/row labels led me to do this), and I recorded
both the initial board state and the state after a set number of iterations.  I
then created JUnit tests that asserted that running the game again with similar
parameters would produce the same output.

## Difficulties
The main difficulty (as it tends to be for me) is determing what is reasonable
to test.  If you created the code yourself, it's a bit easier to know exactly
what you want it to do; if you write it using TDD, you don't even have to worry
about this after the fact.  Writing tests for someone else's code that doesn't
have strict requirements requires a good amount more creative thinking, which is
something that I'm getting used to.

Other than that, there weren't too many challenges, other than figuring out how
to use VisualVM on Arch.  Once it was set up, hooking it up to a running VM was
easy, profiling was straightforward and immediately suggested a method to alter,
and looking at the method made it pretty apparent what needed to be done.
