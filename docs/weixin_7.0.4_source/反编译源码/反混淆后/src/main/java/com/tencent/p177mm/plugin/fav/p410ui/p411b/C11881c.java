package com.tencent.p177mm.plugin.fav.p410ui.p411b;

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
import com.tencent.p177mm.plugin.fts.p419a.p975c.C12026d;
import com.tencent.p177mm.plugin.fts.p424ui.C39153a;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.HashSet;

/* renamed from: com.tencent.mm.plugin.fav.ui.b.c */
public final class C11881c extends C39153a {
    public C11881c(Context context, C39133b c39133b, int i) {
        super(context, c39133b, i);
    }

    /* renamed from: a */
    public final C28106a mo7330a(C7306ak c7306ak, HashSet<String> hashSet) {
        AppMethodBeat.m2504i(74500);
        C20846i c20846i = new C20846i();
        c20846i.hbo = 2;
        c20846i.query = this.query;
        c20846i.mEu = hashSet;
        c20846i.handler = c7306ak;
        c20846i.mEw = this;
        c20846i.mEv = C12026d.mEX;
        C28106a search = ((C12029n) C1720g.m3530M(C12029n.class)).search(6, c20846i);
        AppMethodBeat.m2505o(74500);
        return search;
    }

    /* renamed from: a */
    public final C3154a mo7331a(int i, C34203a c34203a) {
        AppMethodBeat.m2504i(74502);
        int i2 = (i - c34203a.mFb) - 1;
        C3154a c3154a = null;
        if (i2 < c34203a.mFf.size() && i2 >= 0) {
            C45966l c45966l = (C45966l) c34203a.mFf.get(i2);
            C3154a c34153a = new C34153a(i);
            c34153a.hpS = c45966l;
            c34153a.mDz = c34203a.mDz;
            c34153a.mo7419ej(c45966l.type, c45966l.mDw);
            c3154a = c34153a;
        }
        if (c3154a != null) {
            c3154a.mFn = i2 + 1;
        }
        AppMethodBeat.m2505o(74502);
        return c3154a;
    }

    public final int getType() {
        return 4192;
    }

    /* renamed from: a */
    public final void mo7332a(C28109j c28109j, HashSet<String> hashSet) {
        AppMethodBeat.m2504i(74501);
        if (C3158b.m5391bX(c28109j.mEy)) {
            C34203a c34203a = new C34203a();
            c34203a.businessType = -1;
            c34203a.mDz = c28109j.mDz;
            c34203a.mFf = c28109j.mEy;
            this.mHp.add(c34203a);
        }
        AppMethodBeat.m2505o(74501);
    }
}
