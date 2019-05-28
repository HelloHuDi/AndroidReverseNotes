package com.tencent.mm.sdk.platformtools;

import android.os.Build.VERSION;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class n {
    public static void ci(View view) {
        AppMethodBeat.i(51990);
        if (view == null) {
            AppMethodBeat.o(51990);
            return;
        }
        ab.b("MicroMsg.ForceGpuUtil", "setLayerType, view: %s", Integer.valueOf(view.hashCode()));
        if (VERSION.SDK_INT >= 11) {
            p pVar = new p();
            p.ci(view);
        }
        AppMethodBeat.o(51990);
    }

    public static void w(View view, int i, int i2) {
        AppMethodBeat.i(51991);
        if (view == null) {
            AppMethodBeat.o(51991);
            return;
        }
        if (VERSION.SDK_INT >= 11) {
            p pVar = new p();
            p.w(view, i, i2);
        }
        AppMethodBeat.o(51991);
    }
}
