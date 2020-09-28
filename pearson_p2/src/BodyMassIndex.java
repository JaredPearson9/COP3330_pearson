public class BodyMassIndex {

    public double BMInumber;
    public String BMIcategory;

    public BodyMassIndex(double height, double weight) {
        BMInumber = calculateBMI(height, weight);
        BMIcategory = BMIcategory(BMInumber);
    }

    public static double calculateBMI(double inches, double pounds){
        double BMI = Math.round(((703 * pounds) / ( inches * inches ))*10)/10.0;
        return BMI;
    }

    public static String BMIcategory(double BMI){
        String category = "";
        if(BMI < 18.5){
            category = "Underweight";
        }
        if(18.5 <= BMI && BMI <= 24.9){
            category = "Normal weight";
        }
        if(25 <= BMI && BMI <= 29.9){
            category = "Overweight";
        }
        if(BMI >= 30){
            category = "Obesity";
        }
        return category;
    }
}