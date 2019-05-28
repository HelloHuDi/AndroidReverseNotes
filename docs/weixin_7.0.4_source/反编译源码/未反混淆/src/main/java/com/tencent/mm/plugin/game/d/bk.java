package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.btd;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bk extends btd {
    public at nci;
    public aj ncj;
    public h nck;
    public cc ncl;
    public ci ncm;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(111611);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(111611);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.ncj != null) {
                aVar.iy(2, this.ncj.computeSize());
                this.ncj.writeFields(aVar);
            }
            if (this.nci != null) {
                aVar.iy(3, this.nci.computeSize());
                this.nci.writeFields(aVar);
            }
            if (this.nck != null) {
                aVar.iy(4, this.nck.computeSize());
                this.nck.writeFields(aVar);
            }
            if (this.ncl != null) {
                aVar.iy(5, this.ncl.computeSize());
                this.ncl.writeFields(aVar);
            }
            if (this.ncm != null) {
                aVar.iy(6, this.ncm.computeSize());
                this.ncm.writeFields(aVar);
            }
            AppMethodBeat.o(111611);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.ncj != null) {
                ix += e.a.a.a.ix(2, this.ncj.computeSize());
            }
            if (this.nci != null) {
                ix += e.a.a.a.ix(3, this.nci.computeSize());
            }
            if (this.nck != null) {
                ix += e.a.a.a.ix(4, this.nck.computeSize());
            }
            if (this.ncl != null) {
                ix += e.a.a.a.ix(5, this.ncl.computeSize());
            }
            if (this.ncm != null) {
                ix += e.a.a.a.ix(6, this.ncm.computeSize());
            }
            AppMethodBeat.o(111611);
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
                AppMethodBeat.o(111611);
                throw bVar;
            }
            AppMethodBeat.o(111611);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bk bkVar = (bk) objArr[1];
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
                        bkVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(111611);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        aj ajVar = new aj();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ajVar.populateBuilderWithField(aVar4, ajVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bkVar.ncj = ajVar;
                    }
                    AppMethodBeat.o(111611);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        at atVar = new at();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = atVar.populateBuilderWithField(aVar4, atVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bkVar.nci = atVar;
                    }
                    AppMethodBeat.o(111611);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        h hVar = new h();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = hVar.populateBuilderWithField(aVar4, hVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bkVar.nck = hVar;
                    }
                    AppMethodBeat.o(111611);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cc ccVar = new cc();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ccVar.populateBuilderWithField(aVar4, ccVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bkVar.ncl = ccVar;
                    }
                    AppMethodBeat.o(111611);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ci ciVar = new ci();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ciVar.populateBuilderWithField(aVar4, ciVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bkVar.ncm = ciVar;
                    }
                    AppMethodBeat.o(111611);
                    return 0;
                default:
                    AppMethodBeat.o(111611);
                    return -1;
            }
        } else {
            AppMethodBeat.o(111611);
            return -1;
        }
    }
}
