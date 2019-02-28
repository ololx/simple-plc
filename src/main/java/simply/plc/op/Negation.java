package simply.plc.op;

import simply.plc.mask.BitMask;

public class Negation implements UnaryOperation {

    @Override
    public int execute(int operand) {
        //return ~ operand & BitMask.Unit;
        return ~ operand;
    }

    public long executeS(long operand) {
        //return ~ operand & BitMask.Unit;
        return ~ operand;
    }


    @Override
    public int execute(int... args) {
        return this.execute(args[0]);
    }
}
