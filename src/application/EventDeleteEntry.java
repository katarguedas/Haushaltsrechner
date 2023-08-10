package application;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.scene.layout.GridPane;

public class EventDeleteEntry {

	ActionEvent event = new ActionEvent();

	public ActionEvent getEvent() {
		return this.event;
	}

//	(e, id, type, grid, sum, total)
	public void getHandle(ActionEvent event,int id,String type,GridPane grid, ArrayList<EntryElements> elemList ) {
		deleteEntry(event,id, type, grid, elemList);
	}

	void deleteEntry(ActionEvent event, int id, String type, GridPane grid, ArrayList<EntryElements> elemList) {
		
		int hashcode = event.getSource().hashCode();

		int index = Helper.findIndex(elemList, hashcode, "btn");
		
		grid.getChildren().removeAll((elemList.get(index).amountTF.getTextField()));
		grid.getChildren().removeAll((elemList.get(index).btn.getBtn()));
		grid.getChildren().removeAll((elemList.get(index).checkbox.getCheckbox()));
		grid.getChildren().removeAll((elemList.get(index).label.getLabel()));
		
		System.out.println("elemList: " + elemList.get(0));
		try {
		System.out.println("elemList: " + elemList.get(1));
		} catch (Exception e) {
			// TODO: handle exception
		}
	
//		einamal gridElemente löschen und dann die Elemente in der ArrayList
		
//		forEach(element : elemList.get(index)){
////			grid.getChildren().removeAll(elementList.get(0))
//		}
		
//		if (type.equals("Exp")) {
//			removeItem(grid, inputExp.get(id - 1), oneYearB.getYearsBudget(id).getExpense(), sumExpenses,
//					hashcode);
//			counterExp[id - 1] -= 1;
//		}
//		if (type.equals("Rev")) {
//			removeItem(grid, inputRev.get(id - 1), oneYearB.getYearsBudget(id).getRevenue(), sumExpenses,
//					hashcode);
//			counterRev[id - 1] -= 1;
//		}
//
//		calcTotal(event, total, id);
	}

//	void removeItem(GridPane grid, InputList input, ItemGroup itemgroup, TextField groupTotal, int hashcode) {
//
//		int index = findIndex(input, hashcode, "btn");
//
//		if (index != 999) {
//			int id = input.getInputElement(index).id;
//			grid.getChildren().removeAll(input.getInputElement(index).btn);
//			grid.getChildren().removeAll(input.getInputElement(index).label);
//			grid.getChildren().removeAll(input.getInputElement(index).checkbox);
//			grid.getChildren().removeAll(input.getInputElement(index).amountTF);
//
//			// Lösche Item aus 'MonatsBudget':
//			itemgroup.getItemGroup().remove(id);
//
//			// Aktualisiere die Summe der Ausgaben:
//			itemgroup.updateTotal();
//
//			// Schreibe die neue RevenueSumme ins TextField:
//			groupTotal.setText(Double.toString(itemgroup.getTotal()));
//		}
//	}

}
