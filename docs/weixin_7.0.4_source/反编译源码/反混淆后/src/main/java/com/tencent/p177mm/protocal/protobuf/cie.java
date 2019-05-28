package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cie */
public final class cie extends C1331a {
    public String Name;
    public double vNH;
    public double vNI;
    public String wKW;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(113792);
        int fv;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13476f(1, this.vNI);
            c6093a.mo13476f(2, this.vNH);
            if (this.Name != null) {
                c6093a.mo13475e(3, this.Name);
            }
            if (this.wKW != null) {
                c6093a.mo13475e(4, this.wKW);
            }
            AppMethodBeat.m2505o(113792);
            return 0;
        } else if (i == 1) {
            fv = ((C6091a.m9576fv(1) + 8) + 0) + (C6091a.m9576fv(2) + 8);
            if (this.Name != null) {
                fv += C6091a.m9575f(3, this.Name);
            }
            if (this.wKW != null) {
                fv += C6091a.m9575f(4, this.wKW);
            }
            AppMethodBeat.m2505o(113792);
            return fv;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (fv = C1331a.getNextFieldNumber(c6086a); fv > 0; fv = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, fv)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(113792);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cie cie = (cie) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cie.vNI = Double.longBitsToDouble(c6086a2.BTU.eib());
                    AppMethodBeat.m2505o(113792);
                    return 0;
                case 2:
                    cie.vNH = Double.longBitsToDouble(c6086a2.BTU.eib());
                    AppMethodBeat.m2505o(113792);
                    return 0;
                case 3:
                    cie.Name = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(113792);
                    return 0;
                case 4:
                    cie.wKW = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(113792);
                    return 0;
                default:
                    AppMethodBeat.m2505o(113792);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(113792);
            return -1;
        }
    }
}
