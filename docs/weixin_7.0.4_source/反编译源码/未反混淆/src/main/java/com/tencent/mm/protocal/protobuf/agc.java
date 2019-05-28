package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class agc extends btd {
    public mw vMl;
    public mw vMm;
    public mw vMn;
    public SKBuiltinBuffer_t vMo;
    public SKBuiltinBuffer_t vMp;
    public mw vMq;
    public int vMr;
    public mv vMs;
    public mv vMt;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(80070);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(80070);
                throw bVar;
            } else if (this.vMl == null) {
                bVar = new b("Not all required fields were included: DnsInfo");
                AppMethodBeat.o(80070);
                throw bVar;
            } else {
                if (this.BaseResponse != null) {
                    aVar.iy(1, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(aVar);
                }
                if (this.vMl != null) {
                    aVar.iy(2, this.vMl.computeSize());
                    this.vMl.writeFields(aVar);
                }
                if (this.vMm != null) {
                    aVar.iy(3, this.vMm.computeSize());
                    this.vMm.writeFields(aVar);
                }
                if (this.vMn != null) {
                    aVar.iy(4, this.vMn.computeSize());
                    this.vMn.writeFields(aVar);
                }
                if (this.vMo != null) {
                    aVar.iy(5, this.vMo.computeSize());
                    this.vMo.writeFields(aVar);
                }
                if (this.vMp != null) {
                    aVar.iy(6, this.vMp.computeSize());
                    this.vMp.writeFields(aVar);
                }
                if (this.vMq != null) {
                    aVar.iy(7, this.vMq.computeSize());
                    this.vMq.writeFields(aVar);
                }
                aVar.iz(8, this.vMr);
                if (this.vMs != null) {
                    aVar.iy(9, this.vMs.computeSize());
                    this.vMs.writeFields(aVar);
                }
                if (this.vMt != null) {
                    aVar.iy(10, this.vMt.computeSize());
                    this.vMt.writeFields(aVar);
                }
                AppMethodBeat.o(80070);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.vMl != null) {
                ix += e.a.a.a.ix(2, this.vMl.computeSize());
            }
            if (this.vMm != null) {
                ix += e.a.a.a.ix(3, this.vMm.computeSize());
            }
            if (this.vMn != null) {
                ix += e.a.a.a.ix(4, this.vMn.computeSize());
            }
            if (this.vMo != null) {
                ix += e.a.a.a.ix(5, this.vMo.computeSize());
            }
            if (this.vMp != null) {
                ix += e.a.a.a.ix(6, this.vMp.computeSize());
            }
            if (this.vMq != null) {
                ix += e.a.a.a.ix(7, this.vMq.computeSize());
            }
            ix += e.a.a.b.b.a.bs(8, this.vMr);
            if (this.vMs != null) {
                ix += e.a.a.a.ix(9, this.vMs.computeSize());
            }
            if (this.vMt != null) {
                ix += e.a.a.a.ix(10, this.vMt.computeSize());
            }
            AppMethodBeat.o(80070);
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
                AppMethodBeat.o(80070);
                throw bVar;
            } else if (this.vMl == null) {
                bVar = new b("Not all required fields were included: DnsInfo");
                AppMethodBeat.o(80070);
                throw bVar;
            } else {
                AppMethodBeat.o(80070);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            agc agc = (agc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            e.a.a.a.a aVar4;
            boolean z;
            mw mwVar;
            SKBuiltinBuffer_t sKBuiltinBuffer_t;
            mv mvVar;
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
                        agc.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(80070);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        mwVar = new mw();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = mwVar.populateBuilderWithField(aVar4, mwVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        agc.vMl = mwVar;
                    }
                    AppMethodBeat.o(80070);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        mwVar = new mw();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = mwVar.populateBuilderWithField(aVar4, mwVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        agc.vMm = mwVar;
                    }
                    AppMethodBeat.o(80070);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        mwVar = new mw();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = mwVar.populateBuilderWithField(aVar4, mwVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        agc.vMn = mwVar;
                    }
                    AppMethodBeat.o(80070);
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
                        agc.vMo = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(80070);
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
                        agc.vMp = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(80070);
                    return 0;
                case 7:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        mwVar = new mw();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = mwVar.populateBuilderWithField(aVar4, mwVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        agc.vMq = mwVar;
                    }
                    AppMethodBeat.o(80070);
                    return 0;
                case 8:
                    agc.vMr = aVar3.BTU.vd();
                    AppMethodBeat.o(80070);
                    return 0;
                case 9:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        mvVar = new mv();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = mvVar.populateBuilderWithField(aVar4, mvVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        agc.vMs = mvVar;
                    }
                    AppMethodBeat.o(80070);
                    return 0;
                case 10:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        mvVar = new mv();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = mvVar.populateBuilderWithField(aVar4, mvVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        agc.vMt = mvVar;
                    }
                    AppMethodBeat.o(80070);
                    return 0;
                default:
                    AppMethodBeat.o(80070);
                    return -1;
            }
        } else {
            AppMethodBeat.o(80070);
            return -1;
        }
    }
}
