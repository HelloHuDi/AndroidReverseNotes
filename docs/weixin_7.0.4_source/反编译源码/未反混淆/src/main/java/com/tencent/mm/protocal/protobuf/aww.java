package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class aww extends bsr {
    public String wAZ;
    public LinkedList<String> wBc = new LinkedList();

    public aww() {
        AppMethodBeat.i(11782);
        AppMethodBeat.o(11782);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(11783);
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.wAZ != null) {
                aVar.e(2, this.wAZ);
            }
            aVar.e(3, 1, this.wBc);
            AppMethodBeat.o(11783);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wAZ != null) {
                ix += e.a.a.b.b.a.f(2, this.wAZ);
            }
            int c = ix + e.a.a.a.c(3, 1, this.wBc);
            AppMethodBeat.o(11783);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wBc.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(11783);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aww aww = (aww) objArr[1];
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
                        aww.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(11783);
                    return 0;
                case 2:
                    aww.wAZ = aVar3.BTU.readString();
                    AppMethodBeat.o(11783);
                    return 0;
                case 3:
                    aww.wBc.add(aVar3.BTU.readString());
                    AppMethodBeat.o(11783);
                    return 0;
                default:
                    AppMethodBeat.o(11783);
                    return -1;
            }
        } else {
            AppMethodBeat.o(11783);
            return -1;
        }
    }
}
