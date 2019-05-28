package com.tencent.mm.compatible.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.x;

@Deprecated
public final class j extends x {
    public static final int Mv() {
        return xyv;
    }

    @TargetApi(11)
    public static final void r(Activity activity) {
        AppMethodBeat.i(93098);
        if (activity == null) {
            AppMethodBeat.o(93098);
            return;
        }
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        xyv = (activity.getResources().getDisplayMetrics().heightPixels - a.q(activity)) - rect.top;
        AppMethodBeat.o(93098);
    }

    public static final int Mw() {
        AppMethodBeat.i(93100);
        int i = as.amF(ah.doA()).getInt("com.tencent.mm.compatible.util.keybord.height", 0);
        AppMethodBeat.o(93100);
        return i;
    }

    public static final void x(Context context, int i) {
        AppMethodBeat.i(93099);
        int as = x.as(context, 0);
        int gr = x.gr(context);
        if (i >= as) {
            as = i;
        }
        if (as <= gr) {
            gr = as;
        }
        if (x.xyu != gr && x.gt(context) && gr >= 0) {
            x.xyu = gr;
            ab.d("MicroMsg.KeyBordUtil", "save keybord: %d", Integer.valueOf(gr));
            ah.doB().edit().putInt("com.tencent.mm.compatible.util.keybord.height", gr).commit();
        }
        as.amF(ah.doA()).putInt("com.tencent.mm.compatible.util.keybord.height", gr);
        AppMethodBeat.o(93099);
    }
}
