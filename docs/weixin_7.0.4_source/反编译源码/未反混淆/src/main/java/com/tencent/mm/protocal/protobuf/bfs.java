package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bfs extends bsr {
    public int OpCode;
    public int wJy;
    public LinkedList<coc> wJz = new LinkedList();

    public bfs() {
        AppMethodBeat.i(28567);
        AppMethodBeat.o(28567);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28568);
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.iz(2, this.OpCode);
            aVar.iz(3, this.wJy);
            aVar.e(4, 8, this.wJz);
            AppMethodBeat.o(28568);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            int bs = ((ix + e.a.a.b.b.a.bs(2, this.OpCode)) + e.a.a.b.b.a.bs(3, this.wJy)) + e.a.a.a.c(4, 8, this.wJz);
            AppMethodBeat.o(28568);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wJz.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(28568);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bfs bfs = (bfs) objArr[1];
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
                        bfs.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(28568);
                    return 0;
                case 2:
                    bfs.OpCode = aVar3.BTU.vd();
                    AppMethodBeat.o(28568);
                    return 0;
                case 3:
                    bfs.wJy = aVar3.BTU.vd();
                    AppMethodBeat.o(28568);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        coc coc = new coc();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = coc.populateBuilderWithField(aVar4, coc, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bfs.wJz.add(coc);
                    }
                    AppMethodBeat.o(28568);
                    return 0;
                default:
                    AppMethodBeat.o(28568);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28568);
            return -1;
        }
    }
}
