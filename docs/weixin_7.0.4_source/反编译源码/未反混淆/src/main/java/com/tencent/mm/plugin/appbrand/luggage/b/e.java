package com.tencent.mm.plugin.appbrand.luggage.b;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.c;
import com.tencent.mm.cb.g;
import com.tencent.mm.plugin.appbrand.widget.input.a.b;
import com.tencent.mm.plugin.appbrand.widget.input.a.b.a;

@l(dWo = {1, 1, 13}, dWp = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0007\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J$\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u000f"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/luggage/customize/LuggageEmojiCompatByWechat;", "Lcom/tencent/mm/plugin/appbrand/widget/input/emoji/IEmojiCompat;", "()V", "getEmojiItemBySoftBank", "Lcom/tencent/mm/plugin/appbrand/widget/input/emoji/IEmojiCompat$EmojiInfo;", "codePoint", "", "getSmileySpan", "Landroid/text/SpannableString;", "context", "Landroid/content/Context;", "source", "", "sizePx", "", "plugin-appbrand-integration_release"})
public final class e implements b {
    public final SpannableString a(Context context, CharSequence charSequence, float f) {
        AppMethodBeat.i(134724);
        SpannableString b = g.dqQ().b(charSequence, f);
        j.o(b, "SmileyManager.getInstanc…(context, source, sizePx)");
        AppMethodBeat.o(134724);
        return b;
    }

    public final a pe(int i) {
        AppMethodBeat.i(134725);
        c Mi = com.tencent.mm.cb.b.dqD().Mi(i);
        if (Mi != null) {
            a aVar = new a();
            aVar.jik = Mi.jik;
            aVar.jil = Mi.jil;
            aVar.jim = Mi.jim;
            AppMethodBeat.o(134725);
            return aVar;
        }
        AppMethodBeat.o(134725);
        return null;
    }
}
