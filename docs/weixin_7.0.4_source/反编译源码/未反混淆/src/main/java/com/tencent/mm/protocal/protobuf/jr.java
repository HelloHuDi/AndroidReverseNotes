package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class jr extends btd {
    public int jBT;
    public int vCl;
    public int vCo;
    public SKBuiltinBuffer_t vEF;
    public SKBuiltinBuffer_t vHJ;
    public SKBuiltinBuffer_t vHP;
    public btv vLP;
    public String vLX;
    public bts vMa;
    public SKBuiltinBuffer_t vMb;
    public int vMd;
    public String vMe;
    public String vMf;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(73696);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(73696);
                throw bVar;
            } else if (this.vEF == null) {
                bVar = new b("Not all required fields were included: ImgBuf");
                AppMethodBeat.o(73696);
                throw bVar;
            } else {
                if (this.BaseResponse != null) {
                    aVar.iy(1, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(aVar);
                }
                if (this.vLX != null) {
                    aVar.e(2, this.vLX);
                }
                if (this.vEF != null) {
                    aVar.iy(3, this.vEF.computeSize());
                    this.vEF.writeFields(aVar);
                }
                aVar.iz(4, this.vCo);
                aVar.iz(5, this.vMd);
                if (this.vMe != null) {
                    aVar.e(6, this.vMe);
                }
                aVar.iz(7, this.jBT);
                if (this.vMf != null) {
                    aVar.e(8, this.vMf);
                }
                if (this.vMa != null) {
                    aVar.iy(9, this.vMa.computeSize());
                    this.vMa.writeFields(aVar);
                }
                if (this.vHP != null) {
                    aVar.iy(10, this.vHP.computeSize());
                    this.vHP.writeFields(aVar);
                }
                if (this.vMb != null) {
                    aVar.iy(11, this.vMb.computeSize());
                    this.vMb.writeFields(aVar);
                }
                if (this.vLP != null) {
                    aVar.iy(12, this.vLP.computeSize());
                    this.vLP.writeFields(aVar);
                }
                aVar.iz(13, this.vCl);
                if (this.vHJ != null) {
                    aVar.iy(14, this.vHJ.computeSize());
                    this.vHJ.writeFields(aVar);
                }
                AppMethodBeat.o(73696);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.vLX != null) {
                ix += e.a.a.b.b.a.f(2, this.vLX);
            }
            if (this.vEF != null) {
                ix += e.a.a.a.ix(3, this.vEF.computeSize());
            }
            ix = (ix + e.a.a.b.b.a.bs(4, this.vCo)) + e.a.a.b.b.a.bs(5, this.vMd);
            if (this.vMe != null) {
                ix += e.a.a.b.b.a.f(6, this.vMe);
            }
            ix += e.a.a.b.b.a.bs(7, this.jBT);
            if (this.vMf != null) {
                ix += e.a.a.b.b.a.f(8, this.vMf);
            }
            if (this.vMa != null) {
                ix += e.a.a.a.ix(9, this.vMa.computeSize());
            }
            if (this.vHP != null) {
                ix += e.a.a.a.ix(10, this.vHP.computeSize());
            }
            if (this.vMb != null) {
                ix += e.a.a.a.ix(11, this.vMb.computeSize());
            }
            if (this.vLP != null) {
                ix += e.a.a.a.ix(12, this.vLP.computeSize());
            }
            ix += e.a.a.b.b.a.bs(13, this.vCl);
            if (this.vHJ != null) {
                ix += e.a.a.a.ix(14, this.vHJ.computeSize());
            }
            AppMethodBeat.o(73696);
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
                AppMethodBeat.o(73696);
                throw bVar;
            } else if (this.vEF == null) {
                bVar = new b("Not all required fields were included: ImgBuf");
                AppMethodBeat.o(73696);
                throw bVar;
            } else {
                AppMethodBeat.o(73696);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            jr jrVar = (jr) objArr[1];
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
                        jrVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(73696);
                    return 0;
                case 2:
                    jrVar.vLX = aVar3.BTU.readString();
                    AppMethodBeat.o(73696);
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
                        jrVar.vEF = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(73696);
                    return 0;
                case 4:
                    jrVar.vCo = aVar3.BTU.vd();
                    AppMethodBeat.o(73696);
                    return 0;
                case 5:
                    jrVar.vMd = aVar3.BTU.vd();
                    AppMethodBeat.o(73696);
                    return 0;
                case 6:
                    jrVar.vMe = aVar3.BTU.readString();
                    AppMethodBeat.o(73696);
                    return 0;
                case 7:
                    jrVar.jBT = aVar3.BTU.vd();
                    AppMethodBeat.o(73696);
                    return 0;
                case 8:
                    jrVar.vMf = aVar3.BTU.readString();
                    AppMethodBeat.o(73696);
                    return 0;
                case 9:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        jrVar.vMa = bts;
                    }
                    AppMethodBeat.o(73696);
                    return 0;
                case 10:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        jrVar.vHP = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(73696);
                    return 0;
                case 11:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        jrVar.vMb = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(73696);
                    return 0;
                case 12:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        btv btv = new btv();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = btv.populateBuilderWithField(aVar4, btv, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        jrVar.vLP = btv;
                    }
                    AppMethodBeat.o(73696);
                    return 0;
                case 13:
                    jrVar.vCl = aVar3.BTU.vd();
                    AppMethodBeat.o(73696);
                    return 0;
                case 14:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        jrVar.vHJ = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(73696);
                    return 0;
                default:
                    AppMethodBeat.o(73696);
                    return -1;
            }
        } else {
            AppMethodBeat.o(73696);
            return -1;
        }
    }
}
