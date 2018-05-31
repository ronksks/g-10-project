package Student;

import java.awt.Button;
import java.awt.TextField;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class CheckGradeController {
	public static Stage CheckGrade;

	public void start() {
		CheckGrade = new Stage();

		String title = "Grades";
		String srcFXML = "/Student/Student-Grades.fxml";

		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource(srcFXML));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			CheckGrade.setTitle(title);
			CheckGrade.setScene(scene);
			CheckGrade.setResizable(false);
			CheckGrade.show();

			CheckGrade.setOnCloseRequest(new EventHandler<WindowEvent>() {
				public void handle(WindowEvent we) {
					Platform.exit();
				}
			});
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			e.printStackTrace();
		}

	}
	
	public void back() {

		try {
			studentMenuController.hidefunc(CheckGrade);
			studentMenuController.StudentMenu.show();
		} catch (Exception e) {
			CheckGrade.close();
			System.out.println(e);
			e.printStackTrace();
		}
	}
}