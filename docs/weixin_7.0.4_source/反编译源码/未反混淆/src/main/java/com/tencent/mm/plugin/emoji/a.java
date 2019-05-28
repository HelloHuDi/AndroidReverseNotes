package com.tencent.mm.plugin.emoji;

import android.content.Context;
import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.f;
import com.tencent.mm.cb.g;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.ttpic.baseutils.IOUtils;

public final class a implements com.tencent.mm.plugin.emoji.b.a {
    public final SpannableString a(Context context, CharSequence charSequence, float f) {
        AppMethodBeat.i(62300);
        SpannableString b = g.dqQ().b(charSequence, f);
        AppMethodBeat.o(62300);
        return b;
    }

    public final SpannableString b(Context context, CharSequence charSequence, float f) {
        AppMethodBeat.i(62301);
        SpannableString b = j.b(context, charSequence, f);
        AppMethodBeat.o(62301);
        return b;
    }

    public final String dE(String str, String str2) {
        AppMethodBeat.i(62302);
        g.dqQ();
        f dqL = f.dqL();
        ah.getContext();
        int i = 0;
        int length = str.length();
        StringBuilder stringBuilder = new StringBuilder(length);
        while (i < length) {
            char charAt = str.charAt(i);
            if (charAt == IOUtils.DIR_SEPARATOR_UNIX || charAt == '[') {
                com.tencent.mm.cb.f.a anW = dqL.anW(str.substring(i));
                if (anW != null) {
                    stringBuilder.append(str2);
                    i += anW.text.length();
                }
            }
            stringBuilder.append(charAt);
            i++;
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(62302);
        return stringBuilder2;
    }

    public final boolean G(CharSequence charSequence) {
        AppMethodBeat.i(62303);
        boolean G = g.dqQ().G(charSequence);
        AppMethodBeat.o(62303);
        return G;
    }

    public final boolean H(CharSequence charSequence) {
        AppMethodBeat.i(62304);
        boolean H = g.dqQ().H(charSequence);
        AppMethodBeat.o(62304);
        return H;
    }
}
