package com.tencent.p177mm.pluginsdk.p1079f;

import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.ClipboardManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.pluginsdk.f.b */
final class C35784b {
    C35784b() {
    }

    @TargetApi(11)
    /* renamed from: b */
    public static void m58650b(CharSequence charSequence, CharSequence charSequence2) {
        AppMethodBeat.m2504i(79448);
        ((ClipboardManager) C4996ah.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(charSequence, charSequence2));
        AppMethodBeat.m2505o(79448);
    }
}
