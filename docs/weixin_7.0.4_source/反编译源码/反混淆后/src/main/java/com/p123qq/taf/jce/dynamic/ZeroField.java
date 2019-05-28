package com.p123qq.taf.jce.dynamic;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.qq.taf.jce.dynamic.ZeroField */
public final class ZeroField extends NumberField {
    ZeroField(int i) {
        super(i);
    }

    public final Number getNumber() {
        AppMethodBeat.m2504i(117015);
        Integer valueOf = Integer.valueOf(0);
        AppMethodBeat.m2505o(117015);
        return valueOf;
    }

    public final byte byteValue() {
        return (byte) 0;
    }

    public final double doubleValue() {
        return 0.0d;
    }

    public final float floatValue() {
        return 0.0f;
    }

    public final int intValue() {
        return 0;
    }

    public final long longValue() {
        return 0;
    }

    public final short shortValue() {
        return (short) 0;
    }
}
