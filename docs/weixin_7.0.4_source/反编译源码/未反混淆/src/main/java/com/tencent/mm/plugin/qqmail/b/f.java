package com.tencent.mm.plugin.qqmail.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.btd;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class f extends btd {
    public String ptv;
    public int ptw;
    public int ptx;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(67925);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(67925);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.iz(2, this.ptx);
            aVar.iz(3, this.ptw);
            if (this.ptv != null) {
                aVar.e(4, this.ptv);
            }
            AppMethodBeat.o(67925);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (ix + e.a.a.b.b.a.bs(2, this.ptx)) + e.a.a.b.b.a.bs(3, this.ptw);
            if (this.ptv != null) {
                ix += e.a.a.b.b.a.f(4, this.ptv);
            }
            AppMethodBeat.o(67925);
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
                AppMethodBeat.o(67925);
                throw bVar;
            }
            AppMethodBeat.o(67925);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            f fVar = (f) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        BaseResponse baseResponse = new BaseResponse();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = baseResponse.populateBuilderWithField(aVar4, baseResponse, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        fVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(67925);
                    return 0;
                case 2:
                    fVar.ptx = aVar3.BTU.vd();
                    AppMethodBeat.o(67925);
                    return 0;
                case 3:
                    fVar.ptw = aVar3.BTU.vd();
                    AppMethodBeat.o(67925);
                    return 0;
                case 4:
                    fVar.ptv = aVar3.BTU.readString();
                    AppMethodBeat.o(67925);
                    return 0;
                default:
                    AppMethodBeat.o(67925);
                    return -1;
            }
        } else {
            AppMethodBeat.o(67925);
            return -1;
        }
    }
}
