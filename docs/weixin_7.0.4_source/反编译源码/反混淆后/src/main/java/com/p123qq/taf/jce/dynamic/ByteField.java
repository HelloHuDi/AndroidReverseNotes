package com.p123qq.taf.jce.dynamic;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.qq.taf.jce.dynamic.ByteField */
public final class ByteField extends NumberField {
    private byte data;

    ByteField(byte b, int i) {
        super(i);
        this.data = b;
    }

    public final Number getNumber() {
        AppMethodBeat.m2504i(117017);
        Byte valueOf = Byte.valueOf(this.data);
        AppMethodBeat.m2505o(117017);
        return valueOf;
    }

    public final byte get() {
        return this.data;
    }

    public final void set(byte b) {
        this.data = b;
    }
}
