package com.laboon;

import java.util.Random;

public class World {

	static int[] dx = {-1,-1,-1, 0, 0, 1, 1, 1};
	static int[] dy = {-1, 0, 1,-1, 1,-1, 0, 1};

	/**
	 * Size of the world
	 */
	
	int _size;
	
	/**
	 * The world, a 2D array of Cells which can be living or dead.
	 */
	
	Cell[][] _world;
	
	/**
	 * A random number generator.
	 */
	
	Random _rng;
	
	/**
	 * Initial world constructor.
	 * @param size Size of world
	 * @param seed Random number generator seed
	 * @param percent Initial percentage of cells alive
	 */
	
	public World(int size, int seed, int percent) {
		_size = size;
		_rng = new Random(seed);
		_world = generateBoard(size, percent);
	}
	
	/**
	 * Iterated (non-initial) world constructor.
	 * @param cells Cells living in the new world
	 * @param rng Random number generator
	 */
	
	public World(Cell[][] cells, Random rng) {
		_size = cells.length;
		_rng = rng;
		_world = cells;
	}
	
	/**
	 * Generate the initial state of a cell, given the percentage
	 * chance that it is living.
	 * @param percent percentage chance that it is living
	 * @return state of cell, State.ALIVE or State.DEAD
	 */
	
	private State generateInitialState(int percent) {
		int livingChance = _rng.nextInt(100);
		State toReturn = (livingChance < percent) ? State.ALIVE : State.DEAD;
		return toReturn;
	}
	
	/**
	 * The number of living neighbors that a cell has.
	 * @param world the world
	 * @param x x location of cell
	 * @param y y location of cell
	 * @return
	 */
	
	public int getNumNeighbors(Cell[][] world, int x, int y) {
		int numNeighbors = 0;

		if (x != 0 && y != 0 && x != _size-1 && y != _size-1) {
			//anywhere in the middle of the world
			for (int i=0; i<dx.length; i++)
				if (world[x+dx[i]][y+dy[i]].isAlive())
					numNeighbors++;
		} else if( x == 0 && y != 0) {
			if (world[x][y+1].isAlive()) { numNeighbors++; }
			if (world[x][y-1].isAlive()) { numNeighbors++; }
			if (world[x+1][y].isAlive()) { numNeighbors++; }
		} else if (y == 0 && x != 0) {
			if (world[x][y+1].isAlive()) { numNeighbors++; }
			if (world[x-1][y].isAlive()) { numNeighbors++; }
			if (world[x+1][y].isAlive()) { numNeighbors++; }
		} else if (x == 0 && y == 0) {
			//top left corner
			if (world[0][1].isAlive()) { numNeighbors++; }
			if (world[1][1].isAlive()) { numNeighbors++; }
			if (world[1][0].isAlive()) { numNeighbors++; }
		} else if (x == _size-1 && y != _size-1) {
			if (world[x-1][y].isAlive()) { numNeighbors++; }
			if (world[x+1][y].isAlive()) { numNeighbors++; }
			if (world[x][y+1].isAlive()) { numNeighbors++; }			
		} else if (y == _size-1 && x != _size-1) {
			if (world[x-1][y].isAlive()) { numNeighbors++; }
			if (world[x][y+1].isAlive()) { numNeighbors++; }
			if (world[x][y-1].isAlive()) { numNeighbors++; }		
		} else if (x == _size-1 && y == _size-1) {
			//bottom right corner
			if (world[_size-1][_size-2].isAlive()) { numNeighbors++; }
			if (world[_size-2][_size-2].isAlive()) { numNeighbors++; }
			if (world[_size-2][_size-1].isAlive()) { numNeighbors++; }			
		}

		return numNeighbors;
	}
	
	/**
	 * Go through one iteration of this World and return new World.
	 * @return New world
	 */
	
	public World iterate() {
		Cell[][] newCells = new Cell[_size][_size];
		for (int j = 0; j < _size; j++ ) {
			for (int k = 0; k < _size; k++) {
				newCells[j][k] = new Cell(_world[j][k].iterate(getNumNeighbors(_world, j, k)), j, k);
			}
		}
		return new World(newCells, _rng);
	}

	/**
	 * Convert this World to a string for display.
	 * @return String representation of world
	 */
	
	public String toString() {
		String toReturn = "  ";
		for (int j= 0; j < _size; j++) {
			toReturn += String.valueOf(j % 10);
		}
		toReturn += "\n";
		for (int j = 0; j < _size; j++ ) {
			toReturn += String.valueOf(j % 10) + " ";
			for (int k = 0; k < _size; k++) {
				toReturn += (_world[j][k].getStateRep());
			}
			toReturn += "\n";
		}
		return toReturn;
	}
	
	/**
	 * Generate initial game board.
	 * @param size Size of board
	 * @param percent Percent alive
	 * @return Initial world
	 */
	
	private Cell[][] generateBoard(int size, int percent) {
		Cell[][] world = new Cell[size][size];
		for (int j = 0; j < size; j++ ) {
			for (int k = 0; k < size; k++) {
				world[j][k] = new Cell(generateInitialState(percent), j, k);
			}
		}
		return world;
	}
	
}
