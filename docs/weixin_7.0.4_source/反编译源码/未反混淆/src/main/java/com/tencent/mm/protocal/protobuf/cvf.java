package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class cvf extends a {
    public long xrj;
    public li xrk;
    public int xrl;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(124382);
        int o;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.ai(1, this.xrj);
            if (this.xrk != null) {
                aVar.iy(2, this.xrk.computeSize());
                this.xrk.writeFields(aVar);
            }
            aVar.iz(3, this.xrl);
            AppMethodBeat.o(124382);
            return 0;
        } else if (i == 1) {
            o = e.a.a.b.b.a.o(1, this.xrj) + 0;
            if (this.xrk != null) {
                o += e.a.a.a.ix(2, this.xrk.computeSize());
            }
            o += e.a.a.b.b.a.bs(3, this.xrl);
            AppMethodBeat.o(124382);
            return o;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (o = a.getNextFieldNumber(aVar2); o > 0; o = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, o)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(124382);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cvf cvf = (cvf) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cvf.xrj = aVar3.BTU.ve();
                    AppMethodBeat.o(124382);
                    return 0;
                case 2:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        li liVar = new li();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = liVar.populateBuilderWithField(aVar4, liVar, a.getNextFieldNumber(aVar4))) {
                        }
                        cvf.xrk = liVar;
                    }
                    AppMethodBeat.o(124382);
                    return 0;
                case 3:
                    cvf.xrl = aVar3.BTU.vd();
                    AppMethodBeat.o(124382);
                    return 0;
                default:
                    AppMethodBeat.o(124382);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124382);
            return -1;
        }
    }
}
