package com.tencent.mm.plugin.address.e;

import android.annotation.TargetApi;
import android.content.ClipboardManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;

final class b {
    b() {
    }

    @TargetApi(11)
    public static void wG(String str) {
        AppMethodBeat.i(17011);
        ((ClipboardManager) ah.getContext().getSystemService("clipboard")).setText(str);
        AppMethodBeat.o(17011);
    }
}
