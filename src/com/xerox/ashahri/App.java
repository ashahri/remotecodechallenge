package com.xerox.ashahri;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import com.google.gson.Gson;

public class App {

	public static void main(String[] args) throws IOException {

		String story;
		Scanner uInput = new Scanner(System.in);
		System.out
				.println("Please select the number of story to view the results: ");
		story = uInput.nextLine();

		switch (story) {
		case "1":
			firstStory();
			break;
		case "2":
			String userRequest;
			System.out
					.println("Please enter the Brand and model seperated by a space: ");
			userRequest = uInput.nextLine();
			secondStory(userRequest);
			break;
		case "3":
			thirdStory();
			break;
		case "4":
			fourthStory();
			break;
		}

		uInput.close();

	}

	public static void firstStory() throws FileNotFoundException, IOException {

		Gson gson = new Gson();
		try (BufferedReader br = new BufferedReader(new FileReader(
				"devices.json"))) {
			Device[] dev = gson.fromJson(br, Device[].class);

			// First Story
			if (dev != null) {
				int i = 0;
				for (Device d : dev) {
					i++;
					System.out.println("Device number: " + i);
					System.out.println("Brand: " + d.getBrand());
					System.out.println("Model: " + d.getModel());
					System.out.println("FormFactor: " + d.getFormFactor());
					System.out.println("Attributes: ");
					for (int j = 0; j <= d.getAttributes().size() - 1; j++) {

						System.out.print(d.getAttributes().get(j).getName()
								+ ": ");
						System.out.println(d.getAttributes().get(j).getValue());
					}
					System.out.println();

				}

			}
		}
	}

	// end of First Story

	// Second Story
	public static void secondStory(String brandAndModel)
			throws FileNotFoundException, IOException {

		String brand = "", model = "";
		// Scanner input = new Scanner(System.in);
		// System.out
		// .println("Please enter the Brand and model seperated by a space: ");
		// brandAndModel = input.nextLine();

		// input.close();
		String[] word = brandAndModel.split(" ");
		brand = word[0];
		model = word[1];

		Gson gson = new Gson();
		try (BufferedReader br = new BufferedReader(new FileReader(
				"devices.json"))) {
			Device[] dev = gson.fromJson(br, Device[].class);

			// Second Story
			if (dev != null) {
				int i = 0;
				for (Device d : dev) {

					if (d.getBrand().equals(brand)
							&& d.getModel().equals(model)) {
						i++;
						System.out.println("Device number: " + i);
						System.out.println("Brand: " + d.getBrand());
						System.out.println("Model: " + d.getModel());
						System.out.println("FormFactor: " + d.getFormFactor());
						System.out.println("Attributes: ");
						for (int j = 0; j <= d.getAttributes().size() - 1; j++) {

							System.out.print(d.getAttributes().get(j).getName()
									+ ": ");
							System.out.println(d.getAttributes().get(j)
									.getValue());
						}
						System.out.println();

					}
				}

			}
		}

	}

	// end of Second Story

	// start of the third story
	public static void thirdStory() throws FileNotFoundException, IOException {

		Gson gson = new Gson();
		try (BufferedReader br = new BufferedReader(new FileReader(
				"devices.json"))) {
			Device[] dev = gson.fromJson(br, Device[].class);
			int i = 0;
			Set<String> set = new HashSet<String>();
			BufferedWriter wr = new BufferedWriter(
					new FileWriter("Logfile.log"));

			wr.write("This is the log file for the invalid devices");
			wr.newLine();
			wr.write("-------------------------------------------------------------");
			wr.newLine();

			for (Device d : dev) {
				i++;
				int flag = 0;
				// detecting duplicates
				if (set.add(d.getBrand() + " " + d.getModel()) == false) {
					wr.write("The device number " + i + ", \"" + d.getBrand()
							+ " " + d.getModel()
							+ "\" is not unique in the given file");
					wr.newLine();
					flag = 1;
				}
				// end of detecting duplicates

				// validate the Brand and Model name
				if ((d.getBrand().isEmpty() || d.getBrand().length() > 50)) {
					wr.write("Brand for device number " + i
							+ " is invalid, please check");
					wr.newLine();
					flag = 1;
				}
				if ((d.getModel().isEmpty() || d.getModel().length() > 50)) {
					wr.write("Model for device number " + i
							+ " is invalid, please check");
					wr.newLine();
					flag = 1;
				}
				// End of validating the Brand and Model name

				// validating form factors
				if (d.getFormFactor().toString().equals("CANDYBAR")
						|| d.getFormFactor().equals("SMARTPHONE")
						|| d.getFormFactor().equals("PHABLET")
						|| d.getFormFactor().equals("CLAMSHELL")) {
				} else {
					wr.write("Form factor is invalid for the device number "
							+ i);
					wr.newLine();
					flag = 1;
				}
				// end of validating form factors
				// validating attirbutes
				if (d.getAttributes().get(0).getName().length() > 20
						|| d.getAttributes().get(0).getValue().length() > 100) {
					wr.write("Attribute for device number " + i
							+ " is not valid");
					wr.newLine();
					flag = 1;
				}
				if (flag == 0) {

					System.out.println("Device number: " + i);
					System.out.println("Brand: " + d.getBrand());
					System.out.println("Model: " + d.getModel());
					System.out.println("FormFactor: " + d.getFormFactor());
					System.out.println("Attributes: ");
					for (int j = 0; j <= d.getAttributes().size() - 1; j++) {

						System.out.print(d.getAttributes().get(j).getName()
								+ ": ");
						System.out.println(d.getAttributes().get(j).getValue());
					}
					System.out.println();

				}
			}// end of for
			wr.close();
		}
	}

	// end of the thrid story

	// Fourth Story
	public static void fourthStory() throws FileNotFoundException, IOException {
		String brandOrModel = "";
		Scanner uInput = new Scanner(System.in);
		System.out
				.println("Please enter the Brand or the Model of the Device: ");
		brandOrModel = uInput.nextLine();
		uInput.close();

		Gson gson = new Gson();
		try (BufferedReader br = new BufferedReader(new FileReader(
				"devices.json"))) {
			Device[] dev = gson.fromJson(br, Device[].class);

			if (dev != null) {
				int i = 0;
				for (Device d : dev) {

					if (d.getBrand().equals(brandOrModel)
							|| d.getModel().equals(brandOrModel)) {
						i++;
						System.out.println("Device number: " + i);
						System.out.println("Brand: " + d.getBrand());
						System.out.println("Model: " + d.getModel());
						System.out.println("FormFactor: " + d.getFormFactor());
						System.out.println("Attributes: ");
						for (int j = 0; j <= d.getAttributes().size() - 1; j++) {

							System.out.print(d.getAttributes().get(j).getName()
									+ ": ");
							System.out.println(d.getAttributes().get(j)
									.getValue());
						}
						System.out.println();

					}
				}

			}
		}

	}

	// end of Fourth Story
}
