package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class axr extends btd {
    public axn wBI;
    public rg wBJ;
    public cwn wBK;
    public bmm wBL;
    public ay wBM;
    public bhm wBN;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(96274);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(96274);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.wBI != null) {
                aVar.iy(2, this.wBI.computeSize());
                this.wBI.writeFields(aVar);
            }
            if (this.wBJ != null) {
                aVar.iy(3, this.wBJ.computeSize());
                this.wBJ.writeFields(aVar);
            }
            if (this.wBK != null) {
                aVar.iy(4, this.wBK.computeSize());
                this.wBK.writeFields(aVar);
            }
            if (this.wBL != null) {
                aVar.iy(5, this.wBL.computeSize());
                this.wBL.writeFields(aVar);
            }
            if (this.wBM != null) {
                aVar.iy(6, this.wBM.computeSize());
                this.wBM.writeFields(aVar);
            }
            if (this.wBN != null) {
                aVar.iy(7, this.wBN.computeSize());
                this.wBN.writeFields(aVar);
            }
            AppMethodBeat.o(96274);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wBI != null) {
                ix += e.a.a.a.ix(2, this.wBI.computeSize());
            }
            if (this.wBJ != null) {
                ix += e.a.a.a.ix(3, this.wBJ.computeSize());
            }
            if (this.wBK != null) {
                ix += e.a.a.a.ix(4, this.wBK.computeSize());
            }
            if (this.wBL != null) {
                ix += e.a.a.a.ix(5, this.wBL.computeSize());
            }
            if (this.wBM != null) {
                ix += e.a.a.a.ix(6, this.wBM.computeSize());
            }
            if (this.wBN != null) {
                ix += e.a.a.a.ix(7, this.wBN.computeSize());
            }
            AppMethodBeat.o(96274);
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
                AppMethodBeat.o(96274);
                throw bVar;
            }
            AppMethodBeat.o(96274);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            axr axr = (axr) objArr[1];
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
                        axr.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(96274);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        axn axn = new axn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = axn.populateBuilderWithField(aVar4, axn, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        axr.wBI = axn;
                    }
                    AppMethodBeat.o(96274);
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
                        axr.wBJ = rgVar;
                    }
                    AppMethodBeat.o(96274);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cwn cwn = new cwn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cwn.populateBuilderWithField(aVar4, cwn, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        axr.wBK = cwn;
                    }
                    AppMethodBeat.o(96274);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bmm bmm = new bmm();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bmm.populateBuilderWithField(aVar4, bmm, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        axr.wBL = bmm;
                    }
                    AppMethodBeat.o(96274);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ay ayVar = new ay();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ayVar.populateBuilderWithField(aVar4, ayVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        axr.wBM = ayVar;
                    }
                    AppMethodBeat.o(96274);
                    return 0;
                case 7:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bhm bhm = new bhm();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhm.populateBuilderWithField(aVar4, bhm, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        axr.wBN = bhm;
                    }
                    AppMethodBeat.o(96274);
                    return 0;
                default:
                    AppMethodBeat.o(96274);
                    return -1;
            }
        } else {
            AppMethodBeat.o(96274);
            return -1;
        }
    }
}
