package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ann extends btd {
    public long rUb;
    public LinkedList<bql> vKY = new LinkedList();

    public ann() {
        AppMethodBeat.i(108896);
        AppMethodBeat.o(108896);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(108897);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(108897);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.ai(2, this.rUb);
            aVar.e(3, 8, this.vKY);
            AppMethodBeat.o(108897);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            int o = (ix + e.a.a.b.b.a.o(2, this.rUb)) + e.a.a.a.c(3, 8, this.vKY);
            AppMethodBeat.o(108897);
            return o;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vKY.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(108897);
                throw bVar;
            }
            AppMethodBeat.o(108897);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ann ann = (ann) objArr[1];
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
                        ann.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(108897);
                    return 0;
                case 2:
                    ann.rUb = aVar3.BTU.ve();
                    AppMethodBeat.o(108897);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bql bql = new bql();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bql.populateBuilderWithField(aVar4, bql, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        ann.vKY.add(bql);
                    }
                    AppMethodBeat.o(108897);
                    return 0;
                default:
                    AppMethodBeat.o(108897);
                    return -1;
            }
        } else {
            AppMethodBeat.o(108897);
            return -1;
        }
    }
}
