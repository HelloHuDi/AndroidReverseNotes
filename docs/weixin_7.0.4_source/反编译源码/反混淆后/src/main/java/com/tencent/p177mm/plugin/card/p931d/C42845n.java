package com.tencent.p177mm.plugin.card.p931d;

import android.annotation.TargetApi;
import android.content.ClipboardManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.plugin.card.d.n */
final class C42845n {
    C42845n() {
    }

    @TargetApi(11)
    /* renamed from: wG */
    public static void m76053wG(String str) {
        AppMethodBeat.m2504i(88940);
        ((ClipboardManager) C4996ah.getContext().getSystemService("clipboard")).setText(str);
        AppMethodBeat.m2505o(88940);
    }
}
