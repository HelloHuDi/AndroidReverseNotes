package com.tencent.p177mm.plugin.qqmail.p486b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.qqmail.b.h */
public final class C39537h extends C1331a {
    public int ptD;
    public long ptF;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(67927);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.ptD);
            c6093a.mo13472ai(2, this.ptF);
            AppMethodBeat.m2505o(67927);
            return 0;
        } else if (i == 1) {
            bs = (C6091a.m9572bs(1, this.ptD) + 0) + C6091a.m9578o(2, this.ptF);
            AppMethodBeat.m2505o(67927);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(67927);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C39537h c39537h = (C39537h) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c39537h.ptD = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(67927);
                    return 0;
                case 2:
                    c39537h.ptF = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(67927);
                    return 0;
                default:
                    AppMethodBeat.m2505o(67927);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(67927);
            return -1;
        }
    }
}
