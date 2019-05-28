package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class cwv extends a {
    public int vMG;
    public LinkedList<om> wco = new LinkedList();
    public ex xsA;
    public int xsw;
    public String xsx;
    public String xsy;
    public int xsz;

    public cwv() {
        AppMethodBeat.i(96331);
        AppMethodBeat.o(96331);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(96332);
        int bs;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.vMG);
            aVar.iz(2, this.xsw);
            if (this.xsx != null) {
                aVar.e(3, this.xsx);
            }
            if (this.xsy != null) {
                aVar.e(4, this.xsy);
            }
            aVar.iz(5, this.xsz);
            aVar.e(6, 8, this.wco);
            if (this.xsA != null) {
                aVar.iy(7, this.xsA.computeSize());
                this.xsA.writeFields(aVar);
            }
            AppMethodBeat.o(96332);
            return 0;
        } else if (i == 1) {
            bs = (e.a.a.b.b.a.bs(1, this.vMG) + 0) + e.a.a.b.b.a.bs(2, this.xsw);
            if (this.xsx != null) {
                bs += e.a.a.b.b.a.f(3, this.xsx);
            }
            if (this.xsy != null) {
                bs += e.a.a.b.b.a.f(4, this.xsy);
            }
            bs = (bs + e.a.a.b.b.a.bs(5, this.xsz)) + e.a.a.a.c(6, 8, this.wco);
            if (this.xsA != null) {
                bs += e.a.a.a.ix(7, this.xsA.computeSize());
            }
            AppMethodBeat.o(96332);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wco.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(96332);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cwv cwv = (cwv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    cwv.vMG = aVar3.BTU.vd();
                    AppMethodBeat.o(96332);
                    return 0;
                case 2:
                    cwv.xsw = aVar3.BTU.vd();
                    AppMethodBeat.o(96332);
                    return 0;
                case 3:
                    cwv.xsx = aVar3.BTU.readString();
                    AppMethodBeat.o(96332);
                    return 0;
                case 4:
                    cwv.xsy = aVar3.BTU.readString();
                    AppMethodBeat.o(96332);
                    return 0;
                case 5:
                    cwv.xsz = aVar3.BTU.vd();
                    AppMethodBeat.o(96332);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        om omVar = new om();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = omVar.populateBuilderWithField(aVar4, omVar, a.getNextFieldNumber(aVar4))) {
                        }
                        cwv.wco.add(omVar);
                    }
                    AppMethodBeat.o(96332);
                    return 0;
                case 7:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ex exVar = new ex();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = exVar.populateBuilderWithField(aVar4, exVar, a.getNextFieldNumber(aVar4))) {
                        }
                        cwv.xsA = exVar;
                    }
                    AppMethodBeat.o(96332);
                    return 0;
                default:
                    AppMethodBeat.o(96332);
                    return -1;
            }
        } else {
            AppMethodBeat.o(96332);
            return -1;
        }
    }
}
