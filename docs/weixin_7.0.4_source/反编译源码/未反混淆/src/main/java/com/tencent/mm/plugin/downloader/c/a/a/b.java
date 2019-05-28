package com.tencent.mm.plugin.downloader.c.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.btd;
import e.a.a.c.a;
import java.util.LinkedList;

public final class b extends btd {
    public LinkedList<d> kKo = new LinkedList();
    public f kKp;

    public b() {
        AppMethodBeat.i(35508);
        AppMethodBeat.o(35508);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(35509);
        e.a.a.b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new e.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(35509);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.e(2, 8, this.kKo);
            if (this.kKp != null) {
                aVar.iy(3, this.kKp.computeSize());
                this.kKp.writeFields(aVar);
            }
            AppMethodBeat.o(35509);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += e.a.a.a.c(2, 8, this.kKo);
            if (this.kKp != null) {
                ix += e.a.a.a.ix(3, this.kKp.computeSize());
            }
            AppMethodBeat.o(35509);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.kKo.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new e.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(35509);
                throw bVar;
            }
            AppMethodBeat.o(35509);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            b bVar2 = (b) objArr[1];
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
                        bVar2.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(35509);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        d dVar = new d();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = dVar.populateBuilderWithField(aVar4, dVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bVar2.kKo.add(dVar);
                    }
                    AppMethodBeat.o(35509);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        f fVar = new f();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fVar.populateBuilderWithField(aVar4, fVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bVar2.kKp = fVar;
                    }
                    AppMethodBeat.o(35509);
                    return 0;
                default:
                    AppMethodBeat.o(35509);
                    return -1;
            }
        } else {
            AppMethodBeat.o(35509);
            return -1;
        }
    }
}
