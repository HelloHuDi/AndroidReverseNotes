package com.p123qq.taf.jce.dynamic;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.qq.taf.jce.dynamic.DoubleField */
public class DoubleField extends NumberField {
    private double data;

    DoubleField(double d, int i) {
        super(i);
        this.data = d;
    }

    public Number getNumber() {
        AppMethodBeat.m2504i(117016);
        Double valueOf = Double.valueOf(this.data);
        AppMethodBeat.m2505o(117016);
        return valueOf;
    }

    public double get() {
        return this.data;
    }

    public void set(double d) {
        this.data = d;
    }
}
