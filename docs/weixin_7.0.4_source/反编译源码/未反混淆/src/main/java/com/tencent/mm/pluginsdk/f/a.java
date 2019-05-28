package com.tencent.mm.pluginsdk.f;

import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipboardManager;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;

public final class a {
    public static void b(CharSequence charSequence, CharSequence charSequence2) {
        AppMethodBeat.i(79446);
        if (VERSION.SDK_INT >= 11) {
            b bVar = new b();
            b.b(charSequence, charSequence2);
            AppMethodBeat.o(79446);
            return;
        }
        c cVar = new c();
        c.N(charSequence2);
        AppMethodBeat.o(79446);
    }

    public static CharSequence dhS() {
        AppMethodBeat.i(79447);
        CharSequence text;
        if (VERSION.SDK_INT >= 11) {
            b bVar = new b();
            ClipData primaryClip = ((ClipboardManager) ah.getContext().getSystemService("clipboard")).getPrimaryClip();
            if (primaryClip == null || primaryClip.getItemCount() <= 0) {
                AppMethodBeat.o(79447);
                return null;
            }
            Item itemAt = primaryClip.getItemAt(0);
            if (itemAt == null) {
                AppMethodBeat.o(79447);
                return null;
            }
            text = itemAt.getText();
            AppMethodBeat.o(79447);
            return text;
        }
        c cVar = new c();
        text = ((android.text.ClipboardManager) ah.getContext().getSystemService("clipboard")).getText();
        AppMethodBeat.o(79447);
        return text;
    }
}
