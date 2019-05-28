package com.tencent.p177mm.plugin.brandservice.p349ui.p927a;

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
import com.tencent.p177mm.plugin.fts.p419a.p975c.C39132b;
import com.tencent.p177mm.plugin.fts.p424ui.C39153a;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.HashSet;

/* renamed from: com.tencent.mm.plugin.brandservice.ui.a.e */
public final class C11200e extends C39153a {
    public C11200e(Context context, C39133b c39133b, int i) {
        super(context, c39133b, i);
    }

    /* renamed from: a */
    public final C3154a mo7331a(int i, C34203a c34203a) {
        AppMethodBeat.m2504i(14095);
        int i2 = (i - c34203a.mFb) - 1;
        C3154a c3154a = null;
        if (i2 < c34203a.mFf.size() && i2 >= 0) {
            C45966l c45966l = (C45966l) c34203a.mFf.get(i2);
            C3154a a = mo7489a(131076, i, c45966l, c34203a);
            a.mo7419ej(c45966l.type, c45966l.mDw);
            c3154a = a;
        }
        if (c3154a != null) {
            c3154a.mFn = i2 + 1;
        }
        AppMethodBeat.m2505o(14095);
        return c3154a;
    }

    public final int getType() {
        return 96;
    }

    /* renamed from: a */
    public final C3154a mo7489a(int i, int i2, C45966l c45966l, C34203a c34203a) {
        AppMethodBeat.m2504i(14096);
        C42804a c42804a = new C42804a(i2);
        c42804a.hpS = c45966l;
        c42804a.mDz = c34203a.mDz;
        c42804a.mo7419ej(c45966l.type, c45966l.mDw);
        AppMethodBeat.m2505o(14096);
        return c42804a;
    }

    /* renamed from: a */
    public final C28106a mo7330a(C7306ak c7306ak, HashSet<String> hashSet) {
        AppMethodBeat.m2504i(14093);
        C28106a search = ((C12029n) C1720g.m3530M(C12029n.class)).search(2, C20846i.m32057a(this.query, new int[]{131076}, null, 4, hashSet, C39132b.mEV, this, c7306ak));
        AppMethodBeat.m2505o(14093);
        return search;
    }

    /* renamed from: a */
    public final void mo7332a(C28109j c28109j, HashSet<String> hashSet) {
        AppMethodBeat.m2504i(14094);
        if (C3158b.m5391bX(c28109j.mEy)) {
            C34203a c34203a = new C34203a();
            c34203a.businessType = -7;
            c34203a.mFf = c28109j.mEy;
            c34203a.mDz = c28109j.mDz;
            if (c34203a.mFf.size() > 3) {
                c34203a.mFe = true;
                c34203a.mFf = c34203a.mFf.subList(0, 3);
            }
            this.mHp.add(c34203a);
        }
        AppMethodBeat.m2505o(14094);
    }
}
