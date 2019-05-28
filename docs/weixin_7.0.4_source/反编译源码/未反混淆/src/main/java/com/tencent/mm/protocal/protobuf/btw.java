package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class btw extends a {
    public LinkedList<aza> wVM = new LinkedList();
    public boolean wVN;
    public boolean wVO;
    public boolean wVP;
    public boolean wVQ;
    public boolean wVR;

    public btw() {
        AppMethodBeat.i(73753);
        AppMethodBeat.o(73753);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(73754);
        int c;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.wVM);
            aVar.aO(2, this.wVN);
            aVar.aO(3, this.wVO);
            aVar.aO(4, this.wVP);
            aVar.aO(5, this.wVQ);
            aVar.aO(6, this.wVR);
            AppMethodBeat.o(73754);
            return 0;
        } else if (i == 1) {
            c = (((((e.a.a.a.c(1, 8, this.wVM) + 0) + (e.a.a.b.b.a.fv(2) + 1)) + (e.a.a.b.b.a.fv(3) + 1)) + (e.a.a.b.b.a.fv(4) + 1)) + (e.a.a.b.b.a.fv(5) + 1)) + (e.a.a.b.b.a.fv(6) + 1);
            AppMethodBeat.o(73754);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wVM.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (c = a.getNextFieldNumber(aVar2); c > 0; c = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, c)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(73754);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            btw btw = (btw) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        aza aza = new aza();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = aza.populateBuilderWithField(aVar4, aza, a.getNextFieldNumber(aVar4))) {
                        }
                        btw.wVM.add(aza);
                    }
                    AppMethodBeat.o(73754);
                    return 0;
                case 2:
                    btw.wVN = aVar3.BTU.ehX();
                    AppMethodBeat.o(73754);
                    return 0;
                case 3:
                    btw.wVO = aVar3.BTU.ehX();
                    AppMethodBeat.o(73754);
                    return 0;
                case 4:
                    btw.wVP = aVar3.BTU.ehX();
                    AppMethodBeat.o(73754);
                    return 0;
                case 5:
                    btw.wVQ = aVar3.BTU.ehX();
                    AppMethodBeat.o(73754);
                    return 0;
                case 6:
                    btw.wVR = aVar3.BTU.ehX();
                    AppMethodBeat.o(73754);
                    return 0;
                default:
                    AppMethodBeat.o(73754);
                    return -1;
            }
        } else {
            AppMethodBeat.o(73754);
            return -1;
        }
    }
}
