package com.eclipsesource.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class d extends h {
    private final String string;

    d(String str) {
        AppMethodBeat.i(70523);
        if (str == null) {
            NullPointerException nullPointerException = new NullPointerException("string is null");
            AppMethodBeat.o(70523);
            throw nullPointerException;
        }
        this.string = str;
        AppMethodBeat.o(70523);
    }

    public final String toString() {
        return this.string;
    }

    /* Access modifiers changed, original: final */
    public final void a(i iVar) {
        AppMethodBeat.i(70524);
        iVar.ao(this.string);
        AppMethodBeat.o(70524);
    }

    public final boolean isNumber() {
        return true;
    }

    public final int oP() {
        AppMethodBeat.i(70525);
        int parseInt = Integer.parseInt(this.string, 10);
        AppMethodBeat.o(70525);
        return parseInt;
    }

    public final long oQ() {
        AppMethodBeat.i(70526);
        long parseLong = Long.parseLong(this.string, 10);
        AppMethodBeat.o(70526);
        return parseLong;
    }

    public final double oR() {
        AppMethodBeat.i(70527);
        double parseDouble = Double.parseDouble(this.string);
        AppMethodBeat.o(70527);
        return parseDouble;
    }

    public final int hashCode() {
        AppMethodBeat.i(70528);
        int hashCode = this.string.hashCode();
        AppMethodBeat.o(70528);
        return hashCode;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(70529);
        if (this == obj) {
            AppMethodBeat.o(70529);
            return true;
        } else if (obj == null) {
            AppMethodBeat.o(70529);
            return false;
        } else if (getClass() != obj.getClass()) {
            AppMethodBeat.o(70529);
            return false;
        } else {
            boolean equals = this.string.equals(((d) obj).string);
            AppMethodBeat.o(70529);
            return equals;
        }
    }
}
