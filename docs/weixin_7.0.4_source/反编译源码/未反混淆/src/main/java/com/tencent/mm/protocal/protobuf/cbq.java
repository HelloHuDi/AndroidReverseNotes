package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class cbq extends bsr {
    public String ptv;
    public SKBuiltinBuffer_t vIl;
    public int wFe;
    public LinkedList<cba> wFk = new LinkedList();
    public LinkedList<bts> wFp = new LinkedList();
    public cbp wFq;
    public int wHG;
    public civ wNQ;
    public int xaA;
    public LinkedList<bts> xaB = new LinkedList();
    public int xaC;
    public cbu xaE;
    public int xaU;
    public int xaV;
    public int xaW;
    public cbo xaX;
    public SKBuiltinBuffer_t xaY;
    public String xaZ;
    public SKBuiltinBuffer_t xam;
    public int xav;
    public LinkedList<bts> xaw = new LinkedList();
    public long xaz;
    public nl xba;
    public int xbb;
    public LinkedList<bas> xbc = new LinkedList();
    public cap xbd;

    public cbq() {
        AppMethodBeat.i(94595);
        AppMethodBeat.o(94595);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(94596);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.xam == null) {
                bVar = new b("Not all required fields were included: ObjectDesc");
                AppMethodBeat.o(94596);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.xam != null) {
                aVar.iy(2, this.xam.computeSize());
                this.xam.writeFields(aVar);
            }
            aVar.iz(3, this.xav);
            aVar.e(4, 8, this.xaw);
            aVar.iz(5, this.xaU);
            aVar.iz(6, this.wFe);
            if (this.ptv != null) {
                aVar.e(7, this.ptv);
            }
            aVar.iz(8, this.xaV);
            aVar.iz(9, this.wHG);
            aVar.e(10, 8, this.wFk);
            aVar.iz(11, this.xaW);
            aVar.ai(12, this.xaz);
            aVar.iz(13, this.xaA);
            aVar.e(14, 8, this.xaB);
            if (this.wNQ != null) {
                aVar.iy(15, this.wNQ.computeSize());
                this.wNQ.writeFields(aVar);
            }
            aVar.iz(16, this.xaC);
            aVar.e(17, 8, this.wFp);
            if (this.xaX != null) {
                aVar.iy(18, this.xaX.computeSize());
                this.xaX.writeFields(aVar);
            }
            if (this.wFq != null) {
                aVar.iy(19, this.wFq.computeSize());
                this.wFq.writeFields(aVar);
            }
            if (this.xaE != null) {
                aVar.iy(20, this.xaE.computeSize());
                this.xaE.writeFields(aVar);
            }
            if (this.xaY != null) {
                aVar.iy(21, this.xaY.computeSize());
                this.xaY.writeFields(aVar);
            }
            if (this.xaZ != null) {
                aVar.e(22, this.xaZ);
            }
            if (this.xba != null) {
                aVar.iy(23, this.xba.computeSize());
                this.xba.writeFields(aVar);
            }
            aVar.iz(24, this.xbb);
            aVar.e(25, 8, this.xbc);
            if (this.xbd != null) {
                aVar.iy(26, this.xbd.computeSize());
                this.xbd.writeFields(aVar);
            }
            if (this.vIl != null) {
                aVar.iy(27, this.vIl.computeSize());
                this.vIl.writeFields(aVar);
            }
            AppMethodBeat.o(94596);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.xam != null) {
                ix += e.a.a.a.ix(2, this.xam.computeSize());
            }
            ix = (((ix + e.a.a.b.b.a.bs(3, this.xav)) + e.a.a.a.c(4, 8, this.xaw)) + e.a.a.b.b.a.bs(5, this.xaU)) + e.a.a.b.b.a.bs(6, this.wFe);
            if (this.ptv != null) {
                ix += e.a.a.b.b.a.f(7, this.ptv);
            }
            ix = ((((((ix + e.a.a.b.b.a.bs(8, this.xaV)) + e.a.a.b.b.a.bs(9, this.wHG)) + e.a.a.a.c(10, 8, this.wFk)) + e.a.a.b.b.a.bs(11, this.xaW)) + e.a.a.b.b.a.o(12, this.xaz)) + e.a.a.b.b.a.bs(13, this.xaA)) + e.a.a.a.c(14, 8, this.xaB);
            if (this.wNQ != null) {
                ix += e.a.a.a.ix(15, this.wNQ.computeSize());
            }
            ix = (ix + e.a.a.b.b.a.bs(16, this.xaC)) + e.a.a.a.c(17, 8, this.wFp);
            if (this.xaX != null) {
                ix += e.a.a.a.ix(18, this.xaX.computeSize());
            }
            if (this.wFq != null) {
                ix += e.a.a.a.ix(19, this.wFq.computeSize());
            }
            if (this.xaE != null) {
                ix += e.a.a.a.ix(20, this.xaE.computeSize());
            }
            if (this.xaY != null) {
                ix += e.a.a.a.ix(21, this.xaY.computeSize());
            }
            if (this.xaZ != null) {
                ix += e.a.a.b.b.a.f(22, this.xaZ);
            }
            if (this.xba != null) {
                ix += e.a.a.a.ix(23, this.xba.computeSize());
            }
            ix = (ix + e.a.a.b.b.a.bs(24, this.xbb)) + e.a.a.a.c(25, 8, this.xbc);
            if (this.xbd != null) {
                ix += e.a.a.a.ix(26, this.xbd.computeSize());
            }
            if (this.vIl != null) {
                ix += e.a.a.a.ix(27, this.vIl.computeSize());
            }
            AppMethodBeat.o(94596);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xaw.clear();
            this.wFk.clear();
            this.xaB.clear();
            this.wFp.clear();
            this.xbc.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.xam == null) {
                bVar = new b("Not all required fields were included: ObjectDesc");
                AppMethodBeat.o(94596);
                throw bVar;
            }
            AppMethodBeat.o(94596);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cbq cbq = (cbq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            e.a.a.a.a aVar4;
            boolean z;
            SKBuiltinBuffer_t sKBuiltinBuffer_t;
            bts bts;
            switch (intValue) {
                case 1:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        hl hlVar = new hl();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = hlVar.populateBuilderWithField(aVar4, hlVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cbq.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(94596);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cbq.xam = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(94596);
                    return 0;
                case 3:
                    cbq.xav = aVar3.BTU.vd();
                    AppMethodBeat.o(94596);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cbq.xaw.add(bts);
                    }
                    AppMethodBeat.o(94596);
                    return 0;
                case 5:
                    cbq.xaU = aVar3.BTU.vd();
                    AppMethodBeat.o(94596);
                    return 0;
                case 6:
                    cbq.wFe = aVar3.BTU.vd();
                    AppMethodBeat.o(94596);
                    return 0;
                case 7:
                    cbq.ptv = aVar3.BTU.readString();
                    AppMethodBeat.o(94596);
                    return 0;
                case 8:
                    cbq.xaV = aVar3.BTU.vd();
                    AppMethodBeat.o(94596);
                    return 0;
                case 9:
                    cbq.wHG = aVar3.BTU.vd();
                    AppMethodBeat.o(94596);
                    return 0;
                case 10:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cba cba = new cba();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cba.populateBuilderWithField(aVar4, cba, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cbq.wFk.add(cba);
                    }
                    AppMethodBeat.o(94596);
                    return 0;
                case 11:
                    cbq.xaW = aVar3.BTU.vd();
                    AppMethodBeat.o(94596);
                    return 0;
                case 12:
                    cbq.xaz = aVar3.BTU.ve();
                    AppMethodBeat.o(94596);
                    return 0;
                case 13:
                    cbq.xaA = aVar3.BTU.vd();
                    AppMethodBeat.o(94596);
                    return 0;
                case 14:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cbq.xaB.add(bts);
                    }
                    AppMethodBeat.o(94596);
                    return 0;
                case 15:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        civ civ = new civ();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = civ.populateBuilderWithField(aVar4, civ, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cbq.wNQ = civ;
                    }
                    AppMethodBeat.o(94596);
                    return 0;
                case 16:
                    cbq.xaC = aVar3.BTU.vd();
                    AppMethodBeat.o(94596);
                    return 0;
                case 17:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cbq.wFp.add(bts);
                    }
                    AppMethodBeat.o(94596);
                    return 0;
                case 18:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cbo cbo = new cbo();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cbo.populateBuilderWithField(aVar4, cbo, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cbq.xaX = cbo;
                    }
                    AppMethodBeat.o(94596);
                    return 0;
                case 19:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cbp cbp = new cbp();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cbp.populateBuilderWithField(aVar4, cbp, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cbq.wFq = cbp;
                    }
                    AppMethodBeat.o(94596);
                    return 0;
                case 20:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cbu cbu = new cbu();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cbu.populateBuilderWithField(aVar4, cbu, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cbq.xaE = cbu;
                    }
                    AppMethodBeat.o(94596);
                    return 0;
                case 21:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cbq.xaY = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(94596);
                    return 0;
                case 22:
                    cbq.xaZ = aVar3.BTU.readString();
                    AppMethodBeat.o(94596);
                    return 0;
                case 23:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        nl nlVar = new nl();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = nlVar.populateBuilderWithField(aVar4, nlVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cbq.xba = nlVar;
                    }
                    AppMethodBeat.o(94596);
                    return 0;
                case 24:
                    cbq.xbb = aVar3.BTU.vd();
                    AppMethodBeat.o(94596);
                    return 0;
                case 25:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bas bas = new bas();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bas.populateBuilderWithField(aVar4, bas, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cbq.xbc.add(bas);
                    }
                    AppMethodBeat.o(94596);
                    return 0;
                case 26:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cap cap = new cap();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cap.populateBuilderWithField(aVar4, cap, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cbq.xbd = cap;
                    }
                    AppMethodBeat.o(94596);
                    return 0;
                case 27:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cbq.vIl = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(94596);
                    return 0;
                default:
                    AppMethodBeat.o(94596);
                    return -1;
            }
        } else {
            AppMethodBeat.o(94596);
            return -1;
        }
    }
}
