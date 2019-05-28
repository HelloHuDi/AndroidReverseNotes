package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class ad extends a {
    public String fKh;
    public String mZL;
    public int mZN;
    public int mZQ;
    public String mZj;
    public ca naA;
    public dn naB;
    public cj naC;
    public ck naD;
    public aw naE;
    public cs naF;
    public as naG;
    public o naH;
    public cn naI;
    public cy naJ;
    public n naK;
    public n naL;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(111567);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.mZQ);
            aVar.iz(2, this.mZN);
            if (this.mZL != null) {
                aVar.e(3, this.mZL);
            }
            if (this.fKh != null) {
                aVar.e(4, this.fKh);
            }
            if (this.mZj != null) {
                aVar.e(17, this.mZj);
            }
            if (this.naA != null) {
                aVar.iy(5, this.naA.computeSize());
                this.naA.writeFields(aVar);
            }
            if (this.naB != null) {
                aVar.iy(6, this.naB.computeSize());
                this.naB.writeFields(aVar);
            }
            if (this.naC != null) {
                aVar.iy(7, this.naC.computeSize());
                this.naC.writeFields(aVar);
            }
            if (this.naD != null) {
                aVar.iy(8, this.naD.computeSize());
                this.naD.writeFields(aVar);
            }
            if (this.naE != null) {
                aVar.iy(9, this.naE.computeSize());
                this.naE.writeFields(aVar);
            }
            if (this.naF != null) {
                aVar.iy(10, this.naF.computeSize());
                this.naF.writeFields(aVar);
            }
            if (this.naG != null) {
                aVar.iy(11, this.naG.computeSize());
                this.naG.writeFields(aVar);
            }
            if (this.naH != null) {
                aVar.iy(12, this.naH.computeSize());
                this.naH.writeFields(aVar);
            }
            if (this.naI != null) {
                aVar.iy(13, this.naI.computeSize());
                this.naI.writeFields(aVar);
            }
            if (this.naJ != null) {
                aVar.iy(14, this.naJ.computeSize());
                this.naJ.writeFields(aVar);
            }
            if (this.naK != null) {
                aVar.iy(15, this.naK.computeSize());
                this.naK.writeFields(aVar);
            }
            if (this.naL != null) {
                aVar.iy(16, this.naL.computeSize());
                this.naL.writeFields(aVar);
            }
            AppMethodBeat.o(111567);
            return 0;
        } else if (i == 1) {
            bs = (e.a.a.b.b.a.bs(1, this.mZQ) + 0) + e.a.a.b.b.a.bs(2, this.mZN);
            if (this.mZL != null) {
                bs += e.a.a.b.b.a.f(3, this.mZL);
            }
            if (this.fKh != null) {
                bs += e.a.a.b.b.a.f(4, this.fKh);
            }
            if (this.mZj != null) {
                bs += e.a.a.b.b.a.f(17, this.mZj);
            }
            if (this.naA != null) {
                bs += e.a.a.a.ix(5, this.naA.computeSize());
            }
            if (this.naB != null) {
                bs += e.a.a.a.ix(6, this.naB.computeSize());
            }
            if (this.naC != null) {
                bs += e.a.a.a.ix(7, this.naC.computeSize());
            }
            if (this.naD != null) {
                bs += e.a.a.a.ix(8, this.naD.computeSize());
            }
            if (this.naE != null) {
                bs += e.a.a.a.ix(9, this.naE.computeSize());
            }
            if (this.naF != null) {
                bs += e.a.a.a.ix(10, this.naF.computeSize());
            }
            if (this.naG != null) {
                bs += e.a.a.a.ix(11, this.naG.computeSize());
            }
            if (this.naH != null) {
                bs += e.a.a.a.ix(12, this.naH.computeSize());
            }
            if (this.naI != null) {
                bs += e.a.a.a.ix(13, this.naI.computeSize());
            }
            if (this.naJ != null) {
                bs += e.a.a.a.ix(14, this.naJ.computeSize());
            }
            if (this.naK != null) {
                bs += e.a.a.a.ix(15, this.naK.computeSize());
            }
            if (this.naL != null) {
                bs += e.a.a.a.ix(16, this.naL.computeSize());
            }
            AppMethodBeat.o(111567);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(111567);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ad adVar = (ad) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            e.a.a.a.a aVar4;
            boolean z;
            n nVar;
            switch (intValue) {
                case 1:
                    adVar.mZQ = aVar3.BTU.vd();
                    AppMethodBeat.o(111567);
                    return 0;
                case 2:
                    adVar.mZN = aVar3.BTU.vd();
                    AppMethodBeat.o(111567);
                    return 0;
                case 3:
                    adVar.mZL = aVar3.BTU.readString();
                    AppMethodBeat.o(111567);
                    return 0;
                case 4:
                    adVar.fKh = aVar3.BTU.readString();
                    AppMethodBeat.o(111567);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ca caVar = new ca();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = caVar.populateBuilderWithField(aVar4, caVar, a.getNextFieldNumber(aVar4))) {
                        }
                        adVar.naA = caVar;
                    }
                    AppMethodBeat.o(111567);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        dn dnVar = new dn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = dnVar.populateBuilderWithField(aVar4, dnVar, a.getNextFieldNumber(aVar4))) {
                        }
                        adVar.naB = dnVar;
                    }
                    AppMethodBeat.o(111567);
                    return 0;
                case 7:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cj cjVar = new cj();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cjVar.populateBuilderWithField(aVar4, cjVar, a.getNextFieldNumber(aVar4))) {
                        }
                        adVar.naC = cjVar;
                    }
                    AppMethodBeat.o(111567);
                    return 0;
                case 8:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ck ckVar = new ck();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ckVar.populateBuilderWithField(aVar4, ckVar, a.getNextFieldNumber(aVar4))) {
                        }
                        adVar.naD = ckVar;
                    }
                    AppMethodBeat.o(111567);
                    return 0;
                case 9:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        aw awVar = new aw();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = awVar.populateBuilderWithField(aVar4, awVar, a.getNextFieldNumber(aVar4))) {
                        }
                        adVar.naE = awVar;
                    }
                    AppMethodBeat.o(111567);
                    return 0;
                case 10:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cs csVar = new cs();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = csVar.populateBuilderWithField(aVar4, csVar, a.getNextFieldNumber(aVar4))) {
                        }
                        adVar.naF = csVar;
                    }
                    AppMethodBeat.o(111567);
                    return 0;
                case 11:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        as asVar = new as();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = asVar.populateBuilderWithField(aVar4, asVar, a.getNextFieldNumber(aVar4))) {
                        }
                        adVar.naG = asVar;
                    }
                    AppMethodBeat.o(111567);
                    return 0;
                case 12:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        o oVar = new o();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = oVar.populateBuilderWithField(aVar4, oVar, a.getNextFieldNumber(aVar4))) {
                        }
                        adVar.naH = oVar;
                    }
                    AppMethodBeat.o(111567);
                    return 0;
                case 13:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cn cnVar = new cn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cnVar.populateBuilderWithField(aVar4, cnVar, a.getNextFieldNumber(aVar4))) {
                        }
                        adVar.naI = cnVar;
                    }
                    AppMethodBeat.o(111567);
                    return 0;
                case 14:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cy cyVar = new cy();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cyVar.populateBuilderWithField(aVar4, cyVar, a.getNextFieldNumber(aVar4))) {
                        }
                        adVar.naJ = cyVar;
                    }
                    AppMethodBeat.o(111567);
                    return 0;
                case 15:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        nVar = new n();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = nVar.populateBuilderWithField(aVar4, nVar, a.getNextFieldNumber(aVar4))) {
                        }
                        adVar.naK = nVar;
                    }
                    AppMethodBeat.o(111567);
                    return 0;
                case 16:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        nVar = new n();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = nVar.populateBuilderWithField(aVar4, nVar, a.getNextFieldNumber(aVar4))) {
                        }
                        adVar.naL = nVar;
                    }
                    AppMethodBeat.o(111567);
                    return 0;
                case 17:
                    adVar.mZj = aVar3.BTU.readString();
                    AppMethodBeat.o(111567);
                    return 0;
                default:
                    AppMethodBeat.o(111567);
                    return -1;
            }
        } else {
            AppMethodBeat.o(111567);
            return -1;
        }
    }
}
