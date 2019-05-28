package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class cfa extends btd {
    public int vQe;
    public SKBuiltinBuffer_t vTO;
    public tc vTR;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56546);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(56546);
                throw bVar;
            } else if (this.vTR == null) {
                bVar = new b("Not all required fields were included: CmdList");
                AppMethodBeat.o(56546);
                throw bVar;
            } else if (this.vTO == null) {
                bVar = new b("Not all required fields were included: KeyBuf");
                AppMethodBeat.o(56546);
                throw bVar;
            } else {
                if (this.BaseResponse != null) {
                    aVar.iy(1, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(aVar);
                }
                if (this.vTR != null) {
                    aVar.iy(2, this.vTR.computeSize());
                    this.vTR.writeFields(aVar);
                }
                aVar.iz(3, this.vQe);
                if (this.vTO != null) {
                    aVar.iy(4, this.vTO.computeSize());
                    this.vTO.writeFields(aVar);
                }
                AppMethodBeat.o(56546);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.vTR != null) {
                ix += e.a.a.a.ix(2, this.vTR.computeSize());
            }
            ix += e.a.a.b.b.a.bs(3, this.vQe);
            if (this.vTO != null) {
                ix += e.a.a.a.ix(4, this.vTO.computeSize());
            }
            AppMethodBeat.o(56546);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(56546);
                throw bVar;
            } else if (this.vTR == null) {
                bVar = new b("Not all required fields were included: CmdList");
                AppMethodBeat.o(56546);
                throw bVar;
            } else if (this.vTO == null) {
                bVar = new b("Not all required fields were included: KeyBuf");
                AppMethodBeat.o(56546);
                throw bVar;
            } else {
                AppMethodBeat.o(56546);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cfa cfa = (cfa) objArr[1];
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
                        BaseResponse baseResponse = new BaseResponse();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = baseResponse.populateBuilderWithField(aVar4, baseResponse, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cfa.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(56546);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        tc tcVar = new tc();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = tcVar.populateBuilderWithField(aVar4, tcVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cfa.vTR = tcVar;
                    }
                    AppMethodBeat.o(56546);
                    return 0;
                case 3:
                    cfa.vQe = aVar3.BTU.vd();
                    AppMethodBeat.o(56546);
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
                        cfa.vTO = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(56546);
                    return 0;
                default:
                    AppMethodBeat.o(56546);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56546);
            return -1;
        }
    }
}
