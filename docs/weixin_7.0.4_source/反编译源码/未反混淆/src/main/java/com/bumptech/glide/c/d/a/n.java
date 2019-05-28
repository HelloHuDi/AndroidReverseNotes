package com.bumptech.glide.c.d.a;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bumptech.glide.c.b.a.e;
import com.bumptech.glide.c.b.u;
import com.bumptech.glide.c.d.c.d;
import com.bumptech.glide.c.j;
import com.bumptech.glide.c.k;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class n implements k<Uri, Bitmap> {
    private final d aFC;
    private final e awf;

    public final /* synthetic */ u a(Object obj, int i, int i2, j jVar) {
        AppMethodBeat.i(92259);
        u m = this.aFC.m((Uri) obj);
        if (m == null) {
            AppMethodBeat.o(92259);
            return null;
        }
        m = i.a(this.awf, (Drawable) m.get(), i, i2);
        AppMethodBeat.o(92259);
        return m;
    }

    public final /* synthetic */ boolean a(Object obj, j jVar) {
        AppMethodBeat.i(92260);
        boolean equals = "android.resource".equals(((Uri) obj).getScheme());
        AppMethodBeat.o(92260);
        return equals;
    }

    public n(d dVar, e eVar) {
        this.aFC = dVar;
        this.awf = eVar;
    }
}
