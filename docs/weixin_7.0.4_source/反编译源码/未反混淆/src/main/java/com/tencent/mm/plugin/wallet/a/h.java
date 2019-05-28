package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class h extends a {
    public double tmR;
    public double tmS;
    public double tmT;
    public String tmU;
    public LinkedList<t> tmV = new LinkedList();
    public i tmW;
    public int tmX;
    public String tmY;
    public String tmZ;
    public double tna;
    public double tnb;
    public int tnc;
    public String tnd;
    public String tne;
    public a tnf;
    public LinkedList<g> tng = new LinkedList();
    public b tnh;

    public h() {
        AppMethodBeat.i(56649);
        AppMethodBeat.o(56649);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56650);
        int fv;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.f(1, this.tmR);
            aVar.f(2, this.tmS);
            aVar.f(3, this.tmT);
            if (this.tmU != null) {
                aVar.e(4, this.tmU);
            }
            aVar.e(5, 8, this.tmV);
            if (this.tmW != null) {
                aVar.iy(6, this.tmW.computeSize());
                this.tmW.writeFields(aVar);
            }
            aVar.iz(7, this.tmX);
            if (this.tmY != null) {
                aVar.e(8, this.tmY);
            }
            if (this.tmZ != null) {
                aVar.e(9, this.tmZ);
            }
            aVar.f(10, this.tna);
            aVar.f(11, this.tnb);
            aVar.iz(12, this.tnc);
            if (this.tnd != null) {
                aVar.e(13, this.tnd);
            }
            if (this.tne != null) {
                aVar.e(14, this.tne);
            }
            if (this.tnf != null) {
                aVar.iy(15, this.tnf.computeSize());
                this.tnf.writeFields(aVar);
            }
            aVar.e(16, 8, this.tng);
            if (this.tnh != null) {
                aVar.iy(17, this.tnh.computeSize());
                this.tnh.writeFields(aVar);
            }
            AppMethodBeat.o(56650);
            return 0;
        } else if (i == 1) {
            fv = (((e.a.a.b.b.a.fv(1) + 8) + 0) + (e.a.a.b.b.a.fv(2) + 8)) + (e.a.a.b.b.a.fv(3) + 8);
            if (this.tmU != null) {
                fv += e.a.a.b.b.a.f(4, this.tmU);
            }
            fv += e.a.a.a.c(5, 8, this.tmV);
            if (this.tmW != null) {
                fv += e.a.a.a.ix(6, this.tmW.computeSize());
            }
            fv += e.a.a.b.b.a.bs(7, this.tmX);
            if (this.tmY != null) {
                fv += e.a.a.b.b.a.f(8, this.tmY);
            }
            if (this.tmZ != null) {
                fv += e.a.a.b.b.a.f(9, this.tmZ);
            }
            fv = ((fv + (e.a.a.b.b.a.fv(10) + 8)) + (e.a.a.b.b.a.fv(11) + 8)) + e.a.a.b.b.a.bs(12, this.tnc);
            if (this.tnd != null) {
                fv += e.a.a.b.b.a.f(13, this.tnd);
            }
            if (this.tne != null) {
                fv += e.a.a.b.b.a.f(14, this.tne);
            }
            if (this.tnf != null) {
                fv += e.a.a.a.ix(15, this.tnf.computeSize());
            }
            fv += e.a.a.a.c(16, 8, this.tng);
            if (this.tnh != null) {
                fv += e.a.a.a.ix(17, this.tnh.computeSize());
            }
            AppMethodBeat.o(56650);
            return fv;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.tmV.clear();
            this.tng.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (fv = a.getNextFieldNumber(aVar2); fv > 0; fv = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, fv)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56650);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            h hVar = (h) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    hVar.tmR = Double.longBitsToDouble(aVar3.BTU.eib());
                    AppMethodBeat.o(56650);
                    return 0;
                case 2:
                    hVar.tmS = Double.longBitsToDouble(aVar3.BTU.eib());
                    AppMethodBeat.o(56650);
                    return 0;
                case 3:
                    hVar.tmT = Double.longBitsToDouble(aVar3.BTU.eib());
                    AppMethodBeat.o(56650);
                    return 0;
                case 4:
                    hVar.tmU = aVar3.BTU.readString();
                    AppMethodBeat.o(56650);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        t tVar = new t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = tVar.populateBuilderWithField(aVar4, tVar, a.getNextFieldNumber(aVar4))) {
                        }
                        hVar.tmV.add(tVar);
                    }
                    AppMethodBeat.o(56650);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        i iVar = new i();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = iVar.populateBuilderWithField(aVar4, iVar, a.getNextFieldNumber(aVar4))) {
                        }
                        hVar.tmW = iVar;
                    }
                    AppMethodBeat.o(56650);
                    return 0;
                case 7:
                    hVar.tmX = aVar3.BTU.vd();
                    AppMethodBeat.o(56650);
                    return 0;
                case 8:
                    hVar.tmY = aVar3.BTU.readString();
                    AppMethodBeat.o(56650);
                    return 0;
                case 9:
                    hVar.tmZ = aVar3.BTU.readString();
                    AppMethodBeat.o(56650);
                    return 0;
                case 10:
                    hVar.tna = Double.longBitsToDouble(aVar3.BTU.eib());
                    AppMethodBeat.o(56650);
                    return 0;
                case 11:
                    hVar.tnb = Double.longBitsToDouble(aVar3.BTU.eib());
                    AppMethodBeat.o(56650);
                    return 0;
                case 12:
                    hVar.tnc = aVar3.BTU.vd();
                    AppMethodBeat.o(56650);
                    return 0;
                case 13:
                    hVar.tnd = aVar3.BTU.readString();
                    AppMethodBeat.o(56650);
                    return 0;
                case 14:
                    hVar.tne = aVar3.BTU.readString();
                    AppMethodBeat.o(56650);
                    return 0;
                case 15:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        a aVar5 = new a();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aVar5.populateBuilderWithField(aVar4, aVar5, a.getNextFieldNumber(aVar4))) {
                        }
                        hVar.tnf = aVar5;
                    }
                    AppMethodBeat.o(56650);
                    return 0;
                case 16:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        g gVar = new g();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = gVar.populateBuilderWithField(aVar4, gVar, a.getNextFieldNumber(aVar4))) {
                        }
                        hVar.tng.add(gVar);
                    }
                    AppMethodBeat.o(56650);
                    return 0;
                case 17:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        b bVar = new b();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bVar.populateBuilderWithField(aVar4, bVar, a.getNextFieldNumber(aVar4))) {
                        }
                        hVar.tnh = bVar;
                    }
                    AppMethodBeat.o(56650);
                    return 0;
                default:
                    AppMethodBeat.o(56650);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56650);
            return -1;
        }
    }
}
