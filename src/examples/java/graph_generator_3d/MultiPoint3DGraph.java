package graph_generator_3d;

import org.jzy3d.colors.Color;

import rogeraraujo.d_graph_generator.ScatterGraph;
import rogeraraujo.d_graph_generator.Serie;
import rogeraraujo.d_graph_generator.exceptions.DimensionLimitException;

public class MultiPoint3DGraph {
	public static void main(String[] args) {
		int numberOfPoints = 250000;
		
		Serie[] series = new Serie[numberOfPoints];
		float r = 255;
		float g = 0;
		float b = 0;
		
		int colorStep = 0;
		double colorStepControl = 0;
		int valueStepControl = 1;
		
		for (int index = 0; index < numberOfPoints; index++) {
			double v1 = Math.random() * 6;
			double v2 = Math.random() * 6;
			double v3 = Math.random() * (valueStepControl - (valueStepControl - 1)) + (valueStepControl - 1);
			
			if (colorStepControl * 163.398692810458 >= 1) {
				colorStep += 1;
				colorStepControl = 0;
				
				if (colorStep < 20833) {
					g += 1;
				} else if (colorStep >= 20833 && colorStep < 41666) {
					r -= 1;
					valueStepControl = 2;
				} else if (colorStep >= 41666 && colorStep < 62500) {
					b += 1;
					valueStepControl = 3;
				} else if (colorStep >= 62500 && colorStep < 83333) {
					g -= 1;
					valueStepControl = 4;
				} else if (colorStep >= 83333 && colorStep < 104166) {
					r += 1;
					valueStepControl = 5;
				} else if (colorStep > 104166) {
					b -= 1;
					valueStepControl = 6;
				}
			} else {
				colorStepControl += 0.00612;
			}
			
			double[] values = {v1, v2, v3};
			
			Color color = new Color(r, g, b);
			
			try {
				Serie serie = new Serie(values, color);
				series[index] = serie;
			} catch (DimensionLimitException e) { e.printStackTrace(); };
		}
		
		ScatterGraph graph = new ScatterGraph(series);
		graph.open();
	}
}
