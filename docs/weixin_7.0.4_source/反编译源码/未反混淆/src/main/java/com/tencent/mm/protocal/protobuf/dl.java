package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class dl extends bsr {
    public SKBuiltinBuffer_t ReqBuf;
    public int jCt;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(80014);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.ReqBuf == null) {
                bVar = new b("Not all required fields were included: ReqBuf");
                AppMethodBeat.o(80014);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.iz(2, this.jCt);
            if (this.ReqBuf != null) {
                aVar.iy(3, this.ReqBuf.computeSize());
                this.ReqBuf.writeFields(aVar);
            }
            AppMethodBeat.o(80014);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += e.a.a.b.b.a.bs(2, this.jCt);
            if (this.ReqBuf != null) {
                ix += e.a.a.a.ix(3, this.ReqBuf.computeSize());
            }
            AppMethodBeat.o(80014);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.ReqBuf == null) {
                bVar = new b("Not all required fields were included: ReqBuf");
                AppMethodBeat.o(80014);
                throw bVar;
            }
            AppMethodBeat.o(80014);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            dl dlVar = (dl) objArr[1];
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
                        dlVar.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(80014);
                    return 0;
                case 2:
                    dlVar.jCt = aVar3.BTU.vd();
                    AppMethodBeat.o(80014);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        dlVar.ReqBuf = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(80014);
                    return 0;
                default:
                    AppMethodBeat.o(80014);
                    return -1;
            }
        } else {
            AppMethodBeat.o(80014);
            return -1;
        }
    }
}
