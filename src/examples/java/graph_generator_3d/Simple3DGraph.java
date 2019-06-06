package graph_generator_3d;

import org.jzy3d.colors.Color;

import rogeraraujo.d_graph_generator.ScatterGraph;
import rogeraraujo.d_graph_generator.Serie;
import rogeraraujo.d_graph_generator.exceptions.DimensionLimitException;

public class Simple3DGraph {
	public static void main(String[] args) {
		double[] serie1Values = {1, 2, 1};
		double[] serie2Values = {1, 2, 2};
		double[] serie3Values = {2, 1, 2};
		double[] serie4Values = {3, 2, 1};
		double[] serie5Values = {3, 3, 3};
		
		Color serie1Color = Color.BLUE;
		Color serie2Color = Color.GREEN;
		Color serie3Color = Color.RED;
		Color serie4Color = Color.CYAN;
		Color serie5Color = Color.MAGENTA;
		
		try {
			Serie serie1 = new Serie(serie1Values, serie1Color);
			Serie serie2 = new Serie(serie2Values, serie2Color);
			Serie serie3 = new Serie(serie3Values, serie3Color);
			Serie serie4 = new Serie(serie4Values, serie4Color);
			Serie serie5 = new Serie(serie5Values, serie5Color);
			
			Serie[] series = {serie1, serie2, serie3, serie4, serie5};
			
			ScatterGraph graph = new ScatterGraph(series, 10);
			
			graph.open();
		} catch (DimensionLimitException e) {
			System.out.println("this should not be happening... :(");
		}
	}
}
