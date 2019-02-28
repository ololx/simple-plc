package simply.plc.op;

public class Conjunction implements BinaryOperation {

    @Override
    public int execute(int firstOperand, int SecondOperand) {
        return firstOperand & SecondOperand;
    }

    @Override
    public int execute(int... args) {
        return this.execute(args[0], args[1]);
    }
}
