package com.qq.taf.jce.dynamic;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ShortField extends NumberField {
    private short data;

    ShortField(short s, int i) {
        super(i);
        this.data = s;
    }

    public final Number getNumber() {
        AppMethodBeat.i(117008);
        Short valueOf = Short.valueOf(this.data);
        AppMethodBeat.o(117008);
        return valueOf;
    }

    public final short get() {
        return this.data;
    }

    public final void set(short s) {
        this.data = s;
    }
}
