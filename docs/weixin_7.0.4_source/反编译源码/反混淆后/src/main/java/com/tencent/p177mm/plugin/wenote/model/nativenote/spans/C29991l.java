package com.tencent.p177mm.plugin.wenote.model.nativenote.spans;

import android.text.Editable;
import android.text.Spannable;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.wenote.model.nativenote.manager.C23184e;
import com.tencent.p177mm.plugin.wenote.model.nativenote.manager.C35746b;
import com.tencent.p177mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.wenote.model.nativenote.spans.l */
public final class C29991l extends C24931o<Boolean, C17003m> {
    private C44011p uRS = new C44011p();

    public C29991l() {
        AppMethodBeat.m2504i(26952);
        AppMethodBeat.m2505o(26952);
    }

    /* renamed from: a */
    public final /* synthetic */ void mo41817a(WXRTEditText wXRTEditText, C23184e c23184e, Object obj) {
        AppMethodBeat.m2504i(26953);
        Boolean bool = (Boolean) obj;
        Editable text = wXRTEditText.getText();
        if (bool == null) {
            bool = Boolean.FALSE;
        }
        this.uRS.uSf.clear();
        SparseIntArray sparseIntArray = new SparseIntArray();
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        ArrayList paragraphs = wXRTEditText.getParagraphs();
        int size = paragraphs.size();
        int i = 0;
        int i2 = 1;
        while (i < size) {
            int i3;
            int i4;
            Object next;
            boolean booleanValue;
            C29992n c29992n = (C29992n) paragraphs.get(i);
            int i5 = 0;
            ArrayList a = C29993u.uSD.mo38809a((Spannable) text, (C23184e) c29992n, C44014s.EXACT);
            if (a.isEmpty()) {
                i3 = 0;
            } else {
                Iterator it = a.iterator();
                while (true) {
                    i4 = i5;
                    if (!it.hasNext()) {
                        break;
                    }
                    next = it.next();
                    if (next instanceof C46458g) {
                        i5 = ((Integer) ((C46458g) next).getValue()).intValue() + i4;
                    } else {
                        i5 = i4;
                    }
                }
                i3 = i4;
            }
            sparseIntArray.put(i2, i3);
            ArrayList a2 = mo38809a((Spannable) text, (C23184e) c29992n, C44014s.SPAN_FLAGS);
            this.uRS.mo69686a(a2, c29992n);
            boolean z = !a2.isEmpty();
            if (c29992n.mo48228a(c23184e)) {
                booleanValue = bool.booleanValue();
            } else {
                booleanValue = z;
            }
            if (i <= 0 || c29992n.dfF() != 1 || ((C29992n) paragraphs.get(i - 1)).dfF() != 1 || bool.booleanValue()) {
                next = null;
            } else {
                next = 1;
            }
            if (next != null) {
                z = false;
            } else {
                z = booleanValue;
            }
            if (z) {
                i4 = 1;
                for (int i6 = 1; i6 < i2; i6++) {
                    i5 = sparseIntArray.get(i6);
                    int i7 = sparseIntArray2.get(i6);
                    if (i5 < i3) {
                        i5 = 1;
                    } else if (i5 != i3) {
                    } else {
                        i5 = i7 == 0 ? 1 : i7 + 1;
                    }
                    i4 = i5;
                }
                sparseIntArray2.put(i2, i4);
                this.uRS.mo69687b(new C17003m(i4, C35746b.del(), c29992n.isEmpty(), c29992n.uRY, c29992n.uRZ), c29992n);
                C29993u.uSB.mo41816a((Spannable) text, c29992n, this.uRS);
                C29993u.uSA.mo41816a((Spannable) text, c29992n, this.uRS);
            }
            i++;
            i2++;
        }
        this.uRS.mo69688c(text);
        AppMethodBeat.m2505o(26953);
    }

    public final int dfy() {
        return 2;
    }
}
