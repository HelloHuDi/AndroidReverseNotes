package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class alm extends a {
    public String aOt;
    public String app_id;
    public LinkedList<String> wqM = new LinkedList();

    public alm() {
        AppMethodBeat.i(80085);
        AppMethodBeat.o(80085);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(80086);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.aOt != null) {
                aVar.e(1, this.aOt);
            }
            if (this.app_id != null) {
                aVar.e(2, this.app_id);
            }
            aVar.e(3, 1, this.wqM);
            AppMethodBeat.o(80086);
            return 0;
        } else if (i == 1) {
            if (this.aOt != null) {
                f = e.a.a.b.b.a.f(1, this.aOt) + 0;
            } else {
                f = 0;
            }
            if (this.app_id != null) {
                f += e.a.a.b.b.a.f(2, this.app_id);
            }
            int c = f + e.a.a.a.c(3, 1, this.wqM);
            AppMethodBeat.o(80086);
            return c;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.wqM.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(80086);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            alm alm = (alm) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    alm.aOt = aVar3.BTU.readString();
                    AppMethodBeat.o(80086);
                    return 0;
                case 2:
                    alm.app_id = aVar3.BTU.readString();
                    AppMethodBeat.o(80086);
                    return 0;
                case 3:
                    alm.wqM.add(aVar3.BTU.readString());
                    AppMethodBeat.o(80086);
                    return 0;
                default:
                    AppMethodBeat.o(80086);
                    return -1;
            }
        } else {
            AppMethodBeat.o(80086);
            return -1;
        }
    }
}
