package com.tencent.p177mm.plugin.card.p931d;

import android.text.ClipboardManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.plugin.card.d.o */
final class C11279o {
    C11279o() {
    }

    /* renamed from: wG */
    public static void m18994wG(String str) {
        AppMethodBeat.m2504i(88941);
        ((ClipboardManager) C4996ah.getContext().getSystemService("clipboard")).setText(str);
        AppMethodBeat.m2505o(88941);
    }
}
