package view;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicReference;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Pair;
import model.ArrayGenerator;
import model.BubbleSort;
import model.InsertionSort;
import model.MergeSort;
import model.QuickSort;
import model.SelectionSort;

public class TheStage implements Initializable {
	

    @FXML
    private LineChart<String, Number> chart;

    @FXML
    private GridPane theShow;

    @FXML
    private Pane toolbar1;
    @FXML
    private Pane toolbar2;
    @FXML
    private Pane toolbar3;
    @FXML
    private Pane toolbar4;
    @FXML
    private Pane close;

    /*@FXML
    private ImageView header1;
    @FXML
    private ImageView header2;*/

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        HBox hBox = new HBox();
        hBox.setStyle("-fx-border-width: 2;" + "-fx-border-color:  #C3C3C3;");
        CardWarp sortingCards = new CardWarp(500, 500);
        hBox.getChildren().add(sortingCards);
        theShow.add(hBox, 3, 3);
        initializeToolbar(toolbar1);
        initializeToolbar(toolbar2);
        initializeToolbar(toolbar3);
        initializeToolbar(toolbar4);
        close.setOnMouseReleased(event -> ((Stage)(close.getScene().getWindow())).close());

        ArrayList<Integer> alpha = new ArrayList<>();
        alpha.add(13);
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
        sortingCards.visualSort(alpha);
        
        
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

        
        chart.getData().add(coordinate1);
        chart.getData().add(coordinate2);
        chart.getData().add(coordinate3);
        chart.getData().add(coordinate4);
        chart.getData().add(coordinate5);



    }

    private AtomicReference<Double> xOffset = new AtomicReference<>((double) 0);
    private AtomicReference<Double> yOffset = new AtomicReference<>((double) 0);
    private void initializeToolbar(Pane pane){
        pane.setOnMousePressed(event -> {
            xOffset.set(event.getSceneX());
            yOffset.set(event.getSceneY());
        });
        pane.setOnMouseDragged(event -> {
            pane.getScene().getWindow().setX(event.getScreenX() - xOffset.get());
            pane.getScene().getWindow().setY(event.getScreenY() - yOffset.get());
        });
    }
}
