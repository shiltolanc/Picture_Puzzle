// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a SWEN221 assignment.
// You may not distribute it in any other way without permission.
package swen221.picturepuzzle.moves;

import swen221.picturepuzzle.model.Board;
import swen221.picturepuzzle.model.Cell;
import swen221.picturepuzzle.model.Location;
import swen221.picturepuzzle.model.Operation;

/**
 * Responsible for rotating the image data in a given cell in a clockwise
 * direction.
 *
 * @author betty
 *
 */
public class Rotation implements Operation {
	/**
	 * Location of cell which is to be rotated.
	 */
	private final Location location;
	/**
	 * Number of steps to rotate (in a clockwise direction) where each step is a
	 * 90degree rotation.
	 */
	private final int steps;

	/**
	 * Construction a rotation for the cell at a given location, rotating a given
	 * number of steps.
	 *
	 * @param loc   Location of cell to be rotated.
	 * @param steps Number of rotations to apply.
	 */
	public Rotation(Location loc, int steps) {
		this.location = loc;
		this.steps = steps;
	}

	/**
	 * Apply rotation to the selected cell.
	 *
	 * @param board Board where rotation is being applied.
	 */
	@Override
	public void apply(Board board) {
		Cell cell = board.getCellAt(location);
		if(steps == 0 || cell == null) return;
		
		int pixels[][] = new int[cell.getWidth()][cell.getWidth()];
		
		for(int i = 1; i <= steps; i++) {
			
			for(int y = 0; y < cell.getWidth(); y++) {	
				for(int x = 0; x < cell.getWidth(); x++) {
						pixels[x][y] = cell.getRGB(x, y); //saves the rgb values of the cell
			}
		}
		
		int cx = 0;
		for(int y = 0; y < cell.getWidth(); y++) {
			int cy = 0;
			for(int x = cell.getWidth() - 1; x >= 0; x--) {
				cell.setRGB(x, y, pixels[cx][cy]); //places the rgb values back onto the board rotates-
				cy++;
				}
			cx++;
			}
		}
	}
	
}
