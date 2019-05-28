package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.view.d;
import e.a.a.b;
import java.util.LinkedList;

public final class cme extends a {
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

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(123521);
        b bVar;
        int ix;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wBZ == null) {
                bVar = new b("Not all required fields were included: SnsUserInfo");
                AppMethodBeat.o(123521);
                throw bVar;
            }
            if (this.wBZ != null) {
                aVar.iy(1, this.wBZ.computeSize());
                this.wBZ.writeFields(aVar);
            }
            if (this.guX != null) {
                aVar.e(2, this.guX);
            }
            if (this.xjQ != null) {
                aVar.e(3, this.xjQ);
            }
            if (this.xjR != null) {
                aVar.e(4, this.xjR);
            }
            aVar.iz(5, this.xjS);
            aVar.iz(6, this.xjT);
            aVar.iz(7, this.xjU);
            if (this.xjV != null) {
                aVar.e(8, this.xjV);
            }
            if (this.vXm != null) {
                aVar.e(9, this.vXm);
            }
            if (this.vXn != null) {
                aVar.e(10, this.vXn);
            }
            aVar.iz(11, this.xjW);
            if (this.xjX != null) {
                aVar.iy(12, this.xjX.computeSize());
                this.xjX.writeFields(aVar);
            }
            if (this.vLP != null) {
                aVar.iy(13, this.vLP.computeSize());
                this.vLP.writeFields(aVar);
            }
            aVar.iz(14, this.vCl);
            aVar.iz(15, this.xjY);
            if (this.vLf != null) {
                aVar.e(16, this.vLf);
            }
            if (this.wGm != null) {
                aVar.e(17, this.wGm);
            }
            if (this.wGn != null) {
                aVar.e(18, this.wGn);
            }
            if (this.xjZ != null) {
                aVar.e(19, this.xjZ);
            }
            if (this.xka != null) {
                aVar.e(20, this.xka);
            }
            if (this.xkb != null) {
                aVar.e(21, this.xkb);
            }
            if (this.xkc != null) {
                aVar.e(22, this.xkc);
            }
            if (this.vEU != null) {
                aVar.iy(23, this.vEU.computeSize());
                this.vEU.writeFields(aVar);
            }
            if (this.xkd != null) {
                aVar.e(24, this.xkd);
            }
            if (this.xke != null) {
                aVar.iy(25, this.xke.computeSize());
                this.xke.writeFields(aVar);
            }
            if (this.xkf != null) {
                aVar.e(26, this.xkf);
            }
            aVar.iz(27, this.xkg);
            if (this.duq != null) {
                aVar.e(28, this.duq);
            }
            aVar.iz(29, this.wlv);
            aVar.ai(30, this.xkh);
            if (this.xki != null) {
                aVar.e(31, this.xki);
            }
            aVar.iz(32, this.wPr);
            if (this.xkj != null) {
                aVar.iy(33, this.xkj.computeSize());
                this.xkj.writeFields(aVar);
            }
            AppMethodBeat.o(123521);
            return 0;
        } else if (i == 1) {
            if (this.wBZ != null) {
                ix = e.a.a.a.ix(1, this.wBZ.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.guX != null) {
                ix += e.a.a.b.b.a.f(2, this.guX);
            }
            if (this.xjQ != null) {
                ix += e.a.a.b.b.a.f(3, this.xjQ);
            }
            if (this.xjR != null) {
                ix += e.a.a.b.b.a.f(4, this.xjR);
            }
            ix = ((ix + e.a.a.b.b.a.bs(5, this.xjS)) + e.a.a.b.b.a.bs(6, this.xjT)) + e.a.a.b.b.a.bs(7, this.xjU);
            if (this.xjV != null) {
                ix += e.a.a.b.b.a.f(8, this.xjV);
            }
            if (this.vXm != null) {
                ix += e.a.a.b.b.a.f(9, this.vXm);
            }
            if (this.vXn != null) {
                ix += e.a.a.b.b.a.f(10, this.vXn);
            }
            ix += e.a.a.b.b.a.bs(11, this.xjW);
            if (this.xjX != null) {
                ix += e.a.a.a.ix(12, this.xjX.computeSize());
            }
            if (this.vLP != null) {
                ix += e.a.a.a.ix(13, this.vLP.computeSize());
            }
            ix = (ix + e.a.a.b.b.a.bs(14, this.vCl)) + e.a.a.b.b.a.bs(15, this.xjY);
            if (this.vLf != null) {
                ix += e.a.a.b.b.a.f(16, this.vLf);
            }
            if (this.wGm != null) {
                ix += e.a.a.b.b.a.f(17, this.wGm);
            }
            if (this.wGn != null) {
                ix += e.a.a.b.b.a.f(18, this.wGn);
            }
            if (this.xjZ != null) {
                ix += e.a.a.b.b.a.f(19, this.xjZ);
            }
            if (this.xka != null) {
                ix += e.a.a.b.b.a.f(20, this.xka);
            }
            if (this.xkb != null) {
                ix += e.a.a.b.b.a.f(21, this.xkb);
            }
            if (this.xkc != null) {
                ix += e.a.a.b.b.a.f(22, this.xkc);
            }
            if (this.vEU != null) {
                ix += e.a.a.a.ix(23, this.vEU.computeSize());
            }
            if (this.xkd != null) {
                ix += e.a.a.b.b.a.f(24, this.xkd);
            }
            if (this.xke != null) {
                ix += e.a.a.a.ix(25, this.xke.computeSize());
            }
            if (this.xkf != null) {
                ix += e.a.a.b.b.a.f(26, this.xkf);
            }
            ix += e.a.a.b.b.a.bs(27, this.xkg);
            if (this.duq != null) {
                ix += e.a.a.b.b.a.f(28, this.duq);
            }
            ix = (ix + e.a.a.b.b.a.bs(29, this.wlv)) + e.a.a.b.b.a.o(30, this.xkh);
            if (this.xki != null) {
                ix += e.a.a.b.b.a.f(31, this.xki);
            }
            ix += e.a.a.b.b.a.bs(32, this.wPr);
            if (this.xkj != null) {
                ix += e.a.a.a.ix(33, this.xkj.computeSize());
            }
            AppMethodBeat.o(123521);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.wBZ == null) {
                bVar = new b("Not all required fields were included: SnsUserInfo");
                AppMethodBeat.o(123521);
                throw bVar;
            }
            AppMethodBeat.o(123521);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cme cme = (cme) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ccl ccl = new ccl();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ccl.populateBuilderWithField(aVar4, ccl, a.getNextFieldNumber(aVar4))) {
                        }
                        cme.wBZ = ccl;
                    }
                    AppMethodBeat.o(123521);
                    return 0;
                case 2:
                    cme.guX = aVar3.BTU.readString();
                    AppMethodBeat.o(123521);
                    return 0;
                case 3:
                    cme.xjQ = aVar3.BTU.readString();
                    AppMethodBeat.o(123521);
                    return 0;
                case 4:
                    cme.xjR = aVar3.BTU.readString();
                    AppMethodBeat.o(123521);
                    return 0;
                case 5:
                    cme.xjS = aVar3.BTU.vd();
                    AppMethodBeat.o(123521);
                    return 0;
                case 6:
                    cme.xjT = aVar3.BTU.vd();
                    AppMethodBeat.o(123521);
                    return 0;
                case 7:
                    cme.xjU = aVar3.BTU.vd();
                    AppMethodBeat.o(123521);
                    return 0;
                case 8:
                    cme.xjV = aVar3.BTU.readString();
                    AppMethodBeat.o(123521);
                    return 0;
                case 9:
                    cme.vXm = aVar3.BTU.readString();
                    AppMethodBeat.o(123521);
                    return 0;
                case 10:
                    cme.vXn = aVar3.BTU.readString();
                    AppMethodBeat.o(123521);
                    return 0;
                case 11:
                    cme.xjW = aVar3.BTU.vd();
                    AppMethodBeat.o(123521);
                    return 0;
                case 12:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, a.getNextFieldNumber(aVar4))) {
                        }
                        cme.xjX = bts;
                    }
                    AppMethodBeat.o(123521);
                    return 0;
                case 13:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        btv btv = new btv();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = btv.populateBuilderWithField(aVar4, btv, a.getNextFieldNumber(aVar4))) {
                        }
                        cme.vLP = btv;
                    }
                    AppMethodBeat.o(123521);
                    return 0;
                case 14:
                    cme.vCl = aVar3.BTU.vd();
                    AppMethodBeat.o(123521);
                    return 0;
                case 15:
                    cme.xjY = aVar3.BTU.vd();
                    AppMethodBeat.o(123521);
                    return 0;
                case 16:
                    cme.vLf = aVar3.BTU.readString();
                    AppMethodBeat.o(123521);
                    return 0;
                case 17:
                    cme.wGm = aVar3.BTU.readString();
                    AppMethodBeat.o(123521);
                    return 0;
                case 18:
                    cme.wGn = aVar3.BTU.readString();
                    AppMethodBeat.o(123521);
                    return 0;
                case 19:
                    cme.xjZ = aVar3.BTU.readString();
                    AppMethodBeat.o(123521);
                    return 0;
                case 20:
                    cme.xka = aVar3.BTU.readString();
                    AppMethodBeat.o(123521);
                    return 0;
                case 21:
                    cme.xkb = aVar3.BTU.readString();
                    AppMethodBeat.o(123521);
                    return 0;
                case 22:
                    cme.xkc = aVar3.BTU.readString();
                    AppMethodBeat.o(123521);
                    return 0;
                case 23:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ayj ayj = new ayj();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ayj.populateBuilderWithField(aVar4, ayj, a.getNextFieldNumber(aVar4))) {
                        }
                        cme.vEU = ayj;
                    }
                    AppMethodBeat.o(123521);
                    return 0;
                case 24:
                    cme.xkd = aVar3.BTU.readString();
                    AppMethodBeat.o(123521);
                    return 0;
                case 25:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bim bim = new bim();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bim.populateBuilderWithField(aVar4, bim, a.getNextFieldNumber(aVar4))) {
                        }
                        cme.xke = bim;
                    }
                    AppMethodBeat.o(123521);
                    return 0;
                case 26:
                    cme.xkf = aVar3.BTU.readString();
                    AppMethodBeat.o(123521);
                    return 0;
                case 27:
                    cme.xkg = aVar3.BTU.vd();
                    AppMethodBeat.o(123521);
                    return 0;
                case d.MIC_BASE_CHANNELSHARPEN /*28*/:
                    cme.duq = aVar3.BTU.readString();
                    AppMethodBeat.o(123521);
                    return 0;
                case 29:
                    cme.wlv = aVar3.BTU.vd();
                    AppMethodBeat.o(123521);
                    return 0;
                case 30:
                    cme.xkh = aVar3.BTU.ve();
                    AppMethodBeat.o(123521);
                    return 0;
                case 31:
                    cme.xki = aVar3.BTU.readString();
                    AppMethodBeat.o(123521);
                    return 0;
                case 32:
                    cme.wPr = aVar3.BTU.vd();
                    AppMethodBeat.o(123521);
                    return 0;
                case 33:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cfc cfc = new cfc();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cfc.populateBuilderWithField(aVar4, cfc, a.getNextFieldNumber(aVar4))) {
                        }
                        cme.xkj = cfc;
                    }
                    AppMethodBeat.o(123521);
                    return 0;
                default:
                    AppMethodBeat.o(123521);
                    return -1;
            }
        } else {
            AppMethodBeat.o(123521);
            return -1;
        }
    }
}
