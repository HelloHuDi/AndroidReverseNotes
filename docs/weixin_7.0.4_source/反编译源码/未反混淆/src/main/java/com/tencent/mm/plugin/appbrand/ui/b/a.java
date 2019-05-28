package com.tencent.mm.plugin.appbrand.ui.b;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.f;
import com.tencent.mm.sdk.platformtools.d;

public final class a implements f {
    private final int iLU;

    public a(int i) {
        this.iLU = i;
    }

    public final String wP() {
        return "AppBrandProfileLikeImageTransformation";
    }

    public final Bitmap y(Bitmap bitmap) {
        AppMethodBeat.i(133324);
        if (bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
            AppMethodBeat.o(133324);
            return bitmap;
        }
        Bitmap a = d.a(bitmap, false, (float) this.iLU, false);
        if (a != null) {
            AppMethodBeat.o(133324);
            return a;
        }
        AppMethodBeat.o(133324);
        return bitmap;
    }
}
