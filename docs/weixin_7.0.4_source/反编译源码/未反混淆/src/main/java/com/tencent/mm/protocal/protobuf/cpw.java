package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class cpw extends btd {
    public int wPb;
    public int wem;
    public long wen;
    public LinkedList<coj> xmC = new LinkedList();
    public int xnR;
    public LinkedList<coj> xnS = new LinkedList();
    public int xnT;
    public LinkedList<coj> xnU = new LinkedList();
    public int xnV;
    public int xnW;
    public int xnX;

    public cpw() {
        AppMethodBeat.i(5261);
        AppMethodBeat.o(5261);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(5262);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(5262);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.iz(2, this.wem);
            aVar.iz(3, this.xnR);
            aVar.e(4, 8, this.xnS);
            aVar.iz(5, this.xnT);
            aVar.e(6, 8, this.xnU);
            aVar.ai(7, this.wen);
            aVar.iz(8, this.wPb);
            aVar.iz(9, this.xnV);
            aVar.e(10, 8, this.xmC);
            aVar.iz(11, this.xnW);
            aVar.iz(12, this.xnX);
            AppMethodBeat.o(5262);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            int bs = ((((((((((ix + e.a.a.b.b.a.bs(2, this.wem)) + e.a.a.b.b.a.bs(3, this.xnR)) + e.a.a.a.c(4, 8, this.xnS)) + e.a.a.b.b.a.bs(5, this.xnT)) + e.a.a.a.c(6, 8, this.xnU)) + e.a.a.b.b.a.o(7, this.wen)) + e.a.a.b.b.a.bs(8, this.wPb)) + e.a.a.b.b.a.bs(9, this.xnV)) + e.a.a.a.c(10, 8, this.xmC)) + e.a.a.b.b.a.bs(11, this.xnW)) + e.a.a.b.b.a.bs(12, this.xnX);
            AppMethodBeat.o(5262);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xnS.clear();
            this.xnU.clear();
            this.xmC.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(5262);
                throw bVar;
            }
            AppMethodBeat.o(5262);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cpw cpw = (cpw) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            e.a.a.a.a aVar4;
            boolean z;
            coj coj;
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
                        cpw.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(5262);
                    return 0;
                case 2:
                    cpw.wem = aVar3.BTU.vd();
                    AppMethodBeat.o(5262);
                    return 0;
                case 3:
                    cpw.xnR = aVar3.BTU.vd();
                    AppMethodBeat.o(5262);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        coj = new coj();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = coj.populateBuilderWithField(aVar4, coj, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cpw.xnS.add(coj);
                    }
                    AppMethodBeat.o(5262);
                    return 0;
                case 5:
                    cpw.xnT = aVar3.BTU.vd();
                    AppMethodBeat.o(5262);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        coj = new coj();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = coj.populateBuilderWithField(aVar4, coj, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cpw.xnU.add(coj);
                    }
                    AppMethodBeat.o(5262);
                    return 0;
                case 7:
                    cpw.wen = aVar3.BTU.ve();
                    AppMethodBeat.o(5262);
                    return 0;
                case 8:
                    cpw.wPb = aVar3.BTU.vd();
                    AppMethodBeat.o(5262);
                    return 0;
                case 9:
                    cpw.xnV = aVar3.BTU.vd();
                    AppMethodBeat.o(5262);
                    return 0;
                case 10:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        coj = new coj();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = coj.populateBuilderWithField(aVar4, coj, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cpw.xmC.add(coj);
                    }
                    AppMethodBeat.o(5262);
                    return 0;
                case 11:
                    cpw.xnW = aVar3.BTU.vd();
                    AppMethodBeat.o(5262);
                    return 0;
                case 12:
                    cpw.xnX = aVar3.BTU.vd();
                    AppMethodBeat.o(5262);
                    return 0;
                default:
                    AppMethodBeat.o(5262);
                    return -1;
            }
        } else {
            AppMethodBeat.o(5262);
            return -1;
        }
    }
}
