package com.bumptech.glide.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.MessageDigest;

public final class i<T> {
    private static final a<Object> azd = new a<Object>() {
        public final void a(byte[] bArr, Object obj, MessageDigest messageDigest) {
        }
    };
    final T aze;
    final a<T> azf;
    volatile byte[] azg;
    final String key;

    public interface a<T> {
        void a(byte[] bArr, T t, MessageDigest messageDigest);
    }

    static {
        AppMethodBeat.i(91686);
        AppMethodBeat.o(91686);
    }

    public static <T> i<T> Z(String str) {
        AppMethodBeat.i(91679);
        i iVar = new i(str, null, azd);
        AppMethodBeat.o(91679);
        return iVar;
    }

    public static <T> i<T> c(String str, T t) {
        AppMethodBeat.i(91680);
        i iVar = new i(str, t, azd);
        AppMethodBeat.o(91680);
        return iVar;
    }

    public static <T> i<T> a(String str, T t, a<T> aVar) {
        AppMethodBeat.i(91681);
        i iVar = new i(str, t, aVar);
        AppMethodBeat.o(91681);
        return iVar;
    }

    private i(String str, T t, a<T> aVar) {
        AppMethodBeat.i(91682);
        this.key = com.bumptech.glide.h.i.checkNotEmpty(str);
        this.aze = t;
        this.azf = (a) com.bumptech.glide.h.i.d(aVar, "Argument must not be null");
        AppMethodBeat.o(91682);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(91683);
        if (obj instanceof i) {
            boolean equals = this.key.equals(((i) obj).key);
            AppMethodBeat.o(91683);
            return equals;
        }
        AppMethodBeat.o(91683);
        return false;
    }

    public final int hashCode() {
        AppMethodBeat.i(91684);
        int hashCode = this.key.hashCode();
        AppMethodBeat.o(91684);
        return hashCode;
    }

    public final String toString() {
        AppMethodBeat.i(91685);
        String str = "Option{key='" + this.key + '\'' + '}';
        AppMethodBeat.o(91685);
        return str;
    }
}
