package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public class anx extends btd {
    public String nzz;
    public LinkedList<bzq> wss = new LinkedList();
    public int wst;
    public int wsu;

    public anx() {
        AppMethodBeat.i(114965);
        AppMethodBeat.o(114965);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(114966);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(114966);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.e(2, 8, this.wss);
            if (this.nzz != null) {
                aVar.e(3, this.nzz);
            }
            aVar.iz(4, this.wst);
            aVar.iz(5, this.wsu);
            AppMethodBeat.o(114966);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += e.a.a.a.c(2, 8, this.wss);
            if (this.nzz != null) {
                ix += e.a.a.b.b.a.f(3, this.nzz);
            }
            int bs = (ix + e.a.a.b.b.a.bs(4, this.wst)) + e.a.a.b.b.a.bs(5, this.wsu);
            AppMethodBeat.o(114966);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wss.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(114966);
                throw bVar;
            }
            AppMethodBeat.o(114966);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            anx anx = (anx) objArr[1];
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
                        anx.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(114966);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bzq bzq = new bzq();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bzq.populateBuilderWithField(aVar4, bzq, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        anx.wss.add(bzq);
                    }
                    AppMethodBeat.o(114966);
                    return 0;
                case 3:
                    anx.nzz = aVar3.BTU.readString();
                    AppMethodBeat.o(114966);
                    return 0;
                case 4:
                    anx.wst = aVar3.BTU.vd();
                    AppMethodBeat.o(114966);
                    return 0;
                case 5:
                    anx.wsu = aVar3.BTU.vd();
                    AppMethodBeat.o(114966);
                    return 0;
                default:
                    AppMethodBeat.o(114966);
                    return -1;
            }
        } else {
            AppMethodBeat.o(114966);
            return -1;
        }
    }
}
