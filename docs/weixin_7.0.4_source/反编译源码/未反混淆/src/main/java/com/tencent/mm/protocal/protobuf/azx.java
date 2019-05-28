package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class azx extends a {
    public int Scene;
    public String luQ;
    public int wDH;
    public axy wDI;
    public int wDJ;
    public long wDK;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(124325);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.Scene);
            aVar.iz(2, this.wDH);
            if (this.wDI != null) {
                aVar.iy(3, this.wDI.computeSize());
                this.wDI.writeFields(aVar);
            }
            aVar.iz(4, this.wDJ);
            if (this.luQ != null) {
                aVar.e(5, this.luQ);
            }
            aVar.ai(6, this.wDK);
            AppMethodBeat.o(124325);
            return 0;
        } else if (i == 1) {
            bs = (e.a.a.b.b.a.bs(1, this.Scene) + 0) + e.a.a.b.b.a.bs(2, this.wDH);
            if (this.wDI != null) {
                bs += e.a.a.a.ix(3, this.wDI.computeSize());
            }
            bs += e.a.a.b.b.a.bs(4, this.wDJ);
            if (this.luQ != null) {
                bs += e.a.a.b.b.a.f(5, this.luQ);
            }
            bs += e.a.a.b.b.a.o(6, this.wDK);
            AppMethodBeat.o(124325);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(124325);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            azx azx = (azx) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    azx.Scene = aVar3.BTU.vd();
                    AppMethodBeat.o(124325);
                    return 0;
                case 2:
                    azx.wDH = aVar3.BTU.vd();
                    AppMethodBeat.o(124325);
                    return 0;
                case 3:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        axy axy = new axy();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = axy.populateBuilderWithField(aVar4, axy, a.getNextFieldNumber(aVar4))) {
                        }
                        azx.wDI = axy;
                    }
                    AppMethodBeat.o(124325);
                    return 0;
                case 4:
                    azx.wDJ = aVar3.BTU.vd();
                    AppMethodBeat.o(124325);
                    return 0;
                case 5:
                    azx.luQ = aVar3.BTU.readString();
                    AppMethodBeat.o(124325);
                    return 0;
                case 6:
                    azx.wDK = aVar3.BTU.ve();
                    AppMethodBeat.o(124325);
                    return 0;
                default:
                    AppMethodBeat.o(124325);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124325);
            return -1;
        }
    }
}
