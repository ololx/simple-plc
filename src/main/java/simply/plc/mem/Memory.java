package simply.plc.mem;

public interface Memory {

    int get(int address, int value);

    void set(int address, int value);
}
