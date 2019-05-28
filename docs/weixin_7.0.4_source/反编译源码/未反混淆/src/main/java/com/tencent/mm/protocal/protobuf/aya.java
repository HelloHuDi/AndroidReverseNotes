package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class aya extends btd {
    public int qJO;
    public int wCg;
    public int wCh;
    public int wCi;
    public int wod;
    public LinkedList<axv> woe = new LinkedList();

    public aya() {
        AppMethodBeat.i(55528);
        AppMethodBeat.o(55528);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(55529);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(55529);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.iz(2, this.wod);
            aVar.e(3, 8, this.woe);
            aVar.iz(4, this.qJO);
            aVar.iz(5, this.wCg);
            aVar.iz(6, this.wCh);
            aVar.iz(7, this.wCi);
            AppMethodBeat.o(55529);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            int bs = (((((ix + e.a.a.b.b.a.bs(2, this.wod)) + e.a.a.a.c(3, 8, this.woe)) + e.a.a.b.b.a.bs(4, this.qJO)) + e.a.a.b.b.a.bs(5, this.wCg)) + e.a.a.b.b.a.bs(6, this.wCh)) + e.a.a.b.b.a.bs(7, this.wCi);
            AppMethodBeat.o(55529);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.woe.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(55529);
                throw bVar;
            }
            AppMethodBeat.o(55529);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aya aya = (aya) objArr[1];
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
                        aya.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(55529);
                    return 0;
                case 2:
                    aya.wod = aVar3.BTU.vd();
                    AppMethodBeat.o(55529);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        axv axv = new axv();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = axv.populateBuilderWithField(aVar4, axv, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        aya.woe.add(axv);
                    }
                    AppMethodBeat.o(55529);
                    return 0;
                case 4:
                    aya.qJO = aVar3.BTU.vd();
                    AppMethodBeat.o(55529);
                    return 0;
                case 5:
                    aya.wCg = aVar3.BTU.vd();
                    AppMethodBeat.o(55529);
                    return 0;
                case 6:
                    aya.wCh = aVar3.BTU.vd();
                    AppMethodBeat.o(55529);
                    return 0;
                case 7:
                    aya.wCi = aVar3.BTU.vd();
                    AppMethodBeat.o(55529);
                    return 0;
                default:
                    AppMethodBeat.o(55529);
                    return -1;
            }
        } else {
            AppMethodBeat.o(55529);
            return -1;
        }
    }
}
