package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.baa */
public final class baa extends C1331a {
    public String csB;
    public boolean wDO;
    public boolean wDP;
    public int wDQ;
    public int wDR;
    public String wDS;
    public boolean wDT;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(51000);
        int fv;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13471aO(1, this.wDO);
            c6093a.mo13471aO(2, this.wDP);
            c6093a.mo13480iz(3, this.wDQ);
            c6093a.mo13480iz(4, this.wDR);
            if (this.wDS != null) {
                c6093a.mo13475e(5, this.wDS);
            }
            c6093a.mo13471aO(6, this.wDT);
            if (this.csB != null) {
                c6093a.mo13475e(7, this.csB);
            }
            AppMethodBeat.m2505o(51000);
            return 0;
        } else if (i == 1) {
            fv = ((((C6091a.m9576fv(1) + 1) + 0) + (C6091a.m9576fv(2) + 1)) + C6091a.m9572bs(3, this.wDQ)) + C6091a.m9572bs(4, this.wDR);
            if (this.wDS != null) {
                fv += C6091a.m9575f(5, this.wDS);
            }
            fv += C6091a.m9576fv(6) + 1;
            if (this.csB != null) {
                fv += C6091a.m9575f(7, this.csB);
            }
            AppMethodBeat.m2505o(51000);
            return fv;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (fv = C1331a.getNextFieldNumber(c6086a); fv > 0; fv = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, fv)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(51000);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            baa baa = (baa) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    baa.wDO = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(51000);
                    return 0;
                case 2:
                    baa.wDP = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(51000);
                    return 0;
                case 3:
                    baa.wDQ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(51000);
                    return 0;
                case 4:
                    baa.wDR = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(51000);
                    return 0;
                case 5:
                    baa.wDS = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(51000);
                    return 0;
                case 6:
                    baa.wDT = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(51000);
                    return 0;
                case 7:
                    baa.csB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(51000);
                    return 0;
                default:
                    AppMethodBeat.m2505o(51000);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(51000);
            return -1;
        }
    }
}
