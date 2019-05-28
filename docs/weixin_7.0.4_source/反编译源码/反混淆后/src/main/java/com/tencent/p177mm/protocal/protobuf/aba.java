package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.aba */
public final class aba extends C1331a {
    public int jBT;
    public int vEp;
    public int vEq;
    public int vEr;
    public int vEs;
    public String vEv;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(51401);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.vEp);
            c6093a.mo13480iz(2, this.jBT);
            if (this.vEv != null) {
                c6093a.mo13475e(3, this.vEv);
            }
            c6093a.mo13480iz(4, this.vEq);
            c6093a.mo13480iz(5, this.vEr);
            c6093a.mo13480iz(6, this.vEs);
            AppMethodBeat.m2505o(51401);
            return 0;
        } else if (i == 1) {
            bs = (C6091a.m9572bs(1, this.vEp) + 0) + C6091a.m9572bs(2, this.jBT);
            if (this.vEv != null) {
                bs += C6091a.m9575f(3, this.vEv);
            }
            bs = ((bs + C6091a.m9572bs(4, this.vEq)) + C6091a.m9572bs(5, this.vEr)) + C6091a.m9572bs(6, this.vEs);
            AppMethodBeat.m2505o(51401);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(51401);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            aba aba = (aba) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aba.vEp = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(51401);
                    return 0;
                case 2:
                    aba.jBT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(51401);
                    return 0;
                case 3:
                    aba.vEv = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(51401);
                    return 0;
                case 4:
                    aba.vEq = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(51401);
                    return 0;
                case 5:
                    aba.vEr = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(51401);
                    return 0;
                case 6:
                    aba.vEs = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(51401);
                    return 0;
                default:
                    AppMethodBeat.m2505o(51401);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(51401);
            return -1;
        }
    }
}
