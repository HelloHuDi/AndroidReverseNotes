package com.qq.taf.jce.dynamic;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class FloatField extends NumberField {
    private float data;

    FloatField(float f, int i) {
        super(i);
        this.data = f;
    }

    public Number getNumber() {
        AppMethodBeat.i(117018);
        Float valueOf = Float.valueOf(this.data);
        AppMethodBeat.o(117018);
        return valueOf;
    }

    public void set(float f) {
        this.data = f;
    }

    public float get() {
        return this.data;
    }
}
