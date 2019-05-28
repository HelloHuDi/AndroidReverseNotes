package com.tencent.mm.plugin.appbrand.launching;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s.e;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;

public enum ag {
    ;

    public static void oZ(int i) {
        AppMethodBeat.i(131954);
        Ck(ah.getResources().getString(i));
        AppMethodBeat.o(131954);
    }

    public static void Ck(final String str) {
        AppMethodBeat.i(131955);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(131951);
                Toast.makeText(ah.getContext(), str, 0).show();
                AppMethodBeat.o(131951);
            }
        });
        AppMethodBeat.o(131955);
    }

    public static String getMMString(int i, Object... objArr) {
        AppMethodBeat.i(131956);
        String mMString = e.getMMString(i, objArr);
        AppMethodBeat.o(131956);
        return mMString;
    }
}
