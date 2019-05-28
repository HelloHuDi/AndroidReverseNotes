package com.tencent.mm.plugin.card.d;

import android.annotation.TargetApi;
import android.content.ClipboardManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;

final class n {
    n() {
    }

    @TargetApi(11)
    public static void wG(String str) {
        AppMethodBeat.i(88940);
        ((ClipboardManager) ah.getContext().getSystemService("clipboard")).setText(str);
        AppMethodBeat.o(88940);
    }
}
