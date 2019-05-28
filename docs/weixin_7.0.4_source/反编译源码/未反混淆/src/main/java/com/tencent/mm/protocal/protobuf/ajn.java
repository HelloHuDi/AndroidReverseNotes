package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class ajn extends a {
    public asq vKM;
    public int wpk;
    public int wpl;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(10176);
        b bVar;
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vKM == null) {
                bVar = new b("Not all required fields were included: Device");
                AppMethodBeat.o(10176);
                throw bVar;
            }
            aVar.iz(1, this.wpk);
            aVar.iz(2, this.wpl);
            if (this.vKM != null) {
                aVar.iy(3, this.vKM.computeSize());
                this.vKM.writeFields(aVar);
            }
            AppMethodBeat.o(10176);
            return 0;
        } else if (i == 1) {
            bs = (e.a.a.b.b.a.bs(1, this.wpk) + 0) + e.a.a.b.b.a.bs(2, this.wpl);
            if (this.vKM != null) {
                bs += e.a.a.a.ix(3, this.vKM.computeSize());
            }
            AppMethodBeat.o(10176);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            if (this.vKM == null) {
                bVar = new b("Not all required fields were included: Device");
                AppMethodBeat.o(10176);
                throw bVar;
            }
            AppMethodBeat.o(10176);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ajn ajn = (ajn) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ajn.wpk = aVar3.BTU.vd();
                    AppMethodBeat.o(10176);
                    return 0;
                case 2:
                    ajn.wpl = aVar3.BTU.vd();
                    AppMethodBeat.o(10176);
                    return 0;
                case 3:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        asq asq = new asq();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = asq.populateBuilderWithField(aVar4, asq, a.getNextFieldNumber(aVar4))) {
                        }
                        ajn.vKM = asq;
                    }
                    AppMethodBeat.o(10176);
                    return 0;
                default:
                    AppMethodBeat.o(10176);
                    return -1;
            }
        } else {
            AppMethodBeat.o(10176);
            return -1;
        }
    }
}
