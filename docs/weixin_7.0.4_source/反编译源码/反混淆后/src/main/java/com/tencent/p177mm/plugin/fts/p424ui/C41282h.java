package com.tencent.p177mm.plugin.fts.p424ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.fts.p419a.p421d.C45970e;
import com.tencent.p177mm.plugin.fts.p419a.p421d.C45970e.C39133b;
import com.tencent.p177mm.plugin.fts.p419a.p421d.p422a.C3154a;
import com.tencent.p177mm.plugin.fts.p424ui.p426d.C39155g;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.HashSet;

/* renamed from: com.tencent.mm.plugin.fts.ui.h */
public final class C41282h extends C12067d implements C39133b {
    private C7306ak ilv = new C7306ak();
    private boolean mIF;
    private C39155g mII;

    public C41282h(C28149e c28149e, String str, String str2, String str3, int i, int i2) {
        super(c28149e);
        AppMethodBeat.m2504i(61824);
        this.mII = new C39155g(c28149e.getContext(), this, i);
        this.mII.mEq = str2;
        this.mII.talker = str;
        this.mII.mEp = str3;
        this.mII.showType = i2;
        AppMethodBeat.m2505o(61824);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: vZ */
    public final C3154a mo7495vZ(int i) {
        AppMethodBeat.m2504i(61825);
        C3154a vZ = this.mII.mo62055vZ(i);
        if (vZ != null) {
            vZ.pageType = 5;
        }
        AppMethodBeat.m2505o(61825);
        return vZ;
    }

    /* Access modifiers changed, original: protected|final */
    public final void bAL() {
        AppMethodBeat.m2504i(61826);
        this.mIF = false;
        this.mII.mo62049a(this.query, this.ilv, new HashSet());
        AppMethodBeat.m2505o(61826);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final boolean mo7491a(View view, C3154a c3154a, boolean z) {
        AppMethodBeat.m2504i(61827);
        boolean a = this.mII.mo7424a(view, c3154a, z);
        if (c3154a.mFt && !this.mIF) {
            this.mIF = true;
            C34234k.m56147c(this.query, true, this.mII.bAK(), -2);
        }
        if (a) {
            clearCache();
            setCount(this.mII.mo51308vY(0));
            notifyDataSetChanged();
            mo23894T(getCount(), true);
        }
        AppMethodBeat.m2505o(61827);
        return a;
    }

    /* renamed from: a */
    public final void mo7490a(C45970e c45970e, String str) {
        AppMethodBeat.m2504i(61828);
        setCount(c45970e.mo51308vY(0));
        notifyDataSetChanged();
        mo23894T(getCount(), true);
        AppMethodBeat.m2505o(61828);
    }

    public final void finish() {
        AppMethodBeat.m2504i(61829);
        super.finish();
        if (!this.mIF) {
            this.mIF = true;
            C34234k.m56147c(this.query, false, this.mII.bAK(), -2);
        }
        AppMethodBeat.m2505o(61829);
    }

    /* Access modifiers changed, original: protected|final */
    public final int bAt() {
        AppMethodBeat.m2504i(139151);
        int bAK = this.mII.bAK();
        AppMethodBeat.m2505o(139151);
        return bAK;
    }
}
