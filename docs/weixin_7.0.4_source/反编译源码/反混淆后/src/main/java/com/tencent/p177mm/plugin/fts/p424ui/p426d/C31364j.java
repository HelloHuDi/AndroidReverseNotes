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
import com.tencent.p177mm.plugin.fts.p424ui.p425a.C12061i;
import com.tencent.p177mm.plugin.fts.p424ui.p425a.C39148l;
import com.tencent.p177mm.plugin.fts.p424ui.p425a.C45974m;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.fts.ui.d.j */
public final class C31364j extends C28148k {
    public C31364j(Context context, C39133b c39133b, int i) {
        super(context, c39133b, i);
    }

    /* renamed from: a */
    public final C28106a mo7330a(C7306ak c7306ak, HashSet<String> hashSet) {
        AppMethodBeat.m2504i(62085);
        this.mLK = false;
        C20846i c20846i = new C20846i();
        c20846i.query = this.query;
        c20846i.mEu = hashSet;
        c20846i.mEw = this;
        c20846i.handler = c7306ak;
        C28106a search = ((C12029n) C1720g.m3530M(C12029n.class)).search(3, c20846i);
        AppMethodBeat.m2505o(62085);
        return search;
    }

    /* renamed from: a */
    public final void mo7332a(C28109j c28109j, HashSet<String> hashSet) {
        AppMethodBeat.m2504i(62086);
        List list = c28109j.mEy;
        if (C3158b.m5391bX(list)) {
            if (list.size() > 0) {
                C45966l c45966l = (C45966l) list.get(0);
                if (c45966l.mDx.equals("create_talker_message​")) {
                    C34203a c34203a = new C34203a();
                    c34203a.mFc = false;
                    c34203a.mFf = new ArrayList();
                    c34203a.mFf.add(c45966l);
                    c34203a.mDz = c28109j.mDz;
                    c34203a.businessType = -2;
                    this.mHp.add(c34203a);
                    list.remove(0);
                }
            }
            C34203a c34203a2 = new C34203a();
            c34203a2.businessType = -2;
            c34203a2.mDz = c28109j.mDz;
            if (list.size() == 0) {
                c34203a2.mFc = false;
                C45966l c45966l2 = new C45966l();
                c45966l2.mDx = "no_result​";
                c34203a2.mFf = new ArrayList();
                c34203a2.mFf.add(c45966l2);
            } else {
                c34203a2.mFf = list;
            }
            this.mHp.add(c34203a2);
        }
        AppMethodBeat.m2505o(62086);
    }

    /* renamed from: a */
    public final C3154a mo7331a(int i, C34203a c34203a) {
        int i2;
        AppMethodBeat.m2504i(62087);
        int i3 = i - c34203a.mFb;
        if (c34203a.mFc) {
            i2 = i3 - 1;
        } else {
            i2 = i3;
        }
        C3154a c3154a = null;
        if (i2 < c34203a.mFf.size() && i2 >= 0) {
            C45966l c45966l = (C45966l) c34203a.mFf.get(i2);
            if (c45966l.mDx.equals("create_talker_message​")) {
                c3154a = new C12061i(i);
                c3154a.mFk = false;
                this.mLK = true;
            } else if (c45966l.mDx.equals("no_result​")) {
                c3154a = new C39148l(i);
            } else {
                C3154a c45974m = new C45974m(i);
                c45974m.hpS = c45966l;
                c45974m.mo7419ej(c45966l.type, c45966l.mDw);
                c3154a = c45974m;
            }
        }
        if (c3154a != null) {
            c3154a.mFn = i2 + 1;
            c3154a.mDz = c34203a.mDz;
        }
        AppMethodBeat.m2505o(62087);
        return c3154a;
    }

    public final int getType() {
        return 4176;
    }
}
