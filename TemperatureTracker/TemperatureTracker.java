import java.util.ArrayList;
import java.util.Scanner;

public class TemperatureTracker {

	public static void main(String[] args) {
		// Create ArrayLists to store days and temperatures
		ArrayList<String> days = new ArrayList<>();
		ArrayList<Double> temperatures = new ArrayList<>();
		
		// Initialize the days of the week
		String[] weekDays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
		
		// Create a scanner object for user input
		Scanner scnr = new Scanner(System.in);
		
		// Input temperatures for each day of the week
		System.out.println("Please enter the average temperatures for the week:");
		for (String day : weekDays) {
			System.out.print(day + ": ");
			double temperature = scnr.nextDouble();
			scnr.nextLine(); // Consume newline left-over
			days.add(day);
			temperatures.add(temperature);
		}
		
		// Prompt user to enter a day or 'week'
		System.out.println("\nEnter a day of the week (Monday through Sunday) or 'week' to see all data:");
		String input = scnr.nextLine();
		
		if (input.equalsIgnoreCase("week")) {
			// Display temperatures for each day and the weekly average
			double totalTemperature = 0;
			System.out.println("\nWeekly Temperatures:");
			for (int i = 0; i < days.size(); i++) {
				System.out.println(days.get(i) + ": " + temperatures.get(i) + "°C");
				totalTemperature += temperatures.get(i);
			}
			double weeklyAverage = totalTemperature / days.size();
			System.out.printf("Weekly Average Temperature: %.2f°C%n", weeklyAverage);
		} else {
			// Display the temperature for the specified day
			boolean dayFound = false;
			for (int i = 0; i < days.size(); i++) {
				if (days.get(i).equalsIgnoreCase(input)) {
					System.out.println(input + ": " + temperatures.get(i) + "°C");
					dayFound = true;
					break;
				}
			}
			if (!dayFound) {
				System.out.println("Invalid day entered. Please enter a valid day or 'week'.");
				
			}
		}
		
		// Close the scanner
		scnr.close();

	}

}
