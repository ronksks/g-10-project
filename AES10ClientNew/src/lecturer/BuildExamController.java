package lecturer;


import java.awt.Button;
import java.awt.TextField;

import Student.studentMenuController;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class BuildExamController  {
public static Stage buildexamstage;
		
	public void start() {
		buildexamstage = new Stage();

		String title = "Build Exam";
		String srcFXML = "/Lecturer/Lecturer-Build-Exam.fxml";

		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource(srcFXML));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			buildexamstage.setTitle(title);
			buildexamstage.setScene(scene);
			buildexamstage.setResizable(false);
			buildexamstage.show();

			buildexamstage.setOnCloseRequest(new EventHandler<WindowEvent>() {
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
			lecturerMenuController.hidefunc(buildexamstage);
			lecturerMenuController.lecturermenu.show();
		} catch (Exception e) {
			buildexamstage.close();
			System.out.println(e);
			e.printStackTrace();
		}
	}
	
	
	
	
	
}


