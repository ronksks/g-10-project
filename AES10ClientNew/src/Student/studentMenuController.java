package Student;

import java.awt.Button;
import javafx.event.ActionEvent;

import com.sun.prism.paint.Color;

import Login.LoginApp;
import Login.LoginController;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class studentMenuController {

   
	/**
	 * current stage
	 */
	public static Stage StudentMenu;

	/**
	 * Contains login details
	 */
	public static LoginController loginController;

	public void start(Stage primaryStage) throws Exception {
		this.StudentMenu = primaryStage;

		String title = "student";
		String srcFXML = "/Student/Student-menu.fxml";

		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource(srcFXML));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			primaryStage.setTitle(title);
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();

			primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
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

	public void setLoginController(LoginController login) {
		loginController = login;
	}
	
	public void compExam() {
		StudentMenu.hide();
		CompExamController CompExam=new CompExamController();
		CompExam.start();
	}
	
	public void manExam() {
		StudentMenu.hide();
		ManExamController manExam=new ManExamController();
		manExam.start();
	}
	
	public void checkgrade() {
		StudentMenu.hide();
		CheckGradeController CheckGrade=new CheckGradeController();
		CheckGrade.start();
	}
	public void getExamCopy() {
		StudentMenu.hide();
		ExamCopyController examCopy=new ExamCopyController();
		examCopy.start();
	}
	public static void hidefunc(Stage s) {
		s.hide();
		return;
	}

	
	/**
	 * Event Logged out that occurs when clicking on logout
	 */
	public void performLoggedOutHandler()
	{
		Alert alert = new Alert(Alert.AlertType.WARNING);
		alert.setTitle("Logged Out");
		alert.setContentText("Are you Sure?");
		ButtonType okButton = new ButtonType("Yes", ButtonData.YES);
		ButtonType noButton = new ButtonType("No", ButtonData.NO);
		
		alert.getButtonTypes().setAll(okButton, noButton);
		alert.showAndWait().ifPresent(type -> {
		        if (type == okButton)
		        {
		        	loginController.performLoggedOut(LoginController.userLogged);
		       
		        } 
		});
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
