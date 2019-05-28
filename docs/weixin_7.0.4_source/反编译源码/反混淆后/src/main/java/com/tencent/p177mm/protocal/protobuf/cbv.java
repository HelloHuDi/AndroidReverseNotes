package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cbv */
public final class cbv extends C1331a {
    public float bEJ;
    public int rkk;
    public float xbk;
    public float xbl;
    public float xbm;
    public float xbn;
    public int xbo;
    public long xbp;
    public long xbq;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(94602);
        int fv;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13481r(1, this.xbk);
            c6093a.mo13481r(2, this.xbl);
            c6093a.mo13481r(3, this.xbm);
            c6093a.mo13481r(4, this.xbn);
            c6093a.mo13480iz(5, this.xbo);
            c6093a.mo13472ai(6, this.xbp);
            c6093a.mo13472ai(7, this.xbq);
            c6093a.mo13481r(8, this.bEJ);
            c6093a.mo13480iz(9, this.rkk);
            AppMethodBeat.m2505o(94602);
            return 0;
        } else if (i == 1) {
            fv = (((((((((C6091a.m9576fv(1) + 4) + 0) + (C6091a.m9576fv(2) + 4)) + (C6091a.m9576fv(3) + 4)) + (C6091a.m9576fv(4) + 4)) + C6091a.m9572bs(5, this.xbo)) + C6091a.m9578o(6, this.xbp)) + C6091a.m9578o(7, this.xbq)) + (C6091a.m9576fv(8) + 4)) + C6091a.m9572bs(9, this.rkk);
            AppMethodBeat.m2505o(94602);
            return fv;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (fv = C1331a.getNextFieldNumber(c6086a); fv > 0; fv = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, fv)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(94602);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cbv cbv = (cbv) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cbv.xbk = Float.intBitsToFloat(c6086a2.BTU.eia());
                    AppMethodBeat.m2505o(94602);
                    return 0;
                case 2:
                    cbv.xbl = Float.intBitsToFloat(c6086a2.BTU.eia());
                    AppMethodBeat.m2505o(94602);
                    return 0;
                case 3:
                    cbv.xbm = Float.intBitsToFloat(c6086a2.BTU.eia());
                    AppMethodBeat.m2505o(94602);
                    return 0;
                case 4:
                    cbv.xbn = Float.intBitsToFloat(c6086a2.BTU.eia());
                    AppMethodBeat.m2505o(94602);
                    return 0;
                case 5:
                    cbv.xbo = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94602);
                    return 0;
                case 6:
                    cbv.xbp = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(94602);
                    return 0;
                case 7:
                    cbv.xbq = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(94602);
                    return 0;
                case 8:
                    cbv.bEJ = Float.intBitsToFloat(c6086a2.BTU.eia());
                    AppMethodBeat.m2505o(94602);
                    return 0;
                case 9:
                    cbv.rkk = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94602);
                    return 0;
                default:
                    AppMethodBeat.m2505o(94602);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(94602);
            return -1;
        }
    }
}
