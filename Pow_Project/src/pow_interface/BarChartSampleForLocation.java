package pow_interface;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class BarChartSampleForLocation extends Application {

	@Override
	public void start(Stage stage) {
                //Platform.setImplicitExit(false);
		stage.setTitle("Graph for " + POW_Home.graphData[0][POW_Home.graphData[0].length - 1]);
		final CategoryAxis xAxis = new CategoryAxis();
		final NumberAxis yAxis = new NumberAxis();
		final BarChart<String, Number> bc = new BarChart<>(xAxis, yAxis);
		xAxis.setAnimated(false); 
		yAxis.setAnimated(false);
		
		int n = POW_Home.graphData[0].length - 1;

		bc.setTitle(POW_Home.graphData[0][n]);
		xAxis.setLabel("Bird");
		yAxis.setLabel("Annual Population Percent Change");

		
		boolean use = true;
		String bird = "";
		double trend = 0;


		XYChart.Series series1 = new XYChart.Series();
		series1.setName(POW_Home.graphData[0][n]);
		//series1.getData().add(new XYChart.Data("location", 50));

		for (int j = 0; j < POW_Home.graphData[0].length - 2; j++) {
			for (int i = 0; i < 2; i++) {
				if (use == true) {
					bird = POW_Home.graphData[i][j];
				} else {
					trend = Double.parseDouble(POW_Home.graphData[i][j]);
					series1.getData().add(new XYChart.Data(bird, trend));
				}
				use = false;
			}
			use = true; 
		}

		Scene scene = new Scene(bc, 800, 600);
		bc.getData().addAll(series1);
		stage.setScene(scene);
		stage.show();
	}

}