package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class st extends a {
    public int wah;
    public SKBuiltinBuffer_t wai;
    public int waj;
    public SKBuiltinBuffer_t wak;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(126189);
        b bVar;
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wai == null) {
                bVar = new b("Not all required fields were included: OperationInfo");
                AppMethodBeat.o(126189);
                throw bVar;
            }
            aVar.iz(1, this.wah);
            if (this.wai != null) {
                aVar.iy(2, this.wai.computeSize());
                this.wai.writeFields(aVar);
            }
            aVar.iz(3, this.waj);
            if (this.wak != null) {
                aVar.iy(4, this.wak.computeSize());
                this.wak.writeFields(aVar);
            }
            AppMethodBeat.o(126189);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.wah) + 0;
            if (this.wai != null) {
                bs += e.a.a.a.ix(2, this.wai.computeSize());
            }
            bs += e.a.a.b.b.a.bs(3, this.waj);
            if (this.wak != null) {
                bs += e.a.a.a.ix(4, this.wak.computeSize());
            }
            AppMethodBeat.o(126189);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            if (this.wai == null) {
                bVar = new b("Not all required fields were included: OperationInfo");
                AppMethodBeat.o(126189);
                throw bVar;
            }
            AppMethodBeat.o(126189);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            st stVar = (st) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            SKBuiltinBuffer_t sKBuiltinBuffer_t;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    stVar.wah = aVar3.BTU.vd();
                    AppMethodBeat.o(126189);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        stVar.wai = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(126189);
                    return 0;
                case 3:
                    stVar.waj = aVar3.BTU.vd();
                    AppMethodBeat.o(126189);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        stVar.wak = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(126189);
                    return 0;
                default:
                    AppMethodBeat.o(126189);
                    return -1;
            }
        } else {
            AppMethodBeat.o(126189);
            return -1;
        }
    }
}
