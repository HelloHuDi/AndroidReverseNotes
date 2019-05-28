package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class fd extends btd {
    public b vGZ;
    public int vHe;
    public int vHf;
    public fi vHg;
    public fe vHh;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28315);
        e.a.a.b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new e.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(28315);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.iz(2, this.vHe);
            aVar.iz(3, this.vHf);
            if (this.vGZ != null) {
                aVar.c(4, this.vGZ);
            }
            if (this.vHg != null) {
                aVar.iy(5, this.vHg.computeSize());
                this.vHg.writeFields(aVar);
            }
            if (this.vHh != null) {
                aVar.iy(6, this.vHh.computeSize());
                this.vHh.writeFields(aVar);
            }
            AppMethodBeat.o(28315);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (ix + e.a.a.b.b.a.bs(2, this.vHe)) + e.a.a.b.b.a.bs(3, this.vHf);
            if (this.vGZ != null) {
                ix += e.a.a.b.b.a.b(4, this.vGZ);
            }
            if (this.vHg != null) {
                ix += e.a.a.a.ix(5, this.vHg.computeSize());
            }
            if (this.vHh != null) {
                ix += e.a.a.a.ix(6, this.vHh.computeSize());
            }
            AppMethodBeat.o(28315);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new e.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(28315);
                throw bVar;
            }
            AppMethodBeat.o(28315);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            fd fdVar = (fd) objArr[1];
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
                        fdVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(28315);
                    return 0;
                case 2:
                    fdVar.vHe = aVar3.BTU.vd();
                    AppMethodBeat.o(28315);
                    return 0;
                case 3:
                    fdVar.vHf = aVar3.BTU.vd();
                    AppMethodBeat.o(28315);
                    return 0;
                case 4:
                    fdVar.vGZ = aVar3.BTU.emu();
                    AppMethodBeat.o(28315);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        fi fiVar = new fi();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fiVar.populateBuilderWithField(aVar4, fiVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        fdVar.vHg = fiVar;
                    }
                    AppMethodBeat.o(28315);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        fe feVar = new fe();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = feVar.populateBuilderWithField(aVar4, feVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        fdVar.vHh = feVar;
                    }
                    AppMethodBeat.o(28315);
                    return 0;
                default:
                    AppMethodBeat.o(28315);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28315);
            return -1;
        }
    }
}
