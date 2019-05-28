package com.qq.taf.jce.dynamic;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class IntField extends NumberField {
    private int data;

    IntField(int i, int i2) {
        super(i2);
        this.data = i;
    }

    public int get() {
        return this.data;
    }

    public void set(int i) {
        this.data = i;
    }

    public Number getNumber() {
        AppMethodBeat.i(117007);
        Integer valueOf = Integer.valueOf(this.data);
        AppMethodBeat.o(117007);
        return valueOf;
    }
}
