package com.tencent.p177mm.plugin.fts.p424ui.p426d;

import android.content.Context;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.fts.p419a.C12029n;
import com.tencent.p177mm.plugin.fts.p419a.C3161d;
import com.tencent.p177mm.plugin.fts.p419a.C34202c;
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
import com.tencent.p177mm.plugin.fts.p424ui.p425a.C20866a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.fts.ui.d.a */
public final class C34229a extends C39153a {
    private boolean mLJ;

    public C34229a(Context context, C39133b c39133b, int i) {
        boolean z;
        super(context, c39133b, i);
        AppMethodBeat.m2504i(62051);
        String str = (String) C1720g.m3536RP().mo5239Ry().get(6, null);
        if (str == null || str.length() <= 0) {
            z = false;
        } else {
            z = true;
        }
        this.mLJ = z;
        C4990ab.m7411d("MicroMsg.FTS.FTSAddFriendUIUnit", "[FTSAddFriendUIUnit doSearchMobile : %s]", Boolean.valueOf(this.mLJ));
        AppMethodBeat.m2505o(62051);
    }

    private int[] bBk() {
        AppMethodBeat.m2504i(62053);
        ArrayList arrayList = new ArrayList();
        if (this.mLJ) {
            arrayList.add(Integer.valueOf(16));
        }
        int[] iArr = new int[arrayList.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < arrayList.size()) {
                iArr[i2] = ((Integer) arrayList.get(i2)).intValue();
                i = i2 + 1;
            } else {
                AppMethodBeat.m2505o(62053);
                return iArr;
            }
        }
    }

    /* renamed from: a */
    public final void mo7332a(C28109j c28109j, HashSet<String> hashSet) {
        AppMethodBeat.m2504i(62054);
        List list = c28109j.mEy;
        this.mHp.clear();
        C34203a c34203a = new C34203a();
        c34203a.businessType = -4;
        c34203a.mFc = false;
        c34203a.mFi = 1;
        c34203a.mDz = c28109j.mDz;
        c34203a.mFf = new LinkedList();
        this.mHp.add(c34203a);
        if (C3158b.m5391bX(list)) {
            list = C3161d.m5409a(list, C34202c.mCq);
            if (C3158b.m5391bX(list)) {
                c34203a = new C34203a();
                c34203a.businessType = -11;
                c34203a.mFf = list;
                c34203a.mDz = c28109j.mDz;
                this.mHp.add(c34203a);
            }
        }
        AppMethodBeat.m2505o(62054);
    }

    /* renamed from: a */
    public final C3154a mo7331a(int i, C34203a c34203a) {
        AppMethodBeat.m2504i(62055);
        int i2 = (i - c34203a.mFb) - 1;
        C3154a c3154a = null;
        if (i2 < c34203a.mFf.size() && i2 >= 0) {
            C3154a a;
            C45966l c45966l = (C45966l) c34203a.mFf.get(i2);
            if (c45966l.type == 131073 || c45966l.type == 131074) {
                a = ((C39153a) ((C12029n) C1720g.m3530M(C12029n.class)).createFTSUIUnit(33, this.context, this.mEZ, this.mFa)).mo7489a(c45966l.type, i, c45966l, c34203a);
            } else {
                a = null;
            }
            c3154a = a;
        } else if (!c34203a.mFc && i == 0) {
            c3154a = new C20866a(i);
            c3154a.mDz = c34203a.mDz;
        }
        if (c3154a != null) {
            c3154a.mFn = i2 + 1;
        }
        AppMethodBeat.m2505o(62055);
        return c3154a;
    }

    public final int getType() {
        return Utility.DEFAULT_STREAM_BUFFER_SIZE;
    }

    /* renamed from: a */
    public final C28106a mo7330a(C7306ak c7306ak, HashSet<String> hashSet) {
        AppMethodBeat.m2504i(62052);
        String str = this.query;
        ArrayList arrayList = new ArrayList();
        if (this.mLJ) {
            arrayList.add(Integer.valueOf(131073));
            arrayList.add(Integer.valueOf(131074));
        }
        int[] iArr = new int[arrayList.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < arrayList.size()) {
                iArr[i2] = ((Integer) arrayList.get(i2)).intValue();
                i = i2 + 1;
            } else {
                C28106a search = ((C12029n) C1720g.m3530M(C12029n.class)).search(9, C20846i.m32057a(str, iArr, bBk(), -1, hashSet, C39132b.mEV, this, c7306ak));
                AppMethodBeat.m2505o(62052);
                return search;
            }
        }
    }
}
