package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class ajq extends a {
    public int Ret;
    public asq vKM;
    public String wdB;
    public int wpk;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(10181);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.Ret);
            if (this.vKM != null) {
                aVar.iy(2, this.vKM.computeSize());
                this.vKM.writeFields(aVar);
            }
            if (this.wdB != null) {
                aVar.e(3, this.wdB);
            }
            aVar.iz(4, this.wpk);
            AppMethodBeat.o(10181);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.Ret) + 0;
            if (this.vKM != null) {
                bs += e.a.a.a.ix(2, this.vKM.computeSize());
            }
            if (this.wdB != null) {
                bs += e.a.a.b.b.a.f(3, this.wdB);
            }
            bs += e.a.a.b.b.a.bs(4, this.wpk);
            AppMethodBeat.o(10181);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(10181);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ajq ajq = (ajq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ajq.Ret = aVar3.BTU.vd();
                    AppMethodBeat.o(10181);
                    return 0;
                case 2:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        asq asq = new asq();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = asq.populateBuilderWithField(aVar4, asq, a.getNextFieldNumber(aVar4))) {
                        }
                        ajq.vKM = asq;
                    }
                    AppMethodBeat.o(10181);
                    return 0;
                case 3:
                    ajq.wdB = aVar3.BTU.readString();
                    AppMethodBeat.o(10181);
                    return 0;
                case 4:
                    ajq.wpk = aVar3.BTU.vd();
                    AppMethodBeat.o(10181);
                    return 0;
                default:
                    AppMethodBeat.o(10181);
                    return -1;
            }
        } else {
            AppMethodBeat.o(10181);
            return -1;
        }
    }
}
