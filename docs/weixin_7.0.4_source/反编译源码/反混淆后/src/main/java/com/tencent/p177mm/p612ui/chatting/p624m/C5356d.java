package com.tencent.p177mm.p612ui.chatting.p624m;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.chatting.p624m.C36199a.C15705a;
import com.tencent.p177mm.p612ui.chatting.p624m.C36199a.C30557b;
import com.tencent.p177mm.plugin.messenger.p993a.C34529a;
import java.lang.ref.WeakReference;
import java.util.Map;

/* renamed from: com.tencent.mm.ui.chatting.m.d */
public final class C5356d extends C36199a {
    public C5356d(C30557b c30557b) {
        super(c30557b);
    }

    /* Access modifiers changed, original: final */
    public final String dHh() {
        return "link_revoke_qrcode";
    }

    /* Access modifiers changed, original: final */
    /* renamed from: b */
    public final CharSequence mo10981b(Map<String, String> map, String str, Bundle bundle, WeakReference<Context> weakReference) {
        AppMethodBeat.m2504i(32747);
        String str2 = (String) map.get(str + ".title");
        final C15705a c15705a = new C15705a();
        c15705a.username = (String) map.get(str + ".username");
        c15705a.link = (String) map.get(str + ".qrcode");
        SpannableString spannableString = new SpannableString(str2);
        spannableString.setSpan(new C34529a() {
            public final void onClickImp(View view) {
                AppMethodBeat.m2504i(32746);
                C5356d c5356d = C5356d.this;
                C15705a c15705a = c15705a;
                if (!(c5356d.zaF == null || c5356d.zaF.get() == null)) {
                    ((C30557b) c5356d.zaF.get()).mo48964a(view, c15705a);
                }
                AppMethodBeat.m2505o(32746);
            }
        }, 0, str2.length(), 33);
        AppMethodBeat.m2505o(32747);
        return spannableString;
    }
}
