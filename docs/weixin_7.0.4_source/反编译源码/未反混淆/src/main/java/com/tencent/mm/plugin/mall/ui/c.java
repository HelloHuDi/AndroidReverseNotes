package com.tencent.mm.plugin.mall.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ah;

public final class c {
    private static boolean ony = false;

    public static void iR(boolean z) {
        ony = z;
    }

    public static int bNr() {
        AppMethodBeat.i(43248);
        int color;
        if (ony) {
            color = ah.getContext().getResources().getColor(R.color.uk);
            AppMethodBeat.o(43248);
            return color;
        }
        color = ah.getContext().getResources().getColor(R.color.x);
        AppMethodBeat.o(43248);
        return color;
    }
}
