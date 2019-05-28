package com.tencent.mm.kernel.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e<T extends a> implements b, c<T> {
    private T eMH;

    public e(T t) {
        this.eMH = t;
    }

    public final T SJ() {
        return this.eMH;
    }

    public final void SH() {
        AppMethodBeat.i(51937);
        if (this.eMH instanceof b) {
            ((b) this.eMH).SH();
        }
        AppMethodBeat.o(51937);
    }

    public final void SI() {
        AppMethodBeat.i(51938);
        if (this.eMH instanceof b) {
            ((b) this.eMH).SI();
        }
        AppMethodBeat.o(51938);
    }
}
