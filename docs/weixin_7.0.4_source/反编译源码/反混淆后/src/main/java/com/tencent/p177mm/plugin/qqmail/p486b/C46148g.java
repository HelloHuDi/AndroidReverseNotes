package com.tencent.p177mm.plugin.qqmail.p486b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.qqmail.b.g */
public final class C46148g extends C1331a {
    public int FileSize;
    public int jBT;
    public int ptD;
    public String ptE;
    public long ptF;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(67926);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.ptD);
            if (this.ptE != null) {
                c6093a.mo13475e(2, this.ptE);
            }
            c6093a.mo13480iz(3, this.jBT);
            c6093a.mo13480iz(4, this.FileSize);
            c6093a.mo13472ai(5, this.ptF);
            AppMethodBeat.m2505o(67926);
            return 0;
        } else if (i == 1) {
            bs = C6091a.m9572bs(1, this.ptD) + 0;
            if (this.ptE != null) {
                bs += C6091a.m9575f(2, this.ptE);
            }
            bs = ((bs + C6091a.m9572bs(3, this.jBT)) + C6091a.m9572bs(4, this.FileSize)) + C6091a.m9578o(5, this.ptF);
            AppMethodBeat.m2505o(67926);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(67926);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C46148g c46148g = (C46148g) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c46148g.ptD = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(67926);
                    return 0;
                case 2:
                    c46148g.ptE = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(67926);
                    return 0;
                case 3:
                    c46148g.jBT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(67926);
                    return 0;
                case 4:
                    c46148g.FileSize = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(67926);
                    return 0;
                case 5:
                    c46148g.ptF = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(67926);
                    return 0;
                default:
                    AppMethodBeat.m2505o(67926);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(67926);
            return -1;
        }
    }
}
