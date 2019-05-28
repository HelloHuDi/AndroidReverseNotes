package com.bumptech.glide.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;

public final class e extends IOException {
    private final int statusCode;

    public e(int i) {
        this("Http request failed with status code: ".concat(String.valueOf(i)), i);
        AppMethodBeat.i(91673);
        AppMethodBeat.o(91673);
    }

    public e(String str) {
        this(str, -1);
    }

    public e(String str, int i) {
        this(str, i, (byte) 0);
    }

    private e(String str, int i, byte b) {
        super(str, null);
        this.statusCode = i;
    }
}
