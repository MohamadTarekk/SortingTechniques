package view;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.image.*;
import javafx.stage.Stage;
import javafx.util.Pair;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicReference;
import controller.*;
import model.*;

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
    private Sorter sorter;
    private boolean readyToPlot = false;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        initializeToolbar();

        /*Pane hBox = new Pane();
        hBox.setStyle("-fx-border-width: 2;" + "-fx-border-color:  #C3C3C3;");

        hBox.setPrefWidth(460);
        hBox.setMaxWidth(460);
        hBox.setPrefHeight(360);
        hBox.setMaxHeight(360);
        CardWarp sortingCards = new CardWarp(460, 360);
        hBox.getChildren().removeAll();
        hBox.getChildren().add(sortingCards);
        hBox.setRotate(90);
        sortingCards.setRotate(90);
        //theShow.add(sortingCards, 4, 3);
        */


        /*int[] alpha = new int[1000];
        for (int i = 0; i<460; i++){
            alpha[i] = (int) (Math.random()*360);
        }*/
        //HeapSort s = new HeapSort(alpha);
        //s.sort();
        //alpha = s.getA();
        //ArrayList<Integer> alpha = new ArrayList<>();
        /*alpha.add(13);
        alpha.add(2);
        alpha.add(5);
        alpha.add(64);
        alpha.add(98);
        alpha.add(45);
        alpha.add(22);
        alpha.add(18);
        alpha.add(88);
        alpha.add(8);
        alpha.add(60);
        alpha.add(3);
        alpha.add(15);
        alpha.add(6);
        alpha.add(7);
        alpha.add(7);
        for (int i = 0; i<50; i++){
            alpha.add((int) (Math.random()*100));
        }
        sortingCards.visualize(alpha);
        */
        /*
    	@SuppressWarnings("unused")
        ArrayGenerator generator = new ArrayGenerator(10000);
    	BubbleSort bubbleSort = new BubbleSort(ArrayGenerator.toBeSorted);
    	bubbleSort.sort();
        XYChart.Series<String, Number> coordinate1 = new XYChart.Series<>();
        coordinate1.getData().add(new XYChart.Data<>("0" , 0))	;
        for(int i = 0 ; i < 10 ; i++)
        {
			Pair<Integer, Long> p = (BubbleSort.bubbleNT.get(i));
            coordinate1.getData().add(new XYChart.Data<>(p.getKey().toString(),  p.getValue()));
        }
        coordinate1.setName("Bubble Sort");
        
    	SelectionSort selectionSort = new SelectionSort(ArrayGenerator.toBeSorted);
    	selectionSort.sort();
        XYChart.Series<String, Number> coordinate2 = new XYChart.Series<>();
        coordinate2.getData().add(new XYChart.Data<>("0" , 0))	;
        for(int i = 0 ; i < 10 ; i++)
        {
			Pair<Integer, Long> p = (SelectionSort.selectionNTime.get(i));
            coordinate2.getData().add(new XYChart.Data<>(p.getKey().toString(),  p.getValue()));
        }
        coordinate2.setName("Selection Sort");
        
    	InsertionSort insertionSort = new InsertionSort(ArrayGenerator.toBeSorted);
    	insertionSort.sort();
        XYChart.Series<String, Number> coordinate3 = new XYChart.Series<>();
        coordinate3.getData().add(new XYChart.Data<>("0" , 0))	;
        for(int i = 0 ; i < 10 ; i++)
        {
			Pair<Integer, Long> p = (InsertionSort.insertionNTime.get(i));
            coordinate3.getData().add(new XYChart.Data<>(p.getKey().toString(),  p.getValue()));
        }
        coordinate3.setName("Insertion Sort");

        
    	MergeSort mergeSort = new MergeSort(ArrayGenerator.toBeSorted);
    	mergeSort.sort();
        XYChart.Series<String, Number> coordinate4 = new XYChart.Series<>();
        coordinate4.getData().add(new XYChart.Data<>("0" , 0))	;
        for(int i = 0 ; i < 10 ; i++)
        {
			Pair<Integer, Long> p = (MergeSort.mergeNTime.get(i));
            coordinate4.getData().add(new XYChart.Data<>(p.getKey().toString(),  p.getValue()));
        }
        coordinate4.setName("Merge Sort");
        
    	QuickSort quickSort = new QuickSort(ArrayGenerator.toBeSorted);
    	quickSort.sort();
        XYChart.Series<String, Number> coordinate5 = new XYChart.Series<>();
        coordinate5.getData().add(new XYChart.Data<>("0" , 0))	;
        for(int i = 0 ; i < 10 ; i++)
        {
			Pair<Integer, Long> p = (QuickSort.quickNTime.get(i));
            coordinate5.getData().add(new XYChart.Data<>(p.getKey().toString(),  p.getValue()));
        }
        coordinate5.setName("Quick Sort");

        XYChart.Series<String, Number> rand = new XYChart.Series<>();
        rand.getData().add(new XYChart.Data<>("0" , 0))	;
        for(int i = 0 ; i < 50 ; i++)
        {
            Number a = (int) (Math.random() * 500000000);
            Number number = i*100;
            rand.getData().add(new XYChart.Data<>(number.toString(), a));
        }
        rand.setName("Random");
        chart.getData().add(rand);

        chart.getData().add(coordinate1);
        chart.getData().add(coordinate2);
        chart.getData().add(coordinate3);
        chart.getData().add(coordinate4);
        chart.getData().add(coordinate5);
        */


    }
    public void createSetBtnClicked(){
        if (        createSetText.getText().matches("[0-9]+")
                && !createSetText.getText().isEmpty()
                && !createSetText.getText().equals("0")) {
            int i = Integer.parseInt(createSetText.getText());
            if (i>0) {
                arrayGenerator = new ArrayGenerator(i);
                readyToPlot = true;
                techniqueCmb = initializeComboBox();
                System.out.println("heeeeeeerreeee!!!");
            }
        }
    }

    public void sortBtnClicked(){
        chart.getData().clear();
        String sortingTechnique = techniqueCmb.getValue();
        sortingTechnique = "All";
        if (sortingTechnique.equals("All")){
            sorter = new Sorter(arrayGenerator.getToBeSorted(), "Bubble Sort");
            chart.getData().add(sorter.getCoordinates());
            sorter = new Sorter(arrayGenerator.getToBeSorted(), "Heap Sort");
            chart.getData().add(sorter.getCoordinates());
            sorter = new Sorter(arrayGenerator.getToBeSorted(), "Insertion Sort");
            chart.getData().add(sorter.getCoordinates());
            sorter = new Sorter(arrayGenerator.getToBeSorted(), "Merge Sort");
            chart.getData().add(sorter.getCoordinates());
            sorter = new Sorter(arrayGenerator.getToBeSorted(), "Quick Sort");
            chart.getData().add(sorter.getCoordinates());
            sorter = new Sorter(arrayGenerator.getToBeSorted(), "Selection Sort");
            chart.getData().add(sorter.getCoordinates());
        }else {
            sorter = new Sorter(arrayGenerator.getToBeSorted(), sortingTechnique);
            chart.getData().add(sorter.getCoordinates());
        }
        chart.setVisible(true);
    }

    private ComboBox<String> initializeComboBox() {
        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.getItems().addAll("Bubble Sort", "Heap Sort", "Insertion Sort", "Merge Sort", "Quick Sort", "Selection Sort");
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
