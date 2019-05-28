package com.bumptech.glide.p086c.p088b;

import com.bumptech.glide.p086c.C0779h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.MessageDigest;

/* renamed from: com.bumptech.glide.c.b.c */
final class C25421c implements C0779h {
    private final C0779h aAb;
    private final C0779h azW;

    C25421c(C0779h c0779h, C0779h c0779h2) {
        this.azW = c0779h;
        this.aAb = c0779h2;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(91758);
        if (obj instanceof C25421c) {
            C25421c c25421c = (C25421c) obj;
            if (this.azW.equals(c25421c.azW) && this.aAb.equals(c25421c.aAb)) {
                AppMethodBeat.m2505o(91758);
                return true;
            }
            AppMethodBeat.m2505o(91758);
            return false;
        }
        AppMethodBeat.m2505o(91758);
        return false;
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(91759);
        int hashCode = (this.azW.hashCode() * 31) + this.aAb.hashCode();
        AppMethodBeat.m2505o(91759);
        return hashCode;
    }

    public final String toString() {
        AppMethodBeat.m2504i(91760);
        String str = "DataCacheKey{sourceKey=" + this.azW + ", signature=" + this.aAb + '}';
        AppMethodBeat.m2505o(91760);
        return str;
    }

    /* renamed from: a */
    public final void mo2242a(MessageDigest messageDigest) {
        AppMethodBeat.m2504i(91761);
        this.azW.mo2242a(messageDigest);
        this.aAb.mo2242a(messageDigest);
        AppMethodBeat.m2505o(91761);
    }
}
