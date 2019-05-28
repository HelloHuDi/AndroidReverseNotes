package com.bumptech.glide.c.d.a;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.c.b.q;
import com.bumptech.glide.c.b.u;
import com.bumptech.glide.h.i;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class l implements q, u<BitmapDrawable> {
    private final Resources aEH;
    private final u<Bitmap> aFB;

    public static u<BitmapDrawable> a(Resources resources, u<Bitmap> uVar) {
        AppMethodBeat.i(92242);
        if (uVar == null) {
            AppMethodBeat.o(92242);
            return null;
        }
        u<BitmapDrawable> lVar = new l(resources, uVar);
        AppMethodBeat.o(92242);
        return lVar;
    }

    private l(Resources resources, u<Bitmap> uVar) {
        AppMethodBeat.i(92243);
        this.aEH = (Resources) i.d(resources, "Argument must not be null");
        this.aFB = (u) i.d(uVar, "Argument must not be null");
        AppMethodBeat.o(92243);
    }

    public final Class<BitmapDrawable> mK() {
        return BitmapDrawable.class;
    }

    public final int getSize() {
        AppMethodBeat.i(92244);
        int size = this.aFB.getSize();
        AppMethodBeat.o(92244);
        return size;
    }

    public final void recycle() {
        AppMethodBeat.i(92245);
        this.aFB.recycle();
        AppMethodBeat.o(92245);
    }

    public final void initialize() {
        AppMethodBeat.i(92246);
        if (this.aFB instanceof q) {
            ((q) this.aFB).initialize();
        }
        AppMethodBeat.o(92246);
    }

    public final /* synthetic */ Object get() {
        AppMethodBeat.i(92247);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(this.aEH, (Bitmap) this.aFB.get());
        AppMethodBeat.o(92247);
        return bitmapDrawable;
    }
}
