package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class dp extends a {
    public boolean ndK;
    public LinkedList<cu> ndL = new LinkedList();
    public LinkedList<cu> ndM = new LinkedList();

    public dp() {
        AppMethodBeat.i(117005);
        AppMethodBeat.o(117005);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(117006);
        int fv;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.aO(1, this.ndK);
            aVar.e(3, 8, this.ndL);
            aVar.e(4, 8, this.ndM);
            AppMethodBeat.o(117006);
            return 0;
        } else if (i == 1) {
            fv = (((e.a.a.b.b.a.fv(1) + 1) + 0) + e.a.a.a.c(3, 8, this.ndL)) + e.a.a.a.c(4, 8, this.ndM);
            AppMethodBeat.o(117006);
            return fv;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.ndL.clear();
            this.ndM.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (fv = a.getNextFieldNumber(aVar2); fv > 0; fv = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, fv)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(117006);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            dp dpVar = (dp) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            cu cuVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    dpVar.ndK = aVar3.BTU.ehX();
                    AppMethodBeat.o(117006);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cuVar = new cu();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cuVar.populateBuilderWithField(aVar4, cuVar, a.getNextFieldNumber(aVar4))) {
                        }
                        dpVar.ndL.add(cuVar);
                    }
                    AppMethodBeat.o(117006);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cuVar = new cu();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cuVar.populateBuilderWithField(aVar4, cuVar, a.getNextFieldNumber(aVar4))) {
                        }
                        dpVar.ndM.add(cuVar);
                    }
                    AppMethodBeat.o(117006);
                    return 0;
                default:
                    AppMethodBeat.o(117006);
                    return -1;
            }
        } else {
            AppMethodBeat.o(117006);
            return -1;
        }
    }
}
