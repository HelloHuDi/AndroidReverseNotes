package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class uu extends btd {
    public String gfa;
    public LinkedList<bgd> vEN = new LinkedList();
    public String wcj;
    public String wck;

    public uu() {
        AppMethodBeat.i(80040);
        AppMethodBeat.o(80040);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(80041);
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.gfa != null) {
                aVar.e(2, this.gfa);
            }
            aVar.e(3, 8, this.vEN);
            if (this.wcj != null) {
                aVar.e(4, this.wcj);
            }
            if (this.wck != null) {
                aVar.e(5, this.wck);
            }
            AppMethodBeat.o(80041);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.gfa != null) {
                ix += e.a.a.b.b.a.f(2, this.gfa);
            }
            ix += e.a.a.a.c(3, 8, this.vEN);
            if (this.wcj != null) {
                ix += e.a.a.b.b.a.f(4, this.wcj);
            }
            if (this.wck != null) {
                ix += e.a.a.b.b.a.f(5, this.wck);
            }
            AppMethodBeat.o(80041);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vEN.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(80041);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            uu uuVar = (uu) objArr[1];
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
                        uuVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(80041);
                    return 0;
                case 2:
                    uuVar.gfa = aVar3.BTU.readString();
                    AppMethodBeat.o(80041);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bgd bgd = new bgd();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bgd.populateBuilderWithField(aVar4, bgd, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        uuVar.vEN.add(bgd);
                    }
                    AppMethodBeat.o(80041);
                    return 0;
                case 4:
                    uuVar.wcj = aVar3.BTU.readString();
                    AppMethodBeat.o(80041);
                    return 0;
                case 5:
                    uuVar.wck = aVar3.BTU.readString();
                    AppMethodBeat.o(80041);
                    return 0;
                default:
                    AppMethodBeat.o(80041);
                    return -1;
            }
        } else {
            AppMethodBeat.o(80041);
            return -1;
        }
    }
}
