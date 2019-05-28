package com.bumptech.glide.c.d.f;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.c.b.u;
import com.bumptech.glide.c.d.a.l;
import com.bumptech.glide.c.j;
import com.bumptech.glide.h.i;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b implements e<Bitmap, BitmapDrawable> {
    private final Resources aEH;

    public b(Resources resources) {
        AppMethodBeat.i(92361);
        this.aEH = (Resources) i.d(resources, "Argument must not be null");
        AppMethodBeat.o(92361);
    }

    public final u<BitmapDrawable> a(u<Bitmap> uVar, j jVar) {
        AppMethodBeat.i(92362);
        u a = l.a(this.aEH, uVar);
        AppMethodBeat.o(92362);
        return a;
    }
}
