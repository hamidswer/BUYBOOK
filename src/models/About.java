package models;

import java.net.URL;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Lead Author(s):
 * 
 * @author Hamid Reza Zamaninasab
 * 
 *         Other contributors: Allan Schougaard
 * 
 *         Resources:
 * 
 *         Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented
 *         Problem Solving.
 *         https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 * 
 *         Responsibilities of class: It converts JSon file retrived from the
 *         web to the string. So it can be used in the about page view.
 * 
 *         Version/date: 1.6 / 05/26/2022
 * 
 * 
 */

public class About {
	// An About has-a json.
	private JSONObject json;

	// An About has-a message.
	private String message = "";

	public About() {
		// Assign the json value by creating a new JSONObject and invoking the getJSON
		// method.
		try {
			json = new JSONObject(getJSON());
		} catch (Exception e) {
			message = "Something went wrong by importing JSON file from the web!";
		}
	}

	/**
	 * Purpose: It turns a json file from the web to the string.
	 * 
	 * @return result a string value of a json file from the web.
	 */
	public String getJSON() {
		// Initialize the result to save json file in it.
		String result = "";
		try {
			// Retrieving the url
			URL url = new URL("https://soomera.com/programs/BUYBOOK/JSON/about.json");

			// Get a stream from which you can read the contents of the url.
			Scanner sc = new Scanner(url.openStream());

			// Instantiating the StringBuffer class to hold the result.
			StringBuffer sb = new StringBuffer();

			// returns true if this scanner has another token in its input.
			while (sc.hasNext()) {
				// Append next string to characters
				sb.append(sc.next() + " ");
			}

			// Retrieving the String from the String Buffer object
			result = sb.toString();

		} catch (Exception err) {
			message = "Something went wrong by importing JSON file from the web!";
		}
		return result;
	}

	/**
	 * Purpose: Get the Address(key) value of json file as string.
	 * 
	 * @return address value
	 */
	public String getAddress() {
		String address = "";
		if (json != null)
			address = json.has("Address") ? json.getString("Address") : "";
		return address;
	}

	/**
	 * Purpose: Get the History(key) value of json file as string.
	 * 
	 * @return history value
	 */
	public String getHistory() {
		String history = "";
		if (json != null)
			history = json.has("History") ? json.getString("History") : "";
		return history;
	}

	/**
	 * Purpose: Get the Members(key) value of json file as an two dimensional array.
	 * 
	 * @return members array
	 */
	public String[][] getMembers() {

		// Initialize membersJsonArray to get the array with members as a key inside
		// json file.
		JSONArray membersJsonArray = json.getJSONArray("members");

		// Initialize two dimensional members array to save the information which is
		// retrieved from the membersJsonArray.
		String[][] members = new String[membersJsonArray.length()][4];

		for (int i = 0; i < membersJsonArray.length(); i++) {
			// Assign value of members elements.
			members[i][0] = membersJsonArray.getJSONObject(i).getString("gender");
			members[i][1] = membersJsonArray.getJSONObject(i).getString("name");
			members[i][2] = membersJsonArray.getJSONObject(i).getString("position");
			members[i][3] = membersJsonArray.getJSONObject(i).getString("age");
		}
		return members;
	}

	/**
	 * Convert JSon file to a customized text for using in about page view.
	 */
	public String toString() {
		if (json != null) {
			// Adds history to the aboutUsMessage.
			message += "History: " + getHistory() + " Members: ";

			// Initialize the gender to save information about members gender identity.
			String gender = "";

			for (int i = 0; i < getMembers().length; i++) {
				for (int j = 0; j < getMembers()[i].length; j++) {
					String memberInfo = getMembers()[i][j];
					switch (j) {
					case 0:
						// If the gender(key) value is m assign he otherwise assign she to the gender.
						gender = (memberInfo.equals("m")) ? "he" : "she";
						break;

					case 1:
						// Adds position(key) value to the aboutUsMessage.
						message += memberInfo + " is the BUYBOOK's ";
						break;

					case 2:
						// Adds gender value to the aboutUsMessage.
						message += memberInfo + ", and " + gender + " is ";
						break;

					case 3:
						// Adds age(key) value to the aboutUsMessage.
						message += memberInfo + " years old. ";
						break;

					}
				}
			}
			// Adds Address(key) value to the aboutUsMessage.
			message += "Address: " + getAddress();
		}

		return message;
	}
}
