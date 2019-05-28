package com.tencent.p177mm.p612ui.chatting.p624m;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.chatting.p624m.C36199a.C30557b;
import com.tencent.p177mm.plugin.messenger.p993a.C34529a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Map;

/* renamed from: com.tencent.mm.ui.chatting.m.c */
public final class C36876c extends C36199a {
    public C36876c(C30557b c30557b) {
        super(c30557b);
    }

    /* Access modifiers changed, original: final */
    public final String dHh() {
        return "link_revoke";
    }

    /* Access modifiers changed, original: final */
    /* renamed from: b */
    public final CharSequence mo10981b(Map<String, String> map, String str, Bundle bundle, WeakReference<Context> weakReference) {
        AppMethodBeat.m2504i(32745);
        String str2 = (String) map.get(str + ".title");
        final LinkedList linkedList = new LinkedList();
        int i = 0;
        while (true) {
            Object obj = str + ".usernamelist.username";
            if (i != 0) {
                obj = obj + i;
            }
            String str3 = (String) map.get(obj);
            if (C5046bo.isNullOrNil(str3)) {
                SpannableString spannableString = new SpannableString(str2);
                spannableString.setSpan(new C34529a() {
                    public final void onClickImp(View view) {
                        AppMethodBeat.m2504i(32744);
                        C36876c c36876c = C36876c.this;
                        LinkedList linkedList = linkedList;
                        if (!(c36876c.zaF == null || c36876c.zaF.get() == null)) {
                            ((C30557b) c36876c.zaF.get()).mo48965aL(linkedList);
                        }
                        AppMethodBeat.m2505o(32744);
                    }
                }, 0, str2.length(), 33);
                AppMethodBeat.m2505o(32745);
                return spannableString;
            }
            linkedList.add(str3);
            i++;
        }
    }
}
