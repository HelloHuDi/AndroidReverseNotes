package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.mm.plugin.appbrand.jsapi.e.g;
import com.tencent.view.d;
import java.util.LinkedList;

public final class chw extends a {
    public long ctk;
    public boolean cui;
    public int fgI;
    public int fgJ;
    public String lvA;
    public String lvz;
    public String phw;
    public String qVw;
    public String source;
    public long timestamp;
    public String title;
    public String uaf;
    public String uag;
    public String uah;
    public String uai;
    public String uaj;
    public String ubA;
    public String videoUrl;
    public int voe;
    public LinkedList<bzs> wiH = new LinkedList();
    public String xgQ;
    public int xgR;
    public String xgS;
    public long xgT;
    public String xgU;
    public String xgV;
    public int xgW;
    public String xgX;
    public String xgY;
    public long xgZ;
    public long xha;
    public LinkedList<chy> xhb = new LinkedList();
    public LinkedList<abz> xhc = new LinkedList();
    public int xhd;
    public long xhe;
    public int xhf;
    public int xhg;
    public boolean xhh;
    public String xhi;

    public chw() {
        AppMethodBeat.i(55710);
        AppMethodBeat.o(55710);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(55711);
        int f;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.e(1, this.title);
            }
            if (this.videoUrl != null) {
                aVar.e(2, this.videoUrl);
            }
            if (this.xgQ != null) {
                aVar.e(3, this.xgQ);
            }
            aVar.iz(4, this.xgR);
            if (this.xgS != null) {
                aVar.e(5, this.xgS);
            }
            aVar.iz(6, this.fgJ);
            aVar.iz(7, this.fgI);
            if (this.lvz != null) {
                aVar.e(8, this.lvz);
            }
            if (this.lvA != null) {
                aVar.e(9, this.lvA);
            }
            if (this.qVw != null) {
                aVar.e(10, this.qVw);
            }
            if (this.uaf != null) {
                aVar.e(11, this.uaf);
            }
            if (this.uag != null) {
                aVar.e(12, this.uag);
            }
            if (this.uah != null) {
                aVar.e(13, this.uah);
            }
            if (this.source != null) {
                aVar.e(14, this.source);
            }
            if (this.phw != null) {
                aVar.e(15, this.phw);
            }
            aVar.ai(16, this.xgT);
            if (this.xgU != null) {
                aVar.e(17, this.xgU);
            }
            if (this.xgV != null) {
                aVar.e(18, this.xgV);
            }
            if (this.uai != null) {
                aVar.e(19, this.uai);
            }
            if (this.uaj != null) {
                aVar.e(20, this.uaj);
            }
            aVar.iz(21, this.xgW);
            if (this.xgX != null) {
                aVar.e(22, this.xgX);
            }
            if (this.xgY != null) {
                aVar.e(23, this.xgY);
            }
            aVar.e(24, 8, this.wiH);
            aVar.ai(25, this.timestamp);
            aVar.aO(26, this.cui);
            if (this.ubA != null) {
                aVar.e(27, this.ubA);
            }
            aVar.ai(28, this.xgZ);
            aVar.ai(29, this.ctk);
            aVar.ai(30, this.xha);
            aVar.e(31, 8, this.xhb);
            aVar.e(32, 8, this.xhc);
            aVar.iz(33, this.xhd);
            aVar.ai(34, this.xhe);
            aVar.iz(35, this.xhf);
            aVar.iz(36, this.voe);
            aVar.iz(37, this.xhg);
            aVar.aO(38, this.xhh);
            if (this.xhi != null) {
                aVar.e(39, this.xhi);
            }
            AppMethodBeat.o(55711);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                f = e.a.a.b.b.a.f(1, this.title) + 0;
            } else {
                f = 0;
            }
            if (this.videoUrl != null) {
                f += e.a.a.b.b.a.f(2, this.videoUrl);
            }
            if (this.xgQ != null) {
                f += e.a.a.b.b.a.f(3, this.xgQ);
            }
            f += e.a.a.b.b.a.bs(4, this.xgR);
            if (this.xgS != null) {
                f += e.a.a.b.b.a.f(5, this.xgS);
            }
            f = (f + e.a.a.b.b.a.bs(6, this.fgJ)) + e.a.a.b.b.a.bs(7, this.fgI);
            if (this.lvz != null) {
                f += e.a.a.b.b.a.f(8, this.lvz);
            }
            if (this.lvA != null) {
                f += e.a.a.b.b.a.f(9, this.lvA);
            }
            if (this.qVw != null) {
                f += e.a.a.b.b.a.f(10, this.qVw);
            }
            if (this.uaf != null) {
                f += e.a.a.b.b.a.f(11, this.uaf);
            }
            if (this.uag != null) {
                f += e.a.a.b.b.a.f(12, this.uag);
            }
            if (this.uah != null) {
                f += e.a.a.b.b.a.f(13, this.uah);
            }
            if (this.source != null) {
                f += e.a.a.b.b.a.f(14, this.source);
            }
            if (this.phw != null) {
                f += e.a.a.b.b.a.f(15, this.phw);
            }
            f += e.a.a.b.b.a.o(16, this.xgT);
            if (this.xgU != null) {
                f += e.a.a.b.b.a.f(17, this.xgU);
            }
            if (this.xgV != null) {
                f += e.a.a.b.b.a.f(18, this.xgV);
            }
            if (this.uai != null) {
                f += e.a.a.b.b.a.f(19, this.uai);
            }
            if (this.uaj != null) {
                f += e.a.a.b.b.a.f(20, this.uaj);
            }
            f += e.a.a.b.b.a.bs(21, this.xgW);
            if (this.xgX != null) {
                f += e.a.a.b.b.a.f(22, this.xgX);
            }
            if (this.xgY != null) {
                f += e.a.a.b.b.a.f(23, this.xgY);
            }
            f = ((f + e.a.a.a.c(24, 8, this.wiH)) + e.a.a.b.b.a.o(25, this.timestamp)) + (e.a.a.b.b.a.fv(26) + 1);
            if (this.ubA != null) {
                f += e.a.a.b.b.a.f(27, this.ubA);
            }
            f = ((((((((((f + e.a.a.b.b.a.o(28, this.xgZ)) + e.a.a.b.b.a.o(29, this.ctk)) + e.a.a.b.b.a.o(30, this.xha)) + e.a.a.a.c(31, 8, this.xhb)) + e.a.a.a.c(32, 8, this.xhc)) + e.a.a.b.b.a.bs(33, this.xhd)) + e.a.a.b.b.a.o(34, this.xhe)) + e.a.a.b.b.a.bs(35, this.xhf)) + e.a.a.b.b.a.bs(36, this.voe)) + e.a.a.b.b.a.bs(37, this.xhg)) + (e.a.a.b.b.a.fv(38) + 1);
            if (this.xhi != null) {
                f += e.a.a.b.b.a.f(39, this.xhi);
            }
            AppMethodBeat.o(55711);
            return f;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wiH.clear();
            this.xhb.clear();
            this.xhc.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(55711);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            chw chw = (chw) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    chw.title = aVar3.BTU.readString();
                    AppMethodBeat.o(55711);
                    return 0;
                case 2:
                    chw.videoUrl = aVar3.BTU.readString();
                    AppMethodBeat.o(55711);
                    return 0;
                case 3:
                    chw.xgQ = aVar3.BTU.readString();
                    AppMethodBeat.o(55711);
                    return 0;
                case 4:
                    chw.xgR = aVar3.BTU.vd();
                    AppMethodBeat.o(55711);
                    return 0;
                case 5:
                    chw.xgS = aVar3.BTU.readString();
                    AppMethodBeat.o(55711);
                    return 0;
                case 6:
                    chw.fgJ = aVar3.BTU.vd();
                    AppMethodBeat.o(55711);
                    return 0;
                case 7:
                    chw.fgI = aVar3.BTU.vd();
                    AppMethodBeat.o(55711);
                    return 0;
                case 8:
                    chw.lvz = aVar3.BTU.readString();
                    AppMethodBeat.o(55711);
                    return 0;
                case 9:
                    chw.lvA = aVar3.BTU.readString();
                    AppMethodBeat.o(55711);
                    return 0;
                case 10:
                    chw.qVw = aVar3.BTU.readString();
                    AppMethodBeat.o(55711);
                    return 0;
                case 11:
                    chw.uaf = aVar3.BTU.readString();
                    AppMethodBeat.o(55711);
                    return 0;
                case 12:
                    chw.uag = aVar3.BTU.readString();
                    AppMethodBeat.o(55711);
                    return 0;
                case 13:
                    chw.uah = aVar3.BTU.readString();
                    AppMethodBeat.o(55711);
                    return 0;
                case 14:
                    chw.source = aVar3.BTU.readString();
                    AppMethodBeat.o(55711);
                    return 0;
                case 15:
                    chw.phw = aVar3.BTU.readString();
                    AppMethodBeat.o(55711);
                    return 0;
                case 16:
                    chw.xgT = aVar3.BTU.ve();
                    AppMethodBeat.o(55711);
                    return 0;
                case 17:
                    chw.xgU = aVar3.BTU.readString();
                    AppMethodBeat.o(55711);
                    return 0;
                case 18:
                    chw.xgV = aVar3.BTU.readString();
                    AppMethodBeat.o(55711);
                    return 0;
                case 19:
                    chw.uai = aVar3.BTU.readString();
                    AppMethodBeat.o(55711);
                    return 0;
                case 20:
                    chw.uaj = aVar3.BTU.readString();
                    AppMethodBeat.o(55711);
                    return 0;
                case 21:
                    chw.xgW = aVar3.BTU.vd();
                    AppMethodBeat.o(55711);
                    return 0;
                case 22:
                    chw.xgX = aVar3.BTU.readString();
                    AppMethodBeat.o(55711);
                    return 0;
                case 23:
                    chw.xgY = aVar3.BTU.readString();
                    AppMethodBeat.o(55711);
                    return 0;
                case 24:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bzs bzs = new bzs();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bzs.populateBuilderWithField(aVar4, bzs, a.getNextFieldNumber(aVar4))) {
                        }
                        chw.wiH.add(bzs);
                    }
                    AppMethodBeat.o(55711);
                    return 0;
                case 25:
                    chw.timestamp = aVar3.BTU.ve();
                    AppMethodBeat.o(55711);
                    return 0;
                case 26:
                    chw.cui = aVar3.BTU.ehX();
                    AppMethodBeat.o(55711);
                    return 0;
                case 27:
                    chw.ubA = aVar3.BTU.readString();
                    AppMethodBeat.o(55711);
                    return 0;
                case d.MIC_BASE_CHANNELSHARPEN /*28*/:
                    chw.xgZ = aVar3.BTU.ve();
                    AppMethodBeat.o(55711);
                    return 0;
                case 29:
                    chw.ctk = aVar3.BTU.ve();
                    AppMethodBeat.o(55711);
                    return 0;
                case 30:
                    chw.xha = aVar3.BTU.ve();
                    AppMethodBeat.o(55711);
                    return 0;
                case 31:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        chy chy = new chy();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = chy.populateBuilderWithField(aVar4, chy, a.getNextFieldNumber(aVar4))) {
                        }
                        chw.xhb.add(chy);
                    }
                    AppMethodBeat.o(55711);
                    return 0;
                case 32:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        abz abz = new abz();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = abz.populateBuilderWithField(aVar4, abz, a.getNextFieldNumber(aVar4))) {
                        }
                        chw.xhc.add(abz);
                    }
                    AppMethodBeat.o(55711);
                    return 0;
                case 33:
                    chw.xhd = aVar3.BTU.vd();
                    AppMethodBeat.o(55711);
                    return 0;
                case 34:
                    chw.xhe = aVar3.BTU.ve();
                    AppMethodBeat.o(55711);
                    return 0;
                case 35:
                    chw.xhf = aVar3.BTU.vd();
                    AppMethodBeat.o(55711);
                    return 0;
                case 36:
                    chw.voe = aVar3.BTU.vd();
                    AppMethodBeat.o(55711);
                    return 0;
                case g.CTRL_INDEX /*37*/:
                    chw.xhg = aVar3.BTU.vd();
                    AppMethodBeat.o(55711);
                    return 0;
                case 38:
                    chw.xhh = aVar3.BTU.ehX();
                    AppMethodBeat.o(55711);
                    return 0;
                case 39:
                    chw.xhi = aVar3.BTU.readString();
                    AppMethodBeat.o(55711);
                    return 0;
                default:
                    AppMethodBeat.o(55711);
                    return -1;
            }
        } else {
            AppMethodBeat.o(55711);
            return -1;
        }
    }
}
