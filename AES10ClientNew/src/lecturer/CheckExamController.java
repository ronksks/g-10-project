package lecturer;


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

public class CheckExamController  {
public static Stage checkexamstage;
		
	public void start() {
		checkexamstage = new Stage();

		String title = "Check Exam";
		String srcFXML = "/Lecturer/Lecturer-Check-Exam.fxml";

		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource(srcFXML));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			checkexamstage.setTitle(title);
			checkexamstage.setScene(scene);
			checkexamstage.setResizable(false);
			checkexamstage.show();

			checkexamstage.setOnCloseRequest(new EventHandler<WindowEvent>() {
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
			lecturerMenuController.hidefunc(checkexamstage);
			lecturerMenuController.lecturermenu.show();
		} catch (Exception e) {
			checkexamstage.close();
			System.out.println(e);
			e.printStackTrace();
		}
	}
		
	
}


