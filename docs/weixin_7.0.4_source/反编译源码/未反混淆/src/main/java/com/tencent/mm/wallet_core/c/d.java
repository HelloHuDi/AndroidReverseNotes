package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d {
    public int Afo;
    public String aIm;
    public int errCode;
    public int errType;

    public d(int i, int i2, String str) {
        AppMethodBeat.i(49037);
        this.Afo = 0;
        f(i, i2, str, 0);
        AppMethodBeat.o(49037);
    }

    public final void f(int i, int i2, String str, int i3) {
        this.errType = i;
        this.errCode = i2;
        this.aIm = str;
        this.Afo = i3;
    }

    public d() {
        this.Afo = 0;
        this.errType = 0;
        this.errCode = 0;
        this.aIm = "";
        this.Afo = 0;
    }
}
