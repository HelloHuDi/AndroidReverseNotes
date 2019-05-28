package com.bumptech.glide.c.d.a;

import android.graphics.Bitmap;
import com.bumptech.glide.c.b.u;
import com.bumptech.glide.c.j;
import com.bumptech.glide.c.k;
import com.bumptech.glide.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public final class e implements k<ByteBuffer, Bitmap> {
    private final h aEV;

    public final /* synthetic */ u a(Object obj, int i, int i2, j jVar) {
        AppMethodBeat.i(92192);
        u a = this.aEV.a(a.e((ByteBuffer) obj), i, i2, jVar, h.aFq);
        AppMethodBeat.o(92192);
        return a;
    }

    public e(h hVar) {
        this.aEV = hVar;
    }

    public final /* bridge */ /* synthetic */ boolean a(Object obj, j jVar) {
        return true;
    }
}
