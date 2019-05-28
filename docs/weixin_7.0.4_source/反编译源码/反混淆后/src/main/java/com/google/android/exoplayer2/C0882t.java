package com.google.android.exoplayer2;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.google.android.exoplayer2.t */
public final class C0882t {
    public static final C0882t aOE = new C0882t(0);
    public final int aOF;

    static {
        AppMethodBeat.m2504i(95392);
        AppMethodBeat.m2505o(95392);
    }

    public C0882t(int i) {
        this.aOF = i;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(95391);
        if (this == obj) {
            AppMethodBeat.m2505o(95391);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.m2505o(95391);
            return false;
        } else {
            if (this.aOF == ((C0882t) obj).aOF) {
                AppMethodBeat.m2505o(95391);
                return true;
            }
            AppMethodBeat.m2505o(95391);
            return false;
        }
    }

    public final int hashCode() {
        return this.aOF;
    }
}
