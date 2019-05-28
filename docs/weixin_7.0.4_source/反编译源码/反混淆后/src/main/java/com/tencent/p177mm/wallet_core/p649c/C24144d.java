package com.tencent.p177mm.wallet_core.p649c;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.wallet_core.c.d */
public final class C24144d {
    public int Afo;
    public String aIm;
    public int errCode;
    public int errType;

    public C24144d(int i, int i2, String str) {
        AppMethodBeat.m2504i(49037);
        this.Afo = 0;
        mo39942f(i, i2, str, 0);
        AppMethodBeat.m2505o(49037);
    }

    /* renamed from: f */
    public final void mo39942f(int i, int i2, String str, int i3) {
        this.errType = i;
        this.errCode = i2;
        this.aIm = str;
        this.Afo = i3;
    }

    public C24144d() {
        this.Afo = 0;
        this.errType = 0;
        this.errCode = 0;
        this.aIm = "";
        this.Afo = 0;
    }
}
