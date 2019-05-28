package com.tencent.p177mm.plugin.fts.p424ui;

import android.os.Looper;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.fts.p419a.p421d.C45970e;
import com.tencent.p177mm.plugin.fts.p419a.p421d.C45970e.C39133b;
import com.tencent.p177mm.plugin.fts.p419a.p421d.p422a.C3154a;
import com.tencent.p177mm.plugin.fts.p424ui.p426d.C34229a;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.HashSet;

/* renamed from: com.tencent.mm.plugin.fts.ui.c */
public final class C16767c extends C12067d implements C39133b {
    private C34229a mHC;
    protected boolean mHD;
    private C7306ak mHE = new C7306ak(Looper.getMainLooper());

    public C16767c(C28149e c28149e) {
        super(c28149e);
        AppMethodBeat.m2504i(61720);
        this.mHC = new C34229a(c28149e.getContext(), this, 0);
        AppMethodBeat.m2505o(61720);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: vZ */
    public final C3154a mo7495vZ(int i) {
        AppMethodBeat.m2504i(61721);
        C3154a vZ = this.mHC.mo62055vZ(i);
        AppMethodBeat.m2505o(61721);
        return vZ;
    }

    /* Access modifiers changed, original: protected|final */
    public final void bAL() {
        AppMethodBeat.m2504i(61722);
        this.mHD = false;
        this.mHC.mo62049a(this.query, this.mHE, new HashSet());
        AppMethodBeat.m2505o(61722);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final boolean mo7491a(View view, C3154a c3154a, boolean z) {
        return false;
    }

    /* renamed from: a */
    public final void mo7490a(C45970e c45970e, String str) {
        AppMethodBeat.m2504i(61723);
        int vY = this.mHC.mo51308vY(0);
        setCount(vY);
        notifyDataSetChanged();
        mo23894T(vY, true);
        AppMethodBeat.m2505o(61723);
    }

    /* Access modifiers changed, original: protected|final */
    public final int bAt() {
        AppMethodBeat.m2504i(61724);
        int bAK = this.mHC.bAK();
        AppMethodBeat.m2505o(61724);
        return bAK;
    }
}
