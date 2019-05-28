package com.tencent.p177mm.plugin.fts.p424ui.p426d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33250az;
import com.tencent.p177mm.plugin.fts.p419a.C12029n;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C20846i;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C28106a;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C45966l;
import com.tencent.p177mm.plugin.fts.p419a.p421d.C45970e.C34203a;
import com.tencent.p177mm.plugin.fts.p419a.p421d.C45970e.C39133b;
import com.tencent.p177mm.plugin.fts.p419a.p421d.p422a.C3154a;
import com.tencent.p177mm.plugin.fts.p419a.p975c.C28112e;
import com.tencent.p177mm.plugin.fts.p424ui.p425a.C20873g;
import com.tencent.p177mm.plugin.fts.p424ui.p425a.C39147k;
import com.tencent.p177mm.plugin.fts.p424ui.p425a.C39148l;
import com.tencent.p177mm.plugin.fts.p424ui.p425a.C45973f;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.HashSet;

/* renamed from: com.tencent.mm.plugin.fts.ui.d.g */
public final class C39155g extends C31365l {
    public String mEp;
    public int showType;
    public String talker;

    public C39155g(Context context, C39133b c39133b, int i) {
        super(context, c39133b, i);
    }

    public final int getType() {
        return C33250az.CTRL_INDEX;
    }

    /* renamed from: a */
    public final C28106a mo7330a(C7306ak c7306ak, HashSet<String> hashSet) {
        AppMethodBeat.m2504i(62074);
        this.mLK = false;
        C20846i c20846i = new C20846i();
        c20846i.query = this.query;
        c20846i.mEv = C28112e.mEY;
        c20846i.mEp = this.mEp;
        c20846i.mEq = this.mEq;
        c20846i.talker = this.talker;
        c20846i.mEw = this;
        c20846i.handler = c7306ak;
        c20846i.hbo = 11;
        C28106a search = ((C12029n) C1720g.m3530M(C12029n.class)).search(3, c20846i);
        AppMethodBeat.m2505o(62074);
        return search;
    }

    /* renamed from: b */
    public final C39147k mo51306b(int i, C34203a c34203a) {
        AppMethodBeat.m2504i(62075);
        C45973f c45973f = new C45973f(i);
        c45973f.mKp = c34203a.mFh;
        c45973f.mEp = this.mEp;
        AppMethodBeat.m2505o(62075);
        return c45973f;
    }

    /* renamed from: a */
    public final C3154a mo7331a(int i, C34203a c34203a) {
        int i2;
        AppMethodBeat.m2504i(62076);
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
                C3154a c20873g = new C20873g(i);
                c20873g.hpS = c45966l;
                c20873g.mDz = c20873g.hpS.mDz;
                c20873g.mo7419ej(c45966l.type, c45966l.mDw);
                c3154a = c20873g;
            }
        }
        AppMethodBeat.m2505o(62076);
        return c3154a;
    }

    public final int bBl() {
        return this.showType;
    }
}
