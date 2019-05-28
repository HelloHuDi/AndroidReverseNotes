package com.tencent.mm.plugin.soter.c;

import android.app.Activity;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.soter.d.j;
import com.tencent.mm.plugin.soter.d.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.lang.ref.WeakReference;

public enum a {
    ;

    private a(String str) {
    }

    static {
        AppMethodBeat.o(73863);
    }

    public static c a(Activity activity, j jVar, k kVar, Handler handler) {
        AppMethodBeat.i(73862);
        if ((jVar.rOi & 1) == 0 || !com.tencent.soter.core.a.iP(ah.getContext())) {
            ab.e("MicroMsg.SoterControllerFactory", "hy: no matching: %d", Byte.valueOf(jVar.rOi));
            AppMethodBeat.o(73862);
            return null;
        }
        b bVar = new b(new WeakReference(activity), jVar, kVar, handler);
        AppMethodBeat.o(73862);
        return bVar;
    }
}
