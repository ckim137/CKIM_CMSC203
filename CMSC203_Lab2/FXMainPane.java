import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {

	//student Task #2:
	//  declare five buttons, a label, and a textfield
	private Button button1;
	private Button button2;
	private Button button3;
	private Button button4;
	private Button button5;
	
	private Label messageLabel;
	private TextField myTextField = new TextField();
	
	//  declare two HBoxes
	private HBox hbox1;
	private HBox hbox2;
	//student Task #4:
	//  declare an instance of DataManager
	DataManager manageData;

	FXMainPane() {
		//student Task #2:
		//  instantiate the buttons, label, and textfield
		button1 = new Button("Hello");
		button2 = new Button("Howdy");
		button3 = new Button("Chinese");
		button4 = new Button("Clear");
		button5 = new Button("Exit");
		
		messageLabel = new Label("Feedback: ");		
		myTextField = new TextField();
		//  instantiate the HBoxes
		hbox1 = new HBox();
		hbox2 = new HBox();
		
		//student Task #4:
		//  instantiate the DataManager instance
		manageData = new DataManager();
		//  set margins and set alignment of the components
		HBox.setMargin(button1, new Insets(10));
		HBox.setMargin(button2, new Insets(10));
		HBox.setMargin(button3, new Insets(10));
		HBox.setMargin(button4, new Insets(10));
		HBox.setMargin(button5, new Insets(10));
		HBox.setMargin(messageLabel, new Insets(10));
		HBox.setMargin(myTextField, new Insets(10));
		hbox1.setAlignment(Pos.CENTER);
		hbox2.setAlignment(Pos.CENTER);
		//student Task #3:
		//  add the label and textfield to one of the HBoxes
		hbox1.getChildren().addAll(messageLabel, myTextField);

		//  add the buttons to the other HBox
		hbox2.getChildren().addAll(button1, button2, button3, button4, button5);
		//  add the HBoxes to this FXMainPanel (a VBox)
		getChildren().addAll(hbox2, hbox1);
		
		//registering each button with ButtonHandler
		button1.setOnAction(new ButtonHandler());
		button2.setOnAction(new ButtonHandler());
		button3.setOnAction(new ButtonHandler());
		button4.setOnAction(new ButtonHandler());
		button5.setOnAction(new ButtonHandler());
		
	}
	
	//Task #4:
	//  create a private inner class to handle the button clicks
	class ButtonHandler implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent event)
		{
			if(event.getTarget() == button1) 
			{
				myTextField.setText(manageData.getHello());
			}
			else if(event.getTarget() == button2)
			{
				myTextField.setText(manageData.getHowdy());
			}
			else if(event.getTarget() == button3)
			{
				myTextField.setText(manageData.getChinese());
			}
			else if(event.getTarget() == button4)
			{
				myTextField.setText("");
			}
			else if(event.getTarget() == button5)
			{
				Platform.exit();
				System.exit(0);
			}
		}
	}
}
	
