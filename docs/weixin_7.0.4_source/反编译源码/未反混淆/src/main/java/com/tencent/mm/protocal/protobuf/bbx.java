package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class bbx extends a {
    public xe wGB;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(60048);
        b bVar;
        int ix;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wGB == null) {
                bVar = new b("Not all required fields were included: DisturbSetting");
                AppMethodBeat.o(60048);
                throw bVar;
            }
            if (this.wGB != null) {
                aVar.iy(1, this.wGB.computeSize());
                this.wGB.writeFields(aVar);
            }
            AppMethodBeat.o(60048);
            return 0;
        } else if (i == 1) {
            if (this.wGB != null) {
                ix = e.a.a.a.ix(1, this.wGB.computeSize()) + 0;
            } else {
                ix = 0;
            }
            AppMethodBeat.o(60048);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.wGB == null) {
                bVar = new b("Not all required fields were included: DisturbSetting");
                AppMethodBeat.o(60048);
                throw bVar;
            }
            AppMethodBeat.o(60048);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bbx bbx = (bbx) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        xe xeVar = new xe();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = xeVar.populateBuilderWithField(aVar4, xeVar, a.getNextFieldNumber(aVar4))) {
                        }
                        bbx.wGB = xeVar;
                    }
                    AppMethodBeat.o(60048);
                    return 0;
                default:
                    AppMethodBeat.o(60048);
                    return -1;
            }
        } else {
            AppMethodBeat.o(60048);
            return -1;
        }
    }
}
