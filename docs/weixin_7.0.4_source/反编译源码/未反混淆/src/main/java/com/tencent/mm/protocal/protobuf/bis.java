package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bis extends bsr {
    public String pcU;
    public int pdc;
    public String pdn;
    public aw vRP;
    public int wMd;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56880);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.iz(2, this.wMd);
            if (this.pcU != null) {
                aVar.e(3, this.pcU);
            }
            aVar.iz(4, this.pdc);
            if (this.pdn != null) {
                aVar.e(5, this.pdn);
            }
            if (this.vRP != null) {
                aVar.iy(6, this.vRP.computeSize());
                this.vRP.writeFields(aVar);
            }
            AppMethodBeat.o(56880);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += e.a.a.b.b.a.bs(2, this.wMd);
            if (this.pcU != null) {
                ix += e.a.a.b.b.a.f(3, this.pcU);
            }
            ix += e.a.a.b.b.a.bs(4, this.pdc);
            if (this.pdn != null) {
                ix += e.a.a.b.b.a.f(5, this.pdn);
            }
            if (this.vRP != null) {
                ix += e.a.a.a.ix(6, this.vRP.computeSize());
            }
            AppMethodBeat.o(56880);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56880);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bis bis = (bis) objArr[1];
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
                        bis.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(56880);
                    return 0;
                case 2:
                    bis.wMd = aVar3.BTU.vd();
                    AppMethodBeat.o(56880);
                    return 0;
                case 3:
                    bis.pcU = aVar3.BTU.readString();
                    AppMethodBeat.o(56880);
                    return 0;
                case 4:
                    bis.pdc = aVar3.BTU.vd();
                    AppMethodBeat.o(56880);
                    return 0;
                case 5:
                    bis.pdn = aVar3.BTU.readString();
                    AppMethodBeat.o(56880);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        aw awVar = new aw();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = awVar.populateBuilderWithField(aVar4, awVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bis.vRP = awVar;
                    }
                    AppMethodBeat.o(56880);
                    return 0;
                default:
                    AppMethodBeat.o(56880);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56880);
            return -1;
        }
    }
}
