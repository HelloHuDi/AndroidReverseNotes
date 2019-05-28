package com.tencent.p177mm.protocal.p1084a.p1085a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.a.a.l */
public final class C23367l extends C1331a {
    public int action;
    public int vzp;
    public int vzq;
    public int vzr;
    public int vzs;
    public int vzt;
    public int vzu;
    public int vzv;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(72831);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.vzp);
            c6093a.mo13480iz(2, this.action);
            c6093a.mo13480iz(3, this.vzq);
            c6093a.mo13480iz(4, this.vzr);
            c6093a.mo13480iz(5, this.vzs);
            c6093a.mo13480iz(6, this.vzt);
            c6093a.mo13480iz(7, this.vzu);
            c6093a.mo13480iz(8, this.vzv);
            AppMethodBeat.m2505o(72831);
            return 0;
        } else if (i == 1) {
            bs = (((((((C6091a.m9572bs(1, this.vzp) + 0) + C6091a.m9572bs(2, this.action)) + C6091a.m9572bs(3, this.vzq)) + C6091a.m9572bs(4, this.vzr)) + C6091a.m9572bs(5, this.vzs)) + C6091a.m9572bs(6, this.vzt)) + C6091a.m9572bs(7, this.vzu)) + C6091a.m9572bs(8, this.vzv);
            AppMethodBeat.m2505o(72831);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(72831);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C23367l c23367l = (C23367l) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c23367l.vzp = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(72831);
                    return 0;
                case 2:
                    c23367l.action = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(72831);
                    return 0;
                case 3:
                    c23367l.vzq = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(72831);
                    return 0;
                case 4:
                    c23367l.vzr = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(72831);
                    return 0;
                case 5:
                    c23367l.vzs = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(72831);
                    return 0;
                case 6:
                    c23367l.vzt = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(72831);
                    return 0;
                case 7:
                    c23367l.vzu = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(72831);
                    return 0;
                case 8:
                    c23367l.vzv = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(72831);
                    return 0;
                default:
                    AppMethodBeat.m2505o(72831);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(72831);
            return -1;
        }
    }
}
