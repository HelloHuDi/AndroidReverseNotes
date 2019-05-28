package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.mv */
public final class C23417mv extends C1331a {
    public int vQP;
    public int vQQ;
    public int vQR;
    public int vQS;
    public int vQT;
    public int vQU;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(58897);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.vQP);
            c6093a.mo13480iz(2, this.vQQ);
            c6093a.mo13480iz(3, this.vQR);
            c6093a.mo13480iz(4, this.vQS);
            c6093a.mo13480iz(5, this.vQT);
            c6093a.mo13480iz(6, this.vQU);
            AppMethodBeat.m2505o(58897);
            return 0;
        } else if (i == 1) {
            bs = (((((C6091a.m9572bs(1, this.vQP) + 0) + C6091a.m9572bs(2, this.vQQ)) + C6091a.m9572bs(3, this.vQR)) + C6091a.m9572bs(4, this.vQS)) + C6091a.m9572bs(5, this.vQT)) + C6091a.m9572bs(6, this.vQU);
            AppMethodBeat.m2505o(58897);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(58897);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C23417mv c23417mv = (C23417mv) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c23417mv.vQP = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(58897);
                    return 0;
                case 2:
                    c23417mv.vQQ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(58897);
                    return 0;
                case 3:
                    c23417mv.vQR = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(58897);
                    return 0;
                case 4:
                    c23417mv.vQS = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(58897);
                    return 0;
                case 5:
                    c23417mv.vQT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(58897);
                    return 0;
                case 6:
                    c23417mv.vQU = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(58897);
                    return 0;
                default:
                    AppMethodBeat.m2505o(58897);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(58897);
            return -1;
        }
    }
}
