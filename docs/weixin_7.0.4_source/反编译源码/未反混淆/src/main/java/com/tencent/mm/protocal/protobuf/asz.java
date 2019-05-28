package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class asz extends a {
    public hj wwG;
    public na wwH;
    public bba wwI;
    public cdp wwJ;
    public buk wwK;
    public td wwL;
    public abx wwM;
    public acu wwN;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(2542);
        int ix;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wwG != null) {
                aVar.iy(1, this.wwG.computeSize());
                this.wwG.writeFields(aVar);
            }
            if (this.wwH != null) {
                aVar.iy(2, this.wwH.computeSize());
                this.wwH.writeFields(aVar);
            }
            if (this.wwI != null) {
                aVar.iy(3, this.wwI.computeSize());
                this.wwI.writeFields(aVar);
            }
            if (this.wwJ != null) {
                aVar.iy(4, this.wwJ.computeSize());
                this.wwJ.writeFields(aVar);
            }
            if (this.wwK != null) {
                aVar.iy(6, this.wwK.computeSize());
                this.wwK.writeFields(aVar);
            }
            if (this.wwL != null) {
                aVar.iy(7, this.wwL.computeSize());
                this.wwL.writeFields(aVar);
            }
            if (this.wwM != null) {
                aVar.iy(8, this.wwM.computeSize());
                this.wwM.writeFields(aVar);
            }
            if (this.wwN != null) {
                aVar.iy(9, this.wwN.computeSize());
                this.wwN.writeFields(aVar);
            }
            AppMethodBeat.o(2542);
            return 0;
        } else if (i == 1) {
            if (this.wwG != null) {
                ix = e.a.a.a.ix(1, this.wwG.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wwH != null) {
                ix += e.a.a.a.ix(2, this.wwH.computeSize());
            }
            if (this.wwI != null) {
                ix += e.a.a.a.ix(3, this.wwI.computeSize());
            }
            if (this.wwJ != null) {
                ix += e.a.a.a.ix(4, this.wwJ.computeSize());
            }
            if (this.wwK != null) {
                ix += e.a.a.a.ix(6, this.wwK.computeSize());
            }
            if (this.wwL != null) {
                ix += e.a.a.a.ix(7, this.wwL.computeSize());
            }
            if (this.wwM != null) {
                ix += e.a.a.a.ix(8, this.wwM.computeSize());
            }
            if (this.wwN != null) {
                ix += e.a.a.a.ix(9, this.wwN.computeSize());
            }
            AppMethodBeat.o(2542);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(2542);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            asz asz = (asz) objArr[1];
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
                        hj hjVar = new hj();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = hjVar.populateBuilderWithField(aVar4, hjVar, a.getNextFieldNumber(aVar4))) {
                        }
                        asz.wwG = hjVar;
                    }
                    AppMethodBeat.o(2542);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        na naVar = new na();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = naVar.populateBuilderWithField(aVar4, naVar, a.getNextFieldNumber(aVar4))) {
                        }
                        asz.wwH = naVar;
                    }
                    AppMethodBeat.o(2542);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bba bba = new bba();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bba.populateBuilderWithField(aVar4, bba, a.getNextFieldNumber(aVar4))) {
                        }
                        asz.wwI = bba;
                    }
                    AppMethodBeat.o(2542);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cdp cdp = new cdp();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cdp.populateBuilderWithField(aVar4, cdp, a.getNextFieldNumber(aVar4))) {
                        }
                        asz.wwJ = cdp;
                    }
                    AppMethodBeat.o(2542);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        buk buk = new buk();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = buk.populateBuilderWithField(aVar4, buk, a.getNextFieldNumber(aVar4))) {
                        }
                        asz.wwK = buk;
                    }
                    AppMethodBeat.o(2542);
                    return 0;
                case 7:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        td tdVar = new td();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = tdVar.populateBuilderWithField(aVar4, tdVar, a.getNextFieldNumber(aVar4))) {
                        }
                        asz.wwL = tdVar;
                    }
                    AppMethodBeat.o(2542);
                    return 0;
                case 8:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        abx abx = new abx();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = abx.populateBuilderWithField(aVar4, abx, a.getNextFieldNumber(aVar4))) {
                        }
                        asz.wwM = abx;
                    }
                    AppMethodBeat.o(2542);
                    return 0;
                case 9:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        acu acu = new acu();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = acu.populateBuilderWithField(aVar4, acu, a.getNextFieldNumber(aVar4))) {
                        }
                        asz.wwN = acu;
                    }
                    AppMethodBeat.o(2542);
                    return 0;
                default:
                    AppMethodBeat.o(2542);
                    return -1;
            }
        } else {
            AppMethodBeat.o(2542);
            return -1;
        }
    }
}
