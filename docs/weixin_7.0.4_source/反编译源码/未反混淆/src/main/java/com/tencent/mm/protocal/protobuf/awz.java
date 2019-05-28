package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class awz extends bsr {
    public SKBuiltinBuffer_t vLz;
    public int wBh;
    public SKBuiltinBuffer_t wBi;
    public SKBuiltinBuffer_t wBj;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(72859);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wBi == null) {
                bVar = new b("Not all required fields were included: KVBuffer");
                AppMethodBeat.o(72859);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.iz(2, this.wBh);
            if (this.wBi != null) {
                aVar.iy(3, this.wBi.computeSize());
                this.wBi.writeFields(aVar);
            }
            if (this.vLz != null) {
                aVar.iy(4, this.vLz.computeSize());
                this.vLz.writeFields(aVar);
            }
            if (this.wBj != null) {
                aVar.iy(5, this.wBj.computeSize());
                this.wBj.writeFields(aVar);
            }
            AppMethodBeat.o(72859);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += e.a.a.b.b.a.bs(2, this.wBh);
            if (this.wBi != null) {
                ix += e.a.a.a.ix(3, this.wBi.computeSize());
            }
            if (this.vLz != null) {
                ix += e.a.a.a.ix(4, this.vLz.computeSize());
            }
            if (this.wBj != null) {
                ix += e.a.a.a.ix(5, this.wBj.computeSize());
            }
            AppMethodBeat.o(72859);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.wBi == null) {
                bVar = new b("Not all required fields were included: KVBuffer");
                AppMethodBeat.o(72859);
                throw bVar;
            }
            AppMethodBeat.o(72859);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            awz awz = (awz) objArr[1];
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
                        awz.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(72859);
                    return 0;
                case 2:
                    awz.wBh = aVar3.BTU.vd();
                    AppMethodBeat.o(72859);
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
                        awz.wBi = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(72859);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        awz.vLz = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(72859);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        awz.wBj = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(72859);
                    return 0;
                default:
                    AppMethodBeat.o(72859);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72859);
            return -1;
        }
    }
}
