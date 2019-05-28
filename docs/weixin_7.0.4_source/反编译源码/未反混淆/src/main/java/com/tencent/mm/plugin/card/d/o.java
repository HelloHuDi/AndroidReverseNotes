package com.tencent.mm.plugin.card.d;

import android.text.ClipboardManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;

final class o {
    o() {
    }

    public static void wG(String str) {
        AppMethodBeat.i(88941);
        ((ClipboardManager) ah.getContext().getSystemService("clipboard")).setText(str);
        AppMethodBeat.o(88941);
    }
}
