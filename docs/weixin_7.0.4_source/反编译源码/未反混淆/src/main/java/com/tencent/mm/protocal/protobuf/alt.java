package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class alt extends btd {
    public int OpCode;
    public String Url;
    public String vBa;
    public String vQg;
    public String wdK;
    public SKBuiltinBuffer_t wpP;
    public String wpY;
    public int wpZ;
    public int wqU;
    public LinkedList<bhu> wqV = new LinkedList();
    public int wqW;

    public alt() {
        AppMethodBeat.i(113783);
        AppMethodBeat.o(113783);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(113784);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(113784);
                throw bVar;
            } else if (this.wpP == null) {
                bVar = new b("Not all required fields were included: Buff");
                AppMethodBeat.o(113784);
                throw bVar;
            } else {
                if (this.BaseResponse != null) {
                    aVar.iy(1, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(aVar);
                }
                aVar.iz(2, this.wqU);
                aVar.e(3, 8, this.wqV);
                aVar.iz(4, this.OpCode);
                aVar.iz(5, this.wqW);
                if (this.wpP != null) {
                    aVar.iy(6, this.wpP.computeSize());
                    this.wpP.writeFields(aVar);
                }
                if (this.Url != null) {
                    aVar.e(7, this.Url);
                }
                if (this.wpY != null) {
                    aVar.e(8, this.wpY);
                }
                if (this.wdK != null) {
                    aVar.e(9, this.wdK);
                }
                if (this.vBa != null) {
                    aVar.e(10, this.vBa);
                }
                aVar.iz(11, this.wpZ);
                if (this.vQg != null) {
                    aVar.e(12, this.vQg);
                }
                AppMethodBeat.o(113784);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (((ix + e.a.a.b.b.a.bs(2, this.wqU)) + e.a.a.a.c(3, 8, this.wqV)) + e.a.a.b.b.a.bs(4, this.OpCode)) + e.a.a.b.b.a.bs(5, this.wqW);
            if (this.wpP != null) {
                ix += e.a.a.a.ix(6, this.wpP.computeSize());
            }
            if (this.Url != null) {
                ix += e.a.a.b.b.a.f(7, this.Url);
            }
            if (this.wpY != null) {
                ix += e.a.a.b.b.a.f(8, this.wpY);
            }
            if (this.wdK != null) {
                ix += e.a.a.b.b.a.f(9, this.wdK);
            }
            if (this.vBa != null) {
                ix += e.a.a.b.b.a.f(10, this.vBa);
            }
            ix += e.a.a.b.b.a.bs(11, this.wpZ);
            if (this.vQg != null) {
                ix += e.a.a.b.b.a.f(12, this.vQg);
            }
            AppMethodBeat.o(113784);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wqV.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(113784);
                throw bVar;
            } else if (this.wpP == null) {
                bVar = new b("Not all required fields were included: Buff");
                AppMethodBeat.o(113784);
                throw bVar;
            } else {
                AppMethodBeat.o(113784);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            alt alt = (alt) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
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
                        alt.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(113784);
                    return 0;
                case 2:
                    alt.wqU = aVar3.BTU.vd();
                    AppMethodBeat.o(113784);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bhu bhu = new bhu();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhu.populateBuilderWithField(aVar4, bhu, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        alt.wqV.add(bhu);
                    }
                    AppMethodBeat.o(113784);
                    return 0;
                case 4:
                    alt.OpCode = aVar3.BTU.vd();
                    AppMethodBeat.o(113784);
                    return 0;
                case 5:
                    alt.wqW = aVar3.BTU.vd();
                    AppMethodBeat.o(113784);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        alt.wpP = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(113784);
                    return 0;
                case 7:
                    alt.Url = aVar3.BTU.readString();
                    AppMethodBeat.o(113784);
                    return 0;
                case 8:
                    alt.wpY = aVar3.BTU.readString();
                    AppMethodBeat.o(113784);
                    return 0;
                case 9:
                    alt.wdK = aVar3.BTU.readString();
                    AppMethodBeat.o(113784);
                    return 0;
                case 10:
                    alt.vBa = aVar3.BTU.readString();
                    AppMethodBeat.o(113784);
                    return 0;
                case 11:
                    alt.wpZ = aVar3.BTU.vd();
                    AppMethodBeat.o(113784);
                    return 0;
                case 12:
                    alt.vQg = aVar3.BTU.readString();
                    AppMethodBeat.o(113784);
                    return 0;
                default:
                    AppMethodBeat.o(113784);
                    return -1;
            }
        } else {
            AppMethodBeat.o(113784);
            return -1;
        }
    }
}
