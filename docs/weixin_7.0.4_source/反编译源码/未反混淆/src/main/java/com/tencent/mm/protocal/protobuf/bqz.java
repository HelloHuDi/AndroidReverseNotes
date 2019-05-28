package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bqz extends bsr {
    public int Cn;
    public SKBuiltinBuffer_t wTq;
    public SKBuiltinBuffer_t wTr;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(51771);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.wTq != null) {
                aVar.iy(2, this.wTq.computeSize());
                this.wTq.writeFields(aVar);
            }
            if (this.wTr != null) {
                aVar.iy(3, this.wTr.computeSize());
                this.wTr.writeFields(aVar);
            }
            aVar.iz(4, this.Cn);
            AppMethodBeat.o(51771);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wTq != null) {
                ix += e.a.a.a.ix(2, this.wTq.computeSize());
            }
            if (this.wTr != null) {
                ix += e.a.a.a.ix(3, this.wTr.computeSize());
            }
            int bs = ix + e.a.a.b.b.a.bs(4, this.Cn);
            AppMethodBeat.o(51771);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(51771);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bqz bqz = (bqz) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            e.a.a.a.a aVar4;
            boolean z;
            SKBuiltinBuffer_t sKBuiltinBuffer_t;
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
                        bqz.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(51771);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bqz.wTq = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(51771);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bqz.wTr = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(51771);
                    return 0;
                case 4:
                    bqz.Cn = aVar3.BTU.vd();
                    AppMethodBeat.o(51771);
                    return 0;
                default:
                    AppMethodBeat.o(51771);
                    return -1;
            }
        } else {
            AppMethodBeat.o(51771);
            return -1;
        }
    }
}
