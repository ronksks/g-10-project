package lecturer;




import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class BuildQuestionController  {
public static Stage buildquestionstage;
		
	public void start() {
		buildquestionstage = new Stage();

		String title = "Build Question";
		String srcFXML = "/Lecturer/Lecturer-Build-Question.fxml";

		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource(srcFXML));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			buildquestionstage.setTitle(title);
			buildquestionstage.setScene(scene);
			buildquestionstage.setResizable(false);
			buildquestionstage.show();

			buildquestionstage.setOnCloseRequest(new EventHandler<WindowEvent>() {
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
			lecturerMenuController.hidefunc(buildquestionstage);
			lecturerMenuController.lecturermenu.show();
		} catch (Exception e) {
			buildquestionstage.close();
			System.out.println(e);
			e.printStackTrace();
		}
	}
	
	
}


