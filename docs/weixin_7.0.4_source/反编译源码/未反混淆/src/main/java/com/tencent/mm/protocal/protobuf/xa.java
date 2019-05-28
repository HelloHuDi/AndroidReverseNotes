package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public final class xa extends a {
    public String deviceBrand;
    public String deviceModel;
    public String osName;
    public String osVersion;
    public String wcW;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28385);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.deviceModel != null) {
                aVar.e(1, this.deviceModel);
            }
            if (this.deviceBrand != null) {
                aVar.e(2, this.deviceBrand);
            }
            if (this.osName != null) {
                aVar.e(3, this.osName);
            }
            if (this.osVersion != null) {
                aVar.e(4, this.osVersion);
            }
            if (this.wcW != null) {
                aVar.e(5, this.wcW);
            }
            AppMethodBeat.o(28385);
            return 0;
        } else if (i == 1) {
            if (this.deviceModel != null) {
                f = e.a.a.b.b.a.f(1, this.deviceModel) + 0;
            } else {
                f = 0;
            }
            if (this.deviceBrand != null) {
                f += e.a.a.b.b.a.f(2, this.deviceBrand);
            }
            if (this.osName != null) {
                f += e.a.a.b.b.a.f(3, this.osName);
            }
            if (this.osVersion != null) {
                f += e.a.a.b.b.a.f(4, this.osVersion);
            }
            if (this.wcW != null) {
                f += e.a.a.b.b.a.f(5, this.wcW);
            }
            AppMethodBeat.o(28385);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(28385);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            xa xaVar = (xa) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    xaVar.deviceModel = aVar3.BTU.readString();
                    AppMethodBeat.o(28385);
                    return 0;
                case 2:
                    xaVar.deviceBrand = aVar3.BTU.readString();
                    AppMethodBeat.o(28385);
                    return 0;
                case 3:
                    xaVar.osName = aVar3.BTU.readString();
                    AppMethodBeat.o(28385);
                    return 0;
                case 4:
                    xaVar.osVersion = aVar3.BTU.readString();
                    AppMethodBeat.o(28385);
                    return 0;
                case 5:
                    xaVar.wcW = aVar3.BTU.readString();
                    AppMethodBeat.o(28385);
                    return 0;
                default:
                    AppMethodBeat.o(28385);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28385);
            return -1;
        }
    }
}
