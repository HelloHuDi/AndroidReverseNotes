package com.tencent.mm.pluginsdk.f;

import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.ClipboardManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;

final class b {
    b() {
    }

    @TargetApi(11)
    public static void b(CharSequence charSequence, CharSequence charSequence2) {
        AppMethodBeat.i(79448);
        ((ClipboardManager) ah.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(charSequence, charSequence2));
        AppMethodBeat.o(79448);
    }
}
