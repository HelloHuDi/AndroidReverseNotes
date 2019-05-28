package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.view.C31128d;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.lu */
public final class C30202lu extends bsr {
    public int cIb;
    public String jSY;
    public String nickname;
    public int pOA;
    public String pPT;
    public String pPU;
    public String pPW;
    public int pPY;
    public String pPZ;
    public String pPw;
    public String pQa;
    public String rOh;
    public int scene;
    public abv vFe;
    public String vFf;
    public int vFg;
    public String vPj;
    public String vPp;
    public String vPq;
    public String vPr;
    public int vPs;
    public boolean vPt;
    public boolean vPu;
    public String vPv;
    public int vPw;
    public String vPx;
    public int vPy;
    public int vPz;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(56724);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vPp == null) {
                c6092b = new C6092b("Not all required fields were included: qrcode_id");
                AppMethodBeat.m2505o(56724);
                throw c6092b;
            }
            if (this.BaseRequest != null) {
                c6093a.mo13479iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(c6093a);
            }
            if (this.pPZ != null) {
                c6093a.mo13475e(2, this.pPZ);
            }
            if (this.vPp != null) {
                c6093a.mo13475e(3, this.vPp);
            }
            c6093a.mo13480iz(4, this.scene);
            if (this.vPq != null) {
                c6093a.mo13475e(5, this.vPq);
            }
            if (this.pPT != null) {
                c6093a.mo13475e(6, this.pPT);
            }
            c6093a.mo13480iz(7, this.vFg);
            c6093a.mo13480iz(8, this.cIb);
            if (this.pQa != null) {
                c6093a.mo13475e(9, this.pQa);
            }
            if (this.pPU != null) {
                c6093a.mo13475e(10, this.pPU);
            }
            if (this.vPr != null) {
                c6093a.mo13475e(11, this.vPr);
            }
            c6093a.mo13480iz(12, this.vPs);
            c6093a.mo13480iz(13, this.pPY);
            if (this.vFf != null) {
                c6093a.mo13475e(14, this.vFf);
            }
            if (this.vFe != null) {
                c6093a.mo13479iy(15, this.vFe.computeSize());
                this.vFe.writeFields(c6093a);
            }
            if (this.vPj != null) {
                c6093a.mo13475e(16, this.vPj);
            }
            c6093a.mo13480iz(17, this.pOA);
            c6093a.mo13471aO(18, this.vPt);
            c6093a.mo13471aO(19, this.vPu);
            if (this.rOh != null) {
                c6093a.mo13475e(20, this.rOh);
            }
            if (this.jSY != null) {
                c6093a.mo13475e(21, this.jSY);
            }
            if (this.vPv != null) {
                c6093a.mo13475e(22, this.vPv);
            }
            if (this.pPW != null) {
                c6093a.mo13475e(23, this.pPW);
            }
            if (this.nickname != null) {
                c6093a.mo13475e(24, this.nickname);
            }
            if (this.pPw != null) {
                c6093a.mo13475e(25, this.pPw);
            }
            c6093a.mo13480iz(26, this.vPw);
            if (this.vPx != null) {
                c6093a.mo13475e(27, this.vPx);
            }
            c6093a.mo13480iz(28, this.vPy);
            c6093a.mo13480iz(29, this.vPz);
            AppMethodBeat.m2505o(56724);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = C6087a.m9557ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.pPZ != null) {
                ix += C6091a.m9575f(2, this.pPZ);
            }
            if (this.vPp != null) {
                ix += C6091a.m9575f(3, this.vPp);
            }
            ix += C6091a.m9572bs(4, this.scene);
            if (this.vPq != null) {
                ix += C6091a.m9575f(5, this.vPq);
            }
            if (this.pPT != null) {
                ix += C6091a.m9575f(6, this.pPT);
            }
            ix = (ix + C6091a.m9572bs(7, this.vFg)) + C6091a.m9572bs(8, this.cIb);
            if (this.pQa != null) {
                ix += C6091a.m9575f(9, this.pQa);
            }
            if (this.pPU != null) {
                ix += C6091a.m9575f(10, this.pPU);
            }
            if (this.vPr != null) {
                ix += C6091a.m9575f(11, this.vPr);
            }
            ix = (ix + C6091a.m9572bs(12, this.vPs)) + C6091a.m9572bs(13, this.pPY);
            if (this.vFf != null) {
                ix += C6091a.m9575f(14, this.vFf);
            }
            if (this.vFe != null) {
                ix += C6087a.m9557ix(15, this.vFe.computeSize());
            }
            if (this.vPj != null) {
                ix += C6091a.m9575f(16, this.vPj);
            }
            ix = ((ix + C6091a.m9572bs(17, this.pOA)) + (C6091a.m9576fv(18) + 1)) + (C6091a.m9576fv(19) + 1);
            if (this.rOh != null) {
                ix += C6091a.m9575f(20, this.rOh);
            }
            if (this.jSY != null) {
                ix += C6091a.m9575f(21, this.jSY);
            }
            if (this.vPv != null) {
                ix += C6091a.m9575f(22, this.vPv);
            }
            if (this.pPW != null) {
                ix += C6091a.m9575f(23, this.pPW);
            }
            if (this.nickname != null) {
                ix += C6091a.m9575f(24, this.nickname);
            }
            if (this.pPw != null) {
                ix += C6091a.m9575f(25, this.pPw);
            }
            ix += C6091a.m9572bs(26, this.vPw);
            if (this.vPx != null) {
                ix += C6091a.m9575f(27, this.vPx);
            }
            int bs = (ix + C6091a.m9572bs(28, this.vPy)) + C6091a.m9572bs(29, this.vPz);
            AppMethodBeat.m2505o(56724);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.vPp == null) {
                c6092b = new C6092b("Not all required fields were included: qrcode_id");
                AppMethodBeat.m2505o(56724);
                throw c6092b;
            }
            AppMethodBeat.m2505o(56724);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C30202lu c30202lu = (C30202lu) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C7267hl c7267hl = new C7267hl();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c7267hl.populateBuilderWithField(c6086a3, c7267hl, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c30202lu.BaseRequest = c7267hl;
                    }
                    AppMethodBeat.m2505o(56724);
                    return 0;
                case 2:
                    c30202lu.pPZ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56724);
                    return 0;
                case 3:
                    c30202lu.vPp = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56724);
                    return 0;
                case 4:
                    c30202lu.scene = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56724);
                    return 0;
                case 5:
                    c30202lu.vPq = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56724);
                    return 0;
                case 6:
                    c30202lu.pPT = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56724);
                    return 0;
                case 7:
                    c30202lu.vFg = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56724);
                    return 0;
                case 8:
                    c30202lu.cIb = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56724);
                    return 0;
                case 9:
                    c30202lu.pQa = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56724);
                    return 0;
                case 10:
                    c30202lu.pPU = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56724);
                    return 0;
                case 11:
                    c30202lu.vPr = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56724);
                    return 0;
                case 12:
                    c30202lu.vPs = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56724);
                    return 0;
                case 13:
                    c30202lu.pPY = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56724);
                    return 0;
                case 14:
                    c30202lu.vFf = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56724);
                    return 0;
                case 15:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        abv abv = new abv();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = abv.populateBuilderWithField(c6086a3, abv, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c30202lu.vFe = abv;
                    }
                    AppMethodBeat.m2505o(56724);
                    return 0;
                case 16:
                    c30202lu.vPj = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56724);
                    return 0;
                case 17:
                    c30202lu.pOA = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56724);
                    return 0;
                case 18:
                    c30202lu.vPt = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(56724);
                    return 0;
                case 19:
                    c30202lu.vPu = c6086a2.BTU.ehX();
                    AppMethodBeat.m2505o(56724);
                    return 0;
                case 20:
                    c30202lu.rOh = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56724);
                    return 0;
                case 21:
                    c30202lu.jSY = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56724);
                    return 0;
                case 22:
                    c30202lu.vPv = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56724);
                    return 0;
                case 23:
                    c30202lu.pPW = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56724);
                    return 0;
                case 24:
                    c30202lu.nickname = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56724);
                    return 0;
                case 25:
                    c30202lu.pPw = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56724);
                    return 0;
                case 26:
                    c30202lu.vPw = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56724);
                    return 0;
                case 27:
                    c30202lu.vPx = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(56724);
                    return 0;
                case C31128d.MIC_BASE_CHANNELSHARPEN /*28*/:
                    c30202lu.vPy = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56724);
                    return 0;
                case 29:
                    c30202lu.vPz = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(56724);
                    return 0;
                default:
                    AppMethodBeat.m2505o(56724);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(56724);
            return -1;
        }
    }
}
