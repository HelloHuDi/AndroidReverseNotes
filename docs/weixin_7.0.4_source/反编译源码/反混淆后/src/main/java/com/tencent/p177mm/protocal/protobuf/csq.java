package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.csq */
public final class csq extends C1331a {
    public int Scene;
    public int gtF;
    public String pdu;
    public String wDM;
    public String wUo;
    public String xpS;
    public String xpT;
    public String xpU;
    public String xpV;
    public String xpW;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(93804);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.xpS != null) {
                c6093a.mo13475e(1, this.xpS);
            }
            if (this.xpT != null) {
                c6093a.mo13475e(2, this.xpT);
            }
            if (this.wDM != null) {
                c6093a.mo13475e(3, this.wDM);
            }
            if (this.wUo != null) {
                c6093a.mo13475e(4, this.wUo);
            }
            c6093a.mo13480iz(5, this.gtF);
            if (this.pdu != null) {
                c6093a.mo13475e(6, this.pdu);
            }
            if (this.xpU != null) {
                c6093a.mo13475e(7, this.xpU);
            }
            if (this.xpV != null) {
                c6093a.mo13475e(8, this.xpV);
            }
            c6093a.mo13480iz(9, this.Scene);
            if (this.xpW != null) {
                c6093a.mo13475e(19, this.xpW);
            }
            AppMethodBeat.m2505o(93804);
            return 0;
        } else if (i == 1) {
            if (this.xpS != null) {
                f = C6091a.m9575f(1, this.xpS) + 0;
            } else {
                f = 0;
            }
            if (this.xpT != null) {
                f += C6091a.m9575f(2, this.xpT);
            }
            if (this.wDM != null) {
                f += C6091a.m9575f(3, this.wDM);
            }
            if (this.wUo != null) {
                f += C6091a.m9575f(4, this.wUo);
            }
            f += C6091a.m9572bs(5, this.gtF);
            if (this.pdu != null) {
                f += C6091a.m9575f(6, this.pdu);
            }
            if (this.xpU != null) {
                f += C6091a.m9575f(7, this.xpU);
            }
            if (this.xpV != null) {
                f += C6091a.m9575f(8, this.xpV);
            }
            f += C6091a.m9572bs(9, this.Scene);
            if (this.xpW != null) {
                f += C6091a.m9575f(19, this.xpW);
            }
            AppMethodBeat.m2505o(93804);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(93804);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            csq csq = (csq) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    csq.xpS = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(93804);
                    return 0;
                case 2:
                    csq.xpT = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(93804);
                    return 0;
                case 3:
                    csq.wDM = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(93804);
                    return 0;
                case 4:
                    csq.wUo = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(93804);
                    return 0;
                case 5:
                    csq.gtF = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(93804);
                    return 0;
                case 6:
                    csq.pdu = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(93804);
                    return 0;
                case 7:
                    csq.xpU = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(93804);
                    return 0;
                case 8:
                    csq.xpV = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(93804);
                    return 0;
                case 9:
                    csq.Scene = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(93804);
                    return 0;
                case 19:
                    csq.xpW = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(93804);
                    return 0;
                default:
                    AppMethodBeat.m2505o(93804);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(93804);
            return -1;
        }
    }
}
