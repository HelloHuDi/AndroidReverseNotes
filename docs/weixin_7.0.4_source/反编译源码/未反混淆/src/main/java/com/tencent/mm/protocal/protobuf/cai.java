package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class cai extends a {
    public cbf wZu;
    public bts wZv;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(94558);
        b bVar;
        int ix;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wZu == null) {
                bVar = new b("Not all required fields were included: SnsObject");
                AppMethodBeat.o(94558);
                throw bVar;
            }
            if (this.wZu != null) {
                aVar.iy(1, this.wZu.computeSize());
                this.wZu.writeFields(aVar);
            }
            if (this.wZv != null) {
                aVar.iy(2, this.wZv.computeSize());
                this.wZv.writeFields(aVar);
            }
            AppMethodBeat.o(94558);
            return 0;
        } else if (i == 1) {
            if (this.wZu != null) {
                ix = e.a.a.a.ix(1, this.wZu.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wZv != null) {
                ix += e.a.a.a.ix(2, this.wZv.computeSize());
            }
            AppMethodBeat.o(94558);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.wZu == null) {
                bVar = new b("Not all required fields were included: SnsObject");
                AppMethodBeat.o(94558);
                throw bVar;
            }
            AppMethodBeat.o(94558);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cai cai = (cai) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cbf cbf = new cbf();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cbf.populateBuilderWithField(aVar4, cbf, a.getNextFieldNumber(aVar4))) {
                        }
                        cai.wZu = cbf;
                    }
                    AppMethodBeat.o(94558);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, a.getNextFieldNumber(aVar4))) {
                        }
                        cai.wZv = bts;
                    }
                    AppMethodBeat.o(94558);
                    return 0;
                default:
                    AppMethodBeat.o(94558);
                    return -1;
            }
        } else {
            AppMethodBeat.o(94558);
            return -1;
        }
    }
}
