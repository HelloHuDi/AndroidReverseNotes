package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class cnx extends a {
    public bif wVz;
    public bam xlt;
    public int xlu;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(48987);
        int ix;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wVz != null) {
                aVar.iy(1, this.wVz.computeSize());
                this.wVz.writeFields(aVar);
            }
            if (this.xlt != null) {
                aVar.iy(2, this.xlt.computeSize());
                this.xlt.writeFields(aVar);
            }
            aVar.iz(3, this.xlu);
            AppMethodBeat.o(48987);
            return 0;
        } else if (i == 1) {
            if (this.wVz != null) {
                ix = e.a.a.a.ix(1, this.wVz.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.xlt != null) {
                ix += e.a.a.a.ix(2, this.xlt.computeSize());
            }
            int bs = ix + e.a.a.b.b.a.bs(3, this.xlu);
            AppMethodBeat.o(48987);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(48987);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cnx cnx = (cnx) objArr[1];
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
                        bif bif = new bif();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bif.populateBuilderWithField(aVar4, bif, a.getNextFieldNumber(aVar4))) {
                        }
                        cnx.wVz = bif;
                    }
                    AppMethodBeat.o(48987);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bam bam = new bam();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bam.populateBuilderWithField(aVar4, bam, a.getNextFieldNumber(aVar4))) {
                        }
                        cnx.xlt = bam;
                    }
                    AppMethodBeat.o(48987);
                    return 0;
                case 3:
                    cnx.xlu = aVar3.BTU.vd();
                    AppMethodBeat.o(48987);
                    return 0;
                default:
                    AppMethodBeat.o(48987);
                    return -1;
            }
        } else {
            AppMethodBeat.o(48987);
            return -1;
        }
    }
}
