package ua.edu.ucu.apps.tempseries;

import java.util.ArrayList;

public class TemperatureSeriesAnalysis {
    private double[] temperatureSeries;

    public TemperatureSeriesAnalysis() {
        this.temperatureSeries = new double[0];
    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        this.temperatureSeries = temperatureSeries;
    }

    public double average() {
        if (temperatureSeries.length == 0) {
            throw new IllegalArgumentException("Temperature series is empty");
        }
        double sum = 0;
        for (double temp : temperatureSeries) {
            sum += temp;
        }
        return sum / temperatureSeries.length;
    }

    public double deviation() {
        if (temperatureSeries.length == 0) {
            throw new IllegalArgumentException("Temperature series is empty");
        }
        double mean = average();
        double sumOfSquaredDiffs = 0.0;

        for (double temp : temperatureSeries) {
            sumOfSquaredDiffs += Math.pow(temp - mean, 2);
        }
        return Math.sqrt(sumOfSquaredDiffs / temperatureSeries.length);
    }

    public double min() {
        if (temperatureSeries.length == 0) {
            throw new IllegalArgumentException("Temperature series is empty");
        }
        double minTemp = temperatureSeries[0];
        for (double temp : temperatureSeries) {
            if (temp < minTemp) {
                minTemp = temp;
            }
        }
        return minTemp;
    }

    public double max() {
        if (temperatureSeries.length == 0) {
            throw new IllegalArgumentException("Temperature series is empty");
        }
        double maxTemp = temperatureSeries[0];
        for (double temp : temperatureSeries) {
            if (temp > maxTemp) {
                maxTemp = temp;
            }
        }
        return maxTemp;
    }

    public double findTempClosestToZero() {
        if (temperatureSeries.length == 0) {
            throw new IllegalArgumentException("Temperature series is empty");
        }
        double closest = temperatureSeries[0];
        for (double temp : temperatureSeries) {
            if (Math.abs(temp) < Math.abs(closest) || 
                (Math.abs(temp) == Math.abs(closest) && temp > closest)) {
                closest = temp;
            }
        }
        return closest;
    }

    public double findTempClosestToValue(double tempValue) {
        if (temperatureSeries.length == 0) {
            throw new IllegalArgumentException("Temperature series is empty");
        }
        double closest = temperatureSeries[0];
        for (double temp : temperatureSeries) {
            if (Math.abs(temp - tempValue) < Math.abs(closest - tempValue) || 
                (Math.abs(temp - tempValue) == Math.abs(closest - tempValue) && temp > closest)) {
                closest = temp;
            }
        }
        return closest;
    }

    public double[] findTempsLessThan(double tempValue) {
        ArrayList<Double> result = new ArrayList<>();
        for (double temp : temperatureSeries) {
            if (temp < tempValue) {
                result.add(temp);
            }
        }
        return result.stream().mapToDouble(Double::doubleValue).toArray();
    }

    public double[] findTempsGreaterThan(double tempValue) {
        ArrayList<Double> result = new ArrayList<>();
        for (double temp : temperatureSeries) {
            if (temp > tempValue) {
                result.add(temp);
            }
        }
        return result.stream().mapToDouble(Double::doubleValue).toArray();
    }

    public double[] findTempsInRange(double lowerBound, double upperBound) {
        ArrayList<Double> result = new ArrayList<>();
        for (double temp : temperatureSeries) {
            if (temp >= lowerBound && temp <= upperBound) {
                result.add(temp);
            }
        }
        return result.stream().mapToDouble(Double::doubleValue).toArray();
    }

    public void reset() {
        this.temperatureSeries = new double[0];
    }

    public double[] sortTemps() {
        double[] sortedTemps = temperatureSeries.clone();
        java.util.Arrays.sort(sortedTemps);
        return sortedTemps;
    }

    public TempSummaryStatistics summaryStatistics() {
        return new TempSummaryStatistics(average(), deviation(), min(), max());
    }

    public int addTemps(double... temps) {
        double[] newTemperatureSeries = new double[temperatureSeries.length + temps.length];
        System.arraycopy(temperatureSeries, 0, newTemperatureSeries, 0, temperatureSeries.length);
        System.arraycopy(temps, 0, newTemperatureSeries, temperatureSeries.length, temps.length);
        this.temperatureSeries = newTemperatureSeries;
        return temperatureSeries.length;
    }
}
