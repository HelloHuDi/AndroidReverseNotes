package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p205bt.C1332b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cov */
public final class cov extends C1331a {
    public long wen;
    public long xeF;
    public int xmD;
    public int xmE;
    public int xmF;
    public int xmG;
    public C1332b xmH;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(135450);
        int o;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13472ai(1, this.xeF);
            c6093a.mo13472ai(2, this.wen);
            c6093a.mo13480iz(3, this.xmD);
            c6093a.mo13480iz(4, this.xmE);
            c6093a.mo13480iz(5, this.xmF);
            c6093a.mo13480iz(6, this.xmG);
            if (this.xmH != null) {
                c6093a.mo13473c(7, this.xmH);
            }
            AppMethodBeat.m2505o(135450);
            return 0;
        } else if (i == 1) {
            o = (((((C6091a.m9578o(1, this.xeF) + 0) + C6091a.m9578o(2, this.wen)) + C6091a.m9572bs(3, this.xmD)) + C6091a.m9572bs(4, this.xmE)) + C6091a.m9572bs(5, this.xmF)) + C6091a.m9572bs(6, this.xmG);
            if (this.xmH != null) {
                o += C6091a.m9571b(7, this.xmH);
            }
            AppMethodBeat.m2505o(135450);
            return o;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (o = C1331a.getNextFieldNumber(c6086a); o > 0; o = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, o)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(135450);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cov cov = (cov) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cov.xeF = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(135450);
                    return 0;
                case 2:
                    cov.wen = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(135450);
                    return 0;
                case 3:
                    cov.xmD = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(135450);
                    return 0;
                case 4:
                    cov.xmE = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(135450);
                    return 0;
                case 5:
                    cov.xmF = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(135450);
                    return 0;
                case 6:
                    cov.xmG = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(135450);
                    return 0;
                case 7:
                    cov.xmH = c6086a2.BTU.emu();
                    AppMethodBeat.m2505o(135450);
                    return 0;
                default:
                    AppMethodBeat.m2505o(135450);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(135450);
            return -1;
        }
    }
}
