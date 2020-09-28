import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        ArrayList<BodyMassIndex> bmiData = new ArrayList<BodyMassIndex>();

        while (moreInput()) {
            double height = getUserHeight();
            double weight = getUserWeight();

            BodyMassIndex bmi = new BodyMassIndex(height, weight);
            bmiData.add(bmi);

            displayBmiInfo(bmi);
        }

        displayBmiStatistics(bmiData);
    }

    public static double getUserHeight(){
        double heightInput = 0;
        while(heightInput <= 0){
            System.out.println("Enter a height in inches: (must be a positive value)");
            Scanner sc = new Scanner(System.in);
            try{
                heightInput = sc.nextDouble();
            } catch (InputMismatchException e){
                System.out.println("Input error! Please input only numbers.");
            }
        }
        return heightInput;
    }

    public static double getUserWeight(){
        double weightInput = 0;
        while(weightInput <= 0){
            System.out.println("Enter a weight in pounds: (must be a positive value)");
            Scanner sc = new Scanner(System.in);
            try{
                weightInput = sc.nextDouble();
            } catch (InputMismatchException e){
                System.out.println("Input error! Please input only numbers.");
            }

        }
        return weightInput;
    }

    public static boolean moreInput(){

        while(true) {
            System.out.println("Do you want to calculate a BMI? (enter Y or N)");
            Scanner sc = new Scanner(System.in);
            String answer = sc.nextLine();
            if(answer.equalsIgnoreCase("y")){
                return true;
            }
            if(answer.equalsIgnoreCase("n")){
                return false;
            }
            else{
                System.out.println("invalid input, try again.");
                System.out.println("");
            }
        }
    }

    public static void displayBmiInfo(BodyMassIndex bmi){
        System.out.print("BMI: ");
        System.out.println(Double.toString(bmi.BMInumber));
        System.out.print("BMI category: ");
        System.out.println(bmi.BMIcategory);
        System.out.println("");
    }

    public static void displayBmiStatistics(ArrayList<BodyMassIndex> bmiData){
        double sum = 0;
        for(int i=0; i<bmiData.size(); i++){
            sum = sum + bmiData.get(i).BMInumber;
        }
        double BMIaverage = Math.round((sum / bmiData.size())*10) / 10.0;

        System.out.print("Average of all BMIs calculated: ");
        System.out.println(Double.toString(BMIaverage));
    }
}