package com.qq.taf.jce.dynamic;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ByteField extends NumberField {
    private byte data;

    ByteField(byte b, int i) {
        super(i);
        this.data = b;
    }

    public final Number getNumber() {
        AppMethodBeat.i(117017);
        Byte valueOf = Byte.valueOf(this.data);
        AppMethodBeat.o(117017);
        return valueOf;
    }

    public final byte get() {
        return this.data;
    }

    public final void set(byte b) {
        this.data = b;
    }
}
