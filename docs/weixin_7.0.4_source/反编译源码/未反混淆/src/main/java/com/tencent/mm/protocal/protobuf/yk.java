package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class yk extends a {
    public yl wej;
    public yj wek;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(80051);
        b bVar;
        int ix;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wej == null) {
                bVar = new b("Not all required fields were included: RsaReqData");
                AppMethodBeat.o(80051);
                throw bVar;
            } else if (this.wek == null) {
                bVar = new b("Not all required fields were included: AesReqData");
                AppMethodBeat.o(80051);
                throw bVar;
            } else {
                if (this.wej != null) {
                    aVar.iy(1, this.wej.computeSize());
                    this.wej.writeFields(aVar);
                }
                if (this.wek != null) {
                    aVar.iy(2, this.wek.computeSize());
                    this.wek.writeFields(aVar);
                }
                AppMethodBeat.o(80051);
                return 0;
            }
        } else if (i == 1) {
            if (this.wej != null) {
                ix = e.a.a.a.ix(1, this.wej.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wek != null) {
                ix += e.a.a.a.ix(2, this.wek.computeSize());
            }
            AppMethodBeat.o(80051);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.wej == null) {
                bVar = new b("Not all required fields were included: RsaReqData");
                AppMethodBeat.o(80051);
                throw bVar;
            } else if (this.wek == null) {
                bVar = new b("Not all required fields were included: AesReqData");
                AppMethodBeat.o(80051);
                throw bVar;
            } else {
                AppMethodBeat.o(80051);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            yk ykVar = (yk) objArr[1];
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
                        yl ylVar = new yl();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ylVar.populateBuilderWithField(aVar4, ylVar, a.getNextFieldNumber(aVar4))) {
                        }
                        ykVar.wej = ylVar;
                    }
                    AppMethodBeat.o(80051);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        yj yjVar = new yj();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = yjVar.populateBuilderWithField(aVar4, yjVar, a.getNextFieldNumber(aVar4))) {
                        }
                        ykVar.wek = yjVar;
                    }
                    AppMethodBeat.o(80051);
                    return 0;
                default:
                    AppMethodBeat.o(80051);
                    return -1;
            }
        } else {
            AppMethodBeat.o(80051);
            return -1;
        }
    }
}
