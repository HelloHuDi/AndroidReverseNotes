package com.tencent.p177mm.p612ui.chatting.p617f;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.chatting.p1345j.C36196a;
import com.tencent.p177mm.p612ui.chatting.p1345j.C36196a.C361971;
import com.tencent.p177mm.p612ui.chatting.p617f.C40748d.C40749a;
import com.tencent.p177mm.p612ui.chatting.p617f.C40748d.C40750b;
import com.tencent.p177mm.p612ui.chatting.p617f.C40748d.C40752d;
import com.tencent.p177mm.p612ui.chatting.p622l.C30549e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C7620bi;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.ui.chatting.f.a */
public final class C7338a implements C5338c<C7620bi> {
    private SparseArray<C7620bi> yYk;

    public C7338a(SparseArray<C7620bi> sparseArray) {
        this.yYk = sparseArray;
    }

    /* renamed from: a */
    public final void mo10970a(C40749a c40749a, C30549e<C7620bi> c30549e, C40752d<C7620bi> c40752d, C40750b c40750b) {
        AppMethodBeat.m2504i(32477);
        C36196a c36196a = C36196a.yZE;
        int[] iArr;
        switch (C361971.yZG[c40752d.yYA.ordinal()]) {
            case 1:
                iArr = c36196a.yZF;
                iArr[0] = iArr[0] + 1;
                break;
            case 2:
                iArr = c36196a.yZF;
                iArr[1] = iArr[1] + 1;
                break;
            case 3:
                iArr = c36196a.yZF;
                iArr[2] = iArr[2] + 1;
                break;
            case 4:
                if (c40752d.yYz != null && c40752d.yYz.getInt("SCENE") == 1) {
                    iArr = c36196a.yZF;
                    iArr[3] = iArr[3] + 1;
                    break;
                }
                iArr = c36196a.yZF;
                iArr[4] = iArr[4] + 1;
                break;
                break;
        }
        if (c30549e == null) {
            C4990ab.m7412e("MicroMsg.ChattingLoader.ChattingDataCallback", "[load] null == source!");
            c40750b.mo15847dY();
            AppMethodBeat.m2505o(32477);
            return;
        }
        final C30549e<C7620bi> c30549e2 = c30549e;
        final C40752d<C7620bi> c40752d2 = c40752d;
        final C40749a c40749a2 = c40749a;
        final C40750b c40750b2 = c40750b;
        c30549e.mo48956a(new C40750b() {
            /* renamed from: dY */
            public final void mo15847dY() {
                AppMethodBeat.m2504i(32476);
                c30549e2.mo48959fk(c40752d2.yYB);
                c30549e2.close();
                c40752d2.enb = c30549e2.dCP();
                c40752d2.yYC = c40752d2.yYB.size();
                C4990ab.m7416i("MicroMsg.ChattingLoader.ChattingDataCallback", "action：" + c40749a2 + " addCount:" + c40752d2.yYC + " totalCount:" + c40752d2.enb);
                c40750b2.mo15847dY();
                AppMethodBeat.m2505o(32476);
            }
        });
        AppMethodBeat.m2505o(32477);
    }

    /* renamed from: fd */
    public final SparseArray<C7620bi> mo10971fd(List<C7620bi> list) {
        AppMethodBeat.m2504i(32478);
        if (list == null) {
            List list2 = new LinkedList();
            C4990ab.m7412e("MicroMsg.ChattingLoader.ChattingDataCallback", "[fillData] list is null!");
        }
        this.yYk.clear();
        int i = 0;
        for (Object put : list2) {
            this.yYk.put(i, put);
            i++;
        }
        SparseArray sparseArray = this.yYk;
        AppMethodBeat.m2505o(32478);
        return sparseArray;
    }
}
