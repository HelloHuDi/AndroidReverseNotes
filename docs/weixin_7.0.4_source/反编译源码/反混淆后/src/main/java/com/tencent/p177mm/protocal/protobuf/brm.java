package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.brm */
public class brm extends C1331a {
    public int ndr;
    public String vMR;
    public long wTJ;
    public int wTK;
    public boolean wTL;
    public boolean wTM;
    public int wTN;
    public boolean wTO;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(11801);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vMR != null) {
                c6093a.mo13475e(1, this.vMR);
            }
            c6093a.mo13472ai(2, this.wTJ);
            c6093a.mo13480iz(3, this.wTK);
            c6093a.mo13471aO(4, this.wTL);
            c6093a.mo13471aO(5, this.wTM);
            c6093a.mo13480iz(6, this.wTN);
            c6093a.mo13480iz(7, this.ndr);
            c6093a.mo13471aO(8, this.wTO);
            AppMethodBeat.m2505o(11801);
            return 0;
        } else if (i == 1) {
            if (this.vMR != null) {
                f = C6091a.m9575f(1, this.vMR) + 0;
            } else {
                f = 0;
            }
            int o = ((((((f + C6091a.m9578o(2, this.wTJ)) + C6091a.m9572bs(3, this.wTK)) + (C6091a.m9576fv(4) + 1)) + (C6091a.m9576fv(5) + 1)) + C6091a.m9572bs(6, this.wTN)) + C6091a.m9572bs(7, this.ndr)) + (C6091a.m9576fv(8) + 1);
            AppMethodBeat.m2505o(11801);
            return o;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(11801);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            brm brm = (brm) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    brm.vMR = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(11801);
                    return 0;
                case 2:
                    brm.wTJ = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(11801);
                    return 0;
                case 3:
                    brm.wTK = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(11801);
                    return 0;
                case 4:
                    brm.wTL = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(11801);
                    return 0;
                case 5:
                    brm.wTM = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(11801);
                    return 0;
                case 6:
                    brm.wTN = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(11801);
                    return 0;
                case 7:
                    brm.ndr = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(11801);
                    return 0;
                case 8:
                    brm.wTO = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(11801);
                    return 0;
                default:
                    AppMethodBeat.m2505o(11801);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(11801);
            return -1;
        }
    }
}
