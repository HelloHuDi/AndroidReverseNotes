package com.bumptech.glide.c.d.a;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.c.b.a.e;
import com.bumptech.glide.c.b.u;
import com.bumptech.glide.c.c;
import com.bumptech.glide.c.j;
import com.bumptech.glide.c.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public final class b implements l<BitmapDrawable> {
    private final l<Bitmap> aAN;
    private final e awf;

    public final /* synthetic */ boolean a(Object obj, File file, j jVar) {
        AppMethodBeat.i(92183);
        boolean a = this.aAN.a(new d(((BitmapDrawable) ((u) obj).get()).getBitmap(), this.awf), file, jVar);
        AppMethodBeat.o(92183);
        return a;
    }

    public b(e eVar, l<Bitmap> lVar) {
        this.awf = eVar;
        this.aAN = lVar;
    }

    public final c b(j jVar) {
        AppMethodBeat.i(92182);
        c b = this.aAN.b(jVar);
        AppMethodBeat.o(92182);
        return b;
    }
}
