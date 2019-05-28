package com.tencent.p177mm.plugin.wenote.model.nativenote.spans;

import android.text.Spannable;
import com.tencent.p177mm.plugin.wenote.model.nativenote.manager.C23184e;
import com.tencent.p177mm.plugin.wenote.model.nativenote.manager.C35746b;
import com.tencent.p177mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import com.tencent.ttpic.baseutils.IOUtils;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.wenote.model.nativenote.spans.o */
public abstract class C24931o<V, C extends C46458g<V>> extends C23185t<V, C> {
    /* renamed from: a */
    public abstract void mo41817a(WXRTEditText wXRTEditText, C23184e c23184e, V v);

    /* Access modifiers changed, original: protected|final */
    /* renamed from: r */
    public final C23184e mo38812r(WXRTEditText wXRTEditText) {
        return wXRTEditText.getParagraphsInSelection();
    }

    /* renamed from: a */
    public final void mo38810a(WXRTEditText wXRTEditText, V v) {
        C23184e paragraphsInSelection = wXRTEditText.getParagraphsInSelection();
        if (wXRTEditText.uQb && wXRTEditText.getSelection().aqm == paragraphsInSelection.aqm && paragraphsInSelection.aqm > 1) {
            ArrayList a = mo38809a(wXRTEditText.getText(), paragraphsInSelection, C44014s.SPAN_FLAGS);
            if (!a.isEmpty() && wXRTEditText.getLayout().getPrimaryHorizontal(wXRTEditText.getSelection().aqm) == ((float) C35746b.del())) {
                Iterator it = a.iterator();
                while (it.hasNext()) {
                    wXRTEditText.getText().removeSpan(it.next());
                }
                wXRTEditText.getText().insert(paragraphsInSelection.aqm - 1, IOUtils.LINE_SEPARATOR_UNIX);
            }
        }
        mo41817a(wXRTEditText, paragraphsInSelection, (Object) v);
        C29993u.m47470a(wXRTEditText, this);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo41816a(Spannable spannable, C29992n c29992n, C44011p c44011p) {
        c44011p.mo69686a(mo38809a(spannable, (C23184e) c29992n, C44014s.EXACT), c29992n);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final ArrayList<Object> mo38809a(Spannable spannable, C23184e c23184e, C44014s c44014s) {
        ArrayList<Object> arrayList = new ArrayList();
        Type[] actualTypeArguments = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments();
        if (actualTypeArguments == null) {
            return null;
        }
        for (Object obj : spannable.getSpans(c23184e.aqm, c23184e.f4406Ls, (Class) actualTypeArguments[actualTypeArguments.length - 1])) {
            if (C24931o.m39011a(spannable, c23184e, obj, c44014s)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private static boolean m39011a(Spannable spannable, C23184e c23184e, Object obj, C44014s c44014s) {
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
        if (c44014s != C44014s.EXACT) {
            int spanFlags = spannable.getSpanFlags(obj) & 51;
            if (spanEnd == i) {
                return C23185t.m35565f(spanFlags, 34, 18);
            }
            return C23185t.m35565f(spanFlags, 17, 18);
        } else if (spanStart == i && spanEnd == i2 && i == i2) {
            return true;
        } else {
            return false;
        }
    }
}
