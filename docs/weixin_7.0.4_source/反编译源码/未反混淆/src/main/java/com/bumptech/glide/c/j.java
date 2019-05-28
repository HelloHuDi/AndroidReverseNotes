package com.bumptech.glide.c;

import android.support.v4.f.a;
import com.bumptech.glide.h.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.MessageDigest;

public final class j implements h {
    public final a<i<?>, Object> azh = new b();

    public j() {
        AppMethodBeat.i(91687);
        AppMethodBeat.o(91687);
    }

    public final void a(j jVar) {
        AppMethodBeat.i(91688);
        this.azh.a(jVar.azh);
        AppMethodBeat.o(91688);
    }

    public final <T> T a(i<T> iVar) {
        AppMethodBeat.i(91689);
        if (this.azh.containsKey(iVar)) {
            Object obj = this.azh.get(iVar);
            AppMethodBeat.o(91689);
            return obj;
        }
        T t = iVar.aze;
        AppMethodBeat.o(91689);
        return t;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(91690);
        if (obj instanceof j) {
            boolean equals = this.azh.equals(((j) obj).azh);
            AppMethodBeat.o(91690);
            return equals;
        }
        AppMethodBeat.o(91690);
        return false;
    }

    public final int hashCode() {
        AppMethodBeat.i(91691);
        int hashCode = this.azh.hashCode();
        AppMethodBeat.o(91691);
        return hashCode;
    }

    public final void a(MessageDigest messageDigest) {
        AppMethodBeat.i(91692);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.azh.size()) {
                i iVar = (i) this.azh.keyAt(i2);
                Object valueAt = this.azh.valueAt(i2);
                i.a aVar = iVar.azf;
                if (iVar.azg == null) {
                    iVar.azg = iVar.key.getBytes(h.azc);
                }
                aVar.a(iVar.azg, valueAt, messageDigest);
                i = i2 + 1;
            } else {
                AppMethodBeat.o(91692);
                return;
            }
        }
    }

    public final String toString() {
        AppMethodBeat.i(91693);
        String str = "Options{values=" + this.azh + '}';
        AppMethodBeat.o(91693);
        return str;
    }
}
