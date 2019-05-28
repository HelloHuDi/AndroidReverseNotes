package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.text.Editable;
import android.text.style.StyleSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.e;
import java.util.Iterator;

public final class b extends e<Boolean, BoldSpan> {
    public final /* synthetic */ void a(WXRTEditText wXRTEditText, Object obj) {
        AppMethodBeat.i(26934);
        Boolean bool = (Boolean) obj;
        e r = r(wXRTEditText);
        int i = r.isEmpty() ? 18 : 34;
        Editable text = wXRTEditText.getText();
        Iterator it = a(text, r, s.SPAN_FLAGS).iterator();
        while (it.hasNext()) {
            Object next = it.next();
            boolean equals = BoldSpan.dfB().equals(bool);
            int spanStart = text.getSpanStart(next);
            if (spanStart < r.aqm) {
                if (equals) {
                    r.gH(r.aqm - spanStart, 0);
                    i = 34;
                } else {
                    BoldSpan.dfB();
                    text.setSpan(new BoldSpan(), spanStart, r.aqm, 33);
                }
            }
            spanStart = text.getSpanEnd(next);
            if (spanStart > r.Ls) {
                if (equals) {
                    r.gH(0, spanStart - r.Ls);
                } else {
                    BoldSpan.dfB();
                    text.setSpan(new BoldSpan(), r.Ls, spanStart, 34);
                }
            }
            text.removeSpan(next);
        }
        if (bool != null && bool.booleanValue()) {
            text.setSpan(new BoldSpan(), r.aqm, r.Ls, i);
        }
        AppMethodBeat.o(26934);
    }

    public final boolean cs(Object obj) {
        AppMethodBeat.i(26931);
        if ((obj instanceof BoldSpan) || ((obj instanceof StyleSpan) && ((StyleSpan) obj).getStyle() == 1)) {
            AppMethodBeat.o(26931);
            return true;
        }
        AppMethodBeat.o(26931);
        return false;
    }

    public final int dfy() {
        return 0;
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ g dfz() {
        AppMethodBeat.i(26932);
        BoldSpan boldSpan = new BoldSpan();
        AppMethodBeat.o(26932);
        return boldSpan;
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ Object dfA() {
        AppMethodBeat.i(26933);
        Boolean dfB = BoldSpan.dfB();
        AppMethodBeat.o(26933);
        return dfB;
    }
}
