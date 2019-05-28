package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class avk extends btd {
    public int cyE;
    public avi wzj;
    public int wzs;
    public int wzt;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(96251);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(96251);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.wzj != null) {
                aVar.iy(2, this.wzj.computeSize());
                this.wzj.writeFields(aVar);
            }
            aVar.iz(3, this.cyE);
            aVar.iz(4, this.wzs);
            aVar.iz(5, this.wzt);
            AppMethodBeat.o(96251);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wzj != null) {
                ix += e.a.a.a.ix(2, this.wzj.computeSize());
            }
            int bs = ((ix + e.a.a.b.b.a.bs(3, this.cyE)) + e.a.a.b.b.a.bs(4, this.wzs)) + e.a.a.b.b.a.bs(5, this.wzt);
            AppMethodBeat.o(96251);
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
                AppMethodBeat.o(96251);
                throw bVar;
            }
            AppMethodBeat.o(96251);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            avk avk = (avk) objArr[1];
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
                        avk.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(96251);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        avi avi = new avi();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = avi.populateBuilderWithField(aVar4, avi, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        avk.wzj = avi;
                    }
                    AppMethodBeat.o(96251);
                    return 0;
                case 3:
                    avk.cyE = aVar3.BTU.vd();
                    AppMethodBeat.o(96251);
                    return 0;
                case 4:
                    avk.wzs = aVar3.BTU.vd();
                    AppMethodBeat.o(96251);
                    return 0;
                case 5:
                    avk.wzt = aVar3.BTU.vd();
                    AppMethodBeat.o(96251);
                    return 0;
                default:
                    AppMethodBeat.o(96251);
                    return -1;
            }
        } else {
            AppMethodBeat.o(96251);
            return -1;
        }
    }
}
