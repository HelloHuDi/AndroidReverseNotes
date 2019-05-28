package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class cpm extends btd {
    public int ehB;
    public int pcX;
    public int wem;
    public long wen;
    public int xmL;
    public String xmT;
    public LinkedList<cqi> xmU = new LinkedList();

    public cpm() {
        AppMethodBeat.i(5245);
        AppMethodBeat.o(5245);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(5246);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(5246);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.iz(2, this.wem);
            aVar.ai(3, this.wen);
            aVar.iz(4, this.pcX);
            aVar.iz(6, this.ehB);
            aVar.e(7, 8, this.xmU);
            if (this.xmT != null) {
                aVar.e(8, this.xmT);
            }
            aVar.iz(9, this.xmL);
            AppMethodBeat.o(5246);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = ((((ix + e.a.a.b.b.a.bs(2, this.wem)) + e.a.a.b.b.a.o(3, this.wen)) + e.a.a.b.b.a.bs(4, this.pcX)) + e.a.a.b.b.a.bs(6, this.ehB)) + e.a.a.a.c(7, 8, this.xmU);
            if (this.xmT != null) {
                ix += e.a.a.b.b.a.f(8, this.xmT);
            }
            int bs = ix + e.a.a.b.b.a.bs(9, this.xmL);
            AppMethodBeat.o(5246);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xmU.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(5246);
                throw bVar;
            }
            AppMethodBeat.o(5246);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cpm cpm = (cpm) objArr[1];
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
                        cpm.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(5246);
                    return 0;
                case 2:
                    cpm.wem = aVar3.BTU.vd();
                    AppMethodBeat.o(5246);
                    return 0;
                case 3:
                    cpm.wen = aVar3.BTU.ve();
                    AppMethodBeat.o(5246);
                    return 0;
                case 4:
                    cpm.pcX = aVar3.BTU.vd();
                    AppMethodBeat.o(5246);
                    return 0;
                case 6:
                    cpm.ehB = aVar3.BTU.vd();
                    AppMethodBeat.o(5246);
                    return 0;
                case 7:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cqi cqi = new cqi();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cqi.populateBuilderWithField(aVar4, cqi, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cpm.xmU.add(cqi);
                    }
                    AppMethodBeat.o(5246);
                    return 0;
                case 8:
                    cpm.xmT = aVar3.BTU.readString();
                    AppMethodBeat.o(5246);
                    return 0;
                case 9:
                    cpm.xmL = aVar3.BTU.vd();
                    AppMethodBeat.o(5246);
                    return 0;
                default:
                    AppMethodBeat.o(5246);
                    return -1;
            }
        } else {
            AppMethodBeat.o(5246);
            return -1;
        }
    }
}
