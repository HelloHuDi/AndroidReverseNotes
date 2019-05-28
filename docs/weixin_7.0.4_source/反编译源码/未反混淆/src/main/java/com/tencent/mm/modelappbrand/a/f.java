package com.tencent.mm.modelappbrand.a;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.d;

public final class f implements com.tencent.mm.modelappbrand.a.b.f {
    public static final f fqH = new f();

    public final Bitmap y(Bitmap bitmap) {
        AppMethodBeat.i(77383);
        if (bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
            AppMethodBeat.o(77383);
            return bitmap;
        }
        bitmap = d.a(bitmap, false, (float) (bitmap.getWidth() / 2), false);
        AppMethodBeat.o(77383);
        return bitmap;
    }

    public final String wP() {
        return "WxaIcon";
    }

    static {
        AppMethodBeat.i(77384);
        AppMethodBeat.o(77384);
    }
}
