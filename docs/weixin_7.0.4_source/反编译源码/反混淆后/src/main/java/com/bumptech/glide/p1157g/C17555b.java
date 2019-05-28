package com.bumptech.glide.p1157g;

import com.bumptech.glide.p086c.C0779h;
import com.bumptech.glide.p095h.C8561i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.MessageDigest;

/* renamed from: com.bumptech.glide.g.b */
public final class C17555b implements C0779h {
    private final Object object;

    public C17555b(Object obj) {
        AppMethodBeat.m2504i(92537);
        this.object = C8561i.m15217d(obj, "Argument must not be null");
        AppMethodBeat.m2505o(92537);
    }

    public final String toString() {
        AppMethodBeat.m2504i(92538);
        String str = "ObjectKey{object=" + this.object + '}';
        AppMethodBeat.m2505o(92538);
        return str;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(92539);
        if (obj instanceof C17555b) {
            boolean equals = this.object.equals(((C17555b) obj).object);
            AppMethodBeat.m2505o(92539);
            return equals;
        }
        AppMethodBeat.m2505o(92539);
        return false;
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(92540);
        int hashCode = this.object.hashCode();
        AppMethodBeat.m2505o(92540);
        return hashCode;
    }

    /* renamed from: a */
    public final void mo2242a(MessageDigest messageDigest) {
        AppMethodBeat.m2504i(92541);
        messageDigest.update(this.object.toString().getBytes(azc));
        AppMethodBeat.m2505o(92541);
    }
}
