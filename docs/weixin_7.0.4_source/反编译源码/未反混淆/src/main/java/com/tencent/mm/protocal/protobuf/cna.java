package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class cna extends btd {
    public SKBuiltinBuffer_t vEF;
    public SKBuiltinBuffer_t vHJ;
    public String vHO;
    public SKBuiltinBuffer_t vHP;
    public bts vMa;
    public SKBuiltinBuffer_t vMb;
    public String wdB;
    public bts wtZ;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(60073);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(60073);
                throw bVar;
            } else if (this.wtZ == null) {
                bVar = new b("Not all required fields were included: ImgSid");
                AppMethodBeat.o(60073);
                throw bVar;
            } else if (this.vEF == null) {
                bVar = new b("Not all required fields were included: ImgBuf");
                AppMethodBeat.o(60073);
                throw bVar;
            } else {
                if (this.BaseResponse != null) {
                    aVar.iy(1, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(aVar);
                }
                if (this.wtZ != null) {
                    aVar.iy(2, this.wtZ.computeSize());
                    this.wtZ.writeFields(aVar);
                }
                if (this.vEF != null) {
                    aVar.iy(3, this.vEF.computeSize());
                    this.vEF.writeFields(aVar);
                }
                if (this.wdB != null) {
                    aVar.e(4, this.wdB);
                }
                if (this.vMa != null) {
                    aVar.iy(5, this.vMa.computeSize());
                    this.vMa.writeFields(aVar);
                }
                if (this.vHP != null) {
                    aVar.iy(6, this.vHP.computeSize());
                    this.vHP.writeFields(aVar);
                }
                if (this.vMb != null) {
                    aVar.iy(7, this.vMb.computeSize());
                    this.vMb.writeFields(aVar);
                }
                if (this.vHO != null) {
                    aVar.e(8, this.vHO);
                }
                if (this.vHJ != null) {
                    aVar.iy(9, this.vHJ.computeSize());
                    this.vHJ.writeFields(aVar);
                }
                AppMethodBeat.o(60073);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wtZ != null) {
                ix += e.a.a.a.ix(2, this.wtZ.computeSize());
            }
            if (this.vEF != null) {
                ix += e.a.a.a.ix(3, this.vEF.computeSize());
            }
            if (this.wdB != null) {
                ix += e.a.a.b.b.a.f(4, this.wdB);
            }
            if (this.vMa != null) {
                ix += e.a.a.a.ix(5, this.vMa.computeSize());
            }
            if (this.vHP != null) {
                ix += e.a.a.a.ix(6, this.vHP.computeSize());
            }
            if (this.vMb != null) {
                ix += e.a.a.a.ix(7, this.vMb.computeSize());
            }
            if (this.vHO != null) {
                ix += e.a.a.b.b.a.f(8, this.vHO);
            }
            if (this.vHJ != null) {
                ix += e.a.a.a.ix(9, this.vHJ.computeSize());
            }
            AppMethodBeat.o(60073);
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
                AppMethodBeat.o(60073);
                throw bVar;
            } else if (this.wtZ == null) {
                bVar = new b("Not all required fields were included: ImgSid");
                AppMethodBeat.o(60073);
                throw bVar;
            } else if (this.vEF == null) {
                bVar = new b("Not all required fields were included: ImgBuf");
                AppMethodBeat.o(60073);
                throw bVar;
            } else {
                AppMethodBeat.o(60073);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cna cna = (cna) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            e.a.a.a.a aVar4;
            boolean z;
            bts bts;
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
                        cna.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(60073);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cna.wtZ = bts;
                    }
                    AppMethodBeat.o(60073);
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
                        cna.vEF = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(60073);
                    return 0;
                case 4:
                    cna.wdB = aVar3.BTU.readString();
                    AppMethodBeat.o(60073);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cna.vMa = bts;
                    }
                    AppMethodBeat.o(60073);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cna.vHP = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(60073);
                    return 0;
                case 7:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cna.vMb = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(60073);
                    return 0;
                case 8:
                    cna.vHO = aVar3.BTU.readString();
                    AppMethodBeat.o(60073);
                    return 0;
                case 9:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cna.vHJ = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(60073);
                    return 0;
                default:
                    AppMethodBeat.o(60073);
                    return -1;
            }
        } else {
            AppMethodBeat.o(60073);
            return -1;
        }
    }
}
