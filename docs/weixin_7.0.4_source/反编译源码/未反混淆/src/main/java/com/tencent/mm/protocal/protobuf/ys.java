package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ys extends bsr {
    public String fKh;
    public int pXD;
    public aw vRP;
    public String wes;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56773);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.wes != null) {
                aVar.e(2, this.wes);
            }
            if (this.fKh != null) {
                aVar.e(3, this.fKh);
            }
            aVar.iz(4, this.pXD);
            if (this.vRP != null) {
                aVar.iy(5, this.vRP.computeSize());
                this.vRP.writeFields(aVar);
            }
            AppMethodBeat.o(56773);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wes != null) {
                ix += e.a.a.b.b.a.f(2, this.wes);
            }
            if (this.fKh != null) {
                ix += e.a.a.b.b.a.f(3, this.fKh);
            }
            ix += e.a.a.b.b.a.bs(4, this.pXD);
            if (this.vRP != null) {
                ix += e.a.a.a.ix(5, this.vRP.computeSize());
            }
            AppMethodBeat.o(56773);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56773);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ys ysVar = (ys) objArr[1];
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
                        hl hlVar = new hl();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = hlVar.populateBuilderWithField(aVar4, hlVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        ysVar.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(56773);
                    return 0;
                case 2:
                    ysVar.wes = aVar3.BTU.readString();
                    AppMethodBeat.o(56773);
                    return 0;
                case 3:
                    ysVar.fKh = aVar3.BTU.readString();
                    AppMethodBeat.o(56773);
                    return 0;
                case 4:
                    ysVar.pXD = aVar3.BTU.vd();
                    AppMethodBeat.o(56773);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        aw awVar = new aw();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = awVar.populateBuilderWithField(aVar4, awVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        ysVar.vRP = awVar;
                    }
                    AppMethodBeat.o(56773);
                    return 0;
                default:
                    AppMethodBeat.o(56773);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56773);
            return -1;
        }
    }
}
