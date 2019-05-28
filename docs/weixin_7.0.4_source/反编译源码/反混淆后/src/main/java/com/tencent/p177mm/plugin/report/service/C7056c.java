package com.tencent.p177mm.plugin.report.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.report.service.c */
public final class C7056c extends C1331a {
    public int jCt;
    public boolean pXE;
    public int pXL;
    public String pXM;
    public boolean pXN;
    public boolean pXO;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(72718);
        C6092b c6092b;
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.pXM == null) {
                c6092b = new C6092b("Not all required fields were included: Value");
                AppMethodBeat.m2505o(72718);
                throw c6092b;
            }
            c6093a.mo13480iz(1, this.pXL);
            if (this.pXM != null) {
                c6093a.mo13475e(2, this.pXM);
            }
            c6093a.mo13471aO(3, this.pXN);
            c6093a.mo13471aO(4, this.pXE);
            c6093a.mo13480iz(5, this.jCt);
            c6093a.mo13471aO(6, this.pXO);
            AppMethodBeat.m2505o(72718);
            return 0;
        } else if (i == 1) {
            bs = C6091a.m9572bs(1, this.pXL) + 0;
            if (this.pXM != null) {
                bs += C6091a.m9575f(2, this.pXM);
            }
            bs = (((bs + (C6091a.m9576fv(3) + 1)) + (C6091a.m9576fv(4) + 1)) + C6091a.m9572bs(5, this.jCt)) + (C6091a.m9576fv(6) + 1);
            AppMethodBeat.m2505o(72718);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            if (this.pXM == null) {
                c6092b = new C6092b("Not all required fields were included: Value");
                AppMethodBeat.m2505o(72718);
                throw c6092b;
            }
            AppMethodBeat.m2505o(72718);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C7056c c7056c = (C7056c) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c7056c.pXL = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(72718);
                    return 0;
                case 2:
                    c7056c.pXM = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(72718);
                    return 0;
                case 3:
                    c7056c.pXN = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(72718);
                    return 0;
                case 4:
                    c7056c.pXE = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(72718);
                    return 0;
                case 5:
                    c7056c.jCt = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(72718);
                    return 0;
                case 6:
                    c7056c.pXO = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(72718);
                    return 0;
                default:
                    AppMethodBeat.m2505o(72718);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(72718);
            return -1;
        }
    }
}
