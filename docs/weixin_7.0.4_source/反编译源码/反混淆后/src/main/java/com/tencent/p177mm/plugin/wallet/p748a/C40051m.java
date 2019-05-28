package com.tencent.p177mm.plugin.wallet.p748a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.wallet.a.m */
public final class C40051m extends C1331a {
    public int jkL;
    public String pbo;
    public String tnr;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56655);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.tnr != null) {
                c6093a.mo13475e(1, this.tnr);
            }
            c6093a.mo13480iz(2, this.jkL);
            if (this.pbo != null) {
                c6093a.mo13475e(3, this.pbo);
            }
            AppMethodBeat.m2505o(56655);
            return 0;
        } else if (i == 1) {
            if (this.tnr != null) {
                f = C6091a.m9575f(1, this.tnr) + 0;
            } else {
                f = 0;
            }
            f += C6091a.m9572bs(2, this.jkL);
            if (this.pbo != null) {
                f += C6091a.m9575f(3, this.pbo);
            }
            AppMethodBeat.m2505o(56655);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(56655);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C40051m c40051m = (C40051m) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c40051m.tnr = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56655);
                    return 0;
                case 2:
                    c40051m.jkL = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56655);
                    return 0;
                case 3:
                    c40051m.pbo = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56655);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56655);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56655);
            return -1;
        }
    }
}
