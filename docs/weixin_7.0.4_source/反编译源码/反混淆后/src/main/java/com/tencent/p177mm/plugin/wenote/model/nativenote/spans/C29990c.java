package com.tencent.p177mm.plugin.wenote.model.nativenote.spans;

import android.text.Editable;
import android.text.Spannable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.wenote.model.nativenote.manager.C23184e;
import com.tencent.p177mm.plugin.wenote.model.nativenote.manager.C35746b;
import com.tencent.p177mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.wenote.model.nativenote.spans.c */
public final class C29990c extends C24931o<Boolean, C17002d> {
    private C44011p uRS = new C44011p();

    public C29990c() {
        AppMethodBeat.m2504i(26935);
        AppMethodBeat.m2505o(26935);
    }

    /* renamed from: a */
    public final /* synthetic */ void mo41817a(WXRTEditText wXRTEditText, C23184e c23184e, Object obj) {
        AppMethodBeat.m2504i(26936);
        Boolean bool = (Boolean) obj;
        Editable text = wXRTEditText.getText();
        if (bool == null) {
            bool = Boolean.FALSE;
        }
        this.uRS.uSf.clear();
        ArrayList paragraphs = wXRTEditText.getParagraphs();
        int size = paragraphs.size();
        int i = 0;
        while (i < size) {
            boolean booleanValue;
            Object obj2;
            C29992n c29992n = (C29992n) paragraphs.get(i);
            ArrayList a = mo38809a((Spannable) text, (C23184e) c29992n, C44014s.SPAN_FLAGS);
            this.uRS.mo69686a(a, c29992n);
            boolean z = !a.isEmpty();
            if (c29992n.mo48228a(c23184e)) {
                booleanValue = bool.booleanValue();
            } else {
                booleanValue = z;
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
                this.uRS.mo69687b(new C17002d(C35746b.del(), c29992n.isEmpty(), c29992n.uRY, c29992n.uRZ), c29992n);
                C29993u.uSC.mo41816a((Spannable) text, c29992n, this.uRS);
                C29993u.uSA.mo41816a((Spannable) text, c29992n, this.uRS);
            }
            i++;
        }
        this.uRS.mo69688c(text);
        AppMethodBeat.m2505o(26936);
    }

    public final int dfy() {
        return 1;
    }
}
