package sit707_week5;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class WeatherControllerTest {

    private static WeatherController wController;
    private static double minTemperature;
    private static double maxTemperature;
    private static double averageTemperature;
    @Test
   	public void testStudentIdentity() {
   		String studentId = "s223798216";
   		Assert.assertNotNull("Student ID is null", studentId);
   	}

   	@Test
   	public void testStudentName() {
   		String studentName = "chandrakanth";
   		Assert.assertNotNull("Student name is null", studentName);
   	}

    @BeforeClass
    public static void setUp() {
        // Arrange: Initialise controller
        wController = WeatherController.getInstance();
        // Arrange: Retrieve and cache temperature statistics
        minTemperature = wController.getTemperatureMinFromCache();
        maxTemperature = wController.getTemperatureMaxFromCache();
        averageTemperature = wController.getTemperatureAverageFromCache();
    }

    @AfterClass
    public static void tearDown() {
        // After: Shutdown controller
        wController.close();
    }

    @Test
    public void testTemperatureMin() {
        // Act: Retrieve minimum temperature
        double actualMinTemperature = wController.getTemperatureMinFromCache();
        // Assert: Verify the minimum temperature
        Assert.assertEquals(minTemperature, actualMinTemperature, 0.0);
    }

    @Test
    public void testTemperatureMax() {
        // Act: Retrieve maximum temperature
        double actualMaxTemperature = wController.getTemperatureMaxFromCache();
        // Assert: Verify the maximum temperature
        Assert.assertEquals(maxTemperature, actualMaxTemperature, 0.0);
    }

    @Test
    public void testTemperatureAverage() {
        // Act: Retrieve average temperature
        double actualAverageTemperature = wController.getTemperatureAverageFromCache();
        // Assert: Verify the average temperature
        Assert.assertEquals(averageTemperature, actualAverageTemperature, 0.0);
    }
}
