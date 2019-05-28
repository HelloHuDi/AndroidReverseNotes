package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bjo extends bsr {
    public int vAM;
    public int vRK;
    public aw vRP;
    public String wMV;
    public String wMW;
    public b wMX;
    public int wMY;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56903);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.wMV != null) {
                aVar.e(2, this.wMV);
            }
            if (this.wMW != null) {
                aVar.e(3, this.wMW);
            }
            if (this.wMX != null) {
                aVar.c(4, this.wMX);
            }
            aVar.iz(5, this.vRK);
            aVar.iz(6, this.vAM);
            aVar.iz(7, this.wMY);
            if (this.vRP != null) {
                aVar.iy(8, this.vRP.computeSize());
                this.vRP.writeFields(aVar);
            }
            AppMethodBeat.o(56903);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wMV != null) {
                ix += e.a.a.b.b.a.f(2, this.wMV);
            }
            if (this.wMW != null) {
                ix += e.a.a.b.b.a.f(3, this.wMW);
            }
            if (this.wMX != null) {
                ix += e.a.a.b.b.a.b(4, this.wMX);
            }
            ix = ((ix + e.a.a.b.b.a.bs(5, this.vRK)) + e.a.a.b.b.a.bs(6, this.vAM)) + e.a.a.b.b.a.bs(7, this.wMY);
            if (this.vRP != null) {
                ix += e.a.a.a.ix(8, this.vRP.computeSize());
            }
            AppMethodBeat.o(56903);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56903);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bjo bjo = (bjo) objArr[1];
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
                        bjo.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(56903);
                    return 0;
                case 2:
                    bjo.wMV = aVar3.BTU.readString();
                    AppMethodBeat.o(56903);
                    return 0;
                case 3:
                    bjo.wMW = aVar3.BTU.readString();
                    AppMethodBeat.o(56903);
                    return 0;
                case 4:
                    bjo.wMX = aVar3.BTU.emu();
                    AppMethodBeat.o(56903);
                    return 0;
                case 5:
                    bjo.vRK = aVar3.BTU.vd();
                    AppMethodBeat.o(56903);
                    return 0;
                case 6:
                    bjo.vAM = aVar3.BTU.vd();
                    AppMethodBeat.o(56903);
                    return 0;
                case 7:
                    bjo.wMY = aVar3.BTU.vd();
                    AppMethodBeat.o(56903);
                    return 0;
                case 8:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        aw awVar = new aw();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = awVar.populateBuilderWithField(aVar4, awVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bjo.vRP = awVar;
                    }
                    AppMethodBeat.o(56903);
                    return 0;
                default:
                    AppMethodBeat.o(56903);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56903);
            return -1;
        }
    }
}
