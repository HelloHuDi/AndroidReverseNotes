package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class bhr extends a {
    public int Ret;
    public bhs wKS;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(60058);
        b bVar;
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wKS == null) {
                bVar = new b("Not all required fields were included: OplogRet");
                AppMethodBeat.o(60058);
                throw bVar;
            }
            aVar.iz(1, this.Ret);
            if (this.wKS != null) {
                aVar.iy(2, this.wKS.computeSize());
                this.wKS.writeFields(aVar);
            }
            AppMethodBeat.o(60058);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.Ret) + 0;
            if (this.wKS != null) {
                bs += e.a.a.a.ix(2, this.wKS.computeSize());
            }
            AppMethodBeat.o(60058);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            if (this.wKS == null) {
                bVar = new b("Not all required fields were included: OplogRet");
                AppMethodBeat.o(60058);
                throw bVar;
            }
            AppMethodBeat.o(60058);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bhr bhr = (bhr) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bhr.Ret = aVar3.BTU.vd();
                    AppMethodBeat.o(60058);
                    return 0;
                case 2:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        bhs bhs = new bhs();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bhs.populateBuilderWithField(aVar4, bhs, a.getNextFieldNumber(aVar4))) {
                        }
                        bhr.wKS = bhs;
                    }
                    AppMethodBeat.o(60058);
                    return 0;
                default:
                    AppMethodBeat.o(60058);
                    return -1;
            }
        } else {
            AppMethodBeat.o(60058);
            return -1;
        }
    }
}
