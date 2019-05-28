package com.bumptech.glide.c.d.f;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.c.b.a.e;
import com.bumptech.glide.c.b.u;
import com.bumptech.glide.c.d.a.d;
import com.bumptech.glide.c.j;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c implements e<Drawable, byte[]> {
    private final e<Bitmap, byte[]> aGq;
    private final e<com.bumptech.glide.c.d.e.c, byte[]> aGr;
    private final e awf;

    public c(e eVar, e<Bitmap, byte[]> eVar2, e<com.bumptech.glide.c.d.e.c, byte[]> eVar3) {
        this.awf = eVar;
        this.aGq = eVar2;
        this.aGr = eVar3;
    }

    public final u<byte[]> a(u<Drawable> uVar, j jVar) {
        AppMethodBeat.i(92363);
        Drawable drawable = (Drawable) uVar.get();
        if (drawable instanceof BitmapDrawable) {
            u a = this.aGq.a(d.a(((BitmapDrawable) drawable).getBitmap(), this.awf), jVar);
            AppMethodBeat.o(92363);
            return a;
        } else if (drawable instanceof com.bumptech.glide.c.d.e.c) {
            u<byte[]> a2 = this.aGr.a(uVar, jVar);
            AppMethodBeat.o(92363);
            return a2;
        } else {
            AppMethodBeat.o(92363);
            return null;
        }
    }
}
