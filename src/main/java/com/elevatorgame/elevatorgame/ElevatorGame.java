package com.elevatorgame.elevatorgame;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class ElevatorGame extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage mainWindow) {

        /*
        For every couple function;
        1-) Set the image
        2-) Set the actual object

        Correct usage:
            setElevatorImage();
            setElevator();

        Incorrect usage:
            setElevator();
            setElevatorImage();
         */

        // don't change the order of the function calls below
        // if you are NOT SURE about what are you doing

        setBuildingImage();

        setElevatorImage();
        setElevator();

        setInformationMessageText();

        setLastPersonInTheElevatorText();

        setCurrentFloorText();

        setPersonNameText();

        setElevatorUpButtonImage();
        setElevatorUpButton();

        setElevatorDownButtonImage();
        setElevatorDownButton();

        setNewPersonNameText();
        setNewPersonTargetText();
        setAddNewPersonButton();


        setMainBackground();
        setMainLayout();
        setMainWindow(mainWindow);

        mainWindow.show();


    }

    Elevator elevator;
    Pane mainBackground;
    TextField informationMessageText;
    ImageView buildingImage;
    ImageView elevatorImage;
    TextField lastPersonInTheElevatorText;
    TextField currentFloorText;
    TextField personNameText;
    ImageView elevatorUpButtonImage;
    Button elevatorUpButton;
    ImageView elevatorDownButtonImage;
    Button elevatorDownButton;
    TextField newPersonNameText;
    TextField newPersonTargetText;
    Button addNewPersonButton;
    Scene mainLayout;

    double betweenFloorSpace = 128;

    public void setElevator() {
        elevator = new Elevator(4, 0, 5);
    }

    public void setInformationMessageText() {
        informationMessageText = new TextField();
        informationMessageText.setEditable(false);
        informationMessageText.setLayoutX(460);
        informationMessageText.setLayoutY(265);
        informationMessageText.setMaxWidth(210);
        informationMessageText.setMinWidth(210);
    }

    public void setBuildingImage() {
        String imagePath = "https://raw.githubusercontent.com/EpicCMoment/ElevatorGame/main/ikinci_deneme/src/main/java/com/example/ikinci_deneme/building.png";
        buildingImage = new ImageView(imagePath);
        buildingImage.setFitWidth(400);
        buildingImage.setFitHeight(800);
        buildingImage.setLayoutX(20);
    }

    public void setElevatorImage() {
        String imagePath = "https://raw.githubusercontent.com/EpicCMoment/ElevatorGame/main/ikinci_deneme/src/main/java/com/example/ikinci_deneme/elevator.png";
        elevatorImage = new ImageView(imagePath);
        elevatorImage.setFitHeight(100);
        elevatorImage.setFitWidth(100);
        elevatorImage.setLayoutX(173);
        elevatorImage.setLayoutY(700);
    }

    public void setLastPersonInTheElevatorText() {
        lastPersonInTheElevatorText = new TextField();
        lastPersonInTheElevatorText.setAlignment(Pos.CENTER);
        lastPersonInTheElevatorText.setMaxWidth(90);
        lastPersonInTheElevatorText.setMinWidth(90);
        lastPersonInTheElevatorText.setEditable(false);
        lastPersonInTheElevatorText.setLayoutX(informationMessageText.getLayoutX() + 120);
        lastPersonInTheElevatorText.setLayoutY(informationMessageText.getLayoutY() + 60);
    }

    public void setCurrentFloorText() {
        currentFloorText = new TextField();
        currentFloorText.setAlignment(Pos.CENTER);
        currentFloorText.setText("0");
        currentFloorText.setMaxWidth(25);
        currentFloorText.setMinWidth(25);
        currentFloorText.setMaxHeight(25);
        currentFloorText.setMinHeight(25);
        currentFloorText.setEditable(false);
        currentFloorText.setLayoutX(elevatorImage.getLayoutX() + 38);
        currentFloorText.setLayoutY(elevatorImage.getLayoutY() + 5);
    }

    public void setPersonNameText() {
        personNameText = new TextField();
        personNameText.setAlignment(Pos.CENTER);
        personNameText.setMaxWidth(90);
        personNameText.setMinWidth(90);
        personNameText.setEditable(false);
        personNameText.setLayoutX(lastPersonInTheElevatorText.getLayoutX());
        personNameText.setLayoutY(lastPersonInTheElevatorText.getLayoutY() + 30);
    }

    public void setElevatorUpButtonImage() {
        String imagePath = "https://raw.githubusercontent.com/EpicCMoment/ElevatorGame/main/ikinci_deneme/src/main/java/com/example/ikinci_deneme/up_arrow.png";
        elevatorUpButtonImage = new ImageView(imagePath);
        elevatorUpButtonImage.setFitWidth(30);
        elevatorUpButtonImage.setFitHeight(30);
    }

    public void setElevatorUpButton() {
        elevatorUpButton = new Button();
        elevatorUpButton.setGraphic(elevatorUpButtonImage);
        elevatorUpButton.setLayoutX(informationMessageText.getLayoutX());
        elevatorUpButton.setLayoutY(informationMessageText.getLayoutY() + 50);

        elevatorUpButton.setOnAction((e) -> {
            if (elevator.getCurrentFloor() != elevator.getMaxFloor()) {
                elevatorImage.setLayoutY(elevatorImage.getLayoutY() - betweenFloorSpace);
                currentFloorText.setLayoutY(currentFloorText.getLayoutY() - betweenFloorSpace);


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
                    informationMessageText.setText(lastPersonName + " is fucked off.");
                }

                currentFloorText.setText(Integer.toString(elevator.getCurrentFloor()));
            }

        });
    }

    public void setElevatorDownButtonImage() {
        String imagePath = "https://raw.githubusercontent.com/EpicCMoment/ElevatorGame/main/ikinci_deneme/src/main/java/com/example/ikinci_deneme/down_arrow.png";
        elevatorDownButtonImage = new ImageView(imagePath);
        elevatorDownButtonImage.setFitWidth(30);
        elevatorDownButtonImage.setFitHeight(30);
    }

    public void setElevatorDownButton() {
        elevatorDownButton = new Button();
        elevatorDownButton.setGraphic(elevatorDownButtonImage);
        elevatorDownButton.setLayoutX(elevatorUpButton.getLayoutX());
        elevatorDownButton.setLayoutY(elevatorUpButton.getLayoutY() + 45);

        elevatorDownButton.setOnAction((e) -> {
            if (elevator.getCurrentFloor() != elevator.getMinFloor()) {
                elevatorImage.setLayoutY(elevatorImage.getLayoutY() + betweenFloorSpace);
                currentFloorText.setLayoutY(currentFloorText.getLayoutY() + betweenFloorSpace);


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
                    informationMessageText.setText(lastPersonName + " is fucked off.");
                }

                currentFloorText.setText(Integer.toString(elevator.getCurrentFloor()));

            }

        });
    }

    public void setNewPersonNameText() {
        newPersonNameText = new TextField();
        newPersonNameText.setPromptText("Name");
        newPersonNameText.setLayoutX(490);
        newPersonNameText.setLayoutY(475);
    }

    public void setNewPersonTargetText() {
        newPersonTargetText = new TextField();
        newPersonTargetText.setPromptText("Target Floor");
        newPersonTargetText.setLayoutX(newPersonNameText.getLayoutX());
        newPersonTargetText.setLayoutY(newPersonNameText.getLayoutY() + 30);
    }

    public void setAddNewPersonButton() {
        addNewPersonButton = new Button("Add");
        addNewPersonButton.setLayoutX(newPersonNameText.getLayoutX());
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
                    informationMessageText.setText("Elevator is full.");
                } else {
                    elevator.enter(temp, personTarget);
                }

            }

            newPersonNameText.setText("");
            newPersonTargetText.setText("");

        });
    }

    public void setMainBackground() {
        mainBackground = new Pane();
        mainBackground.getChildren().add(buildingImage);
        mainBackground.getChildren().add(lastPersonInTheElevatorText);
        mainBackground.getChildren().add(currentFloorText);
        mainBackground.getChildren().add(elevatorUpButton);
        mainBackground.getChildren().add(elevatorDownButton);
        mainBackground.getChildren().add(elevatorImage);
        mainBackground.getChildren().add(newPersonNameText);
        mainBackground.getChildren().add(newPersonTargetText);
        mainBackground.getChildren().add(addNewPersonButton);
        mainBackground.getChildren().add(personNameText);
        mainBackground.getChildren().add(informationMessageText);
    }

    public void setMainLayout() {
        mainLayout = new Scene(mainBackground, 700, 850);
    }

    public void setMainWindow(Stage mainWindow) {

        String iconURL = "https://raw.githubusercontent.com/EpicCMoment/ElevatorGame/main/ikinci_deneme/src/main/java/com/example/ikinci_deneme/icon.png";

        mainWindow.setResizable(false);
        mainWindow.getIcons().add(new Image(iconURL));

        mainWindow.setScene(mainLayout);
    }


}
