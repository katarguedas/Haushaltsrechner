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
import data.EntryList;
import data.MonthOfYear;
import data.MonthlyBudget;
import javafx.stage.FileChooser;

public abstract class JSON_IO {

	public static void exportJSON(AnnualBudget annualBudget) {

		JSONObject data = new JSONObject();
		for (MonthOfYear month : MonthOfYear.values()) {
			int id = month.getValue();

			JSONObject tmp = new JSONObject().put("monthlyBudget",
					new JSONObject().put("income", annualBudget.getMonthlyBudget(id).getIncome().getEntryList() )
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

				// importieren
				try {
					for (MonthOfYear month : MonthOfYear.values()) {
						int id = month.getValue();
						String monthName = month.toString();
						JSONObject JSONmonthlyData = jsonData.getJSONObject(monthName);
						JSONObject mb = JSONmonthlyData.getJSONObject("monthlyBudget");
						double total = mb.getDouble("total");
						JSONArray income = mb.getJSONArray("income");
						int inLength = income.length();
						if (inLength > 0) {
							double inSum = 0;
							for (int i = 0; i < inLength; i++) {
								JSONObject jsonEntry = income.getJSONObject(i);
								Entry entry = new Entry();
								
								entry.setAmount(jsonEntry.optDouble("amount"));
								entry.setName(jsonEntry.getString("name"));
								entry.setFixed(jsonEntry.getBoolean("fixed"));
								annualBudget.getMonthlyBudget(id).addIncome(i, entry);
								inSum = inSum + entry.getAmount();
							}
							annualBudget.getMonthlyBudget(id).getIncome().setSum(inSum);
						}
						
						JSONArray expense = mb.getJSONArray("expense");
						int expLength = expense.length();
						if (expLength > 0) {
							double expSum = 0;
							for (int i = 0; i < expLength; i++) {
								JSONObject jsonEntry = expense.getJSONObject(i);
								Entry entry = new Entry();
								entry.setAmount(jsonEntry.getDouble("amount"));
								entry.setName(jsonEntry.getString("name"));
								entry.setFixed(jsonEntry.getBoolean("fixed"));
								annualBudget.getMonthlyBudget(id).addExpense(i, entry);
								expSum = expSum + entry.getAmount();
							}
							annualBudget.getMonthlyBudget(id).getExpense().setSum(expSum);
						}				
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
