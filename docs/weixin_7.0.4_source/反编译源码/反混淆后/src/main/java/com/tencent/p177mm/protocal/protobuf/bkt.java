package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bkt */
public final class bkt extends C1331a {
    public float vRp;
    public float vRq;
    public int wfG;
    public String wfH;
    public String wfI;
    public int wfJ;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(80155);
        int fv;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13481r(1, this.vRp);
            c6093a.mo13481r(2, this.vRq);
            c6093a.mo13480iz(3, this.wfG);
            if (this.wfH != null) {
                c6093a.mo13475e(4, this.wfH);
            }
            if (this.wfI != null) {
                c6093a.mo13475e(5, this.wfI);
            }
            c6093a.mo13480iz(6, this.wfJ);
            AppMethodBeat.m2505o(80155);
            return 0;
        } else if (i == 1) {
            fv = (((C6091a.m9576fv(1) + 4) + 0) + (C6091a.m9576fv(2) + 4)) + C6091a.m9572bs(3, this.wfG);
            if (this.wfH != null) {
                fv += C6091a.m9575f(4, this.wfH);
            }
            if (this.wfI != null) {
                fv += C6091a.m9575f(5, this.wfI);
            }
            fv += C6091a.m9572bs(6, this.wfJ);
            AppMethodBeat.m2505o(80155);
            return fv;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (fv = C1331a.getNextFieldNumber(c6086a); fv > 0; fv = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, fv)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(80155);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bkt bkt = (bkt) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bkt.vRp = Float.intBitsToFloat(c6086a2.BTU.eia());
                    AppMethodBeat.m2505o(80155);
                    return 0;
                case 2:
                    bkt.vRq = Float.intBitsToFloat(c6086a2.BTU.eia());
                    AppMethodBeat.m2505o(80155);
                    return 0;
                case 3:
                    bkt.wfG = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80155);
                    return 0;
                case 4:
                    bkt.wfH = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80155);
                    return 0;
                case 5:
                    bkt.wfI = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80155);
                    return 0;
                case 6:
                    bkt.wfJ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80155);
                    return 0;
                default:
                    AppMethodBeat.m2505o(80155);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(80155);
            return -1;
        }
    }
}
