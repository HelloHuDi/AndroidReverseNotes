package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.aaq */
public final class aaq extends C1331a {
    public int jBT;
    public String vRw;
    public int vRx;
    public String vXB;
    public String vXC;
    public String vXD;
    public int vXE;
    public String wfP;
    public String wfQ;
    public int wfR;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(51389);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vXB != null) {
                c6093a.mo13475e(1, this.vXB);
            }
            if (this.vXC != null) {
                c6093a.mo13475e(2, this.vXC);
            }
            if (this.vXD != null) {
                c6093a.mo13475e(3, this.vXD);
            }
            c6093a.mo13480iz(4, this.vXE);
            if (this.wfP != null) {
                c6093a.mo13475e(5, this.wfP);
            }
            if (this.vRw != null) {
                c6093a.mo13475e(6, this.vRw);
            }
            c6093a.mo13480iz(7, this.vRx);
            if (this.wfQ != null) {
                c6093a.mo13475e(8, this.wfQ);
            }
            c6093a.mo13480iz(9, this.jBT);
            c6093a.mo13480iz(10, this.wfR);
            AppMethodBeat.m2505o(51389);
            return 0;
        } else if (i == 1) {
            if (this.vXB != null) {
                f = C6091a.m9575f(1, this.vXB) + 0;
            } else {
                f = 0;
            }
            if (this.vXC != null) {
                f += C6091a.m9575f(2, this.vXC);
            }
            if (this.vXD != null) {
                f += C6091a.m9575f(3, this.vXD);
            }
            f += C6091a.m9572bs(4, this.vXE);
            if (this.wfP != null) {
                f += C6091a.m9575f(5, this.wfP);
            }
            if (this.vRw != null) {
                f += C6091a.m9575f(6, this.vRw);
            }
            f += C6091a.m9572bs(7, this.vRx);
            if (this.wfQ != null) {
                f += C6091a.m9575f(8, this.wfQ);
            }
            int bs = (f + C6091a.m9572bs(9, this.jBT)) + C6091a.m9572bs(10, this.wfR);
            AppMethodBeat.m2505o(51389);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(51389);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            aaq aaq = (aaq) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aaq.vXB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(51389);
                    return 0;
                case 2:
                    aaq.vXC = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(51389);
                    return 0;
                case 3:
                    aaq.vXD = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(51389);
                    return 0;
                case 4:
                    aaq.vXE = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(51389);
                    return 0;
                case 5:
                    aaq.wfP = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(51389);
                    return 0;
                case 6:
                    aaq.vRw = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(51389);
                    return 0;
                case 7:
                    aaq.vRx = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(51389);
                    return 0;
                case 8:
                    aaq.wfQ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(51389);
                    return 0;
                case 9:
                    aaq.jBT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(51389);
                    return 0;
                case 10:
                    aaq.wfR = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(51389);
                    return 0;
                default:
                    AppMethodBeat.m2505o(51389);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(51389);
            return -1;
        }
    }
}
