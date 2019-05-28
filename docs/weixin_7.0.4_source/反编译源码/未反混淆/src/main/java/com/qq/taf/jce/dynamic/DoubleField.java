package com.qq.taf.jce.dynamic;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class DoubleField extends NumberField {
    private double data;

    DoubleField(double d, int i) {
        super(i);
        this.data = d;
    }

    public Number getNumber() {
        AppMethodBeat.i(117016);
        Double valueOf = Double.valueOf(this.data);
        AppMethodBeat.o(117016);
        return valueOf;
    }

    public double get() {
        return this.data;
    }

    public void set(double d) {
        this.data = d;
    }
}
