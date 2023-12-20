
/**
 * Write a description of class EstimatingPI here.
 *
 * @author Eric Shen
 * @version 2023 Dec 13
 */
public class EstimatingPI {
    public static void main(String args[]) {
        Fraction MILU = new Fraction(355, 113);
        Fraction ourApproximation = new Fraction(1, 1);
        final double EPSILON = Math.abs(Math.PI - MILU.toDouble());
        double approximation = Math.abs(ourApproximation.toDouble());
        
        int numI = 1;
        int DenomI = 1;
        
        while(Math.abs(Math.PI - approximation) > EPSILON) {
            if(approximation < Math.PI) {
                ourApproximation.setNum(ourApproximation.getNum()+numI);
            } else if (approximation > Math.PI) {
                ourApproximation.setDenom(ourApproximation.getDenom()+DenomI);
            }
            approximation = Math.abs(ourApproximation.toDouble());
            System.out.println(approximation);
        }

        System.out.println("Estimated value: " + ourApproximation.toDouble());
        System.out.println("Numerator: " + ourApproximation.getNum());
        System.out.println("Denominator: " + ourApproximation.getDenom());
        System.out.println("Epsilon: " + EPSILON);
        System.out.println("Absolute difference: " + Math.abs(Math.PI - approximation));
    }
}
