package simply.plc.mem;

public  class CPUMemory {

    protected int[] mValue;

    public CPUMemory(int size) {
        mValue = new int[size];
        this.reset();
    }

    public void reset() {
        for(int i = 0; i < mValue.length; i++) {
            mValue[i] = 0x00;
        }
    }

    public void writeByte(int address, int value) throws ArrayIndexOutOfBoundsException {
        if(address < 0 || address >= mValue.length) {
            throw new ArrayIndexOutOfBoundsException(address);
        }
        int x = value & 0xFF;
        System.out.println(x + "=" + value + "&" + 0xFF);
        mValue[address] = x;
    }

    public void writeWord(int address, int value)  throws ArrayIndexOutOfBoundsException {
        writeByte(address, value & 0xFF);
        writeByte(address + 1, (value >> 8) & 0xFF);
    }

    public int readByte(int address) throws ArrayIndexOutOfBoundsException {
        if(address < 0 || address >= mValue.length) {
            throw new ArrayIndexOutOfBoundsException(address);
        }
        return mValue[address];
    }

    public int readWord(int address) throws ArrayIndexOutOfBoundsException {
        return readByte(address) + (readByte(address + 1) << 8);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < mValue.length; i++) {
            sb.append("[" + String.format("%8s", Integer.toBinaryString(i)).replace(' ', '0')  + "] 0x" + Integer.toHexString(i).toUpperCase());
            sb.append("\t=>\t");
            sb.append("[" + String.format("%8s", Integer.toBinaryString(mValue[i])).replace(' ', '0')  + "] 0x" + Integer.toHexString(mValue[i]).toUpperCase());
            sb.append("\n");
        }
        return sb.toString();
    }
}    