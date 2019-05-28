package com.tencent.p177mm.plugin.address.p1218e;

import android.text.ClipboardManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.plugin.address.e.c */
final class C18971c {
    C18971c() {
    }

    /* renamed from: wG */
    public static void m29543wG(String str) {
        AppMethodBeat.m2504i(17012);
        ((ClipboardManager) C4996ah.getContext().getSystemService("clipboard")).setText(str);
        AppMethodBeat.m2505o(17012);
    }
}
