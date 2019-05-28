package com.tencent.mm.plugin.qqmail.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.btd;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class d extends btd {
    public int jBv;
    public LinkedList<g> ptu = new LinkedList();

    public d() {
        AppMethodBeat.i(67922);
        AppMethodBeat.o(67922);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(67923);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(67923);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.iz(2, this.jBv);
            aVar.e(3, 8, this.ptu);
            AppMethodBeat.o(67923);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            int bs = (ix + e.a.a.b.b.a.bs(2, this.jBv)) + e.a.a.a.c(3, 8, this.ptu);
            AppMethodBeat.o(67923);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.ptu.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(67923);
                throw bVar;
            }
            AppMethodBeat.o(67923);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            d dVar = (d) objArr[1];
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
                        dVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(67923);
                    return 0;
                case 2:
                    dVar.jBv = aVar3.BTU.vd();
                    AppMethodBeat.o(67923);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        g gVar = new g();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = gVar.populateBuilderWithField(aVar4, gVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        dVar.ptu.add(gVar);
                    }
                    AppMethodBeat.o(67923);
                    return 0;
                default:
                    AppMethodBeat.o(67923);
                    return -1;
            }
        } else {
            AppMethodBeat.o(67923);
            return -1;
        }
    }
}
