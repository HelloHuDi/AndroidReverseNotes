package com.tencent.p177mm.plugin.p369d.p370a.p371a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

/* renamed from: com.tencent.mm.plugin.d.a.a.c */
public final class C11457c {
    public String cbq = "";
    String jEJ = null;
    public C11459e jEK = null;
    public double jEL = 0.0d;

    public final int hashCode() {
        AppMethodBeat.m2504i(18326);
        if (this.jEK == null) {
            AppMethodBeat.m2505o(18326);
            return 0;
        }
        int hashCode = Arrays.hashCode(this.jEK.jEO.jFp);
        AppMethodBeat.m2505o(18326);
        return hashCode;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(18327);
        if (this.jEK == null || obj == null) {
            AppMethodBeat.m2505o(18327);
            return false;
        } else if (this == obj) {
            AppMethodBeat.m2505o(18327);
            return true;
        } else {
            boolean equals = Arrays.equals(((C11457c) obj).jEK.jEO.jFp, this.jEK.jEO.jFp);
            AppMethodBeat.m2505o(18327);
            return equals;
        }
    }
}
