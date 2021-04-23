public class Main {
    public static void main(String[] args) {

        final int PATIENTS = 30;
        final double MAX_TEMP = 40.0;
        final double MIN_TEMP = 32.0;
        final double MIN_HEALTHY_TEMP = 36.2;
        final double MAX_HEALTHY_TEMP = 36.9;

        double[] pacientTemps = new double[PATIENTS];
        for (int i = 0; i < pacientTemps.length; i++) {
            double value = MIN_TEMP + ((MAX_TEMP - MIN_TEMP) * Math.random());
            pacientTemps[i] = value;
            System.out.printf((i + 1) + ":" + "%.1f ", pacientTemps[i]);
        }

        double averageTemp = 0;
        for (double pacientTemp : pacientTemps) {
            averageTemp += pacientTemp;
        }
        averageTemp /= pacientTemps.length;
        System.out.printf("\n\nAverage patient's temperature: " + "%.1f", averageTemp);

        int healthyPatientsNumber = 0;
        for (double pacientTemp : pacientTemps) {
            if (pacientTemp >= MIN_HEALTHY_TEMP && pacientTemp <= MAX_HEALTHY_TEMP) {
                healthyPatientsNumber++;
            }
        }
        System.out.println("\nHealthy patient's number: " + healthyPatientsNumber);
    }
}