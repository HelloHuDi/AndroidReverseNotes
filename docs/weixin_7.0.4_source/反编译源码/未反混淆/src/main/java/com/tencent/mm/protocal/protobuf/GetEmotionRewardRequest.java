package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;

public class GetEmotionRewardRequest extends a {
    public int OpCode;
    public String ProductID;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(62566);
        b bVar;
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.ProductID == null) {
                bVar = new b("Not all required fields were included: ProductID");
                AppMethodBeat.o(62566);
                throw bVar;
            }
            if (this.ProductID != null) {
                aVar.e(1, this.ProductID);
            }
            aVar.iz(2, this.OpCode);
            AppMethodBeat.o(62566);
            return 0;
        } else if (i == 1) {
            if (this.ProductID != null) {
                f = e.a.a.b.b.a.f(1, this.ProductID) + 0;
            } else {
                f = 0;
            }
            int bs = f + e.a.a.b.b.a.bs(2, this.OpCode);
            AppMethodBeat.o(62566);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            if (this.ProductID == null) {
                bVar = new b("Not all required fields were included: ProductID");
                AppMethodBeat.o(62566);
                throw bVar;
            }
            AppMethodBeat.o(62566);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            GetEmotionRewardRequest getEmotionRewardRequest = (GetEmotionRewardRequest) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    getEmotionRewardRequest.ProductID = aVar3.BTU.readString();
                    AppMethodBeat.o(62566);
                    return 0;
                case 2:
                    getEmotionRewardRequest.OpCode = aVar3.BTU.vd();
                    AppMethodBeat.o(62566);
                    return 0;
                default:
                    AppMethodBeat.o(62566);
                    return -1;
            }
        } else {
            AppMethodBeat.o(62566);
            return -1;
        }
    }
}
