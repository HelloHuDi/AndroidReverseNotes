package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.p205bt.C1332b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.ayt */
public final class ayt extends C1331a {
    public float bEJ;
    public String country;
    public String eUu;
    public String guP;
    public String rkg;
    public int rki;
    public int rkk;
    public int score;
    public float vRp;
    public float vRq;
    public String wCC;
    public String wCD;
    public int wCE;
    public int wCF;
    public C1332b wCG;
    public String wCH;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(94535);
        int fv;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13481r(1, this.vRp);
            c6093a.mo13481r(2, this.vRq);
            if (this.guP != null) {
                c6093a.mo13475e(3, this.guP);
            }
            if (this.eUu != null) {
                c6093a.mo13475e(4, this.eUu);
            }
            if (this.rkg != null) {
                c6093a.mo13475e(5, this.rkg);
            }
            if (this.wCC != null) {
                c6093a.mo13475e(6, this.wCC);
            }
            c6093a.mo13480iz(7, this.rki);
            if (this.wCD != null) {
                c6093a.mo13475e(8, this.wCD);
            }
            c6093a.mo13480iz(9, this.wCE);
            c6093a.mo13480iz(10, this.wCF);
            c6093a.mo13480iz(11, this.rkk);
            c6093a.mo13481r(12, this.bEJ);
            if (this.wCG != null) {
                c6093a.mo13473c(13, this.wCG);
            }
            c6093a.mo13480iz(14, this.score);
            if (this.wCH != null) {
                c6093a.mo13475e(15, this.wCH);
            }
            if (this.country != null) {
                c6093a.mo13475e(16, this.country);
            }
            AppMethodBeat.m2505o(94535);
            return 0;
        } else if (i == 1) {
            fv = ((C6091a.m9576fv(1) + 4) + 0) + (C6091a.m9576fv(2) + 4);
            if (this.guP != null) {
                fv += C6091a.m9575f(3, this.guP);
            }
            if (this.eUu != null) {
                fv += C6091a.m9575f(4, this.eUu);
            }
            if (this.rkg != null) {
                fv += C6091a.m9575f(5, this.rkg);
            }
            if (this.wCC != null) {
                fv += C6091a.m9575f(6, this.wCC);
            }
            fv += C6091a.m9572bs(7, this.rki);
            if (this.wCD != null) {
                fv += C6091a.m9575f(8, this.wCD);
            }
            fv = (((fv + C6091a.m9572bs(9, this.wCE)) + C6091a.m9572bs(10, this.wCF)) + C6091a.m9572bs(11, this.rkk)) + (C6091a.m9576fv(12) + 4);
            if (this.wCG != null) {
                fv += C6091a.m9571b(13, this.wCG);
            }
            fv += C6091a.m9572bs(14, this.score);
            if (this.wCH != null) {
                fv += C6091a.m9575f(15, this.wCH);
            }
            if (this.country != null) {
                fv += C6091a.m9575f(16, this.country);
            }
            AppMethodBeat.m2505o(94535);
            return fv;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (fv = C1331a.getNextFieldNumber(c6086a); fv > 0; fv = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, fv)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(94535);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            ayt ayt = (ayt) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ayt.vRp = Float.intBitsToFloat(c6086a2.BTU.eia());
                    AppMethodBeat.m2505o(94535);
                    return 0;
                case 2:
                    ayt.vRq = Float.intBitsToFloat(c6086a2.BTU.eia());
                    AppMethodBeat.m2505o(94535);
                    return 0;
                case 3:
                    ayt.guP = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94535);
                    return 0;
                case 4:
                    ayt.eUu = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94535);
                    return 0;
                case 5:
                    ayt.rkg = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94535);
                    return 0;
                case 6:
                    ayt.wCC = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94535);
                    return 0;
                case 7:
                    ayt.rki = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94535);
                    return 0;
                case 8:
                    ayt.wCD = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94535);
                    return 0;
                case 9:
                    ayt.wCE = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94535);
                    return 0;
                case 10:
                    ayt.wCF = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94535);
                    return 0;
                case 11:
                    ayt.rkk = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94535);
                    return 0;
                case 12:
                    ayt.bEJ = Float.intBitsToFloat(c6086a2.BTU.eia());
                    AppMethodBeat.m2505o(94535);
                    return 0;
                case 13:
                    ayt.wCG = c6086a2.BTU.emu();
                    AppMethodBeat.m2505o(94535);
                    return 0;
                case 14:
                    ayt.score = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(94535);
                    return 0;
                case 15:
                    ayt.wCH = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94535);
                    return 0;
                case 16:
                    ayt.country = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(94535);
                    return 0;
                default:
                    AppMethodBeat.m2505o(94535);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(94535);
            return -1;
        }
    }
}
