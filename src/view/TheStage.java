package view;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicReference;

import controller.ArrayGenerator;
import controller.Sorter;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class TheStage implements Initializable {

    ////////////////////////////////
    @FXML
    private Pane toolbar1;
    @FXML
    private Pane toolbar2;
    @FXML
    private Pane toolbar3;
    @FXML
    private Pane toolbar5;
    @FXML
    private ImageView closeIcon;
    @FXML
    private ImageView minimizeIcon;
    @FXML
    private ImageView refreshIcon;
    ////////////////////////////////
    @FXML
    private LineChart<String, Number> chart;
    @FXML
    private TextField createSetText;
    @FXML
    private Button createSetBtn;
    @FXML
    private ComboBox<String> techniqueCmb;
    @FXML
    private Button sortBtn;
    ////////////////////////////////
    @FXML
    private Button visualizeBtn;
    ////////////////////////////////
    private ArrayGenerator arrayGenerator;
    private boolean readyToPlot = false;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeToolbar();
        initializeComboBox();
        initializeTextField();
        initializeButtons();
    }

    private void initializeToolbar(){
        initializeToolbarMotion(toolbar1);
        initializeToolbarMotion(toolbar2);
        initializeToolbarMotion(toolbar3);
        initializeToolbarMotion(toolbar5);
        closeIcon.setOnMouseReleased(event -> ((Stage)(closeIcon.getScene().getWindow())).close());
        minimizeIcon.setOnMouseReleased(event -> ((Stage)(minimizeIcon.getScene().getWindow())).setIconified(true));
        refreshIcon.setOnMouseReleased(event -> refreshStage());
    }

    private AtomicReference<Double> xOffset = new AtomicReference<>((double) 0);
    private AtomicReference<Double> yOffset = new AtomicReference<>((double) 0);
    private void initializeToolbarMotion(Pane pane){
        pane.setOnMousePressed(event -> {
            xOffset.set(event.getSceneX());
            yOffset.set(event.getSceneY());
        });
        pane.setOnMouseDragged(event -> {
            pane.getScene().getWindow().setX(event.getScreenX() - xOffset.get());
            pane.getScene().getWindow().setY(event.getScreenY() - yOffset.get());
        });
    }

    private void initializeComboBox() {
        techniqueCmb.getItems().addAll("All Sorting Techniques", "Bubble Sort", "Selection Sort", "Insertion Sort", "Heap Sort", "Merge Sort", "Quick Sort");
        techniqueCmb.getSelectionModel().selectFirst();
    }

    private void initializeTextField(){
        createSetText.textProperty().addListener((ov, oldValue, newValue) -> {
            if (createSetText.getText().length() > 5) {
                String s = createSetText.getText().substring(0, 5);
                createSetText.setText(s);
            }
        });
    }

    private void initializeButtons() {
        createSetBtn.setOnAction(event -> {
            if (        createSetText.getText().matches("[0-9]+")
                    && !createSetText.getText().isEmpty()
                    && !createSetText.getText().equals("0")) {
                int i = Integer.parseInt(createSetText.getText());
                if (i>0) {
                    arrayGenerator = new ArrayGenerator(i);
                    readyToPlot = true;
                    //newSelection = false;
                    //readyToVisualize = false;
                    //techniqueCmb = initializeComboBox();
                    System.out.println("heeeeeeerreeee!!!");
                }
            }
        });
        sortBtn.setOnAction(event -> {
            if (readyToPlot) {
                chart.getData().clear();
                String sortingTechnique = techniqueCmb.getValue();
                Sorter sorter;
                if (sortingTechnique.equals("All Sorting Techniques")) {
                    for (int i=1 ; i<7 ; i++) {
                        sorter = new Sorter(arrayGenerator.getToBeSorted(), techniqueCmb.getItems().get(i));
                        chart.getData().add(sorter.getCoordinates());
                    }
                } else {
                    System.out.println(sortingTechnique);
                    sorter = new Sorter(arrayGenerator.getToBeSorted(), sortingTechnique);
                    chart.getData().add(sorter.getCoordinates());
                }
            }
        });
        visualizeBtn.setOnAction(event -> {
            Path currentRelativePath = Paths.get("");
            String path = currentRelativePath.toAbsolutePath().toString() + "\\src\\view\\TheTrick.fxml";
            System.out.println(path);
            try {
                Parent root = FXMLLoader.load(new File(path).toURI().toURL());
                Stage stage = new Stage();
                stage.setTitle("Visualization");
                stage.setScene(new Scene(root, 600, 400));
                stage.setResizable(false);
                stage.show();
                // Hide this current window (if this is what you want)
                //((Node)(event.getSource())).getScene().getWindow().hide();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void refreshStage() {
    }
}