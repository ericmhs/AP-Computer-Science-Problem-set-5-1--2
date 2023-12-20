
/**
 * Write a description of class Fraction here.
 *
 * @author Eric Shen
 * @version 1.0
 */
public class Fraction {

    //Instance Variables
    private int numerator, denominator;

    //Constructors

    /**
     * defalut constructor. Creates a fraction of 1/1.
     */

    public Fraction() {
        numerator = (int) (Math.random()*9)+1;
        denominator = (int) (Math.random()*9)+1;
    }

    /**
     * Parameterized constructor.
     * @param num   The desired numerator
     * @param denom The desired denominator. If denom is zero changed to 1 and an error is printed
     */
    public Fraction(int num, int denom) {
        this.numerator = num;
        this.denominator = denom;
        reduce(numerator, denominator);
        changeDenominator();
    }

    public Fraction(String frac) {
        int slashIndex = frac.indexOf("/");
        if (slashIndex > 0) {
            String n = frac.substring(0, slashIndex);
            String d = frac.substring(slashIndex + 1);
            numerator = Integer.parseInt(n);
            denominator = Integer.parseInt(d);
            changeDenominator();
        }else{
            System.out.println("Invalid fraction format");
            numerator = 1;
            denominator = 1;
        }
    }

    /**
     * Copy constractor.
     * @param frac  A fraction object to copy.
     */
    public Fraction(Fraction myFrac) {
        numerator = myFrac.numerator;
        denominator = myFrac.denominator; 
    }

    private void changeDenominator() {
        if(denominator == 0) {
            System.out.println("Error: denominator cannot be zero. Changed to 1");
            denominator = 1;
        }
    }

    //Behaviour Methods
    //Accessor
    public int getNum() {
        return numerator;
    }

    public int getDenom() {
        return denominator;
    }

    public String toString() {
        return numerator + "/" + denominator;
    }

    public double toDouble() {
        return (double) numerator / denominator;
    }

    //Mutator
    public void reduce(int newNumerator, int newDenominator) {
        int f = gcf(newNumerator,newDenominator);
        
        this.numerator = newNumerator/f;
        this.denominator = newDenominator/f;
    } 

    public void setNum(int num) {
        numerator = num;
    }

    public void setDenom(int denom) {
        denominator = denom;
        changeDenominator();
    }

    //Static
    public static Fraction multiply(Fraction a, Fraction b) {
        int newNumerator = a.numerator * b.numerator;
        int newDenominator = a.denominator * b.denominator;

        return new Fraction(newNumerator, newDenominator);
    }

    public static Fraction divide(Fraction a, Fraction b) {
        int newNumerator = a.numerator * b.denominator;
        int newDenominator = a.denominator * b.numerator;
        return new Fraction(newNumerator, newDenominator);
    }

    public static Fraction add(Fraction a, Fraction b) {
        int newDenominator = a.denominator*b.denominator;
        int newNumerator = a.numerator*b.denominator + b.numerator*a.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    public static Fraction subtract(Fraction a, Fraction b) {
        int newDenominator = a.denominator*b.denominator;
        int newNumerator = a.numerator*b.denominator - b.numerator*a.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    //Helper
    private int gcf(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while(a!=b) {
            if(a < b) {
                b = b - a;
            } else if(a > b) {
                a = a - b;
            }
        }
        return a;
    }
}
