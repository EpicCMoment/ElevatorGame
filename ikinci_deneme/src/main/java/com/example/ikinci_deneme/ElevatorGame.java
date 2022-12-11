package com.example.ikinci_deneme;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class ElevatorGame extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage window) {

        Elevator elevator = new Elevator(4, 0, 5);

        double betweenFloorSpace = 127;

        Pane p = new Pane();

        TextField message = new TextField();
        message.setEditable(false);
        message.setLayoutY(200);
        message.setLayoutX(450);

        // Image of the building and all the adjustments
        ImageView buildingImage = new ImageView("C:\\Users\\Rudrik\\IdeaProjects\\ikinci_deneme\\src\\main\\java\\com\\example\\ikinci_deneme\\building.png");
        buildingImage.setFitWidth(400);
        buildingImage.setFitHeight(800);
        buildingImage.setLayoutX(20);

        // elevator image which moves
        ImageView elevatorImage = new ImageView("C:\\Users\\Rudrik\\IdeaProjects\\ikinci_deneme\\src\\main\\java\\com\\example\\ikinci_deneme\\elevator.png");
        elevatorImage.setFitHeight(100);
        elevatorImage.setFitWidth(100);
        elevatorImage.setLayoutX(173);
        elevatorImage.setLayoutY(700);

        // textfield that shows the available person in the elevator to get out
        TextField lastPersonText = new TextField();
        lastPersonText.setAlignment(Pos.CENTER);
        lastPersonText.setMaxWidth(90);
        lastPersonText.setMinWidth(90);
        lastPersonText.setEditable(false);
        lastPersonText.setLayoutX(462);
        lastPersonText.setLayoutY(350);

        // textfield that shows current floor elevator is sitting at
        TextField currentFloorText = new TextField();
        currentFloorText.setAlignment(Pos.CENTER);
        currentFloorText.setText("0");
        currentFloorText.setMaxWidth(90);
        currentFloorText.setMinWidth(90);
        currentFloorText.setEditable(false);
        currentFloorText.setLayoutX(lastPersonText.getLayoutX());
        currentFloorText.setLayoutY(lastPersonText.getLayoutY() + 30);

        // textfield that shows current floor elevator is sitting at
        TextField personNameText = new TextField();
        personNameText.setAlignment(Pos.CENTER);
        personNameText.setMaxWidth(90);
        personNameText.setMinWidth(90);
        personNameText.setEditable(false);
        personNameText.setLayoutX(lastPersonText.getLayoutX());
        personNameText.setLayoutY(currentFloorText.getLayoutY() + 30);

        ImageView upArrow = new ImageView("C:\\Users\\Rudrik\\IdeaProjects\\ikinci_deneme\\src\\main\\java\\com\\example\\ikinci_deneme\\up_arrow.png");
        upArrow.setFitWidth(30);
        upArrow.setFitHeight(30);

        // up button
        Button upButton = new Button();
        upButton.setGraphic(upArrow);
        upButton.setLayoutX(personNameText.getLayoutX() + 20);
        upButton.setLayoutY(personNameText.getLayoutY() + 40);

        upButton.setOnAction((e) -> {
            if (elevator.getCurrentFloor() != elevator.getMaxFloor()) {
                elevatorImage.setLayoutY(elevatorImage.getLayoutY() - betweenFloorSpace);

                //Person pp = (Person)(elevator.getPeople().peek());
                //String lastPersonName = pp.getName();

                String lastPersonName;
                if (!elevator.getPeople().isEmpty()) {
                    ElevatorPerson ep = (ElevatorPerson)elevator.getPeople().peek();
                    lastPersonName = ep.getPerson().getName();
                } else {
                    lastPersonName = "";
                }

                int beforeCapacity = elevator.getPeople().getSize();
                elevator.goToFloor(elevator.getCurrentFloor() + 1);
                int afterCapacity = elevator.getPeople().getSize();

                if (afterCapacity != beforeCapacity) {
                    message.setText(lastPersonName + " is fucked off.");
                }

                currentFloorText.setText(Integer.toString(elevator.getCurrentFloor()));
            }

        });


        ImageView downArrow = new ImageView("C:\\Users\\Rudrik\\IdeaProjects\\ikinci_deneme\\src\\main\\java\\com\\example\\ikinci_deneme\\down_arrow.png");
        downArrow.setFitWidth(30);
        downArrow.setFitHeight(30);

        // down button
        Button downButton = new Button();
        downButton.setGraphic(downArrow);
        downButton.setLayoutX(upButton.getLayoutX());
        downButton.setLayoutY(upButton.getLayoutY() + 40);

        downButton.setOnAction((e) -> {
            if (elevator.getCurrentFloor() != elevator.getMinFloor()) {
                elevatorImage.setLayoutY(elevatorImage.getLayoutY() + betweenFloorSpace);



                String lastPersonName;
                if (!elevator.getPeople().isEmpty()) {
                    ElevatorPerson ep = (ElevatorPerson)elevator.getPeople().peek();
                    lastPersonName = ep.getPerson().getName();
                } else {
                    lastPersonName = "";
                }

                int beforeCapacity = elevator.getPeople().getSize();
                elevator.goToFloor(elevator.getCurrentFloor() - 1);
                int afterCapacity = elevator.getPeople().getSize();

                if (afterCapacity != beforeCapacity) {
                    message.setText(lastPersonName + " is fucked off.");
                }

                currentFloorText.setText(Integer.toString(elevator.getCurrentFloor()));

            }

        });



        // text field to get the new person's name
        TextField newPersonNameText = new TextField();
        newPersonNameText.setPromptText("Name");
        newPersonNameText.setLayoutX(680);
        newPersonNameText.setLayoutY(100);

        // text field to get the target floor of the new person
        TextField newPersonTargetText = new TextField();
        newPersonTargetText.setPromptText("Target Floor");
        newPersonTargetText.setLayoutX(newPersonNameText.getLayoutX());
        newPersonTargetText.setLayoutY(newPersonNameText.getLayoutY() + 30);

        // add the new person button
        Button addNewPersonButton = new Button("Add");
        addNewPersonButton.setLayoutX(680);
        addNewPersonButton.setLayoutY(newPersonTargetText.getLayoutY() + 30);
        addNewPersonButton.setPrefWidth(147);

        addNewPersonButton.setOnAction((e) -> {

            String personName = newPersonNameText.getText();
            int personTarget = Integer.parseInt(newPersonTargetText.getText());
            Person temp = new Person(personName);

            if (elevator.getPeople().isEmpty()) {
                elevator.enter(temp, personTarget);
                personNameText.setText(personName);
            } else {
                if (elevator.getPeople().getSize() == elevator.getCapacity()) {
                    message.setText("Elevator is full.");
                } else {
                    elevator.enter(temp, personTarget);
                }

            }

            newPersonNameText.setText("");
            newPersonTargetText.setText("");

        });


        p.getChildren().add(buildingImage);
        p.getChildren().add(lastPersonText);
        p.getChildren().add(currentFloorText);
        p.getChildren().add(upButton);
        p.getChildren().add(downButton);
        p.getChildren().add(elevatorImage);
        p.getChildren().add(newPersonNameText);
        p.getChildren().add(newPersonTargetText);
        p.getChildren().add(addNewPersonButton);
        p.getChildren().add(personNameText);
        p.getChildren().add(message);

        // kind of main window controls :S
        Scene sc = new Scene(p, 1000, 850);


        window.setResizable(false);
        window.getIcons().add(new Image("C:\\Users\\Rudrik\\IdeaProjects\\ikinci_deneme\\src\\main\\java\\com\\example\\ikinci_deneme\\icon.png"));

        window.setScene(sc);

        window.show();


    }

}
