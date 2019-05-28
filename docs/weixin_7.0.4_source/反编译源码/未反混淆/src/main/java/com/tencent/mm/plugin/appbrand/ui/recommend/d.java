package com.tencent.mm.plugin.appbrand.ui.recommend;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.f;

public final class d implements f {
    public static final d iPZ = new d();
    public int fsc = 0;
    public int iPY = 0;

    public final Bitmap y(Bitmap bitmap) {
        AppMethodBeat.i(133564);
        if (bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
            AppMethodBeat.o(133564);
            return bitmap;
        }
        Bitmap a;
        float f;
        if (bitmap.getWidth() == bitmap.getHeight()) {
            f = (float) this.iPY;
            if (this.fsc > 0 && this.iPY > 0) {
                f = (float) ((this.iPY * bitmap.getWidth()) / this.fsc);
            }
            a = com.tencent.mm.sdk.platformtools.d.a(bitmap, false, f);
        } else {
            int min = Math.min(bitmap.getWidth(), bitmap.getHeight());
            if (min <= 0) {
                min = Math.max(bitmap.getWidth(), bitmap.getHeight());
            }
            Bitmap b = com.tencent.mm.sdk.platformtools.d.b(bitmap, min, min, true);
            f = (float) this.iPY;
            if (this.fsc > 0 && this.iPY > 0) {
                f = (float) ((this.iPY * b.getWidth()) / this.fsc);
            }
            a = com.tencent.mm.sdk.platformtools.d.a(b, false, f);
        }
        AppMethodBeat.o(133564);
        return a;
    }

    public final String wP() {
        return "WxaRecommendIcon";
    }

    static {
        AppMethodBeat.i(133565);
        AppMethodBeat.o(133565);
    }
}
