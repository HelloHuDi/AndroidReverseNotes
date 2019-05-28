package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class io extends a {
    public LinkedList<in> vKG = new LinkedList();
    public im vKH;
    public int vKI;

    public io() {
        AppMethodBeat.i(10155);
        AppMethodBeat.o(10155);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(10156);
        int c;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.vKG);
            if (this.vKH != null) {
                aVar.iy(2, this.vKH.computeSize());
                this.vKH.writeFields(aVar);
            }
            aVar.iz(3, this.vKI);
            AppMethodBeat.o(10156);
            return 0;
        } else if (i == 1) {
            c = e.a.a.a.c(1, 8, this.vKG) + 0;
            if (this.vKH != null) {
                c += e.a.a.a.ix(2, this.vKH.computeSize());
            }
            c += e.a.a.b.b.a.bs(3, this.vKI);
            AppMethodBeat.o(10156);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vKG.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (c = a.getNextFieldNumber(aVar2); c > 0; c = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, c)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(10156);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            io ioVar = (io) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        in inVar = new in();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = inVar.populateBuilderWithField(aVar4, inVar, a.getNextFieldNumber(aVar4))) {
                        }
                        ioVar.vKG.add(inVar);
                    }
                    AppMethodBeat.o(10156);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        im imVar = new im();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = imVar.populateBuilderWithField(aVar4, imVar, a.getNextFieldNumber(aVar4))) {
                        }
                        ioVar.vKH = imVar;
                    }
                    AppMethodBeat.o(10156);
                    return 0;
                case 3:
                    ioVar.vKI = aVar3.BTU.vd();
                    AppMethodBeat.o(10156);
                    return 0;
                default:
                    AppMethodBeat.o(10156);
                    return -1;
            }
        } else {
            AppMethodBeat.o(10156);
            return -1;
        }
    }
}
