package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.aul */
public final class aul extends C1331a {
    public int wyA;
    public int wyB;
    public int wyC;
    public int wyD;
    public float wyE;
    public float wyF;
    public float wyG;
    public String wyv;
    public String wyw;
    public long wyx;
    public int wyy;
    public int wyz;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(54937);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.wyv != null) {
                c6093a.mo13475e(1, this.wyv);
            }
            if (this.wyw != null) {
                c6093a.mo13475e(2, this.wyw);
            }
            c6093a.mo13472ai(3, this.wyx);
            c6093a.mo13480iz(4, this.wyy);
            c6093a.mo13480iz(5, this.wyz);
            c6093a.mo13480iz(6, this.wyA);
            c6093a.mo13480iz(7, this.wyB);
            c6093a.mo13480iz(8, this.wyC);
            c6093a.mo13480iz(9, this.wyD);
            c6093a.mo13481r(10, this.wyE);
            c6093a.mo13481r(11, this.wyF);
            c6093a.mo13481r(12, this.wyG);
            AppMethodBeat.m2505o(54937);
            return 0;
        } else if (i == 1) {
            if (this.wyv != null) {
                f = C6091a.m9575f(1, this.wyv) + 0;
            } else {
                f = 0;
            }
            if (this.wyw != null) {
                f += C6091a.m9575f(2, this.wyw);
            }
            int o = (((((((((f + C6091a.m9578o(3, this.wyx)) + C6091a.m9572bs(4, this.wyy)) + C6091a.m9572bs(5, this.wyz)) + C6091a.m9572bs(6, this.wyA)) + C6091a.m9572bs(7, this.wyB)) + C6091a.m9572bs(8, this.wyC)) + C6091a.m9572bs(9, this.wyD)) + (C6091a.m9576fv(10) + 4)) + (C6091a.m9576fv(11) + 4)) + (C6091a.m9576fv(12) + 4);
            AppMethodBeat.m2505o(54937);
            return o;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(54937);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            aul aul = (aul) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aul.wyv = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(54937);
                    return 0;
                case 2:
                    aul.wyw = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(54937);
                    return 0;
                case 3:
                    aul.wyx = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(54937);
                    return 0;
                case 4:
                    aul.wyy = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(54937);
                    return 0;
                case 5:
                    aul.wyz = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(54937);
                    return 0;
                case 6:
                    aul.wyA = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(54937);
                    return 0;
                case 7:
                    aul.wyB = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(54937);
                    return 0;
                case 8:
                    aul.wyC = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(54937);
                    return 0;
                case 9:
                    aul.wyD = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(54937);
                    return 0;
                case 10:
                    aul.wyE = Float.intBitsToFloat(c6086a2.BTU.eia());
                    AppMethodBeat.m2505o(54937);
                    return 0;
                case 11:
                    aul.wyF = Float.intBitsToFloat(c6086a2.BTU.eia());
                    AppMethodBeat.m2505o(54937);
                    return 0;
                case 12:
                    aul.wyG = Float.intBitsToFloat(c6086a2.BTU.eia());
                    AppMethodBeat.m2505o(54937);
                    return 0;
                default:
                    AppMethodBeat.m2505o(54937);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(54937);
            return -1;
        }
    }
}
