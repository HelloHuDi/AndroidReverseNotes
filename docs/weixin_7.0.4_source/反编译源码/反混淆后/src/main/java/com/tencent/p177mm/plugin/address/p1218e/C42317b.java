package com.tencent.p177mm.plugin.address.p1218e;

import android.annotation.TargetApi;
import android.content.ClipboardManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.plugin.address.e.b */
final class C42317b {
    C42317b() {
    }

    @TargetApi(11)
    /* renamed from: wG */
    public static void m74837wG(String str) {
        AppMethodBeat.m2504i(17011);
        ((ClipboardManager) C4996ah.getContext().getSystemService("clipboard")).setText(str);
        AppMethodBeat.m2505o(17011);
    }
}
