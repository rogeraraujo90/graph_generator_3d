package rogeraraujo.d_graph_generator;

import org.jzy3d.colors.Color;

import rogeraraujo.d_graph_generator.exceptions.DimensionLimitException;

/**
 * Represents a set of data with value and color to be plotted.
 * 
 * @author Róger Araújo
 */
public class Serie {
	/**
	 * An array of values to plot.
	 */
	private double[] values;
	
	/**
	 * A Color from jzy3d.
	 * @see Color
	 */
	private Color color;
	
	public Serie(double[] values, Color color) throws DimensionLimitException {
		if (values.length != 3) {
			throw new DimensionLimitException();
		}
		
		this.values = values;
		this.color = color;
	}

	public double[] getValues() {
		return values;
	}

	public Color getColor() {
		return color;
	}
}
