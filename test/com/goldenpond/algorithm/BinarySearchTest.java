package com.goldenpond.algorithm;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BinarySearchTest {

	private BinarySearch searcher;

	@Before
	public void setUp() {
		searcher = new BinarySearch();
	}

	@Test
	public void testSearch() {
		int[] a = {3, 15, 28, 30, 49, 57, 65, 74, 83};
		int idx = new Random().nextInt(a.length);
		int idxFound = searcher.search(a, a[idx]);
		assertEquals(idx, idxFound);
		assertEquals(-1, searcher.search(a, 99));
	}

	@After
	public void tearDown() {
		searcher = null;
	}
}
