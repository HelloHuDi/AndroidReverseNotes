package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class cog extends btd {
    public int wRe;
    public int xlI;
    public LinkedList<cod> xlJ = new LinkedList();
    public int xlK;

    public cog() {
        AppMethodBeat.i(116820);
        AppMethodBeat.o(116820);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(116821);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(116821);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.iz(2, this.xlI);
            aVar.e(3, 8, this.xlJ);
            aVar.iz(4, this.wRe);
            aVar.iz(5, this.xlK);
            AppMethodBeat.o(116821);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            int bs = (((ix + e.a.a.b.b.a.bs(2, this.xlI)) + e.a.a.a.c(3, 8, this.xlJ)) + e.a.a.b.b.a.bs(4, this.wRe)) + e.a.a.b.b.a.bs(5, this.xlK);
            AppMethodBeat.o(116821);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xlJ.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(116821);
                throw bVar;
            }
            AppMethodBeat.o(116821);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cog cog = (cog) objArr[1];
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
                        cog.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(116821);
                    return 0;
                case 2:
                    cog.xlI = aVar3.BTU.vd();
                    AppMethodBeat.o(116821);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cod cod = new cod();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cod.populateBuilderWithField(aVar4, cod, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cog.xlJ.add(cod);
                    }
                    AppMethodBeat.o(116821);
                    return 0;
                case 4:
                    cog.wRe = aVar3.BTU.vd();
                    AppMethodBeat.o(116821);
                    return 0;
                case 5:
                    cog.xlK = aVar3.BTU.vd();
                    AppMethodBeat.o(116821);
                    return 0;
                default:
                    AppMethodBeat.o(116821);
                    return -1;
            }
        } else {
            AppMethodBeat.o(116821);
            return -1;
        }
    }
}
