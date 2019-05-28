package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class w extends bsr {
    public int limit;
    public int offset;
    public int type;
    public int vAA;
    public int vAB;
    public String vAC;
    public String vAz;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56692);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.iz(2, this.limit);
            aVar.iz(3, this.offset);
            aVar.iz(4, this.type);
            if (this.vAz != null) {
                aVar.e(5, this.vAz);
            }
            aVar.iz(6, this.vAA);
            aVar.iz(7, this.vAB);
            if (this.vAC != null) {
                aVar.e(8, this.vAC);
            }
            AppMethodBeat.o(56692);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = ((ix + e.a.a.b.b.a.bs(2, this.limit)) + e.a.a.b.b.a.bs(3, this.offset)) + e.a.a.b.b.a.bs(4, this.type);
            if (this.vAz != null) {
                ix += e.a.a.b.b.a.f(5, this.vAz);
            }
            ix = (ix + e.a.a.b.b.a.bs(6, this.vAA)) + e.a.a.b.b.a.bs(7, this.vAB);
            if (this.vAC != null) {
                ix += e.a.a.b.b.a.f(8, this.vAC);
            }
            AppMethodBeat.o(56692);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56692);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            w wVar = (w) objArr[1];
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
                        wVar.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(56692);
                    return 0;
                case 2:
                    wVar.limit = aVar3.BTU.vd();
                    AppMethodBeat.o(56692);
                    return 0;
                case 3:
                    wVar.offset = aVar3.BTU.vd();
                    AppMethodBeat.o(56692);
                    return 0;
                case 4:
                    wVar.type = aVar3.BTU.vd();
                    AppMethodBeat.o(56692);
                    return 0;
                case 5:
                    wVar.vAz = aVar3.BTU.readString();
                    AppMethodBeat.o(56692);
                    return 0;
                case 6:
                    wVar.vAA = aVar3.BTU.vd();
                    AppMethodBeat.o(56692);
                    return 0;
                case 7:
                    wVar.vAB = aVar3.BTU.vd();
                    AppMethodBeat.o(56692);
                    return 0;
                case 8:
                    wVar.vAC = aVar3.BTU.readString();
                    AppMethodBeat.o(56692);
                    return 0;
                default:
                    AppMethodBeat.o(56692);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56692);
            return -1;
        }
    }
}
