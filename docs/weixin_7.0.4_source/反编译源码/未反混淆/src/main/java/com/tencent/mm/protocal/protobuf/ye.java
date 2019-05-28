package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class ye extends a {
    public int Scene;
    public int vIK = 0;
    public LinkedList<ckw> wdV = new LinkedList();
    public int wdW;
    public boolean wdX = false;

    public ye() {
        AppMethodBeat.i(62527);
        AppMethodBeat.o(62527);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(62528);
        int c;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.wdV);
            aVar.iz(2, this.wdW);
            aVar.aO(3, this.wdX);
            aVar.iz(4, this.vIK);
            aVar.iz(5, this.Scene);
            AppMethodBeat.o(62528);
            return 0;
        } else if (i == 1) {
            c = ((((e.a.a.a.c(1, 8, this.wdV) + 0) + e.a.a.b.b.a.bs(2, this.wdW)) + (e.a.a.b.b.a.fv(3) + 1)) + e.a.a.b.b.a.bs(4, this.vIK)) + e.a.a.b.b.a.bs(5, this.Scene);
            AppMethodBeat.o(62528);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wdV.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (c = a.getNextFieldNumber(aVar2); c > 0; c = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, c)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(62528);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ye yeVar = (ye) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ckw ckw = new ckw();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = ckw.populateBuilderWithField(aVar4, ckw, a.getNextFieldNumber(aVar4))) {
                        }
                        yeVar.wdV.add(ckw);
                    }
                    AppMethodBeat.o(62528);
                    return 0;
                case 2:
                    yeVar.wdW = aVar3.BTU.vd();
                    AppMethodBeat.o(62528);
                    return 0;
                case 3:
                    yeVar.wdX = aVar3.BTU.ehX();
                    AppMethodBeat.o(62528);
                    return 0;
                case 4:
                    yeVar.vIK = aVar3.BTU.vd();
                    AppMethodBeat.o(62528);
                    return 0;
                case 5:
                    yeVar.Scene = aVar3.BTU.vd();
                    AppMethodBeat.o(62528);
                    return 0;
                default:
                    AppMethodBeat.o(62528);
                    return -1;
            }
        } else {
            AppMethodBeat.o(62528);
            return -1;
        }
    }
}
