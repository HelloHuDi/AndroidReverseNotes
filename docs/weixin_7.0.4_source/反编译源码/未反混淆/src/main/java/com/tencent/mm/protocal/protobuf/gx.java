package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class gx extends a {
    public LinkedList<gy> vJA = new LinkedList();
    public boolean vJz;

    public gx() {
        AppMethodBeat.i(56705);
        AppMethodBeat.o(56705);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56706);
        int fv;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.aO(1, this.vJz);
            aVar.e(2, 8, this.vJA);
            AppMethodBeat.o(56706);
            return 0;
        } else if (i == 1) {
            fv = ((e.a.a.b.b.a.fv(1) + 1) + 0) + e.a.a.a.c(2, 8, this.vJA);
            AppMethodBeat.o(56706);
            return fv;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vJA.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (fv = a.getNextFieldNumber(aVar2); fv > 0; fv = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, fv)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56706);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            gx gxVar = (gx) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    gxVar.vJz = aVar3.BTU.ehX();
                    AppMethodBeat.o(56706);
                    return 0;
                case 2:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        gy gyVar = new gy();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = gyVar.populateBuilderWithField(aVar4, gyVar, a.getNextFieldNumber(aVar4))) {
                        }
                        gxVar.vJA.add(gyVar);
                    }
                    AppMethodBeat.o(56706);
                    return 0;
                default:
                    AppMethodBeat.o(56706);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56706);
            return -1;
        }
    }
}
