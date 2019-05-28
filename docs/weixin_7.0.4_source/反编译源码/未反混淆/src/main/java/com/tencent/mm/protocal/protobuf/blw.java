package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class blw extends bsr {
    public String wOT;
    public String wOU;
    public String wOV;
    public String wOW;
    public String wOX;
    public int wOY;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28577);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.wOT != null) {
                aVar.e(2, this.wOT);
            }
            if (this.wOU != null) {
                aVar.e(3, this.wOU);
            }
            if (this.wOV != null) {
                aVar.e(4, this.wOV);
            }
            if (this.wOW != null) {
                aVar.e(5, this.wOW);
            }
            if (this.wOX != null) {
                aVar.e(6, this.wOX);
            }
            aVar.iz(7, this.wOY);
            AppMethodBeat.o(28577);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wOT != null) {
                ix += e.a.a.b.b.a.f(2, this.wOT);
            }
            if (this.wOU != null) {
                ix += e.a.a.b.b.a.f(3, this.wOU);
            }
            if (this.wOV != null) {
                ix += e.a.a.b.b.a.f(4, this.wOV);
            }
            if (this.wOW != null) {
                ix += e.a.a.b.b.a.f(5, this.wOW);
            }
            if (this.wOX != null) {
                ix += e.a.a.b.b.a.f(6, this.wOX);
            }
            int bs = ix + e.a.a.b.b.a.bs(7, this.wOY);
            AppMethodBeat.o(28577);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(28577);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            blw blw = (blw) objArr[1];
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
                        blw.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(28577);
                    return 0;
                case 2:
                    blw.wOT = aVar3.BTU.readString();
                    AppMethodBeat.o(28577);
                    return 0;
                case 3:
                    blw.wOU = aVar3.BTU.readString();
                    AppMethodBeat.o(28577);
                    return 0;
                case 4:
                    blw.wOV = aVar3.BTU.readString();
                    AppMethodBeat.o(28577);
                    return 0;
                case 5:
                    blw.wOW = aVar3.BTU.readString();
                    AppMethodBeat.o(28577);
                    return 0;
                case 6:
                    blw.wOX = aVar3.BTU.readString();
                    AppMethodBeat.o(28577);
                    return 0;
                case 7:
                    blw.wOY = aVar3.BTU.vd();
                    AppMethodBeat.o(28577);
                    return 0;
                default:
                    AppMethodBeat.o(28577);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28577);
            return -1;
        }
    }
}
