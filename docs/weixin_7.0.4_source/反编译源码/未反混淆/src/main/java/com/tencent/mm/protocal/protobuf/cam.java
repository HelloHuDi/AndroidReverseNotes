package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class cam extends a {
    public long wZC;
    public bts wZq;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(94562);
        int o;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.ai(1, this.wZC);
            if (this.wZq != null) {
                aVar.iy(2, this.wZq.computeSize());
                this.wZq.writeFields(aVar);
            }
            AppMethodBeat.o(94562);
            return 0;
        } else if (i == 1) {
            o = e.a.a.b.b.a.o(1, this.wZC) + 0;
            if (this.wZq != null) {
                o += e.a.a.a.ix(2, this.wZq.computeSize());
            }
            AppMethodBeat.o(94562);
            return o;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (o = a.getNextFieldNumber(aVar2); o > 0; o = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, o)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(94562);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cam cam = (cam) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cam.wZC = aVar3.BTU.ve();
                    AppMethodBeat.o(94562);
                    return 0;
                case 2:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        bts bts = new bts();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bts.populateBuilderWithField(aVar4, bts, a.getNextFieldNumber(aVar4))) {
                        }
                        cam.wZq = bts;
                    }
                    AppMethodBeat.o(94562);
                    return 0;
                default:
                    AppMethodBeat.o(94562);
                    return -1;
            }
        } else {
            AppMethodBeat.o(94562);
            return -1;
        }
    }
}
