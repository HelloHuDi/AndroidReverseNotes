package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.nq */
public final class C7276nq extends C1331a {
    public String vCb;
    public String vSA;
    public String vSB;
    public String vSC;
    public LinkedList<C7275np> vSD = new LinkedList();
    public int vSE;
    public String vSF;
    public String vSG;
    public String vSH;
    public int vSI;
    public String vSJ;
    public int vSK;
    public String vSy;
    public String vSz;

    public C7276nq() {
        AppMethodBeat.m2504i(89022);
        AppMethodBeat.m2505o(89022);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(89023);
        int f;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vCb != null) {
                c6093a.mo13475e(1, this.vCb);
            }
            if (this.vSy != null) {
                c6093a.mo13475e(2, this.vSy);
            }
            if (this.vSz != null) {
                c6093a.mo13475e(3, this.vSz);
            }
            if (this.vSA != null) {
                c6093a.mo13475e(4, this.vSA);
            }
            if (this.vSB != null) {
                c6093a.mo13475e(5, this.vSB);
            }
            if (this.vSC != null) {
                c6093a.mo13475e(6, this.vSC);
            }
            c6093a.mo13474e(7, 8, this.vSD);
            c6093a.mo13480iz(8, this.vSE);
            if (this.vSF != null) {
                c6093a.mo13475e(9, this.vSF);
            }
            if (this.vSG != null) {
                c6093a.mo13475e(10, this.vSG);
            }
            if (this.vSH != null) {
                c6093a.mo13475e(11, this.vSH);
            }
            c6093a.mo13480iz(12, this.vSI);
            if (this.vSJ != null) {
                c6093a.mo13475e(13, this.vSJ);
            }
            c6093a.mo13480iz(14, this.vSK);
            AppMethodBeat.m2505o(89023);
            return 0;
        } else if (i == 1) {
            if (this.vCb != null) {
                f = C6091a.m9575f(1, this.vCb) + 0;
            } else {
                f = 0;
            }
            if (this.vSy != null) {
                f += C6091a.m9575f(2, this.vSy);
            }
            if (this.vSz != null) {
                f += C6091a.m9575f(3, this.vSz);
            }
            if (this.vSA != null) {
                f += C6091a.m9575f(4, this.vSA);
            }
            if (this.vSB != null) {
                f += C6091a.m9575f(5, this.vSB);
            }
            if (this.vSC != null) {
                f += C6091a.m9575f(6, this.vSC);
            }
            f = (f + C6087a.m9552c(7, 8, this.vSD)) + C6091a.m9572bs(8, this.vSE);
            if (this.vSF != null) {
                f += C6091a.m9575f(9, this.vSF);
            }
            if (this.vSG != null) {
                f += C6091a.m9575f(10, this.vSG);
            }
            if (this.vSH != null) {
                f += C6091a.m9575f(11, this.vSH);
            }
            f += C6091a.m9572bs(12, this.vSI);
            if (this.vSJ != null) {
                f += C6091a.m9575f(13, this.vSJ);
            }
            int bs = f + C6091a.m9572bs(14, this.vSK);
            AppMethodBeat.m2505o(89023);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vSD.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(89023);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C7276nq c7276nq = (C7276nq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    c7276nq.vCb = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89023);
                    return 0;
                case 2:
                    c7276nq.vSy = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89023);
                    return 0;
                case 3:
                    c7276nq.vSz = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89023);
                    return 0;
                case 4:
                    c7276nq.vSA = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89023);
                    return 0;
                case 5:
                    c7276nq.vSB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89023);
                    return 0;
                case 6:
                    c7276nq.vSC = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89023);
                    return 0;
                case 7:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C7275np c7275np = new C7275np();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = c7275np.populateBuilderWithField(c6086a3, c7275np, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c7276nq.vSD.add(c7275np);
                    }
                    AppMethodBeat.m2505o(89023);
                    return 0;
                case 8:
                    c7276nq.vSE = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(89023);
                    return 0;
                case 9:
                    c7276nq.vSF = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89023);
                    return 0;
                case 10:
                    c7276nq.vSG = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89023);
                    return 0;
                case 11:
                    c7276nq.vSH = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89023);
                    return 0;
                case 12:
                    c7276nq.vSI = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(89023);
                    return 0;
                case 13:
                    c7276nq.vSJ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(89023);
                    return 0;
                case 14:
                    c7276nq.vSK = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(89023);
                    return 0;
                default:
                    AppMethodBeat.m2505o(89023);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(89023);
            return -1;
        }
    }
}
