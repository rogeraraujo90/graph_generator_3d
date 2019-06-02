package rogeraraujo.d_graph_generator;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import rogeraraujo.d_graph_generator.exceptions.DimensionLimitException;

/**
 * Unit test for simple App.
 */
public class DimensionLimitExceptionTest extends TestCase {
    /**
     * DimensionLimitException class tests
     * 
     * @param testName name of the test case
     */
    public DimensionLimitExceptionTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( DimensionLimitExceptionTest.class );
    }

    /**
     * Check if a default message is defined when class is instantiated without a customized message
     */
    public void testDefaultMessage()
    {
    	DimensionLimitException exception = new DimensionLimitException();
    	
        assertEquals("Graph is designed to have 3 dimension only", exception.getMessage());
    }
    
    /**
     * Check if a customized message is defined when class is instantiated with a message
     */
    public void testCustomizedMessage()
    {
    	String customizedMessage = "I am a message";
    	DimensionLimitException exception = new DimensionLimitException(customizedMessage);
    	
        assertEquals(customizedMessage, exception.getMessage());
    }
    
    /**
     * Check if a the class is subclass of Exception
     */
    public void testParent()
    {
    	DimensionLimitException exception = new DimensionLimitException();
    	assertTrue(exception instanceof Exception);
    }
}
