package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class cah extends a {
    public int vFH;
    public bts wZq;
    public bts wZs;
    public int wZt;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(94557);
        int ix;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wZq != null) {
                aVar.iy(1, this.wZq.computeSize());
                this.wZq.writeFields(aVar);
            }
            aVar.iz(2, this.vFH);
            if (this.wZs != null) {
                aVar.iy(3, this.wZs.computeSize());
                this.wZs.writeFields(aVar);
            }
            aVar.iz(4, this.wZt);
            AppMethodBeat.o(94557);
            return 0;
        } else if (i == 1) {
            if (this.wZq != null) {
                ix = e.a.a.a.ix(1, this.wZq.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += e.a.a.b.b.a.bs(2, this.vFH);
            if (this.wZs != null) {
                ix += e.a.a.a.ix(3, this.wZs.computeSize());
            }
            int bs = ix + e.a.a.b.b.a.bs(4, this.wZt);
            AppMethodBeat.o(94557);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(94557);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cah cah = (cah) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            bts bts;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, a.getNextFieldNumber(aVar4))) {
                        }
                        cah.wZq = bts;
                    }
                    AppMethodBeat.o(94557);
                    return 0;
                case 2:
                    cah.vFH = aVar3.BTU.vd();
                    AppMethodBeat.o(94557);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, a.getNextFieldNumber(aVar4))) {
                        }
                        cah.wZs = bts;
                    }
                    AppMethodBeat.o(94557);
                    return 0;
                case 4:
                    cah.wZt = aVar3.BTU.vd();
                    AppMethodBeat.o(94557);
                    return 0;
                default:
                    AppMethodBeat.o(94557);
                    return -1;
            }
        } else {
            AppMethodBeat.o(94557);
            return -1;
        }
    }
}
