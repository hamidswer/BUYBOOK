package models;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CustomerDatabase
{
	// A CustomerDatabase has-an inputFile.
	private FileInputStream inputFile;

	// A CustomerDatabase has-an outputFile.
	private FileOutputStream outputFile;

	// A CustomerDatabase has-a customer.
	private Customer customer;

	// A CustomerDatabase has-a creditCard.
	private CreditCard creditCard;

	// A CustomerDatabase has-a currentCustomer.
	private static Customer currentCustomer;

	public CustomerDatabase()
	{
	}

	public CustomerDatabase(Customer customer)
	{
		this.customer = customer;
	}

	/**
	 * Create a new account.
	 * 
	 * @param customer   A customer who created account.
	 * @param creditCard A customer's creditCard.
	 */
	public void createANewAccount()
	{
		try
		{
			this.creditCard = this.customer.getCreditCard();

			// input the Customer database file.
			inputFile = new FileInputStream(new File("src/databases/Customers.xlsx"));

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
				outputFile = new FileOutputStream(new File("src/databases/Customers.xlsx"));

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
	 * Find a customer exist or not.
	 * 
	 * @return true if there is a customer with credentials in database, false if
	 *         there is not.
	 */
	public boolean isCustomer(String userEmail, String userPassword)
	{
		try
		{
			// input the Customer database file.
			inputFile = new FileInputStream(new File("src/databases/Customers.xlsx"));

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
							String name = row.getCell(0).getStringCellValue();
							String creditCardNumber = row.getCell(3).getStringCellValue();
							String expirationDate = row.getCell(4).getStringCellValue();
							String cvv = row.getCell(5).getStringCellValue();
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
	 * Get the current customer.
	 * 
	 * @return currentCustomer
	 */
	public Customer getCurrentCustomer()
	{
		return currentCustomer;
	}
}
