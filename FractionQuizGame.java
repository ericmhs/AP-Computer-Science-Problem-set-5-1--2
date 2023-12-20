import java.util.Scanner;
import java.util.Random;
public class FractionQuizGame {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        System.out.println("Let the Fraction Quiz Begin. Answers should be in lowest terms. Good luck!");

        double numCorrectAnswer = 3;
        double numWrongAnswer = 3;
        int totalQuestion = 4;
        boolean gameContinue = true;

        while(gameContinue) {
            Fraction f1 = new Fraction();
            Fraction f2 = new Fraction();
            Fraction answer = new Fraction();
            Fraction correctAnswer = new Fraction();
            char operator = generateOperator();
            String answerX = "";

            System.out.print(f1 + " " + operator + " " + f2 + " = ");
            answerX = input.nextLine();
            if("quit".equals(answerX)) {
                gameContinue = false;
                break;
            }
            answer = new Fraction(answerX);

            if(operator == '+') {
                correctAnswer = Fraction.add(f1, f2);
            } else if(operator == '-') {
                correctAnswer = Fraction.subtract(f1, f2);
            } else if(operator == '*') {
                correctAnswer = Fraction.multiply(f1, f2);
            } else if(operator == '/') {
                correctAnswer = Fraction.divide(f1, f2);
            }

            if (correctAnswer.equals(answer)){
                System.out.println("Correct!");
                numCorrectAnswer++;
            } else {
                System.out.println("Wrong, the answer was " + correctAnswer);
                numWrongAnswer++;
            }

            System.out.println();
        }

        int percentage = (int)(numCorrectAnswer / (numCorrectAnswer + numWrongAnswer) * 100.0);
        System.out.println("Your win/loss ratio was " + numCorrectAnswer + "/" + numWrongAnswer + ", for a score of " + percentage + " percent!");
    }

    private static char generateOperator() {
        char[] operators = {'+', '-', '*', '/'};
        Random random = new Random();
        return operators[random.nextInt(operators.length)];
    }

}

