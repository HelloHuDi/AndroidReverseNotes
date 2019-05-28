package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.ey */
public final class C46539ey extends C1331a {
    public long vGQ;
    public int vGR;
    public int vGS;
    public int vGT;
    public int vGU;
    public int vGV;
    public int vGW;
    public String vGX;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(96194);
        int o;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13472ai(1, this.vGQ);
            c6093a.mo13480iz(2, this.vGR);
            c6093a.mo13480iz(3, this.vGS);
            c6093a.mo13480iz(4, this.vGT);
            c6093a.mo13480iz(5, this.vGU);
            c6093a.mo13480iz(6, this.vGV);
            c6093a.mo13480iz(7, this.vGW);
            if (this.vGX != null) {
                c6093a.mo13475e(8, this.vGX);
            }
            AppMethodBeat.m2505o(96194);
            return 0;
        } else if (i == 1) {
            o = ((((((C6091a.m9578o(1, this.vGQ) + 0) + C6091a.m9572bs(2, this.vGR)) + C6091a.m9572bs(3, this.vGS)) + C6091a.m9572bs(4, this.vGT)) + C6091a.m9572bs(5, this.vGU)) + C6091a.m9572bs(6, this.vGV)) + C6091a.m9572bs(7, this.vGW);
            if (this.vGX != null) {
                o += C6091a.m9575f(8, this.vGX);
            }
            AppMethodBeat.m2505o(96194);
            return o;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (o = C1331a.getNextFieldNumber(c6086a); o > 0; o = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, o)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(96194);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C46539ey c46539ey = (C46539ey) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c46539ey.vGQ = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(96194);
                    return 0;
                case 2:
                    c46539ey.vGR = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(96194);
                    return 0;
                case 3:
                    c46539ey.vGS = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(96194);
                    return 0;
                case 4:
                    c46539ey.vGT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(96194);
                    return 0;
                case 5:
                    c46539ey.vGU = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(96194);
                    return 0;
                case 6:
                    c46539ey.vGV = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(96194);
                    return 0;
                case 7:
                    c46539ey.vGW = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(96194);
                    return 0;
                case 8:
                    c46539ey.vGX = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(96194);
                    return 0;
                default:
                    AppMethodBeat.m2505o(96194);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(96194);
            return -1;
        }
    }
}
