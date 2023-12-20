
public class FractionDriver {
    public static void main(String[] args) {
        System.out.println("Test:");

        Fraction f1 = new Fraction();
        Fraction f2 = new Fraction(22,168);
        Fraction f3 = new Fraction(60,288);
       
        
        Fraction product = Fraction.multiply(f2, f3);
        Fraction quotient = Fraction.divide(f2, f3);
        Fraction sum = Fraction.add(f2, f3);
        Fraction difference = Fraction.subtract(f2, f3);
        
        System.out.println(f1);
        System.out.println("Multiply: " + product);
        System.out.println("Divide: " + quotient);
        System.out.println("Add: " + sum);
        System.out.println("Subtract: " + difference);
        System.out.println(f3.getNum());
    }
}
