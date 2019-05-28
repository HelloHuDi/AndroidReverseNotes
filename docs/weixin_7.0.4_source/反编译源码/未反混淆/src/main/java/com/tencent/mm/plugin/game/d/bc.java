package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.b;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.btd;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bc extends btd {
    public String mZM;
    public LinkedList<ad> nbU = new LinkedList();
    public b nbV;
    public boolean nbW;

    public bc() {
        AppMethodBeat.i(111598);
        AppMethodBeat.o(111598);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(111599);
        e.a.a.b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new e.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(111599);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.e(2, 8, this.nbU);
            if (this.nbV != null) {
                aVar.c(3, this.nbV);
            }
            aVar.aO(4, this.nbW);
            if (this.mZM != null) {
                aVar.e(5, this.mZM);
            }
            AppMethodBeat.o(111599);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += e.a.a.a.c(2, 8, this.nbU);
            if (this.nbV != null) {
                ix += e.a.a.b.b.a.b(3, this.nbV);
            }
            ix += e.a.a.b.b.a.fv(4) + 1;
            if (this.mZM != null) {
                ix += e.a.a.b.b.a.f(5, this.mZM);
            }
            AppMethodBeat.o(111599);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.nbU.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new e.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(111599);
                throw bVar;
            }
            AppMethodBeat.o(111599);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bc bcVar = (bc) objArr[1];
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
                        bcVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(111599);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ad adVar = new ad();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = adVar.populateBuilderWithField(aVar4, adVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bcVar.nbU.add(adVar);
                    }
                    AppMethodBeat.o(111599);
                    return 0;
                case 3:
                    bcVar.nbV = aVar3.BTU.emu();
                    AppMethodBeat.o(111599);
                    return 0;
                case 4:
                    bcVar.nbW = aVar3.BTU.ehX();
                    AppMethodBeat.o(111599);
                    return 0;
                case 5:
                    bcVar.mZM = aVar3.BTU.readString();
                    AppMethodBeat.o(111599);
                    return 0;
                default:
                    AppMethodBeat.o(111599);
                    return -1;
            }
        } else {
            AppMethodBeat.o(111599);
            return -1;
        }
    }
}
