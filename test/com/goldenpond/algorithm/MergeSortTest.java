package com.goldenpond.algorithm;

import static org.junit.Assert.assertTrue;

import java.util.Random;

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
		int[] a = {3, 5, 1, 6, 8};
		sorter.sort(a);
		int idxHigh = new Random().nextInt(a.length);
		int idxLow = new Random().nextInt(idxHigh);
		assertTrue(a[idxLow] < a[idxHigh]);
	}

	@After
	public void tearDown() {
		sorter = null;
	}
}
