package com.davemorrissey.labs.subscaleview.p1158a;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.davemorrissey.labs.subscaleview.a.c */
public final class C25467c {
    public String aIm;
    public int errCode;

    public C25467c(int i, String str) {
        this.errCode = i;
        this.aIm = str;
    }

    public final String toString() {
        AppMethodBeat.m2504i(115607);
        String format = String.format("ImageDecodeResult{errCode: %d, errMsg: %s}", new Object[]{Integer.valueOf(this.errCode), this.aIm});
        AppMethodBeat.m2505o(115607);
        return format;
    }
}
