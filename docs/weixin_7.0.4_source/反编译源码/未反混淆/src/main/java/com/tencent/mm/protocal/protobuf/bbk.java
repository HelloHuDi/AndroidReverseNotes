package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class bbk extends a {
    public boolean wFY;
    public String wFZ;
    public LinkedList<Integer> wGa = new LinkedList();

    public bbk() {
        AppMethodBeat.i(56856);
        AppMethodBeat.o(56856);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56857);
        int fv;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.aO(1, this.wFY);
            if (this.wFZ != null) {
                aVar.e(2, this.wFZ);
            }
            aVar.e(3, 2, this.wGa);
            AppMethodBeat.o(56857);
            return 0;
        } else if (i == 1) {
            fv = (e.a.a.b.b.a.fv(1) + 1) + 0;
            if (this.wFZ != null) {
                fv += e.a.a.b.b.a.f(2, this.wFZ);
            }
            fv += e.a.a.a.c(3, 2, this.wGa);
            AppMethodBeat.o(56857);
            return fv;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.wGa.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (fv = a.getNextFieldNumber(aVar2); fv > 0; fv = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, fv)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56857);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bbk bbk = (bbk) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bbk.wFY = aVar3.BTU.ehX();
                    AppMethodBeat.o(56857);
                    return 0;
                case 2:
                    bbk.wFZ = aVar3.BTU.readString();
                    AppMethodBeat.o(56857);
                    return 0;
                case 3:
                    bbk.wGa.add(Integer.valueOf(aVar3.BTU.vd()));
                    AppMethodBeat.o(56857);
                    return 0;
                default:
                    AppMethodBeat.o(56857);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56857);
            return -1;
        }
    }
}
