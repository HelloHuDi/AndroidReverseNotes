package com.bumptech.glide.p086c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;

/* renamed from: com.bumptech.glide.c.e */
public final class C31966e extends IOException {
    private final int statusCode;

    public C31966e(int i) {
        this("Http request failed with status code: ".concat(String.valueOf(i)), i);
        AppMethodBeat.m2504i(91673);
        AppMethodBeat.m2505o(91673);
    }

    public C31966e(String str) {
        this(str, -1);
    }

    public C31966e(String str, int i) {
        this(str, i, (byte) 0);
    }

    private C31966e(String str, int i, byte b) {
        super(str, null);
        this.statusCode = i;
    }
}
