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

public class CompExamController {

	public static Stage CompExam;

	public void start() {
		CompExam = new Stage();

		String title = "Computerized Exam";
		String srcFXML = "/Student/Computerized-Menu.fxml";

		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource(srcFXML));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			CompExam.setTitle(title);
			CompExam.setScene(scene);
			CompExam.setResizable(false);
			CompExam.show();

			CompExam.setOnCloseRequest(new EventHandler<WindowEvent>() {
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
			studentMenuController.hidefunc(CompExam);
			studentMenuController.StudentMenu.show();
		} catch (Exception e) {
			CompExam.close();
			System.out.println(e);
			e.printStackTrace();
		}
	}



}
