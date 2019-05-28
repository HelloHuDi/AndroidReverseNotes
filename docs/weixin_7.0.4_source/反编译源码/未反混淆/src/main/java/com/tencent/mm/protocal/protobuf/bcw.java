package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bcw extends bsr {
    public String wcg;
    public long wch;
    public String wpp;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(48889);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.ai(2, this.wch);
            if (this.wcg != null) {
                aVar.e(3, this.wcg);
            }
            if (this.wpp != null) {
                aVar.e(4, this.wpp);
            }
            AppMethodBeat.o(48889);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += e.a.a.b.b.a.o(2, this.wch);
            if (this.wcg != null) {
                ix += e.a.a.b.b.a.f(3, this.wcg);
            }
            if (this.wpp != null) {
                ix += e.a.a.b.b.a.f(4, this.wpp);
            }
            AppMethodBeat.o(48889);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(48889);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bcw bcw = (bcw) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        hl hlVar = new hl();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = hlVar.populateBuilderWithField(aVar4, hlVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bcw.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(48889);
                    return 0;
                case 2:
                    bcw.wch = aVar3.BTU.ve();
                    AppMethodBeat.o(48889);
                    return 0;
                case 3:
                    bcw.wcg = aVar3.BTU.readString();
                    AppMethodBeat.o(48889);
                    return 0;
                case 4:
                    bcw.wpp = aVar3.BTU.readString();
                    AppMethodBeat.o(48889);
                    return 0;
                default:
                    AppMethodBeat.o(48889);
                    return -1;
            }
        } else {
            AppMethodBeat.o(48889);
            return -1;
        }
    }
}
