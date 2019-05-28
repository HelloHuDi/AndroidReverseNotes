package com.tencent.p177mm.plugin.fts.p424ui;

import android.content.Context;
import android.os.Looper;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.plugin.chatroom.p721a.C6822c;
import com.tencent.p177mm.plugin.fts.p419a.C12029n;
import com.tencent.p177mm.plugin.fts.p419a.p421d.C45970e;
import com.tencent.p177mm.plugin.fts.p419a.p421d.C45970e.C39133b;
import com.tencent.p177mm.plugin.fts.p419a.p421d.p422a.C3154a;
import com.tencent.p177mm.plugin.fts.p424ui.p426d.C45978f;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.HashSet;

/* renamed from: com.tencent.mm.plugin.fts.ui.g */
public final class C28150g extends C12067d implements C39133b {
    private C7306ak mHE = new C7306ak(Looper.getMainLooper());
    private C45978f mIE;
    private boolean mIF;

    public C28150g(C28149e c28149e, String str, int i) {
        super(c28149e);
        AppMethodBeat.m2504i(61811);
        Context context = c28149e.getContext();
        HashSet hashSet = new HashSet();
        hashSet.add(Integer.valueOf(160));
        C45978f c45978f = (C45978f) ((C12029n) C1720g.m3530M(C12029n.class)).createFTSUIUnitList(hashSet, context, this, i).get(0);
        c45978f.mEp = str;
        if (C1855t.m3896kH(str)) {
            c45978f.mIy = ((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV().mo14885oa(str);
        }
        this.mIE = c45978f;
        AppMethodBeat.m2505o(61811);
    }

    /* renamed from: a */
    public final void mo7490a(C45970e c45970e, String str) {
        AppMethodBeat.m2504i(61812);
        setCount(c45970e.mo51308vY(0));
        notifyDataSetChanged();
        mo23894T(getCount(), true);
        AppMethodBeat.m2505o(61812);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: vZ */
    public final C3154a mo7495vZ(int i) {
        AppMethodBeat.m2504i(61813);
        C3154a vZ = this.mIE.mo62055vZ(i);
        if (vZ != null) {
            vZ.mFm = i;
            vZ.pageType = 4;
        }
        AppMethodBeat.m2505o(61813);
        return vZ;
    }

    /* Access modifiers changed, original: protected|final */
    public final void bAL() {
        AppMethodBeat.m2504i(61814);
        this.mIF = false;
        this.mIE.mo62049a(this.query, this.mHE, new HashSet());
        AppMethodBeat.m2505o(61814);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final boolean mo7491a(View view, C3154a c3154a, boolean z) {
        AppMethodBeat.m2504i(61815);
        this.mIE.mo7424a(view, c3154a, z);
        if (c3154a.mFt && !this.mIF) {
            this.mIF = true;
            C34234k.m56147c(this.query, true, this.mIE.bAK(), -2);
        }
        AppMethodBeat.m2505o(61815);
        return false;
    }

    public final void finish() {
        AppMethodBeat.m2504i(61816);
        super.finish();
        if (!this.mIF) {
            this.mIF = true;
            C34234k.m56147c(this.query, false, this.mIE.bAK(), -2);
        }
        AppMethodBeat.m2505o(61816);
    }

    /* Access modifiers changed, original: protected|final */
    public final int bAt() {
        AppMethodBeat.m2504i(139150);
        int bAK = this.mIE.bAK();
        AppMethodBeat.m2505o(139150);
        return bAK;
    }
}
