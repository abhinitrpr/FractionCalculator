import java.util.*;
public class Fraction {
    private int num;
    private int den;

    public Fraction(int num, int den){
        if( den == 0){
            throw new IllegalArgumentException("denominator can't be zero");
        }

        else if (den < 0){
         den = Math.abs(den);       // making the denominator positive
         num = -num;                // Bumping the -ve sign of denominator to numerator
        }
        this.num = num;
        this.den = den;
    }

    public Fraction(int num){
        this(num, 1);
    }
    public Fraction(){
        this(0, 1);
    }

    public int getNumerator(){
        return num;
    }

    public int getDenominator(){
        return den;
    }
    public String toString(){
        return num + "/" + den;
    }

    public double toDouble(){
        return (double) num/den;
    }

    public Fraction add(Fraction other){
        Fraction myFrac= new Fraction(((this.num*other.den)+(other.num*this.den)),(this.den*other.den));
        myFrac.toLowestTerms();
        return myFrac;
    }

    public Fraction subtract(Fraction other){
        Fraction myFrac= new Fraction(((this.num*other.den)-(other.num*this.den)),(this.den*other.den));
        myFrac.toLowestTerms();
        return myFrac;
    }
    public Fraction multiply(Fraction other){
        Fraction myFrac= new Fraction((this.num*other.num),(this.den*other.den));
        myFrac.toLowestTerms();
        return myFrac;
    }
    public Fraction divide(Fraction other){
        if( other.num == 0){
            throw new IllegalArgumentException("divider can't be zero");
        }
        else {
            Fraction myFrac= new Fraction((this.num*other.den),(this.den*other.num));
            myFrac.toLowestTerms();
            return myFrac;
        }
    }
    @Override
    public boolean equals(Object other){
     if (other instanceof Fraction){
         ((Fraction) other).toLowestTerms();
         int numerator = ((Fraction) other).getNumerator();
         int denominator = ((Fraction) other).getDenominator();
         Fraction obj = new Fraction(numerator, denominator);
         Fraction thisFrac= new Fraction(this.num,this.den);
         thisFrac.toLowestTerms();

         return (thisFrac.getNumerator() == numerator && thisFrac.getDenominator() == denominator);
     }
     else {
         return false;
     }
    }

    public void toLowestTerms(){
        int div = gcd(num, den);
        this.num = num/div;
        this.den = den/div;

    }

    public static int gcd(int num, int den){
        int rem =0;
        while( num != 0 && den != 0){
             rem = num % den;
            num = den;
            den = rem;
        }
        return num;
    }



}
