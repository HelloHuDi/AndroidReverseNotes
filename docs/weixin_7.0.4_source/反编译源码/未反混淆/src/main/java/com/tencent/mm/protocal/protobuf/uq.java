package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class uq extends btd {
    public int ehB;
    public SKBuiltinBuffer_t vEF;
    public LinkedList<baz> vEh = new LinkedList();
    public bts vEi;
    public String vXm;
    public String vXn;
    public bts wcc;
    public bts wce;
    public bts wcf;

    public uq() {
        AppMethodBeat.i(5570);
        AppMethodBeat.o(5570);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(5571);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(5571);
                throw bVar;
            } else if (this.wcc == null) {
                bVar = new b("Not all required fields were included: Topic");
                AppMethodBeat.o(5571);
                throw bVar;
            } else if (this.wce == null) {
                bVar = new b("Not all required fields were included: PYInitial");
                AppMethodBeat.o(5571);
                throw bVar;
            } else if (this.wcf == null) {
                bVar = new b("Not all required fields were included: QuanPin");
                AppMethodBeat.o(5571);
                throw bVar;
            } else if (this.vEi == null) {
                bVar = new b("Not all required fields were included: ChatRoomName");
                AppMethodBeat.o(5571);
                throw bVar;
            } else if (this.vEF == null) {
                bVar = new b("Not all required fields were included: ImgBuf");
                AppMethodBeat.o(5571);
                throw bVar;
            } else {
                if (this.BaseResponse != null) {
                    aVar.iy(1, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(aVar);
                }
                if (this.wcc != null) {
                    aVar.iy(2, this.wcc.computeSize());
                    this.wcc.writeFields(aVar);
                }
                if (this.wce != null) {
                    aVar.iy(3, this.wce.computeSize());
                    this.wce.writeFields(aVar);
                }
                if (this.wcf != null) {
                    aVar.iy(4, this.wcf.computeSize());
                    this.wcf.writeFields(aVar);
                }
                aVar.iz(5, this.ehB);
                aVar.e(6, 8, this.vEh);
                if (this.vEi != null) {
                    aVar.iy(7, this.vEi.computeSize());
                    this.vEi.writeFields(aVar);
                }
                if (this.vEF != null) {
                    aVar.iy(8, this.vEF.computeSize());
                    this.vEF.writeFields(aVar);
                }
                if (this.vXm != null) {
                    aVar.e(9, this.vXm);
                }
                if (this.vXn != null) {
                    aVar.e(10, this.vXn);
                }
                AppMethodBeat.o(5571);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wcc != null) {
                ix += e.a.a.a.ix(2, this.wcc.computeSize());
            }
            if (this.wce != null) {
                ix += e.a.a.a.ix(3, this.wce.computeSize());
            }
            if (this.wcf != null) {
                ix += e.a.a.a.ix(4, this.wcf.computeSize());
            }
            ix = (ix + e.a.a.b.b.a.bs(5, this.ehB)) + e.a.a.a.c(6, 8, this.vEh);
            if (this.vEi != null) {
                ix += e.a.a.a.ix(7, this.vEi.computeSize());
            }
            if (this.vEF != null) {
                ix += e.a.a.a.ix(8, this.vEF.computeSize());
            }
            if (this.vXm != null) {
                ix += e.a.a.b.b.a.f(9, this.vXm);
            }
            if (this.vXn != null) {
                ix += e.a.a.b.b.a.f(10, this.vXn);
            }
            AppMethodBeat.o(5571);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vEh.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(5571);
                throw bVar;
            } else if (this.wcc == null) {
                bVar = new b("Not all required fields were included: Topic");
                AppMethodBeat.o(5571);
                throw bVar;
            } else if (this.wce == null) {
                bVar = new b("Not all required fields were included: PYInitial");
                AppMethodBeat.o(5571);
                throw bVar;
            } else if (this.wcf == null) {
                bVar = new b("Not all required fields were included: QuanPin");
                AppMethodBeat.o(5571);
                throw bVar;
            } else if (this.vEi == null) {
                bVar = new b("Not all required fields were included: ChatRoomName");
                AppMethodBeat.o(5571);
                throw bVar;
            } else if (this.vEF == null) {
                bVar = new b("Not all required fields were included: ImgBuf");
                AppMethodBeat.o(5571);
                throw bVar;
            } else {
                AppMethodBeat.o(5571);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            uq uqVar = (uq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            e.a.a.a.a aVar4;
            boolean z;
            bts bts;
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
                        uqVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(5571);
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
                        uqVar.wcc = bts;
                    }
                    AppMethodBeat.o(5571);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        uqVar.wce = bts;
                    }
                    AppMethodBeat.o(5571);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        uqVar.wcf = bts;
                    }
                    AppMethodBeat.o(5571);
                    return 0;
                case 5:
                    uqVar.ehB = aVar3.BTU.vd();
                    AppMethodBeat.o(5571);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        baz baz = new baz();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = baz.populateBuilderWithField(aVar4, baz, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        uqVar.vEh.add(baz);
                    }
                    AppMethodBeat.o(5571);
                    return 0;
                case 7:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        uqVar.vEi = bts;
                    }
                    AppMethodBeat.o(5571);
                    return 0;
                case 8:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        uqVar.vEF = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(5571);
                    return 0;
                case 9:
                    uqVar.vXm = aVar3.BTU.readString();
                    AppMethodBeat.o(5571);
                    return 0;
                case 10:
                    uqVar.vXn = aVar3.BTU.readString();
                    AppMethodBeat.o(5571);
                    return 0;
                default:
                    AppMethodBeat.o(5571);
                    return -1;
            }
        } else {
            AppMethodBeat.o(5571);
            return -1;
        }
    }
}
