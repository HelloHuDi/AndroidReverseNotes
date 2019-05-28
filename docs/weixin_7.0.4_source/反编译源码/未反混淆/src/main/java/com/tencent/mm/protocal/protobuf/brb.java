package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class brb extends bsr {
    public int jCs;
    public int wTs;
    public cob wTt;
    public int wTu;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28615);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wTt == null) {
                bVar = new b("Not all required fields were included: PieceData");
                AppMethodBeat.o(28615);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.iz(2, this.jCs);
            aVar.iz(3, this.wTs);
            if (this.wTt != null) {
                aVar.iy(4, this.wTt.computeSize());
                this.wTt.writeFields(aVar);
            }
            aVar.iz(5, this.wTu);
            AppMethodBeat.o(28615);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (ix + e.a.a.b.b.a.bs(2, this.jCs)) + e.a.a.b.b.a.bs(3, this.wTs);
            if (this.wTt != null) {
                ix += e.a.a.a.ix(4, this.wTt.computeSize());
            }
            int bs = ix + e.a.a.b.b.a.bs(5, this.wTu);
            AppMethodBeat.o(28615);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.wTt == null) {
                bVar = new b("Not all required fields were included: PieceData");
                AppMethodBeat.o(28615);
                throw bVar;
            }
            AppMethodBeat.o(28615);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            brb brb = (brb) objArr[1];
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
                        brb.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(28615);
                    return 0;
                case 2:
                    brb.jCs = aVar3.BTU.vd();
                    AppMethodBeat.o(28615);
                    return 0;
                case 3:
                    brb.wTs = aVar3.BTU.vd();
                    AppMethodBeat.o(28615);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cob cob = new cob();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cob.populateBuilderWithField(aVar4, cob, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        brb.wTt = cob;
                    }
                    AppMethodBeat.o(28615);
                    return 0;
                case 5:
                    brb.wTu = aVar3.BTU.vd();
                    AppMethodBeat.o(28615);
                    return 0;
                default:
                    AppMethodBeat.o(28615);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28615);
            return -1;
        }
    }
}
