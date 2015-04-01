import static org.junit.Assert.*;
import org.junit.*;
import static org.mockito.Mockito.*;

public class Verification {

  @Test
  public void passTest() {
    assertEquals(0, 0);
  }

  @Test
  @Ignore
  public void failTest() {
    assertEquals(0, 1);
  }
}
