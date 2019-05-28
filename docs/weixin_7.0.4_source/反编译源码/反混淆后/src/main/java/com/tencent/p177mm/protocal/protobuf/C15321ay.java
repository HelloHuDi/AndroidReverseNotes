package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.ay */
public final class C15321ay extends C1331a {
    public boolean vCK;
    public boolean vCL;
    public int vCM;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(96189);
        int fv;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13471aO(1, this.vCK);
            c6093a.mo13471aO(2, this.vCL);
            c6093a.mo13480iz(3, this.vCM);
            AppMethodBeat.m2505o(96189);
            return 0;
        } else if (i == 1) {
            fv = (((C6091a.m9576fv(1) + 1) + 0) + (C6091a.m9576fv(2) + 1)) + C6091a.m9572bs(3, this.vCM);
            AppMethodBeat.m2505o(96189);
            return fv;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (fv = C1331a.getNextFieldNumber(c6086a); fv > 0; fv = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, fv)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(96189);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C15321ay c15321ay = (C15321ay) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c15321ay.vCK = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(96189);
                    return 0;
                case 2:
                    c15321ay.vCL = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(96189);
                    return 0;
                case 3:
                    c15321ay.vCM = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(96189);
                    return 0;
                default:
                    AppMethodBeat.m2505o(96189);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(96189);
            return -1;
        }
    }
}
