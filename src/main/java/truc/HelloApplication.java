package truc;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    public static Font font;

    @Override
    public void start(Stage stage) {
        // Font used throughout the project
        font = Font.loadFont(String.valueOf((getClass().getResource("/font.otf"))), 20);

        // Prepares the final Pane with the final message
        Label finalLabel = new CustomLabel("Yes you are.");
        finalLabel.setAlignment(Pos.CENTER);
        finalLabel.setPrefSize(400, 250);
        Pane finalPane = new Pane(finalLabel);
        finalPane.setStyle("-fx-background-color: #333234");

        // Prepares the initial pane with the gif as the background
        ImageView image = new ImageView(new Image(String.valueOf(getClass().getResource("/gradient.GIF"))));
        image.setFitWidth(400);
        image.setFitHeight(250);
        Pane pane = new Pane(image);
        Scene scene = new Scene(pane, 400, 250);

        // Prepares the first VBox for the question label
        VBox box = new VBox(); // Using a VBox for easier centering
        box.setPrefSize(400, 250);
        box.setAlignment(Pos.CENTER);
        Label label = new CustomLabel("Are you stupid ?");
        label.setAlignment(Pos.CENTER);
        label.setPrefSize(400, 125);
        box.getChildren().add(label);

        // Prepares the Pane for the buttons (the yes and the no)
        Pane buttons = new Pane();
        buttons.setPrefSize(400, 125);
        buttons.setLayoutX(0);
        buttons.setLayoutY(125);

        // Prepares the button yes, and sets its action for when it's clicked
        Button yes = new CustomButton("Yes");
        yes.setLayoutY(30);
        yes.setLayoutX(65);
        yes.setOnAction(event -> scene.setRoot(finalPane));

        // Prepares the Pane for the No button
        Pane troll = new Pane();
        troll.setPrefSize(200, 125);
        troll.setLayoutX(200);
        troll.setLayoutY(0);
        Button no = new CustomButton("No");
        no.setLayoutY(30);
        no.setLayoutX(65);
        no.setOnAction(event -> {
            no.setLayoutX(Math.random() * 135); // Randomly changes the x-coordinate using Math.random()
            no.setLayoutY(Math.random() * 85); // Randomly changes the y-coordinate using Math.random()
        });
        troll.getChildren().add(no);

        // Adds everyone to the right parent
        buttons.getChildren().addAll(yes, troll);
        box.getChildren().add(buttons);
        pane.getChildren().add(box);

        // Displays everyone
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    // Custom Label for the whole project, using the custom Font and a default color
    public static class CustomLabel extends Label{
        public CustomLabel(String s) {
            super(s);
            this.setFont(font);
            this.setStyle("-fx-text-fill: E7EBEE;");
        }
    }

    // Custom Button for the whole project, using the custom Font and a default color again
    public static class CustomButton extends Button {
        public CustomButton(String s) {
            super(s);
            this.setPrefSize(65, 40);
            this.setFont(font);
            this.setStyle("-fx-text-fill: E7EBEE;" + "-fx-background-color: #333234;");
        }
    }
}

