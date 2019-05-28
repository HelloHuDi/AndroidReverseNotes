package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class bor extends a {
    public bts vEi;
    public bts wcB;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(5600);
        b bVar;
        int ix;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vEi == null) {
                bVar = new b("Not all required fields were included: ChatRoomName");
                AppMethodBeat.o(5600);
                throw bVar;
            } else if (this.wcB == null) {
                bVar = new b("Not all required fields were included: UserName");
                AppMethodBeat.o(5600);
                throw bVar;
            } else {
                if (this.vEi != null) {
                    aVar.iy(1, this.vEi.computeSize());
                    this.vEi.writeFields(aVar);
                }
                if (this.wcB != null) {
                    aVar.iy(2, this.wcB.computeSize());
                    this.wcB.writeFields(aVar);
                }
                AppMethodBeat.o(5600);
                return 0;
            }
        } else if (i == 1) {
            if (this.vEi != null) {
                ix = e.a.a.a.ix(1, this.vEi.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wcB != null) {
                ix += e.a.a.a.ix(2, this.wcB.computeSize());
            }
            AppMethodBeat.o(5600);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.vEi == null) {
                bVar = new b("Not all required fields were included: ChatRoomName");
                AppMethodBeat.o(5600);
                throw bVar;
            } else if (this.wcB == null) {
                bVar = new b("Not all required fields were included: UserName");
                AppMethodBeat.o(5600);
                throw bVar;
            } else {
                AppMethodBeat.o(5600);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bor bor = (bor) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            bts bts;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, a.getNextFieldNumber(aVar4))) {
                        }
                        bor.vEi = bts;
                    }
                    AppMethodBeat.o(5600);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, a.getNextFieldNumber(aVar4))) {
                        }
                        bor.wcB = bts;
                    }
                    AppMethodBeat.o(5600);
                    return 0;
                default:
                    AppMethodBeat.o(5600);
                    return -1;
            }
        } else {
            AppMethodBeat.o(5600);
            return -1;
        }
    }
}
