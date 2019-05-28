package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class arg extends btd {
    public String wvh;
    public LinkedList<jd> wvi = new LinkedList();
    public boolean wvj;

    public arg() {
        AppMethodBeat.i(96241);
        AppMethodBeat.o(96241);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(96242);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(96242);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.e(2, 8, this.wvi);
            if (this.wvh != null) {
                aVar.e(3, this.wvh);
            }
            aVar.aO(4, this.wvj);
            AppMethodBeat.o(96242);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += e.a.a.a.c(2, 8, this.wvi);
            if (this.wvh != null) {
                ix += e.a.a.b.b.a.f(3, this.wvh);
            }
            int fv = ix + (e.a.a.b.b.a.fv(4) + 1);
            AppMethodBeat.o(96242);
            return fv;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wvi.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(96242);
                throw bVar;
            }
            AppMethodBeat.o(96242);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            arg arg = (arg) objArr[1];
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
                        arg.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(96242);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        jd jdVar = new jd();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = jdVar.populateBuilderWithField(aVar4, jdVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        arg.wvi.add(jdVar);
                    }
                    AppMethodBeat.o(96242);
                    return 0;
                case 3:
                    arg.wvh = aVar3.BTU.readString();
                    AppMethodBeat.o(96242);
                    return 0;
                case 4:
                    arg.wvj = aVar3.BTU.ehX();
                    AppMethodBeat.o(96242);
                    return 0;
                default:
                    AppMethodBeat.o(96242);
                    return -1;
            }
        } else {
            AppMethodBeat.o(96242);
            return -1;
        }
    }
}
