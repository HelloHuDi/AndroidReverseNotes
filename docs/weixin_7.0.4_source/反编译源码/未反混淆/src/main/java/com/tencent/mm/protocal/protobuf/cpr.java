package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.view.d;
import e.a.a.b;
import java.util.LinkedList;

public final class cpr extends a {
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
        AppMethodBeat.i(5253);
        AppMethodBeat.o(5253);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(5254);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.xlM == null) {
                bVar = new b("Not all required fields were included: PeerId");
                AppMethodBeat.o(5254);
                throw bVar;
            } else if (this.xlN == null) {
                bVar = new b("Not all required fields were included: CapInfo");
                AppMethodBeat.o(5254);
                throw bVar;
            } else {
                if (this.xlM != null) {
                    aVar.iy(1, this.xlM.computeSize());
                    this.xlM.writeFields(aVar);
                }
                if (this.xlN != null) {
                    aVar.iy(2, this.xlN.computeSize());
                    this.xlN.writeFields(aVar);
                }
                aVar.iz(3, this.xnc);
                if (this.xnd != null) {
                    aVar.iy(4, this.xnd.computeSize());
                    this.xnd.writeFields(aVar);
                }
                if (this.xne != null) {
                    aVar.iy(5, this.xne.computeSize());
                    this.xne.writeFields(aVar);
                }
                aVar.iz(6, this.xnf);
                aVar.iz(7, this.xng);
                aVar.iz(8, this.xnh);
                aVar.iz(9, this.xni);
                if (this.xnj != null) {
                    aVar.iy(10, this.xnj.computeSize());
                    this.xnj.writeFields(aVar);
                }
                aVar.iz(11, this.xnk);
                if (this.xnl != null) {
                    aVar.iy(12, this.xnl.computeSize());
                    this.xnl.writeFields(aVar);
                }
                aVar.iz(13, this.xnm);
                aVar.iz(14, this.xnn);
                aVar.iz(15, this.xno);
                aVar.iz(16, this.xnp);
                aVar.iz(17, this.xnq);
                aVar.iz(18, this.nwQ);
                aVar.iz(19, this.xnr);
                if (this.xns != null) {
                    aVar.iy(20, this.xns.computeSize());
                    this.xns.writeFields(aVar);
                }
                if (this.xnt != null) {
                    aVar.iy(21, this.xnt.computeSize());
                    this.xnt.writeFields(aVar);
                }
                aVar.iz(22, this.xnu);
                if (this.xnv != null) {
                    aVar.iy(23, this.xnv.computeSize());
                    this.xnv.writeFields(aVar);
                }
                aVar.iz(24, this.xnw);
                aVar.iz(25, this.xnx);
                aVar.iz(26, this.xny);
                if (this.xnz != null) {
                    aVar.iy(27, this.xnz.computeSize());
                    this.xnz.writeFields(aVar);
                }
                if (this.xnA != null) {
                    aVar.iy(28, this.xnA.computeSize());
                    this.xnA.writeFields(aVar);
                }
                aVar.iz(29, this.xnB);
                if (this.xnC != null) {
                    aVar.e(30, this.xnC);
                }
                aVar.iz(31, this.xnD);
                aVar.e(32, 8, this.xnE);
                AppMethodBeat.o(5254);
                return 0;
            }
        } else if (i == 1) {
            if (this.xlM != null) {
                ix = e.a.a.a.ix(1, this.xlM.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.xlN != null) {
                ix += e.a.a.a.ix(2, this.xlN.computeSize());
            }
            ix += e.a.a.b.b.a.bs(3, this.xnc);
            if (this.xnd != null) {
                ix += e.a.a.a.ix(4, this.xnd.computeSize());
            }
            if (this.xne != null) {
                ix += e.a.a.a.ix(5, this.xne.computeSize());
            }
            ix = (((ix + e.a.a.b.b.a.bs(6, this.xnf)) + e.a.a.b.b.a.bs(7, this.xng)) + e.a.a.b.b.a.bs(8, this.xnh)) + e.a.a.b.b.a.bs(9, this.xni);
            if (this.xnj != null) {
                ix += e.a.a.a.ix(10, this.xnj.computeSize());
            }
            ix += e.a.a.b.b.a.bs(11, this.xnk);
            if (this.xnl != null) {
                ix += e.a.a.a.ix(12, this.xnl.computeSize());
            }
            ix = ((((((ix + e.a.a.b.b.a.bs(13, this.xnm)) + e.a.a.b.b.a.bs(14, this.xnn)) + e.a.a.b.b.a.bs(15, this.xno)) + e.a.a.b.b.a.bs(16, this.xnp)) + e.a.a.b.b.a.bs(17, this.xnq)) + e.a.a.b.b.a.bs(18, this.nwQ)) + e.a.a.b.b.a.bs(19, this.xnr);
            if (this.xns != null) {
                ix += e.a.a.a.ix(20, this.xns.computeSize());
            }
            if (this.xnt != null) {
                ix += e.a.a.a.ix(21, this.xnt.computeSize());
            }
            ix += e.a.a.b.b.a.bs(22, this.xnu);
            if (this.xnv != null) {
                ix += e.a.a.a.ix(23, this.xnv.computeSize());
            }
            ix = ((ix + e.a.a.b.b.a.bs(24, this.xnw)) + e.a.a.b.b.a.bs(25, this.xnx)) + e.a.a.b.b.a.bs(26, this.xny);
            if (this.xnz != null) {
                ix += e.a.a.a.ix(27, this.xnz.computeSize());
            }
            if (this.xnA != null) {
                ix += e.a.a.a.ix(28, this.xnA.computeSize());
            }
            ix += e.a.a.b.b.a.bs(29, this.xnB);
            if (this.xnC != null) {
                ix += e.a.a.b.b.a.f(30, this.xnC);
            }
            int bs = (ix + e.a.a.b.b.a.bs(31, this.xnD)) + e.a.a.a.c(32, 8, this.xnE);
            AppMethodBeat.o(5254);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xnE.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.xlM == null) {
                bVar = new b("Not all required fields were included: PeerId");
                AppMethodBeat.o(5254);
                throw bVar;
            } else if (this.xlN == null) {
                bVar = new b("Not all required fields were included: CapInfo");
                AppMethodBeat.o(5254);
                throw bVar;
            } else {
                AppMethodBeat.o(5254);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cpr cpr = (cpr) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            cpx cpx;
            e.a.a.a.a aVar4;
            boolean z;
            cok cok;
            SKBuiltinBuffer_t sKBuiltinBuffer_t;
            switch (intValue) {
                case 1:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cpx = new cpx();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cpx.populateBuilderWithField(aVar4, cpx, a.getNextFieldNumber(aVar4))) {
                        }
                        cpr.xlM = cpx;
                    }
                    AppMethodBeat.o(5254);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cpx = new cpx();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cpx.populateBuilderWithField(aVar4, cpx, a.getNextFieldNumber(aVar4))) {
                        }
                        cpr.xlN = cpx;
                    }
                    AppMethodBeat.o(5254);
                    return 0;
                case 3:
                    cpr.xnc = aVar3.BTU.vd();
                    AppMethodBeat.o(5254);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cok = new cok();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cok.populateBuilderWithField(aVar4, cok, a.getNextFieldNumber(aVar4))) {
                        }
                        cpr.xnd = cok;
                    }
                    AppMethodBeat.o(5254);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cok = new cok();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cok.populateBuilderWithField(aVar4, cok, a.getNextFieldNumber(aVar4))) {
                        }
                        cpr.xne = cok;
                    }
                    AppMethodBeat.o(5254);
                    return 0;
                case 6:
                    cpr.xnf = aVar3.BTU.vd();
                    AppMethodBeat.o(5254);
                    return 0;
                case 7:
                    cpr.xng = aVar3.BTU.vd();
                    AppMethodBeat.o(5254);
                    return 0;
                case 8:
                    cpr.xnh = aVar3.BTU.vd();
                    AppMethodBeat.o(5254);
                    return 0;
                case 9:
                    cpr.xni = aVar3.BTU.vd();
                    AppMethodBeat.o(5254);
                    return 0;
                case 10:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        cpr.xnj = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(5254);
                    return 0;
                case 11:
                    cpr.xnk = aVar3.BTU.vd();
                    AppMethodBeat.o(5254);
                    return 0;
                case 12:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cok = new cok();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cok.populateBuilderWithField(aVar4, cok, a.getNextFieldNumber(aVar4))) {
                        }
                        cpr.xnl = cok;
                    }
                    AppMethodBeat.o(5254);
                    return 0;
                case 13:
                    cpr.xnm = aVar3.BTU.vd();
                    AppMethodBeat.o(5254);
                    return 0;
                case 14:
                    cpr.xnn = aVar3.BTU.vd();
                    AppMethodBeat.o(5254);
                    return 0;
                case 15:
                    cpr.xno = aVar3.BTU.vd();
                    AppMethodBeat.o(5254);
                    return 0;
                case 16:
                    cpr.xnp = aVar3.BTU.vd();
                    AppMethodBeat.o(5254);
                    return 0;
                case 17:
                    cpr.xnq = aVar3.BTU.vd();
                    AppMethodBeat.o(5254);
                    return 0;
                case 18:
                    cpr.nwQ = aVar3.BTU.vd();
                    AppMethodBeat.o(5254);
                    return 0;
                case 19:
                    cpr.xnr = aVar3.BTU.vd();
                    AppMethodBeat.o(5254);
                    return 0;
                case 20:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        cpr.xns = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(5254);
                    return 0;
                case 21:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        cpr.xnt = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(5254);
                    return 0;
                case 22:
                    cpr.xnu = aVar3.BTU.vd();
                    AppMethodBeat.o(5254);
                    return 0;
                case 23:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        cpr.xnv = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(5254);
                    return 0;
                case 24:
                    cpr.xnw = aVar3.BTU.vd();
                    AppMethodBeat.o(5254);
                    return 0;
                case 25:
                    cpr.xnx = aVar3.BTU.vd();
                    AppMethodBeat.o(5254);
                    return 0;
                case 26:
                    cpr.xny = aVar3.BTU.vd();
                    AppMethodBeat.o(5254);
                    return 0;
                case 27:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        awi awi = new awi();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = awi.populateBuilderWithField(aVar4, awi, a.getNextFieldNumber(aVar4))) {
                        }
                        cpr.xnz = awi;
                    }
                    AppMethodBeat.o(5254);
                    return 0;
                case d.MIC_BASE_CHANNELSHARPEN /*28*/:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        cpr.xnA = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(5254);
                    return 0;
                case 29:
                    cpr.xnB = aVar3.BTU.vd();
                    AppMethodBeat.o(5254);
                    return 0;
                case 30:
                    cpr.xnC = aVar3.BTU.readString();
                    AppMethodBeat.o(5254);
                    return 0;
                case 31:
                    cpr.xnD = aVar3.BTU.vd();
                    AppMethodBeat.o(5254);
                    return 0;
                case 32:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cps cps = new cps();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cps.populateBuilderWithField(aVar4, cps, a.getNextFieldNumber(aVar4))) {
                        }
                        cpr.xnE.add(cps);
                    }
                    AppMethodBeat.o(5254);
                    return 0;
                default:
                    AppMethodBeat.o(5254);
                    return -1;
            }
        } else {
            AppMethodBeat.o(5254);
            return -1;
        }
    }
}
