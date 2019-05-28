package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class bkm extends a {
    public long cSh;
    public int ehf;
    public String nuL;
    public String pbn;
    public String pck;
    public int state;
    public String vEQ;
    public int vES;
    public String wND;
    public cij wNE;
    public bdg wNF;
    public bbk wNG;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56921);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.ehf);
            aVar.ai(2, this.cSh);
            if (this.pbn != null) {
                aVar.e(3, this.pbn);
            }
            if (this.pck != null) {
                aVar.e(4, this.pck);
            }
            if (this.vEQ != null) {
                aVar.e(5, this.vEQ);
            }
            if (this.wND != null) {
                aVar.e(6, this.wND);
            }
            if (this.wNE != null) {
                aVar.iy(7, this.wNE.computeSize());
                this.wNE.writeFields(aVar);
            }
            if (this.wNF != null) {
                aVar.iy(8, this.wNF.computeSize());
                this.wNF.writeFields(aVar);
            }
            if (this.wNG != null) {
                aVar.iy(9, this.wNG.computeSize());
                this.wNG.writeFields(aVar);
            }
            aVar.iz(10, this.vES);
            aVar.iz(11, this.state);
            if (this.nuL != null) {
                aVar.e(12, this.nuL);
            }
            AppMethodBeat.o(56921);
            return 0;
        } else if (i == 1) {
            bs = (e.a.a.b.b.a.bs(1, this.ehf) + 0) + e.a.a.b.b.a.o(2, this.cSh);
            if (this.pbn != null) {
                bs += e.a.a.b.b.a.f(3, this.pbn);
            }
            if (this.pck != null) {
                bs += e.a.a.b.b.a.f(4, this.pck);
            }
            if (this.vEQ != null) {
                bs += e.a.a.b.b.a.f(5, this.vEQ);
            }
            if (this.wND != null) {
                bs += e.a.a.b.b.a.f(6, this.wND);
            }
            if (this.wNE != null) {
                bs += e.a.a.a.ix(7, this.wNE.computeSize());
            }
            if (this.wNF != null) {
                bs += e.a.a.a.ix(8, this.wNF.computeSize());
            }
            if (this.wNG != null) {
                bs += e.a.a.a.ix(9, this.wNG.computeSize());
            }
            bs = (bs + e.a.a.b.b.a.bs(10, this.vES)) + e.a.a.b.b.a.bs(11, this.state);
            if (this.nuL != null) {
                bs += e.a.a.b.b.a.f(12, this.nuL);
            }
            AppMethodBeat.o(56921);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56921);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bkm bkm = (bkm) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    bkm.ehf = aVar3.BTU.vd();
                    AppMethodBeat.o(56921);
                    return 0;
                case 2:
                    bkm.cSh = aVar3.BTU.ve();
                    AppMethodBeat.o(56921);
                    return 0;
                case 3:
                    bkm.pbn = aVar3.BTU.readString();
                    AppMethodBeat.o(56921);
                    return 0;
                case 4:
                    bkm.pck = aVar3.BTU.readString();
                    AppMethodBeat.o(56921);
                    return 0;
                case 5:
                    bkm.vEQ = aVar3.BTU.readString();
                    AppMethodBeat.o(56921);
                    return 0;
                case 6:
                    bkm.wND = aVar3.BTU.readString();
                    AppMethodBeat.o(56921);
                    return 0;
                case 7:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cij cij = new cij();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cij.populateBuilderWithField(aVar4, cij, a.getNextFieldNumber(aVar4))) {
                        }
                        bkm.wNE = cij;
                    }
                    AppMethodBeat.o(56921);
                    return 0;
                case 8:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bdg bdg = new bdg();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bdg.populateBuilderWithField(aVar4, bdg, a.getNextFieldNumber(aVar4))) {
                        }
                        bkm.wNF = bdg;
                    }
                    AppMethodBeat.o(56921);
                    return 0;
                case 9:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bbk bbk = new bbk();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bbk.populateBuilderWithField(aVar4, bbk, a.getNextFieldNumber(aVar4))) {
                        }
                        bkm.wNG = bbk;
                    }
                    AppMethodBeat.o(56921);
                    return 0;
                case 10:
                    bkm.vES = aVar3.BTU.vd();
                    AppMethodBeat.o(56921);
                    return 0;
                case 11:
                    bkm.state = aVar3.BTU.vd();
                    AppMethodBeat.o(56921);
                    return 0;
                case 12:
                    bkm.nuL = aVar3.BTU.readString();
                    AppMethodBeat.o(56921);
                    return 0;
                default:
                    AppMethodBeat.o(56921);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56921);
            return -1;
        }
    }
}
