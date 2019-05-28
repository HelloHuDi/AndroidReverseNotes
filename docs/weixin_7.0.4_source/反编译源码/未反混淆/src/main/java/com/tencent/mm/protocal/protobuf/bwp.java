package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bwp extends bsr {
    public String Name;
    public String mZR;
    public String oRb;
    public String vEA;
    public String wXa;
    public String wXb;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(73758);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.mZR != null) {
                aVar.e(2, this.mZR);
            }
            if (this.wXa != null) {
                aVar.e(3, this.wXa);
            }
            if (this.oRb != null) {
                aVar.e(5, this.oRb);
            }
            if (this.Name != null) {
                aVar.e(4, this.Name);
            }
            if (this.vEA != null) {
                aVar.e(6, this.vEA);
            }
            if (this.wXb != null) {
                aVar.e(7, this.wXb);
            }
            AppMethodBeat.o(73758);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.mZR != null) {
                ix += e.a.a.b.b.a.f(2, this.mZR);
            }
            if (this.wXa != null) {
                ix += e.a.a.b.b.a.f(3, this.wXa);
            }
            if (this.oRb != null) {
                ix += e.a.a.b.b.a.f(5, this.oRb);
            }
            if (this.Name != null) {
                ix += e.a.a.b.b.a.f(4, this.Name);
            }
            if (this.vEA != null) {
                ix += e.a.a.b.b.a.f(6, this.vEA);
            }
            if (this.wXb != null) {
                ix += e.a.a.b.b.a.f(7, this.wXb);
            }
            AppMethodBeat.o(73758);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(73758);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bwp bwp = (bwp) objArr[1];
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
                        bwp.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(73758);
                    return 0;
                case 2:
                    bwp.mZR = aVar3.BTU.readString();
                    AppMethodBeat.o(73758);
                    return 0;
                case 3:
                    bwp.wXa = aVar3.BTU.readString();
                    AppMethodBeat.o(73758);
                    return 0;
                case 4:
                    bwp.Name = aVar3.BTU.readString();
                    AppMethodBeat.o(73758);
                    return 0;
                case 5:
                    bwp.oRb = aVar3.BTU.readString();
                    AppMethodBeat.o(73758);
                    return 0;
                case 6:
                    bwp.vEA = aVar3.BTU.readString();
                    AppMethodBeat.o(73758);
                    return 0;
                case 7:
                    bwp.wXb = aVar3.BTU.readString();
                    AppMethodBeat.o(73758);
                    return 0;
                default:
                    AppMethodBeat.o(73758);
                    return -1;
            }
        } else {
            AppMethodBeat.o(73758);
            return -1;
        }
    }
}
