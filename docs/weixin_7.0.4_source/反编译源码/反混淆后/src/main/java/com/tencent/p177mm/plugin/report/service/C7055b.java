package com.tencent.p177mm.plugin.report.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.report.service.b */
public final class C7055b extends C1331a {
    /* renamed from: ID */
    public int f1968ID;
    public int pXC;
    public int pXD;
    public boolean pXE;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(72702);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.f1968ID);
            c6093a.mo13480iz(2, this.pXC);
            c6093a.mo13480iz(3, this.pXD);
            c6093a.mo13471aO(4, this.pXE);
            AppMethodBeat.m2505o(72702);
            return 0;
        } else if (i == 1) {
            bs = (((C6091a.m9572bs(1, this.f1968ID) + 0) + C6091a.m9572bs(2, this.pXC)) + C6091a.m9572bs(3, this.pXD)) + (C6091a.m9576fv(4) + 1);
            AppMethodBeat.m2505o(72702);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(72702);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C7055b c7055b = (C7055b) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c7055b.f1968ID = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(72702);
                    return 0;
                case 2:
                    c7055b.pXC = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(72702);
                    return 0;
                case 3:
                    c7055b.pXD = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(72702);
                    return 0;
                case 4:
                    c7055b.pXE = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(72702);
                    return 0;
                default:
                    AppMethodBeat.m2505o(72702);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(72702);
            return -1;
        }
    }
}
