package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ada extends btd {
    public String wkG;
    public LinkedList<adb> wkN = new LinkedList();

    public ada() {
        AppMethodBeat.i(112428);
        AppMethodBeat.o(112428);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(112429);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(112429);
                throw bVar;
            } else if (this.wkG == null) {
                bVar = new b("Not all required fields were included: JsonData");
                AppMethodBeat.o(112429);
                throw bVar;
            } else {
                if (this.BaseResponse != null) {
                    aVar.iy(1, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(aVar);
                }
                aVar.e(2, 8, this.wkN);
                if (this.wkG != null) {
                    aVar.e(3, this.wkG);
                }
                AppMethodBeat.o(112429);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += e.a.a.a.c(2, 8, this.wkN);
            if (this.wkG != null) {
                ix += e.a.a.b.b.a.f(3, this.wkG);
            }
            AppMethodBeat.o(112429);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wkN.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(112429);
                throw bVar;
            } else if (this.wkG == null) {
                bVar = new b("Not all required fields were included: JsonData");
                AppMethodBeat.o(112429);
                throw bVar;
            } else {
                AppMethodBeat.o(112429);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ada ada = (ada) objArr[1];
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
                        ada.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(112429);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        adb adb = new adb();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = adb.populateBuilderWithField(aVar4, adb, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        ada.wkN.add(adb);
                    }
                    AppMethodBeat.o(112429);
                    return 0;
                case 3:
                    ada.wkG = aVar3.BTU.readString();
                    AppMethodBeat.o(112429);
                    return 0;
                default:
                    AppMethodBeat.o(112429);
                    return -1;
            }
        } else {
            AppMethodBeat.o(112429);
            return -1;
        }
    }
}
