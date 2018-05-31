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

public class reportsController  {
public static Stage reportstage;
		
	public void start() {
		reportstage = new Stage();

		String title = "Reports";
		String srcFXML = "/Lecturer/Lecturer-Report.fxml";

		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource(srcFXML));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			reportstage.setTitle(title);
			reportstage.setScene(scene);
			reportstage.setResizable(false);
			reportstage.show();

			reportstage.setOnCloseRequest(new EventHandler<WindowEvent>() {
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
			lecturerMenuController.hidefunc(reportstage);
			lecturerMenuController.lecturermenu.show();
		} catch (Exception e) {
			reportstage.close();
			System.out.println(e);
			e.printStackTrace();
		}
	}
	
	
}


