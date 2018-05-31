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

public class ExecutionCodeController  {
public static Stage executioncodestage;
		
	public void start() {
		executioncodestage = new Stage();

		String title = "Execution Code";
		String srcFXML = "/Lecturer/Lecturer-Execution-Code.fxml";

		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource(srcFXML));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			executioncodestage.setTitle(title);
			executioncodestage.setScene(scene);
			executioncodestage.setResizable(false);
			executioncodestage.show();

			executioncodestage.setOnCloseRequest(new EventHandler<WindowEvent>() {
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
			lecturerMenuController.hidefunc(executioncodestage);
			lecturerMenuController.lecturermenu.show();
		} catch (Exception e) {
			executioncodestage.close();
			System.out.println(e);
			e.printStackTrace();
		}
	}
	
	
	
	
}


