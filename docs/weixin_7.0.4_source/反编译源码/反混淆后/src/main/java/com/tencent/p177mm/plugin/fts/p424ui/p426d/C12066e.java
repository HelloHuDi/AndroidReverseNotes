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

/* renamed from: com.tencent.mm.plugin.fts.ui.d.e */
public final class C12066e extends C39153a {
    public C12066e(Context context, C39133b c39133b, int i) {
        super(context, c39133b, i);
    }

    /* renamed from: a */
    public final C28106a mo7330a(C7306ak c7306ak, HashSet<String> hashSet) {
        AppMethodBeat.m2504i(62066);
        C20846i c20846i = new C20846i();
        c20846i.hbo = 64;
        c20846i.query = this.query;
        c20846i.mEr = new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT, 131081};
        c20846i.mEt = 3;
        c20846i.mEv = C39132b.mEV;
        c20846i.mEu = hashSet;
        c20846i.mEw = this;
        c20846i.handler = c7306ak;
        C28106a search = ((C12029n) C1720g.m3530M(C12029n.class)).search(2, c20846i);
        AppMethodBeat.m2505o(62066);
        return search;
    }

    /* renamed from: a */
    public final C3154a mo7331a(int i, C34203a c34203a) {
        AppMethodBeat.m2504i(62068);
        C3154a c3154a = null;
        int i2 = 0;
        if (c34203a.mFc) {
            int i3 = (i - c34203a.mFb) - 1;
            if (i3 < c34203a.mFf.size() && i3 >= 0) {
                C45966l c45966l = (C45966l) c34203a.mFf.get(i3);
                c3154a = mo7489a(c45966l.type, i, c45966l, c34203a);
                if (c3154a != null) {
                    c3154a.mo7419ej(c45966l.type, c45966l.mDw);
                }
            }
            i2 = i3;
        }
        if (c3154a != null) {
            c3154a.mFn = i2 + 1;
        }
        AppMethodBeat.m2505o(62068);
        return c3154a;
    }

    public final int getType() {
        return 32;
    }

    /* renamed from: a */
    public final C3154a mo7489a(int i, int i2, C45966l c45966l, C34203a c34203a) {
        AppMethodBeat.m2504i(62069);
        C3154a c3154a = null;
        if (c45966l.type == WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT || c45966l.type == 131081) {
            c3154a = new C3195r(i2);
            c3154a.hpS = c45966l;
            c3154a.mDz = c34203a.mDz;
            c3154a.mo7419ej(c45966l.type, c45966l.mDw);
        } else if (c45966l.type == 131073 || c45966l.type == 131074) {
            c3154a = ((C39153a) ((C12029n) C1720g.m3530M(C12029n.class)).createFTSUIUnit(33, this.context, this.mEZ, this.mFa)).mo7489a(i, i2, c45966l, c34203a);
        }
        AppMethodBeat.m2505o(62069);
        return c3154a;
    }

    /* renamed from: a */
    public final void mo7332a(C28109j c28109j, HashSet<String> hashSet) {
        AppMethodBeat.m2504i(62067);
        C34203a c34203a = new C34203a();
        c34203a.businessType = -4;
        c34203a.mFf = c28109j.mEy;
        c34203a.mFc = C3158b.m5391bX(c28109j.mEy);
        c34203a.mDz = c28109j.mDz;
        if (c34203a.mFf.size() > 3) {
            c34203a.mFe = true;
            c34203a.mFf = c34203a.mFf.subList(0, 3);
        }
        if (C3158b.m5391bX(c28109j.mEy)) {
            this.mHp.add(c34203a);
        }
        AppMethodBeat.m2505o(62067);
    }
}
