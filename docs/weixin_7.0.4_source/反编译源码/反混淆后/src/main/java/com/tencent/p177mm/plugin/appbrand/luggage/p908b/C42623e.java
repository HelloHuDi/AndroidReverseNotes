package com.tencent.p177mm.plugin.appbrand.luggage.p908b;

import android.content.Context;
import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p211cb.C37626b;
import com.tencent.p177mm.p211cb.C45278c;
import com.tencent.p177mm.p211cb.C9212g;
import com.tencent.p177mm.plugin.appbrand.widget.input.p1237a.C19859b;
import com.tencent.p177mm.plugin.appbrand.widget.input.p1237a.C19859b.C19860a;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0007\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J$\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u000f"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/luggage/customize/LuggageEmojiCompatByWechat;", "Lcom/tencent/mm/plugin/appbrand/widget/input/emoji/IEmojiCompat;", "()V", "getEmojiItemBySoftBank", "Lcom/tencent/mm/plugin/appbrand/widget/input/emoji/IEmojiCompat$EmojiInfo;", "codePoint", "", "getSmileySpan", "Landroid/text/SpannableString;", "context", "Landroid/content/Context;", "source", "", "sizePx", "", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.luggage.b.e */
public final class C42623e implements C19859b {
    /* renamed from: a */
    public final SpannableString mo35083a(Context context, CharSequence charSequence, float f) {
        AppMethodBeat.m2504i(134724);
        SpannableString b = C9212g.dqQ().mo20622b(charSequence, f);
        C25052j.m39375o(b, "SmileyManager.getInstanc…(context, source, sizePx)");
        AppMethodBeat.m2505o(134724);
        return b;
    }

    /* renamed from: pe */
    public final C19860a mo35084pe(int i) {
        AppMethodBeat.m2504i(134725);
        C45278c Mi = C37626b.dqD().mo60446Mi(i);
        if (Mi != null) {
            C19860a c19860a = new C19860a();
            c19860a.jik = Mi.jik;
            c19860a.jil = Mi.jil;
            c19860a.jim = Mi.jim;
            AppMethodBeat.m2505o(134725);
            return c19860a;
        }
        AppMethodBeat.m2505o(134725);
        return null;
    }
}
