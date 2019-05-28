package com.eclipsesource.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;

final class c extends h {
    private final boolean aLn;
    private final boolean aLo;
    private final boolean aLp;
    private final String value;

    c(String str) {
        AppMethodBeat.i(70518);
        this.value = str;
        this.aLn = BuildConfig.COMMAND.equals(str);
        this.aLo = "true".equals(str);
        this.aLp = "false".equals(str);
        AppMethodBeat.o(70518);
    }

    /* Access modifiers changed, original: final */
    public final void a(i iVar) {
        AppMethodBeat.i(70519);
        iVar.an(this.value);
        AppMethodBeat.o(70519);
    }

    public final String toString() {
        return this.value;
    }

    public final int hashCode() {
        AppMethodBeat.i(70520);
        int hashCode = this.value.hashCode();
        AppMethodBeat.o(70520);
        return hashCode;
    }

    public final boolean isBoolean() {
        return this.aLo || this.aLp;
    }

    public final boolean oO() {
        AppMethodBeat.i(70521);
        boolean oO;
        if (this.aLn) {
            oO = super.oO();
            AppMethodBeat.o(70521);
            return oO;
        }
        oO = this.aLo;
        AppMethodBeat.o(70521);
        return oO;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(70522);
        if (this == obj) {
            AppMethodBeat.o(70522);
            return true;
        } else if (obj == null) {
            AppMethodBeat.o(70522);
            return false;
        } else if (getClass() != obj.getClass()) {
            AppMethodBeat.o(70522);
            return false;
        } else {
            boolean equals = this.value.equals(((c) obj).value);
            AppMethodBeat.o(70522);
            return equals;
        }
    }
}
