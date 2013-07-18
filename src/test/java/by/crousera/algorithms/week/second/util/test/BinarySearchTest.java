package by.crousera.algorithms.week.second.util.test;

import static org.junit.Assert.*;

import org.junit.Test;

import by.crousera.algorithms.week.second.BinarySearch;

public class BinarySearchTest {
	@Test
	public void testContains() {
		int[] a = { 1, 2, 3, 4, 5, 7, 17, 19 };
		assertTrue(BinarySearch.contains(a, 1));
		assertTrue(BinarySearch.contains(a, 2));
		assertTrue(BinarySearch.contains(a, 3));
		assertTrue(BinarySearch.contains(a, 4));
		assertFalse(BinarySearch.contains(a, 10));
	}
}
