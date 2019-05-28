package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.gz */
public final class C23395gz extends C1331a {
    public String nuL;
    public String pbn;
    public String pbo;
    public String tuk;
    public String vJB;
    public String vJC;
    public String vJD;
    public String vJE;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56708);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vJB != null) {
                c6093a.mo13475e(1, this.vJB);
            }
            if (this.tuk != null) {
                c6093a.mo13475e(2, this.tuk);
            }
            if (this.pbn != null) {
                c6093a.mo13475e(3, this.pbn);
            }
            if (this.pbo != null) {
                c6093a.mo13475e(4, this.pbo);
            }
            if (this.nuL != null) {
                c6093a.mo13475e(5, this.nuL);
            }
            if (this.vJC != null) {
                c6093a.mo13475e(6, this.vJC);
            }
            if (this.vJD != null) {
                c6093a.mo13475e(7, this.vJD);
            }
            if (this.vJE != null) {
                c6093a.mo13475e(8, this.vJE);
            }
            AppMethodBeat.m2505o(56708);
            return 0;
        } else if (i == 1) {
            if (this.vJB != null) {
                f = C6091a.m9575f(1, this.vJB) + 0;
            } else {
                f = 0;
            }
            if (this.tuk != null) {
                f += C6091a.m9575f(2, this.tuk);
            }
            if (this.pbn != null) {
                f += C6091a.m9575f(3, this.pbn);
            }
            if (this.pbo != null) {
                f += C6091a.m9575f(4, this.pbo);
            }
            if (this.nuL != null) {
                f += C6091a.m9575f(5, this.nuL);
            }
            if (this.vJC != null) {
                f += C6091a.m9575f(6, this.vJC);
            }
            if (this.vJD != null) {
                f += C6091a.m9575f(7, this.vJD);
            }
            if (this.vJE != null) {
                f += C6091a.m9575f(8, this.vJE);
            }
            AppMethodBeat.m2505o(56708);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(56708);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C23395gz c23395gz = (C23395gz) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c23395gz.vJB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56708);
                    return 0;
                case 2:
                    c23395gz.tuk = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56708);
                    return 0;
                case 3:
                    c23395gz.pbn = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56708);
                    return 0;
                case 4:
                    c23395gz.pbo = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56708);
                    return 0;
                case 5:
                    c23395gz.nuL = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56708);
                    return 0;
                case 6:
                    c23395gz.vJC = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56708);
                    return 0;
                case 7:
                    c23395gz.vJD = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56708);
                    return 0;
                case 8:
                    c23395gz.vJE = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56708);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56708);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56708);
            return -1;
        }
    }
}
