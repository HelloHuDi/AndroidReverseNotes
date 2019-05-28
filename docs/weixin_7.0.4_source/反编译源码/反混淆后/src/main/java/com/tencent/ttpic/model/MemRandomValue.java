package com.tencent.ttpic.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class MemRandomValue {
    public static final MemRandomValue EMPTY = new MemRandomValue();
    public int curValue;
    public int lastValue;

    static {
        AppMethodBeat.m2504i(83507);
        AppMethodBeat.m2505o(83507);
    }

    public MemRandomValue() {
        this(-1, -1);
    }

    public MemRandomValue(int i, int i2) {
        this.lastValue = i;
        this.curValue = i2;
    }

    public boolean isAssigned() {
        return this.lastValue >= 0;
    }
}
