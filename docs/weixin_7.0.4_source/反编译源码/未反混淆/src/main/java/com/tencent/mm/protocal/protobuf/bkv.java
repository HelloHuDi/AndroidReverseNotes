package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class bkv extends a {
    public civ wNQ;
    public int wpw;
    public String wpx;
    public String wpy;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28572);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.wpw);
            if (this.wpx != null) {
                aVar.e(2, this.wpx);
            }
            if (this.wpy != null) {
                aVar.e(3, this.wpy);
            }
            if (this.wNQ != null) {
                aVar.iy(4, this.wNQ.computeSize());
                this.wNQ.writeFields(aVar);
            }
            AppMethodBeat.o(28572);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.wpw) + 0;
            if (this.wpx != null) {
                bs += e.a.a.b.b.a.f(2, this.wpx);
            }
            if (this.wpy != null) {
                bs += e.a.a.b.b.a.f(3, this.wpy);
            }
            if (this.wNQ != null) {
                bs += e.a.a.a.ix(4, this.wNQ.computeSize());
            }
            AppMethodBeat.o(28572);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(28572);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bkv bkv = (bkv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bkv.wpw = aVar3.BTU.vd();
                    AppMethodBeat.o(28572);
                    return 0;
                case 2:
                    bkv.wpx = aVar3.BTU.readString();
                    AppMethodBeat.o(28572);
                    return 0;
                case 3:
                    bkv.wpy = aVar3.BTU.readString();
                    AppMethodBeat.o(28572);
                    return 0;
                case 4:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        civ civ = new civ();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = civ.populateBuilderWithField(aVar4, civ, a.getNextFieldNumber(aVar4))) {
                        }
                        bkv.wNQ = civ;
                    }
                    AppMethodBeat.o(28572);
                    return 0;
                default:
                    AppMethodBeat.o(28572);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28572);
            return -1;
        }
    }
}
