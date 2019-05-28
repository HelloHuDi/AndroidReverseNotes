package com.tencent.mm.plugin.account.security.a;

import android.content.Context;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.act;
import com.tencent.mm.sdk.platformtools.ah;

public final class f {
    public static void n(boolean z, boolean z2) {
        AppMethodBeat.i(69842);
        if (g.RK()) {
            int YF = r.YF();
            if (z) {
                YF |= 16384;
            } else {
                YF &= -16385;
            }
            g.RP().Ry().set(40, Integer.valueOf(YF));
            if (z2) {
                act act = new act();
                act.wkw = 28;
                act.pvD = z ? 1 : 2;
                ((j) g.K(j.class)).XL().c(new a(23, act));
                com.tencent.mm.plugin.account.a.a.gkF.BS();
            }
            AppMethodBeat.o(69842);
            return;
        }
        AppMethodBeat.o(69842);
    }

    public static String cz(Context context) {
        AppMethodBeat.i(69843);
        String string;
        if (context == null) {
            if (com.tencent.mm.sdk.platformtools.g.xyg) {
                string = ah.getContext().getString(R.string.dw2);
                AppMethodBeat.o(69843);
                return string;
            }
            string = ah.getContext().getString(R.string.dw1);
            AppMethodBeat.o(69843);
            return string;
        } else if (com.tencent.mm.sdk.platformtools.g.xyg) {
            string = context.getString(R.string.dw2);
            AppMethodBeat.o(69843);
            return string;
        } else {
            string = context.getString(R.string.dw1);
            AppMethodBeat.o(69843);
            return string;
        }
    }

    public static String aqE() {
        AppMethodBeat.i(69844);
        String str = Build.MANUFACTURER + "-" + Build.MODEL;
        AppMethodBeat.o(69844);
        return str;
    }
}
