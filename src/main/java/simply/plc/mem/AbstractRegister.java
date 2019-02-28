package simply.plc.mem;

import simply.plc.mask.BitMask;

public abstract class AbstractRegister implements Memory {

    public int mValue;

    @Override
    public int get(int address, int value) {
        return this.mValue & BitMask.Unit;
    }

    @Override
    public void set(int address, int value) {
        this.mValue ^= (value << address);
    }

    public AbstractRegister(int value) {
        this.mValue = value;
    }
}
