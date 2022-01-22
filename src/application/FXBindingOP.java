package application;
	
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class FXBindingOP extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			VBox root = new VBox();
			root.setAlignment(Pos.CENTER);
			
			Label lb1 = new Label();
			lb1.textProperty().bind(primaryStage.widthProperty()
					.asString()
					.concat(" : ")
					.concat(primaryStage.heightProperty())
			);
			
			Label lb2 = new Label();
			lb2.textProperty().bind(Bindings.min(primaryStage.widthProperty(), primaryStage.heightProperty())
					.divide(10)
					.asString()
			);
			
			Label lb3 = new Label();
			lb3.textProperty().bind(Bindings
					.when(primaryStage.widthProperty().lessThan(primaryStage.heightProperty()))
					.then(primaryStage.widthProperty())
					.otherwise(primaryStage.heightProperty())
					.asString()
			);
			
			root.getChildren().addAll(lb1, lb2, lb3);
			
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
