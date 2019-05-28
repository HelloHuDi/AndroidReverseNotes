package com.tencent.p177mm.plugin.wenote.model.nativenote.spans;

import android.text.Editable;
import android.text.Spannable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.wenote.model.nativenote.manager.C23184e;
import com.tencent.p177mm.plugin.wenote.model.nativenote.manager.C35746b;
import com.tencent.p177mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.wenote.model.nativenote.spans.j */
public final class C46459j extends C24931o<Boolean, C40387k> {
    private C44011p uRS = new C44011p();

    public C46459j() {
        AppMethodBeat.m2504i(26945);
        AppMethodBeat.m2505o(26945);
    }

    /* renamed from: a */
    public final /* synthetic */ void mo41817a(WXRTEditText wXRTEditText, C23184e c23184e, Object obj) {
        AppMethodBeat.m2504i(26946);
        Boolean bool = (Boolean) obj;
        Editable text = wXRTEditText.getText();
        if (bool == null) {
            bool = Boolean.FALSE;
        }
        this.uRS.uSf.clear();
        ArrayList paragraphs = wXRTEditText.getParagraphs();
        int size = paragraphs.size();
        int i = 0;
        C40387k c40387k = null;
        while (i < size) {
            C40387k c40387k2;
            boolean booleanValue;
            Object obj2;
            boolean z;
            C29992n c29992n = (C29992n) paragraphs.get(i);
            ArrayList a = mo38809a((Spannable) text, (C23184e) c29992n, C44014s.SPAN_FLAGS);
            this.uRS.mo69686a(a, c29992n);
            if (a.isEmpty() || !(a.get(0) instanceof C40387k)) {
                c40387k2 = null;
            } else {
                c40387k2 = (C40387k) a.get(0);
            }
            boolean z2 = c40387k2 != null && c40387k2.uSb;
            if (c40387k != null && c40387k == c40387k2 && z2) {
                z2 = false;
            }
            boolean z3 = !a.isEmpty();
            if (c29992n.mo48228a(c23184e)) {
                booleanValue = bool.booleanValue();
            } else {
                booleanValue = z3;
            }
            if (i <= 0 || c29992n.dfF() != 1 || ((C29992n) paragraphs.get(i - 1)).dfF() != 1 || bool.booleanValue()) {
                obj2 = null;
            } else {
                obj2 = 1;
            }
            if (obj2 != null) {
                z = false;
            } else {
                z = booleanValue;
            }
            if (z) {
                this.uRS.mo69687b(new C40387k(z2, C35746b.del(), c29992n.isEmpty(), c29992n.uRY, c29992n.uRZ), c29992n);
                C29993u.uSC.mo41816a((Spannable) text, c29992n, this.uRS);
                C29993u.uSB.mo41816a((Spannable) text, c29992n, this.uRS);
            }
            if (!z && z3) {
                Iterator it = a.iterator();
                while (it.hasNext()) {
                    text.removeSpan(it.next());
                }
            }
            i++;
            c40387k = c40387k2;
        }
        this.uRS.mo69688c(text);
        AppMethodBeat.m2505o(26946);
    }

    public final int dfy() {
        return 3;
    }
}
