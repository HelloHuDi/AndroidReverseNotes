package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class oa extends a {
    public int vTs;
    public String vTt;
    public String vTu;
    public String vTv;
    public int vTw;
    public String vTx;
    public ny vTy;
    public String vTz;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(89037);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.vTs);
            if (this.vTt != null) {
                aVar.e(2, this.vTt);
            }
            if (this.vTu != null) {
                aVar.e(3, this.vTu);
            }
            if (this.vTv != null) {
                aVar.e(4, this.vTv);
            }
            aVar.iz(5, this.vTw);
            if (this.vTx != null) {
                aVar.e(6, this.vTx);
            }
            if (this.vTy != null) {
                aVar.iy(7, this.vTy.computeSize());
                this.vTy.writeFields(aVar);
            }
            if (this.vTz != null) {
                aVar.e(8, this.vTz);
            }
            AppMethodBeat.o(89037);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.vTs) + 0;
            if (this.vTt != null) {
                bs += e.a.a.b.b.a.f(2, this.vTt);
            }
            if (this.vTu != null) {
                bs += e.a.a.b.b.a.f(3, this.vTu);
            }
            if (this.vTv != null) {
                bs += e.a.a.b.b.a.f(4, this.vTv);
            }
            bs += e.a.a.b.b.a.bs(5, this.vTw);
            if (this.vTx != null) {
                bs += e.a.a.b.b.a.f(6, this.vTx);
            }
            if (this.vTy != null) {
                bs += e.a.a.a.ix(7, this.vTy.computeSize());
            }
            if (this.vTz != null) {
                bs += e.a.a.b.b.a.f(8, this.vTz);
            }
            AppMethodBeat.o(89037);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(89037);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            oa oaVar = (oa) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    oaVar.vTs = aVar3.BTU.vd();
                    AppMethodBeat.o(89037);
                    return 0;
                case 2:
                    oaVar.vTt = aVar3.BTU.readString();
                    AppMethodBeat.o(89037);
                    return 0;
                case 3:
                    oaVar.vTu = aVar3.BTU.readString();
                    AppMethodBeat.o(89037);
                    return 0;
                case 4:
                    oaVar.vTv = aVar3.BTU.readString();
                    AppMethodBeat.o(89037);
                    return 0;
                case 5:
                    oaVar.vTw = aVar3.BTU.vd();
                    AppMethodBeat.o(89037);
                    return 0;
                case 6:
                    oaVar.vTx = aVar3.BTU.readString();
                    AppMethodBeat.o(89037);
                    return 0;
                case 7:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        ny nyVar = new ny();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = nyVar.populateBuilderWithField(aVar4, nyVar, a.getNextFieldNumber(aVar4))) {
                        }
                        oaVar.vTy = nyVar;
                    }
                    AppMethodBeat.o(89037);
                    return 0;
                case 8:
                    oaVar.vTz = aVar3.BTU.readString();
                    AppMethodBeat.o(89037);
                    return 0;
                default:
                    AppMethodBeat.o(89037);
                    return -1;
            }
        } else {
            AppMethodBeat.o(89037);
            return -1;
        }
    }
}
