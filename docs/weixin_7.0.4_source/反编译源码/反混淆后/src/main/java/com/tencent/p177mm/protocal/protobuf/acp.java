package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.acp */
public final class acp extends C1331a {
    public int fQi = 0;
    public int wkl = 7;
    public long wkm = 0;
    public int wkn = 0;
    public String wko = "";
    public String wkp = "";
    public boolean wkq = false;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(73650);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.wkl);
            c6093a.mo13472ai(2, this.wkm);
            c6093a.mo13480iz(3, this.wkn);
            if (this.wko != null) {
                c6093a.mo13475e(4, this.wko);
            }
            if (this.wkp != null) {
                c6093a.mo13475e(5, this.wkp);
            }
            c6093a.mo13480iz(6, this.fQi);
            c6093a.mo13471aO(7, this.wkq);
            AppMethodBeat.m2505o(73650);
            return 0;
        } else if (i == 1) {
            bs = ((C6091a.m9572bs(1, this.wkl) + 0) + C6091a.m9578o(2, this.wkm)) + C6091a.m9572bs(3, this.wkn);
            if (this.wko != null) {
                bs += C6091a.m9575f(4, this.wko);
            }
            if (this.wkp != null) {
                bs += C6091a.m9575f(5, this.wkp);
            }
            bs = (bs + C6091a.m9572bs(6, this.fQi)) + (C6091a.m9576fv(7) + 1);
            AppMethodBeat.m2505o(73650);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(73650);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            acp acp = (acp) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    acp.wkl = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(73650);
                    return 0;
                case 2:
                    acp.wkm = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(73650);
                    return 0;
                case 3:
                    acp.wkn = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(73650);
                    return 0;
                case 4:
                    acp.wko = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(73650);
                    return 0;
                case 5:
                    acp.wkp = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(73650);
                    return 0;
                case 6:
                    acp.fQi = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(73650);
                    return 0;
                case 7:
                    acp.wkq = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(73650);
                    return 0;
                default:
                    AppMethodBeat.m2505o(73650);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(73650);
            return -1;
        }
    }
}
