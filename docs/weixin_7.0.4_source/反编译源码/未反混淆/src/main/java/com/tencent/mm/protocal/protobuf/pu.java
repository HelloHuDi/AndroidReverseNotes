package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class pu extends bsr {
    public String desc;
    public boolean vWT;
    public boolean vWU;
    public LinkedList<Integer> vWt = new LinkedList();

    public pu() {
        AppMethodBeat.i(48806);
        AppMethodBeat.o(48806);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(48807);
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.e(2, 2, this.vWt);
            if (this.desc != null) {
                aVar.e(3, this.desc);
            }
            aVar.aO(4, this.vWT);
            aVar.aO(5, this.vWU);
            AppMethodBeat.o(48807);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += e.a.a.a.c(2, 2, this.vWt);
            if (this.desc != null) {
                ix += e.a.a.b.b.a.f(3, this.desc);
            }
            int fv = (ix + (e.a.a.b.b.a.fv(4) + 1)) + (e.a.a.b.b.a.fv(5) + 1);
            AppMethodBeat.o(48807);
            return fv;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vWt.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(48807);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            pu puVar = (pu) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        hl hlVar = new hl();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = hlVar.populateBuilderWithField(aVar4, hlVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        puVar.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(48807);
                    return 0;
                case 2:
                    puVar.vWt.add(Integer.valueOf(aVar3.BTU.vd()));
                    AppMethodBeat.o(48807);
                    return 0;
                case 3:
                    puVar.desc = aVar3.BTU.readString();
                    AppMethodBeat.o(48807);
                    return 0;
                case 4:
                    puVar.vWT = aVar3.BTU.ehX();
                    AppMethodBeat.o(48807);
                    return 0;
                case 5:
                    puVar.vWU = aVar3.BTU.ehX();
                    AppMethodBeat.o(48807);
                    return 0;
                default:
                    AppMethodBeat.o(48807);
                    return -1;
            }
        } else {
            AppMethodBeat.o(48807);
            return -1;
        }
    }
}
