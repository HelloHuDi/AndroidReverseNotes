package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bda extends bsr {
    public String wpp;
    public bkc wxt;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(48893);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.wxt != null) {
                aVar.iy(2, this.wxt.computeSize());
                this.wxt.writeFields(aVar);
            }
            if (this.wpp != null) {
                aVar.e(3, this.wpp);
            }
            AppMethodBeat.o(48893);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wxt != null) {
                ix += e.a.a.a.ix(2, this.wxt.computeSize());
            }
            if (this.wpp != null) {
                ix += e.a.a.b.b.a.f(3, this.wpp);
            }
            AppMethodBeat.o(48893);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(48893);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bda bda = (bda) objArr[1];
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
                        hl hlVar = new hl();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = hlVar.populateBuilderWithField(aVar4, hlVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bda.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(48893);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bkc bkc = new bkc();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bkc.populateBuilderWithField(aVar4, bkc, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bda.wxt = bkc;
                    }
                    AppMethodBeat.o(48893);
                    return 0;
                case 3:
                    bda.wpp = aVar3.BTU.readString();
                    AppMethodBeat.o(48893);
                    return 0;
                default:
                    AppMethodBeat.o(48893);
                    return -1;
            }
        } else {
            AppMethodBeat.o(48893);
            return -1;
        }
    }
}
