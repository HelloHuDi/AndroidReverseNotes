package com.tencent.p177mm.plugin.fts.p424ui.p426d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.plugin.fts.p419a.C12029n;
import com.tencent.p177mm.plugin.fts.p419a.C3161d;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C20846i;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C28106a;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C28109j;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C45966l;
import com.tencent.p177mm.plugin.fts.p419a.p421d.C3158b;
import com.tencent.p177mm.plugin.fts.p419a.p421d.C45970e.C34203a;
import com.tencent.p177mm.plugin.fts.p419a.p421d.C45970e.C39133b;
import com.tencent.p177mm.plugin.fts.p419a.p421d.p422a.C3154a;
import com.tencent.p177mm.plugin.fts.p424ui.C39153a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.HashSet;

/* renamed from: com.tencent.mm.plugin.fts.ui.d.m */
public final class C20881m extends C39153a {
    private boolean mLJ = false;

    public C20881m(Context context, C39133b c39133b, int i) {
        boolean z;
        super(context, c39133b, i);
        AppMethodBeat.m2504i(62099);
        String str = (String) C1720g.m3536RP().mo5239Ry().get(6, null);
        if (str == null || str.length() <= 0) {
            z = false;
        } else {
            z = true;
        }
        this.mLJ = z;
        this.mLJ &= C5046bo.m7558gT(context);
        AppMethodBeat.m2505o(62099);
    }

    /* renamed from: a */
    public final C28106a mo7330a(C7306ak c7306ak, HashSet<String> hashSet) {
        int[] iArr;
        AppMethodBeat.m2504i(62100);
        C20846i c20846i = new C20846i();
        if (this.mLJ) {
            iArr = new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT, 131075, 131073, 131074, 262144, 131076};
        } else {
            iArr = new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT, 131075, 262144, 131076};
        }
        c20846i.mEr = iArr;
        c20846i.mEt = 3;
        c20846i.mEw = this;
        c20846i.handler = c7306ak;
        c20846i.scene = 0;
        c20846i.mEu = hashSet;
        C28106a search;
        if (this.query.startsWith("@@")) {
            c20846i.query = this.query.substring(2);
            search = ((C12029n) C1720g.m3530M(C12029n.class)).search(Downloads.MIN_WAIT_FOR_NETWORK, c20846i);
            AppMethodBeat.m2505o(62100);
            return search;
        }
        c20846i.query = this.query;
        search = ((C12029n) C1720g.m3530M(C12029n.class)).search(1, c20846i);
        AppMethodBeat.m2505o(62100);
        return search;
    }

    /* renamed from: a */
    public final void mo7332a(C28109j c28109j, HashSet<String> hashSet) {
        AppMethodBeat.m2504i(62101);
        for (C45966l c45966l : c28109j.mEy) {
            hashSet.add(c45966l.mDx);
        }
        if (C3158b.m5391bX(c28109j.mEy)) {
            C34203a c34203a = new C34203a();
            c34203a.businessType = -8;
            c34203a.mFf = C3158b.m5392bY(c28109j.mEy);
            c34203a.mFe = false;
            c34203a.mDz = c28109j.mDz;
            this.mHp.add(c34203a);
        }
        C3161d.m5412bW(c28109j.mEy);
        AppMethodBeat.m2505o(62101);
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0046  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final C3154a mo7331a(int i, C34203a c34203a) {
        C3154a a;
        AppMethodBeat.m2504i(62102);
        int i2 = (i - c34203a.mFb) - 1;
        if (i2 < c34203a.mFf.size() && i2 >= 0) {
            C45966l c45966l = (C45966l) c34203a.mFf.get(i2);
            C39153a c39153a = c45966l.type == 131075 ? (C39153a) ((C12029n) C1720g.m3530M(C12029n.class)).createFTSUIUnit(48, this.context, this.mEZ, this.mFa) : (c45966l.type == WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT || c45966l.type == 131073 || c45966l.type == 131074) ? (C39153a) ((C12029n) C1720g.m3530M(C12029n.class)).createFTSUIUnit(32, this.context, this.mEZ, this.mFa) : c45966l.type == 262144 ? (C39153a) ((C12029n) C1720g.m3530M(C12029n.class)).createFTSUIUnit(64, this.context, this.mEZ, this.mFa) : c45966l.type == 131076 ? (C39153a) ((C12029n) C1720g.m3530M(C12029n.class)).createFTSUIUnit(96, this.context, this.mEZ, this.mFa) : null;
            if (c39153a != null) {
                a = c39153a.mo7489a(c45966l.type, i, c45966l, c34203a);
                if (a != null) {
                    a.mFn = i2 + 1;
                }
                AppMethodBeat.m2505o(62102);
                return a;
            }
        }
        a = null;
        if (a != null) {
        }
        AppMethodBeat.m2505o(62102);
        return a;
    }

    public final int getType() {
        return 16;
    }
}
