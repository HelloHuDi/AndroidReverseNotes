package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class byf extends bsr {
    public String luH;
    public SKBuiltinBuffer_t vHH;
    public int wXE;
    public String wdB;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(123519);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.luH != null) {
                aVar.e(2, this.luH);
            }
            if (this.wdB != null) {
                aVar.e(3, this.wdB);
            }
            if (this.vHH != null) {
                aVar.iy(4, this.vHH.computeSize());
                this.vHH.writeFields(aVar);
            }
            aVar.iz(5, this.wXE);
            AppMethodBeat.o(123519);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.luH != null) {
                ix += e.a.a.b.b.a.f(2, this.luH);
            }
            if (this.wdB != null) {
                ix += e.a.a.b.b.a.f(3, this.wdB);
            }
            if (this.vHH != null) {
                ix += e.a.a.a.ix(4, this.vHH.computeSize());
            }
            int bs = ix + e.a.a.b.b.a.bs(5, this.wXE);
            AppMethodBeat.o(123519);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(123519);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            byf byf = (byf) objArr[1];
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
                        byf.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(123519);
                    return 0;
                case 2:
                    byf.luH = aVar3.BTU.readString();
                    AppMethodBeat.o(123519);
                    return 0;
                case 3:
                    byf.wdB = aVar3.BTU.readString();
                    AppMethodBeat.o(123519);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        byf.vHH = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(123519);
                    return 0;
                case 5:
                    byf.wXE = aVar3.BTU.vd();
                    AppMethodBeat.o(123519);
                    return 0;
                default:
                    AppMethodBeat.o(123519);
                    return -1;
            }
        } else {
            AppMethodBeat.o(123519);
            return -1;
        }
    }
}
