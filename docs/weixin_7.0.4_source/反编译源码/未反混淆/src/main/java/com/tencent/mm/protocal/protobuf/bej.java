package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class bej extends a {
    public int Scene;
    public String vIk;
    public int vTN;
    public SKBuiltinBuffer_t vTO;
    public tc wIw;
    public int wIx;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(58922);
        b bVar;
        int ix;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wIw == null) {
                bVar = new b("Not all required fields were included: Oplog");
                AppMethodBeat.o(58922);
                throw bVar;
            } else if (this.vTO == null) {
                bVar = new b("Not all required fields were included: KeyBuf");
                AppMethodBeat.o(58922);
                throw bVar;
            } else {
                if (this.wIw != null) {
                    aVar.iy(1, this.wIw.computeSize());
                    this.wIw.writeFields(aVar);
                }
                aVar.iz(2, this.vTN);
                if (this.vTO != null) {
                    aVar.iy(3, this.vTO.computeSize());
                    this.vTO.writeFields(aVar);
                }
                aVar.iz(4, this.Scene);
                if (this.vIk != null) {
                    aVar.e(5, this.vIk);
                }
                aVar.iz(6, this.wIx);
                AppMethodBeat.o(58922);
                return 0;
            }
        } else if (i == 1) {
            if (this.wIw != null) {
                ix = e.a.a.a.ix(1, this.wIw.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += e.a.a.b.b.a.bs(2, this.vTN);
            if (this.vTO != null) {
                ix += e.a.a.a.ix(3, this.vTO.computeSize());
            }
            ix += e.a.a.b.b.a.bs(4, this.Scene);
            if (this.vIk != null) {
                ix += e.a.a.b.b.a.f(5, this.vIk);
            }
            int bs = ix + e.a.a.b.b.a.bs(6, this.wIx);
            AppMethodBeat.o(58922);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.wIw == null) {
                bVar = new b("Not all required fields were included: Oplog");
                AppMethodBeat.o(58922);
                throw bVar;
            } else if (this.vTO == null) {
                bVar = new b("Not all required fields were included: KeyBuf");
                AppMethodBeat.o(58922);
                throw bVar;
            } else {
                AppMethodBeat.o(58922);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bej bej = (bej) objArr[1];
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
                        tc tcVar = new tc();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = tcVar.populateBuilderWithField(aVar4, tcVar, a.getNextFieldNumber(aVar4))) {
                        }
                        bej.wIw = tcVar;
                    }
                    AppMethodBeat.o(58922);
                    return 0;
                case 2:
                    bej.vTN = aVar3.BTU.vd();
                    AppMethodBeat.o(58922);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        bej.vTO = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(58922);
                    return 0;
                case 4:
                    bej.Scene = aVar3.BTU.vd();
                    AppMethodBeat.o(58922);
                    return 0;
                case 5:
                    bej.vIk = aVar3.BTU.readString();
                    AppMethodBeat.o(58922);
                    return 0;
                case 6:
                    bej.wIx = aVar3.BTU.vd();
                    AppMethodBeat.o(58922);
                    return 0;
                default:
                    AppMethodBeat.o(58922);
                    return -1;
            }
        } else {
            AppMethodBeat.o(58922);
            return -1;
        }
    }
}
