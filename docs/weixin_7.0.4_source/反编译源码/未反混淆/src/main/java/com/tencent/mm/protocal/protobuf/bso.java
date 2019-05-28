package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bso extends bsr {
    public azt wUJ;
    public String wkG;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(102385);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.wUJ != null) {
                aVar.iy(2, this.wUJ.computeSize());
                this.wUJ.writeFields(aVar);
            }
            if (this.wkG != null) {
                aVar.e(3, this.wkG);
            }
            AppMethodBeat.o(102385);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wUJ != null) {
                ix += e.a.a.a.ix(2, this.wUJ.computeSize());
            }
            if (this.wkG != null) {
                ix += e.a.a.b.b.a.f(3, this.wkG);
            }
            AppMethodBeat.o(102385);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(102385);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bso bso = (bso) objArr[1];
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
                        bso.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(102385);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        azt azt = new azt();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = azt.populateBuilderWithField(aVar4, azt, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bso.wUJ = azt;
                    }
                    AppMethodBeat.o(102385);
                    return 0;
                case 3:
                    bso.wkG = aVar3.BTU.readString();
                    AppMethodBeat.o(102385);
                    return 0;
                default:
                    AppMethodBeat.o(102385);
                    return -1;
            }
        } else {
            AppMethodBeat.o(102385);
            return -1;
        }
    }
}
