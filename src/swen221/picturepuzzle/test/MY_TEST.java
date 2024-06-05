package swen221.picturepuzzle.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import swen221.picturepuzzle.model.Board;
import swen221.picturepuzzle.model.Location;
import swen221.picturepuzzle.moves.Rotation;

public class MY_TEST {
	
	@Test public void test_07() {
		int[] image = {
				0x000011, 0x000012, 0x000013, 0x000014, 0x000015, 0x000016,
				0x000017, 0x000018, 0x000019, 0x000020, 0x000021, 0x000022,
				0x000023, 0x000024, 0x000025, 0x000026, 0x000027, 0x000028,
				0x000029, 0x000030, 0x000031, 0x000032, 0x000033, 0x000034,
				0x000035, 0x000036, 0x000037, 0x000038, 0x000039, 0x000040,
				0x000041, 0x000042, 0x000043, 0x000044, 0x000045, 0x000046,
		};
		// Create board
		Board board = new Board(image,6,3);
		// Apply operation sequence
		board.apply(new Rotation(new Location(0,0),1));
		// Check output
		System.out.println(board.toString());
	}

}
