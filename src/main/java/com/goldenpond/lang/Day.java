package com.goldenpond.lang;

import com.goldenpond.utils.Print;

public enum Day {

	SUNDAY(10),
	MONDAY(5),
	TUESDAY(5),
	WENDESDAY(8),
	THURSDAY(8),
	FRIDAY(9),
	SATURDAY(10);
	
	private float discount;

	Day(int discount) {
		this.discount = (float) (discount * 0.1);
	}

	public float discount() {
		return this.discount;
	}

	public static void main(String[] args) {
		for (Day day : Day.values()) {
			Print.ln("the discount of " + day.name() + " is " + day.discount());
		}
	}
}
