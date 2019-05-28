package com.tencent.mm.ui.chatting.m;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.chatting.m.a.a;
import com.tencent.mm.ui.chatting.m.a.b;
import java.lang.ref.WeakReference;
import java.util.Map;

public final class d extends a {
    public d(b bVar) {
        super(bVar);
    }

    /* Access modifiers changed, original: final */
    public final String dHh() {
        return "link_revoke_qrcode";
    }

    /* Access modifiers changed, original: final */
    public final CharSequence b(Map<String, String> map, String str, Bundle bundle, WeakReference<Context> weakReference) {
        AppMethodBeat.i(32747);
        String str2 = (String) map.get(str + ".title");
        final a aVar = new a();
        aVar.username = (String) map.get(str + ".username");
        aVar.link = (String) map.get(str + ".qrcode");
        SpannableString spannableString = new SpannableString(str2);
        spannableString.setSpan(new com.tencent.mm.plugin.messenger.a.a() {
            public final void onClickImp(View view) {
                AppMethodBeat.i(32746);
                d dVar = d.this;
                a aVar = aVar;
                if (!(dVar.zaF == null || dVar.zaF.get() == null)) {
                    ((b) dVar.zaF.get()).a(view, aVar);
                }
                AppMethodBeat.o(32746);
            }
        }, 0, str2.length(), 33);
        AppMethodBeat.o(32747);
        return spannableString;
    }
}
