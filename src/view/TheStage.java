package view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicReference;

public class TheStage implements Initializable {

    @FXML
    private LineChart<String, Number> chart;

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        initializeToolbar(toolbar1);
        initializeToolbar(toolbar2);
        initializeToolbar(toolbar3);
        initializeToolbar(toolbar4);
        close.setOnMouseReleased(event -> {
            ((Stage)(close.getScene().getWindow())).close();
        });
        

        XYChart.Series<String, Number> coordinate1 = new XYChart.Series<>();
        coordinate1.getData().add(new XYChart.Data<>("1", 23));
        coordinate1.getData().add(new XYChart.Data<>("2", 3));
        coordinate1.getData().add(new XYChart.Data<>("3", 52));
        coordinate1.getData().add(new XYChart.Data<>("4", 36));
        coordinate1.getData().add(new XYChart.Data<>("5", 49));
        coordinate1.getData().add(new XYChart.Data<>("6", 15));
        coordinate1.getData().add(new XYChart.Data<>("7", 69));
        coordinate1.getData().add(new XYChart.Data<>("8", 48));
        coordinate1.setName("Bubble Sort");
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
        chart.getData().add(coordinate6);
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
