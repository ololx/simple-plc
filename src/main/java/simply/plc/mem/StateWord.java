package simply.plc.mem;

import simply.plc.mask.BitMask;

public class StateWord extends AbstractRegister {

    public StateWord() {
        super(BitMask.NilL);
    }

    public StateWord(int value) {
        super(value);
    }
}
