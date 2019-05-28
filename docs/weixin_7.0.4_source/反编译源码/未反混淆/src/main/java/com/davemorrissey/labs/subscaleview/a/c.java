package com.davemorrissey.labs.subscaleview.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c {
    public String aIm;
    public int errCode;

    public c(int i, String str) {
        this.errCode = i;
        this.aIm = str;
    }

    public final String toString() {
        AppMethodBeat.i(115607);
        String format = String.format("ImageDecodeResult{errCode: %d, errMsg: %s}", new Object[]{Integer.valueOf(this.errCode), this.aIm});
        AppMethodBeat.o(115607);
        return format;
    }
}
