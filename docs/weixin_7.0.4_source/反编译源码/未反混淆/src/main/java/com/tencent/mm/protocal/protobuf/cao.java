package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class cao extends a {
    public String ptv;
    public long vQE;
    public long wZM;
    public can wZN;
    public can wZO;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(94564);
        b bVar;
        int o;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wZN == null) {
                bVar = new b("Not all required fields were included: CurrentAction");
                AppMethodBeat.o(94564);
                throw bVar;
            }
            aVar.ai(1, this.vQE);
            aVar.ai(2, this.wZM);
            if (this.wZN != null) {
                aVar.iy(3, this.wZN.computeSize());
                this.wZN.writeFields(aVar);
            }
            if (this.wZO != null) {
                aVar.iy(4, this.wZO.computeSize());
                this.wZO.writeFields(aVar);
            }
            if (this.ptv != null) {
                aVar.e(5, this.ptv);
            }
            AppMethodBeat.o(94564);
            return 0;
        } else if (i == 1) {
            o = (e.a.a.b.b.a.o(1, this.vQE) + 0) + e.a.a.b.b.a.o(2, this.wZM);
            if (this.wZN != null) {
                o += e.a.a.a.ix(3, this.wZN.computeSize());
            }
            if (this.wZO != null) {
                o += e.a.a.a.ix(4, this.wZO.computeSize());
            }
            if (this.ptv != null) {
                o += e.a.a.b.b.a.f(5, this.ptv);
            }
            AppMethodBeat.o(94564);
            return o;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (o = a.getNextFieldNumber(aVar2); o > 0; o = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, o)) {
                    aVar2.ems();
                }
            }
            if (this.wZN == null) {
                bVar = new b("Not all required fields were included: CurrentAction");
                AppMethodBeat.o(94564);
                throw bVar;
            }
            AppMethodBeat.o(94564);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cao cao = (cao) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            can can;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    cao.vQE = aVar3.BTU.ve();
                    AppMethodBeat.o(94564);
                    return 0;
                case 2:
                    cao.wZM = aVar3.BTU.ve();
                    AppMethodBeat.o(94564);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        can = new can();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = can.populateBuilderWithField(aVar4, can, a.getNextFieldNumber(aVar4))) {
                        }
                        cao.wZN = can;
                    }
                    AppMethodBeat.o(94564);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        can = new can();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = can.populateBuilderWithField(aVar4, can, a.getNextFieldNumber(aVar4))) {
                        }
                        cao.wZO = can;
                    }
                    AppMethodBeat.o(94564);
                    return 0;
                case 5:
                    cao.ptv = aVar3.BTU.readString();
                    AppMethodBeat.o(94564);
                    return 0;
                default:
                    AppMethodBeat.o(94564);
                    return -1;
            }
        } else {
            AppMethodBeat.o(94564);
            return -1;
        }
    }
}
