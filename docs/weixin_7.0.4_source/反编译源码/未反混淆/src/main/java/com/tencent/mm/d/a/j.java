package com.tencent.mm.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class j extends w {
    private static final ThreadLocal<j> chH = new ThreadLocal();
    private final a chF;
    private boolean chG = true;

    interface a {
        boolean Cw();

        void closeUVLoop();

        void wakeUpUVLoop();
    }

    static {
        AppMethodBeat.i(113827);
        AppMethodBeat.o(113827);
    }

    public static j a(a aVar) {
        AppMethodBeat.i(113822);
        if (chH.get() != null) {
            RuntimeException runtimeException = new RuntimeException("Only one Looper may be created per thread");
            AppMethodBeat.o(113822);
            throw runtimeException;
        }
        j jVar = new j(aVar);
        chH.set(jVar);
        AppMethodBeat.o(113822);
        return jVar;
    }

    private j(a aVar) {
        this.chF = aVar;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean Cx() {
        AppMethodBeat.i(113823);
        if (this.chG || !super.Cx()) {
            AppMethodBeat.o(113823);
            return false;
        }
        AppMethodBeat.o(113823);
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    public final void Cy() {
        AppMethodBeat.i(113824);
        super.Cy();
        this.chG = this.chF.Cw();
        AppMethodBeat.o(113824);
    }

    /* Access modifiers changed, original: protected|final */
    public final void Cz() {
        AppMethodBeat.i(113825);
        super.Cz();
        if (this.chF != null) {
            this.chF.closeUVLoop();
        }
        AppMethodBeat.o(113825);
    }

    /* Access modifiers changed, original: protected|final */
    public final void CA() {
        AppMethodBeat.i(113826);
        if (this.chF != null) {
            this.chF.wakeUpUVLoop();
        }
        AppMethodBeat.o(113826);
    }
}
