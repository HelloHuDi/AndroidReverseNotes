package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.btd;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bm extends btd {
    public ch ncr;
    public LinkedList<c> ncs = new LinkedList();
    public boolean nct;
    public int ncu;

    public bm() {
        AppMethodBeat.i(111614);
        AppMethodBeat.o(111614);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(111615);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(111615);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.ncr != null) {
                aVar.iy(2, this.ncr.computeSize());
                this.ncr.writeFields(aVar);
            }
            aVar.e(3, 8, this.ncs);
            aVar.aO(4, this.nct);
            aVar.iz(5, this.ncu);
            AppMethodBeat.o(111615);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.ncr != null) {
                ix += e.a.a.a.ix(2, this.ncr.computeSize());
            }
            int c = ((ix + e.a.a.a.c(3, 8, this.ncs)) + (e.a.a.b.b.a.fv(4) + 1)) + e.a.a.b.b.a.bs(5, this.ncu);
            AppMethodBeat.o(111615);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.ncs.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(111615);
                throw bVar;
            }
            AppMethodBeat.o(111615);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bm bmVar = (bm) objArr[1];
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
                        bmVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(111615);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ch chVar = new ch();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = chVar.populateBuilderWithField(aVar4, chVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bmVar.ncr = chVar;
                    }
                    AppMethodBeat.o(111615);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        c cVar = new c();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cVar.populateBuilderWithField(aVar4, cVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bmVar.ncs.add(cVar);
                    }
                    AppMethodBeat.o(111615);
                    return 0;
                case 4:
                    bmVar.nct = aVar3.BTU.ehX();
                    AppMethodBeat.o(111615);
                    return 0;
                case 5:
                    bmVar.ncu = aVar3.BTU.vd();
                    AppMethodBeat.o(111615);
                    return 0;
                default:
                    AppMethodBeat.o(111615);
                    return -1;
            }
        } else {
            AppMethodBeat.o(111615);
            return -1;
        }
    }
}
