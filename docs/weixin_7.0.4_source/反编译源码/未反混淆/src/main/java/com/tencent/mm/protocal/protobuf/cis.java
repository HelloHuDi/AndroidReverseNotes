package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class cis extends a {
    public int Ret;
    public SKBuiltinBuffer_t wlw;
    public int xhA;
    public String xhD;
    public String xhE;
    public int xhF;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28675);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.xhA);
            if (this.xhD != null) {
                aVar.e(2, this.xhD);
            }
            aVar.iz(3, this.Ret);
            if (this.xhE != null) {
                aVar.e(4, this.xhE);
            }
            if (this.wlw != null) {
                aVar.iy(5, this.wlw.computeSize());
                this.wlw.writeFields(aVar);
            }
            aVar.iz(6, this.xhF);
            AppMethodBeat.o(28675);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.xhA) + 0;
            if (this.xhD != null) {
                bs += e.a.a.b.b.a.f(2, this.xhD);
            }
            bs += e.a.a.b.b.a.bs(3, this.Ret);
            if (this.xhE != null) {
                bs += e.a.a.b.b.a.f(4, this.xhE);
            }
            if (this.wlw != null) {
                bs += e.a.a.a.ix(5, this.wlw.computeSize());
            }
            bs += e.a.a.b.b.a.bs(6, this.xhF);
            AppMethodBeat.o(28675);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(28675);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cis cis = (cis) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cis.xhA = aVar3.BTU.vd();
                    AppMethodBeat.o(28675);
                    return 0;
                case 2:
                    cis.xhD = aVar3.BTU.readString();
                    AppMethodBeat.o(28675);
                    return 0;
                case 3:
                    cis.Ret = aVar3.BTU.vd();
                    AppMethodBeat.o(28675);
                    return 0;
                case 4:
                    cis.xhE = aVar3.BTU.readString();
                    AppMethodBeat.o(28675);
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
                        cis.wlw = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(28675);
                    return 0;
                case 6:
                    cis.xhF = aVar3.BTU.vd();
                    AppMethodBeat.o(28675);
                    return 0;
                default:
                    AppMethodBeat.o(28675);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28675);
            return -1;
        }
    }
}
