package com.tencent.tencentmap.mapsdk.p666a;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.tencentmap.mapsdk.a.cm */
public final class C41018cm {
    /* renamed from: a */
    private C5838bl f16406a = null;

    C41018cm(C5838bl c5838bl) {
        this.f16406a = c5838bl;
    }

    /* renamed from: a */
    public final C5838bl mo65065a() {
        return this.f16406a;
    }

    /* renamed from: a */
    public final Bitmap mo65064a(Context context) {
        AppMethodBeat.m2504i(100947);
        if (this.f16406a == null) {
            AppMethodBeat.m2505o(100947);
            return null;
        }
        Bitmap a = this.f16406a.mo12311a(context);
        AppMethodBeat.m2505o(100947);
        return a;
    }
}
