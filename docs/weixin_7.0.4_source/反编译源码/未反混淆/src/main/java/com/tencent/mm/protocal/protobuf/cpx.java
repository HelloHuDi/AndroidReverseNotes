package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class cpx extends a {
    public int jCt;
    public SKBuiltinBuffer_t vJd;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(5263);
        b bVar;
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vJd == null) {
                bVar = new b("Not all required fields were included: Buffer");
                AppMethodBeat.o(5263);
                throw bVar;
            }
            aVar.iz(1, this.jCt);
            if (this.vJd != null) {
                aVar.iy(2, this.vJd.computeSize());
                this.vJd.writeFields(aVar);
            }
            AppMethodBeat.o(5263);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.jCt) + 0;
            if (this.vJd != null) {
                bs += e.a.a.a.ix(2, this.vJd.computeSize());
            }
            AppMethodBeat.o(5263);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            if (this.vJd == null) {
                bVar = new b("Not all required fields were included: Buffer");
                AppMethodBeat.o(5263);
                throw bVar;
            }
            AppMethodBeat.o(5263);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cpx cpx = (cpx) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cpx.jCt = aVar3.BTU.vd();
                    AppMethodBeat.o(5263);
                    return 0;
                case 2:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        cpx.vJd = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(5263);
                    return 0;
                default:
                    AppMethodBeat.o(5263);
                    return -1;
            }
        } else {
            AppMethodBeat.o(5263);
            return -1;
        }
    }
}
