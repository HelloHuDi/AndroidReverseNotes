package com.bumptech.glide.c.d.a;

import android.graphics.Bitmap;
import com.bumptech.glide.c.b.a.e;
import com.bumptech.glide.c.b.q;
import com.bumptech.glide.c.b.u;
import com.bumptech.glide.h.i;
import com.bumptech.glide.h.j;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d implements q, u<Bitmap> {
    private final e awf;
    private final Bitmap bitmap;

    public static d a(Bitmap bitmap, e eVar) {
        AppMethodBeat.i(92187);
        if (bitmap == null) {
            AppMethodBeat.o(92187);
            return null;
        }
        d dVar = new d(bitmap, eVar);
        AppMethodBeat.o(92187);
        return dVar;
    }

    public d(Bitmap bitmap, e eVar) {
        AppMethodBeat.i(92188);
        this.bitmap = (Bitmap) i.d(bitmap, "Bitmap must not be null");
        this.awf = (e) i.d(eVar, "BitmapPool must not be null");
        AppMethodBeat.o(92188);
    }

    public final Class<Bitmap> mK() {
        return Bitmap.class;
    }

    public final int getSize() {
        AppMethodBeat.i(92189);
        int k = j.k(this.bitmap);
        AppMethodBeat.o(92189);
        return k;
    }

    public final void recycle() {
        AppMethodBeat.i(92190);
        this.awf.g(this.bitmap);
        AppMethodBeat.o(92190);
    }

    public final void initialize() {
        AppMethodBeat.i(92191);
        this.bitmap.prepareToDraw();
        AppMethodBeat.o(92191);
    }

    public final /* bridge */ /* synthetic */ Object get() {
        return this.bitmap;
    }
}
