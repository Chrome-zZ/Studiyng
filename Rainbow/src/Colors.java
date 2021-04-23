public class Colors {
    public static void main(String[] args) {
        String text = "Каждый охотник желает знать, где сидит фазан";
        String[] colors = text.split(",?\\s+");
        String temp;
        for (int i = 0; i < (colors.length / 2); i++) {
            temp = colors[colors.length - i - 1];
            colors[colors.length - i - 1] = colors[i];
            colors[i] = temp;
        }
        for (String color : colors) {
            System.out.println(color);
        }
    }
}