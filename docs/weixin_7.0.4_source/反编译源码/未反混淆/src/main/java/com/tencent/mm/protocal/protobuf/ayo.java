package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ayo extends btd {
    public int wCn;
    public int wCp;
    public LinkedList<aym> wCr = new LinkedList();
    public LinkedList<aym> wCs = new LinkedList();
    public String wdB;

    public ayo() {
        AppMethodBeat.i(73735);
        AppMethodBeat.o(73735);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(73736);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(73736);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.wdB != null) {
                aVar.e(2, this.wdB);
            }
            aVar.iz(3, this.wCn);
            aVar.e(4, 8, this.wCr);
            aVar.iz(5, this.wCp);
            aVar.e(6, 8, this.wCs);
            AppMethodBeat.o(73736);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wdB != null) {
                ix += e.a.a.b.b.a.f(2, this.wdB);
            }
            int bs = (((ix + e.a.a.b.b.a.bs(3, this.wCn)) + e.a.a.a.c(4, 8, this.wCr)) + e.a.a.b.b.a.bs(5, this.wCp)) + e.a.a.a.c(6, 8, this.wCs);
            AppMethodBeat.o(73736);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wCr.clear();
            this.wCs.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(73736);
                throw bVar;
            }
            AppMethodBeat.o(73736);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ayo ayo = (ayo) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            e.a.a.a.a aVar4;
            boolean z;
            aym aym;
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
                        ayo.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(73736);
                    return 0;
                case 2:
                    ayo.wdB = aVar3.BTU.readString();
                    AppMethodBeat.o(73736);
                    return 0;
                case 3:
                    ayo.wCn = aVar3.BTU.vd();
                    AppMethodBeat.o(73736);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        aym = new aym();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aym.populateBuilderWithField(aVar4, aym, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        ayo.wCr.add(aym);
                    }
                    AppMethodBeat.o(73736);
                    return 0;
                case 5:
                    ayo.wCp = aVar3.BTU.vd();
                    AppMethodBeat.o(73736);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        aym = new aym();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aym.populateBuilderWithField(aVar4, aym, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        ayo.wCs.add(aym);
                    }
                    AppMethodBeat.o(73736);
                    return 0;
                default:
                    AppMethodBeat.o(73736);
                    return -1;
            }
        } else {
            AppMethodBeat.o(73736);
            return -1;
        }
    }
}
