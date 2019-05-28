package com.tencent.p177mm.plugin.appbrand.p336ui.recommend;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelappbrand.p873a.C37926b.C37932f;
import com.tencent.p177mm.sdk.platformtools.C5056d;

/* renamed from: com.tencent.mm.plugin.appbrand.ui.recommend.d */
public final class C27346d implements C37932f {
    public static final C27346d iPZ = new C27346d();
    public int fsc = 0;
    public int iPY = 0;

    /* renamed from: y */
    public final Bitmap mo22474y(Bitmap bitmap) {
        AppMethodBeat.m2504i(133564);
        if (bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
            AppMethodBeat.m2505o(133564);
            return bitmap;
        }
        Bitmap a;
        float f;
        if (bitmap.getWidth() == bitmap.getHeight()) {
            f = (float) this.iPY;
            if (this.fsc > 0 && this.iPY > 0) {
                f = (float) ((this.iPY * bitmap.getWidth()) / this.fsc);
            }
            a = C5056d.m7616a(bitmap, false, f);
        } else {
            int min = Math.min(bitmap.getWidth(), bitmap.getHeight());
            if (min <= 0) {
                min = Math.max(bitmap.getWidth(), bitmap.getHeight());
            }
            Bitmap b = C5056d.m7649b(bitmap, min, min, true);
            f = (float) this.iPY;
            if (this.fsc > 0 && this.iPY > 0) {
                f = (float) ((this.iPY * b.getWidth()) / this.fsc);
            }
            a = C5056d.m7616a(b, false, f);
        }
        AppMethodBeat.m2505o(133564);
        return a;
    }

    /* renamed from: wP */
    public final String mo6523wP() {
        return "WxaRecommendIcon";
    }

    static {
        AppMethodBeat.m2504i(133565);
        AppMethodBeat.m2505o(133565);
    }
}
