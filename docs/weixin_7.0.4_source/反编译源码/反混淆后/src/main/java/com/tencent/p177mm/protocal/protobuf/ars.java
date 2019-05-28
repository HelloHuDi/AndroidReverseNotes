package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.ars */
public final class ars extends C1331a {
    public int wvG;
    public int wvH;
    public boolean wvI;
    public boolean wvJ;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(134433);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.wvG);
            c6093a.mo13480iz(2, this.wvH);
            c6093a.mo13471aO(3, this.wvI);
            c6093a.mo13471aO(4, this.wvJ);
            AppMethodBeat.m2505o(134433);
            return 0;
        } else if (i == 1) {
            bs = (((C6091a.m9572bs(1, this.wvG) + 0) + C6091a.m9572bs(2, this.wvH)) + (C6091a.m9576fv(3) + 1)) + (C6091a.m9576fv(4) + 1);
            AppMethodBeat.m2505o(134433);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(134433);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            ars ars = (ars) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ars.wvG = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(134433);
                    return 0;
                case 2:
                    ars.wvH = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(134433);
                    return 0;
                case 3:
                    ars.wvI = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(134433);
                    return 0;
                case 4:
                    ars.wvJ = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(134433);
                    return 0;
                default:
                    AppMethodBeat.m2505o(134433);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(134433);
            return -1;
        }
    }
}
