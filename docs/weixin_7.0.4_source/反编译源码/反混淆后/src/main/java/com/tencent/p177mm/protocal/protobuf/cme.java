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

/* renamed from: com.tencent.mm.protocal.protobuf.cme */
public final class cme extends C1331a {
    public String duq;
    public String guX;
    public int vCl;
    public ayj vEU;
    public btv vLP;
    public String vLf;
    public String vXm;
    public String vXn;
    public ccl wBZ;
    public String wGm;
    public String wGn;
    public int wPr;
    public int wlv;
    public String xjQ;
    public String xjR;
    public int xjS;
    public int xjT;
    public int xjU;
    public String xjV;
    public int xjW;
    public bts xjX;
    public int xjY;
    public String xjZ;
    public String xka;
    public String xkb;
    public String xkc;
    public String xkd;
    public bim xke;
    public String xkf;
    public int xkg;
    public long xkh;
    public String xki;
    public cfc xkj;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(123521);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.wBZ == null) {
                c6092b = new C6092b("Not all required fields were included: SnsUserInfo");
                AppMethodBeat.m2505o(123521);
                throw c6092b;
            }
            if (this.wBZ != null) {
                c6093a.mo13479iy(1, this.wBZ.computeSize());
                this.wBZ.writeFields(c6093a);
            }
            if (this.guX != null) {
                c6093a.mo13475e(2, this.guX);
            }
            if (this.xjQ != null) {
                c6093a.mo13475e(3, this.xjQ);
            }
            if (this.xjR != null) {
                c6093a.mo13475e(4, this.xjR);
            }
            c6093a.mo13480iz(5, this.xjS);
            c6093a.mo13480iz(6, this.xjT);
            c6093a.mo13480iz(7, this.xjU);
            if (this.xjV != null) {
                c6093a.mo13475e(8, this.xjV);
            }
            if (this.vXm != null) {
                c6093a.mo13475e(9, this.vXm);
            }
            if (this.vXn != null) {
                c6093a.mo13475e(10, this.vXn);
            }
            c6093a.mo13480iz(11, this.xjW);
            if (this.xjX != null) {
                c6093a.mo13479iy(12, this.xjX.computeSize());
                this.xjX.writeFields(c6093a);
            }
            if (this.vLP != null) {
                c6093a.mo13479iy(13, this.vLP.computeSize());
                this.vLP.writeFields(c6093a);
            }
            c6093a.mo13480iz(14, this.vCl);
            c6093a.mo13480iz(15, this.xjY);
            if (this.vLf != null) {
                c6093a.mo13475e(16, this.vLf);
            }
            if (this.wGm != null) {
                c6093a.mo13475e(17, this.wGm);
            }
            if (this.wGn != null) {
                c6093a.mo13475e(18, this.wGn);
            }
            if (this.xjZ != null) {
                c6093a.mo13475e(19, this.xjZ);
            }
            if (this.xka != null) {
                c6093a.mo13475e(20, this.xka);
            }
            if (this.xkb != null) {
                c6093a.mo13475e(21, this.xkb);
            }
            if (this.xkc != null) {
                c6093a.mo13475e(22, this.xkc);
            }
            if (this.vEU != null) {
                c6093a.mo13479iy(23, this.vEU.computeSize());
                this.vEU.writeFields(c6093a);
            }
            if (this.xkd != null) {
                c6093a.mo13475e(24, this.xkd);
            }
            if (this.xke != null) {
                c6093a.mo13479iy(25, this.xke.computeSize());
                this.xke.writeFields(c6093a);
            }
            if (this.xkf != null) {
                c6093a.mo13475e(26, this.xkf);
            }
            c6093a.mo13480iz(27, this.xkg);
            if (this.duq != null) {
                c6093a.mo13475e(28, this.duq);
            }
            c6093a.mo13480iz(29, this.wlv);
            c6093a.mo13472ai(30, this.xkh);
            if (this.xki != null) {
                c6093a.mo13475e(31, this.xki);
            }
            c6093a.mo13480iz(32, this.wPr);
            if (this.xkj != null) {
                c6093a.mo13479iy(33, this.xkj.computeSize());
                this.xkj.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(123521);
            return 0;
        } else if (i == 1) {
            if (this.wBZ != null) {
                ix = C6087a.m9557ix(1, this.wBZ.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.guX != null) {
                ix += C6091a.m9575f(2, this.guX);
            }
            if (this.xjQ != null) {
                ix += C6091a.m9575f(3, this.xjQ);
            }
            if (this.xjR != null) {
                ix += C6091a.m9575f(4, this.xjR);
            }
            ix = ((ix + C6091a.m9572bs(5, this.xjS)) + C6091a.m9572bs(6, this.xjT)) + C6091a.m9572bs(7, this.xjU);
            if (this.xjV != null) {
                ix += C6091a.m9575f(8, this.xjV);
            }
            if (this.vXm != null) {
                ix += C6091a.m9575f(9, this.vXm);
            }
            if (this.vXn != null) {
                ix += C6091a.m9575f(10, this.vXn);
            }
            ix += C6091a.m9572bs(11, this.xjW);
            if (this.xjX != null) {
                ix += C6087a.m9557ix(12, this.xjX.computeSize());
            }
            if (this.vLP != null) {
                ix += C6087a.m9557ix(13, this.vLP.computeSize());
            }
            ix = (ix + C6091a.m9572bs(14, this.vCl)) + C6091a.m9572bs(15, this.xjY);
            if (this.vLf != null) {
                ix += C6091a.m9575f(16, this.vLf);
            }
            if (this.wGm != null) {
                ix += C6091a.m9575f(17, this.wGm);
            }
            if (this.wGn != null) {
                ix += C6091a.m9575f(18, this.wGn);
            }
            if (this.xjZ != null) {
                ix += C6091a.m9575f(19, this.xjZ);
            }
            if (this.xka != null) {
                ix += C6091a.m9575f(20, this.xka);
            }
            if (this.xkb != null) {
                ix += C6091a.m9575f(21, this.xkb);
            }
            if (this.xkc != null) {
                ix += C6091a.m9575f(22, this.xkc);
            }
            if (this.vEU != null) {
                ix += C6087a.m9557ix(23, this.vEU.computeSize());
            }
            if (this.xkd != null) {
                ix += C6091a.m9575f(24, this.xkd);
            }
            if (this.xke != null) {
                ix += C6087a.m9557ix(25, this.xke.computeSize());
            }
            if (this.xkf != null) {
                ix += C6091a.m9575f(26, this.xkf);
            }
            ix += C6091a.m9572bs(27, this.xkg);
            if (this.duq != null) {
                ix += C6091a.m9575f(28, this.duq);
            }
            ix = (ix + C6091a.m9572bs(29, this.wlv)) + C6091a.m9578o(30, this.xkh);
            if (this.xki != null) {
                ix += C6091a.m9575f(31, this.xki);
            }
            ix += C6091a.m9572bs(32, this.wPr);
            if (this.xkj != null) {
                ix += C6087a.m9557ix(33, this.xkj.computeSize());
            }
            AppMethodBeat.m2505o(123521);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.wBZ == null) {
                c6092b = new C6092b("Not all required fields were included: SnsUserInfo");
                AppMethodBeat.m2505o(123521);
                throw c6092b;
            }
            AppMethodBeat.m2505o(123521);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cme cme = (cme) objArr[1];
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
                        ccl ccl = new ccl();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = ccl.populateBuilderWithField(c6086a3, ccl, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cme.wBZ = ccl;
                    }
                    AppMethodBeat.m2505o(123521);
                    return 0;
                case 2:
                    cme.guX = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(123521);
                    return 0;
                case 3:
                    cme.xjQ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(123521);
                    return 0;
                case 4:
                    cme.xjR = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(123521);
                    return 0;
                case 5:
                    cme.xjS = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(123521);
                    return 0;
                case 6:
                    cme.xjT = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(123521);
                    return 0;
                case 7:
                    cme.xjU = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(123521);
                    return 0;
                case 8:
                    cme.xjV = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(123521);
                    return 0;
                case 9:
                    cme.vXm = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(123521);
                    return 0;
                case 10:
                    cme.vXn = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(123521);
                    return 0;
                case 11:
                    cme.xjW = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(123521);
                    return 0;
                case 12:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts bts = new bts();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(c6086a3, bts, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cme.xjX = bts;
                    }
                    AppMethodBeat.m2505o(123521);
                    return 0;
                case 13:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        btv btv = new btv();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = btv.populateBuilderWithField(c6086a3, btv, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cme.vLP = btv;
                    }
                    AppMethodBeat.m2505o(123521);
                    return 0;
                case 14:
                    cme.vCl = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(123521);
                    return 0;
                case 15:
                    cme.xjY = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(123521);
                    return 0;
                case 16:
                    cme.vLf = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(123521);
                    return 0;
                case 17:
                    cme.wGm = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(123521);
                    return 0;
                case 18:
                    cme.wGn = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(123521);
                    return 0;
                case 19:
                    cme.xjZ = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(123521);
                    return 0;
                case 20:
                    cme.xka = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(123521);
                    return 0;
                case 21:
                    cme.xkb = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(123521);
                    return 0;
                case 22:
                    cme.xkc = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(123521);
                    return 0;
                case 23:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ayj ayj = new ayj();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = ayj.populateBuilderWithField(c6086a3, ayj, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cme.vEU = ayj;
                    }
                    AppMethodBeat.m2505o(123521);
                    return 0;
                case 24:
                    cme.xkd = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(123521);
                    return 0;
                case 25:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bim bim = new bim();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bim.populateBuilderWithField(c6086a3, bim, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cme.xke = bim;
                    }
                    AppMethodBeat.m2505o(123521);
                    return 0;
                case 26:
                    cme.xkf = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(123521);
                    return 0;
                case 27:
                    cme.xkg = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(123521);
                    return 0;
                case C31128d.MIC_BASE_CHANNELSHARPEN /*28*/:
                    cme.duq = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(123521);
                    return 0;
                case 29:
                    cme.wlv = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(123521);
                    return 0;
                case 30:
                    cme.xkh = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(123521);
                    return 0;
                case 31:
                    cme.xki = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(123521);
                    return 0;
                case 32:
                    cme.wPr = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(123521);
                    return 0;
                case 33:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cfc cfc = new cfc();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cfc.populateBuilderWithField(c6086a3, cfc, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cme.xkj = cfc;
                    }
                    AppMethodBeat.m2505o(123521);
                    return 0;
                default:
                    AppMethodBeat.m2505o(123521);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(123521);
            return -1;
        }
    }
}
