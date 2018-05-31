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

public class UseExistingController  {
public static Stage useexistingstage;
		
	public void start() {
		useexistingstage = new Stage();

		String title = "Use Existing Exam";
		String srcFXML = "/Lecturer/Lecturer-Use-Existing-Exam.fxml";

		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource(srcFXML));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			useexistingstage.setTitle(title);
			useexistingstage.setScene(scene);
			useexistingstage.setResizable(false);
			useexistingstage.show();

			useexistingstage.setOnCloseRequest(new EventHandler<WindowEvent>() {
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
			lecturerMenuController.hidefunc(useexistingstage);
			lecturerMenuController.lecturermenu.show();
		} catch (Exception e) {
			useexistingstage.close();
			System.out.println(e);
			e.printStackTrace();
		}
	}
		
	
}


