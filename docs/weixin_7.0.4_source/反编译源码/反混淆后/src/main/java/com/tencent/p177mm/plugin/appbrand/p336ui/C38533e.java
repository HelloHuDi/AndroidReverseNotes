package com.tencent.p177mm.plugin.appbrand.p336ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.p057v4.p065f.C6197a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C41243o;
import com.tencent.p177mm.plugin.appbrand.C6750i;
import com.tencent.p177mm.plugin.appbrand.weishi.C33572e;
import com.tencent.p177mm.plugin.appbrand.weishi.C38567b;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.plugin.appbrand.ui.e */
public final class C38533e {
    private static final C6197a<C6750i, Bitmap> iGV = new C6197a();

    /* renamed from: a */
    public static C27333q m65259a(Context context, C41243o c41243o) {
        AppMethodBeat.m2504i(132989);
        if (context == null) {
            context = C4996ah.getContext();
        }
        C19793l c19793l = new C19793l(context);
        Bitmap bitmap = (Bitmap) iGV.remove(c41243o);
        C27333q c38567b;
        if (bitmap != null && !bitmap.isRecycled()) {
            C42694g c42694g = new C42694g(c19793l, c41243o, bitmap);
            AppMethodBeat.m2505o(132989);
            return c42694g;
        } else if (C33572e.m54822E(c41243o)) {
            c38567b = new C38567b(c19793l, c41243o);
            AppMethodBeat.m2505o(132989);
            return c38567b;
        } else if (C27331i.m43385D(c41243o)) {
            c38567b = new C45704f(c19793l, c41243o);
            AppMethodBeat.m2505o(132989);
            return c38567b;
        } else if (c41243o.mo65903xy()) {
            c38567b = new C10838c(c19793l, c41243o);
            AppMethodBeat.m2505o(132989);
            return c38567b;
        } else {
            c38567b = new C19784j(c19793l, c41243o);
            AppMethodBeat.m2505o(132989);
            return c38567b;
        }
    }

    static {
        AppMethodBeat.m2504i(132991);
        AppMethodBeat.m2505o(132991);
    }

    /* renamed from: a */
    public static void m65260a(C6750i c6750i, Bitmap bitmap) {
        AppMethodBeat.m2504i(132990);
        if (c6750i == null || bitmap == null || bitmap.isRecycled()) {
            AppMethodBeat.m2505o(132990);
            return;
        }
        iGV.put(c6750i, bitmap);
        AppMethodBeat.m2505o(132990);
    }
}
