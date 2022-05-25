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
 *         Responsibilities of class: It gets the Inventory databse and updates
 *         it. It gets the books.
 * 
 *         Version/date: 2.4 / 05/15/2022
 * 
 * 
 */

public class InventoryDatabase
{

	// An InventoryDatabase has many books.
	private Book[] books;

	public InventoryDatabase()
	{
		getInventory();
	}

	/**
	 * Get books from the Inventory database.
	 * 
	 */
	public void getInventory()
	{
		try
		{
			// Initialize inputFile. Input bytes from a file in a file system.
			FileInputStream inputFile = new FileInputStream(new File("src/databases/Inventory.xlsx"));

			try (XSSFWorkbook workbook = new XSSFWorkbook(inputFile))
			{
				// Get the first sheet of excel file.
				XSSFSheet sheet = workbook.getSheetAt(0);

				// Initialize numberOfRows.
				int numberOfRows = sheet.getPhysicalNumberOfRows();

				// Initialize books array.
				books = new Book[numberOfRows];

				// use iterator object to loop through collections like ArrayList. <Row> means each row of spreadsheet, 
				// so the program start to iterate for each row
				// to iterate through rows of excel file.
				java.util.Iterator<Row> rowIterator = sheet.iterator();

				int rowCounter = 0;

				// while there isn't any blank row.
				while (rowIterator.hasNext())
				{

					// Initialize row.
					Row row = rowIterator.next();
					if (row.getRowNum() == 0)
					{
						continue; //just skip the rows if row number is 0
					}

					// use iterator object to loop through collections like ArrayList. 
					// <Cell> means each cell of spreadsheet. 
					// So the program start to iterate for each cell.
					java.util.Iterator<Cell> cellIterator = row.cellIterator();

					// the column used to see in which column of row the rowItrator is, 
					// So we can assign value to right variable.
					int column = 0;

					// Initialize an id.
					int id = 0;

					// Initialize a name.
					String name = "";

					// Initialize an author.
					String author = "";

					// Initialize a rate.
					int rate = 0;

					// Initialize a price.
					int price = 0;

					// Initialize a year.
					int year = 0;

					// Initialize a leftInStore.
					int leftInStore = 0;

					// Initialize a genre.
					String genre = "";

					// while there isn't any blank cell.
					while (cellIterator.hasNext())
					{

						// Initialize the cell.
						Cell cell = cellIterator.next();

						// Determine a cell is in which column.
						switch (column)
						{

						// if it's the first column.
						case 0:
							// Assign cell value to the id. 
							id = Integer.parseInt(type(cell));

							// Increment the column.
							column++;
							break;

						// if it's in the second column.	
						case 1:

							// Assign cell value to the name. 
							name = type(cell);

							// Increment the column.
							column++;
							break;

						// if it's in the third column.	
						case 2:

							// Assign cell value to the author. 
							author = type(cell);

							// Increment the column.
							column++;
							break;

						// if it's in the fourth column.	
						case 3:

							// Assign cell value to the rate.
							rate = Integer.parseInt(type(cell));

							// Increment the column.
							column++;
							break;

						// if it's in the fifth column.
						case 4:

							// Assign cell value to the price.
							price = Integer.parseInt(type(cell));

							// Increment the column.
							column++;
							break;

						// if it's in the sixth column.
						case 5:

							// Assign cell value to the year.
							year = Integer.parseInt(type(cell));

							// Increment the column.
							column++;
							break;

						// if it's in the seventh column.
						case 6:

							// Assign cell value to the leftInStore.
							leftInStore = Integer.parseInt(type(cell));

							// Increment the column.
							column++;
							break;

						// if it's in the eighth column.
						case 7:

							// Assign cell value to the genre.
							genre = type(cell);

							Book book = new Book(id, name, author, rate, price, year, leftInStore, genre);
							books[rowCounter] = book;

							rowCounter++;
							column = 0;
							break;
						}

					}
				}
			}

			// Close the inputFile.
			if (inputFile != null)
				inputFile.close();
		}

		// Handle Input or Output exceptions.
		catch (IOException e)
		{
			System.out.println("Something is wrong with file. First check file directory and name.");
		}
	}

	/**
	 * Purpose: Get the books.
	 * 
	 * @return books.
	 */
	public Book[] getBooks()
	{
		return books;
	}

	/**
	 * Purpose: Update the leftInStore column in the inventory database by finding a
	 * book based on its id.
	 * 
	 * @param bookId - an id of a book
	 */
	public void updateInventory(int bookId)
	{
		try
		{
			// Initialize inputFile. Input bytes from a file in a file system.
			FileInputStream inputFile = new FileInputStream(new File("src/databases/Inventory.xlsx"));

			try (XSSFWorkbook workbook = new XSSFWorkbook(inputFile))
			{
				// Get the first sheet of excel file.
				XSSFSheet sheet = workbook.getSheetAt(0);

				// use iterator object to loop through collections like ArrayList. <Row> means each row of spreadsheet, 
				// so the program start to iterate for each row
				// to iterate through rows of excel file.
				java.util.Iterator<Row> rowIterator = sheet.iterator();

				// While there isn't any blank row.
				while (rowIterator.hasNext())
				{
					// Initialize row.
					Row row = rowIterator.next();
					if (row.getRowNum() == 0)
					{
						continue; //just skip the rows if row number is 0
					}

					// Get the id Cell.
					Cell idCell = row.getCell(0);

					// Get the cell value.
					int id = (int) idCell.getNumericCellValue();

					// If the book id is the same by the id provided.
					if (bookId == id)
					{
						// Get the leftInStore Cell.
						Cell leftInStore = row.getCell(6);

						// Calculate updated leftInStore and assign it to the left.
						int left = (int) leftInStore.getNumericCellValue() - 1;

						// Update the cell value.
						leftInStore.setCellValue(left);
					}

					// Initialize the outputFile.
					FileOutputStream outputFile = new FileOutputStream(new File("bestsellers.xlsx"));

					// Update the file.
					workbook.write(outputFile);
					// Close the outputFile.
					outputFile.close();
				}

			}

			// Close the inputFile.
			if (inputFile != null)
				inputFile.close();
		}

		// Handle Input or Output exceptions.
		catch (IOException e)
		{
			System.out.println("Something is wrong with file. First check file directory and name.");
		}
	}

	/**
	 * Purpose: Give string value of each cell of an excel file. Each cell could
	 * have String or Numeric values so we should handle it somehow to assign the
	 * String value to our properties.
	 * 
	 * @param cell - each cell of excel file.
	 * @return cell value as String
	 */
	public static String type(Cell cell)
	{
		// The getCellTypeEnum method check the type of each cell's value. (It could be String, Numeric, or ...)
		switch (cell.getCellTypeEnum())
		{
		// If the type of input is string.
		case STRING:

			// Return the String value.
			return cell.getStringCellValue();

		// If the type of input is Numeric
		case NUMERIC:

			// Return the Numeric value(double) and then turn it to Int, and then turn it to String.
			return String.valueOf((int) cell.getNumericCellValue());
		case BLANK:
			break;
		case BOOLEAN:
			break;
		case ERROR:
			break;
		case FORMULA:
			break;
		case _NONE:
			break;
		default:
			break;
		}

		// return empty Space if the cell has different type of values.
		return " ";
	}

}
