package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class cob extends a {
    public int ptx;
    public int xlA;
    public int xlB;
    public SKBuiltinBuffer_t xlC;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28702);
        b bVar;
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.xlC == null) {
                bVar = new b("Not all required fields were included: PieceData");
                AppMethodBeat.o(28702);
                throw bVar;
            }
            aVar.iz(1, this.ptx);
            aVar.iz(2, this.xlA);
            aVar.iz(3, this.xlB);
            if (this.xlC != null) {
                aVar.iy(4, this.xlC.computeSize());
                this.xlC.writeFields(aVar);
            }
            AppMethodBeat.o(28702);
            return 0;
        } else if (i == 1) {
            bs = ((e.a.a.b.b.a.bs(1, this.ptx) + 0) + e.a.a.b.b.a.bs(2, this.xlA)) + e.a.a.b.b.a.bs(3, this.xlB);
            if (this.xlC != null) {
                bs += e.a.a.a.ix(4, this.xlC.computeSize());
            }
            AppMethodBeat.o(28702);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            if (this.xlC == null) {
                bVar = new b("Not all required fields were included: PieceData");
                AppMethodBeat.o(28702);
                throw bVar;
            }
            AppMethodBeat.o(28702);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cob cob = (cob) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cob.ptx = aVar3.BTU.vd();
                    AppMethodBeat.o(28702);
                    return 0;
                case 2:
                    cob.xlA = aVar3.BTU.vd();
                    AppMethodBeat.o(28702);
                    return 0;
                case 3:
                    cob.xlB = aVar3.BTU.vd();
                    AppMethodBeat.o(28702);
                    return 0;
                case 4:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        cob.xlC = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(28702);
                    return 0;
                default:
                    AppMethodBeat.o(28702);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28702);
            return -1;
        }
    }
}
