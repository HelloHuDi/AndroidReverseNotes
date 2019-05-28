package com.tencent.ttpic.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.CopyOnWriteArrayList;

public class Audio2Text {
    public static final int MODE_FIFO = 2;
    public static final int MODE_LOOP_REPLACE = 1;
    public int segmentCount;
    public double segmentTime;
    public int sentenceCount;
    public int sentenceMode = 2;
    public double silenceTime;
    public String triggerWords;

    public static class FIFOList<T> extends CopyOnWriteArrayList<T> {
        private int mCapacity;

        public FIFOList(int i) {
            this.mCapacity = i;
        }

        public boolean add(T t) {
            AppMethodBeat.m2504i(83451);
            boolean add;
            if (size() >= this.mCapacity) {
                remove(0);
                add = super.add(t);
                AppMethodBeat.m2505o(83451);
                return add;
            }
            add = super.add(t);
            AppMethodBeat.m2505o(83451);
            return add;
        }
    }

    public static class LoopRepList<T> extends CopyOnWriteArrayList<T> {
        private int mCapacity;
        private int mCurrent = 0;

        public LoopRepList(int i) {
            this.mCapacity = i;
        }

        public boolean add(T t) {
            AppMethodBeat.m2504i(83452);
            if (size() >= this.mCapacity) {
                if (this.mCurrent >= this.mCapacity) {
                    this.mCurrent = 0;
                }
                int i = this.mCurrent;
                this.mCurrent = i + 1;
                super.set(i, t);
                AppMethodBeat.m2505o(83452);
                return true;
            }
            boolean add = super.add(t);
            AppMethodBeat.m2505o(83452);
            return add;
        }
    }
}
