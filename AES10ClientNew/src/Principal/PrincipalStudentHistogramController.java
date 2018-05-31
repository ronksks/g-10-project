package Principal;


import Login.LoginController;
import Student.ExamCopyController;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class PrincipalStudentHistogramController {

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
		
		String title = "Student Histogram";
		String srcFXML = "/Principal/principal-student-histogram.fxml";

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
		
	/*	public void StudentHistogram() {
			mainStage.close();
			PrincipalStudentHistogramController StudentHistogram=new PrincipalStudentHistogramController();
			StudentHistogram.start();
		}*/
	    
}