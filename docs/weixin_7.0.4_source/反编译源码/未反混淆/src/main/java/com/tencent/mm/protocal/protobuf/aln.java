package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class aln extends btd {
    public dr wqN;
    public as wqO;
    public LinkedList<cvz> wqP = new LinkedList();

    public aln() {
        AppMethodBeat.i(80087);
        AppMethodBeat.o(80087);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(80088);
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.wqN != null) {
                aVar.iy(2, this.wqN.computeSize());
                this.wqN.writeFields(aVar);
            }
            if (this.wqO != null) {
                aVar.iy(3, this.wqO.computeSize());
                this.wqO.writeFields(aVar);
            }
            aVar.e(4, 8, this.wqP);
            AppMethodBeat.o(80088);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wqN != null) {
                ix += e.a.a.a.ix(2, this.wqN.computeSize());
            }
            if (this.wqO != null) {
                ix += e.a.a.a.ix(3, this.wqO.computeSize());
            }
            int c = ix + e.a.a.a.c(4, 8, this.wqP);
            AppMethodBeat.o(80088);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wqP.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(80088);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aln aln = (aln) objArr[1];
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
                        aln.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(80088);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        dr drVar = new dr();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = drVar.populateBuilderWithField(aVar4, drVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        aln.wqN = drVar;
                    }
                    AppMethodBeat.o(80088);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        as asVar = new as();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = asVar.populateBuilderWithField(aVar4, asVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        aln.wqO = asVar;
                    }
                    AppMethodBeat.o(80088);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cvz cvz = new cvz();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cvz.populateBuilderWithField(aVar4, cvz, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        aln.wqP.add(cvz);
                    }
                    AppMethodBeat.o(80088);
                    return 0;
                default:
                    AppMethodBeat.o(80088);
                    return -1;
            }
        } else {
            AppMethodBeat.o(80088);
            return -1;
        }
    }
}
