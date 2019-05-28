package com.tencent.mm.platformtools;

import android.os.Build.VERSION;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class r {
    public static void ci(View view) {
        AppMethodBeat.i(16669);
        if (view == null) {
            AppMethodBeat.o(16669);
            return;
        }
        if (VERSION.SDK_INT >= 11) {
            u uVar = new u();
            if (VERSION.SDK_INT >= 11) {
                view.setLayerType(1, null);
            }
        }
        AppMethodBeat.o(16669);
    }
}
