package com.bumptech.glide.g;

import com.bumptech.glide.c.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.MessageDigest;

public final class a implements h {
    private static final a aHT = new a();

    static {
        AppMethodBeat.i(92536);
        AppMethodBeat.o(92536);
    }

    public static a oj() {
        return aHT;
    }

    private a() {
    }

    public final String toString() {
        return "EmptySignature";
    }

    public final void a(MessageDigest messageDigest) {
    }
}
