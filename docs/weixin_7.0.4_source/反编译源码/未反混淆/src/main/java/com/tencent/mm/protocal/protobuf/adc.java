package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class adc extends a {
    public acv wkV;
    public LinkedList<String> wkW = new LinkedList();

    public adc() {
        AppMethodBeat.i(112432);
        AppMethodBeat.o(112432);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(112433);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wkV == null) {
                bVar = new b("Not all required fields were included: GameItem");
                AppMethodBeat.o(112433);
                throw bVar;
            }
            if (this.wkV != null) {
                aVar.iy(1, this.wkV.computeSize());
                this.wkV.writeFields(aVar);
            }
            aVar.e(2, 1, this.wkW);
            AppMethodBeat.o(112433);
            return 0;
        } else if (i == 1) {
            if (this.wkV != null) {
                ix = e.a.a.a.ix(1, this.wkV.computeSize()) + 0;
            } else {
                ix = 0;
            }
            int c = ix + e.a.a.a.c(2, 1, this.wkW);
            AppMethodBeat.o(112433);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wkW.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.wkV == null) {
                bVar = new b("Not all required fields were included: GameItem");
                AppMethodBeat.o(112433);
                throw bVar;
            }
            AppMethodBeat.o(112433);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            adc adc = (adc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        acv acv = new acv();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = acv.populateBuilderWithField(aVar4, acv, a.getNextFieldNumber(aVar4))) {
                        }
                        adc.wkV = acv;
                    }
                    AppMethodBeat.o(112433);
                    return 0;
                case 2:
                    adc.wkW.add(aVar3.BTU.readString());
                    AppMethodBeat.o(112433);
                    return 0;
                default:
                    AppMethodBeat.o(112433);
                    return -1;
            }
        } else {
            AppMethodBeat.o(112433);
            return -1;
        }
    }
}
