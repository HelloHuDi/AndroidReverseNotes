package com.tencent.p177mm.plugin.fts.p424ui.p426d;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.fts.p419a.C12029n;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C20846i;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C28106a;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C28109j;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C45966l;
import com.tencent.p177mm.plugin.fts.p419a.p421d.C3158b;
import com.tencent.p177mm.plugin.fts.p419a.p421d.C45970e.C34203a;
import com.tencent.p177mm.plugin.fts.p419a.p421d.C45970e.C39133b;
import com.tencent.p177mm.plugin.fts.p419a.p421d.p422a.C3154a;
import com.tencent.p177mm.plugin.fts.p424ui.C39153a;
import com.tencent.p177mm.plugin.fts.p424ui.p425a.C12061i;
import com.tencent.p177mm.plugin.fts.p424ui.p425a.C45974m;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.HashSet;

/* renamed from: com.tencent.mm.plugin.fts.ui.d.k */
public class C28148k extends C39153a {
    protected boolean mLK = false;

    public C28148k(Context context, C39133b c39133b, int i) {
        super(context, c39133b, i);
    }

    /* renamed from: a */
    public C28106a mo7330a(C7306ak c7306ak, HashSet<String> hashSet) {
        AppMethodBeat.m2504i(62088);
        this.mLK = false;
        C20846i c20846i = new C20846i();
        c20846i.query = this.query;
        c20846i.mEu = hashSet;
        c20846i.mEw = this;
        c20846i.handler = c7306ak;
        c20846i.hbo = 1;
        c20846i.mEt = 3;
        C28106a search = ((C12029n) C1720g.m3530M(C12029n.class)).search(3, c20846i);
        AppMethodBeat.m2505o(62088);
        return search;
    }

    /* renamed from: a */
    public void mo7332a(C28109j c28109j, HashSet<String> hashSet) {
        AppMethodBeat.m2504i(62089);
        if (C3158b.m5391bX(c28109j.mEy)) {
            C34203a c34203a = new C34203a();
            c34203a.businessType = -2;
            c34203a.mDz = c28109j.mDz;
            c34203a.mFf = c28109j.mEy;
            if (c34203a.mFf.size() > 3) {
                if (((C45966l) c28109j.mEy.get(3)).mDx.equals("create_talker_message​")) {
                    c34203a.mFe = false;
                    c34203a.mFf = c34203a.mFf.subList(0, 4);
                } else {
                    c34203a.mFe = true;
                    c34203a.mFf = c34203a.mFf.subList(0, 3);
                }
            } else if (c28109j.mEy.size() == 1 && ((C45966l) c28109j.mEy.get(0)).mDx.equals("create_talker_message​")) {
                c34203a.mFc = false;
            }
            this.mHp.add(c34203a);
        }
        AppMethodBeat.m2505o(62089);
    }

    /* renamed from: a */
    public C3154a mo7331a(int i, C34203a c34203a) {
        int i2;
        AppMethodBeat.m2504i(62090);
        int i3 = i - c34203a.mFb;
        if (c34203a.mFc) {
            i2 = i3 - 1;
        } else {
            i2 = i3;
        }
        C3154a c3154a = null;
        if (i2 < c34203a.mFf.size() && i2 >= 0) {
            C45966l c45966l = (C45966l) c34203a.mFf.get(i2);
            if (c45966l.mDx.equals("create_talker_message​")) {
                C3154a c12061i = new C12061i(i);
                c12061i.mKF = c34203a.mFf.size() == 1;
                this.mLK = true;
                c3154a = c12061i;
            } else {
                C3154a c45974m = new C45974m(i);
                c45974m.hpS = c45966l;
                c45974m.mo7419ej(c45966l.type, c45966l.mDw);
                c3154a = c45974m;
            }
        }
        if (c3154a != null) {
            c3154a.mFn = i2 + 1;
            c3154a.mDz = c34203a.mDz;
        }
        AppMethodBeat.m2505o(62090);
        return c3154a;
    }

    public int getType() {
        return 112;
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public boolean mo7424a(View view, C3154a c3154a, boolean z) {
        AppMethodBeat.m2504i(62091);
        if (c3154a instanceof C45974m) {
            int bBl = bBl();
            boolean z2 = this.mLK;
            if (c3154a.mFr == 65536) {
                switch (c3154a.pageType) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                        bBl = c3154a.pageType;
                    case 5:
                        if (bBl == 1) {
                            bBl = 6;
                        } else if (bBl == 2) {
                            bBl = 5;
                        }
                        break;
                }
                String str = "%s,%s,%s";
                Object[] objArr = new Object[3];
                objArr[0] = Integer.valueOf(c3154a.bAw());
                objArr[1] = Integer.valueOf(bBl);
                if (z2) {
                    bBl = 1;
                } else {
                    bBl = 0;
                }
                objArr[2] = Integer.valueOf(bBl);
                C4990ab.m7419v("MicroMsg.FTS.FTSReportLogic", "reportFTSGlobalMsgResultClick: %d, %s", Integer.valueOf(14756), String.format(str, objArr));
                C7060h.pYm.mo8374X(14756, r0);
            }
        }
        AppMethodBeat.m2505o(62091);
        return false;
    }

    /* Access modifiers changed, original: protected */
    public int bBl() {
        return 0;
    }
}
