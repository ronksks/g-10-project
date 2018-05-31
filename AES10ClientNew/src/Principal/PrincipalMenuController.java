package Principal;

import Login.LoginController;
import Student.ExamCopyController;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class PrincipalMenuController {

	/**
	 * current stage
	 */
	private static Stage mainStage;
	
	
	 /**
     * Contains login details
     */
    private static LoginController loginController;
    
	
	public void start(Stage primaryStage) throws Exception {
		this.mainStage = primaryStage;
		
		String title = "principal";
		String srcFXML = "/Principal/principal-menu.fxml";

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
	
	
	 public void setLoginController(LoginController login)
	    {
	    	loginController = login;
	    }
	 
		public void GetReports() {
			mainStage.close();
			GetReportsController getReports=new GetReportsController();
			getReports.start();
		}
		public void Approval() {
			mainStage.close();
			PrincipalExtensionController approval=new PrincipalExtensionController();
			approval.start();
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