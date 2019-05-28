package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class cir extends a {
    public int Scene;
    public SKBuiltinBuffer_t wlw;
    public int xhA;
    public String xhB;
    public String xhC;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28674);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.xhA);
            if (this.xhB != null) {
                aVar.e(2, this.xhB);
            }
            if (this.xhC != null) {
                aVar.e(3, this.xhC);
            }
            aVar.iz(4, this.Scene);
            if (this.wlw != null) {
                aVar.iy(5, this.wlw.computeSize());
                this.wlw.writeFields(aVar);
            }
            AppMethodBeat.o(28674);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.xhA) + 0;
            if (this.xhB != null) {
                bs += e.a.a.b.b.a.f(2, this.xhB);
            }
            if (this.xhC != null) {
                bs += e.a.a.b.b.a.f(3, this.xhC);
            }
            bs += e.a.a.b.b.a.bs(4, this.Scene);
            if (this.wlw != null) {
                bs += e.a.a.a.ix(5, this.wlw.computeSize());
            }
            AppMethodBeat.o(28674);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(28674);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cir cir = (cir) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cir.xhA = aVar3.BTU.vd();
                    AppMethodBeat.o(28674);
                    return 0;
                case 2:
                    cir.xhB = aVar3.BTU.readString();
                    AppMethodBeat.o(28674);
                    return 0;
                case 3:
                    cir.xhC = aVar3.BTU.readString();
                    AppMethodBeat.o(28674);
                    return 0;
                case 4:
                    cir.Scene = aVar3.BTU.vd();
                    AppMethodBeat.o(28674);
                    return 0;
                case 5:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        cir.wlw = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(28674);
                    return 0;
                default:
                    AppMethodBeat.o(28674);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28674);
            return -1;
        }
    }
}
