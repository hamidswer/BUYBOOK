package models;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

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
 *         Responsibilities of class: It's responsible to check if a customer
 *         exist in the Customer database based on email and password provided
 *         by a customer. It is responsible for creating a new account in the
 *         customer database.
 * 
 *         Version/date: 1.6 / 05/15/2022
 * 
 * 
 */
public class CustomerDatabase
{

	// A CustomerDatabase has-a customer.
	private Customer customer;

	// The CustomerDatabase class has-a currentCustomer.
	private static Customer currentCustomer;

	public CustomerDatabase()
	{
	}

	public CustomerDatabase(Customer customer)
	{
		this.customer = customer;
	}

	/**
	 * Purpose: Create a new account.
	 * 
	 */
	public void createANewAccount()
	{
		try
		{
			CreditCard creditCard = this.customer.getCreditCard();

			// input the Customer database file.
			FileInputStream inputFile = new FileInputStream(new File("src/databases/Customers.xlsx"));

			try (XSSFWorkbook workbook = new XSSFWorkbook(inputFile))
			{
				// Get first sheet of excel file.
				XSSFSheet sheet = workbook.getSheetAt(0);

				// Get the last row in a database.
				Row row = sheet.createRow(sheet.getPhysicalNumberOfRows());

				// Create the frist cell of the last row.
				Cell cell = row.createCell(0);

				// Set the cell value to customer's name.
				cell.setCellValue(customer.getName());

				// Create the second cell of the last row.
				cell = row.createCell(1);

				// Set the cell value to customer's email.
				cell.setCellValue(customer.getEmail());

				// Create the third cell of the last row.
				cell = row.createCell(2);

				// Set the cell value to customer's password.
				cell.setCellValue(customer.getPassword());

				// Create the fourth cell of the last row.
				cell = row.createCell(3);

				// Set the cell value to customer's creditCardNumber.
				cell.setCellValue(creditCard.getCreditCardNumber());

				// Create the fifth cell of the last row.
				cell = row.createCell(4);

				// Set the cell value to customer's expirationDate.
				cell.setCellValue(creditCard.getExpirationDate());

				// Create the sixth cell of the last row.
				cell = row.createCell(5);

				// Set the cell value to customer's cvv.
				cell.setCellValue(creditCard.getCvv());

				// Initialize the output stream.
				FileOutputStream outputFile = new FileOutputStream(new File("src/databases/Customers.xlsx"));

				// Update the output file.
				workbook.write(outputFile);

				// The output file closed.
				outputFile.close();

				// Handle the output exceptions.
			} catch (IOException e)
			{
				System.out.println("Something is wrong with the output file.");
			} finally
			{
				// The input file closed.
				inputFile.close();
			}
		}
		// Handle Input exceptions.
		catch (IOException e)
		{
			System.out.println("Something is wrong with the input file.");
		}
	}

	/**
	 * Purpose: Find a customer exist or not.
	 * 
	 * @return true if there is a customer with credentials in database, false if
	 *         there is not.
	 */
	/**
	 * Purpose: Find a customer exist or not.
	 * 
	 * @param userEmail    - it's a use email address.
	 * @param userPassword - it's a user password.
	 * @return true if the user exist in the Customer database, false if the user is
	 *         not exist in the database.
	 */
	public boolean isCustomer(String userEmail, String userPassword)
	{
		try
		{
			// input the Customer database file.
			FileInputStream inputFile = new FileInputStream(new File("src/databases/Customers.xlsx"));

			try (XSSFWorkbook workbook = new XSSFWorkbook(inputFile))
			{
				// Get first sheet of excel file.
				XSSFSheet sheet = workbook.getSheetAt(0);

				// use iterator object to loop through collections like ArrayList. 
				// <Row> means each row of spreadsheet. so the program start to iterate for each row.
				// To iterate through rows of excel file.
				java.util.Iterator<Row> rowIterator = sheet.iterator();

				// While there isn't any blank row.
				while (rowIterator.hasNext())
				{
					// Get the row.
					Row row = rowIterator.next();

					// Get the second Cell.
					Cell cell2 = row.getCell(1);

					// Get its value (email)
					String email = cell2.getStringCellValue();

					// If the email is the same with provided email from the customer.
					if (email.equals(userEmail))
					{
						// Get the third Cell.
						Cell cell3 = row.getCell(2);

						// Get its value (password)
						String password = cell3.getStringCellValue();

						// If the password is the same with provided password from the customer.
						if (password.equals(userPassword))
						{
							// Assign the name from the first column of the row.
							String name = row.getCell(0).getStringCellValue();

							// Assign the creditCardNumber from the fourth column of the row. 
							String creditCardNumber = row.getCell(3).getStringCellValue();

							// Assign the expirationDate from the fifth column of the row. 
							String expirationDate = row.getCell(4).getStringCellValue();

							// Assign the cvv from the sixth column of the row. 
							String cvv = row.getCell(5).getStringCellValue();

							// Create the currentCustomer from the Customer class. 
							currentCustomer = new Customer(name, email, password, creditCardNumber, expirationDate,
									cvv);

							return true;
						}
					}

				}

			} catch (IOException e)
			{
				System.out.println("Something is wrong with the output file.");
			} finally
			{
				// The input file closed.
				inputFile.close();
			}
		} catch (IOException e)
		{
			System.out.println("Something is wrong with the output file.");
		}

		return false;
	}

	/**
	 * Purpose: Get the current customer.
	 * 
	 * @return currentCustomer
	 */
	public Customer getCurrentCustomer()
	{
		return currentCustomer;
	}
}
