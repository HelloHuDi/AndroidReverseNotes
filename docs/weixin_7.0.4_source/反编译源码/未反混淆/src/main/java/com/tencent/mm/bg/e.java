package com.tencent.mm.bg;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bh.d;
import com.tencent.mm.g.a.kc;
import com.tencent.mm.r.a;
import com.tencent.mm.ui.widget.a.c;

public final class e {
    public static boolean bH(Context context) {
        AppMethodBeat.i(78814);
        boolean bH = a.bH(context);
        AppMethodBeat.o(78814);
        return bH;
    }

    public static c a(Context context, int i, final Runnable runnable) {
        AppMethodBeat.i(78818);
        c.a aVar = new c.a(context);
        aVar.PV(R.string.tz);
        aVar.PZ(i);
        aVar.Qc(R.string.r4).a(new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(78812);
                if (runnable != null) {
                    runnable.run();
                }
                AppMethodBeat.o(78812);
            }
        });
        aVar.rc(true);
        aVar.f(new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(78813);
                if (runnable != null) {
                    runnable.run();
                }
                AppMethodBeat.o(78813);
            }
        });
        c aMb = aVar.aMb();
        aMb.show();
        AppMethodBeat.o(78818);
        return aMb;
    }

    public static boolean akI() {
        AppMethodBeat.i(78815);
        kc kcVar = new kc();
        kcVar.cFw.action = 2;
        com.tencent.mm.sdk.b.a.xxA.m(kcVar);
        boolean z = kcVar.cFx.cFy;
        AppMethodBeat.o(78815);
        return z;
    }

    public static boolean akJ() {
        AppMethodBeat.i(78816);
        if (g.fUs == null || !g.fUs.akv()) {
            AppMethodBeat.o(78816);
            return false;
        }
        AppMethodBeat.o(78816);
        return true;
    }

    public static boolean akK() {
        AppMethodBeat.i(78817);
        if (d.fUu == null || !d.fUu.akL()) {
            AppMethodBeat.o(78817);
            return false;
        }
        AppMethodBeat.o(78817);
        return true;
    }
}
