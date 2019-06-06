package rogeraraujo.d_graph_generator;

import org.jzy3d.analysis.AbstractAnalysis;
import org.jzy3d.analysis.AnalysisLauncher;
import org.jzy3d.chart.factories.AWTChartComponentFactory;
import org.jzy3d.colors.Color;
import org.jzy3d.maths.Coord3d;
import org.jzy3d.plot3d.primitives.Scatter;
import org.jzy3d.plot3d.rendering.canvas.Quality;

import rogeraraujo.d_graph_generator.exceptions.DimensionLimitException;

/**
 * A 3D graph plotted using jzy3d 
 * 
 * @author Róger Araújo
 *
 */
public class ScatterGraph extends AbstractAnalysis
{
	/**
	 * An array containing all series to be plotted
	 * @see Serie
	 */
	private Serie[] series = {};
	
	/**
	 * An array of strings representing The axis' labels. (x, y, z)
	 */
	private String[] axis = {"x", "y", "z"};
	
	/**
	 * The pretended width to the graph.
	 */
	private int width;
	
	/**
	 * The graph from jzy3d rendered.
	 * @see Scatter
	 */
	private Scatter graph;
	
	public ScatterGraph(Serie[] series) {
		super();
		this.series = series;
		draw();
	}
	
	public ScatterGraph(Serie[] series, String[] axis) throws DimensionLimitException {
		super();
		
		setAxis(axis);
		this.series = series;
		draw();
	}

	public ScatterGraph(Serie[] series, int width) {
		super();
		this.series = series;
		this.width = width;
		draw();
	}

	public ScatterGraph(Serie[] series, String[] axis, int width) throws DimensionLimitException {
		super();
		this.series = series;
		this.width = width;
		setAxis(axis);
		draw();
	}
	
	private void setAxis(String[] axis) throws DimensionLimitException {
		if (axis.length != 3) {
			throw new DimensionLimitException();
		}
		
		this.axis = axis;
	}
	
	/**
	 * Builds a Scatter chart based on Graph informations
	 */
	private void buildChart() {
		int seriesSize = this.series.length;
		Coord3d[] points = new Coord3d[seriesSize];
		Color[] colors = new Color[seriesSize];
		
		for (int index = 0; index < this.series.length; index++) {
			Serie serie = this.series[index];
			double[] values = serie.getValues();
			Color color = serie.getColor();
			
			points[index] = new Coord3d(values[0], values[1], values[2]);
			colors[index] = new Color(color.r, color.g, color.b);
		}
        
        this.graph = new Scatter(points, colors, width);
	}

	@Override
	public void init() {
		buildChart();	
	}
	
	/**
	 * Configures the chart according data 
	 */
	private void draw()
	{
		this.init();
		
		chart = AWTChartComponentFactory.chart(Quality.Advanced, "newt");
        chart.getScene().add(this.graph);
        chart.getAxeLayout().setXAxeLabel(this.axis[0]);
        chart.getAxeLayout().setYAxeLabel(this.axis[1]);
        chart.getAxeLayout().setZAxeLabel(this.axis[2]);
	}
	
	/**
	 * Open the chart in a new java app window
	 */
	public void open()
	{
        try {
			AnalysisLauncher.open(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Serie[] getSeries() {
		return series;
	}

	public int getWidth() {
		return width;
	}

	public Scatter getGraph() {
		return graph;
	}

	public String[] getAxis() {
		return axis;
	}
}
