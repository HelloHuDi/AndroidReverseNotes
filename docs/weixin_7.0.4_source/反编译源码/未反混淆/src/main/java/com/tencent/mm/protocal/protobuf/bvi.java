package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class bvi extends a {
    public int Scene;
    public String luQ;
    public axy wDI;
    public String wWv;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(124357);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wWv != null) {
                aVar.e(1, this.wWv);
            }
            aVar.iz(2, this.Scene);
            if (this.luQ != null) {
                aVar.e(3, this.luQ);
            }
            if (this.wDI != null) {
                aVar.iy(4, this.wDI.computeSize());
                this.wDI.writeFields(aVar);
            }
            AppMethodBeat.o(124357);
            return 0;
        } else if (i == 1) {
            if (this.wWv != null) {
                f = e.a.a.b.b.a.f(1, this.wWv) + 0;
            } else {
                f = 0;
            }
            f += e.a.a.b.b.a.bs(2, this.Scene);
            if (this.luQ != null) {
                f += e.a.a.b.b.a.f(3, this.luQ);
            }
            if (this.wDI != null) {
                f += e.a.a.a.ix(4, this.wDI.computeSize());
            }
            AppMethodBeat.o(124357);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(124357);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bvi bvi = (bvi) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bvi.wWv = aVar3.BTU.readString();
                    AppMethodBeat.o(124357);
                    return 0;
                case 2:
                    bvi.Scene = aVar3.BTU.vd();
                    AppMethodBeat.o(124357);
                    return 0;
                case 3:
                    bvi.luQ = aVar3.BTU.readString();
                    AppMethodBeat.o(124357);
                    return 0;
                case 4:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        axy axy = new axy();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = axy.populateBuilderWithField(aVar4, axy, a.getNextFieldNumber(aVar4))) {
                        }
                        bvi.wDI = axy;
                    }
                    AppMethodBeat.o(124357);
                    return 0;
                default:
                    AppMethodBeat.o(124357);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124357);
            return -1;
        }
    }
}
