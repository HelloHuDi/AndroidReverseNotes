package com.tencent.p177mm.plugin.fts.p424ui.p426d;

import android.content.Context;
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
import com.tencent.p177mm.plugin.fts.p419a.p975c.C28111c;
import com.tencent.p177mm.plugin.fts.p424ui.C39153a;
import com.tencent.p177mm.plugin.fts.p424ui.p425a.C28144j;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.HashSet;

/* renamed from: com.tencent.mm.plugin.fts.ui.d.h */
public final class C43137h extends C39153a {
    public C43137h(Context context, C39133b c39133b, int i) {
        super(context, c39133b, i);
    }

    /* renamed from: a */
    public final C28106a mo7330a(C7306ak c7306ak, HashSet<String> hashSet) {
        AppMethodBeat.m2504i(62077);
        C20846i c20846i = new C20846i();
        c20846i.query = this.query;
        c20846i.handler = c7306ak;
        c20846i.mEu = hashSet;
        c20846i.mEw = this;
        c20846i.mEv = C28111c.mEW;
        C28106a search = ((C12029n) C1720g.m3530M(C12029n.class)).search(4, c20846i);
        AppMethodBeat.m2505o(62077);
        return search;
    }

    /* renamed from: a */
    public final C3154a mo7331a(int i, C34203a c34203a) {
        AppMethodBeat.m2504i(62079);
        int i2 = (i - c34203a.mFb) - 1;
        C3154a c3154a = null;
        if (i2 < c34203a.mFf.size() && i2 >= 0) {
            c3154a = mo7489a(262144, i, (C45966l) c34203a.mFf.get(i2), c34203a);
        }
        if (c3154a != null) {
            c3154a.mFn = i2 + 1;
        }
        AppMethodBeat.m2505o(62079);
        return c3154a;
    }

    public final int getType() {
        return 64;
    }

    /* renamed from: a */
    public final C3154a mo7489a(int i, int i2, C45966l c45966l, C34203a c34203a) {
        AppMethodBeat.m2504i(62080);
        C28144j c28144j = new C28144j(i2);
        c28144j.hpS = c45966l;
        c28144j.mDz = c34203a.mDz;
        c28144j.mo7419ej(c45966l.type, c45966l.mDw);
        AppMethodBeat.m2505o(62080);
        return c28144j;
    }

    /* renamed from: a */
    public final void mo7332a(C28109j c28109j, HashSet<String> hashSet) {
        AppMethodBeat.m2504i(62078);
        if (C3158b.m5391bX(c28109j.mEy)) {
            C34203a c34203a = new C34203a();
            c34203a.businessType = -6;
            c34203a.mDz = c28109j.mDz;
            c34203a.mFf = c28109j.mEy;
            c34203a.mFe = false;
            this.mHp.add(c34203a);
        }
        AppMethodBeat.m2505o(62078);
    }
}
