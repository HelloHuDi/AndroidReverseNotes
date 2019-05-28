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

/* renamed from: com.tencent.mm.protocal.protobuf.cpr */
public final class cpr extends C1331a {
    public int nwQ;
    public cpx xlM;
    public cpx xlN;
    public SKBuiltinBuffer_t xnA;
    public int xnB;
    public String xnC;
    public int xnD;
    public LinkedList<cps> xnE = new LinkedList();
    public int xnc;
    public cok xnd;
    public cok xne;
    public int xnf;
    public int xng;
    public int xnh;
    public int xni;
    public SKBuiltinBuffer_t xnj;
    public int xnk;
    public cok xnl;
    public int xnm;
    public int xnn;
    public int xno;
    public int xnp;
    public int xnq;
    public int xnr;
    public SKBuiltinBuffer_t xns;
    public SKBuiltinBuffer_t xnt;
    public int xnu;
    public SKBuiltinBuffer_t xnv;
    public int xnw;
    public int xnx;
    public int xny;
    public awi xnz;

    public cpr() {
        AppMethodBeat.m2504i(5253);
        AppMethodBeat.m2505o(5253);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(5254);
        C6092b c6092b;
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.xlM == null) {
                c6092b = new C6092b("Not all required fields were included: PeerId");
                AppMethodBeat.m2505o(5254);
                throw c6092b;
            } else if (this.xlN == null) {
                c6092b = new C6092b("Not all required fields were included: CapInfo");
                AppMethodBeat.m2505o(5254);
                throw c6092b;
            } else {
                if (this.xlM != null) {
                    c6093a.mo13479iy(1, this.xlM.computeSize());
                    this.xlM.writeFields(c6093a);
                }
                if (this.xlN != null) {
                    c6093a.mo13479iy(2, this.xlN.computeSize());
                    this.xlN.writeFields(c6093a);
                }
                c6093a.mo13480iz(3, this.xnc);
                if (this.xnd != null) {
                    c6093a.mo13479iy(4, this.xnd.computeSize());
                    this.xnd.writeFields(c6093a);
                }
                if (this.xne != null) {
                    c6093a.mo13479iy(5, this.xne.computeSize());
                    this.xne.writeFields(c6093a);
                }
                c6093a.mo13480iz(6, this.xnf);
                c6093a.mo13480iz(7, this.xng);
                c6093a.mo13480iz(8, this.xnh);
                c6093a.mo13480iz(9, this.xni);
                if (this.xnj != null) {
                    c6093a.mo13479iy(10, this.xnj.computeSize());
                    this.xnj.writeFields(c6093a);
                }
                c6093a.mo13480iz(11, this.xnk);
                if (this.xnl != null) {
                    c6093a.mo13479iy(12, this.xnl.computeSize());
                    this.xnl.writeFields(c6093a);
                }
                c6093a.mo13480iz(13, this.xnm);
                c6093a.mo13480iz(14, this.xnn);
                c6093a.mo13480iz(15, this.xno);
                c6093a.mo13480iz(16, this.xnp);
                c6093a.mo13480iz(17, this.xnq);
                c6093a.mo13480iz(18, this.nwQ);
                c6093a.mo13480iz(19, this.xnr);
                if (this.xns != null) {
                    c6093a.mo13479iy(20, this.xns.computeSize());
                    this.xns.writeFields(c6093a);
                }
                if (this.xnt != null) {
                    c6093a.mo13479iy(21, this.xnt.computeSize());
                    this.xnt.writeFields(c6093a);
                }
                c6093a.mo13480iz(22, this.xnu);
                if (this.xnv != null) {
                    c6093a.mo13479iy(23, this.xnv.computeSize());
                    this.xnv.writeFields(c6093a);
                }
                c6093a.mo13480iz(24, this.xnw);
                c6093a.mo13480iz(25, this.xnx);
                c6093a.mo13480iz(26, this.xny);
                if (this.xnz != null) {
                    c6093a.mo13479iy(27, this.xnz.computeSize());
                    this.xnz.writeFields(c6093a);
                }
                if (this.xnA != null) {
                    c6093a.mo13479iy(28, this.xnA.computeSize());
                    this.xnA.writeFields(c6093a);
                }
                c6093a.mo13480iz(29, this.xnB);
                if (this.xnC != null) {
                    c6093a.mo13475e(30, this.xnC);
                }
                c6093a.mo13480iz(31, this.xnD);
                c6093a.mo13474e(32, 8, this.xnE);
                AppMethodBeat.m2505o(5254);
                return 0;
            }
        } else if (i == 1) {
            if (this.xlM != null) {
                ix = C6087a.m9557ix(1, this.xlM.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.xlN != null) {
                ix += C6087a.m9557ix(2, this.xlN.computeSize());
            }
            ix += C6091a.m9572bs(3, this.xnc);
            if (this.xnd != null) {
                ix += C6087a.m9557ix(4, this.xnd.computeSize());
            }
            if (this.xne != null) {
                ix += C6087a.m9557ix(5, this.xne.computeSize());
            }
            ix = (((ix + C6091a.m9572bs(6, this.xnf)) + C6091a.m9572bs(7, this.xng)) + C6091a.m9572bs(8, this.xnh)) + C6091a.m9572bs(9, this.xni);
            if (this.xnj != null) {
                ix += C6087a.m9557ix(10, this.xnj.computeSize());
            }
            ix += C6091a.m9572bs(11, this.xnk);
            if (this.xnl != null) {
                ix += C6087a.m9557ix(12, this.xnl.computeSize());
            }
            ix = ((((((ix + C6091a.m9572bs(13, this.xnm)) + C6091a.m9572bs(14, this.xnn)) + C6091a.m9572bs(15, this.xno)) + C6091a.m9572bs(16, this.xnp)) + C6091a.m9572bs(17, this.xnq)) + C6091a.m9572bs(18, this.nwQ)) + C6091a.m9572bs(19, this.xnr);
            if (this.xns != null) {
                ix += C6087a.m9557ix(20, this.xns.computeSize());
            }
            if (this.xnt != null) {
                ix += C6087a.m9557ix(21, this.xnt.computeSize());
            }
            ix += C6091a.m9572bs(22, this.xnu);
            if (this.xnv != null) {
                ix += C6087a.m9557ix(23, this.xnv.computeSize());
            }
            ix = ((ix + C6091a.m9572bs(24, this.xnw)) + C6091a.m9572bs(25, this.xnx)) + C6091a.m9572bs(26, this.xny);
            if (this.xnz != null) {
                ix += C6087a.m9557ix(27, this.xnz.computeSize());
            }
            if (this.xnA != null) {
                ix += C6087a.m9557ix(28, this.xnA.computeSize());
            }
            ix += C6091a.m9572bs(29, this.xnB);
            if (this.xnC != null) {
                ix += C6091a.m9575f(30, this.xnC);
            }
            int bs = (ix + C6091a.m9572bs(31, this.xnD)) + C6087a.m9552c(32, 8, this.xnE);
            AppMethodBeat.m2505o(5254);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xnE.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.xlM == null) {
                c6092b = new C6092b("Not all required fields were included: PeerId");
                AppMethodBeat.m2505o(5254);
                throw c6092b;
            } else if (this.xlN == null) {
                c6092b = new C6092b("Not all required fields were included: CapInfo");
                AppMethodBeat.m2505o(5254);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(5254);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            cpr cpr = (cpr) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            cpx cpx;
            C6086a c6086a3;
            boolean z;
            cok cok;
            SKBuiltinBuffer_t sKBuiltinBuffer_t;
            switch (intValue) {
                case 1:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cpx = new cpx();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cpx.populateBuilderWithField(c6086a3, cpx, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cpr.xlM = cpx;
                    }
                    AppMethodBeat.m2505o(5254);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cpx = new cpx();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cpx.populateBuilderWithField(c6086a3, cpx, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cpr.xlN = cpx;
                    }
                    AppMethodBeat.m2505o(5254);
                    return 0;
                case 3:
                    cpr.xnc = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5254);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cok = new cok();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cok.populateBuilderWithField(c6086a3, cok, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cpr.xnd = cok;
                    }
                    AppMethodBeat.m2505o(5254);
                    return 0;
                case 5:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cok = new cok();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cok.populateBuilderWithField(c6086a3, cok, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cpr.xne = cok;
                    }
                    AppMethodBeat.m2505o(5254);
                    return 0;
                case 6:
                    cpr.xnf = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5254);
                    return 0;
                case 7:
                    cpr.xng = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5254);
                    return 0;
                case 8:
                    cpr.xnh = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5254);
                    return 0;
                case 9:
                    cpr.xni = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5254);
                    return 0;
                case 10:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cpr.xnj = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(5254);
                    return 0;
                case 11:
                    cpr.xnk = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5254);
                    return 0;
                case 12:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cok = new cok();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cok.populateBuilderWithField(c6086a3, cok, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cpr.xnl = cok;
                    }
                    AppMethodBeat.m2505o(5254);
                    return 0;
                case 13:
                    cpr.xnm = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5254);
                    return 0;
                case 14:
                    cpr.xnn = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5254);
                    return 0;
                case 15:
                    cpr.xno = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5254);
                    return 0;
                case 16:
                    cpr.xnp = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5254);
                    return 0;
                case 17:
                    cpr.xnq = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5254);
                    return 0;
                case 18:
                    cpr.nwQ = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5254);
                    return 0;
                case 19:
                    cpr.xnr = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5254);
                    return 0;
                case 20:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cpr.xns = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(5254);
                    return 0;
                case 21:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cpr.xnt = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(5254);
                    return 0;
                case 22:
                    cpr.xnu = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5254);
                    return 0;
                case 23:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cpr.xnv = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(5254);
                    return 0;
                case 24:
                    cpr.xnw = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5254);
                    return 0;
                case 25:
                    cpr.xnx = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5254);
                    return 0;
                case 26:
                    cpr.xny = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5254);
                    return 0;
                case 27:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        awi awi = new awi();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = awi.populateBuilderWithField(c6086a3, awi, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cpr.xnz = awi;
                    }
                    AppMethodBeat.m2505o(5254);
                    return 0;
                case C31128d.MIC_BASE_CHANNELSHARPEN /*28*/:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cpr.xnA = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(5254);
                    return 0;
                case 29:
                    cpr.xnB = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5254);
                    return 0;
                case 30:
                    cpr.xnC = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(5254);
                    return 0;
                case 31:
                    cpr.xnD = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(5254);
                    return 0;
                case 32:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cps cps = new cps();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = cps.populateBuilderWithField(c6086a3, cps, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        cpr.xnE.add(cps);
                    }
                    AppMethodBeat.m2505o(5254);
                    return 0;
                default:
                    AppMethodBeat.m2505o(5254);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(5254);
            return -1;
        }
    }
}
