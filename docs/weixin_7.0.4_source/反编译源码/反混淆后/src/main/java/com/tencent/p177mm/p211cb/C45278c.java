package com.tencent.p177mm.p211cb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.cb.c */
public final class C45278c extends C1331a {
    public int coc;
    public int jik;
    public int jil;
    public int jim;
    public int size;
    public int xFV = -1;
    public int xFW;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(62664);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.jik);
            c6093a.mo13480iz(2, this.jil);
            c6093a.mo13480iz(3, this.jim);
            c6093a.mo13480iz(41, this.xFV);
            c6093a.mo13480iz(5, this.xFW);
            c6093a.mo13480iz(6, this.coc);
            c6093a.mo13480iz(7, this.size);
            AppMethodBeat.m2505o(62664);
            return 0;
        } else if (i == 1) {
            bs = ((((((C6091a.m9572bs(1, this.jik) + 0) + C6091a.m9572bs(2, this.jil)) + C6091a.m9572bs(3, this.jim)) + C6091a.m9572bs(41, this.xFV)) + C6091a.m9572bs(5, this.xFW)) + C6091a.m9572bs(6, this.coc)) + C6091a.m9572bs(7, this.size);
            AppMethodBeat.m2505o(62664);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(62664);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C45278c c45278c = (C45278c) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c45278c.jik = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(62664);
                    return 0;
                case 2:
                    c45278c.jil = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(62664);
                    return 0;
                case 3:
                    c45278c.jim = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(62664);
                    return 0;
                case 5:
                    c45278c.xFW = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(62664);
                    return 0;
                case 6:
                    c45278c.coc = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(62664);
                    return 0;
                case 7:
                    c45278c.size = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(62664);
                    return 0;
                case 41:
                    c45278c.xFV = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(62664);
                    return 0;
                default:
                    AppMethodBeat.m2505o(62664);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(62664);
            return -1;
        }
    }
}
