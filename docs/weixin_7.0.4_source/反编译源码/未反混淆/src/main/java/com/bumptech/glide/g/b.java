package com.bumptech.glide.g;

import com.bumptech.glide.c.h;
import com.bumptech.glide.h.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.MessageDigest;

public final class b implements h {
    private final Object object;

    public b(Object obj) {
        AppMethodBeat.i(92537);
        this.object = i.d(obj, "Argument must not be null");
        AppMethodBeat.o(92537);
    }

    public final String toString() {
        AppMethodBeat.i(92538);
        String str = "ObjectKey{object=" + this.object + '}';
        AppMethodBeat.o(92538);
        return str;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(92539);
        if (obj instanceof b) {
            boolean equals = this.object.equals(((b) obj).object);
            AppMethodBeat.o(92539);
            return equals;
        }
        AppMethodBeat.o(92539);
        return false;
    }

    public final int hashCode() {
        AppMethodBeat.i(92540);
        int hashCode = this.object.hashCode();
        AppMethodBeat.o(92540);
        return hashCode;
    }

    public final void a(MessageDigest messageDigest) {
        AppMethodBeat.i(92541);
        messageDigest.update(this.object.toString().getBytes(azc));
        AppMethodBeat.o(92541);
    }
}
