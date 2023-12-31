package application;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * Contains info- and error-Alerts
 * 
 * @author katharina
 *
 */
public class MyAlerts {

	public static void errorAlert(int code) {

		switch (code) {
		case 1:
			Alert alert1 = new Alert(AlertType.ERROR);
			alert1.setTitle("Fehlermeldung");
			alert1.setHeaderText("Befehl konnte nicht ausgeführt werden.");
			alert1.setContentText("Datei nicht gefunden.");
			alert1.showAndWait();
			break;

		case 2:
			Alert alert2 = new Alert(AlertType.ERROR);
			alert2.setTitle("Fehlermeldung");
			alert2.setHeaderText("Keine gültige Angabe.");
			alert2.setContentText("Bitte nur Zahlen eingeben.");
			alert2.showAndWait();
			break;

		default:
		}
	}

	public static void infoAlert(int code) {

		switch (code) {
		case 1:
			Alert alert1 = new Alert(AlertType.INFORMATION);
			alert1.setTitle("Hinweis");
			alert1.setHeaderText("Befehl konnte nicht ausgeführt werden.");
			alert1.setContentText(
					"Es gibt bereits Daten. Es können daher keine neuen eingelesen werden. Lösche zuerst die vorhandenen Daten.");
			alert1.showAndWait();
			break;

		case 2:
			Alert alert2 = new Alert(AlertType.INFORMATION);
			alert2.setTitle("Hinweis");
			alert2.setHeaderText("Kein Text vorhanden.");
			alert2.setContentText("Bitte gebe eine Bezeichnung für den neuen Eintrag ein.");
			alert2.showAndWait();
			break;
		case 3:
			Alert alert3 = new Alert(AlertType.INFORMATION);
			alert3.setTitle("Hinweis");
			alert3.setHeaderText("Keine neue Zeile mehr eingefügt.");
			alert3.setContentText("Die maximale Anzahl von Zeilen wurde erreicht.");
			alert3.showAndWait();
			break;
		case 4:
			Alert alert4 = new Alert(AlertType.INFORMATION);
			alert4.setTitle("Hinweis");
			alert4.setHeaderText("Datei wurde nicht gespeichert.");
			alert4.setContentText("Keinen Dateinamen zum Speichern gefunden.");
			alert4.showAndWait();
			break;
		case 5:
			Alert alert5 = new Alert(AlertType.INFORMATION);
			alert5.setTitle("Hinweis");
			alert5.setHeaderText("hiermit werden die Daten aller Monate gelöscht.");
			alert5.setContentText("Keinen Dateinamen zum Speichern gefunden.");
			alert5.showAndWait();
			break;

		default:
		}
	}
}
