package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class bid extends a {
    public String app_id;
    public String kmr;
    public String kmt;
    public String tyv;
    public String wLu;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(48915);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.app_id != null) {
                aVar.e(1, this.app_id);
            }
            if (this.tyv != null) {
                aVar.e(2, this.tyv);
            }
            if (this.kmt != null) {
                aVar.e(3, this.kmt);
            }
            if (this.kmr != null) {
                aVar.e(4, this.kmr);
            }
            if (this.wLu != null) {
                aVar.e(5, this.wLu);
            }
            AppMethodBeat.o(48915);
            return 0;
        } else if (i == 1) {
            if (this.app_id != null) {
                f = e.a.a.b.b.a.f(1, this.app_id) + 0;
            } else {
                f = 0;
            }
            if (this.tyv != null) {
                f += e.a.a.b.b.a.f(2, this.tyv);
            }
            if (this.kmt != null) {
                f += e.a.a.b.b.a.f(3, this.kmt);
            }
            if (this.kmr != null) {
                f += e.a.a.b.b.a.f(4, this.kmr);
            }
            if (this.wLu != null) {
                f += e.a.a.b.b.a.f(5, this.wLu);
            }
            AppMethodBeat.o(48915);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(48915);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bid bid = (bid) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bid.app_id = aVar3.BTU.readString();
                    AppMethodBeat.o(48915);
                    return 0;
                case 2:
                    bid.tyv = aVar3.BTU.readString();
                    AppMethodBeat.o(48915);
                    return 0;
                case 3:
                    bid.kmt = aVar3.BTU.readString();
                    AppMethodBeat.o(48915);
                    return 0;
                case 4:
                    bid.kmr = aVar3.BTU.readString();
                    AppMethodBeat.o(48915);
                    return 0;
                case 5:
                    bid.wLu = aVar3.BTU.readString();
                    AppMethodBeat.o(48915);
                    return 0;
                default:
                    AppMethodBeat.o(48915);
                    return -1;
            }
        } else {
            AppMethodBeat.o(48915);
            return -1;
        }
    }
}
