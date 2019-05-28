package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bkb */
public final class bkb extends C1331a {
    public String ncH;
    public String pcU;
    public String pcW;
    public int pcX;
    public String pcY;
    public int pcZ;
    public String pda;
    public int pdb;
    public int pdc;
    public String pde;
    public String pdf;
    public String pdg;
    public String pdh;
    public int wMU;
    public String wNg;
    public String wNh;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56917);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.pcU != null) {
                c6093a.mo13475e(1, this.pcU);
            }
            c6093a.mo13480iz(2, this.wMU);
            if (this.pcW != null) {
                c6093a.mo13475e(3, this.pcW);
            }
            c6093a.mo13480iz(4, this.pcX);
            if (this.pcY != null) {
                c6093a.mo13475e(5, this.pcY);
            }
            c6093a.mo13480iz(6, this.pcZ);
            if (this.pda != null) {
                c6093a.mo13475e(7, this.pda);
            }
            c6093a.mo13480iz(8, this.pdb);
            c6093a.mo13480iz(9, this.pdc);
            if (this.ncH != null) {
                c6093a.mo13475e(11, this.ncH);
            }
            if (this.pde != null) {
                c6093a.mo13475e(12, this.pde);
            }
            if (this.pdf != null) {
                c6093a.mo13475e(13, this.pdf);
            }
            if (this.pdg != null) {
                c6093a.mo13475e(14, this.pdg);
            }
            if (this.pdh != null) {
                c6093a.mo13475e(15, this.pdh);
            }
            if (this.wNg != null) {
                c6093a.mo13475e(18, this.wNg);
            }
            if (this.wNh != null) {
                c6093a.mo13475e(19, this.wNh);
            }
            AppMethodBeat.m2505o(56917);
            return 0;
        } else if (i == 1) {
            if (this.pcU != null) {
                f = C6091a.m9575f(1, this.pcU) + 0;
            } else {
                f = 0;
            }
            f += C6091a.m9572bs(2, this.wMU);
            if (this.pcW != null) {
                f += C6091a.m9575f(3, this.pcW);
            }
            f += C6091a.m9572bs(4, this.pcX);
            if (this.pcY != null) {
                f += C6091a.m9575f(5, this.pcY);
            }
            f += C6091a.m9572bs(6, this.pcZ);
            if (this.pda != null) {
                f += C6091a.m9575f(7, this.pda);
            }
            f = (f + C6091a.m9572bs(8, this.pdb)) + C6091a.m9572bs(9, this.pdc);
            if (this.ncH != null) {
                f += C6091a.m9575f(11, this.ncH);
            }
            if (this.pde != null) {
                f += C6091a.m9575f(12, this.pde);
            }
            if (this.pdf != null) {
                f += C6091a.m9575f(13, this.pdf);
            }
            if (this.pdg != null) {
                f += C6091a.m9575f(14, this.pdg);
            }
            if (this.pdh != null) {
                f += C6091a.m9575f(15, this.pdh);
            }
            if (this.wNg != null) {
                f += C6091a.m9575f(18, this.wNg);
            }
            if (this.wNh != null) {
                f += C6091a.m9575f(19, this.wNh);
            }
            AppMethodBeat.m2505o(56917);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(56917);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bkb bkb = (bkb) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bkb.pcU = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56917);
                    return 0;
                case 2:
                    bkb.wMU = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56917);
                    return 0;
                case 3:
                    bkb.pcW = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56917);
                    return 0;
                case 4:
                    bkb.pcX = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56917);
                    return 0;
                case 5:
                    bkb.pcY = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56917);
                    return 0;
                case 6:
                    bkb.pcZ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56917);
                    return 0;
                case 7:
                    bkb.pda = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56917);
                    return 0;
                case 8:
                    bkb.pdb = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56917);
                    return 0;
                case 9:
                    bkb.pdc = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56917);
                    return 0;
                case 11:
                    bkb.ncH = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56917);
                    return 0;
                case 12:
                    bkb.pde = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56917);
                    return 0;
                case 13:
                    bkb.pdf = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56917);
                    return 0;
                case 14:
                    bkb.pdg = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56917);
                    return 0;
                case 15:
                    bkb.pdh = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56917);
                    return 0;
                case 18:
                    bkb.wNg = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56917);
                    return 0;
                case 19:
                    bkb.wNh = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56917);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56917);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56917);
            return -1;
        }
    }
}
