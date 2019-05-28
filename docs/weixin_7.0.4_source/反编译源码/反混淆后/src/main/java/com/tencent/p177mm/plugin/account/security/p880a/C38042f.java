package com.tencent.p177mm.plugin.account.security.p880a;

import android.content.Context;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.plugin.account.p765a.C24679a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C3464j.C3465a;
import com.tencent.p177mm.protocal.protobuf.act;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5059g;

/* renamed from: com.tencent.mm.plugin.account.security.a.f */
public final class C38042f {
    /* renamed from: n */
    public static void m64374n(boolean z, boolean z2) {
        AppMethodBeat.m2504i(69842);
        if (C1720g.m3531RK()) {
            int YF = C1853r.m3824YF();
            if (z) {
                YF |= 16384;
            } else {
                YF &= -16385;
            }
            C1720g.m3536RP().mo5239Ry().set(40, Integer.valueOf(YF));
            if (z2) {
                act act = new act();
                act.wkw = 28;
                act.pvD = z ? 1 : 2;
                ((C6982j) C1720g.m3528K(C6982j.class)).mo15368XL().mo7920c(new C3465a(23, act));
                C24679a.gkF.mo38844BS();
            }
            AppMethodBeat.m2505o(69842);
            return;
        }
        AppMethodBeat.m2505o(69842);
    }

    /* renamed from: cz */
    public static String m64373cz(Context context) {
        AppMethodBeat.m2504i(69843);
        String string;
        if (context == null) {
            if (C5059g.xyg) {
                string = C4996ah.getContext().getString(C25738R.string.dw2);
                AppMethodBeat.m2505o(69843);
                return string;
            }
            string = C4996ah.getContext().getString(C25738R.string.dw1);
            AppMethodBeat.m2505o(69843);
            return string;
        } else if (C5059g.xyg) {
            string = context.getString(C25738R.string.dw2);
            AppMethodBeat.m2505o(69843);
            return string;
        } else {
            string = context.getString(C25738R.string.dw1);
            AppMethodBeat.m2505o(69843);
            return string;
        }
    }

    public static String aqE() {
        AppMethodBeat.m2504i(69844);
        String str = Build.MANUFACTURER + "-" + Build.MODEL;
        AppMethodBeat.m2505o(69844);
        return str;
    }
}
