package rogeraraujo.d_graph_generator;

import org.jzy3d.colors.Color;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import rogeraraujo.d_graph_generator.exceptions.DimensionLimitException;

public class SerieTest extends TestCase {
	/**
     * Serie class tests
     * 
     * @param testName name of the test case
     */
    public SerieTest( String testName ) {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite( SerieTest.class );
    }
    
    public void testClassInstantiation() {
    	double[] values = {0.1, 0.2, 0.3};
    	Color color = Color.MAGENTA;
    	
    	try {
			Serie serie = new Serie(values, color);
			
			assertEquals("Values were defined corretly", values, serie.getValues());
			assertEquals("Color was defined corretly", color, serie.getColor());
		} catch (DimensionLimitException e) {
			e.printStackTrace();
		}
    }
    
    public void testExceptionWhenValuesAreWrong() {
    	double[] values = {0.1, 0.2};
    	Color color = Color.MAGENTA;
    	
    	try {
			new Serie(values, color);
			fail();
		} catch (DimensionLimitException e) {
			assertTrue("Exception was thrown", true);
		}
    }
    
    public void testExceptionWhenValuesAreWrong2() {
    	double[] values = {0.1, 0.2, 0.3, 0.4};
    	Color color = Color.MAGENTA;
    	
    	try {
			new Serie(values, color);
			fail();
		} catch (DimensionLimitException e) {
			assertTrue("Exception was thrown", true);
		}
    }
}
