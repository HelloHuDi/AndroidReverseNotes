package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class coz extends bsr {
    public long wen;
    public long xeF;
    public LinkedList<coy> xmJ = new LinkedList();

    public coz() {
        AppMethodBeat.i(135455);
        AppMethodBeat.o(135455);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(135456);
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.ai(2, this.xeF);
            aVar.ai(3, this.wen);
            aVar.e(4, 8, this.xmJ);
            AppMethodBeat.o(135456);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            int o = ((ix + e.a.a.b.b.a.o(2, this.xeF)) + e.a.a.b.b.a.o(3, this.wen)) + e.a.a.a.c(4, 8, this.xmJ);
            AppMethodBeat.o(135456);
            return o;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xmJ.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(135456);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            coz coz = (coz) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
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
                        coz.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(135456);
                    return 0;
                case 2:
                    coz.xeF = aVar3.BTU.ve();
                    AppMethodBeat.o(135456);
                    return 0;
                case 3:
                    coz.wen = aVar3.BTU.ve();
                    AppMethodBeat.o(135456);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        coy coy = new coy();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = coy.populateBuilderWithField(aVar4, coy, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        coz.xmJ.add(coy);
                    }
                    AppMethodBeat.o(135456);
                    return 0;
                default:
                    AppMethodBeat.o(135456);
                    return -1;
            }
        } else {
            AppMethodBeat.o(135456);
            return -1;
        }
    }
}
