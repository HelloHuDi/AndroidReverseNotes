package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class cex extends a {
    public int jCt;
    public long vQE;
    public cey xex;
    public cey xey;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56543);
        b bVar;
        int o;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.xex == null) {
                bVar = new b("Not all required fields were included: SyncMsgDetail");
                AppMethodBeat.o(56543);
                throw bVar;
            }
            aVar.ai(1, this.vQE);
            aVar.iz(2, this.jCt);
            if (this.xex != null) {
                aVar.iy(3, this.xex.computeSize());
                this.xex.writeFields(aVar);
            }
            if (this.xey != null) {
                aVar.iy(4, this.xey.computeSize());
                this.xey.writeFields(aVar);
            }
            AppMethodBeat.o(56543);
            return 0;
        } else if (i == 1) {
            o = (e.a.a.b.b.a.o(1, this.vQE) + 0) + e.a.a.b.b.a.bs(2, this.jCt);
            if (this.xex != null) {
                o += e.a.a.a.ix(3, this.xex.computeSize());
            }
            if (this.xey != null) {
                o += e.a.a.a.ix(4, this.xey.computeSize());
            }
            AppMethodBeat.o(56543);
            return o;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (o = a.getNextFieldNumber(aVar2); o > 0; o = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, o)) {
                    aVar2.ems();
                }
            }
            if (this.xex == null) {
                bVar = new b("Not all required fields were included: SyncMsgDetail");
                AppMethodBeat.o(56543);
                throw bVar;
            }
            AppMethodBeat.o(56543);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cex cex = (cex) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            cey cey;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    cex.vQE = aVar3.BTU.ve();
                    AppMethodBeat.o(56543);
                    return 0;
                case 2:
                    cex.jCt = aVar3.BTU.vd();
                    AppMethodBeat.o(56543);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cey = new cey();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cey.populateBuilderWithField(aVar4, cey, a.getNextFieldNumber(aVar4))) {
                        }
                        cex.xex = cey;
                    }
                    AppMethodBeat.o(56543);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cey = new cey();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cey.populateBuilderWithField(aVar4, cey, a.getNextFieldNumber(aVar4))) {
                        }
                        cex.xey = cey;
                    }
                    AppMethodBeat.o(56543);
                    return 0;
                default:
                    AppMethodBeat.o(56543);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56543);
            return -1;
        }
    }
}
