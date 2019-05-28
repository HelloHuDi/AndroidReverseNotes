package com.tencent.mm.pluginsdk.f;

import android.text.ClipboardManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;

final class c {
    c() {
    }

    public static void N(CharSequence charSequence) {
        AppMethodBeat.i(79449);
        ((ClipboardManager) ah.getContext().getSystemService("clipboard")).setText(charSequence);
        AppMethodBeat.o(79449);
    }
}
