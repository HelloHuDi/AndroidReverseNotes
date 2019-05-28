package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.ts */
public final class C46587ts extends C1331a {
    public int kzN;
    public int kzO;
    public int kzP;
    public int kzQ;
    public int kzR;
    public int kzS;
    public int kzT;
    public int kzU;
    public int kzV;
    public int waQ;
    public int waR;
    public int waS;
    public int waT;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(135598);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.kzN);
            c6093a.mo13480iz(2, this.waQ);
            c6093a.mo13480iz(3, this.kzO);
            c6093a.mo13480iz(4, this.kzP);
            c6093a.mo13480iz(5, this.kzQ);
            c6093a.mo13480iz(6, this.waR);
            c6093a.mo13480iz(7, this.kzR);
            c6093a.mo13480iz(8, this.kzS);
            c6093a.mo13480iz(9, this.waS);
            c6093a.mo13480iz(10, this.waT);
            c6093a.mo13480iz(11, this.kzT);
            c6093a.mo13480iz(12, this.kzU);
            c6093a.mo13480iz(13, this.kzV);
            AppMethodBeat.m2505o(135598);
            return 0;
        } else if (i == 1) {
            bs = ((((((((((((C6091a.m9572bs(1, this.kzN) + 0) + C6091a.m9572bs(2, this.waQ)) + C6091a.m9572bs(3, this.kzO)) + C6091a.m9572bs(4, this.kzP)) + C6091a.m9572bs(5, this.kzQ)) + C6091a.m9572bs(6, this.waR)) + C6091a.m9572bs(7, this.kzR)) + C6091a.m9572bs(8, this.kzS)) + C6091a.m9572bs(9, this.waS)) + C6091a.m9572bs(10, this.waT)) + C6091a.m9572bs(11, this.kzT)) + C6091a.m9572bs(12, this.kzU)) + C6091a.m9572bs(13, this.kzV);
            AppMethodBeat.m2505o(135598);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(135598);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C46587ts c46587ts = (C46587ts) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c46587ts.kzN = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(135598);
                    return 0;
                case 2:
                    c46587ts.waQ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(135598);
                    return 0;
                case 3:
                    c46587ts.kzO = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(135598);
                    return 0;
                case 4:
                    c46587ts.kzP = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(135598);
                    return 0;
                case 5:
                    c46587ts.kzQ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(135598);
                    return 0;
                case 6:
                    c46587ts.waR = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(135598);
                    return 0;
                case 7:
                    c46587ts.kzR = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(135598);
                    return 0;
                case 8:
                    c46587ts.kzS = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(135598);
                    return 0;
                case 9:
                    c46587ts.waS = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(135598);
                    return 0;
                case 10:
                    c46587ts.waT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(135598);
                    return 0;
                case 11:
                    c46587ts.kzT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(135598);
                    return 0;
                case 12:
                    c46587ts.kzU = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(135598);
                    return 0;
                case 13:
                    c46587ts.kzV = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(135598);
                    return 0;
                default:
                    AppMethodBeat.m2505o(135598);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(135598);
            return -1;
        }
    }
}
