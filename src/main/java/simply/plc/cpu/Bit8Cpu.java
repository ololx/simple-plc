package simply.plc.cpu;

import simply.plc.mask.BitMask;
import simply.plc.mem.CPUMemory;
import simply.plc.mem.StateWord;
import simply.plc.op.Conjunction;
import simply.plc.op.Disjunction;
import simply.plc.op.Negation;
import simply.plc.op.Operation;

import java.util.HashMap;

public class Bit8Cpu implements CentralProcessingUnit {

    private ProgrammCounter pc;

    private ArithmeticLogicUnit alu;

    private StateWord mStateWord;

    private CPUMemory mProgramm;

    public Bit8Cpu() {
        this.pc = new ProgrammCounter();
        this.alu = new ArithmeticLogicUnit(new HashMap<Integer, Operation>() {
            {
                put(BitMask.NilL, new Conjunction());
                put(BitMask.NilL + 1, new Disjunction());
                put(BitMask.NilL + 2, new Negation());
            }
        });
        this.mProgramm = new CPUMemory(4);
        this.mProgramm.writeByte(0, 00000001);
        this.mProgramm.writeByte(1, 111);
        //this.mProgramm.writeByte(0, 000010001);
        this.mStateWord = new StateWord();
        //System.out.println(this.alu.execute(0, 1, 1));
        //System.out.println(this.alu.execute(0, 1, 0));
        System.out.println(this.alu.execute(0,
            this.mProgramm.readByte(0),
            this.mProgramm.readByte(1)));
        System.out.println(this.alu.execute(1,
            this.mProgramm.readByte(0),
            this.mProgramm.readByte(1)));
        System.out.println(this.mProgramm.readByte(0));
         System.out.println(this.mProgramm.readByte(1));
         System.out.println("!!!");
        System.out.println(this.alu.execute(2, 2));
        System.out.println(~ (short) 2);
    }

}
