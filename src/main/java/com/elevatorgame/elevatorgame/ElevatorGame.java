package com.elevatorgame.elevatorgame;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
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

        setElevatorControlsLabel();

        setInformationMessageLabel();
        setInformationMessageArea();

        setElevatorUpButtonImage();
        setElevatorUpButton();

        setLastPersonInTheElevatorLabel();
        setLastPersonInTheElevatorText();

        setLastPersonTargetLabel();

        setCurrentFloorText();

        setLastPersonTargetText();

        setElevatorStatusLabel();




        setElevatorDownButtonImage();
        setElevatorDownButton();

        setNewPersonFieldsLabel();
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
    Label informationMessageLabel;
    TextArea informationMessageArea;
    ImageView buildingImage;
    ImageView elevatorImage;
    Label lastPersonInTheElevatorLabel;
    TextField lastPersonInTheElevatorText;

    Label elevatorStatusLabel;
    Label lastPersonTargetLabel;
    TextField currentFloorText;
    TextField lastPersonTargetText;

    Label elevatorControlsLabel;
    ImageView elevatorUpButtonImage;
    Button elevatorUpButton;
    ImageView elevatorDownButtonImage;
    Button elevatorDownButton;
    TextField newPersonNameText;
    TextField newPersonTargetText;
    Button addNewPersonButton;
    Scene mainLayout;

    Label newPersonFieldsLabel;

    double betweenFloorSpace = 128;



    public void setElevator() {
        elevator = new Elevator(4, 0, 5);
    }

    private void setInformationMessageLabel() {
        informationMessageLabel = new Label("Information messages");
        informationMessageLabel.setLayoutX(450);
        informationMessageLabel.setLayoutY(680);
    }
    public void setInformationMessageArea() {
        informationMessageArea = new TextArea();
        informationMessageArea.setEditable(false);
        informationMessageArea.setLayoutX(informationMessageLabel.getLayoutX());
        informationMessageArea.setLayoutY(informationMessageLabel.getLayoutY() + 20);
        informationMessageArea.setMaxWidth(220);
        informationMessageArea.setMinWidth(220);
        informationMessageArea.setMaxHeight(100);
        informationMessageArea.setMinHeight(100);
    }

    public void setBuildingImage() {
        String imagePath = "https://raw.githubusercontent.com/EpicCMoment/ElevatorGame/main/src/main/java/com/elevatorgame/elevatorgame/building.png";
        buildingImage = new ImageView(imagePath);
        buildingImage.setFitWidth(400);
        buildingImage.setFitHeight(800);
        buildingImage.setLayoutX(20);
    }

    public void setElevatorImage() {
        String imagePath = "https://raw.githubusercontent.com/EpicCMoment/ElevatorGame/main/src/main/java/com/elevatorgame/elevatorgame/elevator.png";
        elevatorImage = new ImageView(imagePath);
        elevatorImage.setFitHeight(100);
        elevatorImage.setFitWidth(100);
        elevatorImage.setLayoutX(173);
        elevatorImage.setLayoutY(700);
    }

    public void setElevatorStatusLabel() {
     elevatorStatusLabel = new Label("Elevator Status");
     elevatorStatusLabel.setMaxWidth(100);
     elevatorStatusLabel.setMinWidth(100);
     elevatorStatusLabel.setLayoutX(elevatorControlsLabel.getLayoutX() + 150);
     elevatorStatusLabel.setLayoutY(elevatorControlsLabel.getLayoutY());

    }

    public void setLastPersonInTheElevatorLabel() {
        lastPersonInTheElevatorLabel = new Label("Last Person: ");
        lastPersonInTheElevatorLabel.setMaxWidth(200);
        lastPersonInTheElevatorLabel.setMinWidth(200);
        lastPersonInTheElevatorLabel.setLayoutX(elevatorUpButton.getLayoutX() + 90);
        lastPersonInTheElevatorLabel.setLayoutY(elevatorUpButton.getLayoutY() + 10);

    }

    public void setLastPersonInTheElevatorText() {
        lastPersonInTheElevatorText = new TextField();
        lastPersonInTheElevatorText.setAlignment(Pos.CENTER);
        lastPersonInTheElevatorText.setMaxWidth(90);
        lastPersonInTheElevatorText.setMinWidth(90);
        lastPersonInTheElevatorText.setEditable(false);
        lastPersonInTheElevatorText.setLayoutX(lastPersonInTheElevatorLabel.getLayoutX() + 70 );
        lastPersonInTheElevatorText.setLayoutY(lastPersonInTheElevatorLabel.getLayoutY());
    }

    public void setLastPersonTargetLabel() {
        lastPersonTargetLabel = new Label("Target floor: ");
        lastPersonTargetLabel.setMaxWidth(200);
        lastPersonTargetLabel.setMinWidth(200);
        lastPersonTargetLabel.setLayoutX(lastPersonInTheElevatorLabel.getLayoutX());
        lastPersonTargetLabel.setLayoutY(lastPersonInTheElevatorLabel.getLayoutY() + 35);
    }

    public void setLastPersonTargetText() {
        lastPersonTargetText = new TextField();
        lastPersonTargetText.setAlignment(Pos.CENTER);
        lastPersonTargetText.setMaxWidth(90);
        lastPersonTargetText.setMinWidth(90);
        lastPersonTargetText.setEditable(false);
        lastPersonTargetText.setLayoutX(lastPersonTargetLabel.getLayoutX() + 70);
        lastPersonTargetText.setLayoutY(lastPersonTargetLabel.getLayoutY());
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

    public void setElevatorControlsLabel() {
        elevatorControlsLabel = new Label("Elevator Controls");
        elevatorControlsLabel.setMaxWidth(100);
        elevatorControlsLabel.setMinWidth(100);
        elevatorControlsLabel.setLayoutX(460);
        elevatorControlsLabel.setLayoutY(400);
    }

    public void setElevatorUpButtonImage() {
        String imagePath = "https://raw.githubusercontent.com/EpicCMoment/ElevatorGame/main/src/main/java/com/elevatorgame/elevatorgame/up_arrow.png";
        elevatorUpButtonImage = new ImageView(imagePath);
        elevatorUpButtonImage.setFitWidth(30);
        elevatorUpButtonImage.setFitHeight(30);
    }

    public void setElevatorUpButton() {
        elevatorUpButton = new Button();
        elevatorUpButton.setGraphic(elevatorUpButtonImage);
        elevatorUpButton.setLayoutX(elevatorControlsLabel.getLayoutX() + 20);
        elevatorUpButton.setLayoutY(elevatorControlsLabel.getLayoutY() + 20);

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
                    informationMessageArea.setText(informationMessageArea.getText() + lastPersonName + " is fucked off.\n");
                }

                currentFloorText.setText(Integer.toString(elevator.getCurrentFloor()));
            }

        });
    }

    public void setElevatorDownButtonImage() {
        String imagePath = "https://raw.githubusercontent.com/EpicCMoment/ElevatorGame/main/src/main/java/com/elevatorgame/elevatorgame/down_arrow.png";
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
                    informationMessageArea.setText(informationMessageArea.getText() + lastPersonName + " is fucked off.\n" + informationMessageArea);
                }

                currentFloorText.setText(Integer.toString(elevator.getCurrentFloor()));

            }

        });
    }

    private void setNewPersonFieldsLabel() {
        newPersonFieldsLabel = new Label("Add a new person");
        newPersonFieldsLabel.setLayoutX(477);
        newPersonFieldsLabel.setLayoutY(120);
    }

    public void setNewPersonNameText() {
        newPersonNameText = new TextField();
        newPersonNameText.setPromptText("Name");
        newPersonNameText.setLayoutX(newPersonFieldsLabel.getLayoutX());
        newPersonNameText.setLayoutY(newPersonFieldsLabel.getLayoutY() + 20);
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
                lastPersonInTheElevatorText.setText(personName);
            } else {
                if (elevator.getPeople().getSize() == elevator.getCapacity()) {
                    informationMessageArea.setText("Elevator is full.");
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
        ObservableList<Node> backgroundElements = mainBackground.getChildren();

        backgroundElements.add(buildingImage);
        backgroundElements.add(lastPersonInTheElevatorLabel);
        backgroundElements.add(lastPersonInTheElevatorText);
        backgroundElements.add(lastPersonTargetLabel);
        backgroundElements.add(lastPersonTargetText);
        backgroundElements.add(currentFloorText);
        backgroundElements.add(elevatorUpButton);
        backgroundElements.add(elevatorDownButton);
        backgroundElements.add(elevatorImage);
        backgroundElements.add(newPersonNameText);
        backgroundElements.add(newPersonTargetText);
        backgroundElements.add(addNewPersonButton);
        backgroundElements.add(informationMessageArea);
        backgroundElements.add(newPersonFieldsLabel);
        backgroundElements.add(informationMessageLabel);
        backgroundElements.add(elevatorControlsLabel);
        backgroundElements.add(elevatorStatusLabel);
    }

    public void setMainLayout() {
        mainLayout = new Scene(mainBackground, 750, 850);
    }

    public void setMainWindow(Stage mainWindow) {

        String iconURL = "https://raw.githubusercontent.com/EpicCMoment/ElevatorGame/main/src/main/java/com/elevatorgame/elevatorgame/icon.png";

        mainWindow.setResizable(false);
        mainWindow.getIcons().add(new Image(iconURL));

        mainWindow.setScene(mainLayout);
    }


}
