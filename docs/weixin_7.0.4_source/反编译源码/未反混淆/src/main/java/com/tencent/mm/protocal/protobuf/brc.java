package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class brc extends btd {
    public int wTs;
    public int wTv;
    public int wTw;
    public cob wTx;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28616);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(28616);
                throw bVar;
            } else if (this.wTx == null) {
                bVar = new b("Not all required fields were included: NextPiece");
                AppMethodBeat.o(28616);
                throw bVar;
            } else {
                if (this.BaseResponse != null) {
                    aVar.iy(1, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(aVar);
                }
                aVar.iz(2, this.wTv);
                aVar.iz(3, this.wTw);
                if (this.wTx != null) {
                    aVar.iy(4, this.wTx.computeSize());
                    this.wTx.writeFields(aVar);
                }
                aVar.iz(5, this.wTs);
                AppMethodBeat.o(28616);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (ix + e.a.a.b.b.a.bs(2, this.wTv)) + e.a.a.b.b.a.bs(3, this.wTw);
            if (this.wTx != null) {
                ix += e.a.a.a.ix(4, this.wTx.computeSize());
            }
            int bs = ix + e.a.a.b.b.a.bs(5, this.wTs);
            AppMethodBeat.o(28616);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(28616);
                throw bVar;
            } else if (this.wTx == null) {
                bVar = new b("Not all required fields were included: NextPiece");
                AppMethodBeat.o(28616);
                throw bVar;
            } else {
                AppMethodBeat.o(28616);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            brc brc = (brc) objArr[1];
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
                        brc.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(28616);
                    return 0;
                case 2:
                    brc.wTv = aVar3.BTU.vd();
                    AppMethodBeat.o(28616);
                    return 0;
                case 3:
                    brc.wTw = aVar3.BTU.vd();
                    AppMethodBeat.o(28616);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cob cob = new cob();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cob.populateBuilderWithField(aVar4, cob, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        brc.wTx = cob;
                    }
                    AppMethodBeat.o(28616);
                    return 0;
                case 5:
                    brc.wTs = aVar3.BTU.vd();
                    AppMethodBeat.o(28616);
                    return 0;
                default:
                    AppMethodBeat.o(28616);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28616);
            return -1;
        }
    }
}
