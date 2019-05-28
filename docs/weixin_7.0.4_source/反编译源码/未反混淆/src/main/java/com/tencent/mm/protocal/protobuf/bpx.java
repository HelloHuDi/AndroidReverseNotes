package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class bpx extends a {
    public cbt wSf;
    public bts wSg;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(94552);
        b bVar;
        int ix;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wSf == null) {
                bVar = new b("Not all required fields were included: SnsRecommendObject");
                AppMethodBeat.o(94552);
                throw bVar;
            }
            if (this.wSf != null) {
                aVar.iy(1, this.wSf.computeSize());
                this.wSf.writeFields(aVar);
            }
            if (this.wSg != null) {
                aVar.iy(2, this.wSg.computeSize());
                this.wSg.writeFields(aVar);
            }
            AppMethodBeat.o(94552);
            return 0;
        } else if (i == 1) {
            if (this.wSf != null) {
                ix = e.a.a.a.ix(1, this.wSf.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wSg != null) {
                ix += e.a.a.a.ix(2, this.wSg.computeSize());
            }
            AppMethodBeat.o(94552);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.wSf == null) {
                bVar = new b("Not all required fields were included: SnsRecommendObject");
                AppMethodBeat.o(94552);
                throw bVar;
            }
            AppMethodBeat.o(94552);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bpx bpx = (bpx) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cbt cbt = new cbt();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cbt.populateBuilderWithField(aVar4, cbt, a.getNextFieldNumber(aVar4))) {
                        }
                        bpx.wSf = cbt;
                    }
                    AppMethodBeat.o(94552);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, a.getNextFieldNumber(aVar4))) {
                        }
                        bpx.wSg = bts;
                    }
                    AppMethodBeat.o(94552);
                    return 0;
                default:
                    AppMethodBeat.o(94552);
                    return -1;
            }
        } else {
            AppMethodBeat.o(94552);
            return -1;
        }
    }
}
