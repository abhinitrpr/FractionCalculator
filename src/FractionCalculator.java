import java.util.*;
public class FractionCalculator {
    static int numerator;
    static int denominator;

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("This program is a fraction calculator");
        System.out.println("It will add, subtract, multiply and divide fraction until you type Q to quit");
        System.out.println("Please enter your fractions in the form of a/b, where a and b are integers.");
        String operand = "";
        while(!operand.equalsIgnoreCase("Q")) {
            System.out.println("-----------------------------------------------------------------------------");
            operand = getOperation(input);

            if (operand.equals("+")){
                Fraction frac1 = getFraction(input);
                Fraction frac2 = getFraction(input);
                Fraction addup = frac1.add(frac2);
                System.out.println(frac1.getNumerator()+"/"+frac1.getDenominator()+"+"+ frac2.getNumerator()+"/"+frac2.getDenominator()+ "="+ addup.getNumerator()+"/"+addup.getDenominator());
            }
            else if (operand.equals("-")){
                Fraction frac1 = getFraction(input);
                Fraction frac2 = getFraction(input);
                Fraction minus = frac1.subtract(frac2);
                System.out.println(frac1.getNumerator()+"/"+frac1.getDenominator()+"-"+ frac2.getNumerator()+"/"+frac2.getDenominator()+ "="+ minus.getNumerator()+"/"+minus.getDenominator());
            }
            else if (operand.equals("*")){
                Fraction frac1 = getFraction(input);
                Fraction frac2 = getFraction(input);
                Fraction product = frac1.multiply(frac2);
                System.out.println(frac1.getNumerator()+"/"+frac1.getDenominator()+"*"+ frac2.getNumerator()+"/"+frac2.getDenominator()+ "="+ product.getNumerator()+"/"+product.getDenominator());
            }
            else if (operand.equals("/")){
                Fraction frac1 = getFraction(input);
                Fraction frac2 = getFraction(input);

                Fraction quotient = frac1.divide(frac2);
                System.out.println(frac1.getNumerator()+"/"+frac1.getDenominator()+"/"+ frac2.getNumerator()+"/"+frac2.getDenominator()+ "="+ quotient.getNumerator()+"/"+quotient.getDenominator());
            }
            else if (operand.equals("=")){
                Fraction frac1 = getFraction(input);
                frac1.toLowestTerms();
                System.out.println(frac1.getNumerator()+"/"+frac1.getDenominator());
            }

        }

    }


    public static String getOperation(Scanner input){
        System.out.print("Please enter an operation(+, -, *, /, = or Q to quit): ");
        String operand = input.next();
        while (!operand.equals("+")  && !operand.equals("-") && !operand.equals("/") && !operand.equals("*") && !operand.equals("=") && !operand.equalsIgnoreCase("Q") ){
            System.out.print("Invalid input (+, -, *, /, = or Q to quit): ");
            operand = input.next();
        }
        return operand;
    }

    public static boolean validFraction(String input){

        int length = input.length();
        int sign = input.lastIndexOf("-");
        if (sign == 0){
            input = input.substring(1, length);

        }
        else if (sign > 0){
            return false;
        }
        int hyphen = input.indexOf("/");
        if (hyphen > 0) {
            String num1 = input.substring(0, hyphen);
            if (!isNumber(num1)) {
                return false;

            }
            numerator = Integer.parseInt(num1);
            if (sign == 0){
                numerator = numerator * -1;
            }
            length = input.length();
            String num2 = input.substring((hyphen + 1), length);

            if (isNumber(num2)) {
                denominator = Integer.parseInt(num2);

                if (denominator == 0) {
                    return false;
                }
            }
        }
            else if (hyphen <0){
                length = input.length();
                String num1 = input.substring(0,length);
                if(!isNumber(num1)){
                    return false;

                }
                numerator= Integer.parseInt(num1);
                if (sign == 0){
                    numerator = numerator* -1;
                }
                denominator = 1;
            }

        else {
            return false;
        }

        return true;
    }

    public static Fraction getFraction(Scanner input){

        System.out.print("Please enter a fraction (a/b) or integer (a): ");
        String fract = input.next();
        while(!validFraction(fract)){
            System.out.print("Invalid fraction. Please enter (a/b) or (a), where a and b are integers and b is not zero: ");
            fract = input.next();
        }

        Fraction myFrac = new Fraction(numerator, denominator);
        return myFrac;


    }

    public static boolean isNumber(String input){

        int length = input.length();
        for (int i =0; i< length; i++){
            boolean digit = Character.isDigit(input.charAt(i));
            if (!digit){
                return false;
            }
        }
        return true;


    }
}




