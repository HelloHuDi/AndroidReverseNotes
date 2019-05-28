package com.tencent.p177mm.plugin.wenote.model.nativenote.spans;

import android.text.Editable;
import android.text.style.StyleSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.wenote.model.nativenote.manager.C23184e;
import com.tencent.p177mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.wenote.model.nativenote.spans.b */
public final class C36861b extends C35748e<Boolean, BoldSpan> {
    /* renamed from: a */
    public final /* synthetic */ void mo38810a(WXRTEditText wXRTEditText, Object obj) {
        AppMethodBeat.m2504i(26934);
        Boolean bool = (Boolean) obj;
        C23184e r = mo38812r(wXRTEditText);
        int i = r.isEmpty() ? 18 : 34;
        Editable text = wXRTEditText.getText();
        Iterator it = mo38809a(text, r, C44014s.SPAN_FLAGS).iterator();
        while (it.hasNext()) {
            Object next = it.next();
            boolean equals = BoldSpan.dfB().equals(bool);
            int spanStart = text.getSpanStart(next);
            if (spanStart < r.aqm) {
                if (equals) {
                    r.mo38805gH(r.aqm - spanStart, 0);
                    i = 34;
                } else {
                    BoldSpan.dfB();
                    text.setSpan(new BoldSpan(), spanStart, r.aqm, 33);
                }
            }
            spanStart = text.getSpanEnd(next);
            if (spanStart > r.f4406Ls) {
                if (equals) {
                    r.mo38805gH(0, spanStart - r.f4406Ls);
                } else {
                    BoldSpan.dfB();
                    text.setSpan(new BoldSpan(), r.f4406Ls, spanStart, 34);
                }
            }
            text.removeSpan(next);
        }
        if (bool != null && bool.booleanValue()) {
            text.setSpan(new BoldSpan(), r.aqm, r.f4406Ls, i);
        }
        AppMethodBeat.m2505o(26934);
    }

    /* renamed from: cs */
    public final boolean mo56520cs(Object obj) {
        AppMethodBeat.m2504i(26931);
        if ((obj instanceof BoldSpan) || ((obj instanceof StyleSpan) && ((StyleSpan) obj).getStyle() == 1)) {
            AppMethodBeat.m2505o(26931);
            return true;
        }
        AppMethodBeat.m2505o(26931);
        return false;
    }

    public final int dfy() {
        return 0;
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ C46458g dfz() {
        AppMethodBeat.m2504i(26932);
        BoldSpan boldSpan = new BoldSpan();
        AppMethodBeat.m2505o(26932);
        return boldSpan;
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ Object dfA() {
        AppMethodBeat.m2504i(26933);
        Boolean dfB = BoldSpan.dfB();
        AppMethodBeat.m2505o(26933);
        return dfB;
    }
}
