package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.brr */
public final class brr extends C1331a {
    public String jCg;
    public int qBF;
    public String vOA;
    public String vOB;
    public String vOC;
    public String vOz;
    public int wTR;
    public int wTS;
    public String wTT;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(96283);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.jCg != null) {
                c6093a.mo13475e(1, this.jCg);
            }
            c6093a.mo13480iz(2, this.wTR);
            if (this.vOz != null) {
                c6093a.mo13475e(3, this.vOz);
            }
            if (this.vOA != null) {
                c6093a.mo13475e(4, this.vOA);
            }
            c6093a.mo13480iz(5, this.qBF);
            c6093a.mo13480iz(6, this.wTS);
            if (this.vOB != null) {
                c6093a.mo13475e(7, this.vOB);
            }
            if (this.vOC != null) {
                c6093a.mo13475e(8, this.vOC);
            }
            if (this.wTT != null) {
                c6093a.mo13475e(9, this.wTT);
            }
            AppMethodBeat.m2505o(96283);
            return 0;
        } else if (i == 1) {
            if (this.jCg != null) {
                f = C6091a.m9575f(1, this.jCg) + 0;
            } else {
                f = 0;
            }
            f += C6091a.m9572bs(2, this.wTR);
            if (this.vOz != null) {
                f += C6091a.m9575f(3, this.vOz);
            }
            if (this.vOA != null) {
                f += C6091a.m9575f(4, this.vOA);
            }
            f = (f + C6091a.m9572bs(5, this.qBF)) + C6091a.m9572bs(6, this.wTS);
            if (this.vOB != null) {
                f += C6091a.m9575f(7, this.vOB);
            }
            if (this.vOC != null) {
                f += C6091a.m9575f(8, this.vOC);
            }
            if (this.wTT != null) {
                f += C6091a.m9575f(9, this.wTT);
            }
            AppMethodBeat.m2505o(96283);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(96283);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            brr brr = (brr) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    brr.jCg = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(96283);
                    return 0;
                case 2:
                    brr.wTR = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(96283);
                    return 0;
                case 3:
                    brr.vOz = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(96283);
                    return 0;
                case 4:
                    brr.vOA = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(96283);
                    return 0;
                case 5:
                    brr.qBF = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(96283);
                    return 0;
                case 6:
                    brr.wTS = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(96283);
                    return 0;
                case 7:
                    brr.vOB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(96283);
                    return 0;
                case 8:
                    brr.vOC = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(96283);
                    return 0;
                case 9:
                    brr.wTT = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(96283);
                    return 0;
                default:
                    AppMethodBeat.m2505o(96283);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(96283);
            return -1;
        }
    }
}
