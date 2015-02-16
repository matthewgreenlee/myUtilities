package com.goldenpond.algorithm;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MergeSortTest {

	private MergeSort sorter;

	@Before
	public void setUp() {
		sorter = new MergeSort();
	}

	@Test
	public void testSort() {
		int[] vals = {3, 5, 1, 6, 8};
		sorter.sort(vals);
		for (int i = 0; i < vals.length-1; i++) {
			assertTrue(vals[i] < vals[i+1]);
		}
	}

	@After
	public void tearDown() {
		sorter = null;
	}
}
