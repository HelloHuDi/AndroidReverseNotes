package com.tencent.p177mm.compatible.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C40619x;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5018as;

@Deprecated
/* renamed from: com.tencent.mm.compatible.util.j */
public final class C18175j extends C40619x {
    /* renamed from: Mv */
    public static final int m28617Mv() {
        return xyv;
    }

    @TargetApi(11)
    /* renamed from: r */
    public static final void m28619r(Activity activity) {
        AppMethodBeat.m2504i(93098);
        if (activity == null) {
            AppMethodBeat.m2505o(93098);
            return;
        }
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        xyv = (activity.getResources().getDisplayMetrics().heightPixels - C1441a.m3066q(activity)) - rect.top;
        AppMethodBeat.m2505o(93098);
    }

    /* renamed from: Mw */
    public static final int m28618Mw() {
        AppMethodBeat.m2504i(93100);
        int i = C5018as.amF(C4996ah.doA()).getInt("com.tencent.mm.compatible.util.keybord.height", 0);
        AppMethodBeat.m2505o(93100);
        return i;
    }

    /* renamed from: x */
    public static final void m28620x(Context context, int i) {
        AppMethodBeat.m2504i(93099);
        int as = C40619x.m70066as(context, 0);
        int gr = C40619x.m70072gr(context);
        if (i >= as) {
            as = i;
        }
        if (as <= gr) {
            gr = as;
        }
        if (C40619x.xyu != gr && C40619x.m70074gt(context) && gr >= 0) {
            C40619x.xyu = gr;
            C4990ab.m7411d("MicroMsg.KeyBordUtil", "save keybord: %d", Integer.valueOf(gr));
            C4996ah.doB().edit().putInt("com.tencent.mm.compatible.util.keybord.height", gr).commit();
        }
        C5018as.amF(C4996ah.doA()).putInt("com.tencent.mm.compatible.util.keybord.height", gr);
        AppMethodBeat.m2505o(93099);
    }
}
