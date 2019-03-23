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
import model.Sorter;

public class TheStage implements Initializable {
	
	private Sorter sorter = new Sorter(100);
	private ArrayList<Long> timeList = Sorter.getTimeList();
	private ArrayList<Integer> nList = Sorter.getnList();


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


        XYChart.Series<String, Number> coordinate1 = new XYChart.Series<>();
        coordinate1.getData().add(new XYChart.Data<>(nList.get(0).toString(), timeList.get(0)));
        coordinate1.getData().add(new XYChart.Data<>(nList.get(1).toString(),  timeList.get(1)));
        coordinate1.getData().add(new XYChart.Data<>(nList.get(2).toString(),  timeList.get(2)));
        coordinate1.getData().add(new XYChart.Data<>(nList.get(3).toString(),  timeList.get(3)));
        coordinate1.getData().add(new XYChart.Data<>(nList.get(4).toString(),  timeList.get(4)));
        coordinate1.getData().add(new XYChart.Data<>(nList.get(5).toString(),  timeList.get(5)));
        coordinate1.getData().add(new XYChart.Data<>(nList.get(6).toString(), timeList.get(6)));
        coordinate1.getData().add(new XYChart.Data<>(nList.get(7).toString(),  timeList.get(7)));
        coordinate1.getData().add(new XYChart.Data<>(nList.get(8).toString(),  timeList.get(8)));
        coordinate1.getData().add(new XYChart.Data<>(nList.get(9).toString(),  timeList.get(9)));
        
        coordinate1.setName("Bubble Sort");

        /*
        XYChart.Series<String, Number> coordinate2 = new XYChart.Series<>();
        coordinate2.getData().add(new XYChart.Data<>("1", 12));
        coordinate2.getData().add(new XYChart.Data<>("2", 0));
        coordinate2.getData().add(new XYChart.Data<>("3", 64));
        coordinate2.getData().add(new XYChart.Data<>("4", 38));
        coordinate2.getData().add(new XYChart.Data<>("5", 29));
        coordinate2.getData().add(new XYChart.Data<>("6", 25));
        coordinate2.getData().add(new XYChart.Data<>("7", 64));
        coordinate2.getData().add(new XYChart.Data<>("8", 40));
        coordinate2.setName("Selection Sort");
        XYChart.Series<String, Number> coordinate3 = new XYChart.Series<>();
        coordinate3.getData().add(new XYChart.Data<>("1", 40));
        coordinate3.getData().add(new XYChart.Data<>("2", 2));
        coordinate3.getData().add(new XYChart.Data<>("3", 56));
        coordinate3.getData().add(new XYChart.Data<>("4", 78));
        coordinate3.getData().add(new XYChart.Data<>("5", 30));
        coordinate3.getData().add(new XYChart.Data<>("6", 49));
        coordinate3.getData().add(new XYChart.Data<>("7", 25));
        coordinate3.getData().add(new XYChart.Data<>("8", 65));
        coordinate3.setName("Insertion Sort");
        XYChart.Series<String, Number> coordinate4 = new XYChart.Series<>();
        coordinate4.getData().add(new XYChart.Data<>("1", 88));
        coordinate4.getData().add(new XYChart.Data<>("2", 13));
        coordinate4.getData().add(new XYChart.Data<>("3", 94));
        coordinate4.getData().add(new XYChart.Data<>("4", 72));
        coordinate4.getData().add(new XYChart.Data<>("5", 63));
        coordinate4.getData().add(new XYChart.Data<>("6", 4));
        coordinate4.getData().add(new XYChart.Data<>("7", 24));
        coordinate4.getData().add(new XYChart.Data<>("8", 50));
        coordinate4.setName("Merge Sort");
        XYChart.Series<String, Number> coordinate5 = new XYChart.Series<>();
        coordinate5.getData().add(new XYChart.Data<>("1", 3));
        coordinate5.getData().add(new XYChart.Data<>("2", 95));
        coordinate5.getData().add(new XYChart.Data<>("3", 10));
        coordinate5.getData().add(new XYChart.Data<>("4", 47));
        coordinate5.getData().add(new XYChart.Data<>("5", 63));
        coordinate5.getData().add(new XYChart.Data<>("6", 75));
        coordinate5.getData().add(new XYChart.Data<>("7", 13));
        coordinate5.getData().add(new XYChart.Data<>("8", 10));
        coordinate5.setName("Quick Sort");
        XYChart.Series<String, Number> coordinate6 = new XYChart.Series<>();
        coordinate6.getData().add(new XYChart.Data<>("1", 87));
        coordinate6.getData().add(new XYChart.Data<>("2", 32));
        coordinate6.getData().add(new XYChart.Data<>("3", 6));
        coordinate6.getData().add(new XYChart.Data<>("4", 15));
        coordinate6.getData().add(new XYChart.Data<>("5", 40));
        coordinate6.getData().add(new XYChart.Data<>("6", 30));
        coordinate6.getData().add(new XYChart.Data<>("7", 21));
        coordinate6.getData().add(new XYChart.Data<>("8", 8));
        coordinate6.setName("Heap Sort");
        chart.getData().add(coordinate1);
        chart.getData().add(coordinate2);
        chart.getData().add(coordinate3);
        chart.getData().add(coordinate4);
        chart.getData().add(coordinate5);
        chart.getData().add(coordinate6);*/
        
        chart.getData().add(coordinate1);

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
