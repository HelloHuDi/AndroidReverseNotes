package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.ef */
public final class C40515ef extends C1331a {
    public String Url;
    public String ncM;
    public int ptD;
    public int vFU = 600;
    public String vFV;
    public int vFW;
    public boolean vFX;
    public int vFY;
    public int vFZ;
    public int vGa;
    public int vGb;
    public int vGc = -1;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(14689);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.Url != null) {
                c6093a.mo13475e(1, this.Url);
            }
            if (this.ncM != null) {
                c6093a.mo13475e(2, this.ncM);
            }
            c6093a.mo13480iz(3, this.vFU);
            if (this.vFV != null) {
                c6093a.mo13475e(4, this.vFV);
            }
            c6093a.mo13480iz(5, this.vFW);
            c6093a.mo13471aO(6, this.vFX);
            c6093a.mo13480iz(7, this.vFY);
            c6093a.mo13480iz(8, this.vFZ);
            c6093a.mo13480iz(9, this.ptD);
            c6093a.mo13480iz(10, this.vGa);
            c6093a.mo13480iz(11, this.vGb);
            c6093a.mo13480iz(12, this.vGc);
            AppMethodBeat.m2505o(14689);
            return 0;
        } else if (i == 1) {
            if (this.Url != null) {
                f = C6091a.m9575f(1, this.Url) + 0;
            } else {
                f = 0;
            }
            if (this.ncM != null) {
                f += C6091a.m9575f(2, this.ncM);
            }
            f += C6091a.m9572bs(3, this.vFU);
            if (this.vFV != null) {
                f += C6091a.m9575f(4, this.vFV);
            }
            int bs = (((((((f + C6091a.m9572bs(5, this.vFW)) + (C6091a.m9576fv(6) + 1)) + C6091a.m9572bs(7, this.vFY)) + C6091a.m9572bs(8, this.vFZ)) + C6091a.m9572bs(9, this.ptD)) + C6091a.m9572bs(10, this.vGa)) + C6091a.m9572bs(11, this.vGb)) + C6091a.m9572bs(12, this.vGc);
            AppMethodBeat.m2505o(14689);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(14689);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C40515ef c40515ef = (C40515ef) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c40515ef.Url = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(14689);
                    return 0;
                case 2:
                    c40515ef.ncM = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(14689);
                    return 0;
                case 3:
                    c40515ef.vFU = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14689);
                    return 0;
                case 4:
                    c40515ef.vFV = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(14689);
                    return 0;
                case 5:
                    c40515ef.vFW = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14689);
                    return 0;
                case 6:
                    c40515ef.vFX = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(14689);
                    return 0;
                case 7:
                    c40515ef.vFY = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14689);
                    return 0;
                case 8:
                    c40515ef.vFZ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14689);
                    return 0;
                case 9:
                    c40515ef.ptD = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14689);
                    return 0;
                case 10:
                    c40515ef.vGa = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14689);
                    return 0;
                case 11:
                    c40515ef.vGb = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14689);
                    return 0;
                case 12:
                    c40515ef.vGc = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(14689);
                    return 0;
                default:
                    AppMethodBeat.m2505o(14689);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(14689);
            return -1;
        }
    }
}
