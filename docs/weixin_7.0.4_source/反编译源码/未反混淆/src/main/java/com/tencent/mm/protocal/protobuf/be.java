package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class be extends a {
    public int flags = -1;
    public int state = -1;
    public chm vDg;
    public String vDh = "";

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(73644);
        int ix;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vDg != null) {
                aVar.iy(1, this.vDg.computeSize());
                this.vDg.writeFields(aVar);
            }
            aVar.iz(2, this.flags);
            aVar.iz(3, this.state);
            if (this.vDh != null) {
                aVar.e(4, this.vDh);
            }
            AppMethodBeat.o(73644);
            return 0;
        } else if (i == 1) {
            if (this.vDg != null) {
                ix = e.a.a.a.ix(1, this.vDg.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (ix + e.a.a.b.b.a.bs(2, this.flags)) + e.a.a.b.b.a.bs(3, this.state);
            if (this.vDh != null) {
                ix += e.a.a.b.b.a.f(4, this.vDh);
            }
            AppMethodBeat.o(73644);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(73644);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            be beVar = (be) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        chm chm = new chm();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = chm.populateBuilderWithField(aVar4, chm, a.getNextFieldNumber(aVar4))) {
                        }
                        beVar.vDg = chm;
                    }
                    AppMethodBeat.o(73644);
                    return 0;
                case 2:
                    beVar.flags = aVar3.BTU.vd();
                    AppMethodBeat.o(73644);
                    return 0;
                case 3:
                    beVar.state = aVar3.BTU.vd();
                    AppMethodBeat.o(73644);
                    return 0;
                case 4:
                    beVar.vDh = aVar3.BTU.readString();
                    AppMethodBeat.o(73644);
                    return 0;
                default:
                    AppMethodBeat.o(73644);
                    return -1;
            }
        } else {
            AppMethodBeat.o(73644);
            return -1;
        }
    }
}
