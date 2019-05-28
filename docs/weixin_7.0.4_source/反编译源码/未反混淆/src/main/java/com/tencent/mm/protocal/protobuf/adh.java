package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class adh extends bsr {
    public int Scene;
    public String fKh;
    public String ndT;
    public int vAM;
    public String vLo;
    public String vXP;
    public String vYO;
    public String vYP;
    public String vYQ;
    public String vYR;
    public String wla;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56798);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.fKh != null) {
                aVar.e(2, this.fKh);
            }
            if (this.vYO != null) {
                aVar.e(3, this.vYO);
            }
            if (this.vLo != null) {
                aVar.e(4, this.vLo);
            }
            if (this.vYP != null) {
                aVar.e(5, this.vYP);
            }
            if (this.vYQ != null) {
                aVar.e(6, this.vYQ);
            }
            if (this.vYR != null) {
                aVar.e(7, this.vYR);
            }
            if (this.vXP != null) {
                aVar.e(8, this.vXP);
            }
            if (this.wla != null) {
                aVar.e(9, this.wla);
            }
            aVar.iz(10, this.vAM);
            if (this.ndT != null) {
                aVar.e(11, this.ndT);
            }
            aVar.iz(12, this.Scene);
            AppMethodBeat.o(56798);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.fKh != null) {
                ix += e.a.a.b.b.a.f(2, this.fKh);
            }
            if (this.vYO != null) {
                ix += e.a.a.b.b.a.f(3, this.vYO);
            }
            if (this.vLo != null) {
                ix += e.a.a.b.b.a.f(4, this.vLo);
            }
            if (this.vYP != null) {
                ix += e.a.a.b.b.a.f(5, this.vYP);
            }
            if (this.vYQ != null) {
                ix += e.a.a.b.b.a.f(6, this.vYQ);
            }
            if (this.vYR != null) {
                ix += e.a.a.b.b.a.f(7, this.vYR);
            }
            if (this.vXP != null) {
                ix += e.a.a.b.b.a.f(8, this.vXP);
            }
            if (this.wla != null) {
                ix += e.a.a.b.b.a.f(9, this.wla);
            }
            ix += e.a.a.b.b.a.bs(10, this.vAM);
            if (this.ndT != null) {
                ix += e.a.a.b.b.a.f(11, this.ndT);
            }
            int bs = ix + e.a.a.b.b.a.bs(12, this.Scene);
            AppMethodBeat.o(56798);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56798);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            adh adh = (adh) objArr[1];
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
                        adh.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(56798);
                    return 0;
                case 2:
                    adh.fKh = aVar3.BTU.readString();
                    AppMethodBeat.o(56798);
                    return 0;
                case 3:
                    adh.vYO = aVar3.BTU.readString();
                    AppMethodBeat.o(56798);
                    return 0;
                case 4:
                    adh.vLo = aVar3.BTU.readString();
                    AppMethodBeat.o(56798);
                    return 0;
                case 5:
                    adh.vYP = aVar3.BTU.readString();
                    AppMethodBeat.o(56798);
                    return 0;
                case 6:
                    adh.vYQ = aVar3.BTU.readString();
                    AppMethodBeat.o(56798);
                    return 0;
                case 7:
                    adh.vYR = aVar3.BTU.readString();
                    AppMethodBeat.o(56798);
                    return 0;
                case 8:
                    adh.vXP = aVar3.BTU.readString();
                    AppMethodBeat.o(56798);
                    return 0;
                case 9:
                    adh.wla = aVar3.BTU.readString();
                    AppMethodBeat.o(56798);
                    return 0;
                case 10:
                    adh.vAM = aVar3.BTU.vd();
                    AppMethodBeat.o(56798);
                    return 0;
                case 11:
                    adh.ndT = aVar3.BTU.readString();
                    AppMethodBeat.o(56798);
                    return 0;
                case 12:
                    adh.Scene = aVar3.BTU.vd();
                    AppMethodBeat.o(56798);
                    return 0;
                default:
                    AppMethodBeat.o(56798);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56798);
            return -1;
        }
    }
}
