package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cvo */
public final class cvo extends C1331a {
    public String xrA;
    public boolean xrB;
    public int xrC;
    public int xrD;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(63695);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.xrA != null) {
                c6093a.mo13475e(1, this.xrA);
            }
            c6093a.mo13471aO(2, this.xrB);
            c6093a.mo13480iz(3, this.xrC);
            c6093a.mo13480iz(4, this.xrD);
            AppMethodBeat.m2505o(63695);
            return 0;
        } else if (i == 1) {
            if (this.xrA != null) {
                f = C6091a.m9575f(1, this.xrA) + 0;
            } else {
                f = 0;
            }
            int fv = ((f + (C6091a.m9576fv(2) + 1)) + C6091a.m9572bs(3, this.xrC)) + C6091a.m9572bs(4, this.xrD);
            AppMethodBeat.m2505o(63695);
            return fv;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(63695);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cvo cvo = (cvo) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cvo.xrA = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(63695);
                    return 0;
                case 2:
                    cvo.xrB = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(63695);
                    return 0;
                case 3:
                    cvo.xrC = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(63695);
                    return 0;
                case 4:
                    cvo.xrD = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(63695);
                    return 0;
                default:
                    AppMethodBeat.m2505o(63695);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(63695);
            return -1;
        }
    }
}
