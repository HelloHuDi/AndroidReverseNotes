package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bqk */
public final class bqk extends C1331a {
    public int wSJ;
    public int wSK;
    public int wSL;
    public int wSM;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(108898);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.wSJ);
            c6093a.mo13480iz(2, this.wSK);
            c6093a.mo13480iz(3, this.wSL);
            c6093a.mo13480iz(4, this.wSM);
            AppMethodBeat.m2505o(108898);
            return 0;
        } else if (i == 1) {
            bs = (((C6091a.m9572bs(1, this.wSJ) + 0) + C6091a.m9572bs(2, this.wSK)) + C6091a.m9572bs(3, this.wSL)) + C6091a.m9572bs(4, this.wSM);
            AppMethodBeat.m2505o(108898);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(108898);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bqk bqk = (bqk) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bqk.wSJ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(108898);
                    return 0;
                case 2:
                    bqk.wSK = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(108898);
                    return 0;
                case 3:
                    bqk.wSL = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(108898);
                    return 0;
                case 4:
                    bqk.wSM = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(108898);
                    return 0;
                default:
                    AppMethodBeat.m2505o(108898);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(108898);
            return -1;
        }
    }
}
