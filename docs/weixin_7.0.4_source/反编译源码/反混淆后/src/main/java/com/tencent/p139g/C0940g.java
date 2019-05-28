package com.tencent.p139g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p139g.p1166b.C17759a;
import com.tencent.p139g.p1166b.C25637b;
import com.tencent.p139g.p1166b.C25638d;

/* renamed from: com.tencent.g.g */
public final class C0940g implements C25637b {
    private C0938f AHI;
    C25638d AHJ;
    C32132b AHK;
    C17759a AHL;
    int mReferenceCount = 0;
    int mState;

    public C0940g(C0938f c0938f, C25638d c25638d) {
        this.AHI = c0938f;
        this.AHJ = c25638d;
    }

    public final void start() {
        AppMethodBeat.m2504i(127761);
        this.AHI.mo3771a(this);
        AppMethodBeat.m2505o(127761);
    }
}
