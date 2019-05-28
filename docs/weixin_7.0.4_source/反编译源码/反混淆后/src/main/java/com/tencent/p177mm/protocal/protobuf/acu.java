package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.acu */
public final class acu extends C1331a {
    public boolean wkx;
    public boolean wky;
    public boolean wkz;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(2541);
        int fv;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13471aO(1, this.wkx);
            c6093a.mo13471aO(2, this.wky);
            c6093a.mo13471aO(3, this.wkz);
            AppMethodBeat.m2505o(2541);
            return 0;
        } else if (i == 1) {
            fv = (((C6091a.m9576fv(1) + 1) + 0) + (C6091a.m9576fv(2) + 1)) + (C6091a.m9576fv(3) + 1);
            AppMethodBeat.m2505o(2541);
            return fv;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (fv = C1331a.getNextFieldNumber(c6086a); fv > 0; fv = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, fv)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(2541);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            acu acu = (acu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    acu.wkx = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(2541);
                    return 0;
                case 2:
                    acu.wky = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(2541);
                    return 0;
                case 3:
                    acu.wkz = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(2541);
                    return 0;
                default:
                    AppMethodBeat.m2505o(2541);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(2541);
            return -1;
        }
    }
}
