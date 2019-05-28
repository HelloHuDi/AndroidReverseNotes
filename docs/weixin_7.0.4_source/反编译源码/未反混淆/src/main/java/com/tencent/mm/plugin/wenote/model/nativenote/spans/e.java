package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.text.Editable;
import android.text.Spannable;
import android.text.style.CharacterStyle;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class e<V, C extends g<V>> extends t<V, C> {
    public abstract boolean cs(Object obj);

    public abstract V dfA();

    public abstract g<V> dfz();

    /* Access modifiers changed, original: protected|final */
    public final com.tencent.mm.plugin.wenote.model.nativenote.manager.e r(WXRTEditText wXRTEditText) {
        return new com.tencent.mm.plugin.wenote.model.nativenote.manager.e(wXRTEditText);
    }

    public void a(WXRTEditText wXRTEditText, V v) {
        com.tencent.mm.plugin.wenote.model.nativenote.manager.e r = r(wXRTEditText);
        int i = r.isEmpty() ? 18 : 34;
        Editable text = wXRTEditText.getText();
        Iterator it = a(text, r, s.SPAN_FLAGS).iterator();
        while (it.hasNext()) {
            Object next = it.next();
            boolean equals = dfA().equals(v);
            int spanStart = text.getSpanStart(next);
            if (spanStart < r.aqm) {
                if (equals) {
                    r.gH(r.aqm - spanStart, 0);
                    i = 34;
                } else {
                    dfA();
                    text.setSpan(dfz(), spanStart, r.aqm, 33);
                }
            }
            spanStart = text.getSpanEnd(next);
            if (spanStart > r.Ls) {
                if (equals) {
                    r.gH(0, spanStart - r.Ls);
                } else {
                    dfA();
                    text.setSpan(dfz(), r.Ls, spanStart, 34);
                }
            }
            text.removeSpan(next);
        }
        if (v != null) {
            text.setSpan(dfz(), r.aqm, r.Ls, i);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final ArrayList<Object> a(Spannable spannable, com.tencent.mm.plugin.wenote.model.nativenote.manager.e eVar, s sVar) {
        int i = 0;
        ArrayList arrayList = new ArrayList();
        Object[] spans = spannable.getSpans(Math.max(0, eVar.aqm - 1), Math.min(spannable.length(), eVar.Ls + 1), CharacterStyle.class);
        int length = spans.length;
        while (i < length) {
            Object obj = spans[i];
            if (cs(obj) && a(spannable, eVar, obj, sVar)) {
                arrayList.add(obj);
            }
            i++;
        }
        return arrayList;
    }

    private static boolean a(Spannable spannable, com.tencent.mm.plugin.wenote.model.nativenote.manager.e eVar, Object obj, s sVar) {
        int spanStart = spannable.getSpanStart(obj);
        int spanEnd = spannable.getSpanEnd(obj);
        int i = eVar.aqm;
        int i2 = eVar.Ls;
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
        if (sVar == s.EXACT) {
            return false;
        }
        int spanFlags = spannable.getSpanFlags(obj) & 51;
        if (spanEnd == i) {
            return t.f(spanFlags, 34, 18);
        }
        return t.f(spanFlags, 17, 18);
    }
}
