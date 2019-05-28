package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class agt extends bsr {
    public String kfA;
    public double latitude;
    public double longitude;
    public String wnm;
    public String wnn;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(89087);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.f(2, this.latitude);
            aVar.f(3, this.longitude);
            if (this.kfA != null) {
                aVar.e(4, this.kfA);
            }
            if (this.wnm != null) {
                aVar.e(5, this.wnm);
            }
            if (this.wnn != null) {
                aVar.e(6, this.wnn);
            }
            AppMethodBeat.o(89087);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (ix + (e.a.a.b.b.a.fv(2) + 8)) + (e.a.a.b.b.a.fv(3) + 8);
            if (this.kfA != null) {
                ix += e.a.a.b.b.a.f(4, this.kfA);
            }
            if (this.wnm != null) {
                ix += e.a.a.b.b.a.f(5, this.wnm);
            }
            if (this.wnn != null) {
                ix += e.a.a.b.b.a.f(6, this.wnn);
            }
            AppMethodBeat.o(89087);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(89087);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            agt agt = (agt) objArr[1];
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
                        agt.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(89087);
                    return 0;
                case 2:
                    agt.latitude = Double.longBitsToDouble(aVar3.BTU.eib());
                    AppMethodBeat.o(89087);
                    return 0;
                case 3:
                    agt.longitude = Double.longBitsToDouble(aVar3.BTU.eib());
                    AppMethodBeat.o(89087);
                    return 0;
                case 4:
                    agt.kfA = aVar3.BTU.readString();
                    AppMethodBeat.o(89087);
                    return 0;
                case 5:
                    agt.wnm = aVar3.BTU.readString();
                    AppMethodBeat.o(89087);
                    return 0;
                case 6:
                    agt.wnn = aVar3.BTU.readString();
                    AppMethodBeat.o(89087);
                    return 0;
                default:
                    AppMethodBeat.o(89087);
                    return -1;
            }
        } else {
            AppMethodBeat.o(89087);
            return -1;
        }
    }
}
