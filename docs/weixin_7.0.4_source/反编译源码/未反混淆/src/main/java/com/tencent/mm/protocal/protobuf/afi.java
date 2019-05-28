package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class afi extends btd {
    public int result;
    public aue wmJ;
    public String wmK;
    public atz wmL;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(10174);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(10174);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.wmJ != null) {
                aVar.iy(2, this.wmJ.computeSize());
                this.wmJ.writeFields(aVar);
            }
            if (this.wmK != null) {
                aVar.e(3, this.wmK);
            }
            if (this.wmL != null) {
                aVar.iy(4, this.wmL.computeSize());
                this.wmL.writeFields(aVar);
            }
            aVar.iz(5, this.result);
            AppMethodBeat.o(10174);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wmJ != null) {
                ix += e.a.a.a.ix(2, this.wmJ.computeSize());
            }
            if (this.wmK != null) {
                ix += e.a.a.b.b.a.f(3, this.wmK);
            }
            if (this.wmL != null) {
                ix += e.a.a.a.ix(4, this.wmL.computeSize());
            }
            int bs = ix + e.a.a.b.b.a.bs(5, this.result);
            AppMethodBeat.o(10174);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(10174);
                throw bVar;
            }
            AppMethodBeat.o(10174);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            afi afi = (afi) objArr[1];
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
                        afi.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(10174);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        aue aue = new aue();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aue.populateBuilderWithField(aVar4, aue, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        afi.wmJ = aue;
                    }
                    AppMethodBeat.o(10174);
                    return 0;
                case 3:
                    afi.wmK = aVar3.BTU.readString();
                    AppMethodBeat.o(10174);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        atz atz = new atz();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = atz.populateBuilderWithField(aVar4, atz, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        afi.wmL = atz;
                    }
                    AppMethodBeat.o(10174);
                    return 0;
                case 5:
                    afi.result = aVar3.BTU.vd();
                    AppMethodBeat.o(10174);
                    return 0;
                default:
                    AppMethodBeat.o(10174);
                    return -1;
            }
        } else {
            AppMethodBeat.o(10174);
            return -1;
        }
    }
}
