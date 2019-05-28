package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class avp extends btd {
    public LinkedList<String> wzA = new LinkedList();
    public String wzB;
    public avi wzj;
    public LinkedList<cmu> wzz = new LinkedList();

    public avp() {
        AppMethodBeat.i(10205);
        AppMethodBeat.o(10205);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(10206);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(10206);
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
            aVar.e(3, 8, this.wzz);
            aVar.e(4, 1, this.wzA);
            if (this.wzB != null) {
                aVar.e(5, this.wzB);
            }
            AppMethodBeat.o(10206);
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
            ix = (ix + e.a.a.a.c(3, 8, this.wzz)) + e.a.a.a.c(4, 1, this.wzA);
            if (this.wzB != null) {
                ix += e.a.a.b.b.a.f(5, this.wzB);
            }
            AppMethodBeat.o(10206);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wzz.clear();
            this.wzA.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(10206);
                throw bVar;
            }
            AppMethodBeat.o(10206);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            avp avp = (avp) objArr[1];
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
                        avp.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(10206);
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
                        avp.wzj = avi;
                    }
                    AppMethodBeat.o(10206);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cmu cmu = new cmu();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cmu.populateBuilderWithField(aVar4, cmu, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        avp.wzz.add(cmu);
                    }
                    AppMethodBeat.o(10206);
                    return 0;
                case 4:
                    avp.wzA.add(aVar3.BTU.readString());
                    AppMethodBeat.o(10206);
                    return 0;
                case 5:
                    avp.wzB = aVar3.BTU.readString();
                    AppMethodBeat.o(10206);
                    return 0;
                default:
                    AppMethodBeat.o(10206);
                    return -1;
            }
        } else {
            AppMethodBeat.o(10206);
            return -1;
        }
    }
}
