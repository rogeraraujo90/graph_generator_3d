package rogeraraujo.d_graph_generator;

import org.jzy3d.colors.Color;
import org.jzy3d.maths.Coord3d;
import org.jzy3d.plot3d.primitives.Scatter;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import rogeraraujo.d_graph_generator.exceptions.DimensionLimitException;

public class ScatterGraphTest extends TestCase {
	/**
     * ScatterGraph class tests
     * 
     * @param testName name of the test case
     */
    public ScatterGraphTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( ScatterGraphTest.class );
    }
    
    public void testDefautValues() throws DimensionLimitException {
    	Serie[] series = new Serie[1];
    	double[] serieValues = {0, 0, 0};
    	
    	Serie serie = new Serie(serieValues);
    	series[0] = serie;
    	
    	ScatterGraph graph = new ScatterGraph(series);
    	
    	assertEquals("Series were correctly defined", series, graph.getSeries());
    	
    	String[] axis = graph.getAxis();
    	
    	assertEquals("XAxis were correctly defined", "x", axis[0]);
    	assertEquals("YAxis were correctly defined", "y", axis[1]);
    	assertEquals("ZAxis were correctly defined", "z", axis[2]);
    	
    	assertEquals("Width was correctly defined", 0, graph.getWidth());
    }
    
    public void testCustomizedAxis() throws DimensionLimitException {
    	Serie[] series = new Serie[1];
    	double[] serieValues = {0, 0, 0};
    	
    	Serie serie = new Serie(serieValues);
    	series[0] = serie;
    	String[] customizedAxis = {"a", "b", "c"};
    	
    	ScatterGraph graph = new ScatterGraph(series, customizedAxis);
    	
    	assertEquals("Series were correctly defined", series, graph.getSeries());
    	
    	String[] axis = graph.getAxis();
    	
    	assertEquals("XAxis were correctly defined", "a", axis[0]);
    	assertEquals("YAxis were correctly defined", "b", axis[1]);
    	assertEquals("ZAxis were correctly defined", "c", axis[2]);
    	
    	assertEquals("Width was correctly defined", 0, graph.getWidth());
    }
    
    public void testCustomizedAxisFails(){
    	Serie[] series = new Serie[1];
    	String[] customizedAxis = {"a", "b"};
    	
		try {
			new ScatterGraph(series, customizedAxis);
			fail();
		} catch (DimensionLimitException e) {
			assertTrue("Exception was thrown", true);
		}
    }
    
    public void testCustomizedAxisAndWidth() throws DimensionLimitException {
    	Serie[] series = new Serie[1];
    	double[] serieValues = {0, 0, 0};
    	
    	Serie serie = new Serie(serieValues);
    	series[0] = serie;
    	
    	String[] customizedAxis = {"a", "b", "c"};
    	int width = 2;
    	
    	ScatterGraph graph = new ScatterGraph(series, customizedAxis, 2);
    	
    	assertEquals("Series were correctly defined", series, graph.getSeries());
    	
    	String[] axis = graph.getAxis();
    	
    	assertEquals("XAxis were correctly defined", "a", axis[0]);
    	assertEquals("YAxis were correctly defined", "b", axis[1]);
    	assertEquals("ZAxis were correctly defined", "c", axis[2]);
    	
    	assertEquals("Width was correctly defined", width, graph.getWidth());
    }
    
    public void testCustomizedAxisAndWidthFails() throws DimensionLimitException {
    	Serie[] series = new Serie[1];
    	String[] customizedAxis = {"a", "b"};
    	int width = 2;
    	
    	try {
    		new ScatterGraph(series, customizedAxis, width);
			fail();
		} catch (DimensionLimitException e) {
			assertTrue("Exception was thrown", true);
		}
    }
    
    public void testCustomizedWidth() throws DimensionLimitException {
    	Serie[] series = new Serie[1];
    	double[] serieValues = {0, 0, 0};
    	
    	Serie serie = new Serie(serieValues);
    	series[0] = serie;
    	int width = 2;
    	
    	ScatterGraph graph = new ScatterGraph(series, 2);
    	
    	assertEquals("Series were correctly defined", series, graph.getSeries());
    	
    	String[] axis = graph.getAxis();
    	
    	assertEquals("XAxis were correctly defined", "x", axis[0]);
    	assertEquals("YAxis were correctly defined", "y", axis[1]);
    	assertEquals("ZAxis were correctly defined", "z", axis[2]);
    	
    	assertEquals("Width was correctly defined", width, graph.getWidth());
    }
    
    public void testChartBuild() throws DimensionLimitException {
    	double[] serie1Values = {1, 2, 3};
    	double[] serie2Values = {4, 5, 6};
    	double[] serie3Values = {7, 8, 9};
    	
    	Color serie1Color = Color.GREEN;
    	Color serie2Color = Color.YELLOW;
    	Color serie3Color = Color.BLUE;
    	
    	Serie serie1 = new Serie(serie1Values, serie1Color);
    	Serie serie2 = new Serie(serie2Values, serie2Color);
    	Serie serie3 = new Serie(serie3Values, serie3Color);
    	
    	Serie[] series = {serie1, serie2, serie3};
    	String[] customizedAxis = {"a", "b", "c"};
    	int width = 2;
    	
    	ScatterGraph graph = new ScatterGraph(series, customizedAxis, width);
    	graph.init();
    	
    	Scatter chart = graph.getGraph();
    	
    	assertNotNull("The chart was defined", chart);
    	
    	Coord3d[] coordinates = chart.coordinates;
    	Color[] colors = chart.colors;
    	
    	assertEquals("The number of series is correct", 3, coordinates.length);
    	assertEquals("The number of colors is correct", 3, colors.length);
    	
    	for (int index = 0; index < 3; index++) {
    		Serie serie = series[index];
    		double[] serieValues = serie.getValues();
    		Color serieColor = serie.getColor();
    		
    		Coord3d coordinate = coordinates[index];
    		Color chartColor = colors[index];
    		
    		assertEquals("x point was correctly defined", (float) serieValues[0], coordinate.x);
    		assertEquals("y point was correctly defined", (float) serieValues[1], coordinate.y);
    		assertEquals("z point was correctly defined", (float) serieValues[2], coordinate.z);
    		
    		assertEquals("r color was defined correctly", serieColor.r, chartColor.r);
    		assertEquals("g color was defined correctly", serieColor.g, chartColor.g);
    		assertEquals("b color was defined correctly", serieColor.b, chartColor.b);
    	}
    }
}
