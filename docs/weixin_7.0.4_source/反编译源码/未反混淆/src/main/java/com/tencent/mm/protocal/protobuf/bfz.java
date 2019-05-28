package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class bfz extends a {
    public String app_id;
    public String gfa;
    public int oqG;
    public int wJQ;
    public bga wJR;
    public int wJS;
    public int wJT;
    public int wJU;
    public int wJV;
    public int wqI;
    public bgb wqJ;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(80125);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.gfa != null) {
                aVar.e(1, this.gfa);
            }
            aVar.iz(2, this.wJQ);
            if (this.wJR != null) {
                aVar.iy(3, this.wJR.computeSize());
                this.wJR.writeFields(aVar);
            }
            aVar.iz(4, this.wqI);
            if (this.wqJ != null) {
                aVar.iy(5, this.wqJ.computeSize());
                this.wqJ.writeFields(aVar);
            }
            aVar.iz(6, this.wJS);
            aVar.iz(7, this.wJT);
            aVar.iz(8, this.oqG);
            aVar.iz(9, this.wJU);
            if (this.app_id != null) {
                aVar.e(10, this.app_id);
            }
            aVar.iz(11, this.wJV);
            AppMethodBeat.o(80125);
            return 0;
        } else if (i == 1) {
            if (this.gfa != null) {
                f = e.a.a.b.b.a.f(1, this.gfa) + 0;
            } else {
                f = 0;
            }
            f += e.a.a.b.b.a.bs(2, this.wJQ);
            if (this.wJR != null) {
                f += e.a.a.a.ix(3, this.wJR.computeSize());
            }
            f += e.a.a.b.b.a.bs(4, this.wqI);
            if (this.wqJ != null) {
                f += e.a.a.a.ix(5, this.wqJ.computeSize());
            }
            f = (((f + e.a.a.b.b.a.bs(6, this.wJS)) + e.a.a.b.b.a.bs(7, this.wJT)) + e.a.a.b.b.a.bs(8, this.oqG)) + e.a.a.b.b.a.bs(9, this.wJU);
            if (this.app_id != null) {
                f += e.a.a.b.b.a.f(10, this.app_id);
            }
            int bs = f + e.a.a.b.b.a.bs(11, this.wJV);
            AppMethodBeat.o(80125);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(80125);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bfz bfz = (bfz) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    bfz.gfa = aVar3.BTU.readString();
                    AppMethodBeat.o(80125);
                    return 0;
                case 2:
                    bfz.wJQ = aVar3.BTU.vd();
                    AppMethodBeat.o(80125);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bga bga = new bga();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bga.populateBuilderWithField(aVar4, bga, a.getNextFieldNumber(aVar4))) {
                        }
                        bfz.wJR = bga;
                    }
                    AppMethodBeat.o(80125);
                    return 0;
                case 4:
                    bfz.wqI = aVar3.BTU.vd();
                    AppMethodBeat.o(80125);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bgb bgb = new bgb();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bgb.populateBuilderWithField(aVar4, bgb, a.getNextFieldNumber(aVar4))) {
                        }
                        bfz.wqJ = bgb;
                    }
                    AppMethodBeat.o(80125);
                    return 0;
                case 6:
                    bfz.wJS = aVar3.BTU.vd();
                    AppMethodBeat.o(80125);
                    return 0;
                case 7:
                    bfz.wJT = aVar3.BTU.vd();
                    AppMethodBeat.o(80125);
                    return 0;
                case 8:
                    bfz.oqG = aVar3.BTU.vd();
                    AppMethodBeat.o(80125);
                    return 0;
                case 9:
                    bfz.wJU = aVar3.BTU.vd();
                    AppMethodBeat.o(80125);
                    return 0;
                case 10:
                    bfz.app_id = aVar3.BTU.readString();
                    AppMethodBeat.o(80125);
                    return 0;
                case 11:
                    bfz.wJV = aVar3.BTU.vd();
                    AppMethodBeat.o(80125);
                    return 0;
                default:
                    AppMethodBeat.o(80125);
                    return -1;
            }
        } else {
            AppMethodBeat.o(80125);
            return -1;
        }
    }
}
