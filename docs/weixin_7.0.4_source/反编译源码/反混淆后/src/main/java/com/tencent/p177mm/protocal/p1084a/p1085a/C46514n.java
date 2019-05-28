package com.tencent.p177mm.protocal.p1084a.p1085a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.a.a.n */
public final class C46514n extends C1331a {
    public int type;
    public int vyQ;
    public int vzA;
    public int vzB;
    public int vzC;
    public int vzD;
    public int vzE;
    public int vzz;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(72834);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.vyQ);
            c6093a.mo13480iz(2, this.vzz);
            c6093a.mo13480iz(3, this.vzA);
            c6093a.mo13480iz(4, this.vzB);
            c6093a.mo13480iz(5, this.vzC);
            c6093a.mo13480iz(6, this.vzD);
            c6093a.mo13480iz(7, this.vzE);
            c6093a.mo13480iz(8, this.type);
            AppMethodBeat.m2505o(72834);
            return 0;
        } else if (i == 1) {
            bs = (((((((C6091a.m9572bs(1, this.vyQ) + 0) + C6091a.m9572bs(2, this.vzz)) + C6091a.m9572bs(3, this.vzA)) + C6091a.m9572bs(4, this.vzB)) + C6091a.m9572bs(5, this.vzC)) + C6091a.m9572bs(6, this.vzD)) + C6091a.m9572bs(7, this.vzE)) + C6091a.m9572bs(8, this.type);
            AppMethodBeat.m2505o(72834);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(72834);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C46514n c46514n = (C46514n) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c46514n.vyQ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(72834);
                    return 0;
                case 2:
                    c46514n.vzz = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(72834);
                    return 0;
                case 3:
                    c46514n.vzA = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(72834);
                    return 0;
                case 4:
                    c46514n.vzB = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(72834);
                    return 0;
                case 5:
                    c46514n.vzC = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(72834);
                    return 0;
                case 6:
                    c46514n.vzD = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(72834);
                    return 0;
                case 7:
                    c46514n.vzE = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(72834);
                    return 0;
                case 8:
                    c46514n.type = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(72834);
                    return 0;
                default:
                    AppMethodBeat.m2505o(72834);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(72834);
            return -1;
        }
    }
}
