package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class afe extends btd {
    public int kCl;
    public String kCm;
    public LinkedList<String> ttN = new LinkedList();
    public String wmE;

    public afe() {
        AppMethodBeat.i(56809);
        AppMethodBeat.o(56809);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56810);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(56810);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.e(2, 1, this.ttN);
            aVar.iz(3, this.kCl);
            if (this.kCm != null) {
                aVar.e(4, this.kCm);
            }
            if (this.wmE != null) {
                aVar.e(5, this.wmE);
            }
            AppMethodBeat.o(56810);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (ix + e.a.a.a.c(2, 1, this.ttN)) + e.a.a.b.b.a.bs(3, this.kCl);
            if (this.kCm != null) {
                ix += e.a.a.b.b.a.f(4, this.kCm);
            }
            if (this.wmE != null) {
                ix += e.a.a.b.b.a.f(5, this.wmE);
            }
            AppMethodBeat.o(56810);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.ttN.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(56810);
                throw bVar;
            }
            AppMethodBeat.o(56810);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            afe afe = (afe) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        BaseResponse baseResponse = new BaseResponse();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = baseResponse.populateBuilderWithField(aVar4, baseResponse, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        afe.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(56810);
                    return 0;
                case 2:
                    afe.ttN.add(aVar3.BTU.readString());
                    AppMethodBeat.o(56810);
                    return 0;
                case 3:
                    afe.kCl = aVar3.BTU.vd();
                    AppMethodBeat.o(56810);
                    return 0;
                case 4:
                    afe.kCm = aVar3.BTU.readString();
                    AppMethodBeat.o(56810);
                    return 0;
                case 5:
                    afe.wmE = aVar3.BTU.readString();
                    AppMethodBeat.o(56810);
                    return 0;
                default:
                    AppMethodBeat.o(56810);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56810);
            return -1;
        }
    }
}
