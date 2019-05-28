package com.tencent.p177mm.modelappbrand.p873a;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelappbrand.p873a.C37926b.C37932f;
import com.tencent.p177mm.sdk.platformtools.C5056d;

/* renamed from: com.tencent.mm.modelappbrand.a.f */
public final class C42201f implements C37932f {
    public static final C42201f fqH = new C42201f();

    /* renamed from: y */
    public final Bitmap mo22474y(Bitmap bitmap) {
        AppMethodBeat.m2504i(77383);
        if (bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
            AppMethodBeat.m2505o(77383);
            return bitmap;
        }
        bitmap = C5056d.m7617a(bitmap, false, (float) (bitmap.getWidth() / 2), false);
        AppMethodBeat.m2505o(77383);
        return bitmap;
    }

    /* renamed from: wP */
    public final String mo6523wP() {
        return "WxaIcon";
    }

    static {
        AppMethodBeat.m2504i(77384);
        AppMethodBeat.m2505o(77384);
    }
}
