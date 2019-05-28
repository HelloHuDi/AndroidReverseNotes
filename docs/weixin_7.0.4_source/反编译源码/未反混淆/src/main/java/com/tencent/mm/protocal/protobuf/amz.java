package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class amz extends btd {
    public SKBuiltinBuffer_t wrC;
    public SKBuiltinBuffer_t wrD;
    public SKBuiltinBuffer_t wrE;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(105147);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(105147);
                throw bVar;
            } else if (this.wrC == null) {
                bVar = new b("Not all required fields were included: SongLyric");
                AppMethodBeat.o(105147);
                throw bVar;
            } else {
                if (this.BaseResponse != null) {
                    aVar.iy(1, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(aVar);
                }
                if (this.wrC != null) {
                    aVar.iy(2, this.wrC.computeSize());
                    this.wrC.writeFields(aVar);
                }
                if (this.wrD != null) {
                    aVar.iy(3, this.wrD.computeSize());
                    this.wrD.writeFields(aVar);
                }
                if (this.wrE != null) {
                    aVar.iy(4, this.wrE.computeSize());
                    this.wrE.writeFields(aVar);
                }
                AppMethodBeat.o(105147);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wrC != null) {
                ix += e.a.a.a.ix(2, this.wrC.computeSize());
            }
            if (this.wrD != null) {
                ix += e.a.a.a.ix(3, this.wrD.computeSize());
            }
            if (this.wrE != null) {
                ix += e.a.a.a.ix(4, this.wrE.computeSize());
            }
            AppMethodBeat.o(105147);
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
                AppMethodBeat.o(105147);
                throw bVar;
            } else if (this.wrC == null) {
                bVar = new b("Not all required fields were included: SongLyric");
                AppMethodBeat.o(105147);
                throw bVar;
            } else {
                AppMethodBeat.o(105147);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            amz amz = (amz) objArr[1];
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
                        amz.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(105147);
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
                        amz.wrC = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(105147);
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
                        amz.wrD = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(105147);
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
                        amz.wrE = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(105147);
                    return 0;
                default:
                    AppMethodBeat.o(105147);
                    return -1;
            }
        } else {
            AppMethodBeat.o(105147);
            return -1;
        }
    }
}
