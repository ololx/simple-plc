package simply.plc.cpu;

import simply.plc.mask.BitMask;
import simply.plc.op.Conjunction;
import simply.plc.op.Disjunction;
import simply.plc.op.Negation;
import simply.plc.op.Operation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface CentralProcessingUnit {

    class ProgrammCounter {

        int mValue;

        public void set(int value) {
            this.mValue = value;
        }

        public void reset() {
            this.mValue = BitMask.NilL;
        }

        public int current() {
            return this.mValue;
        }

        public int next() {
            this.increase();
            return this.current();
        }

        public int previous() {
            this.decrease();
            return this.current();
        }

        public int currentNext() {
            this.increase();
            return this.current() - BitMask.Unit;
        }

        public int currentPrevious() {
            this.decrease();
            return this.current() + BitMask.Unit;
        }

        public void increase() {
            this.set(this.current() +  BitMask.Unit);
        }

        public void decrease() {
            this.set(this.current() - BitMask.Unit);
        }

        ProgrammCounter() {
            this.set(0);
        }

        ProgrammCounter(int value) {
            this.set(value);
        }
    }

    class ArithmeticLogicUnit {

        private Map<Integer, Operation> mOperations;

        public int execute(int ... args) {
            return this.mOperations.get(args[0]).execute(Arrays.stream(args).skip(1).toArray());
        }

        ArithmeticLogicUnit(Map<Integer, Operation> operations) {
            this.mOperations = operations;
        }

        public long executeS(long arg) {
            return ((Negation) this.mOperations.get(2)).executeS(arg);
        }
    }

    class ControlUnit {

        ControlUnit(Map<Integer, Integer> opcode) {

        }
    }
}
