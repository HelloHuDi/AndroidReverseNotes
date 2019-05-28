package com.tencent.p177mm.plugin.emoji;

import android.content.Context;
import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p211cb.C26005f;
import com.tencent.p177mm.p211cb.C26005f.C26004a;
import com.tencent.p177mm.p211cb.C9212g;
import com.tencent.p177mm.plugin.emoji.p725b.C45845a;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.plugin.emoji.a */
public final class C42934a implements C45845a {
    /* renamed from: a */
    public final SpannableString mo68462a(Context context, CharSequence charSequence, float f) {
        AppMethodBeat.m2504i(62300);
        SpannableString b = C9212g.dqQ().mo20622b(charSequence, f);
        AppMethodBeat.m2505o(62300);
        return b;
    }

    /* renamed from: b */
    public final SpannableString mo68463b(Context context, CharSequence charSequence, float f) {
        AppMethodBeat.m2504i(62301);
        SpannableString b = C44089j.m79293b(context, charSequence, f);
        AppMethodBeat.m2505o(62301);
        return b;
    }

    /* renamed from: dE */
    public final String mo68464dE(String str, String str2) {
        AppMethodBeat.m2504i(62302);
        C9212g.dqQ();
        C26005f dqL = C26005f.dqL();
        C4996ah.getContext();
        int i = 0;
        int length = str.length();
        StringBuilder stringBuilder = new StringBuilder(length);
        while (i < length) {
            char charAt = str.charAt(i);
            if (charAt == IOUtils.DIR_SEPARATOR_UNIX || charAt == '[') {
                C26004a anW = dqL.anW(str.substring(i));
                if (anW != null) {
                    stringBuilder.append(str2);
                    i += anW.text.length();
                }
            }
            stringBuilder.append(charAt);
            i++;
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(62302);
        return stringBuilder2;
    }

    /* renamed from: G */
    public final boolean mo68460G(CharSequence charSequence) {
        AppMethodBeat.m2504i(62303);
        boolean G = C9212g.dqQ().mo20620G(charSequence);
        AppMethodBeat.m2505o(62303);
        return G;
    }

    /* renamed from: H */
    public final boolean mo68461H(CharSequence charSequence) {
        AppMethodBeat.m2504i(62304);
        boolean H = C9212g.dqQ().mo20621H(charSequence);
        AppMethodBeat.m2505o(62304);
        return H;
    }
}
