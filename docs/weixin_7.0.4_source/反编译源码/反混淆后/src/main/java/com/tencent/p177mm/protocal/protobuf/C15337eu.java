package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.eu */
public final class C15337eu extends C1331a {
    public long jVD;
    public int jVE;
    public String url;
    public String vGE;
    public int vGF;
    public int vGG;
    public long vGH;
    public int vGI;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(11691);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vGE != null) {
                c6093a.mo13475e(1, this.vGE);
            }
            c6093a.mo13472ai(2, this.jVD);
            c6093a.mo13480iz(3, this.jVE);
            c6093a.mo13480iz(4, this.vGF);
            c6093a.mo13480iz(5, this.vGG);
            c6093a.mo13472ai(6, this.vGH);
            c6093a.mo13480iz(7, this.vGI);
            if (this.url != null) {
                c6093a.mo13475e(8, this.url);
            }
            AppMethodBeat.m2505o(11691);
            return 0;
        } else if (i == 1) {
            if (this.vGE != null) {
                f = C6091a.m9575f(1, this.vGE) + 0;
            } else {
                f = 0;
            }
            f = (((((f + C6091a.m9578o(2, this.jVD)) + C6091a.m9572bs(3, this.jVE)) + C6091a.m9572bs(4, this.vGF)) + C6091a.m9572bs(5, this.vGG)) + C6091a.m9578o(6, this.vGH)) + C6091a.m9572bs(7, this.vGI);
            if (this.url != null) {
                f += C6091a.m9575f(8, this.url);
            }
            AppMethodBeat.m2505o(11691);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(11691);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C15337eu c15337eu = (C15337eu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c15337eu.vGE = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(11691);
                    return 0;
                case 2:
                    c15337eu.jVD = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(11691);
                    return 0;
                case 3:
                    c15337eu.jVE = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(11691);
                    return 0;
                case 4:
                    c15337eu.vGF = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(11691);
                    return 0;
                case 5:
                    c15337eu.vGG = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(11691);
                    return 0;
                case 6:
                    c15337eu.vGH = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(11691);
                    return 0;
                case 7:
                    c15337eu.vGI = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(11691);
                    return 0;
                case 8:
                    c15337eu.url = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(11691);
                    return 0;
                default:
                    AppMethodBeat.m2505o(11691);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(11691);
            return -1;
        }
    }
}
