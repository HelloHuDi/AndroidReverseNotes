package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class hv extends btd {
    public int fJT;
    public LinkedList<String> vII = new LinkedList();
    public int vKj;
    public LinkedList<xx> vKl = new LinkedList();

    public hv() {
        AppMethodBeat.i(62521);
        AppMethodBeat.o(62521);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(62522);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(62522);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.iz(2, this.vKj);
            aVar.e(3, 1, this.vII);
            aVar.iz(4, this.fJT);
            aVar.e(5, 8, this.vKl);
            AppMethodBeat.o(62522);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            int bs = (((ix + e.a.a.b.b.a.bs(2, this.vKj)) + e.a.a.a.c(3, 1, this.vII)) + e.a.a.b.b.a.bs(4, this.fJT)) + e.a.a.a.c(5, 8, this.vKl);
            AppMethodBeat.o(62522);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vII.clear();
            this.vKl.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(62522);
                throw bVar;
            }
            AppMethodBeat.o(62522);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            hv hvVar = (hv) objArr[1];
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
                        hvVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(62522);
                    return 0;
                case 2:
                    hvVar.vKj = aVar3.BTU.vd();
                    AppMethodBeat.o(62522);
                    return 0;
                case 3:
                    hvVar.vII.add(aVar3.BTU.readString());
                    AppMethodBeat.o(62522);
                    return 0;
                case 4:
                    hvVar.fJT = aVar3.BTU.vd();
                    AppMethodBeat.o(62522);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        xx xxVar = new xx();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = xxVar.populateBuilderWithField(aVar4, xxVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        hvVar.vKl.add(xxVar);
                    }
                    AppMethodBeat.o(62522);
                    return 0;
                default:
                    AppMethodBeat.o(62522);
                    return -1;
            }
        } else {
            AppMethodBeat.o(62522);
            return -1;
        }
    }
}
