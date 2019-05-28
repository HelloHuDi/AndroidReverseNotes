package com.bumptech.glide.c.b.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class f implements e {
    public void g(Bitmap bitmap) {
        AppMethodBeat.i(91911);
        bitmap.recycle();
        AppMethodBeat.o(91911);
    }

    public final Bitmap c(int i, int i2, Config config) {
        AppMethodBeat.i(91912);
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, config);
        AppMethodBeat.o(91912);
        return createBitmap;
    }

    public final void mO() {
    }

    public final void trimMemory(int i) {
    }

    public final Bitmap h(int i, int i2, Config config) {
        AppMethodBeat.i(91913);
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, config);
        AppMethodBeat.o(91913);
        return createBitmap;
    }
}
