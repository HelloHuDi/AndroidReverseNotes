package com.bumptech.glide.c.d.a;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.c.b.u;
import com.bumptech.glide.c.j;
import com.bumptech.glide.c.k;
import com.bumptech.glide.h.i;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a<DataType> implements k<DataType, BitmapDrawable> {
    private final Resources aEH;
    private final k<DataType, Bitmap> aES;

    public a(Resources resources, k<DataType, Bitmap> kVar) {
        AppMethodBeat.i(92179);
        this.aEH = (Resources) i.d(resources, "Argument must not be null");
        this.aES = (k) i.d(kVar, "Argument must not be null");
        AppMethodBeat.o(92179);
    }

    public final boolean a(DataType dataType, j jVar) {
        AppMethodBeat.i(92180);
        boolean a = this.aES.a(dataType, jVar);
        AppMethodBeat.o(92180);
        return a;
    }

    public final u<BitmapDrawable> a(DataType dataType, int i, int i2, j jVar) {
        AppMethodBeat.i(92181);
        u a = l.a(this.aEH, this.aES.a(dataType, i, i2, jVar));
        AppMethodBeat.o(92181);
        return a;
    }
}
