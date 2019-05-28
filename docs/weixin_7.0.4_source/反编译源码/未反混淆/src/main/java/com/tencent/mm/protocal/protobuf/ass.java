package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ass extends bsr {
    public asq vLi;
    public int wwx;
    public SKBuiltinBuffer_t wwy;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28518);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.vLi == null) {
                bVar = new b("Not all required fields were included: HardDevice");
                AppMethodBeat.o(28518);
                throw bVar;
            } else if (this.wwy == null) {
                bVar = new b("Not all required fields were included: AuthBuffer");
                AppMethodBeat.o(28518);
                throw bVar;
            } else {
                if (this.BaseRequest != null) {
                    aVar.iy(1, this.BaseRequest.computeSize());
                    this.BaseRequest.writeFields(aVar);
                }
                if (this.vLi != null) {
                    aVar.iy(2, this.vLi.computeSize());
                    this.vLi.writeFields(aVar);
                }
                aVar.iz(3, this.wwx);
                if (this.wwy != null) {
                    aVar.iy(4, this.wwy.computeSize());
                    this.wwy.writeFields(aVar);
                }
                AppMethodBeat.o(28518);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.vLi != null) {
                ix += e.a.a.a.ix(2, this.vLi.computeSize());
            }
            ix += e.a.a.b.b.a.bs(3, this.wwx);
            if (this.wwy != null) {
                ix += e.a.a.a.ix(4, this.wwy.computeSize());
            }
            AppMethodBeat.o(28518);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.vLi == null) {
                bVar = new b("Not all required fields were included: HardDevice");
                AppMethodBeat.o(28518);
                throw bVar;
            } else if (this.wwy == null) {
                bVar = new b("Not all required fields were included: AuthBuffer");
                AppMethodBeat.o(28518);
                throw bVar;
            } else {
                AppMethodBeat.o(28518);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ass ass = (ass) objArr[1];
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
                        ass.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(28518);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        asq asq = new asq();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = asq.populateBuilderWithField(aVar4, asq, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        ass.vLi = asq;
                    }
                    AppMethodBeat.o(28518);
                    return 0;
                case 3:
                    ass.wwx = aVar3.BTU.vd();
                    AppMethodBeat.o(28518);
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
                        ass.wwy = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(28518);
                    return 0;
                default:
                    AppMethodBeat.o(28518);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28518);
            return -1;
        }
    }
}
