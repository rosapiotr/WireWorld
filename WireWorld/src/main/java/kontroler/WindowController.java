package kontroler;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.util.StringConverter;
import javafx.util.converter.IntegerStringConverter;
import main.Animation;
import main.Read;
import main.ReadFile;

public class WindowController implements Initializable {

	private Animation animation;
	private Read read;
	private BooleanProperty buttonsProperty = new SimpleBooleanProperty(true);
	private BooleanProperty disableSaveProperty = new SimpleBooleanProperty(true);
	private boolean isPlaying = false; // potrzebne aby po dwukrotnym kliknieciu Start nie ponawiac

	@FXML
	private StackPane mainStackPane;

	@FXML
	private ToggleButton Start;

	@FXML
	private Button Stop;

	@FXML
	private ToggleButton Pause;

	@FXML
	private TextField Quantity;

	@FXML
	private ToggleGroup playpause;

	@FXML
	private Button Save;

	@FXML
	private Slider Speed;

	@FXML
	private Button Choose;

	@FXML
	private Label Selected;

	@FXML
	private void choose(ActionEvent event) {

		FileChooser fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().addAll(new ExtensionFilter("txt Files", "*.txt"));
		File selectedFile = fileChooser.showOpenDialog(null);
		try {
			Selected.setText(selectedFile.getAbsolutePath());

			ReadFile readFile = new ReadFile(selectedFile);

			read = new Read(readFile.read());

			animation.setTab(read.read()); // getter/setter!

			Quantity.setDisable(false);

			Save.disableProperty().bind(disableSaveProperty);

			Pause.setSelected(false);
			Start.setSelected(false);
		} catch (NullPointerException e) {

		}
	}

	@FXML
	private void number(ActionEvent event) {
		animation.setQuantity(Integer.parseInt(Quantity.getText()));
	}

	@FXML
	private void play(ActionEvent event) {
		if (!isPlaying) {
			animation.fill();
			isPlaying = true;
			Quantity.setEditable(false);
		}
		buttonsProperty.unbind();
		Start.setSelected(true);
	}

	@FXML
	private void pause(ActionEvent event) {
		try {
			animation.pause();
		} catch (NullPointerException e) {

		}
		isPlaying = false;
		Quantity.setEditable(true);
		Pause.setSelected(true);
	}

	@FXML
	private void stop(ActionEvent event) {

		buttonsProperty.bind(animation.getQuantity().isEqualTo(0));
		animation.pause();
		Pause.setSelected(false);
		Start.setSelected(false);
		animation.getLogic().clear();
		Selected.setText("");
		Quantity.setText("");
		Quantity.setDisable(true);
		Save.disableProperty().unbind();
		Save.setDisable(true);
		isPlaying = false;
		Quantity.setEditable(true);
	}

	@FXML
	private void save(ActionEvent event) {
		main.Save.save(read, animation);
		NowyDialog.saveDialog();
	}

	@FXML
	private void speed(MouseEvent event) {

		animation.speedProperty().bind(new SimpleDoubleProperty(0.25).divide(Speed.valueProperty()));
		if (Start.isSelected()) {
			try {
				animation.pause();
				animation.fill();
			} catch (NullPointerException e) {

			}
		}
	}

	@FXML
	private void showInformation(ActionEvent event) {
		NowyDialog.informationDialog();
	}

	public void initialize(URL location, ResourceBundle resources) {

		GridPane root = makeGridPane();
		mainStackPane.getChildren().add(root);

		animation = new Animation(root);

		StringConverter converter = new IntegerStringConverter();

		Quantity.textProperty().bindBidirectional(animation.getQuantity(), converter);
		Quantity.setText("");
		Quantity.setDisable(true);
		Start.disableProperty().bind(buttonsProperty);
		Pause.disableProperty().bind(buttonsProperty);
		Stop.disableProperty().bind(buttonsProperty);
		Speed.disableProperty().bind(buttonsProperty);
		buttonsProperty.bind(animation.getQuantity().isEqualTo(0));
		Save.setDisable(true);
		disableSaveProperty.bind(Start.selectedProperty());
	}

	private GridPane makeGridPane() {

		GridPane root = new GridPane();
		root.setMaxWidth(600);
		root.setMaxHeight(600);

		for (int i = 0; i < 50; i++) {
			ColumnConstraints colConst = new ColumnConstraints();
			colConst.setPercentWidth(100.0 / 50);
			root.getColumnConstraints().add(colConst);
		}
		for (int i = 0; i < 50; i++) {
			RowConstraints rowConst = new RowConstraints();
			rowConst.setPercentHeight(100.0 / 50);
			root.getRowConstraints().add(rowConst);
		}
		return root;
	}
}
