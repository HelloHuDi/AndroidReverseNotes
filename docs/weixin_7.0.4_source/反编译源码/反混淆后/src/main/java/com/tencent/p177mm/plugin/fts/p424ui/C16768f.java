package com.tencent.p177mm.plugin.fts.p424ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.plugin.chatroom.p721a.C6822c;
import com.tencent.p177mm.plugin.fts.p419a.C12029n;
import com.tencent.p177mm.plugin.fts.p419a.C28114l;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C20846i;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C28106a;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C28109j;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C45966l;
import com.tencent.p177mm.plugin.fts.p419a.p421d.p422a.C3154a;
import com.tencent.p177mm.plugin.fts.p419a.p975c.C28112e;
import com.tencent.p177mm.plugin.fts.p424ui.p425a.C43129d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C7577u;

/* renamed from: com.tencent.mm.plugin.fts.ui.f */
public final class C16768f extends C12067d implements C28114l {
    private C7306ak ilv = new C7306ak();
    private C28109j mEm;
    private String mEp;
    private C28106a mEx;
    private C7577u mIy;

    public C16768f(C28149e c28149e, String str) {
        super(c28149e);
        AppMethodBeat.m2504i(61785);
        this.mEp = str;
        if (C1855t.m3901mN(str)) {
            this.mIy = ((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV().mo14885oa(str);
        }
        AppMethodBeat.m2505o(61785);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: vZ */
    public final C3154a mo7495vZ(int i) {
        AppMethodBeat.m2504i(61786);
        C43129d c43129d = new C43129d(i);
        c43129d.hpS = (C45966l) this.mEm.mEy.get(i);
        c43129d.mDz = this.mEm.mDz;
        c43129d.mFl = -14;
        c43129d.mIy = this.mIy;
        c43129d.mFm = i;
        c43129d.pageType = 6;
        if (c43129d.position == getCount() - 1) {
            c43129d.mFk = true;
        }
        AppMethodBeat.m2505o(61786);
        return c43129d;
    }

    /* Access modifiers changed, original: protected|final */
    public final void bAL() {
        AppMethodBeat.m2504i(61787);
        clearCache();
        if (this.mEx != null) {
            ((C12029n) C1720g.m3530M(C12029n.class)).cancelSearchTask(this.mEx);
        }
        C20846i c20846i = new C20846i();
        c20846i.query = this.query;
        c20846i.mEp = this.mEp;
        c20846i.mEv = C28112e.mEY;
        c20846i.mEu.add("create_talker_message​");
        c20846i.mEw = this;
        c20846i.handler = this.ilv;
        c20846i.hbo = 3;
        this.mEx = ((C12029n) C1720g.m3530M(C12029n.class)).search(3, c20846i);
        C4990ab.m7417i("MicroMSsg.FTS.FTSChattingConvAdapter", "do search %s", this.query);
        AppMethodBeat.m2505o(61787);
    }

    /* renamed from: b */
    public final void mo8215b(C28109j c28109j) {
        AppMethodBeat.m2504i(61788);
        switch (c28109j.bFZ) {
            case -3:
            case -2:
            case -1:
                setCount(0);
                notifyDataSetChanged();
                mo23894T(getCount(), true);
                break;
            case 0:
                this.mEm = c28109j;
                setCount(c28109j.mEy.size());
                notifyDataSetChanged();
                mo23894T(getCount(), true);
                AppMethodBeat.m2505o(61788);
                return;
        }
        AppMethodBeat.m2505o(61788);
    }

    public final void finish() {
        AppMethodBeat.m2504i(61789);
        super.finish();
        if (this.mEx != null) {
            ((C12029n) C1720g.m3530M(C12029n.class)).cancelSearchTask(this.mEx);
        }
        AppMethodBeat.m2505o(61789);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final boolean mo7491a(View view, C3154a c3154a, boolean z) {
        return false;
    }
}
