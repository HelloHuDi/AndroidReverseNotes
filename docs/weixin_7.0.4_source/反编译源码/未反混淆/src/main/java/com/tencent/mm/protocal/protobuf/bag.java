package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class bag extends a {
    public bah wEb;
    public baf wEc;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(58913);
        b bVar;
        int ix;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wEb == null) {
                bVar = new b("Not all required fields were included: RsaReqData");
                AppMethodBeat.o(58913);
                throw bVar;
            } else if (this.wEc == null) {
                bVar = new b("Not all required fields were included: AesReqData");
                AppMethodBeat.o(58913);
                throw bVar;
            } else {
                if (this.wEb != null) {
                    aVar.iy(1, this.wEb.computeSize());
                    this.wEb.writeFields(aVar);
                }
                if (this.wEc != null) {
                    aVar.iy(2, this.wEc.computeSize());
                    this.wEc.writeFields(aVar);
                }
                AppMethodBeat.o(58913);
                return 0;
            }
        } else if (i == 1) {
            if (this.wEb != null) {
                ix = e.a.a.a.ix(1, this.wEb.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wEc != null) {
                ix += e.a.a.a.ix(2, this.wEc.computeSize());
            }
            AppMethodBeat.o(58913);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.wEb == null) {
                bVar = new b("Not all required fields were included: RsaReqData");
                AppMethodBeat.o(58913);
                throw bVar;
            } else if (this.wEc == null) {
                bVar = new b("Not all required fields were included: AesReqData");
                AppMethodBeat.o(58913);
                throw bVar;
            } else {
                AppMethodBeat.o(58913);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bag bag = (bag) objArr[1];
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
                        bah bah = new bah();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bah.populateBuilderWithField(aVar4, bah, a.getNextFieldNumber(aVar4))) {
                        }
                        bag.wEb = bah;
                    }
                    AppMethodBeat.o(58913);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        baf baf = new baf();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = baf.populateBuilderWithField(aVar4, baf, a.getNextFieldNumber(aVar4))) {
                        }
                        bag.wEc = baf;
                    }
                    AppMethodBeat.o(58913);
                    return 0;
                default:
                    AppMethodBeat.o(58913);
                    return -1;
            }
        } else {
            AppMethodBeat.o(58913);
            return -1;
        }
    }
}
