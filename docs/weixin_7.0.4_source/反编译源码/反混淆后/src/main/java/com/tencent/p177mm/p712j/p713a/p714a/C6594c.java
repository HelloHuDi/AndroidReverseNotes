package com.tencent.p177mm.p712j.p713a.p714a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.j.a.a.c */
public final class C6594c extends C1331a {
    public long eoC;
    public long eoD;
    public long eoE;
    public long eoF;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(59617);
        int o;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13472ai(1, this.eoC);
            c6093a.mo13472ai(2, this.eoD);
            c6093a.mo13472ai(3, this.eoE);
            c6093a.mo13472ai(4, this.eoF);
            AppMethodBeat.m2505o(59617);
            return 0;
        } else if (i == 1) {
            o = (((C6091a.m9578o(1, this.eoC) + 0) + C6091a.m9578o(2, this.eoD)) + C6091a.m9578o(3, this.eoE)) + C6091a.m9578o(4, this.eoF);
            AppMethodBeat.m2505o(59617);
            return o;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (o = C1331a.getNextFieldNumber(c6086a); o > 0; o = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, o)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(59617);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C6594c c6594c = (C6594c) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c6594c.eoC = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(59617);
                    return 0;
                case 2:
                    c6594c.eoD = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(59617);
                    return 0;
                case 3:
                    c6594c.eoE = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(59617);
                    return 0;
                case 4:
                    c6594c.eoF = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(59617);
                    return 0;
                default:
                    AppMethodBeat.m2505o(59617);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(59617);
            return -1;
        }
    }
}
