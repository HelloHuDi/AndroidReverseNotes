package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class acw extends bsr {
    public String nbs;
    public String wkD;
    public LinkedList<String> wkE = new LinkedList();

    public acw() {
        AppMethodBeat.i(112421);
        AppMethodBeat.o(112421);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(112422);
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.wkD != null) {
                aVar.e(2, this.wkD);
            }
            aVar.e(3, 1, this.wkE);
            if (this.nbs != null) {
                aVar.e(4, this.nbs);
            }
            AppMethodBeat.o(112422);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wkD != null) {
                ix += e.a.a.b.b.a.f(2, this.wkD);
            }
            ix += e.a.a.a.c(3, 1, this.wkE);
            if (this.nbs != null) {
                ix += e.a.a.b.b.a.f(4, this.nbs);
            }
            AppMethodBeat.o(112422);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wkE.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(112422);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            acw acw = (acw) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        hl hlVar = new hl();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = hlVar.populateBuilderWithField(aVar4, hlVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        acw.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(112422);
                    return 0;
                case 2:
                    acw.wkD = aVar3.BTU.readString();
                    AppMethodBeat.o(112422);
                    return 0;
                case 3:
                    acw.wkE.add(aVar3.BTU.readString());
                    AppMethodBeat.o(112422);
                    return 0;
                case 4:
                    acw.nbs = aVar3.BTU.readString();
                    AppMethodBeat.o(112422);
                    return 0;
                default:
                    AppMethodBeat.o(112422);
                    return -1;
            }
        } else {
            AppMethodBeat.o(112422);
            return -1;
        }
    }
}
