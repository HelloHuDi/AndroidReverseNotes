package com.tencent.p177mm.plugin.appbrand.game.p292b;

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

/* renamed from: com.tencent.mm.plugin.appbrand.game.b.e */
public final class C10234e extends C39153a {
    public C10234e(Context context, C39133b c39133b, int i) {
        super(context, c39133b, i);
    }

    /* renamed from: a */
    public final C28106a mo7330a(C7306ak c7306ak, HashSet<String> hashSet) {
        AppMethodBeat.m2504i(130084);
        C20846i c20846i = new C20846i();
        c20846i.query = this.query;
        c20846i.mEv = C12026d.mEX;
        c20846i.mEw = this;
        c20846i.handler = c7306ak;
        c20846i.mEu = hashSet;
        c20846i.mEv = C38216h.hri;
        C28106a search = ((C12029n) C1720g.m3530M(C12029n.class)).search(10, c20846i);
        AppMethodBeat.m2505o(130084);
        return search;
    }

    /* renamed from: a */
    public final C3154a mo7331a(int i, C34203a c34203a) {
        AppMethodBeat.m2504i(130086);
        int i2 = (i - c34203a.mFb) - 1;
        C3154a c3154a = null;
        if (i2 < c34203a.mFf.size() && i2 >= 0) {
            C45966l c45966l = (C45966l) c34203a.mFf.get(i2);
            C3154a c6744c = new C6744c(i);
            c6744c.hpS = c45966l;
            c6744c.mDz = c34203a.mDz;
            c6744c.mo7419ej(c45966l.type, c45966l.mDw);
            c3154a = c6744c;
        }
        if (c3154a != null) {
            c3154a.mFn = i2 + 1;
        }
        AppMethodBeat.m2505o(130086);
        return c3154a;
    }

    public final int getType() {
        return 4240;
    }

    /* renamed from: a */
    public final void mo7332a(C28109j c28109j, HashSet<String> hashSet) {
        AppMethodBeat.m2504i(130085);
        if (C3158b.m5391bX(c28109j.mEy)) {
            C34203a c34203a = new C34203a();
            c34203a.businessType = -15;
            c34203a.mDz = c28109j.mDz;
            c34203a.mFf = c28109j.mEy;
            this.mHp.add(c34203a);
        }
        AppMethodBeat.m2505o(130085);
    }
}
