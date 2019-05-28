package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class ble extends a {
    public String path;
    public String query;
    public int scene;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(114981);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.path != null) {
                aVar.e(1, this.path);
            }
            if (this.query != null) {
                aVar.e(2, this.query);
            }
            aVar.iz(3, this.scene);
            AppMethodBeat.o(114981);
            return 0;
        } else if (i == 1) {
            if (this.path != null) {
                f = e.a.a.b.b.a.f(1, this.path) + 0;
            } else {
                f = 0;
            }
            if (this.query != null) {
                f += e.a.a.b.b.a.f(2, this.query);
            }
            int bs = f + e.a.a.b.b.a.bs(3, this.scene);
            AppMethodBeat.o(114981);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(114981);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ble ble = (ble) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ble.path = aVar3.BTU.readString();
                    AppMethodBeat.o(114981);
                    return 0;
                case 2:
                    ble.query = aVar3.BTU.readString();
                    AppMethodBeat.o(114981);
                    return 0;
                case 3:
                    ble.scene = aVar3.BTU.vd();
                    AppMethodBeat.o(114981);
                    return 0;
                default:
                    AppMethodBeat.o(114981);
                    return -1;
            }
        } else {
            AppMethodBeat.o(114981);
            return -1;
        }
    }
}
