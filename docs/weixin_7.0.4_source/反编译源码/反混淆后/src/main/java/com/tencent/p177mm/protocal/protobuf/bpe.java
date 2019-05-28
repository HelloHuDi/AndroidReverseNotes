package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bpe */
public final class bpe extends C1331a {
    public String mZr;
    public int mZx;
    public String nad;
    public String ncH;
    public String vDk;
    public String vDl;
    public String vDm;
    public String vDn;
    public String vDo;
    public String vDp;
    public cyf vDq;
    public String vME;
    public int wHF;
    public LinkedList<bts> wRA = new LinkedList();
    public String wRB;
    public String wRC;
    public String wRD;
    public String wRE;
    public String wRF;
    public String wRG;
    public String wRH;
    public int wRI;
    public String wRx;
    public String wRy;
    public int wRz;

    public bpe() {
        AppMethodBeat.m2504i(80158);
        AppMethodBeat.m2505o(80158);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(80159);
        int f;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.mZr != null) {
                c6093a.mo13475e(1, this.mZr);
            }
            if (this.ncH != null) {
                c6093a.mo13475e(2, this.ncH);
            }
            if (this.vDm != null) {
                c6093a.mo13475e(3, this.vDm);
            }
            if (this.wRx != null) {
                c6093a.mo13475e(4, this.wRx);
            }
            if (this.vDl != null) {
                c6093a.mo13475e(5, this.vDl);
            }
            if (this.vDk != null) {
                c6093a.mo13475e(6, this.vDk);
            }
            if (this.wRy != null) {
                c6093a.mo13475e(7, this.wRy);
            }
            c6093a.mo13480iz(8, this.wRz);
            c6093a.mo13474e(9, 8, this.wRA);
            if (this.vDn != null) {
                c6093a.mo13475e(10, this.vDn);
            }
            if (this.wRB != null) {
                c6093a.mo13475e(11, this.wRB);
            }
            if (this.wRC != null) {
                c6093a.mo13475e(12, this.wRC);
            }
            c6093a.mo13480iz(13, this.wHF);
            if (this.vME != null) {
                c6093a.mo13475e(14, this.vME);
            }
            if (this.nad != null) {
                c6093a.mo13475e(15, this.nad);
            }
            if (this.vDo != null) {
                c6093a.mo13475e(16, this.vDo);
            }
            if (this.wRD != null) {
                c6093a.mo13475e(17, this.wRD);
            }
            if (this.wRE != null) {
                c6093a.mo13475e(18, this.wRE);
            }
            if (this.vDp != null) {
                c6093a.mo13475e(19, this.vDp);
            }
            if (this.wRF != null) {
                c6093a.mo13475e(20, this.wRF);
            }
            if (this.wRG != null) {
                c6093a.mo13475e(21, this.wRG);
            }
            if (this.vDq != null) {
                c6093a.mo13479iy(22, this.vDq.computeSize());
                this.vDq.writeFields(c6093a);
            }
            if (this.wRH != null) {
                c6093a.mo13475e(23, this.wRH);
            }
            c6093a.mo13480iz(24, this.wRI);
            c6093a.mo13480iz(25, this.mZx);
            AppMethodBeat.m2505o(80159);
            return 0;
        } else if (i == 1) {
            if (this.mZr != null) {
                f = C6091a.m9575f(1, this.mZr) + 0;
            } else {
                f = 0;
            }
            if (this.ncH != null) {
                f += C6091a.m9575f(2, this.ncH);
            }
            if (this.vDm != null) {
                f += C6091a.m9575f(3, this.vDm);
            }
            if (this.wRx != null) {
                f += C6091a.m9575f(4, this.wRx);
            }
            if (this.vDl != null) {
                f += C6091a.m9575f(5, this.vDl);
            }
            if (this.vDk != null) {
                f += C6091a.m9575f(6, this.vDk);
            }
            if (this.wRy != null) {
                f += C6091a.m9575f(7, this.wRy);
            }
            f = (f + C6091a.m9572bs(8, this.wRz)) + C6087a.m9552c(9, 8, this.wRA);
            if (this.vDn != null) {
                f += C6091a.m9575f(10, this.vDn);
            }
            if (this.wRB != null) {
                f += C6091a.m9575f(11, this.wRB);
            }
            if (this.wRC != null) {
                f += C6091a.m9575f(12, this.wRC);
            }
            f += C6091a.m9572bs(13, this.wHF);
            if (this.vME != null) {
                f += C6091a.m9575f(14, this.vME);
            }
            if (this.nad != null) {
                f += C6091a.m9575f(15, this.nad);
            }
            if (this.vDo != null) {
                f += C6091a.m9575f(16, this.vDo);
            }
            if (this.wRD != null) {
                f += C6091a.m9575f(17, this.wRD);
            }
            if (this.wRE != null) {
                f += C6091a.m9575f(18, this.wRE);
            }
            if (this.vDp != null) {
                f += C6091a.m9575f(19, this.vDp);
            }
            if (this.wRF != null) {
                f += C6091a.m9575f(20, this.wRF);
            }
            if (this.wRG != null) {
                f += C6091a.m9575f(21, this.wRG);
            }
            if (this.vDq != null) {
                f += C6087a.m9557ix(22, this.vDq.computeSize());
            }
            if (this.wRH != null) {
                f += C6091a.m9575f(23, this.wRH);
            }
            int bs = (f + C6091a.m9572bs(24, this.wRI)) + C6091a.m9572bs(25, this.mZx);
            AppMethodBeat.m2505o(80159);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wRA.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(80159);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bpe bpe = (bpe) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    bpe.mZr = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80159);
                    return 0;
                case 2:
                    bpe.ncH = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80159);
                    return 0;
                case 3:
                    bpe.vDm = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80159);
                    return 0;
                case 4:
                    bpe.wRx = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80159);
                    return 0;
                case 5:
                    bpe.vDl = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80159);
                    return 0;
                case 6:
                    bpe.vDk = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80159);
                    return 0;
                case 7:
                    bpe.wRy = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80159);
                    return 0;
                case 8:
                    bpe.wRz = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80159);
                    return 0;
                case 9:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts bts = new bts();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(c6086a3, bts, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bpe.wRA.add(bts);
                    }
                    AppMethodBeat.m2505o(80159);
                    return 0;
                case 10:
                    bpe.vDn = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80159);
                    return 0;
                case 11:
                    bpe.wRB = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80159);
                    return 0;
                case 12:
                    bpe.wRC = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80159);
                    return 0;
                case 13:
                    bpe.wHF = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80159);
                    return 0;
                case 14:
                    bpe.vME = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80159);
                    return 0;
                case 15:
                    bpe.nad = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80159);
                    return 0;
                case 16:
                    bpe.vDo = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80159);
                    return 0;
                case 17:
                    bpe.wRD = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80159);
                    return 0;
                case 18:
                    bpe.wRE = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80159);
                    return 0;
                case 19:
                    bpe.vDp = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80159);
                    return 0;
                case 20:
                    bpe.wRF = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80159);
                    return 0;
                case 21:
                    bpe.wRG = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80159);
                    return 0;
                case 22:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cyf cyf = new cyf();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cyf.populateBuilderWithField(c6086a3, cyf, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        bpe.vDq = cyf;
                    }
                    AppMethodBeat.m2505o(80159);
                    return 0;
                case 23:
                    bpe.wRH = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(80159);
                    return 0;
                case 24:
                    bpe.wRI = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80159);
                    return 0;
                case 25:
                    bpe.mZx = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(80159);
                    return 0;
                default:
                    AppMethodBeat.m2505o(80159);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(80159);
            return -1;
        }
    }
}
