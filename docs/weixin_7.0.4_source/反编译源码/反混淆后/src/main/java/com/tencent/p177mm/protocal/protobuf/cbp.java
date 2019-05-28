package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cbp */
public final class cbp extends C1331a {
    public int rnf;
    public int rng;
    public String vFJ;
    public String vFK;
    public String vFL;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(94594);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vFJ != null) {
                c6093a.mo13475e(1, this.vFJ);
            }
            if (this.vFK != null) {
                c6093a.mo13475e(2, this.vFK);
            }
            if (this.vFL != null) {
                c6093a.mo13475e(3, this.vFL);
            }
            c6093a.mo13480iz(4, this.rnf);
            c6093a.mo13480iz(5, this.rng);
            AppMethodBeat.m2505o(94594);
            return 0;
        } else if (i == 1) {
            if (this.vFJ != null) {
                f = C6091a.m9575f(1, this.vFJ) + 0;
            } else {
                f = 0;
            }
            if (this.vFK != null) {
                f += C6091a.m9575f(2, this.vFK);
            }
            if (this.vFL != null) {
                f += C6091a.m9575f(3, this.vFL);
            }
            int bs = (f + C6091a.m9572bs(4, this.rnf)) + C6091a.m9572bs(5, this.rng);
            AppMethodBeat.m2505o(94594);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(94594);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cbp cbp = (cbp) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cbp.vFJ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94594);
                    return 0;
                case 2:
                    cbp.vFK = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94594);
                    return 0;
                case 3:
                    cbp.vFL = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94594);
                    return 0;
                case 4:
                    cbp.rnf = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94594);
                    return 0;
                case 5:
                    cbp.rng = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94594);
                    return 0;
                default:
                    AppMethodBeat.m2505o(94594);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(94594);
            return -1;
        }
    }
}
