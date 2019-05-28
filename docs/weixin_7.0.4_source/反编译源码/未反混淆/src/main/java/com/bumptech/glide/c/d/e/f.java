package com.bumptech.glide.c.d.e;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.c;
import com.bumptech.glide.c.b.u;
import com.bumptech.glide.c.d.a.d;
import com.bumptech.glide.c.m;
import com.bumptech.glide.h.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.MessageDigest;

public final class f implements m<c> {
    private final m<Bitmap> aFv;

    public f(m<Bitmap> mVar) {
        AppMethodBeat.i(92337);
        this.aFv = (m) i.d(mVar, "Argument must not be null");
        AppMethodBeat.o(92337);
    }

    public final u<c> a(Context context, u<c> uVar, int i, int i2) {
        AppMethodBeat.i(92338);
        c cVar = (c) uVar.get();
        d dVar = new d(cVar.ny(), c.ae(context).awf);
        u a = this.aFv.a(context, dVar, i, i2);
        if (!dVar.equals(a)) {
            dVar.recycle();
        }
        Bitmap bitmap = (Bitmap) a.get();
        cVar.aFU.aGa.a(this.aFv, bitmap);
        AppMethodBeat.o(92338);
        return uVar;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(92339);
        if (obj instanceof f) {
            boolean equals = this.aFv.equals(((f) obj).aFv);
            AppMethodBeat.o(92339);
            return equals;
        }
        AppMethodBeat.o(92339);
        return false;
    }

    public final int hashCode() {
        AppMethodBeat.i(92340);
        int hashCode = this.aFv.hashCode();
        AppMethodBeat.o(92340);
        return hashCode;
    }

    public final void a(MessageDigest messageDigest) {
        AppMethodBeat.i(92341);
        this.aFv.a(messageDigest);
        AppMethodBeat.o(92341);
    }
}
