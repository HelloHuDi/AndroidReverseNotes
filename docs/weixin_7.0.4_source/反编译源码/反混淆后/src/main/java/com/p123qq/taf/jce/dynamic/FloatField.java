package com.p123qq.taf.jce.dynamic;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.qq.taf.jce.dynamic.FloatField */
public class FloatField extends NumberField {
    private float data;

    FloatField(float f, int i) {
        super(i);
        this.data = f;
    }

    public Number getNumber() {
        AppMethodBeat.m2504i(117018);
        Float valueOf = Float.valueOf(this.data);
        AppMethodBeat.m2505o(117018);
        return valueOf;
    }

    public void set(float f) {
        this.data = f;
    }

    public float get() {
        return this.data;
    }
}
