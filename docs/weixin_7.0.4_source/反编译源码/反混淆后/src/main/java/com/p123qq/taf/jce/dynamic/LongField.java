package com.p123qq.taf.jce.dynamic;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.qq.taf.jce.dynamic.LongField */
public class LongField extends NumberField {
    private long data;

    LongField(long j, int i) {
        super(i);
        this.data = j;
    }

    public Number getNumber() {
        AppMethodBeat.m2504i(117014);
        Long valueOf = Long.valueOf(this.data);
        AppMethodBeat.m2505o(117014);
        return valueOf;
    }

    public long get() {
        return this.data;
    }

    public void set(long j) {
        this.data = j;
    }
}
