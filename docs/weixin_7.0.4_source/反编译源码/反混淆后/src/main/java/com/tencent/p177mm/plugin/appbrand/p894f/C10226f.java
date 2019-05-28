package com.tencent.p177mm.plugin.appbrand.p894f;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelsns.C32831d;
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
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.HashSet;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.appbrand.f.f */
public final class C10226f extends C39153a {
    public C10226f(Context context, C39133b c39133b, int i) {
        super(context, c39133b, i);
    }

    /* renamed from: a */
    public final C28106a mo7330a(C7306ak c7306ak, HashSet<String> hashSet) {
        AppMethodBeat.m2504i(129976);
        C20846i c20846i = new C20846i();
        c20846i.query = this.query;
        c20846i.mEv = C12026d.mEX;
        c20846i.mEw = this;
        c20846i.handler = c7306ak;
        c20846i.mEu = hashSet;
        C28106a search = ((C12029n) C1720g.m3530M(C12029n.class)).search(7, c20846i);
        AppMethodBeat.m2505o(129976);
        return search;
    }

    /* renamed from: a */
    public final void mo7332a(C28109j c28109j, HashSet<String> hashSet) {
        AppMethodBeat.m2504i(129977);
        List list = c28109j.mEy;
        if (!(list == null || list.isEmpty())) {
            C32831d c32831d = new C32831d();
            String str = this.query;
            if (str != null) {
                str = str.replaceAll(",", " ");
            }
            c32831d.mo53400l("20KeyWordId", str + ",");
            c32831d.mo53400l("21ViewType", "2,");
            c32831d.mo53400l("22OpType", "1,");
            c32831d.mo53400l("23ResultCount", list.size() + ",");
            c32831d.mo53400l("24ClickPos", ",");
            c32831d.mo53400l("25ClickAppUserName", ",");
            C4990ab.m7417i("MicroMsg.FTSWeAppDetailUIUnit", "report oreh LocalSearchWeApp(13963), %s", c32831d.mo53398Fk());
            C7060h.pYm.mo8381e(13963, c32831d);
        }
        if (C3158b.m5391bX(c28109j.mEy)) {
            C34203a c34203a = new C34203a();
            c34203a.businessType = -13;
            c34203a.mDz = c28109j.mDz;
            c34203a.mFf = c28109j.mEy;
            this.mHp.add(c34203a);
        }
        AppMethodBeat.m2505o(129977);
    }

    /* renamed from: a */
    public final C3154a mo7331a(int i, C34203a c34203a) {
        AppMethodBeat.m2504i(129978);
        int i2 = (i - c34203a.mFb) - 1;
        C3154a c3154a = null;
        if (i2 < c34203a.mFf.size() && i2 >= 0) {
            C45966l c45966l = (C45966l) c34203a.mFf.get(i2);
            C3154a c26877d = new C26877d(i);
            c26877d.hpS = c45966l;
            c26877d.mDz = c34203a.mDz;
            c26877d.mo7419ej(c45966l.type, c45966l.mDw);
            c3154a = c26877d;
        }
        if (c3154a != null) {
            c3154a.mFn = i2 + 1;
        }
        AppMethodBeat.m2505o(129978);
        return c3154a;
    }

    public final int getType() {
        return 4224;
    }
}
