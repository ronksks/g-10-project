package lecturer;

import Login.LoginController;
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

public class lecturerMenuController {

	/**
	 * current stage
	 */
	public static Stage lecturermenu;
	
	
	 /**
     * Contains login details
     */
    public static LoginController loginController;
    
	
	public void start(Stage primaryStage) throws Exception {
		this.lecturermenu = primaryStage;
		
		String title = "lecturer";
		String srcFXML = "/lecturer/Lecturer-menu.fxml";

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
	 
		public void BuildQuestion() {
			lecturermenu.hide();
			BuildQuestionController Buildq=new BuildQuestionController();
			Buildq.start();
		}
		
		public void BuildExam() {
			lecturermenu.hide();
			BuildExamController BuildExam=new BuildExamController();
			BuildExam.start();
		}
		
		public void Existing() {
			lecturermenu.hide();
			UseExistingController exist=new UseExistingController();
			exist.start();
		}
		
		public void executionCode() {
			lecturermenu.hide();
			ExecutionCodeController exec=new ExecutionCodeController();
			exec.start();
		}
		
		public void checkExam() {
			lecturermenu.hide();
			CheckExamController checkExam=new CheckExamController();
			checkExam.start();
		}
		
		public void reports() {
			lecturermenu.hide();
			reportsController reports=new reportsController();
			reports.start();
		}
		public void ExamTimeChange() {
			lecturermenu.hide();
			ExamTimeController ExamTime=new ExamTimeController();
			ExamTime.start();
		}
		
		public static void hidefunc(Stage s) {
			s.hide();
			return;
		}
		
		
		
		
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