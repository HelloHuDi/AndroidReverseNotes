package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.text.Spannable;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.b;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.e;
import com.tencent.ttpic.baseutils.IOUtils;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class o<V, C extends g<V>> extends t<V, C> {
    public abstract void a(WXRTEditText wXRTEditText, e eVar, V v);

    /* Access modifiers changed, original: protected|final */
    public final e r(WXRTEditText wXRTEditText) {
        return wXRTEditText.getParagraphsInSelection();
    }

    public final void a(WXRTEditText wXRTEditText, V v) {
        e paragraphsInSelection = wXRTEditText.getParagraphsInSelection();
        if (wXRTEditText.uQb && wXRTEditText.getSelection().aqm == paragraphsInSelection.aqm && paragraphsInSelection.aqm > 1) {
            ArrayList a = a(wXRTEditText.getText(), paragraphsInSelection, s.SPAN_FLAGS);
            if (!a.isEmpty() && wXRTEditText.getLayout().getPrimaryHorizontal(wXRTEditText.getSelection().aqm) == ((float) b.del())) {
                Iterator it = a.iterator();
                while (it.hasNext()) {
                    wXRTEditText.getText().removeSpan(it.next());
                }
                wXRTEditText.getText().insert(paragraphsInSelection.aqm - 1, IOUtils.LINE_SEPARATOR_UNIX);
            }
        }
        a(wXRTEditText, paragraphsInSelection, (Object) v);
        u.a(wXRTEditText, this);
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(Spannable spannable, n nVar, p pVar) {
        pVar.a(a(spannable, (e) nVar, s.EXACT), nVar);
    }

    /* Access modifiers changed, original: protected|final */
    public final ArrayList<Object> a(Spannable spannable, e eVar, s sVar) {
        ArrayList<Object> arrayList = new ArrayList();
        Type[] actualTypeArguments = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments();
        if (actualTypeArguments == null) {
            return null;
        }
        for (Object obj : spannable.getSpans(eVar.aqm, eVar.Ls, (Class) actualTypeArguments[actualTypeArguments.length - 1])) {
            if (a(spannable, eVar, obj, sVar)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    private static boolean a(Spannable spannable, e eVar, Object obj, s sVar) {
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
        if (sVar != s.EXACT) {
            int spanFlags = spannable.getSpanFlags(obj) & 51;
            if (spanEnd == i) {
                return t.f(spanFlags, 34, 18);
            }
            return t.f(spanFlags, 17, 18);
        } else if (spanStart == i && spanEnd == i2 && i == i2) {
            return true;
        } else {
            return false;
        }
    }
}
