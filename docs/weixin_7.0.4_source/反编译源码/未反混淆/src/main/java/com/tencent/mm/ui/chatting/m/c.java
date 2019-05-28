package com.tencent.mm.ui.chatting.m;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.a.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.chatting.m.a.b;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Map;

public final class c extends a {
    public c(b bVar) {
        super(bVar);
    }

    /* Access modifiers changed, original: final */
    public final String dHh() {
        return "link_revoke";
    }

    /* Access modifiers changed, original: final */
    public final CharSequence b(Map<String, String> map, String str, Bundle bundle, WeakReference<Context> weakReference) {
        AppMethodBeat.i(32745);
        String str2 = (String) map.get(str + ".title");
        final LinkedList linkedList = new LinkedList();
        int i = 0;
        while (true) {
            Object obj = str + ".usernamelist.username";
            if (i != 0) {
                obj = obj + i;
            }
            String str3 = (String) map.get(obj);
            if (bo.isNullOrNil(str3)) {
                SpannableString spannableString = new SpannableString(str2);
                spannableString.setSpan(new a() {
                    public final void onClickImp(View view) {
                        AppMethodBeat.i(32744);
                        c cVar = c.this;
                        LinkedList linkedList = linkedList;
                        if (!(cVar.zaF == null || cVar.zaF.get() == null)) {
                            ((b) cVar.zaF.get()).aL(linkedList);
                        }
                        AppMethodBeat.o(32744);
                    }
                }, 0, str2.length(), 33);
                AppMethodBeat.o(32745);
                return spannableString;
            }
            linkedList.add(str3);
            i++;
        }
    }
}
