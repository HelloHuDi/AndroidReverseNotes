package com.tencent.mm.sdk.platformtools;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a {
    a() {
    }

    public static void ez(View view) {
        AppMethodBeat.i(93279);
        if (view != null) {
            view.setAnimation(null);
        }
        AppMethodBeat.o(93279);
    }
}
