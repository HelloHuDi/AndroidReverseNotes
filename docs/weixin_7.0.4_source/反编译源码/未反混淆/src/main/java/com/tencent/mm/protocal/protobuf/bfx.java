package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bfx extends bsr {
    public int cHF;
    public int cME;
    public String pbn;
    public String tuk;
    public String vKZ;
    public String vLa;
    public boolean wJJ;
    public String wJK;
    public String wJL;
    public int wJM;
    public String wJN;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(48905);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.vKZ != null) {
                aVar.e(2, this.vKZ);
            }
            if (this.vLa != null) {
                aVar.e(3, this.vLa);
            }
            if (this.wJK != null) {
                aVar.e(4, this.wJK);
            }
            if (this.wJL != null) {
                aVar.e(5, this.wJL);
            }
            if (this.tuk != null) {
                aVar.e(6, this.tuk);
            }
            if (this.pbn != null) {
                aVar.e(7, this.pbn);
            }
            aVar.iz(8, this.cHF);
            aVar.iz(9, this.wJM);
            aVar.aO(10, this.wJJ);
            aVar.iz(11, this.cME);
            if (this.wJN != null) {
                aVar.e(12, this.wJN);
            }
            AppMethodBeat.o(48905);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.vKZ != null) {
                ix += e.a.a.b.b.a.f(2, this.vKZ);
            }
            if (this.vLa != null) {
                ix += e.a.a.b.b.a.f(3, this.vLa);
            }
            if (this.wJK != null) {
                ix += e.a.a.b.b.a.f(4, this.wJK);
            }
            if (this.wJL != null) {
                ix += e.a.a.b.b.a.f(5, this.wJL);
            }
            if (this.tuk != null) {
                ix += e.a.a.b.b.a.f(6, this.tuk);
            }
            if (this.pbn != null) {
                ix += e.a.a.b.b.a.f(7, this.pbn);
            }
            ix = (((ix + e.a.a.b.b.a.bs(8, this.cHF)) + e.a.a.b.b.a.bs(9, this.wJM)) + (e.a.a.b.b.a.fv(10) + 1)) + e.a.a.b.b.a.bs(11, this.cME);
            if (this.wJN != null) {
                ix += e.a.a.b.b.a.f(12, this.wJN);
            }
            AppMethodBeat.o(48905);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(48905);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bfx bfx = (bfx) objArr[1];
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
                        bfx.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(48905);
                    return 0;
                case 2:
                    bfx.vKZ = aVar3.BTU.readString();
                    AppMethodBeat.o(48905);
                    return 0;
                case 3:
                    bfx.vLa = aVar3.BTU.readString();
                    AppMethodBeat.o(48905);
                    return 0;
                case 4:
                    bfx.wJK = aVar3.BTU.readString();
                    AppMethodBeat.o(48905);
                    return 0;
                case 5:
                    bfx.wJL = aVar3.BTU.readString();
                    AppMethodBeat.o(48905);
                    return 0;
                case 6:
                    bfx.tuk = aVar3.BTU.readString();
                    AppMethodBeat.o(48905);
                    return 0;
                case 7:
                    bfx.pbn = aVar3.BTU.readString();
                    AppMethodBeat.o(48905);
                    return 0;
                case 8:
                    bfx.cHF = aVar3.BTU.vd();
                    AppMethodBeat.o(48905);
                    return 0;
                case 9:
                    bfx.wJM = aVar3.BTU.vd();
                    AppMethodBeat.o(48905);
                    return 0;
                case 10:
                    bfx.wJJ = aVar3.BTU.ehX();
                    AppMethodBeat.o(48905);
                    return 0;
                case 11:
                    bfx.cME = aVar3.BTU.vd();
                    AppMethodBeat.o(48905);
                    return 0;
                case 12:
                    bfx.wJN = aVar3.BTU.readString();
                    AppMethodBeat.o(48905);
                    return 0;
                default:
                    AppMethodBeat.o(48905);
                    return -1;
            }
        } else {
            AppMethodBeat.o(48905);
            return -1;
        }
    }
}
