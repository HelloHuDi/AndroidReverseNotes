package com.tencent.p177mm.p612ui.chatting;

import android.os.Bundle;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C42184aq;
import com.tencent.p177mm.p612ui.chatting.p1670d.C46650a;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C44299r;
import com.tencent.p177mm.platformtools.C42252ah;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C7620bi;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.ui.chatting.x */
public final class C15763x implements C42184aq {
    public C46650a cgL;
    public C15571aa yLx = new C15571aa();

    public C15763x(C46650a c46650a) {
        AppMethodBeat.m2504i(30904);
        this.cgL = c46650a;
        AppMethodBeat.m2505o(30904);
    }

    /* renamed from: a */
    public final void mo27972a(C7620bi c7620bi) {
        AppMethodBeat.m2504i(30905);
        if (this.cgL.mo74857aF(C44299r.class) == null) {
            C4990ab.m7420w("MicroMsg.ChattingUIKeywordChecker", "chatting ui maybe has exit!");
            AppMethodBeat.m2505o(30905);
            return;
        }
        ((C44299r) this.cgL.mo74857aF(C44299r.class)).dEm();
        if (c7620bi.field_talker.equals(this.cgL.getTalkerUserName()) && c7620bi.isText()) {
            m24115aL(c7620bi);
            AppMethodBeat.m2505o(30905);
            return;
        }
        AppMethodBeat.m2505o(30905);
    }

    /* renamed from: L */
    public final void mo27970L(List<C7620bi> list) {
        AppMethodBeat.m2504i(30906);
        if (this.cgL == null) {
            C4990ab.m7420w("MicroMsg.ChattingUIKeywordChecker", "chatting ui is null.");
            AppMethodBeat.m2505o(30906);
        } else if (C1855t.m3896kH(this.cgL.getTalkerUserName())) {
            AppMethodBeat.m2505o(30906);
        } else {
            ArrayList arrayList = new ArrayList();
            for (C7620bi c7620bi : list) {
                if (c7620bi.field_talker.equals(this.cgL.getTalkerUserName()) && c7620bi.isText()) {
                    arrayList.add(c7620bi);
                }
            }
            m24116eV(arrayList);
            AppMethodBeat.m2505o(30906);
        }
    }

    public final void ard(String str) {
        AppMethodBeat.m2504i(30907);
        if (C42252ah.isNullOrNil(str)) {
            AppMethodBeat.m2505o(30907);
            return;
        }
        C7620bi c7620bi = new C7620bi();
        c7620bi.setContent(str);
        c7620bi.mo14781hO(1);
        m24115aL(c7620bi);
        AppMethodBeat.m2505o(30907);
    }

    /* renamed from: aL */
    private void m24115aL(C7620bi c7620bi) {
        AppMethodBeat.m2504i(30908);
        if (c7620bi == null) {
            AppMethodBeat.m2505o(30908);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(c7620bi);
        m24116eV(arrayList);
        AppMethodBeat.m2505o(30908);
    }

    /* renamed from: eV */
    private void m24116eV(List<C7620bi> list) {
        AppMethodBeat.m2504i(30909);
        if (!(this.yLx == null || this.cgL == null)) {
            this.yLx.mo27747a(this.cgL.yTx.getContext(), (List) list);
        }
        AppMethodBeat.m2505o(30909);
    }

    public final Looper getLooper() {
        AppMethodBeat.m2504i(30910);
        Looper mainLooper = Looper.getMainLooper();
        AppMethodBeat.m2505o(30910);
        return mainLooper;
    }

    /* renamed from: a */
    public final void mo27971a(int i, String str, String str2, String str3, String str4, Bundle bundle) {
    }
}
