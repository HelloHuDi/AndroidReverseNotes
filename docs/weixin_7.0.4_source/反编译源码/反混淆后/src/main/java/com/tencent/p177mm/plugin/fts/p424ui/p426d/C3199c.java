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
import com.tencent.p177mm.plugin.fts.p419a.p975c.C39131a;
import com.tencent.p177mm.plugin.fts.p424ui.C39153a;
import com.tencent.p177mm.plugin.fts.p424ui.p425a.C28140h;
import com.tencent.p177mm.plugin.fts.p424ui.p425a.C6925q;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.HashSet;

/* renamed from: com.tencent.mm.plugin.fts.ui.d.c */
public final class C3199c extends C39153a {
    public C3199c(Context context, C39133b c39133b, int i) {
        super(context, c39133b, i);
    }

    /* renamed from: a */
    public final C28106a mo7330a(C7306ak c7306ak, HashSet<String> hashSet) {
        AppMethodBeat.m2504i(62059);
        C20846i c20846i = new C20846i();
        c20846i.hbo = 96;
        c20846i.mEt = 3;
        c20846i.query = this.query;
        c20846i.mEu = hashSet;
        c20846i.mEv = C39131a.mEU;
        c20846i.mEw = this;
        c20846i.handler = c7306ak;
        C28106a search = ((C12029n) C1720g.m3530M(C12029n.class)).search(2, c20846i);
        AppMethodBeat.m2505o(62059);
        return search;
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0038  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final C3154a mo7331a(int i, C34203a c34203a) {
        C3154a c28140h;
        AppMethodBeat.m2504i(62061);
        int i2 = (i - c34203a.mFb) - 1;
        if (i2 < c34203a.mFf.size() && i2 >= 0) {
            C45966l c45966l = (C45966l) c34203a.mFf.get(i2);
            if (c45966l.mDx.equals("create_chatroom​")) {
                c28140h = new C28140h(i);
                c28140h.mDz = c34203a.mDz;
            } else if (c45966l.type == 131075) {
                C3154a a = mo7489a(131075, i, c45966l, c34203a);
                a.mo7419ej(c45966l.type, c45966l.mDw);
                c28140h = a;
            }
            if (c28140h != null) {
                c28140h.mFn = i2 + 1;
            }
            AppMethodBeat.m2505o(62061);
            return c28140h;
        }
        c28140h = null;
        if (c28140h != null) {
        }
        AppMethodBeat.m2505o(62061);
        return c28140h;
    }

    public final int getType() {
        return 48;
    }

    /* renamed from: a */
    public final C3154a mo7489a(int i, int i2, C45966l c45966l, C34203a c34203a) {
        AppMethodBeat.m2504i(62062);
        C6925q c6925q = new C6925q(i2);
        c6925q.hpS = c45966l;
        c6925q.mDz = c34203a.mDz;
        c6925q.mo7419ej(c45966l.type, c45966l.mDw);
        AppMethodBeat.m2505o(62062);
        return c6925q;
    }

    /* renamed from: a */
    public final void mo7332a(C28109j c28109j, HashSet<String> hashSet) {
        AppMethodBeat.m2504i(62060);
        if (C3158b.m5391bX(c28109j.mEy)) {
            C34203a c34203a = new C34203a();
            c34203a.mFf = c28109j.mEy;
            c34203a.businessType = -3;
            c34203a.mDz = c28109j.mDz;
            if (c34203a.mFf.size() > 3) {
                if (((C45966l) c34203a.mFf.get(3)).mDx.equals("create_chatroom​")) {
                    c34203a.mFe = c34203a.mFf.size() > 4;
                    c34203a.mFf = c34203a.mFf.subList(0, 4);
                } else {
                    c34203a.mFe = true;
                    c34203a.mFf = c34203a.mFf.subList(0, 3);
                }
            }
            this.mHp.add(c34203a);
        }
        AppMethodBeat.m2505o(62060);
    }
}
