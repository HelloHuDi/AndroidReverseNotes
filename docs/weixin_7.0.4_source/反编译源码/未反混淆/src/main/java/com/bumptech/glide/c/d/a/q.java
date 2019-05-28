package com.bumptech.glide.c.d.a;

import android.graphics.Bitmap;
import com.bumptech.glide.c.b.u;
import com.bumptech.glide.c.k;
import com.bumptech.glide.h.j;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class q implements k<Bitmap, Bitmap> {

    static final class a implements u<Bitmap> {
        private final Bitmap bitmap;

        a(Bitmap bitmap) {
            this.bitmap = bitmap;
        }

        public final Class<Bitmap> mK() {
            return Bitmap.class;
        }

        public final int getSize() {
            AppMethodBeat.i(92268);
            int k = j.k(this.bitmap);
            AppMethodBeat.o(92268);
            return k;
        }

        public final void recycle() {
        }

        public final /* bridge */ /* synthetic */ Object get() {
            return this.bitmap;
        }
    }

    public final /* synthetic */ u a(Object obj, int i, int i2, com.bumptech.glide.c.j jVar) {
        AppMethodBeat.i(92269);
        a aVar = new a((Bitmap) obj);
        AppMethodBeat.o(92269);
        return aVar;
    }

    public final /* bridge */ /* synthetic */ boolean a(Object obj, com.bumptech.glide.c.j jVar) {
        return true;
    }
}
