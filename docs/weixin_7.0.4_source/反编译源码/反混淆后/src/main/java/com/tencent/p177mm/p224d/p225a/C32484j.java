package com.tencent.p177mm.p224d.p225a;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.d.a.j */
final class C32484j extends C16537w {
    private static final ThreadLocal<C32484j> chH = new ThreadLocal();
    private final C32483a chF;
    private boolean chG = true;

    /* renamed from: com.tencent.mm.d.a.j$a */
    interface C32483a {
        /* renamed from: Cw */
        boolean mo20678Cw();

        void closeUVLoop();

        void wakeUpUVLoop();
    }

    static {
        AppMethodBeat.m2504i(113827);
        AppMethodBeat.m2505o(113827);
    }

    /* renamed from: a */
    public static C32484j m53173a(C32483a c32483a) {
        AppMethodBeat.m2504i(113822);
        if (chH.get() != null) {
            RuntimeException runtimeException = new RuntimeException("Only one Looper may be created per thread");
            AppMethodBeat.m2505o(113822);
            throw runtimeException;
        }
        C32484j c32484j = new C32484j(c32483a);
        chH.set(c32484j);
        AppMethodBeat.m2505o(113822);
        return c32484j;
    }

    private C32484j(C32483a c32483a) {
        this.chF = c32483a;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: Cx */
    public final boolean mo30506Cx() {
        AppMethodBeat.m2504i(113823);
        if (this.chG || !super.mo30506Cx()) {
            AppMethodBeat.m2505o(113823);
            return false;
        }
        AppMethodBeat.m2505o(113823);
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: Cy */
    public final void mo30507Cy() {
        AppMethodBeat.m2504i(113824);
        super.mo30507Cy();
        this.chG = this.chF.mo20678Cw();
        AppMethodBeat.m2505o(113824);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: Cz */
    public final void mo30508Cz() {
        AppMethodBeat.m2504i(113825);
        super.mo30508Cz();
        if (this.chF != null) {
            this.chF.closeUVLoop();
        }
        AppMethodBeat.m2505o(113825);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: CA */
    public final void mo30505CA() {
        AppMethodBeat.m2504i(113826);
        if (this.chF != null) {
            this.chF.wakeUpUVLoop();
        }
        AppMethodBeat.m2505o(113826);
    }
}
