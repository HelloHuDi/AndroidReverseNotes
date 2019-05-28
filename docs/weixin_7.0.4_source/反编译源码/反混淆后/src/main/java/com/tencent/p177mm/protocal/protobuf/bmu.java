package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bmu */
public final class bmu extends C1331a {
    public int guN;
    public String guO;
    public String guP;
    public String guQ;
    public int guR;
    public String guS;
    public int guT;
    public int guU;
    public String guV;
    public String guW;
    public String guX;
    public String jBB;
    public String jCH;
    public String vXm;
    public String vXn;
    public ccl wBZ;
    public C7285uy wCa;
    public int wPI;
    public String wPJ;
    public int wPK;
    public String wPL;
    public String wlF;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(73747);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.wPI);
            if (this.jBB != null) {
                c6093a.mo13475e(2, this.jBB);
            }
            if (this.jCH != null) {
                c6093a.mo13475e(3, this.jCH);
            }
            if (this.wPJ != null) {
                c6093a.mo13475e(4, this.wPJ);
            }
            c6093a.mo13480iz(5, this.wPK);
            if (this.wPL != null) {
                c6093a.mo13475e(6, this.wPL);
            }
            c6093a.mo13480iz(7, this.guN);
            if (this.guO != null) {
                c6093a.mo13475e(8, this.guO);
            }
            if (this.guP != null) {
                c6093a.mo13475e(9, this.guP);
            }
            if (this.guQ != null) {
                c6093a.mo13475e(10, this.guQ);
            }
            c6093a.mo13480iz(11, this.guR);
            if (this.guS != null) {
                c6093a.mo13475e(12, this.guS);
            }
            c6093a.mo13480iz(13, this.guT);
            c6093a.mo13480iz(14, this.guU);
            if (this.guV != null) {
                c6093a.mo13475e(15, this.guV);
            }
            if (this.wBZ != null) {
                c6093a.mo13479iy(16, this.wBZ.computeSize());
                this.wBZ.writeFields(c6093a);
            }
            if (this.guW != null) {
                c6093a.mo13475e(17, this.guW);
            }
            if (this.guX != null) {
                c6093a.mo13475e(18, this.guX);
            }
            if (this.wCa != null) {
                c6093a.mo13479iy(19, this.wCa.computeSize());
                this.wCa.writeFields(c6093a);
            }
            if (this.vXm != null) {
                c6093a.mo13475e(20, this.vXm);
            }
            if (this.vXn != null) {
                c6093a.mo13475e(21, this.vXn);
            }
            if (this.wlF != null) {
                c6093a.mo13475e(22, this.wlF);
            }
            AppMethodBeat.m2505o(73747);
            return 0;
        } else if (i == 1) {
            bs = C6091a.m9572bs(1, this.wPI) + 0;
            if (this.jBB != null) {
                bs += C6091a.m9575f(2, this.jBB);
            }
            if (this.jCH != null) {
                bs += C6091a.m9575f(3, this.jCH);
            }
            if (this.wPJ != null) {
                bs += C6091a.m9575f(4, this.wPJ);
            }
            bs += C6091a.m9572bs(5, this.wPK);
            if (this.wPL != null) {
                bs += C6091a.m9575f(6, this.wPL);
            }
            bs += C6091a.m9572bs(7, this.guN);
            if (this.guO != null) {
                bs += C6091a.m9575f(8, this.guO);
            }
            if (this.guP != null) {
                bs += C6091a.m9575f(9, this.guP);
            }
            if (this.guQ != null) {
                bs += C6091a.m9575f(10, this.guQ);
            }
            bs += C6091a.m9572bs(11, this.guR);
            if (this.guS != null) {
                bs += C6091a.m9575f(12, this.guS);
            }
            bs = (bs + C6091a.m9572bs(13, this.guT)) + C6091a.m9572bs(14, this.guU);
            if (this.guV != null) {
                bs += C6091a.m9575f(15, this.guV);
            }
            if (this.wBZ != null) {
                bs += C6087a.m9557ix(16, this.wBZ.computeSize());
            }
            if (this.guW != null) {
                bs += C6091a.m9575f(17, this.guW);
            }
            if (this.guX != null) {
                bs += C6091a.m9575f(18, this.guX);
            }
            if (this.wCa != null) {
                bs += C6087a.m9557ix(19, this.wCa.computeSize());
            }
            if (this.vXm != null) {
                bs += C6091a.m9575f(20, this.vXm);
            }
            if (this.vXn != null) {
                bs += C6091a.m9575f(21, this.vXn);
            }
            if (this.wlF != null) {
                bs += C6091a.m9575f(22, this.wlF);
            }
            AppMethodBeat.m2505o(73747);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(73747);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bmu bmu = (bmu) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    bmu.wPI = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(73747);
                    return 0;
                case 2:
                    bmu.jBB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(73747);
                    return 0;
                case 3:
                    bmu.jCH = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(73747);
                    return 0;
                case 4:
                    bmu.wPJ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(73747);
                    return 0;
                case 5:
                    bmu.wPK = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(73747);
                    return 0;
                case 6:
                    bmu.wPL = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(73747);
                    return 0;
                case 7:
                    bmu.guN = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(73747);
                    return 0;
                case 8:
                    bmu.guO = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(73747);
                    return 0;
                case 9:
                    bmu.guP = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(73747);
                    return 0;
                case 10:
                    bmu.guQ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(73747);
                    return 0;
                case 11:
                    bmu.guR = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(73747);
                    return 0;
                case 12:
                    bmu.guS = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(73747);
                    return 0;
                case 13:
                    bmu.guT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(73747);
                    return 0;
                case 14:
                    bmu.guU = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(73747);
                    return 0;
                case 15:
                    bmu.guV = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(73747);
                    return 0;
                case 16:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ccl ccl = new ccl();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = ccl.populateBuilderWithField(c6086a3, ccl, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bmu.wBZ = ccl;
                    }
                    AppMethodBeat.m2505o(73747);
                    return 0;
                case 17:
                    bmu.guW = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(73747);
                    return 0;
                case 18:
                    bmu.guX = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(73747);
                    return 0;
                case 19:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C7285uy c7285uy = new C7285uy();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c7285uy.populateBuilderWithField(c6086a3, c7285uy, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bmu.wCa = c7285uy;
                    }
                    AppMethodBeat.m2505o(73747);
                    return 0;
                case 20:
                    bmu.vXm = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(73747);
                    return 0;
                case 21:
                    bmu.vXn = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(73747);
                    return 0;
                case 22:
                    bmu.wlF = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(73747);
                    return 0;
                default:
                    AppMethodBeat.m2505o(73747);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(73747);
            return -1;
        }
    }
}
