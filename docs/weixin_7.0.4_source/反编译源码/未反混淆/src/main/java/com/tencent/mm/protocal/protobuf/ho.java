package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ho extends bsr {
    public int jBv;
    public LinkedList<Integer> vKh = new LinkedList();

    public ho() {
        AppMethodBeat.i(51365);
        AppMethodBeat.o(51365);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(51366);
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.iz(2, this.jBv);
            aVar.f(3, 2, this.vKh);
            AppMethodBeat.o(51366);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            int bs = (ix + e.a.a.b.b.a.bs(2, this.jBv)) + e.a.a.a.d(3, 2, this.vKh);
            AppMethodBeat.o(51366);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vKh.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(51366);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ho hoVar = (ho) objArr[1];
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
                        hoVar.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(51366);
                    return 0;
                case 2:
                    hoVar.jBv = aVar3.BTU.vd();
                    AppMethodBeat.o(51366);
                    return 0;
                case 3:
                    hoVar.vKh = new e.a.a.a.a(aVar3.BTU.emu().wR, unknownTagHandler).BTU.emt();
                    AppMethodBeat.o(51366);
                    return 0;
                default:
                    AppMethodBeat.o(51366);
                    return -1;
            }
        } else {
            AppMethodBeat.o(51366);
            return -1;
        }
    }
}
