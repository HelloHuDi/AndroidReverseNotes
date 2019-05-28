package com.eclipsesource.p096a;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.eclipsesource.a.g */
final class C8570g extends C0803h {
    private final String string;

    C8570g(String str) {
        AppMethodBeat.m2504i(70580);
        if (str == null) {
            NullPointerException nullPointerException = new NullPointerException("string is null");
            AppMethodBeat.m2505o(70580);
            throw nullPointerException;
        }
        this.string = str;
        AppMethodBeat.m2505o(70580);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo2353a(C0804i c0804i) {
        AppMethodBeat.m2504i(70581);
        c0804i.writeString(this.string);
        AppMethodBeat.m2505o(70581);
    }

    public final boolean isString() {
        return true;
    }

    /* renamed from: pq */
    public final String mo2367pq() {
        return this.string;
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(70582);
        int hashCode = this.string.hashCode();
        AppMethodBeat.m2505o(70582);
        return hashCode;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(70583);
        if (this == obj) {
            AppMethodBeat.m2505o(70583);
            return true;
        } else if (obj == null) {
            AppMethodBeat.m2505o(70583);
            return false;
        } else if (getClass() != obj.getClass()) {
            AppMethodBeat.m2505o(70583);
            return false;
        } else {
            boolean equals = this.string.equals(((C8570g) obj).string);
            AppMethodBeat.m2505o(70583);
            return equals;
        }
    }
}
