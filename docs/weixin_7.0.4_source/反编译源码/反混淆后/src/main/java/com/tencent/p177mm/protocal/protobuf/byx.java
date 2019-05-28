package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.byx */
public final class byx extends C1331a {
    public String cMC;
    public String cMD;
    public String kbU;
    public String vBu;
    public String vBv;
    public int vBw;
    public String vGv;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(89140);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.cMC != null) {
                c6093a.mo13475e(1, this.cMC);
            }
            if (this.kbU != null) {
                c6093a.mo13475e(2, this.kbU);
            }
            if (this.cMD != null) {
                c6093a.mo13475e(3, this.cMD);
            }
            if (this.vBu != null) {
                c6093a.mo13475e(4, this.vBu);
            }
            if (this.vBv != null) {
                c6093a.mo13475e(5, this.vBv);
            }
            c6093a.mo13480iz(6, this.vBw);
            if (this.vGv != null) {
                c6093a.mo13475e(7, this.vGv);
            }
            AppMethodBeat.m2505o(89140);
            return 0;
        } else if (i == 1) {
            if (this.cMC != null) {
                f = C6091a.m9575f(1, this.cMC) + 0;
            } else {
                f = 0;
            }
            if (this.kbU != null) {
                f += C6091a.m9575f(2, this.kbU);
            }
            if (this.cMD != null) {
                f += C6091a.m9575f(3, this.cMD);
            }
            if (this.vBu != null) {
                f += C6091a.m9575f(4, this.vBu);
            }
            if (this.vBv != null) {
                f += C6091a.m9575f(5, this.vBv);
            }
            f += C6091a.m9572bs(6, this.vBw);
            if (this.vGv != null) {
                f += C6091a.m9575f(7, this.vGv);
            }
            AppMethodBeat.m2505o(89140);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(89140);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            byx byx = (byx) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    byx.cMC = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89140);
                    return 0;
                case 2:
                    byx.kbU = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89140);
                    return 0;
                case 3:
                    byx.cMD = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89140);
                    return 0;
                case 4:
                    byx.vBu = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89140);
                    return 0;
                case 5:
                    byx.vBv = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89140);
                    return 0;
                case 6:
                    byx.vBw = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(89140);
                    return 0;
                case 7:
                    byx.vGv = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89140);
                    return 0;
                default:
                    AppMethodBeat.m2505o(89140);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(89140);
            return -1;
        }
    }
}
