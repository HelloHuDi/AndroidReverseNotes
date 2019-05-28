package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ank extends bsr {
    public long bHi;
    public int bNT = 5;
    public int wsg;
    public oo wsh;
    public sq wsi;
    public int wsj;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(134430);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.iz(2, this.wsg);
            aVar.iz(3, this.bNT);
            if (this.wsh != null) {
                aVar.iy(4, this.wsh.computeSize());
                this.wsh.writeFields(aVar);
            }
            aVar.ai(5, this.bHi);
            if (this.wsi != null) {
                aVar.iy(6, this.wsi.computeSize());
                this.wsi.writeFields(aVar);
            }
            aVar.iz(7, this.wsj);
            AppMethodBeat.o(134430);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (ix + e.a.a.b.b.a.bs(2, this.wsg)) + e.a.a.b.b.a.bs(3, this.bNT);
            if (this.wsh != null) {
                ix += e.a.a.a.ix(4, this.wsh.computeSize());
            }
            ix += e.a.a.b.b.a.o(5, this.bHi);
            if (this.wsi != null) {
                ix += e.a.a.a.ix(6, this.wsi.computeSize());
            }
            int bs = ix + e.a.a.b.b.a.bs(7, this.wsj);
            AppMethodBeat.o(134430);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(134430);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ank ank = (ank) objArr[1];
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
                        ank.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(134430);
                    return 0;
                case 2:
                    ank.wsg = aVar3.BTU.vd();
                    AppMethodBeat.o(134430);
                    return 0;
                case 3:
                    ank.bNT = aVar3.BTU.vd();
                    AppMethodBeat.o(134430);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        oo ooVar = new oo();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ooVar.populateBuilderWithField(aVar4, ooVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        ank.wsh = ooVar;
                    }
                    AppMethodBeat.o(134430);
                    return 0;
                case 5:
                    ank.bHi = aVar3.BTU.ve();
                    AppMethodBeat.o(134430);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sq sqVar = new sq();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sqVar.populateBuilderWithField(aVar4, sqVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        ank.wsi = sqVar;
                    }
                    AppMethodBeat.o(134430);
                    return 0;
                case 7:
                    ank.wsj = aVar3.BTU.vd();
                    AppMethodBeat.o(134430);
                    return 0;
                default:
                    AppMethodBeat.o(134430);
                    return -1;
            }
        } else {
            AppMethodBeat.o(134430);
            return -1;
        }
    }
}
