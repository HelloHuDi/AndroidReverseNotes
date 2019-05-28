package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class hj extends a {
    public String imei;
    public String vJX;
    public String vJY;
    public String vJZ;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(2536);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.imei != null) {
                aVar.e(1, this.imei);
            }
            if (this.vJX != null) {
                aVar.e(2, this.vJX);
            }
            if (this.vJY != null) {
                aVar.e(3, this.vJY);
            }
            if (this.vJZ != null) {
                aVar.e(4, this.vJZ);
            }
            AppMethodBeat.o(2536);
            return 0;
        } else if (i == 1) {
            if (this.imei != null) {
                f = e.a.a.b.b.a.f(1, this.imei) + 0;
            } else {
                f = 0;
            }
            if (this.vJX != null) {
                f += e.a.a.b.b.a.f(2, this.vJX);
            }
            if (this.vJY != null) {
                f += e.a.a.b.b.a.f(3, this.vJY);
            }
            if (this.vJZ != null) {
                f += e.a.a.b.b.a.f(4, this.vJZ);
            }
            AppMethodBeat.o(2536);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(2536);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            hj hjVar = (hj) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    hjVar.imei = aVar3.BTU.readString();
                    AppMethodBeat.o(2536);
                    return 0;
                case 2:
                    hjVar.vJX = aVar3.BTU.readString();
                    AppMethodBeat.o(2536);
                    return 0;
                case 3:
                    hjVar.vJY = aVar3.BTU.readString();
                    AppMethodBeat.o(2536);
                    return 0;
                case 4:
                    hjVar.vJZ = aVar3.BTU.readString();
                    AppMethodBeat.o(2536);
                    return 0;
                default:
                    AppMethodBeat.o(2536);
                    return -1;
            }
        } else {
            AppMethodBeat.o(2536);
            return -1;
        }
    }
}
