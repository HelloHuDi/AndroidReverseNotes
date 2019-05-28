package com.eclipsesource.p096a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.BuildConfig;

/* renamed from: com.eclipsesource.a.c */
final class C45008c extends C0803h {
    private final boolean aLn;
    private final boolean aLo;
    private final boolean aLp;
    private final String value;

    C45008c(String str) {
        AppMethodBeat.m2504i(70518);
        this.value = str;
        this.aLn = BuildConfig.COMMAND.equals(str);
        this.aLo = "true".equals(str);
        this.aLp = "false".equals(str);
        AppMethodBeat.m2505o(70518);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo2353a(C0804i c0804i) {
        AppMethodBeat.m2504i(70519);
        c0804i.mo2369an(this.value);
        AppMethodBeat.m2505o(70519);
    }

    public final String toString() {
        return this.value;
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(70520);
        int hashCode = this.value.hashCode();
        AppMethodBeat.m2505o(70520);
        return hashCode;
    }

    public final boolean isBoolean() {
        return this.aLo || this.aLp;
    }

    /* renamed from: oO */
    public final boolean mo2362oO() {
        AppMethodBeat.m2504i(70521);
        boolean oO;
        if (this.aLn) {
            oO = super.mo2362oO();
            AppMethodBeat.m2505o(70521);
            return oO;
        }
        oO = this.aLo;
        AppMethodBeat.m2505o(70521);
        return oO;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(70522);
        if (this == obj) {
            AppMethodBeat.m2505o(70522);
            return true;
        } else if (obj == null) {
            AppMethodBeat.m2505o(70522);
            return false;
        } else if (getClass() != obj.getClass()) {
            AppMethodBeat.m2505o(70522);
            return false;
        } else {
            boolean equals = this.value.equals(((C45008c) obj).value);
            AppMethodBeat.m2505o(70522);
            return equals;
        }
    }
}
