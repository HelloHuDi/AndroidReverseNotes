package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.mm.plugin.appbrand.jsapi.e.g;
import com.tencent.view.d;
import java.util.LinkedList;

public final class k extends a {
    public int cRT;
    public int cRU;
    public int cRV;
    public long cSh;
    public int kCd;
    public String nSX;
    public String nSd;
    public int nUh;
    public String nUi;
    public String nUj;
    public String nUk;
    public String nWO;
    public String nWP;
    public String nWQ;
    public String nWR;
    public String nWS;
    public String nWT;
    public long nWU;
    public long nWV;
    public long nWW;
    public String nWX;
    public int nWY;
    public int nWZ;
    public int nXa;
    public String nXb;
    public int nXc;
    public e nXd;
    public LinkedList<as> nXe = new LinkedList();
    public as nXf;
    public String nXg;
    public String nXh;
    public int nXi;
    public LinkedList<w> nXj = new LinkedList();
    public String nXk;
    public String nXl;
    public int nXm;
    public String nXn;
    public String nXo;
    public int resourceId;

    public k() {
        AppMethodBeat.i(56610);
        AppMethodBeat.o(56610);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56611);
        int bs;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.cRT);
            aVar.iz(2, this.cRU);
            if (this.nWO != null) {
                aVar.e(3, this.nWO);
            }
            if (this.nWP != null) {
                aVar.e(4, this.nWP);
            }
            if (this.nSd != null) {
                aVar.e(5, this.nSd);
            }
            if (this.nWQ != null) {
                aVar.e(6, this.nWQ);
            }
            if (this.nWR != null) {
                aVar.e(7, this.nWR);
            }
            if (this.nSX != null) {
                aVar.e(8, this.nSX);
            }
            if (this.nWS != null) {
                aVar.e(9, this.nWS);
            }
            if (this.nWT != null) {
                aVar.e(10, this.nWT);
            }
            aVar.ai(11, this.cSh);
            aVar.ai(12, this.nWU);
            aVar.ai(13, this.nWV);
            aVar.iz(14, this.kCd);
            aVar.ai(15, this.nWW);
            if (this.nWX != null) {
                aVar.e(16, this.nWX);
            }
            aVar.iz(17, this.nWY);
            aVar.iz(18, this.nWZ);
            aVar.iz(19, this.nXa);
            if (this.nXb != null) {
                aVar.e(20, this.nXb);
            }
            aVar.iz(21, this.cRV);
            aVar.iz(22, this.nXc);
            if (this.nXd != null) {
                aVar.iy(23, this.nXd.computeSize());
                this.nXd.writeFields(aVar);
            }
            aVar.iz(24, this.nUh);
            if (this.nUj != null) {
                aVar.e(25, this.nUj);
            }
            aVar.e(26, 8, this.nXe);
            if (this.nXf != null) {
                aVar.iy(27, this.nXf.computeSize());
                this.nXf.writeFields(aVar);
            }
            if (this.nXg != null) {
                aVar.e(28, this.nXg);
            }
            if (this.nXh != null) {
                aVar.e(29, this.nXh);
            }
            aVar.iz(30, this.nXi);
            aVar.iz(31, this.resourceId);
            if (this.nUk != null) {
                aVar.e(32, this.nUk);
            }
            aVar.e(33, 8, this.nXj);
            if (this.nUi != null) {
                aVar.e(34, this.nUi);
            }
            if (this.nXk != null) {
                aVar.e(35, this.nXk);
            }
            if (this.nXl != null) {
                aVar.e(36, this.nXl);
            }
            aVar.iz(37, this.nXm);
            if (this.nXn != null) {
                aVar.e(38, this.nXn);
            }
            if (this.nXo != null) {
                aVar.e(39, this.nXo);
            }
            AppMethodBeat.o(56611);
            return 0;
        } else if (i == 1) {
            bs = (e.a.a.b.b.a.bs(1, this.cRT) + 0) + e.a.a.b.b.a.bs(2, this.cRU);
            if (this.nWO != null) {
                bs += e.a.a.b.b.a.f(3, this.nWO);
            }
            if (this.nWP != null) {
                bs += e.a.a.b.b.a.f(4, this.nWP);
            }
            if (this.nSd != null) {
                bs += e.a.a.b.b.a.f(5, this.nSd);
            }
            if (this.nWQ != null) {
                bs += e.a.a.b.b.a.f(6, this.nWQ);
            }
            if (this.nWR != null) {
                bs += e.a.a.b.b.a.f(7, this.nWR);
            }
            if (this.nSX != null) {
                bs += e.a.a.b.b.a.f(8, this.nSX);
            }
            if (this.nWS != null) {
                bs += e.a.a.b.b.a.f(9, this.nWS);
            }
            if (this.nWT != null) {
                bs += e.a.a.b.b.a.f(10, this.nWT);
            }
            bs = ((((bs + e.a.a.b.b.a.o(11, this.cSh)) + e.a.a.b.b.a.o(12, this.nWU)) + e.a.a.b.b.a.o(13, this.nWV)) + e.a.a.b.b.a.bs(14, this.kCd)) + e.a.a.b.b.a.o(15, this.nWW);
            if (this.nWX != null) {
                bs += e.a.a.b.b.a.f(16, this.nWX);
            }
            bs = ((bs + e.a.a.b.b.a.bs(17, this.nWY)) + e.a.a.b.b.a.bs(18, this.nWZ)) + e.a.a.b.b.a.bs(19, this.nXa);
            if (this.nXb != null) {
                bs += e.a.a.b.b.a.f(20, this.nXb);
            }
            bs = (bs + e.a.a.b.b.a.bs(21, this.cRV)) + e.a.a.b.b.a.bs(22, this.nXc);
            if (this.nXd != null) {
                bs += e.a.a.a.ix(23, this.nXd.computeSize());
            }
            bs += e.a.a.b.b.a.bs(24, this.nUh);
            if (this.nUj != null) {
                bs += e.a.a.b.b.a.f(25, this.nUj);
            }
            bs += e.a.a.a.c(26, 8, this.nXe);
            if (this.nXf != null) {
                bs += e.a.a.a.ix(27, this.nXf.computeSize());
            }
            if (this.nXg != null) {
                bs += e.a.a.b.b.a.f(28, this.nXg);
            }
            if (this.nXh != null) {
                bs += e.a.a.b.b.a.f(29, this.nXh);
            }
            bs = (bs + e.a.a.b.b.a.bs(30, this.nXi)) + e.a.a.b.b.a.bs(31, this.resourceId);
            if (this.nUk != null) {
                bs += e.a.a.b.b.a.f(32, this.nUk);
            }
            bs += e.a.a.a.c(33, 8, this.nXj);
            if (this.nUi != null) {
                bs += e.a.a.b.b.a.f(34, this.nUi);
            }
            if (this.nXk != null) {
                bs += e.a.a.b.b.a.f(35, this.nXk);
            }
            if (this.nXl != null) {
                bs += e.a.a.b.b.a.f(36, this.nXl);
            }
            bs += e.a.a.b.b.a.bs(37, this.nXm);
            if (this.nXn != null) {
                bs += e.a.a.b.b.a.f(38, this.nXn);
            }
            if (this.nXo != null) {
                bs += e.a.a.b.b.a.f(39, this.nXo);
            }
            AppMethodBeat.o(56611);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.nXe.clear();
            this.nXj.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56611);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            k kVar = (k) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            e.a.a.a.a aVar4;
            boolean z;
            as asVar;
            switch (intValue) {
                case 1:
                    kVar.cRT = aVar3.BTU.vd();
                    AppMethodBeat.o(56611);
                    return 0;
                case 2:
                    kVar.cRU = aVar3.BTU.vd();
                    AppMethodBeat.o(56611);
                    return 0;
                case 3:
                    kVar.nWO = aVar3.BTU.readString();
                    AppMethodBeat.o(56611);
                    return 0;
                case 4:
                    kVar.nWP = aVar3.BTU.readString();
                    AppMethodBeat.o(56611);
                    return 0;
                case 5:
                    kVar.nSd = aVar3.BTU.readString();
                    AppMethodBeat.o(56611);
                    return 0;
                case 6:
                    kVar.nWQ = aVar3.BTU.readString();
                    AppMethodBeat.o(56611);
                    return 0;
                case 7:
                    kVar.nWR = aVar3.BTU.readString();
                    AppMethodBeat.o(56611);
                    return 0;
                case 8:
                    kVar.nSX = aVar3.BTU.readString();
                    AppMethodBeat.o(56611);
                    return 0;
                case 9:
                    kVar.nWS = aVar3.BTU.readString();
                    AppMethodBeat.o(56611);
                    return 0;
                case 10:
                    kVar.nWT = aVar3.BTU.readString();
                    AppMethodBeat.o(56611);
                    return 0;
                case 11:
                    kVar.cSh = aVar3.BTU.ve();
                    AppMethodBeat.o(56611);
                    return 0;
                case 12:
                    kVar.nWU = aVar3.BTU.ve();
                    AppMethodBeat.o(56611);
                    return 0;
                case 13:
                    kVar.nWV = aVar3.BTU.ve();
                    AppMethodBeat.o(56611);
                    return 0;
                case 14:
                    kVar.kCd = aVar3.BTU.vd();
                    AppMethodBeat.o(56611);
                    return 0;
                case 15:
                    kVar.nWW = aVar3.BTU.ve();
                    AppMethodBeat.o(56611);
                    return 0;
                case 16:
                    kVar.nWX = aVar3.BTU.readString();
                    AppMethodBeat.o(56611);
                    return 0;
                case 17:
                    kVar.nWY = aVar3.BTU.vd();
                    AppMethodBeat.o(56611);
                    return 0;
                case 18:
                    kVar.nWZ = aVar3.BTU.vd();
                    AppMethodBeat.o(56611);
                    return 0;
                case 19:
                    kVar.nXa = aVar3.BTU.vd();
                    AppMethodBeat.o(56611);
                    return 0;
                case 20:
                    kVar.nXb = aVar3.BTU.readString();
                    AppMethodBeat.o(56611);
                    return 0;
                case 21:
                    kVar.cRV = aVar3.BTU.vd();
                    AppMethodBeat.o(56611);
                    return 0;
                case 22:
                    kVar.nXc = aVar3.BTU.vd();
                    AppMethodBeat.o(56611);
                    return 0;
                case 23:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        e eVar = new e();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eVar.populateBuilderWithField(aVar4, eVar, a.getNextFieldNumber(aVar4))) {
                        }
                        kVar.nXd = eVar;
                    }
                    AppMethodBeat.o(56611);
                    return 0;
                case 24:
                    kVar.nUh = aVar3.BTU.vd();
                    AppMethodBeat.o(56611);
                    return 0;
                case 25:
                    kVar.nUj = aVar3.BTU.readString();
                    AppMethodBeat.o(56611);
                    return 0;
                case 26:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        asVar = new as();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = asVar.populateBuilderWithField(aVar4, asVar, a.getNextFieldNumber(aVar4))) {
                        }
                        kVar.nXe.add(asVar);
                    }
                    AppMethodBeat.o(56611);
                    return 0;
                case 27:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        asVar = new as();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = asVar.populateBuilderWithField(aVar4, asVar, a.getNextFieldNumber(aVar4))) {
                        }
                        kVar.nXf = asVar;
                    }
                    AppMethodBeat.o(56611);
                    return 0;
                case d.MIC_BASE_CHANNELSHARPEN /*28*/:
                    kVar.nXg = aVar3.BTU.readString();
                    AppMethodBeat.o(56611);
                    return 0;
                case 29:
                    kVar.nXh = aVar3.BTU.readString();
                    AppMethodBeat.o(56611);
                    return 0;
                case 30:
                    kVar.nXi = aVar3.BTU.vd();
                    AppMethodBeat.o(56611);
                    return 0;
                case 31:
                    kVar.resourceId = aVar3.BTU.vd();
                    AppMethodBeat.o(56611);
                    return 0;
                case 32:
                    kVar.nUk = aVar3.BTU.readString();
                    AppMethodBeat.o(56611);
                    return 0;
                case 33:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        w wVar = new w();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = wVar.populateBuilderWithField(aVar4, wVar, a.getNextFieldNumber(aVar4))) {
                        }
                        kVar.nXj.add(wVar);
                    }
                    AppMethodBeat.o(56611);
                    return 0;
                case 34:
                    kVar.nUi = aVar3.BTU.readString();
                    AppMethodBeat.o(56611);
                    return 0;
                case 35:
                    kVar.nXk = aVar3.BTU.readString();
                    AppMethodBeat.o(56611);
                    return 0;
                case 36:
                    kVar.nXl = aVar3.BTU.readString();
                    AppMethodBeat.o(56611);
                    return 0;
                case g.CTRL_INDEX /*37*/:
                    kVar.nXm = aVar3.BTU.vd();
                    AppMethodBeat.o(56611);
                    return 0;
                case 38:
                    kVar.nXn = aVar3.BTU.readString();
                    AppMethodBeat.o(56611);
                    return 0;
                case 39:
                    kVar.nXo = aVar3.BTU.readString();
                    AppMethodBeat.o(56611);
                    return 0;
                default:
                    AppMethodBeat.o(56611);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56611);
            return -1;
        }
    }
}
