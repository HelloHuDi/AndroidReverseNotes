package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class amx extends btd {
    public int nbk;
    public bmx wrx;
    public bmv wry;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(73712);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(73712);
                throw bVar;
            } else if (this.wrx == null) {
                bVar = new b("Not all required fields were included: QQGroup");
                AppMethodBeat.o(73712);
                throw bVar;
            } else if (this.wry == null) {
                bVar = new b("Not all required fields were included: QQFriend");
                AppMethodBeat.o(73712);
                throw bVar;
            } else {
                if (this.BaseResponse != null) {
                    aVar.iy(1, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(aVar);
                }
                aVar.iz(2, this.nbk);
                if (this.wrx != null) {
                    aVar.iy(3, this.wrx.computeSize());
                    this.wrx.writeFields(aVar);
                }
                if (this.wry != null) {
                    aVar.iy(4, this.wry.computeSize());
                    this.wry.writeFields(aVar);
                }
                AppMethodBeat.o(73712);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += e.a.a.b.b.a.bs(2, this.nbk);
            if (this.wrx != null) {
                ix += e.a.a.a.ix(3, this.wrx.computeSize());
            }
            if (this.wry != null) {
                ix += e.a.a.a.ix(4, this.wry.computeSize());
            }
            AppMethodBeat.o(73712);
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
                AppMethodBeat.o(73712);
                throw bVar;
            } else if (this.wrx == null) {
                bVar = new b("Not all required fields were included: QQGroup");
                AppMethodBeat.o(73712);
                throw bVar;
            } else if (this.wry == null) {
                bVar = new b("Not all required fields were included: QQFriend");
                AppMethodBeat.o(73712);
                throw bVar;
            } else {
                AppMethodBeat.o(73712);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            amx amx = (amx) objArr[1];
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
                        amx.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(73712);
                    return 0;
                case 2:
                    amx.nbk = aVar3.BTU.vd();
                    AppMethodBeat.o(73712);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bmx bmx = new bmx();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bmx.populateBuilderWithField(aVar4, bmx, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        amx.wrx = bmx;
                    }
                    AppMethodBeat.o(73712);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bmv bmv = new bmv();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bmv.populateBuilderWithField(aVar4, bmv, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        amx.wry = bmv;
                    }
                    AppMethodBeat.o(73712);
                    return 0;
                default:
                    AppMethodBeat.o(73712);
                    return -1;
            }
        } else {
            AppMethodBeat.o(73712);
            return -1;
        }
    }
}
