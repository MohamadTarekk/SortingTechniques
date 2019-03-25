package view;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicReference;

import controller.ArrayGenerator;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import controller.Sorter;

public class TheStage implements Initializable {

    ////////////////////////////////
    @FXML
    private GridPane theShowGrid;
    ////////////////////////////////
    @FXML
    private Pane toolbar1;
    @FXML
    private Pane toolbar2;
    @FXML
    private Pane toolbar3;
    @FXML
    private Pane toolbar4;
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
    private ComboBox<String> visualCmb;
    @FXML
    private Button visualizeBtn;
    ////////////////////////////////
    @FXML
    private Label label1;
    @FXML
    private Label label2;
    @FXML
    private ImageView sortingHat;

    ////////////////////////////////
    private ArrayGenerator arrayGenerator;
    private boolean readyToPlot = false;
    private boolean readyToVisualize = false;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        initializeToolbar();
    }

    public void createSetBtnClicked(){
        if (        createSetText.getText().matches("[0-9]+")
                && !createSetText.getText().isEmpty()
                && !createSetText.getText().equals("0")) {
            int i = Integer.parseInt(createSetText.getText());
            if (i>0) {
                arrayGenerator = new ArrayGenerator(i);
                readyToPlot = true;
                readyToVisualize = false;
                techniqueCmb = initializeComboBox();
                System.out.println("heeeeeeerreeee!!!");
            }
        }
    }

    public void sortBtnClicked(){
        if (readyToPlot) {
            chart.getData().clear();
            String sortingTechnique = techniqueCmb.getItems().get(0);
            Sorter sorter;
            if (sortingTechnique.equals("All")) {
                for (int i=1 ; i<7 ; i++) {
                    sorter = new Sorter(arrayGenerator.getToBeSorted(), techniqueCmb.getItems().get(i));
                    chart.getData().add(sorter.getCoordinates());
                }
            } else {
                sorter = new Sorter(arrayGenerator.getToBeSorted(), sortingTechnique);
                chart.getData().add(sorter.getCoordinates());
            }
            readyToPlot = false;
            readyToVisualize = true;
        }
    }

    public void visualizeBtnClicked(){
                /*Pane hBox = new Pane();
        hBox.setStyle("-fx-border-width: 2;" + "-fx-border-color:  #C3C3C3;");

        hBox.setPrefWidth(460);
        hBox.setMaxWidth(460);
        hBox.setPrefHeight(360);
        hBox.setMaxHeight(360);
        CardWarp sortingCards = new CardWarp(460, 360);
        hBox.getChildren().removeAll();
        hBox.getChildren().add(sortingCards);
        hBox.setRotate(180);
        theShow.add(hBox, 3, 3);
        hBox.setRotate(90);
        sortingCards.setRotate(90);
        //theShow.add(sortingCards, 4, 3);
        */
    }

    private ComboBox<String> initializeComboBox() {
        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.getItems().addAll("All", "Bubble Sort", "Heap Sort", "Insertion Sort", "Merge Sort", "Quick Sort", "Selection Sort");
        return comboBox;
    }

    private void initializeToolbar(){
        initializeToolbarMotion(toolbar1);
        initializeToolbarMotion(toolbar2);
        initializeToolbarMotion(toolbar3);
        initializeToolbarMotion(toolbar4);
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

    private void refreshStage() {
    }
}