package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class axt extends btd {
    public rg wBJ;
    public cvx wBP;
    public cvy wBQ;
    public cyd wBR;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(96276);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(96276);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.wBP != null) {
                aVar.iy(2, this.wBP.computeSize());
                this.wBP.writeFields(aVar);
            }
            if (this.wBJ != null) {
                aVar.iy(3, this.wBJ.computeSize());
                this.wBJ.writeFields(aVar);
            }
            if (this.wBQ != null) {
                aVar.iy(4, this.wBQ.computeSize());
                this.wBQ.writeFields(aVar);
            }
            if (this.wBR != null) {
                aVar.iy(5, this.wBR.computeSize());
                this.wBR.writeFields(aVar);
            }
            AppMethodBeat.o(96276);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wBP != null) {
                ix += e.a.a.a.ix(2, this.wBP.computeSize());
            }
            if (this.wBJ != null) {
                ix += e.a.a.a.ix(3, this.wBJ.computeSize());
            }
            if (this.wBQ != null) {
                ix += e.a.a.a.ix(4, this.wBQ.computeSize());
            }
            if (this.wBR != null) {
                ix += e.a.a.a.ix(5, this.wBR.computeSize());
            }
            AppMethodBeat.o(96276);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(96276);
                throw bVar;
            }
            AppMethodBeat.o(96276);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            axt axt = (axt) objArr[1];
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
                        axt.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(96276);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cvx cvx = new cvx();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cvx.populateBuilderWithField(aVar4, cvx, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        axt.wBP = cvx;
                    }
                    AppMethodBeat.o(96276);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        rg rgVar = new rg();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = rgVar.populateBuilderWithField(aVar4, rgVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        axt.wBJ = rgVar;
                    }
                    AppMethodBeat.o(96276);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cvy cvy = new cvy();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cvy.populateBuilderWithField(aVar4, cvy, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        axt.wBQ = cvy;
                    }
                    AppMethodBeat.o(96276);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cyd cyd = new cyd();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cyd.populateBuilderWithField(aVar4, cyd, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        axt.wBR = cyd;
                    }
                    AppMethodBeat.o(96276);
                    return 0;
                default:
                    AppMethodBeat.o(96276);
                    return -1;
            }
        } else {
            AppMethodBeat.o(96276);
            return -1;
        }
    }
}
