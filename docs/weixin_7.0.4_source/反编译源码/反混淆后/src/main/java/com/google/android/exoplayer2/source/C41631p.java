package com.google.android.exoplayer2.source;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

/* renamed from: com.google.android.exoplayer2.source.p */
public final class C41631p {
    public static final C41631p bhZ = new C41631p(new C41630o[0]);
    private int aBR;
    public final C41630o[] bia;
    public final int length;

    static {
        AppMethodBeat.m2504i(95558);
        AppMethodBeat.m2505o(95558);
    }

    public C41631p(C41630o... c41630oArr) {
        AppMethodBeat.m2504i(95555);
        this.bia = c41630oArr;
        this.length = c41630oArr.length;
        AppMethodBeat.m2505o(95555);
    }

    /* renamed from: a */
    public final int mo66766a(C41630o c41630o) {
        for (int i = 0; i < this.length; i++) {
            if (this.bia[i] == c41630o) {
                return i;
            }
        }
        return -1;
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(95556);
        if (this.aBR == 0) {
            this.aBR = Arrays.hashCode(this.bia);
        }
        int i = this.aBR;
        AppMethodBeat.m2505o(95556);
        return i;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(95557);
        if (this == obj) {
            AppMethodBeat.m2505o(95557);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.m2505o(95557);
            return false;
        } else {
            C41631p c41631p = (C41631p) obj;
            if (this.length == c41631p.length && Arrays.equals(this.bia, c41631p.bia)) {
                AppMethodBeat.m2505o(95557);
                return true;
            }
            AppMethodBeat.m2505o(95557);
            return false;
        }
    }
}
