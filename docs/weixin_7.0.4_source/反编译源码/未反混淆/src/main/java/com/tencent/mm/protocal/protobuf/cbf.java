package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.view.d;
import e.a.a.b;
import java.util.LinkedList;

public final class cbf extends a {
    public int pcX;
    public LinkedList<cba> vFk = new LinkedList();
    public String vHl;
    public long vQE;
    public String wCW;
    public LinkedList<bts> wFp = new LinkedList();
    public int wGu;
    public int wGz;
    public int wHG;
    public int wZH;
    public int xaA;
    public LinkedList<bts> xaB = new LinkedList();
    public int xaC;
    public SKBuiltinBuffer_t xaD;
    public cbu xaE;
    public bld xaF;
    public cap xaG;
    public SKBuiltinBuffer_t xam;
    public int xan;
    public int xao;
    public int xap;
    public LinkedList<cat> xaq = new LinkedList();
    public int xar;
    public int xas;
    public LinkedList<cat> xat = new LinkedList();
    public int xau;
    public int xav;
    public LinkedList<cat> xaw = new LinkedList();
    public int xax;
    public String xay;
    public long xaz;

    public cbf() {
        AppMethodBeat.i(94581);
        AppMethodBeat.o(94581);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(94582);
        b bVar;
        int o;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.xam == null) {
                bVar = new b("Not all required fields were included: ObjectDesc");
                AppMethodBeat.o(94582);
                throw bVar;
            }
            aVar.ai(1, this.vQE);
            if (this.vHl != null) {
                aVar.e(2, this.vHl);
            }
            if (this.wCW != null) {
                aVar.e(3, this.wCW);
            }
            aVar.iz(4, this.pcX);
            if (this.xam != null) {
                aVar.iy(5, this.xam.computeSize());
                this.xam.writeFields(aVar);
            }
            aVar.iz(6, this.xan);
            aVar.iz(7, this.xao);
            aVar.iz(8, this.xap);
            aVar.e(9, 8, this.xaq);
            aVar.iz(10, this.xar);
            aVar.iz(11, this.xas);
            aVar.e(12, 8, this.xat);
            aVar.iz(13, this.xau);
            aVar.iz(14, this.xav);
            aVar.e(15, 8, this.xaw);
            aVar.iz(16, this.wGz);
            aVar.iz(17, this.xax);
            aVar.iz(18, this.wHG);
            aVar.e(19, 8, this.vFk);
            aVar.iz(20, this.wZH);
            if (this.xay != null) {
                aVar.e(21, this.xay);
            }
            aVar.ai(22, this.xaz);
            aVar.iz(23, this.xaA);
            aVar.e(24, 8, this.xaB);
            aVar.iz(25, this.wGu);
            aVar.iz(26, this.xaC);
            aVar.e(27, 8, this.wFp);
            if (this.xaD != null) {
                aVar.iy(28, this.xaD.computeSize());
                this.xaD.writeFields(aVar);
            }
            if (this.xaE != null) {
                aVar.iy(29, this.xaE.computeSize());
                this.xaE.writeFields(aVar);
            }
            if (this.xaF != null) {
                aVar.iy(30, this.xaF.computeSize());
                this.xaF.writeFields(aVar);
            }
            if (this.xaG != null) {
                aVar.iy(31, this.xaG.computeSize());
                this.xaG.writeFields(aVar);
            }
            AppMethodBeat.o(94582);
            return 0;
        } else if (i == 1) {
            o = e.a.a.b.b.a.o(1, this.vQE) + 0;
            if (this.vHl != null) {
                o += e.a.a.b.b.a.f(2, this.vHl);
            }
            if (this.wCW != null) {
                o += e.a.a.b.b.a.f(3, this.wCW);
            }
            o += e.a.a.b.b.a.bs(4, this.pcX);
            if (this.xam != null) {
                o += e.a.a.a.ix(5, this.xam.computeSize());
            }
            o = ((((((((((((((o + e.a.a.b.b.a.bs(6, this.xan)) + e.a.a.b.b.a.bs(7, this.xao)) + e.a.a.b.b.a.bs(8, this.xap)) + e.a.a.a.c(9, 8, this.xaq)) + e.a.a.b.b.a.bs(10, this.xar)) + e.a.a.b.b.a.bs(11, this.xas)) + e.a.a.a.c(12, 8, this.xat)) + e.a.a.b.b.a.bs(13, this.xau)) + e.a.a.b.b.a.bs(14, this.xav)) + e.a.a.a.c(15, 8, this.xaw)) + e.a.a.b.b.a.bs(16, this.wGz)) + e.a.a.b.b.a.bs(17, this.xax)) + e.a.a.b.b.a.bs(18, this.wHG)) + e.a.a.a.c(19, 8, this.vFk)) + e.a.a.b.b.a.bs(20, this.wZH);
            if (this.xay != null) {
                o += e.a.a.b.b.a.f(21, this.xay);
            }
            o = (((((o + e.a.a.b.b.a.o(22, this.xaz)) + e.a.a.b.b.a.bs(23, this.xaA)) + e.a.a.a.c(24, 8, this.xaB)) + e.a.a.b.b.a.bs(25, this.wGu)) + e.a.a.b.b.a.bs(26, this.xaC)) + e.a.a.a.c(27, 8, this.wFp);
            if (this.xaD != null) {
                o += e.a.a.a.ix(28, this.xaD.computeSize());
            }
            if (this.xaE != null) {
                o += e.a.a.a.ix(29, this.xaE.computeSize());
            }
            if (this.xaF != null) {
                o += e.a.a.a.ix(30, this.xaF.computeSize());
            }
            if (this.xaG != null) {
                o += e.a.a.a.ix(31, this.xaG.computeSize());
            }
            AppMethodBeat.o(94582);
            return o;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xaq.clear();
            this.xat.clear();
            this.xaw.clear();
            this.vFk.clear();
            this.xaB.clear();
            this.wFp.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (o = a.getNextFieldNumber(aVar2); o > 0; o = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, o)) {
                    aVar2.ems();
                }
            }
            if (this.xam == null) {
                bVar = new b("Not all required fields were included: ObjectDesc");
                AppMethodBeat.o(94582);
                throw bVar;
            }
            AppMethodBeat.o(94582);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cbf cbf = (cbf) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            SKBuiltinBuffer_t sKBuiltinBuffer_t;
            e.a.a.a.a aVar4;
            boolean z;
            cat cat;
            bts bts;
            switch (intValue) {
                case 1:
                    cbf.vQE = aVar3.BTU.ve();
                    AppMethodBeat.o(94582);
                    return 0;
                case 2:
                    cbf.vHl = aVar3.BTU.readString();
                    AppMethodBeat.o(94582);
                    return 0;
                case 3:
                    cbf.wCW = aVar3.BTU.readString();
                    AppMethodBeat.o(94582);
                    return 0;
                case 4:
                    cbf.pcX = aVar3.BTU.vd();
                    AppMethodBeat.o(94582);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        cbf.xam = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(94582);
                    return 0;
                case 6:
                    cbf.xan = aVar3.BTU.vd();
                    AppMethodBeat.o(94582);
                    return 0;
                case 7:
                    cbf.xao = aVar3.BTU.vd();
                    AppMethodBeat.o(94582);
                    return 0;
                case 8:
                    cbf.xap = aVar3.BTU.vd();
                    AppMethodBeat.o(94582);
                    return 0;
                case 9:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cat = new cat();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cat.populateBuilderWithField(aVar4, cat, a.getNextFieldNumber(aVar4))) {
                        }
                        cbf.xaq.add(cat);
                    }
                    AppMethodBeat.o(94582);
                    return 0;
                case 10:
                    cbf.xar = aVar3.BTU.vd();
                    AppMethodBeat.o(94582);
                    return 0;
                case 11:
                    cbf.xas = aVar3.BTU.vd();
                    AppMethodBeat.o(94582);
                    return 0;
                case 12:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cat = new cat();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cat.populateBuilderWithField(aVar4, cat, a.getNextFieldNumber(aVar4))) {
                        }
                        cbf.xat.add(cat);
                    }
                    AppMethodBeat.o(94582);
                    return 0;
                case 13:
                    cbf.xau = aVar3.BTU.vd();
                    AppMethodBeat.o(94582);
                    return 0;
                case 14:
                    cbf.xav = aVar3.BTU.vd();
                    AppMethodBeat.o(94582);
                    return 0;
                case 15:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cat = new cat();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cat.populateBuilderWithField(aVar4, cat, a.getNextFieldNumber(aVar4))) {
                        }
                        cbf.xaw.add(cat);
                    }
                    AppMethodBeat.o(94582);
                    return 0;
                case 16:
                    cbf.wGz = aVar3.BTU.vd();
                    AppMethodBeat.o(94582);
                    return 0;
                case 17:
                    cbf.xax = aVar3.BTU.vd();
                    AppMethodBeat.o(94582);
                    return 0;
                case 18:
                    cbf.wHG = aVar3.BTU.vd();
                    AppMethodBeat.o(94582);
                    return 0;
                case 19:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cba cba = new cba();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cba.populateBuilderWithField(aVar4, cba, a.getNextFieldNumber(aVar4))) {
                        }
                        cbf.vFk.add(cba);
                    }
                    AppMethodBeat.o(94582);
                    return 0;
                case 20:
                    cbf.wZH = aVar3.BTU.vd();
                    AppMethodBeat.o(94582);
                    return 0;
                case 21:
                    cbf.xay = aVar3.BTU.readString();
                    AppMethodBeat.o(94582);
                    return 0;
                case 22:
                    cbf.xaz = aVar3.BTU.ve();
                    AppMethodBeat.o(94582);
                    return 0;
                case 23:
                    cbf.xaA = aVar3.BTU.vd();
                    AppMethodBeat.o(94582);
                    return 0;
                case 24:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, a.getNextFieldNumber(aVar4))) {
                        }
                        cbf.xaB.add(bts);
                    }
                    AppMethodBeat.o(94582);
                    return 0;
                case 25:
                    cbf.wGu = aVar3.BTU.vd();
                    AppMethodBeat.o(94582);
                    return 0;
                case 26:
                    cbf.xaC = aVar3.BTU.vd();
                    AppMethodBeat.o(94582);
                    return 0;
                case 27:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, a.getNextFieldNumber(aVar4))) {
                        }
                        cbf.wFp.add(bts);
                    }
                    AppMethodBeat.o(94582);
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
                        cbf.xaD = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(94582);
                    return 0;
                case 29:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cbu cbu = new cbu();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cbu.populateBuilderWithField(aVar4, cbu, a.getNextFieldNumber(aVar4))) {
                        }
                        cbf.xaE = cbu;
                    }
                    AppMethodBeat.o(94582);
                    return 0;
                case 30:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bld bld = new bld();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bld.populateBuilderWithField(aVar4, bld, a.getNextFieldNumber(aVar4))) {
                        }
                        cbf.xaF = bld;
                    }
                    AppMethodBeat.o(94582);
                    return 0;
                case 31:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cap cap = new cap();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cap.populateBuilderWithField(aVar4, cap, a.getNextFieldNumber(aVar4))) {
                        }
                        cbf.xaG = cap;
                    }
                    AppMethodBeat.o(94582);
                    return 0;
                default:
                    AppMethodBeat.o(94582);
                    return -1;
            }
        } else {
            AppMethodBeat.o(94582);
            return -1;
        }
    }
}
