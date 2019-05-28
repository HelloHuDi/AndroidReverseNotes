package com.tencent.p177mm.plugin.fts.p424ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.fts.p419a.p421d.C45970e;
import com.tencent.p177mm.plugin.fts.p419a.p421d.C45970e.C39133b;
import com.tencent.p177mm.plugin.fts.p419a.p421d.p422a.C3154a;
import com.tencent.p177mm.plugin.fts.p424ui.p426d.C31365l;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.HashSet;

/* renamed from: com.tencent.mm.plugin.fts.ui.l */
public final class C3200l extends C12067d implements C39133b {
    private C7306ak ilv = new C7306ak();
    private boolean mIF;
    private C31365l mJL;

    public C3200l(C28149e c28149e, String str, int i) {
        super(c28149e);
        AppMethodBeat.m2504i(61943);
        this.mJL = new C31365l(c28149e.getContext(), this, i);
        this.mJL.mEq = str;
        AppMethodBeat.m2505o(61943);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: vZ */
    public final C3154a mo7495vZ(int i) {
        AppMethodBeat.m2504i(61944);
        C3154a vZ = this.mJL.mo62055vZ(i);
        if (vZ != null) {
            vZ.pageType = 3;
        }
        AppMethodBeat.m2505o(61944);
        return vZ;
    }

    /* Access modifiers changed, original: protected|final */
    public final void bAL() {
        AppMethodBeat.m2504i(61945);
        this.mIF = false;
        this.mJL.mo62049a(this.query, this.ilv, new HashSet());
        AppMethodBeat.m2505o(61945);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final boolean mo7491a(View view, C3154a c3154a, boolean z) {
        AppMethodBeat.m2504i(61946);
        boolean a = this.mJL.mo7424a(view, c3154a, z);
        if (c3154a.mFt && !this.mIF) {
            this.mIF = true;
            C34234k.m56147c(this.query, true, this.mJL.bAK(), -2);
        }
        if (a) {
            clearCache();
            setCount(this.mJL.mo51308vY(0));
            notifyDataSetChanged();
            mo23894T(getCount(), true);
        }
        AppMethodBeat.m2505o(61946);
        return a;
    }

    /* renamed from: a */
    public final void mo7490a(C45970e c45970e, String str) {
        AppMethodBeat.m2504i(61947);
        setCount(c45970e.mo51308vY(0));
        notifyDataSetChanged();
        mo23894T(getCount(), true);
        AppMethodBeat.m2505o(61947);
    }

    public final void finish() {
        AppMethodBeat.m2504i(61948);
        super.finish();
        if (!this.mIF) {
            this.mIF = true;
            C34234k.m56147c(this.query, false, this.mJL.bAK(), -2);
        }
        AppMethodBeat.m2505o(61948);
    }

    /* Access modifiers changed, original: protected|final */
    public final int bAt() {
        AppMethodBeat.m2504i(139152);
        int bAK = this.mJL.bAK();
        AppMethodBeat.m2505o(139152);
        return bAK;
    }
}
