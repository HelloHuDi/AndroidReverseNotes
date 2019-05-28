package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class bce extends a {
    public asq vLi;
    public asr vLj;
    public int wGJ;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28553);
        b bVar;
        int ix;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vLi == null) {
                bVar = new b("Not all required fields were included: HardDevice");
                AppMethodBeat.o(28553);
                throw bVar;
            } else if (this.vLj == null) {
                bVar = new b("Not all required fields were included: HardDeviceAttr");
                AppMethodBeat.o(28553);
                throw bVar;
            } else {
                if (this.vLi != null) {
                    aVar.iy(1, this.vLi.computeSize());
                    this.vLi.writeFields(aVar);
                }
                if (this.vLj != null) {
                    aVar.iy(2, this.vLj.computeSize());
                    this.vLj.writeFields(aVar);
                }
                aVar.iz(3, this.wGJ);
                AppMethodBeat.o(28553);
                return 0;
            }
        } else if (i == 1) {
            if (this.vLi != null) {
                ix = e.a.a.a.ix(1, this.vLi.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.vLj != null) {
                ix += e.a.a.a.ix(2, this.vLj.computeSize());
            }
            int bs = ix + e.a.a.b.b.a.bs(3, this.wGJ);
            AppMethodBeat.o(28553);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.vLi == null) {
                bVar = new b("Not all required fields were included: HardDevice");
                AppMethodBeat.o(28553);
                throw bVar;
            } else if (this.vLj == null) {
                bVar = new b("Not all required fields were included: HardDeviceAttr");
                AppMethodBeat.o(28553);
                throw bVar;
            } else {
                AppMethodBeat.o(28553);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bce bce = (bce) objArr[1];
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
                        asq asq = new asq();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = asq.populateBuilderWithField(aVar4, asq, a.getNextFieldNumber(aVar4))) {
                        }
                        bce.vLi = asq;
                    }
                    AppMethodBeat.o(28553);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        asr asr = new asr();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = asr.populateBuilderWithField(aVar4, asr, a.getNextFieldNumber(aVar4))) {
                        }
                        bce.vLj = asr;
                    }
                    AppMethodBeat.o(28553);
                    return 0;
                case 3:
                    bce.wGJ = aVar3.BTU.vd();
                    AppMethodBeat.o(28553);
                    return 0;
                default:
                    AppMethodBeat.o(28553);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28553);
            return -1;
        }
    }
}
