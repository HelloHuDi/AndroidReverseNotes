package com.bumptech.glide.c.d.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.c;
import com.bumptech.glide.c.b.u;
import com.bumptech.glide.c.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.MessageDigest;

public final class j implements m<Drawable> {
    private final m<Bitmap> aFv;
    private final boolean aFw = true;

    public j(m<Bitmap> mVar) {
        this.aFv = mVar;
    }

    public final u<Drawable> a(Context context, u<Drawable> uVar, int i, int i2) {
        AppMethodBeat.i(92235);
        Drawable drawable = (Drawable) uVar.get();
        u a = i.a(c.ae(context).awf, drawable, i, i2);
        if (a != null) {
            u a2 = this.aFv.a(context, a, i, i2);
            if (a2.equals(a)) {
                a2.recycle();
                AppMethodBeat.o(92235);
                return uVar;
            }
            uVar = l.a(context.getResources(), a2);
            AppMethodBeat.o(92235);
            return uVar;
        } else if (this.aFw) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unable to convert " + drawable + " to a Bitmap");
            AppMethodBeat.o(92235);
            throw illegalArgumentException;
        } else {
            AppMethodBeat.o(92235);
            return uVar;
        }
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(92236);
        if (obj instanceof j) {
            boolean equals = this.aFv.equals(((j) obj).aFv);
            AppMethodBeat.o(92236);
            return equals;
        }
        AppMethodBeat.o(92236);
        return false;
    }

    public final int hashCode() {
        AppMethodBeat.i(92237);
        int hashCode = this.aFv.hashCode();
        AppMethodBeat.o(92237);
        return hashCode;
    }

    public final void a(MessageDigest messageDigest) {
        AppMethodBeat.i(92238);
        this.aFv.a(messageDigest);
        AppMethodBeat.o(92238);
    }
}
