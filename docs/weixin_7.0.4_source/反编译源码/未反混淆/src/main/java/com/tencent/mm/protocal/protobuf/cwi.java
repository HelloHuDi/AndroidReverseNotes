package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public class cwi extends btd {
    public cmi xsa;
    public LinkedList<fu> xsb = new LinkedList();

    public cwi() {
        AppMethodBeat.i(102432);
        AppMethodBeat.o(102432);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(102433);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(102433);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.xsa != null) {
                aVar.iy(2, this.xsa.computeSize());
                this.xsa.writeFields(aVar);
            }
            aVar.e(3, 8, this.xsb);
            AppMethodBeat.o(102433);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.xsa != null) {
                ix += e.a.a.a.ix(2, this.xsa.computeSize());
            }
            int c = ix + e.a.a.a.c(3, 8, this.xsb);
            AppMethodBeat.o(102433);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xsb.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(102433);
                throw bVar;
            }
            AppMethodBeat.o(102433);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cwi cwi = (cwi) objArr[1];
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
                        cwi.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(102433);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cmi cmi = new cmi();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cmi.populateBuilderWithField(aVar4, cmi, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cwi.xsa = cmi;
                    }
                    AppMethodBeat.o(102433);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        fu fuVar = new fu();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fuVar.populateBuilderWithField(aVar4, fuVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cwi.xsb.add(fuVar);
                    }
                    AppMethodBeat.o(102433);
                    return 0;
                default:
                    AppMethodBeat.o(102433);
                    return -1;
            }
        } else {
            AppMethodBeat.o(102433);
            return -1;
        }
    }
}
