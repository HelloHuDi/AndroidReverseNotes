package com.tencent.mm.plugin.sns.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import com.tencent.mm.protocal.protobuf.bau;
import java.util.LinkedList;

public final class b extends a {
    public bau cNr;
    public int fDG;
    public String qQd;
    public int qQe;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(36823);
        int ix;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.cNr != null) {
                aVar.iy(1, this.cNr.computeSize());
                this.cNr.writeFields(aVar);
            }
            if (this.qQd != null) {
                aVar.e(2, this.qQd);
            }
            aVar.iz(3, this.fDG);
            aVar.iz(4, this.qQe);
            AppMethodBeat.o(36823);
            return 0;
        } else if (i == 1) {
            if (this.cNr != null) {
                ix = e.a.a.a.ix(1, this.cNr.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.qQd != null) {
                ix += e.a.a.b.b.a.f(2, this.qQd);
            }
            int bs = (ix + e.a.a.b.b.a.bs(3, this.fDG)) + e.a.a.b.b.a.bs(4, this.qQe);
            AppMethodBeat.o(36823);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(36823);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            b bVar = (b) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        bau bau = new bau();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bau.populateBuilderWithField(aVar4, bau, a.getNextFieldNumber(aVar4))) {
                        }
                        bVar.cNr = bau;
                    }
                    AppMethodBeat.o(36823);
                    return 0;
                case 2:
                    bVar.qQd = aVar3.BTU.readString();
                    AppMethodBeat.o(36823);
                    return 0;
                case 3:
                    bVar.fDG = aVar3.BTU.vd();
                    AppMethodBeat.o(36823);
                    return 0;
                case 4:
                    bVar.qQe = aVar3.BTU.vd();
                    AppMethodBeat.o(36823);
                    return 0;
                default:
                    AppMethodBeat.o(36823);
                    return -1;
            }
        } else {
            AppMethodBeat.o(36823);
            return -1;
        }
    }
}
