package com.tencent.p177mm.plugin.downloader.p723c.p941a.p942a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.downloader.c.a.a.g */
public final class C27702g extends C1331a {
    public String kKw;
    public String kKx;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(35515);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.kKw != null) {
                c6093a.mo13475e(1, this.kKw);
            }
            if (this.kKx != null) {
                c6093a.mo13475e(2, this.kKx);
            }
            AppMethodBeat.m2505o(35515);
            return 0;
        } else if (i == 1) {
            if (this.kKw != null) {
                f = C6091a.m9575f(1, this.kKw) + 0;
            } else {
                f = 0;
            }
            if (this.kKx != null) {
                f += C6091a.m9575f(2, this.kKx);
            }
            AppMethodBeat.m2505o(35515);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(35515);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C27702g c27702g = (C27702g) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c27702g.kKw = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(35515);
                    return 0;
                case 2:
                    c27702g.kKx = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(35515);
                    return 0;
                default:
                    AppMethodBeat.m2505o(35515);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(35515);
            return -1;
        }
    }
}
