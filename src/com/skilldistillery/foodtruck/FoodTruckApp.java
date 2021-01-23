package com.skilldistillery.foodtruck;

import java.util.Scanner;

public class FoodTruckApp {
	private int userEntry;
	private String userTruck;
	private String userType;
	private boolean userAnswer = true;
	private boolean userMenu = true;
	private double userRating;
	private int counter = 0;
	boolean keepGoing = true;
	private double averagedRating;
	private double highestRatedTruck;

	public static void main(String[] args) {

		FoodTruckApp app = new FoodTruckApp();
		Scanner kb = new Scanner(System.in);

		// Runs the first method to get all the user input
		FoodTruck[] truckList = app.userAnswer(kb);
// runs the second method to calculate and store all the info

		app.userMenu(kb, truckList);

		kb.close();
	}

	public void printAllTrucks(FoodTruck[] trucks) {
		for (int i = 0; i < counter; i++) {
			System.out.println(trucks[i]);
		}

	}

	public void printTruckAverage(FoodTruck[] trucks) {
		for (int i = 0; i < counter; i++) {
			userRating += trucks[i].getRating();
		}
		averagedRating = (userRating / counter);

		System.out.println("The average rating for all of the Food Trucks is : ");
		System.out.printf("%.1f", averagedRating);
	}

	public void printAverageRating(FoodTruck[] trucks) {
		FoodTruck topTruck = new FoodTruck();
		for (int i = 0; i < counter; i++) {
			if (trucks[i].getRating() > highestRatedTruck) {
				highestRatedTruck = trucks[i].getRating();
				topTruck = trucks[i];
			} else {
				continue;
			}
		}
		System.out.println("The highest rated Food Truck is: " + highestRatedTruck);
	}

	// This is the start of the user entering all Food Truck Attributes

	public FoodTruck[] userAnswer(Scanner kb) {

		FoodTruck[] trucks;
		System.out.println("Please tell me how many truck you would like to review: ");
		userEntry = kb.nextInt();

		while (keepGoing) {
			if (userEntry > 5 && userEntry < 0) {
				System.out.println(
						"You can only enter between 1 & 5 trucks at a time. If you would like to quit, you may enter 0");
				userEntry = kb.nextInt();
				continue;
			} else if (userEntry == 0) {
				System.out.println("Please make a valid entry.");
				break;
			}
			keepGoing = false;

		}
		trucks = new FoodTruck(userEntry);

		while (counter < userEntry && keepGoing < userEntry) {
			System.out.println("Enter a name for the food truck or you can type 'quit' to exit.");
			userTruck = kb.nextLine();
		}

		if (userTruck.equals("quit") && counter == 0) {
			System.out.println("Moving on...");
			keepGoing = false;
			userMenu = false;
			break;
		}
		if (userTruck.equals("quit")) {
			break;
		}

		System.out.println("What type of food  does this truck serve? ");
		userType = kb.nextLine();

		System.out.println("What rating would you give this truck? ");
		userRating = kb.nextDouble();
		kb.nextLine();

		FoodTruck truck = new FoodTruck(userTruck, userType, userRating);

		trucks[counter] = truck;
		counter++;
		return trucks;
	}

	// This is the User Menu
	public void userMenu(Scanner kb, FoodTruck[] trucks) {
		int userMenuSelection = 0;

		while (userMenu) {
			System.out.println("\nChoose an option from the menu: ");
			System.out.println("===================================");
			System.out.println("1. List all exsisiting Food Trucks.");
			System.out.println("2. See the average rating of the Food Trucks. ");
			System.out.println("3. Display the highest rated Food Truck.  ");
			System.out.println("4. Quit");

			switch (userMenuSelection) {
			case 1:
				printAllTrucks(trucks);
				break;
			case 2:
				printTruckAverage(trucks);
				break;
			case 3:
				printAverageRating(trucks);
				break;
			case 4:
				keepGoing = false;
				userMenu = false;
				System.out.println("Thanks for using the app! ");
				break;
			default:
				break;
			}

		}
	}

}
