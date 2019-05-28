package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class aki extends btd {
    public String guP;
    public int vQe;
    public String vQg;
    public SKBuiltinBuffer_t wpP;
    public int wpU;
    public LinkedList<bts> wpV = new LinkedList();
    public int wpW;
    public LinkedList<axw> wpX = new LinkedList();
    public String wpY;
    public int wpZ;
    public int wqa;
    public axx wqb;
    public String wqc;

    public aki() {
        AppMethodBeat.i(28447);
        AppMethodBeat.o(28447);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28448);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(28448);
                throw bVar;
            } else if (this.wpP == null) {
                bVar = new b("Not all required fields were included: Buff");
                AppMethodBeat.o(28448);
                throw bVar;
            } else {
                if (this.BaseResponse != null) {
                    aVar.iy(1, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(aVar);
                }
                if (this.wpP != null) {
                    aVar.iy(2, this.wpP.computeSize());
                    this.wpP.writeFields(aVar);
                }
                aVar.iz(3, this.wpU);
                aVar.e(4, 8, this.wpV);
                aVar.iz(5, this.wpW);
                aVar.e(6, 8, this.wpX);
                aVar.iz(7, this.vQe);
                if (this.wpY != null) {
                    aVar.e(8, this.wpY);
                }
                if (this.vQg != null) {
                    aVar.e(9, this.vQg);
                }
                aVar.iz(10, this.wpZ);
                if (this.guP != null) {
                    aVar.e(11, this.guP);
                }
                aVar.iz(12, this.wqa);
                if (this.wqb != null) {
                    aVar.iy(13, this.wqb.computeSize());
                    this.wqb.writeFields(aVar);
                }
                if (this.wqc != null) {
                    aVar.e(14, this.wqc);
                }
                AppMethodBeat.o(28448);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wpP != null) {
                ix += e.a.a.a.ix(2, this.wpP.computeSize());
            }
            ix = ((((ix + e.a.a.b.b.a.bs(3, this.wpU)) + e.a.a.a.c(4, 8, this.wpV)) + e.a.a.b.b.a.bs(5, this.wpW)) + e.a.a.a.c(6, 8, this.wpX)) + e.a.a.b.b.a.bs(7, this.vQe);
            if (this.wpY != null) {
                ix += e.a.a.b.b.a.f(8, this.wpY);
            }
            if (this.vQg != null) {
                ix += e.a.a.b.b.a.f(9, this.vQg);
            }
            ix += e.a.a.b.b.a.bs(10, this.wpZ);
            if (this.guP != null) {
                ix += e.a.a.b.b.a.f(11, this.guP);
            }
            ix += e.a.a.b.b.a.bs(12, this.wqa);
            if (this.wqb != null) {
                ix += e.a.a.a.ix(13, this.wqb.computeSize());
            }
            if (this.wqc != null) {
                ix += e.a.a.b.b.a.f(14, this.wqc);
            }
            AppMethodBeat.o(28448);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wpV.clear();
            this.wpX.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(28448);
                throw bVar;
            } else if (this.wpP == null) {
                bVar = new b("Not all required fields were included: Buff");
                AppMethodBeat.o(28448);
                throw bVar;
            } else {
                AppMethodBeat.o(28448);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aki aki = (aki) objArr[1];
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
                        aki.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(28448);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        aki.wpP = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(28448);
                    return 0;
                case 3:
                    aki.wpU = aVar3.BTU.vd();
                    AppMethodBeat.o(28448);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        aki.wpV.add(bts);
                    }
                    AppMethodBeat.o(28448);
                    return 0;
                case 5:
                    aki.wpW = aVar3.BTU.vd();
                    AppMethodBeat.o(28448);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        axw axw = new axw();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = axw.populateBuilderWithField(aVar4, axw, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        aki.wpX.add(axw);
                    }
                    AppMethodBeat.o(28448);
                    return 0;
                case 7:
                    aki.vQe = aVar3.BTU.vd();
                    AppMethodBeat.o(28448);
                    return 0;
                case 8:
                    aki.wpY = aVar3.BTU.readString();
                    AppMethodBeat.o(28448);
                    return 0;
                case 9:
                    aki.vQg = aVar3.BTU.readString();
                    AppMethodBeat.o(28448);
                    return 0;
                case 10:
                    aki.wpZ = aVar3.BTU.vd();
                    AppMethodBeat.o(28448);
                    return 0;
                case 11:
                    aki.guP = aVar3.BTU.readString();
                    AppMethodBeat.o(28448);
                    return 0;
                case 12:
                    aki.wqa = aVar3.BTU.vd();
                    AppMethodBeat.o(28448);
                    return 0;
                case 13:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        axx axx = new axx();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = axx.populateBuilderWithField(aVar4, axx, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        aki.wqb = axx;
                    }
                    AppMethodBeat.o(28448);
                    return 0;
                case 14:
                    aki.wqc = aVar3.BTU.readString();
                    AppMethodBeat.o(28448);
                    return 0;
                default:
                    AppMethodBeat.o(28448);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28448);
            return -1;
        }
    }
}
