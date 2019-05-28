package com.qq.taf.jce.dynamic;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class LongField extends NumberField {
    private long data;

    LongField(long j, int i) {
        super(i);
        this.data = j;
    }

    public Number getNumber() {
        AppMethodBeat.i(117014);
        Long valueOf = Long.valueOf(this.data);
        AppMethodBeat.o(117014);
        return valueOf;
    }

    public long get() {
        return this.data;
    }

    public void set(long j) {
        this.data = j;
    }
}
