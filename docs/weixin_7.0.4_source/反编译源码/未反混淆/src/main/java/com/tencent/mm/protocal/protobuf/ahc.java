package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class ahc extends a {
    public int vEI;
    public bts wnA;
    public int wnB;
    public int wnC;
    public int wnD = 1;
    public int wnE;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(5580);
        b bVar;
        int ix;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wnA == null) {
                bVar = new b("Not all required fields were included: ChatroomId");
                AppMethodBeat.o(5580);
                throw bVar;
            }
            if (this.wnA != null) {
                aVar.iy(1, this.wnA.computeSize());
                this.wnA.writeFields(aVar);
            }
            aVar.iz(2, this.vEI);
            aVar.iz(3, this.wnB);
            aVar.iz(4, this.wnC);
            aVar.iz(5, this.wnD);
            aVar.iz(6, this.wnE);
            AppMethodBeat.o(5580);
            return 0;
        } else if (i == 1) {
            if (this.wnA != null) {
                ix = e.a.a.a.ix(1, this.wnA.computeSize()) + 0;
            } else {
                ix = 0;
            }
            int bs = ((((ix + e.a.a.b.b.a.bs(2, this.vEI)) + e.a.a.b.b.a.bs(3, this.wnB)) + e.a.a.b.b.a.bs(4, this.wnC)) + e.a.a.b.b.a.bs(5, this.wnD)) + e.a.a.b.b.a.bs(6, this.wnE);
            AppMethodBeat.o(5580);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.wnA == null) {
                bVar = new b("Not all required fields were included: ChatroomId");
                AppMethodBeat.o(5580);
                throw bVar;
            }
            AppMethodBeat.o(5580);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ahc ahc = (ahc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        bts bts = new bts();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bts.populateBuilderWithField(aVar4, bts, a.getNextFieldNumber(aVar4))) {
                        }
                        ahc.wnA = bts;
                    }
                    AppMethodBeat.o(5580);
                    return 0;
                case 2:
                    ahc.vEI = aVar3.BTU.vd();
                    AppMethodBeat.o(5580);
                    return 0;
                case 3:
                    ahc.wnB = aVar3.BTU.vd();
                    AppMethodBeat.o(5580);
                    return 0;
                case 4:
                    ahc.wnC = aVar3.BTU.vd();
                    AppMethodBeat.o(5580);
                    return 0;
                case 5:
                    ahc.wnD = aVar3.BTU.vd();
                    AppMethodBeat.o(5580);
                    return 0;
                case 6:
                    ahc.wnE = aVar3.BTU.vd();
                    AppMethodBeat.o(5580);
                    return 0;
                default:
                    AppMethodBeat.o(5580);
                    return -1;
            }
        } else {
            AppMethodBeat.o(5580);
            return -1;
        }
    }
}
