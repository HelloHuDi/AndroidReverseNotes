package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.hb */
public final class C35922hb extends C1331a {
    public String kmu;
    public String nuL;
    public String pbn;
    public String tuk;
    public String vJG;
    public String vJH;
    public String vJI;
    public boolean vJJ;
    public String vJK;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(48775);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.nuL != null) {
                c6093a.mo13475e(1, this.nuL);
            }
            if (this.pbn != null) {
                c6093a.mo13475e(2, this.pbn);
            }
            if (this.kmu != null) {
                c6093a.mo13475e(3, this.kmu);
            }
            if (this.tuk != null) {
                c6093a.mo13475e(4, this.tuk);
            }
            if (this.vJG != null) {
                c6093a.mo13475e(5, this.vJG);
            }
            if (this.vJH != null) {
                c6093a.mo13475e(6, this.vJH);
            }
            if (this.vJI != null) {
                c6093a.mo13475e(8, this.vJI);
            }
            c6093a.mo13471aO(9, this.vJJ);
            if (this.vJK != null) {
                c6093a.mo13475e(10, this.vJK);
            }
            AppMethodBeat.m2505o(48775);
            return 0;
        } else if (i == 1) {
            if (this.nuL != null) {
                f = C6091a.m9575f(1, this.nuL) + 0;
            } else {
                f = 0;
            }
            if (this.pbn != null) {
                f += C6091a.m9575f(2, this.pbn);
            }
            if (this.kmu != null) {
                f += C6091a.m9575f(3, this.kmu);
            }
            if (this.tuk != null) {
                f += C6091a.m9575f(4, this.tuk);
            }
            if (this.vJG != null) {
                f += C6091a.m9575f(5, this.vJG);
            }
            if (this.vJH != null) {
                f += C6091a.m9575f(6, this.vJH);
            }
            if (this.vJI != null) {
                f += C6091a.m9575f(8, this.vJI);
            }
            f += C6091a.m9576fv(9) + 1;
            if (this.vJK != null) {
                f += C6091a.m9575f(10, this.vJK);
            }
            AppMethodBeat.m2505o(48775);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(48775);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C35922hb c35922hb = (C35922hb) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    c35922hb.nuL = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48775);
                    return 0;
                case 2:
                    c35922hb.pbn = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48775);
                    return 0;
                case 3:
                    c35922hb.kmu = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48775);
                    return 0;
                case 4:
                    c35922hb.tuk = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48775);
                    return 0;
                case 5:
                    c35922hb.vJG = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48775);
                    return 0;
                case 6:
                    c35922hb.vJH = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48775);
                    return 0;
                case 8:
                    c35922hb.vJI = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48775);
                    return 0;
                case 9:
                    c35922hb.vJJ = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(48775);
                    return 0;
                case 10:
                    c35922hb.vJK = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48775);
                    return 0;
                default:
                    AppMethodBeat.m2505o(48775);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(48775);
            return -1;
        }
    }
}
