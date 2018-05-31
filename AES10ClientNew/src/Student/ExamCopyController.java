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

public class ExamCopyController {

	public static Stage ExamCopyStage;

	public void start() {
		ExamCopyStage = new Stage();

		String title = "Download Exam Copy";
		String srcFXML = "/Student/Student-ExamCopy.fxml";

		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource(srcFXML));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			ExamCopyStage.setTitle(title);
			ExamCopyStage.setScene(scene);
			ExamCopyStage.setResizable(false);
			ExamCopyStage.show();

			ExamCopyStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
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
			studentMenuController.hidefunc(ExamCopyStage);
			studentMenuController.StudentMenu.show();
		} catch (Exception e) {
			ExamCopyStage.close();
			System.out.println(e);
			e.printStackTrace();
		}
	}
}