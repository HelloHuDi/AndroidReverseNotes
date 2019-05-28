package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bvm extends btd {
    public String url;
    public bvk wWB;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(80181);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(80181);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.wWB != null) {
                aVar.iy(2, this.wWB.computeSize());
                this.wWB.writeFields(aVar);
            }
            if (this.url != null) {
                aVar.e(3, this.url);
            }
            AppMethodBeat.o(80181);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wWB != null) {
                ix += e.a.a.a.ix(2, this.wWB.computeSize());
            }
            if (this.url != null) {
                ix += e.a.a.b.b.a.f(3, this.url);
            }
            AppMethodBeat.o(80181);
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
                AppMethodBeat.o(80181);
                throw bVar;
            }
            AppMethodBeat.o(80181);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bvm bvm = (bvm) objArr[1];
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
                        bvm.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(80181);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bvk bvk = new bvk();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bvk.populateBuilderWithField(aVar4, bvk, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bvm.wWB = bvk;
                    }
                    AppMethodBeat.o(80181);
                    return 0;
                case 3:
                    bvm.url = aVar3.BTU.readString();
                    AppMethodBeat.o(80181);
                    return 0;
                default:
                    AppMethodBeat.o(80181);
                    return -1;
            }
        } else {
            AppMethodBeat.o(80181);
            return -1;
        }
    }
}
