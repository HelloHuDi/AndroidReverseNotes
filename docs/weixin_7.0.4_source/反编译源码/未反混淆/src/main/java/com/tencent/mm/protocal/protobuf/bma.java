package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bma extends bsr {
    public String ndF;
    public String ndG;
    public int vZF;
    public long wOP;
    public int wOQ;
    public String wOR;
    public int wOY;
    public int wOZ;
    public int wPa;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28581);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.ndG != null) {
                aVar.e(2, this.ndG);
            }
            if (this.wOR != null) {
                aVar.e(3, this.wOR);
            }
            aVar.iz(4, this.vZF);
            aVar.ai(5, this.wOP);
            aVar.iz(6, this.wOQ);
            if (this.ndF != null) {
                aVar.e(7, this.ndF);
            }
            aVar.iz(8, this.wOZ);
            aVar.iz(9, this.wOY);
            aVar.iz(10, this.wPa);
            AppMethodBeat.o(28581);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.ndG != null) {
                ix += e.a.a.b.b.a.f(2, this.ndG);
            }
            if (this.wOR != null) {
                ix += e.a.a.b.b.a.f(3, this.wOR);
            }
            ix = ((ix + e.a.a.b.b.a.bs(4, this.vZF)) + e.a.a.b.b.a.o(5, this.wOP)) + e.a.a.b.b.a.bs(6, this.wOQ);
            if (this.ndF != null) {
                ix += e.a.a.b.b.a.f(7, this.ndF);
            }
            int bs = ((ix + e.a.a.b.b.a.bs(8, this.wOZ)) + e.a.a.b.b.a.bs(9, this.wOY)) + e.a.a.b.b.a.bs(10, this.wPa);
            AppMethodBeat.o(28581);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(28581);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bma bma = (bma) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        hl hlVar = new hl();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = hlVar.populateBuilderWithField(aVar4, hlVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bma.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(28581);
                    return 0;
                case 2:
                    bma.ndG = aVar3.BTU.readString();
                    AppMethodBeat.o(28581);
                    return 0;
                case 3:
                    bma.wOR = aVar3.BTU.readString();
                    AppMethodBeat.o(28581);
                    return 0;
                case 4:
                    bma.vZF = aVar3.BTU.vd();
                    AppMethodBeat.o(28581);
                    return 0;
                case 5:
                    bma.wOP = aVar3.BTU.ve();
                    AppMethodBeat.o(28581);
                    return 0;
                case 6:
                    bma.wOQ = aVar3.BTU.vd();
                    AppMethodBeat.o(28581);
                    return 0;
                case 7:
                    bma.ndF = aVar3.BTU.readString();
                    AppMethodBeat.o(28581);
                    return 0;
                case 8:
                    bma.wOZ = aVar3.BTU.vd();
                    AppMethodBeat.o(28581);
                    return 0;
                case 9:
                    bma.wOY = aVar3.BTU.vd();
                    AppMethodBeat.o(28581);
                    return 0;
                case 10:
                    bma.wPa = aVar3.BTU.vd();
                    AppMethodBeat.o(28581);
                    return 0;
                default:
                    AppMethodBeat.o(28581);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28581);
            return -1;
        }
    }
}
