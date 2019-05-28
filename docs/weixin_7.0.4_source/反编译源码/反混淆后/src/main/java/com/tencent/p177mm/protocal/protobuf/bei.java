package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bei */
public final class bei extends C1331a {
    public int jCt;
    public int wBd;
    public int wIq;
    public int wIr;
    public int wIs;
    public int wIt;
    public int wIu;
    public int wIv;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(72861);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.wBd);
            c6093a.mo13480iz(2, this.wIq);
            c6093a.mo13480iz(3, this.wIr);
            c6093a.mo13480iz(4, this.wIs);
            c6093a.mo13480iz(5, this.wIt);
            c6093a.mo13480iz(6, this.wIu);
            c6093a.mo13480iz(7, this.wIv);
            c6093a.mo13480iz(8, this.jCt);
            AppMethodBeat.m2505o(72861);
            return 0;
        } else if (i == 1) {
            bs = (((((((C6091a.m9572bs(1, this.wBd) + 0) + C6091a.m9572bs(2, this.wIq)) + C6091a.m9572bs(3, this.wIr)) + C6091a.m9572bs(4, this.wIs)) + C6091a.m9572bs(5, this.wIt)) + C6091a.m9572bs(6, this.wIu)) + C6091a.m9572bs(7, this.wIv)) + C6091a.m9572bs(8, this.jCt);
            AppMethodBeat.m2505o(72861);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(72861);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bei bei = (bei) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bei.wBd = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(72861);
                    return 0;
                case 2:
                    bei.wIq = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(72861);
                    return 0;
                case 3:
                    bei.wIr = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(72861);
                    return 0;
                case 4:
                    bei.wIs = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(72861);
                    return 0;
                case 5:
                    bei.wIt = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(72861);
                    return 0;
                case 6:
                    bei.wIu = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(72861);
                    return 0;
                case 7:
                    bei.wIv = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(72861);
                    return 0;
                case 8:
                    bei.jCt = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(72861);
                    return 0;
                default:
                    AppMethodBeat.m2505o(72861);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(72861);
            return -1;
        }
    }
}
