package com.skilldistillery.foodtruck;

public class FoodTruck {

	private int numericId;
	private static int foodTruckCount = 1;
	private String name;
	private String foodType;
	private double numericRating;

	// Constructors

	public FoodTruck(String name, String foodType, double numericRating) {

		this.name = name;
		this.foodType = foodType;
		this.numericRating = numericRating;
		this.numericId = foodTruckCount;
		foodTruckCount++;
	}

	public FoodTruck() {
		// TODO Auto-generated constructor stub
	}

	public String toString() {
		StringBuilder build = new StringBuilder();
		build.append(" Name = ");
		build.append(name);
		build.append(" Type of food = ");
		build.append(foodType);
		build.append("Food Truck # ");
		build.append(numericId);
		build.append(" This truck has a rating of: ");
		build.append(numericRating);
		build.append("This trucks ID is: ");
		build.append(numericId);
		build.append(" ");
		return build.toString();

	}
	
	public double getRating() {
		return this.numericRating;
	}

	public String getName() {
		return this.name;
	}
}
