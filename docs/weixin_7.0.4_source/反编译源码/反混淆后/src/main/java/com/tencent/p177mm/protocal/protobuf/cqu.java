package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cqu */
public final class cqu extends C1331a {
    public String wbe;
    public String xoA;
    public String xoB;
    public int xoC;
    public float xoD;
    public float xoE;
    public String xoF;
    public String xoz;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(102402);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.xoz != null) {
                c6093a.mo13475e(1, this.xoz);
            }
            if (this.wbe != null) {
                c6093a.mo13475e(2, this.wbe);
            }
            if (this.xoA != null) {
                c6093a.mo13475e(3, this.xoA);
            }
            if (this.xoB != null) {
                c6093a.mo13475e(4, this.xoB);
            }
            c6093a.mo13480iz(5, this.xoC);
            c6093a.mo13481r(6, this.xoD);
            c6093a.mo13481r(7, this.xoE);
            if (this.xoF != null) {
                c6093a.mo13475e(8, this.xoF);
            }
            AppMethodBeat.m2505o(102402);
            return 0;
        } else if (i == 1) {
            if (this.xoz != null) {
                f = C6091a.m9575f(1, this.xoz) + 0;
            } else {
                f = 0;
            }
            if (this.wbe != null) {
                f += C6091a.m9575f(2, this.wbe);
            }
            if (this.xoA != null) {
                f += C6091a.m9575f(3, this.xoA);
            }
            if (this.xoB != null) {
                f += C6091a.m9575f(4, this.xoB);
            }
            f = ((f + C6091a.m9572bs(5, this.xoC)) + (C6091a.m9576fv(6) + 4)) + (C6091a.m9576fv(7) + 4);
            if (this.xoF != null) {
                f += C6091a.m9575f(8, this.xoF);
            }
            AppMethodBeat.m2505o(102402);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(102402);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cqu cqu = (cqu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cqu.xoz = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(102402);
                    return 0;
                case 2:
                    cqu.wbe = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(102402);
                    return 0;
                case 3:
                    cqu.xoA = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(102402);
                    return 0;
                case 4:
                    cqu.xoB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(102402);
                    return 0;
                case 5:
                    cqu.xoC = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(102402);
                    return 0;
                case 6:
                    cqu.xoD = Float.intBitsToFloat(c6086a2.BTU.eia());
                    AppMethodBeat.m2505o(102402);
                    return 0;
                case 7:
                    cqu.xoE = Float.intBitsToFloat(c6086a2.BTU.eia());
                    AppMethodBeat.m2505o(102402);
                    return 0;
                case 8:
                    cqu.xoF = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(102402);
                    return 0;
                default:
                    AppMethodBeat.m2505o(102402);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(102402);
            return -1;
        }
    }
}
