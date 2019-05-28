package com.tencent.mm.plugin.appbrand.ui.collection;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appusage.af;
import com.tencent.mm.plugin.appbrand.widget.f.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

public final class h {
    public static boolean a(boolean z, Context context, String str, int i) {
        AppMethodBeat.i(133322);
        if (z) {
            try {
                if (((af) g.K(af.class)).aD(str, i)) {
                    new c(context).F(context.getResources().getString(R.string.oc)).show();
                    AppMethodBeat.o(133322);
                    return true;
                }
                r(context, z);
            } catch (Exception e) {
                ab.e("MicroMsg.CollectionModifyInteractLogic", "performClick, (%s %d) added = %b, modify e = %s", str, Integer.valueOf(i), Boolean.valueOf(z), e);
                r(context, z);
            }
        } else {
            int aC = ((af) g.K(af.class)).aC(str, i);
            com.tencent.mm.ui.widget.a.c a;
            if (aC == 0) {
                new c(context).F(context.getResources().getString(R.string.ob)).show();
                AppMethodBeat.o(133322);
                return true;
            } else if (aC == -2) {
                aC = ((af) g.K(af.class)).awY();
                a = com.tencent.mm.ui.base.h.a(context, context.getResources().getString(R.string.ht, new Object[]{Integer.valueOf(aC)}), "", context.getResources().getString(R.string.s6), null);
                if (a != null) {
                    a.setCanceledOnTouchOutside(false);
                    a.qZ(true);
                }
            } else if (aC == -3) {
                a = com.tencent.mm.ui.base.h.a(context, context.getResources().getString(R.string.gh), "", context.getResources().getString(R.string.s6), null);
                if (a != null) {
                    a.setCanceledOnTouchOutside(false);
                    a.qZ(true);
                }
            } else {
                r(context, z);
            }
        }
        AppMethodBeat.o(133322);
        return false;
    }

    private static void r(final Context context, final boolean z) {
        AppMethodBeat.i(133323);
        al.d(new Runnable() {
            public final void run() {
                CharSequence string;
                AppMethodBeat.i(133321);
                Context context = context;
                if (z) {
                    string = context.getString(R.string.hf);
                } else {
                    string = context.getString(R.string.hd);
                }
                Toast.makeText(context, string, 0).show();
                AppMethodBeat.o(133321);
            }
        });
        AppMethodBeat.o(133323);
    }
}
