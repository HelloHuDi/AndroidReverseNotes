package com.eclipsesource.p096a;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.eclipsesource.a.d */
final class C37207d extends C0803h {
    private final String string;

    C37207d(String str) {
        AppMethodBeat.m2504i(70523);
        if (str == null) {
            NullPointerException nullPointerException = new NullPointerException("string is null");
            AppMethodBeat.m2505o(70523);
            throw nullPointerException;
        }
        this.string = str;
        AppMethodBeat.m2505o(70523);
    }

    public final String toString() {
        return this.string;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo2353a(C0804i c0804i) {
        AppMethodBeat.m2504i(70524);
        c0804i.mo2370ao(this.string);
        AppMethodBeat.m2505o(70524);
    }

    public final boolean isNumber() {
        return true;
    }

    /* renamed from: oP */
    public final int mo2363oP() {
        AppMethodBeat.m2504i(70525);
        int parseInt = Integer.parseInt(this.string, 10);
        AppMethodBeat.m2505o(70525);
        return parseInt;
    }

    /* renamed from: oQ */
    public final long mo2364oQ() {
        AppMethodBeat.m2504i(70526);
        long parseLong = Long.parseLong(this.string, 10);
        AppMethodBeat.m2505o(70526);
        return parseLong;
    }

    /* renamed from: oR */
    public final double mo2365oR() {
        AppMethodBeat.m2504i(70527);
        double parseDouble = Double.parseDouble(this.string);
        AppMethodBeat.m2505o(70527);
        return parseDouble;
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(70528);
        int hashCode = this.string.hashCode();
        AppMethodBeat.m2505o(70528);
        return hashCode;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(70529);
        if (this == obj) {
            AppMethodBeat.m2505o(70529);
            return true;
        } else if (obj == null) {
            AppMethodBeat.m2505o(70529);
            return false;
        } else if (getClass() != obj.getClass()) {
            AppMethodBeat.m2505o(70529);
            return false;
        } else {
            boolean equals = this.string.equals(((C37207d) obj).string);
            AppMethodBeat.m2505o(70529);
            return equals;
        }
    }
}
