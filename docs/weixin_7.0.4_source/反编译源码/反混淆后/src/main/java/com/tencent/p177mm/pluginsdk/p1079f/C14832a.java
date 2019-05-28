package com.tencent.p177mm.pluginsdk.p1079f;

import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipboardManager;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.pluginsdk.f.a */
public final class C14832a {
    /* renamed from: b */
    public static void m23084b(CharSequence charSequence, CharSequence charSequence2) {
        AppMethodBeat.m2504i(79446);
        if (VERSION.SDK_INT >= 11) {
            C35784b c35784b = new C35784b();
            C35784b.m58650b(charSequence, charSequence2);
            AppMethodBeat.m2505o(79446);
            return;
        }
        C40421c c40421c = new C40421c();
        C40421c.m69331N(charSequence2);
        AppMethodBeat.m2505o(79446);
    }

    public static CharSequence dhS() {
        AppMethodBeat.m2504i(79447);
        CharSequence text;
        if (VERSION.SDK_INT >= 11) {
            C35784b c35784b = new C35784b();
            ClipData primaryClip = ((ClipboardManager) C4996ah.getContext().getSystemService("clipboard")).getPrimaryClip();
            if (primaryClip == null || primaryClip.getItemCount() <= 0) {
                AppMethodBeat.m2505o(79447);
                return null;
            }
            Item itemAt = primaryClip.getItemAt(0);
            if (itemAt == null) {
                AppMethodBeat.m2505o(79447);
                return null;
            }
            text = itemAt.getText();
            AppMethodBeat.m2505o(79447);
            return text;
        }
        C40421c c40421c = new C40421c();
        text = ((android.text.ClipboardManager) C4996ah.getContext().getSystemService("clipboard")).getText();
        AppMethodBeat.m2505o(79447);
        return text;
    }
}
