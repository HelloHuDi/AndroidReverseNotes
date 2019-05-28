package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bxk */
public final class bxk extends C1331a {
    public int wXr;
    public int wXs;
    public int wXt;
    public int wXu;
    public int wXv;
    public int wXw;
    public int wXx;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(11805);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.wXr);
            c6093a.mo13480iz(2, this.wXs);
            c6093a.mo13480iz(3, this.wXt);
            c6093a.mo13480iz(4, this.wXu);
            c6093a.mo13480iz(5, this.wXv);
            c6093a.mo13480iz(6, this.wXw);
            c6093a.mo13480iz(7, this.wXx);
            AppMethodBeat.m2505o(11805);
            return 0;
        } else if (i == 1) {
            bs = ((((((C6091a.m9572bs(1, this.wXr) + 0) + C6091a.m9572bs(2, this.wXs)) + C6091a.m9572bs(3, this.wXt)) + C6091a.m9572bs(4, this.wXu)) + C6091a.m9572bs(5, this.wXv)) + C6091a.m9572bs(6, this.wXw)) + C6091a.m9572bs(7, this.wXx);
            AppMethodBeat.m2505o(11805);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(11805);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bxk bxk = (bxk) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bxk.wXr = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(11805);
                    return 0;
                case 2:
                    bxk.wXs = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(11805);
                    return 0;
                case 3:
                    bxk.wXt = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(11805);
                    return 0;
                case 4:
                    bxk.wXu = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(11805);
                    return 0;
                case 5:
                    bxk.wXv = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(11805);
                    return 0;
                case 6:
                    bxk.wXw = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(11805);
                    return 0;
                case 7:
                    bxk.wXx = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(11805);
                    return 0;
                default:
                    AppMethodBeat.m2505o(11805);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(11805);
            return -1;
        }
    }
}
