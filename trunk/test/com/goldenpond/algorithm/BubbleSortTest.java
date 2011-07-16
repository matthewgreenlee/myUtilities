package com.goldenpond.algorithm;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BubbleSortTest {

	private BubbleSort sorter;

	@Before
	public void setUp() {
		sorter = new BubbleSort();
	}

	@Test
	public void testSort() {
		int[] vals = {4, 3, 7, 5, 6, 2, 8, 1, 9};
		vals = sorter.sort(vals);
		for (int i = 0; i < vals.length-1; i++) {
			assertTrue(vals[i] < vals[i+1]);
		}
	}

	@After
	public void tearDown() {
		sorter = null;
	}
}
