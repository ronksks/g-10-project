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

public class ExamTimeController  {
public  static Stage changetimestage;
		
	public void start() {
		changetimestage = new Stage();

		String title = "Exam Time Change And Lock ";
		String srcFXML = "/Lecturer/Lecturer-Change-Time-Lock.fxml";

		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource(srcFXML));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			changetimestage.setTitle(title);
			changetimestage.setScene(scene);
			changetimestage.setResizable(false);
			changetimestage.show();

			changetimestage.setOnCloseRequest(new EventHandler<WindowEvent>() {
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
			lecturerMenuController.hidefunc(changetimestage);
			lecturerMenuController.lecturermenu.show();
		} catch (Exception e) {
			changetimestage.close();
			System.out.println(e);
			e.printStackTrace();
		}
	}
}


