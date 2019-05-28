package com.eclipsesource.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class g extends h {
    private final String string;

    g(String str) {
        AppMethodBeat.i(70580);
        if (str == null) {
            NullPointerException nullPointerException = new NullPointerException("string is null");
            AppMethodBeat.o(70580);
            throw nullPointerException;
        }
        this.string = str;
        AppMethodBeat.o(70580);
    }

    /* Access modifiers changed, original: final */
    public final void a(i iVar) {
        AppMethodBeat.i(70581);
        iVar.writeString(this.string);
        AppMethodBeat.o(70581);
    }

    public final boolean isString() {
        return true;
    }

    public final String pq() {
        return this.string;
    }

    public final int hashCode() {
        AppMethodBeat.i(70582);
        int hashCode = this.string.hashCode();
        AppMethodBeat.o(70582);
        return hashCode;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(70583);
        if (this == obj) {
            AppMethodBeat.o(70583);
            return true;
        } else if (obj == null) {
            AppMethodBeat.o(70583);
            return false;
        } else if (getClass() != obj.getClass()) {
            AppMethodBeat.o(70583);
            return false;
        } else {
            boolean equals = this.string.equals(((g) obj).string);
            AppMethodBeat.o(70583);
            return equals;
        }
    }
}
