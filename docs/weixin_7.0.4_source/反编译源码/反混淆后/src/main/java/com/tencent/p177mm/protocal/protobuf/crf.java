package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.crf */
public final class crf extends C1331a {
    public boolean xoO;
    public String xoP;
    public String xoQ;
    public int xoR;
    public int xoS;
    public int xoT;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(102416);
        int fv;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13471aO(1, this.xoO);
            if (this.xoP != null) {
                c6093a.mo13475e(2, this.xoP);
            }
            if (this.xoQ != null) {
                c6093a.mo13475e(3, this.xoQ);
            }
            c6093a.mo13480iz(4, this.xoR);
            c6093a.mo13480iz(5, this.xoS);
            c6093a.mo13480iz(6, this.xoT);
            AppMethodBeat.m2505o(102416);
            return 0;
        } else if (i == 1) {
            fv = (C6091a.m9576fv(1) + 1) + 0;
            if (this.xoP != null) {
                fv += C6091a.m9575f(2, this.xoP);
            }
            if (this.xoQ != null) {
                fv += C6091a.m9575f(3, this.xoQ);
            }
            fv = ((fv + C6091a.m9572bs(4, this.xoR)) + C6091a.m9572bs(5, this.xoS)) + C6091a.m9572bs(6, this.xoT);
            AppMethodBeat.m2505o(102416);
            return fv;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (fv = C1331a.getNextFieldNumber(c6086a); fv > 0; fv = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, fv)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(102416);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            crf crf = (crf) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    crf.xoO = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(102416);
                    return 0;
                case 2:
                    crf.xoP = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(102416);
                    return 0;
                case 3:
                    crf.xoQ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(102416);
                    return 0;
                case 4:
                    crf.xoR = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(102416);
                    return 0;
                case 5:
                    crf.xoS = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(102416);
                    return 0;
                case 6:
                    crf.xoT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(102416);
                    return 0;
                default:
                    AppMethodBeat.m2505o(102416);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(102416);
            return -1;
        }
    }
}
