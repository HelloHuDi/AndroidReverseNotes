package com.bumptech.glide.p095h;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.bumptech.glide.h.h */
public final class C25464h {
    private Class<?> aId;
    private Class<?> aIe;
    private Class<?> aIf;

    public C25464h(Class<?> cls, Class<?> cls2) {
        AppMethodBeat.m2504i(92592);
        mo42511d(cls, cls2, null);
        AppMethodBeat.m2505o(92592);
    }

    public C25464h(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        AppMethodBeat.m2504i(92593);
        mo42511d(cls, cls2, cls3);
        AppMethodBeat.m2505o(92593);
    }

    /* renamed from: d */
    public final void mo42511d(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        this.aId = cls;
        this.aIe = cls2;
        this.aIf = cls3;
    }

    public final String toString() {
        AppMethodBeat.m2504i(92594);
        String str = "MultiClassKey{first=" + this.aId + ", second=" + this.aIe + '}';
        AppMethodBeat.m2505o(92594);
        return str;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(92595);
        if (this == obj) {
            AppMethodBeat.m2505o(92595);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.m2505o(92595);
            return false;
        } else {
            C25464h c25464h = (C25464h) obj;
            if (!this.aId.equals(c25464h.aId)) {
                AppMethodBeat.m2505o(92595);
                return false;
            } else if (!this.aIe.equals(c25464h.aIe)) {
                AppMethodBeat.m2505o(92595);
                return false;
            } else if (C45002j.m82421h(this.aIf, c25464h.aIf)) {
                AppMethodBeat.m2505o(92595);
                return true;
            } else {
                AppMethodBeat.m2505o(92595);
                return false;
            }
        }
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(92596);
        int hashCode = (this.aIf != null ? this.aIf.hashCode() : 0) + (((this.aId.hashCode() * 31) + this.aIe.hashCode()) * 31);
        AppMethodBeat.m2505o(92596);
        return hashCode;
    }
}
