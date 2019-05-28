package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class cvm extends a {
    public cvp xrx;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(63693);
        b bVar;
        int ix;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.xrx == null) {
                bVar = new b("Not all required fields were included: DownloadInfo");
                AppMethodBeat.o(63693);
                throw bVar;
            }
            if (this.xrx != null) {
                aVar.iy(4, this.xrx.computeSize());
                this.xrx.writeFields(aVar);
            }
            AppMethodBeat.o(63693);
            return 0;
        } else if (i == 1) {
            if (this.xrx != null) {
                ix = e.a.a.a.ix(4, this.xrx.computeSize()) + 0;
            } else {
                ix = 0;
            }
            AppMethodBeat.o(63693);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.xrx == null) {
                bVar = new b("Not all required fields were included: DownloadInfo");
                AppMethodBeat.o(63693);
                throw bVar;
            }
            AppMethodBeat.o(63693);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cvm cvm = (cvm) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 4:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        cvp cvp = new cvp();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = cvp.populateBuilderWithField(aVar4, cvp, a.getNextFieldNumber(aVar4))) {
                        }
                        cvm.xrx = cvp;
                    }
                    AppMethodBeat.o(63693);
                    return 0;
                default:
                    AppMethodBeat.o(63693);
                    return -1;
            }
        } else {
            AppMethodBeat.o(63693);
            return -1;
        }
    }
}
