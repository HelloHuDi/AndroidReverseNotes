package com.bumptech.glide.h;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h {
    private Class<?> aId;
    private Class<?> aIe;
    private Class<?> aIf;

    public h(Class<?> cls, Class<?> cls2) {
        AppMethodBeat.i(92592);
        d(cls, cls2, null);
        AppMethodBeat.o(92592);
    }

    public h(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        AppMethodBeat.i(92593);
        d(cls, cls2, cls3);
        AppMethodBeat.o(92593);
    }

    public final void d(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        this.aId = cls;
        this.aIe = cls2;
        this.aIf = cls3;
    }

    public final String toString() {
        AppMethodBeat.i(92594);
        String str = "MultiClassKey{first=" + this.aId + ", second=" + this.aIe + '}';
        AppMethodBeat.o(92594);
        return str;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(92595);
        if (this == obj) {
            AppMethodBeat.o(92595);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.o(92595);
            return false;
        } else {
            h hVar = (h) obj;
            if (!this.aId.equals(hVar.aId)) {
                AppMethodBeat.o(92595);
                return false;
            } else if (!this.aIe.equals(hVar.aIe)) {
                AppMethodBeat.o(92595);
                return false;
            } else if (j.h(this.aIf, hVar.aIf)) {
                AppMethodBeat.o(92595);
                return true;
            } else {
                AppMethodBeat.o(92595);
                return false;
            }
        }
    }

    public final int hashCode() {
        AppMethodBeat.i(92596);
        int hashCode = (this.aIf != null ? this.aIf.hashCode() : 0) + (((this.aId.hashCode() * 31) + this.aIe.hashCode()) * 31);
        AppMethodBeat.o(92596);
        return hashCode;
    }
}
