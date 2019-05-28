package com.tencent.p177mm.plugin.fts.p424ui.p426d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
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
import com.tencent.p177mm.plugin.fts.p424ui.p425a.C3195r;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.HashSet;

/* renamed from: com.tencent.mm.plugin.fts.ui.d.d */
public final class C12065d extends C39153a {
    public C12065d(Context context, C39133b c39133b, int i) {
        super(context, c39133b, i);
    }

    /* renamed from: a */
    public final C28106a mo7330a(C7306ak c7306ak, HashSet<String> hashSet) {
        AppMethodBeat.m2504i(62063);
        C20846i c20846i = new C20846i();
        c20846i.query = this.query;
        c20846i.mEr = new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT, 131081};
        c20846i.mEv = C39132b.mEV;
        c20846i.mEu = hashSet;
        c20846i.mEw = this;
        c20846i.handler = c7306ak;
        c20846i.hbo = 16;
        C28106a search = ((C12029n) C1720g.m3530M(C12029n.class)).search(2, c20846i);
        AppMethodBeat.m2505o(62063);
        return search;
    }

    /* renamed from: a */
    public final C3154a mo7331a(int i, C34203a c34203a) {
        AppMethodBeat.m2504i(62065);
        int i2 = (i - c34203a.mFb) - 1;
        C3154a c3154a = null;
        if (i2 < c34203a.mFf.size() && i2 >= 0) {
            C45966l c45966l = (C45966l) c34203a.mFf.get(i2);
            C3154a c3195r = new C3195r(i);
            c3195r.hpS = c45966l;
            c3195r.mDz = c34203a.mDz;
            c3195r.mo7419ej(c45966l.type, c45966l.mDw);
            c3154a = c3195r;
        }
        if (c3154a != null) {
            c3154a.mFn = i2 + 1;
        }
        AppMethodBeat.m2505o(62065);
        return c3154a;
    }

    public final int getType() {
        return 4112;
    }

    /* renamed from: a */
    public final void mo7332a(C28109j c28109j, HashSet<String> hashSet) {
        AppMethodBeat.m2504i(62064);
        if (C3158b.m5391bX(c28109j.mEy)) {
            C34203a c34203a = new C34203a();
            c34203a.businessType = -4;
            c34203a.mFf = c28109j.mEy;
            c34203a.mDz = c28109j.mDz;
            c34203a.mFe = false;
            this.mHp.add(c34203a);
        }
        AppMethodBeat.m2505o(62064);
    }
}
