package simply.plc.op;

public class Implication implements BinaryOperation {

    @Override
    public int execute(int firstOperand, int secondOperand) {
        return firstOperand = secondOperand;
    }


    @Override
    public int execute(int... args) {
        return this.execute(args[0], args[1]);
    }
}
