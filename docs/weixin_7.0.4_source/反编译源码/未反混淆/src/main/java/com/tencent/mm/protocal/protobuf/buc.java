package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class buc extends a {
    public String wCK;
    public LinkedList<dh> wVV = new LinkedList();

    public buc() {
        AppMethodBeat.i(28620);
        AppMethodBeat.o(28620);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28621);
        int c;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.wVV);
            if (this.wCK != null) {
                aVar.e(2, this.wCK);
            }
            AppMethodBeat.o(28621);
            return 0;
        } else if (i == 1) {
            c = e.a.a.a.c(1, 8, this.wVV) + 0;
            if (this.wCK != null) {
                c += e.a.a.b.b.a.f(2, this.wCK);
            }
            AppMethodBeat.o(28621);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wVV.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (c = a.getNextFieldNumber(aVar2); c > 0; c = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, c)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(28621);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            buc buc = (buc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        dh dhVar = new dh();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = dhVar.populateBuilderWithField(aVar4, dhVar, a.getNextFieldNumber(aVar4))) {
                        }
                        buc.wVV.add(dhVar);
                    }
                    AppMethodBeat.o(28621);
                    return 0;
                case 2:
                    buc.wCK = aVar3.BTU.readString();
                    AppMethodBeat.o(28621);
                    return 0;
                default:
                    AppMethodBeat.o(28621);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28621);
            return -1;
        }
    }
}
