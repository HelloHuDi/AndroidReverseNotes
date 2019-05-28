package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ast extends btd {
    public SKBuiltinBuffer_t vHG;
    public SKBuiltinBuffer_t wwA;
    public int wwB;
    public int wwC;
    public int wwD;
    public SKBuiltinBuffer_t wwz;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28519);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(28519);
                throw bVar;
            } else if (this.vHG == null) {
                bVar = new b("Not all required fields were included: SessionKey");
                AppMethodBeat.o(28519);
                throw bVar;
            } else if (this.wwz == null) {
                bVar = new b("Not all required fields were included: SessionBuffer");
                AppMethodBeat.o(28519);
                throw bVar;
            } else if (this.wwA == null) {
                bVar = new b("Not all required fields were included: KeyBuffer");
                AppMethodBeat.o(28519);
                throw bVar;
            } else {
                if (this.BaseResponse != null) {
                    aVar.iy(1, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(aVar);
                }
                if (this.vHG != null) {
                    aVar.iy(2, this.vHG.computeSize());
                    this.vHG.writeFields(aVar);
                }
                if (this.wwz != null) {
                    aVar.iy(3, this.wwz.computeSize());
                    this.wwz.writeFields(aVar);
                }
                if (this.wwA != null) {
                    aVar.iy(4, this.wwA.computeSize());
                    this.wwA.writeFields(aVar);
                }
                aVar.iz(5, this.wwB);
                aVar.iz(6, this.wwC);
                aVar.iz(7, this.wwD);
                AppMethodBeat.o(28519);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.vHG != null) {
                ix += e.a.a.a.ix(2, this.vHG.computeSize());
            }
            if (this.wwz != null) {
                ix += e.a.a.a.ix(3, this.wwz.computeSize());
            }
            if (this.wwA != null) {
                ix += e.a.a.a.ix(4, this.wwA.computeSize());
            }
            int bs = ((ix + e.a.a.b.b.a.bs(5, this.wwB)) + e.a.a.b.b.a.bs(6, this.wwC)) + e.a.a.b.b.a.bs(7, this.wwD);
            AppMethodBeat.o(28519);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(28519);
                throw bVar;
            } else if (this.vHG == null) {
                bVar = new b("Not all required fields were included: SessionKey");
                AppMethodBeat.o(28519);
                throw bVar;
            } else if (this.wwz == null) {
                bVar = new b("Not all required fields were included: SessionBuffer");
                AppMethodBeat.o(28519);
                throw bVar;
            } else if (this.wwA == null) {
                bVar = new b("Not all required fields were included: KeyBuffer");
                AppMethodBeat.o(28519);
                throw bVar;
            } else {
                AppMethodBeat.o(28519);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ast ast = (ast) objArr[1];
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
                        BaseResponse baseResponse = new BaseResponse();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = baseResponse.populateBuilderWithField(aVar4, baseResponse, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        ast.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(28519);
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
                        ast.vHG = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(28519);
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
                        ast.wwz = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(28519);
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
                        ast.wwA = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(28519);
                    return 0;
                case 5:
                    ast.wwB = aVar3.BTU.vd();
                    AppMethodBeat.o(28519);
                    return 0;
                case 6:
                    ast.wwC = aVar3.BTU.vd();
                    AppMethodBeat.o(28519);
                    return 0;
                case 7:
                    ast.wwD = aVar3.BTU.vd();
                    AppMethodBeat.o(28519);
                    return 0;
                default:
                    AppMethodBeat.o(28519);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28519);
            return -1;
        }
    }
}
