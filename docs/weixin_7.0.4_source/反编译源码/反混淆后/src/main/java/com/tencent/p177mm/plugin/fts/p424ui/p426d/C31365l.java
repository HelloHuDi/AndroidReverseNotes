package com.tencent.p177mm.plugin.fts.p424ui.p426d;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.fts.p419a.C12029n;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C20846i;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C28106a;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C28109j;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C45966l;
import com.tencent.p177mm.plugin.fts.p419a.p421d.C45970e.C34203a;
import com.tencent.p177mm.plugin.fts.p419a.p421d.C45970e.C39133b;
import com.tencent.p177mm.plugin.fts.p419a.p421d.p422a.C3154a;
import com.tencent.p177mm.plugin.fts.p419a.p975c.C28112e;
import com.tencent.p177mm.plugin.fts.p424ui.p425a.C20874p;
import com.tencent.p177mm.plugin.fts.p424ui.p425a.C39147k;
import com.tencent.p177mm.plugin.fts.p424ui.p425a.C39148l;
import com.tencent.p177mm.plugin.fts.p424ui.p425a.C39152n;
import com.tencent.p177mm.plugin.fts.p424ui.p425a.C43127c;
import com.tencent.p177mm.plugin.fts.p424ui.p425a.C46912o;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.fts.ui.d.l */
public class C31365l extends C28148k {
    public String mEq;

    public C31365l(Context context, C39133b c39133b, int i) {
        super(context, c39133b, i);
    }

    public int getType() {
        return ErrorCode.NEEDDOWNLOAD_FALSE_6;
    }

    /* renamed from: a */
    public C28106a mo7330a(C7306ak c7306ak, HashSet<String> hashSet) {
        AppMethodBeat.m2504i(62092);
        this.mLK = false;
        C20846i c20846i = new C20846i();
        c20846i.query = this.query;
        c20846i.mEv = C28112e.mEY;
        c20846i.mEq = this.mEq;
        c20846i.mEw = this;
        c20846i.handler = c7306ak;
        c20846i.hbo = 10;
        C28106a search = ((C12029n) C1720g.m3530M(C12029n.class)).search(3, c20846i);
        AppMethodBeat.m2505o(62092);
        return search;
    }

    /* renamed from: a */
    public final void mo7332a(C28109j c28109j, HashSet<String> hashSet) {
        AppMethodBeat.m2504i(62093);
        switch (c28109j.bFZ) {
            case 0:
                if (c28109j.mEy.size() <= 0) {
                    C34203a c34203a = new C34203a();
                    c34203a.businessType = -2;
                    c34203a.mDz = c28109j.mDz;
                    c34203a.mFc = false;
                    C45966l c45966l = new C45966l();
                    c45966l.mDx = "no_result​";
                    c34203a.mFf = new ArrayList();
                    c34203a.mFf.add(c45966l);
                    this.mHp.add(c34203a);
                    break;
                }
                int i = 0;
                while (i < c28109j.mEy.size()) {
                    C34203a c34203a2 = new C34203a();
                    c34203a2.mFc = true;
                    c34203a2.mFh = (C45966l) c28109j.mEy.get(i);
                    c34203a2.mDz = c28109j.mDz;
                    c34203a2.mFf = (List) c34203a2.mFh.userData;
                    if (c34203a2.mFf.size() <= 3 || i == c28109j.mEy.size() - 1) {
                        c34203a2.mFg = false;
                        c34203a2.mFe = false;
                    } else {
                        c34203a2.mFg = true;
                        c34203a2.mFe = true;
                    }
                    this.mHp.add(c34203a2);
                    i++;
                }
                AppMethodBeat.m2505o(62093);
                return;
                break;
        }
        AppMethodBeat.m2505o(62093);
    }

    /* renamed from: b */
    public C39147k mo51306b(int i, C34203a c34203a) {
        AppMethodBeat.m2504i(62095);
        C46912o c46912o = new C46912o(i);
        c46912o.mKp = c34203a.mFh;
        c46912o.mDz = c46912o.mKp.mDz;
        AppMethodBeat.m2505o(62095);
        return c46912o;
    }

    /* renamed from: c */
    public final C39152n mo51307c(int i, C34203a c34203a) {
        AppMethodBeat.m2504i(62096);
        C43127c c43127c = new C43127c(i);
        c43127c.resId = C25738R.string.c1r;
        c43127c.mJY = c34203a.mFg;
        AppMethodBeat.m2505o(62096);
        return c43127c;
    }

    /* renamed from: a */
    public C3154a mo7331a(int i, C34203a c34203a) {
        int i2;
        AppMethodBeat.m2504i(62097);
        C3154a c3154a = null;
        if (c34203a.mFc) {
            i2 = (i - c34203a.mFb) - 1;
        } else {
            i2 = i - c34203a.mFb;
        }
        if (i2 >= 0 && i2 < c34203a.mFf.size()) {
            C45966l c45966l = (C45966l) c34203a.mFf.get(i2);
            if (c45966l.mDx.equals("no_result​")) {
                c3154a = new C39148l(i);
            } else {
                C3154a c20874p = new C20874p(i);
                c20874p.hpS = c45966l;
                c20874p.mKp = c34203a.mFh;
                c20874p.mDz = c20874p.hpS.mDz;
                c20874p.mFl = -14;
                c20874p.showType = 2;
                c20874p.mo7419ej(c45966l.type, c45966l.mDw);
                c3154a = c20874p;
            }
        }
        AppMethodBeat.m2505o(62097);
        return c3154a;
    }

    /* renamed from: a */
    public final boolean mo7424a(View view, C3154a c3154a, boolean z) {
        boolean z2 = false;
        AppMethodBeat.m2504i(62098);
        super.mo7424a(view, c3154a, z);
        if (c3154a instanceof C43127c) {
            int i = 0;
            while (i < this.mHp.size()) {
                C34203a c34203a = (C34203a) this.mHp.get(i);
                if (c34203a.mFd == c3154a.position) {
                    if (!c34203a.mFg) {
                        z2 = true;
                    }
                    c34203a.mFg = z2;
                } else {
                    i++;
                }
            }
        }
        AppMethodBeat.m2505o(62098);
        return true;
    }

    /* Access modifiers changed, original: protected */
    public int bBl() {
        return 2;
    }

    /* renamed from: vY */
    public final int mo51308vY(int i) {
        AppMethodBeat.m2504i(62094);
        int size = this.mHp.size();
        int i2 = i;
        for (int i3 = 0; i3 < size; i3++) {
            C34203a c34203a = (C34203a) this.mHp.get(i3);
            c34203a.mFb = i2;
            if (c34203a.mFc) {
                i2++;
            }
            if (c34203a.mFf.size() > 3) {
                if (c34203a.mFg) {
                    i2 += 3;
                } else {
                    i2 += c34203a.mFf.size();
                }
                c34203a.mFd = i2;
                if (c34203a.mFe) {
                    i2++;
                }
            } else {
                i2 += c34203a.mFf.size();
                c34203a.mFd = i2;
            }
        }
        AppMethodBeat.m2505o(62094);
        return i2;
    }
}
