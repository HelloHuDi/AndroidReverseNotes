package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.cek */
public final class cek extends C1331a {
    /* renamed from: Id */
    public String f4416Id;
    public String Url;
    public int cNE;
    public int cuu;
    public String cvZ;
    public float duration;
    public int jCt;
    public int wEG;
    public String wEH;
    public int wEI;
    public int wET;
    public long wEU;
    public String wEV;
    public String wEW;
    public int wEX;
    public String wEY;
    public String wEZ;
    public int wFa;
    public String wFb;
    public String wFc;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56527);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.f4416Id != null) {
                c6093a.mo13475e(1, this.f4416Id);
            }
            c6093a.mo13480iz(2, this.jCt);
            if (this.Url != null) {
                c6093a.mo13475e(3, this.Url);
            }
            c6093a.mo13480iz(4, this.wEG);
            if (this.wEH != null) {
                c6093a.mo13475e(5, this.wEH);
            }
            c6093a.mo13480iz(6, this.wEI);
            c6093a.mo13480iz(7, this.cuu);
            if (this.cvZ != null) {
                c6093a.mo13475e(8, this.cvZ);
            }
            if (this.wFc != null) {
                c6093a.mo13475e(9, this.wFc);
            }
            c6093a.mo13480iz(10, this.cNE);
            c6093a.mo13480iz(11, this.wET);
            c6093a.mo13472ai(12, this.wEU);
            if (this.wEV != null) {
                c6093a.mo13475e(13, this.wEV);
            }
            if (this.wEW != null) {
                c6093a.mo13475e(14, this.wEW);
            }
            c6093a.mo13480iz(15, this.wEX);
            if (this.wEY != null) {
                c6093a.mo13475e(16, this.wEY);
            }
            if (this.wEZ != null) {
                c6093a.mo13475e(17, this.wEZ);
            }
            c6093a.mo13480iz(18, this.wFa);
            if (this.wFb != null) {
                c6093a.mo13475e(19, this.wFb);
            }
            c6093a.mo13481r(20, this.duration);
            AppMethodBeat.m2505o(56527);
            return 0;
        } else if (i == 1) {
            if (this.f4416Id != null) {
                f = C6091a.m9575f(1, this.f4416Id) + 0;
            } else {
                f = 0;
            }
            f += C6091a.m9572bs(2, this.jCt);
            if (this.Url != null) {
                f += C6091a.m9575f(3, this.Url);
            }
            f += C6091a.m9572bs(4, this.wEG);
            if (this.wEH != null) {
                f += C6091a.m9575f(5, this.wEH);
            }
            f = (f + C6091a.m9572bs(6, this.wEI)) + C6091a.m9572bs(7, this.cuu);
            if (this.cvZ != null) {
                f += C6091a.m9575f(8, this.cvZ);
            }
            if (this.wFc != null) {
                f += C6091a.m9575f(9, this.wFc);
            }
            f = ((f + C6091a.m9572bs(10, this.cNE)) + C6091a.m9572bs(11, this.wET)) + C6091a.m9578o(12, this.wEU);
            if (this.wEV != null) {
                f += C6091a.m9575f(13, this.wEV);
            }
            if (this.wEW != null) {
                f += C6091a.m9575f(14, this.wEW);
            }
            f += C6091a.m9572bs(15, this.wEX);
            if (this.wEY != null) {
                f += C6091a.m9575f(16, this.wEY);
            }
            if (this.wEZ != null) {
                f += C6091a.m9575f(17, this.wEZ);
            }
            f += C6091a.m9572bs(18, this.wFa);
            if (this.wFb != null) {
                f += C6091a.m9575f(19, this.wFb);
            }
            int fv = f + (C6091a.m9576fv(20) + 4);
            AppMethodBeat.m2505o(56527);
            return fv;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(56527);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cek cek = (cek) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cek.f4416Id = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56527);
                    return 0;
                case 2:
                    cek.jCt = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56527);
                    return 0;
                case 3:
                    cek.Url = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56527);
                    return 0;
                case 4:
                    cek.wEG = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56527);
                    return 0;
                case 5:
                    cek.wEH = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56527);
                    return 0;
                case 6:
                    cek.wEI = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56527);
                    return 0;
                case 7:
                    cek.cuu = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56527);
                    return 0;
                case 8:
                    cek.cvZ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56527);
                    return 0;
                case 9:
                    cek.wFc = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56527);
                    return 0;
                case 10:
                    cek.cNE = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56527);
                    return 0;
                case 11:
                    cek.wET = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56527);
                    return 0;
                case 12:
                    cek.wEU = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(56527);
                    return 0;
                case 13:
                    cek.wEV = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56527);
                    return 0;
                case 14:
                    cek.wEW = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56527);
                    return 0;
                case 15:
                    cek.wEX = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56527);
                    return 0;
                case 16:
                    cek.wEY = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56527);
                    return 0;
                case 17:
                    cek.wEZ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56527);
                    return 0;
                case 18:
                    cek.wFa = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56527);
                    return 0;
                case 19:
                    cek.wFb = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56527);
                    return 0;
                case 20:
                    cek.duration = Float.intBitsToFloat(c6086a2.BTU.eia());
                    AppMethodBeat.m2505o(56527);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56527);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56527);
            return -1;
        }
    }
}
