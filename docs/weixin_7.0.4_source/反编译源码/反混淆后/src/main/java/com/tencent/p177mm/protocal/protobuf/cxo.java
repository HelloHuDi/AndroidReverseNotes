package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cxo */
public final class cxo extends C1331a {
    public String session_id;
    public String xrS;
    public int xsP;
    public int xsQ;
    public String xsR;
    public int xsS;
    public boolean xsT = false;
    public boolean xsU = false;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(124389);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.xsP);
            c6093a.mo13480iz(2, this.xsQ);
            if (this.session_id != null) {
                c6093a.mo13475e(3, this.session_id);
            }
            if (this.xsR != null) {
                c6093a.mo13475e(4, this.xsR);
            }
            if (this.xrS != null) {
                c6093a.mo13475e(5, this.xrS);
            }
            c6093a.mo13480iz(6, this.xsS);
            c6093a.mo13471aO(7, this.xsT);
            c6093a.mo13471aO(8, this.xsU);
            AppMethodBeat.m2505o(124389);
            return 0;
        } else if (i == 1) {
            bs = (C6091a.m9572bs(1, this.xsP) + 0) + C6091a.m9572bs(2, this.xsQ);
            if (this.session_id != null) {
                bs += C6091a.m9575f(3, this.session_id);
            }
            if (this.xsR != null) {
                bs += C6091a.m9575f(4, this.xsR);
            }
            if (this.xrS != null) {
                bs += C6091a.m9575f(5, this.xrS);
            }
            bs = ((bs + C6091a.m9572bs(6, this.xsS)) + (C6091a.m9576fv(7) + 1)) + (C6091a.m9576fv(8) + 1);
            AppMethodBeat.m2505o(124389);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(124389);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cxo cxo = (cxo) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cxo.xsP = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(124389);
                    return 0;
                case 2:
                    cxo.xsQ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(124389);
                    return 0;
                case 3:
                    cxo.session_id = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124389);
                    return 0;
                case 4:
                    cxo.xsR = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124389);
                    return 0;
                case 5:
                    cxo.xrS = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(124389);
                    return 0;
                case 6:
                    cxo.xsS = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(124389);
                    return 0;
                case 7:
                    cxo.xsT = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(124389);
                    return 0;
                case 8:
                    cxo.xsU = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(124389);
                    return 0;
                default:
                    AppMethodBeat.m2505o(124389);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(124389);
            return -1;
        }
    }
}
