package Pt2_day10;

import java.util.logging.Logger;

public class Solution01 {
    public static void main(String[] args) {
        ICalculator calculator = new Calculator();
        Logger logger = Logger.getLogger("calculator");
        logger.info("%d".formatted(calculator.add(1, 2)));
        logger.info("%d".formatted(calculator.subtract(1, 2)));
        // 피연산자 2개 -> 계산 -> 그 때 그 때? -> 매개변수와 반환값만 인터페이스 지정하고...
        // 함수는 그때그때 익명함수로 못 넣어?
//        ICalculatorLambda calculatorLambda = (a, b) -> a * b;
        ICalculatorLambda calculatorLambda = (a, b) -> a % b;
        logger.info("%d".formatted(calculatorLambda.run(5, 12)));
        ICalculatorLambda calculatorLambda2 = calculator::add;
        logger.info("%d".formatted(calculatorLambda2.run(5, 12)));
        ICalculatorLambda calculatorLambda3 = Calculator::pythagoras;
        logger.info("%d".formatted(calculatorLambda3.run(5, 12)));
    }
}

@FunctionalInterface
interface ICalculatorLambda {
    int run(int a, int b);
}

class Calculator implements ICalculator {

    public static int pythagoras(int a, int b) {
        return (int) Math.pow(Math.pow(a, 2) + Math.pow(b, 2), 0.5);
    }

    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public int subtract(int a, int b) {
        return a - b;
    }
}

interface ICalculator {
    int add(int a, int b);
    int subtract(int a, int b);
}