package simply.plc.op;

public class Disjunction implements BinaryOperation {

    @Override
    public int execute(int firstOperand, int SecondOperand) {
        return firstOperand | SecondOperand;
    }


    @Override
    public int execute(int... args) {
        return this.execute(args[0], args[1]);
    }

}
