package com.tencent.p177mm.plugin.wenote.model.nativenote.spans;

import android.text.Editable;
import android.text.Spannable;
import android.text.style.CharacterStyle;
import com.tencent.p177mm.plugin.wenote.model.nativenote.manager.C23184e;
import com.tencent.p177mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.wenote.model.nativenote.spans.e */
public abstract class C35748e<V, C extends C46458g<V>> extends C23185t<V, C> {
    /* renamed from: cs */
    public abstract boolean mo56520cs(Object obj);

    public abstract V dfA();

    public abstract C46458g<V> dfz();

    /* Access modifiers changed, original: protected|final */
    /* renamed from: r */
    public final C23184e mo38812r(WXRTEditText wXRTEditText) {
        return new C23184e(wXRTEditText);
    }

    /* renamed from: a */
    public void mo38810a(WXRTEditText wXRTEditText, V v) {
        C23184e r = mo38812r(wXRTEditText);
        int i = r.isEmpty() ? 18 : 34;
        Editable text = wXRTEditText.getText();
        Iterator it = mo38809a(text, r, C44014s.SPAN_FLAGS).iterator();
        while (it.hasNext()) {
            Object next = it.next();
            boolean equals = dfA().equals(v);
            int spanStart = text.getSpanStart(next);
            if (spanStart < r.aqm) {
                if (equals) {
                    r.mo38805gH(r.aqm - spanStart, 0);
                    i = 34;
                } else {
                    dfA();
                    text.setSpan(dfz(), spanStart, r.aqm, 33);
                }
            }
            spanStart = text.getSpanEnd(next);
            if (spanStart > r.f4406Ls) {
                if (equals) {
                    r.mo38805gH(0, spanStart - r.f4406Ls);
                } else {
                    dfA();
                    text.setSpan(dfz(), r.f4406Ls, spanStart, 34);
                }
            }
            text.removeSpan(next);
        }
        if (v != null) {
            text.setSpan(dfz(), r.aqm, r.f4406Ls, i);
        }
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final ArrayList<Object> mo38809a(Spannable spannable, C23184e c23184e, C44014s c44014s) {
        int i = 0;
        ArrayList arrayList = new ArrayList();
        Object[] spans = spannable.getSpans(Math.max(0, c23184e.aqm - 1), Math.min(spannable.length(), c23184e.f4406Ls + 1), CharacterStyle.class);
        int length = spans.length;
        while (i < length) {
            Object obj = spans[i];
            if (mo56520cs(obj) && C35748e.m58603a(spannable, c23184e, obj, c44014s)) {
                arrayList.add(obj);
            }
            i++;
        }
        return arrayList;
    }

    /* renamed from: a */
    private static boolean m58603a(Spannable spannable, C23184e c23184e, Object obj, C44014s c44014s) {
        int spanStart = spannable.getSpanStart(obj);
        int spanEnd = spannable.getSpanEnd(obj);
        int i = c23184e.aqm;
        int i2 = c23184e.f4406Ls;
        int max = Math.max(spanStart, i);
        int min = Math.min(spanEnd, i2);
        if (max > min) {
            return false;
        }
        if (max < min) {
            return true;
        }
        if ((spanStart > i && spanEnd < i2) || (i > spanStart && i2 < spanEnd)) {
            return true;
        }
        if (c44014s == C44014s.EXACT) {
            return false;
        }
        int spanFlags = spannable.getSpanFlags(obj) & 51;
        if (spanEnd == i) {
            return C23185t.m35565f(spanFlags, 34, 18);
        }
        return C23185t.m35565f(spanFlags, 17, 18);
    }
}
