package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.abt */
public final class abt extends C1331a {
    public int fileCount;
    public int wiK;
    public int wiL;
    public int wiM;
    public int wiN;
    public int wiO;
    public int wiP;
    public int wiQ;
    public int wiR;
    public int wiS;
    public int wiT;
    public int wiU;
    public int wiV;
    public int wiW;
    public int wiX;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(51423);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.wiK);
            c6093a.mo13480iz(2, this.wiL);
            c6093a.mo13480iz(3, this.wiM);
            c6093a.mo13480iz(4, this.wiN);
            c6093a.mo13480iz(5, this.wiO);
            c6093a.mo13480iz(6, this.wiP);
            c6093a.mo13480iz(7, this.wiQ);
            c6093a.mo13480iz(8, this.fileCount);
            c6093a.mo13480iz(9, this.wiR);
            c6093a.mo13480iz(10, this.wiS);
            c6093a.mo13480iz(11, this.wiT);
            c6093a.mo13480iz(12, this.wiU);
            c6093a.mo13480iz(13, this.wiV);
            c6093a.mo13480iz(14, this.wiW);
            c6093a.mo13480iz(15, this.wiX);
            AppMethodBeat.m2505o(51423);
            return 0;
        } else if (i == 1) {
            bs = ((((((((((((((C6091a.m9572bs(1, this.wiK) + 0) + C6091a.m9572bs(2, this.wiL)) + C6091a.m9572bs(3, this.wiM)) + C6091a.m9572bs(4, this.wiN)) + C6091a.m9572bs(5, this.wiO)) + C6091a.m9572bs(6, this.wiP)) + C6091a.m9572bs(7, this.wiQ)) + C6091a.m9572bs(8, this.fileCount)) + C6091a.m9572bs(9, this.wiR)) + C6091a.m9572bs(10, this.wiS)) + C6091a.m9572bs(11, this.wiT)) + C6091a.m9572bs(12, this.wiU)) + C6091a.m9572bs(13, this.wiV)) + C6091a.m9572bs(14, this.wiW)) + C6091a.m9572bs(15, this.wiX);
            AppMethodBeat.m2505o(51423);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(51423);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            abt abt = (abt) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    abt.wiK = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(51423);
                    return 0;
                case 2:
                    abt.wiL = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(51423);
                    return 0;
                case 3:
                    abt.wiM = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(51423);
                    return 0;
                case 4:
                    abt.wiN = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(51423);
                    return 0;
                case 5:
                    abt.wiO = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(51423);
                    return 0;
                case 6:
                    abt.wiP = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(51423);
                    return 0;
                case 7:
                    abt.wiQ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(51423);
                    return 0;
                case 8:
                    abt.fileCount = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(51423);
                    return 0;
                case 9:
                    abt.wiR = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(51423);
                    return 0;
                case 10:
                    abt.wiS = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(51423);
                    return 0;
                case 11:
                    abt.wiT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(51423);
                    return 0;
                case 12:
                    abt.wiU = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(51423);
                    return 0;
                case 13:
                    abt.wiV = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(51423);
                    return 0;
                case 14:
                    abt.wiW = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(51423);
                    return 0;
                case 15:
                    abt.wiX = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(51423);
                    return 0;
                default:
                    AppMethodBeat.m2505o(51423);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(51423);
            return -1;
        }
    }
}
