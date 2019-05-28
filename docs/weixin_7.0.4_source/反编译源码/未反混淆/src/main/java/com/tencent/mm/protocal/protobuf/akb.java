package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class akb extends bsr {
    public String vQq;
    public String vRN;
    public cx wpB;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56811);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wpB == null) {
                bVar = new b("Not all required fields were included: Address");
                AppMethodBeat.o(56811);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.vQq != null) {
                aVar.e(2, this.vQq);
            }
            if (this.vRN != null) {
                aVar.e(3, this.vRN);
            }
            if (this.wpB != null) {
                aVar.iy(4, this.wpB.computeSize());
                this.wpB.writeFields(aVar);
            }
            AppMethodBeat.o(56811);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.vQq != null) {
                ix += e.a.a.b.b.a.f(2, this.vQq);
            }
            if (this.vRN != null) {
                ix += e.a.a.b.b.a.f(3, this.vRN);
            }
            if (this.wpB != null) {
                ix += e.a.a.a.ix(4, this.wpB.computeSize());
            }
            AppMethodBeat.o(56811);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.wpB == null) {
                bVar = new b("Not all required fields were included: Address");
                AppMethodBeat.o(56811);
                throw bVar;
            }
            AppMethodBeat.o(56811);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            akb akb = (akb) objArr[1];
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
                        akb.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(56811);
                    return 0;
                case 2:
                    akb.vQq = aVar3.BTU.readString();
                    AppMethodBeat.o(56811);
                    return 0;
                case 3:
                    akb.vRN = aVar3.BTU.readString();
                    AppMethodBeat.o(56811);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cx cxVar = new cx();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cxVar.populateBuilderWithField(aVar4, cxVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        akb.wpB = cxVar;
                    }
                    AppMethodBeat.o(56811);
                    return 0;
                default:
                    AppMethodBeat.o(56811);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56811);
            return -1;
        }
    }
}
