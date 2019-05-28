package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bl */
public final class C44104bl extends C1331a {
    public long endTime;
    public int qDF;
    public int qDG;
    public long startTime;
    public float vDD;
    public float vDE;
    public float vDF;
    public long vDG;
    public long vDH;
    public long vDI;
    public long vDJ;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(94496);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.qDF);
            c6093a.mo13480iz(2, this.qDG);
            c6093a.mo13481r(3, this.vDD);
            c6093a.mo13481r(4, this.vDE);
            c6093a.mo13481r(5, this.vDF);
            c6093a.mo13472ai(6, this.startTime);
            c6093a.mo13472ai(7, this.endTime);
            c6093a.mo13472ai(8, this.vDG);
            c6093a.mo13472ai(9, this.vDH);
            c6093a.mo13472ai(10, this.vDI);
            c6093a.mo13472ai(11, this.vDJ);
            AppMethodBeat.m2505o(94496);
            return 0;
        } else if (i == 1) {
            bs = ((((((((((C6091a.m9572bs(1, this.qDF) + 0) + C6091a.m9572bs(2, this.qDG)) + (C6091a.m9576fv(3) + 4)) + (C6091a.m9576fv(4) + 4)) + (C6091a.m9576fv(5) + 4)) + C6091a.m9578o(6, this.startTime)) + C6091a.m9578o(7, this.endTime)) + C6091a.m9578o(8, this.vDG)) + C6091a.m9578o(9, this.vDH)) + C6091a.m9578o(10, this.vDI)) + C6091a.m9578o(11, this.vDJ);
            AppMethodBeat.m2505o(94496);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(94496);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C44104bl c44104bl = (C44104bl) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c44104bl.qDF = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94496);
                    return 0;
                case 2:
                    c44104bl.qDG = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94496);
                    return 0;
                case 3:
                    c44104bl.vDD = Float.intBitsToFloat(c6086a2.BTU.eia());
                    AppMethodBeat.m2505o(94496);
                    return 0;
                case 4:
                    c44104bl.vDE = Float.intBitsToFloat(c6086a2.BTU.eia());
                    AppMethodBeat.m2505o(94496);
                    return 0;
                case 5:
                    c44104bl.vDF = Float.intBitsToFloat(c6086a2.BTU.eia());
                    AppMethodBeat.m2505o(94496);
                    return 0;
                case 6:
                    c44104bl.startTime = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(94496);
                    return 0;
                case 7:
                    c44104bl.endTime = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(94496);
                    return 0;
                case 8:
                    c44104bl.vDG = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(94496);
                    return 0;
                case 9:
                    c44104bl.vDH = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(94496);
                    return 0;
                case 10:
                    c44104bl.vDI = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(94496);
                    return 0;
                case 11:
                    c44104bl.vDJ = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(94496);
                    return 0;
                default:
                    AppMethodBeat.m2505o(94496);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(94496);
            return -1;
        }
    }
}
