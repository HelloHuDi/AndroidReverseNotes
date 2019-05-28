package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cjg */
public final class cjg extends C1331a {
    public String kbV;
    public String nuL;
    public String pbn;
    public String pbo;
    public String vJC;
    public String vJD;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(48977);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.pbn != null) {
                c6093a.mo13475e(1, this.pbn);
            }
            if (this.kbV != null) {
                c6093a.mo13475e(2, this.kbV);
            }
            if (this.nuL != null) {
                c6093a.mo13475e(3, this.nuL);
            }
            if (this.pbo != null) {
                c6093a.mo13475e(4, this.pbo);
            }
            if (this.vJC != null) {
                c6093a.mo13475e(5, this.vJC);
            }
            if (this.vJD != null) {
                c6093a.mo13475e(6, this.vJD);
            }
            AppMethodBeat.m2505o(48977);
            return 0;
        } else if (i == 1) {
            if (this.pbn != null) {
                f = C6091a.m9575f(1, this.pbn) + 0;
            } else {
                f = 0;
            }
            if (this.kbV != null) {
                f += C6091a.m9575f(2, this.kbV);
            }
            if (this.nuL != null) {
                f += C6091a.m9575f(3, this.nuL);
            }
            if (this.pbo != null) {
                f += C6091a.m9575f(4, this.pbo);
            }
            if (this.vJC != null) {
                f += C6091a.m9575f(5, this.vJC);
            }
            if (this.vJD != null) {
                f += C6091a.m9575f(6, this.vJD);
            }
            AppMethodBeat.m2505o(48977);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(48977);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cjg cjg = (cjg) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cjg.pbn = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48977);
                    return 0;
                case 2:
                    cjg.kbV = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48977);
                    return 0;
                case 3:
                    cjg.nuL = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48977);
                    return 0;
                case 4:
                    cjg.pbo = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48977);
                    return 0;
                case 5:
                    cjg.vJC = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48977);
                    return 0;
                case 6:
                    cjg.vJD = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48977);
                    return 0;
                default:
                    AppMethodBeat.m2505o(48977);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(48977);
            return -1;
        }
    }
}
