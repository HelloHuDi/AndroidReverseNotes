package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class chn extends a {
    public String cIy;
    public int cdf;
    public String ctj;
    public String cvF;
    public String hlm;
    public String nQB;
    public int offset;
    public int sBd;
    public int scene;
    public LinkedList<tn> tZG = new LinkedList();
    public String tZP;
    public String url;
    public String xgj;
    public LinkedList<chu> xgk = new LinkedList();
    public int xgl;
    public String xgm;
    public String xgn;
    public String xgo;
    public LinkedList<String> xgp = new LinkedList();

    public chn() {
        AppMethodBeat.i(55702);
        AppMethodBeat.o(55702);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(55703);
        int f;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.hlm != null) {
                aVar.e(1, this.hlm);
            }
            if (this.cvF != null) {
                aVar.e(2, this.cvF);
            }
            if (this.cIy != null) {
                aVar.e(3, this.cIy);
            }
            aVar.iz(4, this.offset);
            if (this.ctj != null) {
                aVar.e(5, this.ctj);
            }
            aVar.iz(6, this.scene);
            if (this.url != null) {
                aVar.e(7, this.url);
            }
            if (this.nQB != null) {
                aVar.e(8, this.nQB);
            }
            aVar.e(9, 8, this.tZG);
            if (this.xgj != null) {
                aVar.e(10, this.xgj);
            }
            aVar.e(11, 8, this.xgk);
            aVar.iz(12, this.sBd);
            aVar.iz(13, this.cdf);
            if (this.tZP != null) {
                aVar.e(14, this.tZP);
            }
            aVar.iz(15, this.xgl);
            if (this.xgm != null) {
                aVar.e(16, this.xgm);
            }
            if (this.xgn != null) {
                aVar.e(17, this.xgn);
            }
            if (this.xgo != null) {
                aVar.e(18, this.xgo);
            }
            aVar.e(19, 1, this.xgp);
            AppMethodBeat.o(55703);
            return 0;
        } else if (i == 1) {
            if (this.hlm != null) {
                f = e.a.a.b.b.a.f(1, this.hlm) + 0;
            } else {
                f = 0;
            }
            if (this.cvF != null) {
                f += e.a.a.b.b.a.f(2, this.cvF);
            }
            if (this.cIy != null) {
                f += e.a.a.b.b.a.f(3, this.cIy);
            }
            f += e.a.a.b.b.a.bs(4, this.offset);
            if (this.ctj != null) {
                f += e.a.a.b.b.a.f(5, this.ctj);
            }
            f += e.a.a.b.b.a.bs(6, this.scene);
            if (this.url != null) {
                f += e.a.a.b.b.a.f(7, this.url);
            }
            if (this.nQB != null) {
                f += e.a.a.b.b.a.f(8, this.nQB);
            }
            f += e.a.a.a.c(9, 8, this.tZG);
            if (this.xgj != null) {
                f += e.a.a.b.b.a.f(10, this.xgj);
            }
            f = ((f + e.a.a.a.c(11, 8, this.xgk)) + e.a.a.b.b.a.bs(12, this.sBd)) + e.a.a.b.b.a.bs(13, this.cdf);
            if (this.tZP != null) {
                f += e.a.a.b.b.a.f(14, this.tZP);
            }
            f += e.a.a.b.b.a.bs(15, this.xgl);
            if (this.xgm != null) {
                f += e.a.a.b.b.a.f(16, this.xgm);
            }
            if (this.xgn != null) {
                f += e.a.a.b.b.a.f(17, this.xgn);
            }
            if (this.xgo != null) {
                f += e.a.a.b.b.a.f(18, this.xgo);
            }
            int c = f + e.a.a.a.c(19, 1, this.xgp);
            AppMethodBeat.o(55703);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.tZG.clear();
            this.xgk.clear();
            this.xgp.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(55703);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            chn chn = (chn) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    chn.hlm = aVar3.BTU.readString();
                    AppMethodBeat.o(55703);
                    return 0;
                case 2:
                    chn.cvF = aVar3.BTU.readString();
                    AppMethodBeat.o(55703);
                    return 0;
                case 3:
                    chn.cIy = aVar3.BTU.readString();
                    AppMethodBeat.o(55703);
                    return 0;
                case 4:
                    chn.offset = aVar3.BTU.vd();
                    AppMethodBeat.o(55703);
                    return 0;
                case 5:
                    chn.ctj = aVar3.BTU.readString();
                    AppMethodBeat.o(55703);
                    return 0;
                case 6:
                    chn.scene = aVar3.BTU.vd();
                    AppMethodBeat.o(55703);
                    return 0;
                case 7:
                    chn.url = aVar3.BTU.readString();
                    AppMethodBeat.o(55703);
                    return 0;
                case 8:
                    chn.nQB = aVar3.BTU.readString();
                    AppMethodBeat.o(55703);
                    return 0;
                case 9:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        tn tnVar = new tn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = tnVar.populateBuilderWithField(aVar4, tnVar, a.getNextFieldNumber(aVar4))) {
                        }
                        chn.tZG.add(tnVar);
                    }
                    AppMethodBeat.o(55703);
                    return 0;
                case 10:
                    chn.xgj = aVar3.BTU.readString();
                    AppMethodBeat.o(55703);
                    return 0;
                case 11:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        chu chu = new chu();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = chu.populateBuilderWithField(aVar4, chu, a.getNextFieldNumber(aVar4))) {
                        }
                        chn.xgk.add(chu);
                    }
                    AppMethodBeat.o(55703);
                    return 0;
                case 12:
                    chn.sBd = aVar3.BTU.vd();
                    AppMethodBeat.o(55703);
                    return 0;
                case 13:
                    chn.cdf = aVar3.BTU.vd();
                    AppMethodBeat.o(55703);
                    return 0;
                case 14:
                    chn.tZP = aVar3.BTU.readString();
                    AppMethodBeat.o(55703);
                    return 0;
                case 15:
                    chn.xgl = aVar3.BTU.vd();
                    AppMethodBeat.o(55703);
                    return 0;
                case 16:
                    chn.xgm = aVar3.BTU.readString();
                    AppMethodBeat.o(55703);
                    return 0;
                case 17:
                    chn.xgn = aVar3.BTU.readString();
                    AppMethodBeat.o(55703);
                    return 0;
                case 18:
                    chn.xgo = aVar3.BTU.readString();
                    AppMethodBeat.o(55703);
                    return 0;
                case 19:
                    chn.xgp.add(aVar3.BTU.readString());
                    AppMethodBeat.o(55703);
                    return 0;
                default:
                    AppMethodBeat.o(55703);
                    return -1;
            }
        } else {
            AppMethodBeat.o(55703);
            return -1;
        }
    }
}
