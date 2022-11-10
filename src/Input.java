import java.util.Scanner;

public class Input {
    private final static Scanner input = new Scanner(System.in);
    public static int inputInt(String title){
        System.out.print(title);
        try{
            return Integer.parseInt(input.nextLine());
        }catch(Exception e){
            System.out.println(e.getMessage() + "- Illegal, try again!");
            return inputInt(title);
        }
    }

    public static boolean inputChoice(String title){
        char a = inputString(title).charAt(0);
        return switch (a){
            case '1' -> true;
            case '2' -> false;
            default -> inputChoice("Illegal, try again! \n" + title);
        };
    }
    public static int inputRange(String title, int min, int max){
        int a = inputInt(title);
        if (a < min || a > max){
            System.out.println("Illegal, try again!");
            return inputRange(title, min, max);
        }else{
            return a;
        }

    }

    public static long inputLong(String title){
        System.out.print(title);
        try{
            return Integer.parseInt(input.nextLine());
        }catch(Exception e){
            System.out.println(e.getMessage() + "- Illegal, try again!");
            return inputInt(title);
        }
    }

    public static double inputDouble(String title){
        System.out.print(title);
        try{
            return Double.parseDouble(input.nextLine());
        }catch(Exception e){
            System.out.println(e.getMessage() + "- Illegal, try again!");
            return inputDouble(title);
        }
    }
    public static double inputDoubleInRange(String title, double min, double max){
        double a = inputDouble(title);
        if(a<min || a > max){
            System.out.println("Illegal, try again!");
            inputDoubleInRange(title, min, max);
        }
        return a;
    }

    public static String inputString(String title){
        System.out.print(title);
        return input.nextLine();
    }
}
