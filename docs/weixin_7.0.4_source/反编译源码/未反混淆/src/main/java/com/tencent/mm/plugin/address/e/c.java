package com.tencent.mm.plugin.address.e;

import android.text.ClipboardManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;

final class c {
    c() {
    }

    public static void wG(String str) {
        AppMethodBeat.i(17012);
        ((ClipboardManager) ah.getContext().getSystemService("clipboard")).setText(str);
        AppMethodBeat.o(17012);
    }
}
