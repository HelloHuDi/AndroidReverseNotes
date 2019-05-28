package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class cew extends btd {
    public cer xdJ;
    public int xev;
    public int xew;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56542);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(56542);
                throw bVar;
            } else if (this.xdJ == null) {
                bVar = new b("Not all required fields were included: StoryObject");
                AppMethodBeat.o(56542);
                throw bVar;
            } else {
                if (this.BaseResponse != null) {
                    aVar.iy(1, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(aVar);
                }
                if (this.xdJ != null) {
                    aVar.iy(2, this.xdJ.computeSize());
                    this.xdJ.writeFields(aVar);
                }
                aVar.iz(3, this.xev);
                aVar.iz(4, this.xew);
                AppMethodBeat.o(56542);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.xdJ != null) {
                ix += e.a.a.a.ix(2, this.xdJ.computeSize());
            }
            int bs = (ix + e.a.a.b.b.a.bs(3, this.xev)) + e.a.a.b.b.a.bs(4, this.xew);
            AppMethodBeat.o(56542);
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
                AppMethodBeat.o(56542);
                throw bVar;
            } else if (this.xdJ == null) {
                bVar = new b("Not all required fields were included: StoryObject");
                AppMethodBeat.o(56542);
                throw bVar;
            } else {
                AppMethodBeat.o(56542);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cew cew = (cew) objArr[1];
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
                        cew.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(56542);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cer cer = new cer();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cer.populateBuilderWithField(aVar4, cer, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cew.xdJ = cer;
                    }
                    AppMethodBeat.o(56542);
                    return 0;
                case 3:
                    cew.xev = aVar3.BTU.vd();
                    AppMethodBeat.o(56542);
                    return 0;
                case 4:
                    cew.xew = aVar3.BTU.vd();
                    AppMethodBeat.o(56542);
                    return 0;
                default:
                    AppMethodBeat.o(56542);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56542);
            return -1;
        }
    }
}
