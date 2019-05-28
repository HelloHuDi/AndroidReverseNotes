package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class auf extends a {
    public LinkedList<aug> naO = new LinkedList();
    public int wye;

    public auf() {
        AppMethodBeat.i(72855);
        AppMethodBeat.o(72855);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(72856);
        int bs;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.wye);
            aVar.e(2, 8, this.naO);
            AppMethodBeat.o(72856);
            return 0;
        } else if (i == 1) {
            bs = (e.a.a.b.b.a.bs(1, this.wye) + 0) + e.a.a.a.c(2, 8, this.naO);
            AppMethodBeat.o(72856);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.naO.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(72856);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            auf auf = (auf) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    auf.wye = aVar3.BTU.vd();
                    AppMethodBeat.o(72856);
                    return 0;
                case 2:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        aug aug = new aug();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = aug.populateBuilderWithField(aVar4, aug, a.getNextFieldNumber(aVar4))) {
                        }
                        auf.naO.add(aug);
                    }
                    AppMethodBeat.o(72856);
                    return 0;
                default:
                    AppMethodBeat.o(72856);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72856);
            return -1;
        }
    }
}
