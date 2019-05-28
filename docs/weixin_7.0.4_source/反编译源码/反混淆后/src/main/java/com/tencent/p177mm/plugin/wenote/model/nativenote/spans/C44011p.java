package com.tencent.p177mm.plugin.wenote.model.nativenote.spans;

import android.text.Spannable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.wenote.model.nativenote.spans.p */
public final class C44011p {
    final ArrayList<C44010a> uSf = new ArrayList();

    /* renamed from: com.tencent.mm.plugin.wenote.model.nativenote.spans.p$a */
    static class C44010a {
        final C14739f uSg;
        final C29992n uSh;
        final boolean uSi;

        C44010a(Object obj, C29992n c29992n, boolean z) {
            AppMethodBeat.m2504i(26960);
            this.uSg = (C14739f) obj;
            this.uSh = c29992n;
            this.uSi = z;
            AppMethodBeat.m2505o(26960);
        }
    }

    public C44011p() {
        AppMethodBeat.m2504i(26961);
        AppMethodBeat.m2505o(26961);
    }

    /* renamed from: a */
    public final void mo69686a(ArrayList<Object> arrayList, C29992n c29992n) {
        AppMethodBeat.m2504i(26962);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            m79001a(it.next(), c29992n);
        }
        AppMethodBeat.m2505o(26962);
    }

    /* renamed from: a */
    private void m79001a(Object obj, C29992n c29992n) {
        AppMethodBeat.m2504i(26963);
        if (obj instanceof C14739f) {
            this.uSf.add(new C44010a(obj, c29992n, true));
        }
        AppMethodBeat.m2505o(26963);
    }

    /* renamed from: b */
    public final void mo69687b(Object obj, C29992n c29992n) {
        AppMethodBeat.m2504i(26964);
        this.uSf.add(new C44010a(obj, c29992n, false));
        AppMethodBeat.m2505o(26964);
    }

    /* renamed from: c */
    public final void mo69688c(Spannable spannable) {
        AppMethodBeat.m2504i(26965);
        Iterator it = this.uSf.iterator();
        while (it.hasNext()) {
            C44010a c44010a = (C44010a) it.next();
            C14739f c14739f = c44010a.uSg;
            int i = c44010a.uSh.aqm;
            int spanStart;
            if (c44010a.uSi) {
                spanStart = spannable.getSpanStart(c14739f);
                if (spanStart >= 0 && spanStart < i) {
                    spannable.setSpan(c14739f.dfC(), spanStart, i, 34);
                }
                spannable.removeSpan(c14739f);
            } else {
                C29992n c29992n = c44010a.uSh;
                int i2 = c44010a.uSh.f4406Ls;
                spanStart = (c29992n.uRZ && c29992n.isEmpty()) ? 34 : (c29992n.uRZ && c29992n.uRY) ? 18 : c29992n.uRZ ? 34 : 33;
                if (i2 > spannable.length()) {
                    i2 = spannable.length();
                }
                spannable.setSpan(c14739f, i, i2, spanStart);
            }
        }
        AppMethodBeat.m2505o(26965);
    }
}
