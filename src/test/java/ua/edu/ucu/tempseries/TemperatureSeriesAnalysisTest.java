// package ua.edu.ucu.tempseries;

// import static org.junit.Assert.*;
// import org.junit.Test;
// import ua.edu.ucu.apps.tempseries.TemperatureSeriesAnalysis;

// public class TemperatureSeriesAnalysisTest {

//     @Test
//     public void test() {
//         double[] temperatureSeries = {-1.0};
//         TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
//         double expResult = -1.0;

//         double actualResult = seriesAnalysis.average();
//         assertEquals(expResult, actualResult, 0.00001);
//     }

//    @Test
//    public void testAverageWithOneElementArray() {
//        // setup input data and expected result
//        double[] temperatureSeries = {-1.0};
//        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
//        double expResult = -1.0;
//
//        // call tested method
//        double actualResult = seriesAnalysis.average();
//
//        // compare expected result with actual result
//        assertEquals(expResult, actualResult, 0.00001);
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    public void testAverageWithEmptyArray() {
//        double[] temperatureSeries = {};
//        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
//
//        // expect exception here
//        seriesAnalysis.average();
//    }
//
//    @Test
//    public void testAverage() {
//        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
//        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
//        double expResult = 1.0;
//
//        double actualResult = seriesAnalysis.average();
//
//        assertEquals(expResult, actualResult, 0.00001);
//    }
    

// }


package ua.edu.ucu.tempseries;

import static org.junit.Assert.*;
import org.junit.Test;
import ua.edu.ucu.apps.tempseries.TemperatureSeriesAnalysis;
import ua.edu.ucu.apps.tempseries.TempSummaryStatistics;

public class TemperatureSeriesAnalysisTest {

    @Test
    public void testAverageWithOneElementArray() {
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;

        double actualResult = seriesAnalysis.average();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAverageWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        seriesAnalysis.average(); // should throw exception
    }

    @Test
    public void testMin() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -5.0;

        double actualResult = seriesAnalysis.min();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testMax() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 5.0;

        double actualResult = seriesAnalysis.max();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempClosestToZero() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 1.0;

        double actualResult = seriesAnalysis.findTempClosestToZero();
        assertEquals(expResult, actualResult, 0.00001);
    }


    @Test
    public void testSummaryStatistics() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        TempSummaryStatistics statistics = seriesAnalysis.summaryStatistics();

        assertEquals(1.0, statistics.getAvgTemp(), 0.00001);
        assertEquals(3.741657, statistics.getDevTemp(), 0.00001);
        assertEquals(-5.0, statistics.getMinTemp(), 0.00001);
        assertEquals(5.0, statistics.getMaxTemp(), 0.00001);
    }
}

