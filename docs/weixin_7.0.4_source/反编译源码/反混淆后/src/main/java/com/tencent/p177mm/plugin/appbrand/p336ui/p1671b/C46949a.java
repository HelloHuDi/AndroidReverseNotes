package com.tencent.p177mm.plugin.appbrand.p336ui.p1671b;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelappbrand.p873a.C37926b.C37932f;
import com.tencent.p177mm.sdk.platformtools.C5056d;

/* renamed from: com.tencent.mm.plugin.appbrand.ui.b.a */
public final class C46949a implements C37932f {
    private final int iLU;

    public C46949a(int i) {
        this.iLU = i;
    }

    /* renamed from: wP */
    public final String mo6523wP() {
        return "AppBrandProfileLikeImageTransformation";
    }

    /* renamed from: y */
    public final Bitmap mo22474y(Bitmap bitmap) {
        AppMethodBeat.m2504i(133324);
        if (bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
            AppMethodBeat.m2505o(133324);
            return bitmap;
        }
        Bitmap a = C5056d.m7617a(bitmap, false, (float) this.iLU, false);
        if (a != null) {
            AppMethodBeat.m2505o(133324);
            return a;
        }
        AppMethodBeat.m2505o(133324);
        return bitmap;
    }
}
