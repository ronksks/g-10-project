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

public class ManExamController  {
public static Stage ManExam;
	public void start() {
		ManExam = new Stage();

		String title = "Manual Exam";
		String srcFXML = "/Student/Manual-Exam-Menu.fxml";

		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource(srcFXML));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			ManExam.setTitle(title);
			ManExam.setScene(scene);
			ManExam.setResizable(false);
			ManExam.show();

			ManExam.setOnCloseRequest(new EventHandler<WindowEvent>() {
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
			studentMenuController.hidefunc(ManExam);
			studentMenuController.StudentMenu.show();
		} catch (Exception e) {
			ManExam.close();
			System.out.println(e);
			e.printStackTrace();
		}
	}

}

