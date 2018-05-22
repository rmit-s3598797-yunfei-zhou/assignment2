//developer: JiaQi Tang  s3598284
package startup;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import exceptions.NoAvailableException;
import exceptions.NoParentException;
import exceptions.NoSuchAgeException;
import exceptions.NotToBeClassmatesException;
import exceptions.NotToBeColleaguesException;
import exceptions.NotToBeCoupledException;
import exceptions.NotToBeFriendsException;
import exceptions.TooYoungException;
import functionality.GameEngineImpl;
import interfaces.GameEngine;
import interfaces.People;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MiniNet extends Application {
	final GameEngine gameEngine = new GameEngineImpl();

	@Override
	public void start(Stage primaryStage) {
		int p = 0;
		Pane pane = new Pane();
		Scene scene = new Scene(pane, 900, 550);
		primaryStage.setTitle("MiniNet");
		primaryStage.setScene(scene);
		primaryStage.show();

		Text welcomeText = new Text(210, 190, "Welcome To MiniNet !");
		welcomeText.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.ITALIC, 40));
		welcomeText.setFill(Color.CORNFLOWERBLUE);
		pane.getChildren().add(welcomeText);
		Text authorText = new Text(290, 240, "(developer: JiaQi Tang  s3598284)");
		authorText.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.ITALIC, 15));
		authorText.setFill(Color.LIGHTBLUE);
		pane.getChildren().add(authorText);
		Text authorText2 = new Text(290, 270, "(developer: YunFei Zhou s3598797)");
		authorText2.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.ITALIC, 15));
		authorText2.setFill(Color.LIGHTBLUE);
		pane.getChildren().add(authorText2);
		// all what happen when button 'start' is clicked are defined here
		Button start = new Button("START");
		start.setLayoutX(360);
		start.setLayoutY(300);
		start.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.REGULAR, 25));
		start.setTextFill(Color.DODGERBLUE);
		start.setPrefHeight(80);
		start.setPrefWidth(150);
		pane.getChildren().add(start);

		start.setOnAction((ActionEvent e) -> {
			try {
				gameEngine.initialPeopleList();
			} catch (Exception e3) {
				e3.printStackTrace();
				System.out.println("txt document and database are both not found");
				GridPane pane7 = new GridPane();
				Scene settingsScene = new Scene(pane7, 500, 30);
				Stage popup = new Stage();
				popup.setScene(settingsScene);
				Text reminder = new Text(50, 200, "both txt and database are not found");
				reminder.setFont(Font.font("Courier", FontWeight.THIN, FontPosture.ITALIC, 20));
				reminder.setFill(Color.RED);
				pane7.getChildren().add(reminder);
				popup.show();
			}
			gameEngine.initialRelationList();
			start.setVisible(false);
			welcomeText.setVisible(false);
			authorText.setVisible(false);
			authorText2.setVisible(false);
			Text guidingTxt = new Text(40, 120, "Just Do Anything You want      ==>>");
			guidingTxt.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.ITALIC, 30));
			guidingTxt.setFill(Color.CORNFLOWERBLUE);
			pane.getChildren().add(guidingTxt);
			/*
			 * make a flower animation ,just for fun!!
			*/
			Rectangle rectangle1 = new Rectangle(0, 0, 10, 20);
			Rectangle rectangle2 = new Rectangle(0, 0, 10, 20);
			Rectangle rectangle3 = new Rectangle(0, 0, 10, 20);
			Rectangle rectangle4 = new Rectangle(0, 0, 10, 20);
			Rectangle rectangle5 = new Rectangle(0, 0, 10, 20);
			Rectangle rectangle6 = new Rectangle(0, 0, 10, 20);
			Rectangle rectangle7 = new Rectangle(0, 0, 10, 20);
			Rectangle rectangle8 = new Rectangle(0, 0, 10, 20);
			Rectangle rectangle9 = new Rectangle(0, 0, 10, 20);
			Rectangle rectangle0 = new Rectangle(0, 0, 10, 20);
			rectangle1.setFill(Color.CORNFLOWERBLUE);
			rectangle2.setFill(Color.CORNFLOWERBLUE);
			rectangle3.setFill(Color.CORNFLOWERBLUE);
			rectangle4.setFill(Color.CORNFLOWERBLUE);
			rectangle5.setFill(Color.CORNFLOWERBLUE);
			rectangle6.setFill(Color.CORNFLOWERBLUE);
			rectangle7.setFill(Color.CORNFLOWERBLUE);
			rectangle8.setFill(Color.CORNFLOWERBLUE);
			rectangle9.setFill(Color.CORNFLOWERBLUE);
			rectangle0.setFill(Color.CORNFLOWERBLUE);

			Circle circle = new Circle(550, 110, 20);
			circle.setFill(Color.WHITE);
			circle.setStroke(Color.BLACK);

			pane.getChildren().add(circle);
			pane.getChildren().add(rectangle1);
			pane.getChildren().add(rectangle2);
			pane.getChildren().add(rectangle3);
			pane.getChildren().add(rectangle4);
			pane.getChildren().add(rectangle5);
			pane.getChildren().add(rectangle6);
			pane.getChildren().add(rectangle7);
			pane.getChildren().add(rectangle8);
			pane.getChildren().add(rectangle9);
			pane.getChildren().add(rectangle0);

			PathTransition pt1 = new PathTransition();
			pt1.setDuration(Duration.millis(1000));
			pt1.setPath(circle);
			pt1.setNode(rectangle1);
			pt1.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
			pt1.setCycleCount(Timeline.INDEFINITE);
			pt1.setAutoReverse(true);
			pt1.play(); 
			PathTransition pt2 = new PathTransition();
			pt2.setDuration(Duration.millis(2000));
			pt2.setPath(circle);
			pt2.setNode(rectangle2);
			pt2.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
			pt2.setCycleCount(Timeline.INDEFINITE);
			pt2.setAutoReverse(true);
			pt2.play(); 
			PathTransition pt3 = new PathTransition();
			pt3.setDuration(Duration.millis(3000));
			pt3.setPath(circle);
			pt3.setNode(rectangle3);
			pt3.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
			pt3.setCycleCount(Timeline.INDEFINITE);
			pt3.setAutoReverse(true);
			pt3.play(); 
			PathTransition pt4 = new PathTransition();
			pt4.setDuration(Duration.millis(4000));
			pt4.setPath(circle);
			pt4.setNode(rectangle4);
			pt4.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
			pt4.setCycleCount(Timeline.INDEFINITE);
			pt4.setAutoReverse(true);
			pt4.play(); 
			PathTransition pt5 = new PathTransition();
			pt5.setDuration(Duration.millis(5000));
			pt5.setPath(circle);
			pt5.setNode(rectangle5);
			pt5.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
			pt5.setCycleCount(Timeline.INDEFINITE);
			pt5.setAutoReverse(true);
			pt5.play(); 
			PathTransition pt6 = new PathTransition();
			pt6.setDuration(Duration.millis(6000));
			pt6.setPath(circle);
			pt6.setNode(rectangle6);
			pt6.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
			pt6.setCycleCount(Timeline.INDEFINITE);
			pt6.setAutoReverse(true);
			pt6.play(); 
			PathTransition pt7 = new PathTransition();
			pt7.setDuration(Duration.millis(7000));
			pt7.setPath(circle);
			pt7.setNode(rectangle7);
			pt7.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
			pt7.setCycleCount(Timeline.INDEFINITE);
			pt7.setAutoReverse(true);
			pt7.play(); 
			PathTransition pt8 = new PathTransition();
			pt8.setDuration(Duration.millis(8000));
			pt8.setPath(circle);
			pt8.setNode(rectangle8);
			pt8.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
			pt8.setCycleCount(Timeline.INDEFINITE);
			pt8.setAutoReverse(true);
			pt8.play(); 
			PathTransition pt9 = new PathTransition();
			pt9.setDuration(Duration.millis(9000));
			pt9.setPath(circle);
			pt9.setNode(rectangle9);
			pt9.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
			pt9.setCycleCount(Timeline.INDEFINITE);
			pt9.setAutoReverse(true);
			pt9.play(); 
			PathTransition pt0 = new PathTransition();
			pt0.setDuration(Duration.millis(10000));
			pt0.setPath(circle);
			pt0.setNode(rectangle0);
			pt0.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
			pt0.setCycleCount(Timeline.INDEFINITE);
			pt0.setAutoReverse(true);
			pt0.play(); 
			
			
			// all what happen when button 'list people' is clicked are defined here
			Button listPeople = new Button("List people");
			listPeople.setLayoutX(720);
			listPeople.setLayoutY(100);
			listPeople.setTextFill(Color.CHOCOLATE);
			pane.getChildren().add(listPeople);
			listPeople.setOnAction((ActionEvent a) -> {
				Pane pane3 = new Pane();
				double text2Y = 30;
				for (People people : gameEngine.getPeopleList()) {
					Text text2 = new Text(60, text2Y + 20,
							"Name: " + people.getName() + " Status: " + people.getStatus() + " Gender: "
									+ people.getGender() + " Age: " + people.getAge() + " State " + people.getState());
					text2.setFont(Font.font("Courier", FontWeight.THIN, FontPosture.ITALIC, 12));
					pane3.getChildren().add(text2);

					// Creating an image
					Image image = null;
					try {
						// remove the " “ " and " ” " of the picture name that we load from the txt
						// document
						String picName = (people.getPic()).replace("“", "").replace("”", "");
						image = new Image(new FileInputStream("../../ApAssignment2/src/inPutData/" + picName));
					} catch (FileNotFoundException e1) {
						// Creating an image
						Image image2 = null;
						try {
							image2 = new Image(new FileInputStream("../../ApAssignment2/src/inPutData/NoPic.jpg"));
						} catch (FileNotFoundException e2) {
							GridPane pane7 = new GridPane();
							Scene settingsScene = new Scene(pane7, 500, 30);
							Stage popup = new Stage();
							popup.setScene(settingsScene);
							Text reminder = new Text(50, 200, "pictures are missing");
							reminder.setFont(Font.font("Courier", FontWeight.THIN, FontPosture.ITALIC, 20));
							reminder.setFill(Color.RED);
							pane7.getChildren().add(reminder);
							popup.show();
						}

						// Setting the image view
						ImageView imageView = new ImageView(image2);

						// Setting the position of the image
						imageView.setX(5);
						imageView.setY(text2Y);

						// setting the fit height and width of the image view
						imageView.setFitHeight(40);
						imageView.setFitWidth(40);

						// Setting the preserve ratio of the image view
						imageView.setPreserveRatio(true);

						// Creating a Group object
						Group root = new Group(imageView);
						pane3.getChildren().add(root);
					}

					// Setting the image view
					ImageView imageView = new ImageView(image);

					// Setting the position of the image
					imageView.setX(5);
					imageView.setY(text2Y);

					// setting the fit height and width of the image view
					imageView.setFitHeight(40);
					imageView.setFitWidth(40);

					// Setting the preserve ratio of the image view
					imageView.setPreserveRatio(true);

					// Creating a Group object
					Group root = new Group(imageView);
					pane3.getChildren().add(root);

					text2Y = text2Y + 50;
				}
				Button btBack = new Button("Go Back");
				btBack.setLayoutX(740);
				btBack.setLayoutY(280);
				btBack.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.REGULAR, 15));
				btBack.setTextFill(Color.DODGERBLUE);
				btBack.setPrefHeight(40);
				btBack.setPrefWidth(100);
				pane3.getChildren().add(btBack);
				Scene scene3 = new Scene(pane3, 900, 350);
				primaryStage.setTitle("MiniNet");
				primaryStage.setScene(scene3);
				primaryStage.show();

				btBack.setOnAction((ActionEvent h) -> {
					primaryStage.setTitle("MiniNet");
					primaryStage.setScene(scene);
					primaryStage.show();
				});

			});
			// all what happen when button 'select people' is clicked are defined here
			Button selectPeople = new Button("Select people");
			selectPeople.setLayoutX(720);
			selectPeople.setLayoutY(150);
			selectPeople.setTextFill(Color.CHOCOLATE);
			pane.getChildren().add(selectPeople);
			selectPeople.setOnAction((ActionEvent a) -> {
				GridPane pane3 = new GridPane();
				TextField selectNameField = new TextField();
				pane3.add(new Label("Full Name or First Name:"), 1, 0);
				pane3.add(selectNameField, 2, 0);
				Button btSelect = new Button("Select");
				pane3.add(btSelect, 2, 7);
				Button btBack = new Button("Go Back");
				pane3.add(btBack, 2, 8);
				Scene scene3 = new Scene(pane3, 900, 350);
				primaryStage.setTitle("MiniNet");
				primaryStage.setScene(scene3);
				primaryStage.show();
				btSelect.setOnAction((ActionEvent c) -> {
					if (gameEngine.selectPeople(selectNameField.getText())) {
						Pane pane4 = new Pane();

						Text optionAsker = new Text(50, 50, "What you want to do with the selected person?");
						optionAsker.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.ITALIC, 20));
						optionAsker.setFill(Color.CORNFLOWERBLUE);
						pane4.getChildren().add(optionAsker);

						Button showProfile = new Button("Show Profile");
						showProfile.setLayoutX(50);
						showProfile.setLayoutY(300);
						showProfile.setTextFill(Color.CHOCOLATE);
						pane4.getChildren().add(showProfile);

						Button deletePerson = new Button("Delete Person");
						deletePerson.setLayoutX(200);
						deletePerson.setLayoutY(300);
						deletePerson.setTextFill(Color.CHOCOLATE);
						pane4.getChildren().add(deletePerson);

						Button backToMain = new Button("Back");
						backToMain.setLayoutX(350);
						backToMain.setLayoutY(300);
						backToMain.setTextFill(Color.CHOCOLATE);
						pane4.getChildren().add(backToMain);

						Scene scene4 = new Scene(pane4, 900, 350);
						primaryStage.setTitle("MiniNet");
						primaryStage.setScene(scene4);
						primaryStage.show();

						showProfile.setOnAction((ActionEvent d) -> {
							// Creating an image
							Image image = null;
							try {
								// remove the " “ " and " ” " of the picture name that we load from the txt
								// document
								String picName = (gameEngine.getSelectedPeople(selectNameField.getText()).getPic())
										.replace("“", "").replace("”", "");
								image = new Image(new FileInputStream("../../ApAssignment2/src/inPutData/" + picName));
							} catch (FileNotFoundException e1) {
								// Creating an image
								Image image2 = null;
								try {
									image2 = new Image(
											new FileInputStream("../../ApAssignment2/src/inPutData/NoPic.jpg"));
								} catch (FileNotFoundException e2) {
									GridPane pane7 = new GridPane();
									Scene settingsScene = new Scene(pane7, 500, 30);
									Stage popup = new Stage();
									popup.setScene(settingsScene);
									Text reminder = new Text(50, 200, "unknown error");
									reminder.setFont(Font.font("Courier", FontWeight.THIN, FontPosture.ITALIC, 20));
									reminder.setFill(Color.RED);
									pane7.getChildren().add(reminder);
									popup.show();
								}

								// Setting the image view
								ImageView imageView = new ImageView(image2);

								// Setting the position of the image
								imageView.setX(50);
								imageView.setY(70);

								// setting the fit height and width of the image view
								imageView.setFitHeight(150);
								imageView.setFitWidth(150);

								// Setting the preserve ratio of the image view
								imageView.setPreserveRatio(true);

								// Creating a Group object
								Group root = new Group(imageView);
								pane4.getChildren().add(root);
							}

							// Setting the image view
							ImageView imageView = new ImageView(image);

							// Setting the position of the image
							imageView.setX(50);
							imageView.setY(70);

							// setting the fit height and width of the image view
							imageView.setFitHeight(150);
							imageView.setFitWidth(150);

							// Setting the preserve ratio of the image view
							imageView.setPreserveRatio(true);

							// Creating a Group object
							Group root = new Group(imageView);
							pane4.getChildren().add(root);

							Text profile = new Text(50, 250, "Name: "
									+ gameEngine.getSelectedPeople(selectNameField.getText()).getName() + " Status: "
									+ gameEngine.getSelectedPeople(selectNameField.getText()).getStatus() + " Gender: "
									+ gameEngine.getSelectedPeople(selectNameField.getText()).getGender() + " Age: "
									+ gameEngine.getSelectedPeople(selectNameField.getText()).getAge() + " State "
									+ gameEngine.getSelectedPeople(selectNameField.getText()).getState());
							profile.setFont(Font.font("Courier", FontWeight.THIN, FontPosture.ITALIC, 12));
							pane4.getChildren().add(profile);
						});
						deletePerson.setOnAction((ActionEvent d) -> {
							try {
								gameEngine.removePeople(gameEngine.getSelectedPeople(selectNameField.getText()));
								gameEngine.removeAllRelationship(selectNameField.getText());
								primaryStage.setTitle("MiniNet");
								primaryStage.setScene(scene);
								primaryStage.show();
							} catch (NoParentException e1) {
								System.out.println(e1.toString());
								GridPane pane7 = new GridPane();
								Scene settingsScene = new Scene(pane7, 500, 30);
								Stage popup = new Stage();
								popup.setScene(settingsScene);
								Text reminder = new Text(50, 200, "this person is a parent of someone");
								reminder.setFont(Font.font("Courier", FontWeight.THIN, FontPosture.ITALIC, 20));
								reminder.setFill(Color.RED);
								pane7.getChildren().add(reminder);
								popup.show();
							} catch (Exception e1) {

							}
						});
						backToMain.setOnAction((ActionEvent d) -> {
							primaryStage.setTitle("MiniNet");
							primaryStage.setScene(scene);
							primaryStage.show();
						});
					} else {
						Text noPeopleReminder = new Text(260, 50,
								"There is no '" + selectNameField.getText() + "' is this system!");
						noPeopleReminder.setFill(Color.INDIANRED);
						pane3.add(noPeopleReminder, 2, 9);
						primaryStage.setTitle("MiniNet");
						primaryStage.setScene(scene3);
						primaryStage.show();
					}
				});
				btBack.setOnAction((ActionEvent h) -> {
					primaryStage.setTitle("MiniNet");
					primaryStage.setScene(scene);
					primaryStage.show();
				});
			});
			// all what happen when button 'add people' is clicked are defined here
			Button addANewPeople = new Button("Add people ");
			addANewPeople.setLayoutX(720);
			addANewPeople.setLayoutY(200);
			addANewPeople.setTextFill(Color.CHOCOLATE);
			pane.getChildren().add(addANewPeople);
			addANewPeople.setOnAction((ActionEvent a) -> {
				GridPane pane2 = new GridPane();
				TextField fullNameField = new TextField();
				TextField ageField = new TextField();
				TextField pictureField = new TextField();
				TextField statusField = new TextField();
				TextField genderField = new TextField();
				TextField stateField = new TextField();
				pane2.add(new Label("Full Name:"), 1, 0);
				pane2.add(fullNameField, 2, 0);
				pane2.add(new Label("Age:"), 1, 1);
				pane2.add(ageField, 2, 1);
				pane2.add(new Label("Picture:"), 1, 2);
				pane2.add(pictureField, 2, 2);
				pane2.add(new Label("Status:"), 1, 3);
				pane2.add(statusField, 2, 3);
				pane2.add(new Label("Gender:"), 1, 4);
				pane2.add(genderField, 2, 4);
				pane2.add(new Label("State:"), 1, 5);
				pane2.add(stateField, 2, 5);
				Button btAdd = new Button("Add");
				pane2.add(btAdd, 2, 6);
				Button btBack = new Button("Go Back");
				pane2.add(btBack, 2, 8);
				Scene scene2 = new Scene(pane2, 900, 350);
				primaryStage.setTitle("MiniNet");
				primaryStage.setScene(scene2);
				primaryStage.show();
				btAdd.setOnAction((ActionEvent b) -> {
					int integerAge = 0;
					try {
						integerAge = Integer.parseInt(ageField.getText());
						gameEngine.addPeople(fullNameField.getText(), pictureField.getText(), statusField.getText(),
								genderField.getText(), ageField.getText(), stateField.getText());
						primaryStage.setTitle("MiniNet");
						primaryStage.setScene(scene);
						primaryStage.show();
					} catch (NoParentException e1) {
						System.out.println(e1.toString());
						Text ageReminder = new Text(500, 50, "The new person is under 16 !");
						ageReminder.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.ITALIC, 20));
						ageReminder.setFill(Color.RED);

						GridPane pane3 = new GridPane();
						pane3.getChildren().add(ageReminder);
						TextField fatherField = new TextField();
						TextField motherField = new TextField();
						pane3.add(new Label("Father:"), 1, 20);
						pane3.add(fatherField, 2, 20);
						pane3.add(new Label("Mother:"), 1, 30);
						pane3.add(motherField, 2, 30);

						Button btSetParents = new Button("Set Parents");
						pane3.add(btSetParents, 2, 40);

						Button btBack2 = new Button("Go Back");
						pane3.add(btBack, 30, 40);
						Scene scene3 = new Scene(pane3, 900, 350);

						primaryStage.setTitle("MiniNet");
						primaryStage.setScene(scene3);
						primaryStage.show();
						btSetParents.setOnAction((ActionEvent c) -> {
							try {
								gameEngine.defineParents(fullNameField.getText(), fatherField.getText(),
										motherField.getText());
								primaryStage.setTitle("MiniNet");
								primaryStage.setScene(scene2);
								primaryStage.show();

							} catch (NoParentException e2) {
								System.out.println(e2.toString());
								GridPane pane7 = new GridPane();
								Scene settingsScene = new Scene(pane7, 500, 30);
								Stage popup = new Stage();
								popup.setScene(settingsScene);
								Text reminder = new Text(50, 200, "they are not couple !");
								reminder.setFont(Font.font("Courier", FontWeight.THIN, FontPosture.ITALIC, 20));
								reminder.setFill(Color.RED);
								pane7.getChildren().add(reminder);
								popup.show();
							} catch (Exception e2) {
								System.out.println(e2.toString());
								GridPane pane7 = new GridPane();
								Scene settingsScene = new Scene(pane7, 500, 30);
								Stage popup = new Stage();
								popup.setScene(settingsScene);
								Text reminder = new Text(50, 200, "they are not couple !");
								reminder.setFont(Font.font("Courier", FontWeight.THIN, FontPosture.ITALIC, 20));
								reminder.setFill(Color.RED);
								pane7.getChildren().add(reminder);
								popup.show();
							}

						});
						btBack2.setOnAction((ActionEvent h) -> {
							primaryStage.setTitle("MiniNet");
							primaryStage.setScene(scene2);
							primaryStage.show();
						});
					} catch (NoSuchAgeException e1) {
						GridPane pane7 = new GridPane();
						Scene settingsScene = new Scene(pane7, 500, 30);
						Stage popup = new Stage();
						popup.setScene(settingsScene);
						Text reminder = new Text(50, 200, e1.toString());
						reminder.setFont(Font.font("Courier", FontWeight.THIN, FontPosture.ITALIC, 20));
						reminder.setFill(Color.RED);
						pane7.getChildren().add(reminder);
						popup.show();
					} catch (NumberFormatException ageIntegerOrNot) {
						GridPane pane7 = new GridPane();
						Scene settingsScene = new Scene(pane7, 500, 30);
						Stage popup = new Stage();
						popup.setScene(settingsScene);
						Text reminder = new Text(50, 200, "The Age Should Be An Integer !!");
						reminder.setFont(Font.font("Courier", FontWeight.THIN, FontPosture.ITALIC, 20));
						reminder.setFill(Color.RED);
						pane7.getChildren().add(reminder);
						popup.show();
					} catch (Exception e1) {
						GridPane pane7 = new GridPane();
						Scene settingsScene = new Scene(pane7, 500, 30);
						Stage popup = new Stage();
						popup.setScene(settingsScene);
						Text reminder = new Text(50, 200, "unknown error");
						reminder.setFont(Font.font("Courier", FontWeight.THIN, FontPosture.ITALIC, 20));
						reminder.setFill(Color.RED);
						pane7.getChildren().add(reminder);
						popup.show();
					}
				});
				btBack.setOnAction((ActionEvent h) -> {
					primaryStage.setTitle("MiniNet");
					primaryStage.setScene(scene);
					primaryStage.show();
				});
			});
			// all what happen when button 'find relation' is clicked are defined here
			Button findRelation = new Button("Find relationship");
			findRelation.setLayoutX(720);
			findRelation.setLayoutY(250);
			findRelation.setTextFill(Color.CHOCOLATE);
			pane.getChildren().add(findRelation);
			findRelation.setOnAction((ActionEvent a) -> {
				GridPane pane5 = new GridPane();
				TextField firstNameField = new TextField();
				TextField secondNameField = new TextField();
				pane5.add(new Label("Full Name:"), 1, 0);
				pane5.add(firstNameField, 2, 0);
				pane5.add(new Label("Full Name:"), 1, 2);
				pane5.add(secondNameField, 2, 2);
				Button btFindRelation = new Button("Find the Relationship");
				pane5.add(btFindRelation, 2, 6);
				Button btBack = new Button("Go Back");
				pane5.add(btBack, 2, 8);
				Scene scene5 = new Scene(pane5, 900, 350);
				primaryStage.setTitle("MiniNet");
				primaryStage.setScene(scene5);
				primaryStage.show();

				btFindRelation.setOnAction((ActionEvent f) -> {

					GridPane pane7 = new GridPane();
					Scene settingsScene = new Scene(pane7, 500, 30);
					Stage popup = new Stage();
					popup.setScene(settingsScene);
					Text reminder = new Text(50, 200, "their relation type is :"
							+ gameEngine.findRelationship(firstNameField.getText(), secondNameField.getText()) + " ");
					reminder.setFont(Font.font("Courier", FontWeight.THIN, FontPosture.ITALIC, 20));
					reminder.setFill(Color.CHOCOLATE);
					pane7.getChildren().add(reminder);
					popup.show();
				});
				btBack.setOnAction((ActionEvent f) -> {
					primaryStage.setTitle("MiniNet");
					primaryStage.setScene(scene);
					primaryStage.show();
				});
			});
			// all what happen when button 'add relation' is clicked are defined here
			Button defineRelation = new Button("Add relationship");
			defineRelation.setLayoutX(720);
			defineRelation.setLayoutY(300);
			defineRelation.setTextFill(Color.CHOCOLATE);
			pane.getChildren().add(defineRelation);
			defineRelation.setOnAction((ActionEvent a) -> {
				GridPane pane6 = new GridPane();
				TextField firstNameField = new TextField();
				TextField secondNameField = new TextField();
				TextField relationTypeField = new TextField();
				pane6.add(new Label("Full Name:"), 1, 0);
				pane6.add(firstNameField, 2, 0);
				pane6.add(new Label("Full Name:"), 1, 2);
				pane6.add(secondNameField, 2, 2);
				pane6.add(new Label("relationship:"), 1, 4);
				pane6.add(relationTypeField, 2, 4);
				Button btAddRelation = new Button("Add New Relationship");
				pane6.add(btAddRelation, 2, 6);
				Button btBack = new Button("Go Back");
				pane6.add(btBack, 2, 8);
				Scene scene6 = new Scene(pane6, 900, 350);
				primaryStage.setTitle("MiniNet");
				primaryStage.setScene(scene6);
				primaryStage.show();

				btAddRelation.setOnAction((ActionEvent f) -> {
					try {
						gameEngine.defineRelation(firstNameField.getText(), secondNameField.getText(),
								relationTypeField.getText());

						primaryStage.setTitle("MiniNet");
						primaryStage.setScene(scene);
						primaryStage.show();
					} catch (TooYoungException e1) {
						System.out.println(e1.toString());
						GridPane pane7 = new GridPane();
						Scene settingsScene = new Scene(pane7, 500, 30);
						Stage popup = new Stage();
						popup.setScene(settingsScene);
						Text reminder = new Text(50, 200, e1.toString());
						reminder.setFont(Font.font("Courier", FontWeight.THIN, FontPosture.ITALIC, 20));
						reminder.setFill(Color.RED);
						pane7.getChildren().add(reminder);
						popup.show();

					} catch (NotToBeFriendsException e1) {
						System.out.println(e1.toString());
						GridPane pane7 = new GridPane();
						Scene settingsScene = new Scene(pane7, 1200, 30);
						Stage popup = new Stage();
						popup.setScene(settingsScene);
						Text reminder = new Text(50, 200, e1.toString());
						reminder.setFont(Font.font("Courier", FontWeight.THIN, FontPosture.ITALIC, 20));
						reminder.setFill(Color.RED);
						pane7.getChildren().add(reminder);
						popup.show();

					} catch (NoAvailableException e1) {
						System.out.println(e1.toString());
						GridPane pane7 = new GridPane();
						Scene settingsScene = new Scene(pane7, 1000, 30);
						Stage popup = new Stage();
						popup.setScene(settingsScene);
						Text reminder = new Text(50, 200, e1.toString());
						reminder.setFont(Font.font("Courier", FontWeight.THIN, FontPosture.ITALIC, 20));
						reminder.setFill(Color.RED);
						pane7.getChildren().add(reminder);
						popup.show();

					} catch (NotToBeCoupledException e1) {
						System.out.println(e1.toString());
						GridPane pane7 = new GridPane();
						Scene settingsScene = new Scene(pane7, 1000, 30);
						Stage popup = new Stage();
						popup.setScene(settingsScene);
						Text reminder = new Text(50, 200, e1.toString());
						reminder.setFont(Font.font("Courier", FontWeight.THIN, FontPosture.ITALIC, 20));
						reminder.setFill(Color.RED);
						pane7.getChildren().add(reminder);
						popup.show();

					} catch (NotToBeColleaguesException e1) {
						System.out.println(e1.toString());
						GridPane pane7 = new GridPane();
						Scene settingsScene = new Scene(pane7, 600, 30);
						Stage popup = new Stage();
						popup.setScene(settingsScene);
						Text reminder = new Text(50, 200, e1.toString());
						reminder.setFont(Font.font("Courier", FontWeight.THIN, FontPosture.ITALIC, 20));
						reminder.setFill(Color.RED);
						pane7.getChildren().add(reminder);
						popup.show();

					} catch (NotToBeClassmatesException e1) {
						System.out.println(e1.toString());
						GridPane pane7 = new GridPane();
						Scene settingsScene = new Scene(pane7, 600, 30);
						Stage popup = new Stage();
						popup.setScene(settingsScene);
						Text reminder = new Text(50, 200, e1.toString());
						reminder.setFont(Font.font("Courier", FontWeight.THIN, FontPosture.ITALIC, 20));
						reminder.setFill(Color.RED);
						pane7.getChildren().add(reminder);
						popup.show();

					} catch (Exception e1) {
						GridPane pane7 = new GridPane();
						Scene settingsScene = new Scene(pane7, 500, 30);
						Stage popup = new Stage();
						popup.setScene(settingsScene);
						Text reminder = new Text(50, 200, "unknown error");
						reminder.setFont(Font.font("Courier", FontWeight.THIN, FontPosture.ITALIC, 20));
						reminder.setFill(Color.RED);
						pane7.getChildren().add(reminder);
						popup.show();
					}
				});
				btBack.setOnAction((ActionEvent f) -> {
					primaryStage.setTitle("MiniNet");
					primaryStage.setScene(scene);
					primaryStage.show();
				});
			});
			// all what happen when button 'find children' is clicked are defined here
			Button findChildren = new Button("Find children");
			findChildren.setLayoutX(720);
			findChildren.setLayoutY(350);
			findChildren.setTextFill(Color.CHOCOLATE);
			pane.getChildren().add(findChildren);
			findChildren.setOnAction((ActionEvent a) -> {
				GridPane pane7 = new GridPane();
				TextField firstNameField = new TextField();
				pane7.add(new Label("Full Name:"), 1, 0);
				pane7.add(firstNameField, 2, 0);
				Button btFindChildren = new Button("Find Children");
				pane7.add(btFindChildren, 2, 6);
				Button btBack = new Button("Go Back");
				pane7.add(btBack, 2, 8);
				Scene scene6 = new Scene(pane7, 900, 350);
				primaryStage.setTitle("MiniNet");
				primaryStage.setScene(scene6);
				primaryStage.show();

				btFindChildren.setOnAction((ActionEvent g) -> {

					GridPane pane8 = new GridPane();
					Scene settingsScene = new Scene(pane8, 700, 30);
					Stage popup = new Stage();
					popup.setScene(settingsScene);
					Text reminder = new Text(50, 200,
							"this person's children are:" + gameEngine.findChild(firstNameField.getText()));
					reminder.setFont(Font.font("Courier", FontWeight.THIN, FontPosture.ITALIC, 20));
					reminder.setFill(Color.CHOCOLATE);
					pane8.getChildren().add(reminder);
					popup.show();
				});
				btBack.setOnAction((ActionEvent g) -> {
					primaryStage.setTitle("MiniNet");
					primaryStage.setScene(scene);
					primaryStage.show();
				});
			});
			// all what happen when button 'find parents' is clicked are defined here
			Button findParents = new Button("Find parents ");
			findParents.setLayoutX(720);
			findParents.setLayoutY(400);
			findParents.setTextFill(Color.CHOCOLATE);
			pane.getChildren().add(findParents);
			findParents.setOnAction((ActionEvent a) -> {
				GridPane pane8 = new GridPane();
				TextField firstNameField = new TextField();
				pane8.add(new Label("Full Name:"), 1, 0);
				pane8.add(firstNameField, 2, 0);
				Button btFindParents = new Button("Find Parents");
				pane8.add(btFindParents, 2, 6);
				Button btBack = new Button("Go Back");
				pane8.add(btBack, 2, 8);
				Scene scene6 = new Scene(pane8, 900, 350);
				primaryStage.setTitle("MiniNet");
				primaryStage.setScene(scene6);
				primaryStage.show();

				btFindParents.setOnAction((ActionEvent h) -> {

					GridPane pane9 = new GridPane();
					Scene settingsScene = new Scene(pane9, 700, 30);
					Stage popup = new Stage();
					popup.setScene(settingsScene);
					Text reminder = new Text(50, 200,
							"this person's parents are:" + gameEngine.findParents(firstNameField.getText()));
					reminder.setFont(Font.font("Courier", FontWeight.THIN, FontPosture.ITALIC, 20));
					reminder.setFill(Color.CHOCOLATE);
					pane9.getChildren().add(reminder);
					popup.show();
				});
				btBack.setOnAction((ActionEvent h) -> {
					primaryStage.setTitle("MiniNet");
					primaryStage.setScene(scene);
					primaryStage.show();
				});
			});
		});

	}

	public static void main(String[] args) {
		launch(args);
	}
}
