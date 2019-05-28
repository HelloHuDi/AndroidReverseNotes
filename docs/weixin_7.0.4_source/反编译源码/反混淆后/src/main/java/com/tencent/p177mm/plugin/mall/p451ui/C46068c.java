package com.tencent.p177mm.plugin.mall.p451ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.plugin.mall.ui.c */
public final class C46068c {
    private static boolean ony = false;

    /* renamed from: iR */
    public static void m85830iR(boolean z) {
        ony = z;
    }

    public static int bNr() {
        AppMethodBeat.m2504i(43248);
        int color;
        if (ony) {
            color = C4996ah.getContext().getResources().getColor(C25738R.color.f12164uk);
            AppMethodBeat.m2505o(43248);
            return color;
        }
        color = C4996ah.getContext().getResources().getColor(C25738R.color.f11636x);
        AppMethodBeat.m2505o(43248);
        return color;
    }
}
