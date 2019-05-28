package com.bumptech.glide.c.b;

import com.bumptech.glide.c.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.MessageDigest;

final class c implements h {
    private final h aAb;
    private final h azW;

    c(h hVar, h hVar2) {
        this.azW = hVar;
        this.aAb = hVar2;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(91758);
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (this.azW.equals(cVar.azW) && this.aAb.equals(cVar.aAb)) {
                AppMethodBeat.o(91758);
                return true;
            }
            AppMethodBeat.o(91758);
            return false;
        }
        AppMethodBeat.o(91758);
        return false;
    }

    public final int hashCode() {
        AppMethodBeat.i(91759);
        int hashCode = (this.azW.hashCode() * 31) + this.aAb.hashCode();
        AppMethodBeat.o(91759);
        return hashCode;
    }

    public final String toString() {
        AppMethodBeat.i(91760);
        String str = "DataCacheKey{sourceKey=" + this.azW + ", signature=" + this.aAb + '}';
        AppMethodBeat.o(91760);
        return str;
    }

    public final void a(MessageDigest messageDigest) {
        AppMethodBeat.i(91761);
        this.azW.a(messageDigest);
        this.aAb.a(messageDigest);
        AppMethodBeat.o(91761);
    }
}
