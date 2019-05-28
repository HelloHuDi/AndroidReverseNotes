package com.tencent.p177mm.pluginsdk.p1079f;

import android.text.ClipboardManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.pluginsdk.f.c */
final class C40421c {
    C40421c() {
    }

    /* renamed from: N */
    public static void m69331N(CharSequence charSequence) {
        AppMethodBeat.m2504i(79449);
        ((ClipboardManager) C4996ah.getContext().getSystemService("clipboard")).setText(charSequence);
        AppMethodBeat.m2505o(79449);
    }
}
