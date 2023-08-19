package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import data.AnnualBudget;
import data.Entry;
import data.MonthOfYear;
import data.MonthlyBudget;
import javafx.stage.FileChooser;

public class JSON_IO {

	/**
	 * Exports all entered data into a json-file.
	 * 
	 * @param annualBudget - contains all entered data
	 */
	public static void exportJSON(AnnualBudget annualBudget) {

		JSONObject data = new JSONObject();
		for (MonthOfYear month : MonthOfYear.values()) {
			int id = month.getValue();

			JSONObject tmp = new JSONObject().put("monthlyBudget",
					new JSONObject().put("income", annualBudget.getMonthlyBudget(id).getIncome().getEntryList())
							.put("expense", annualBudget.getMonthlyBudget(id).getExpense().getEntryList())
							.put("total", annualBudget.getMonthlyBudget(id).getTotal()));
			data.put(annualBudget.getMonthName(id), tmp);
		}

		File file;
		try {
			file = new File(chooseFile(2).toString());
			try (PrintWriter out = new PrintWriter(new FileWriter(file))) {
				out.write(data.toString());
				System.out.println("Datei wurde gespeichert.");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			System.out.println("Keine Datei ausgewählt.");
			MyAlerts.infoAlert(4);
		}
	}

	/**
	 * Imports data from a json-file and creates all necessary GUI-Elements.
	 * 
	 * @param annualBudget - data of all months
	 * 
	 * @return: true or false
	 */
	public static boolean importJSON(AnnualBudget annualBudget) {

		JSONObject jsonData = new JSONObject();

		File file;
		try {
			file = new File(chooseFile(1).toString());
		} catch (Exception e) {
			System.out.println("Keine Datei ausgewählt.");
			return false;
		}

		if (file.exists()) {
			try (FileReader reader = new FileReader(file)) {
				JSONTokener tokener = new JSONTokener(reader);
				jsonData = new JSONObject(tokener);

				try {
					for (MonthOfYear month : MonthOfYear.values()) {
						int id = month.getValue();
						String monthName = month.toString();
						JSONObject JSONmonthlyData = jsonData.getJSONObject(monthName);
						JSONObject mb = JSONmonthlyData.getJSONObject("monthlyBudget");
						double total = mb.getDouble("total");
 
						readEntryList(annualBudget.getMonthlyBudget(id),mb, "in", "income");
						readEntryList(annualBudget.getMonthlyBudget(id),mb, "exp", "expense");

						annualBudget.getMonthlyBudget(id).setTotal(total);
					}

				} catch (Exception e) {
					System.out.println("\nEinige Daten konnten nicht gelesen werden.");
				}
				return true;

			} catch (FileNotFoundException e) {
				System.out.println("Datei nicht gefunden.");
				e.printStackTrace();
				return false;
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		} else
			return false;
	}

	/**
	 * Reads Entries from the Income and Expense list. 
	 * 
	 * @param monthlyBudget - Object in which the data is stored.
	 * @param mb            - JSONObject which contains data of one month.
	 * @param type          - defines whether the data is from the income- or expense-list.
	 * @param name          - String, which defines whether income or expense data is loaded.
	 */
	public static void readEntryList(MonthlyBudget monthlyBudget, JSONObject mb, String type, String name) {
		JSONArray entryList = mb.getJSONArray(name);
		int length = entryList.length();
		if (length > 0) {
			double sum = 0;
			for (int i = 0; i < length; i++) {
				JSONObject jsonEntry = entryList.getJSONObject(i);
				Entry entry = new Entry();
				entry.setId(jsonEntry.getInt("id"));
				entry.setAmount(jsonEntry.optDouble("amount"));
				entry.setName(jsonEntry.getString("name"));
				entry.setFixed(jsonEntry.getBoolean("fixed"));
				if (type.equals("in"))
					monthlyBudget.addIncome(i, entry);
				if (type.equals("exp"))
					monthlyBudget.addExpense(i, entry);
				sum = sum + entry.getAmount();
			}
			if (type.equals("in"))
			monthlyBudget.getIncome().setSum(sum);
			if (type.equals("exp"))
			monthlyBudget.getExpense().setSum(sum);
		}
	}

	/**
	 * Opens a window to select/define the export/import-file
	 * 
	 * @param value
	 * @return
	 */
	public static File chooseFile(int value) {
		FileChooser fileChooser = new FileChooser();
		// only allow text files to be selected using chooser
		fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("JSON files (*.json)", "*.json"));
		// set initial directory somewhere user will recognise
		fileChooser.setInitialDirectory(new File(System.getProperty("user.dir")));

		// let user select file
		switch (value) {
		case 1:
			File fileToLoad = fileChooser.showOpenDialog(null);
			return fileToLoad;
		case 2:
			File fileToSave = fileChooser.showSaveDialog(null);
			return fileToSave;
		default:
			return null;
		}
	}
}
