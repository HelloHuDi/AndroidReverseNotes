package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class cfn extends bsr {
    public cad xeP;
    public String xeR;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56983);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.xeP != null) {
                aVar.iy(2, this.xeP.computeSize());
                this.xeP.writeFields(aVar);
            }
            if (this.xeR != null) {
                aVar.e(3, this.xeR);
            }
            AppMethodBeat.o(56983);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.xeP != null) {
                ix += e.a.a.a.ix(2, this.xeP.computeSize());
            }
            if (this.xeR != null) {
                ix += e.a.a.b.b.a.f(3, this.xeR);
            }
            AppMethodBeat.o(56983);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56983);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cfn cfn = (cfn) objArr[1];
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
                        hl hlVar = new hl();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = hlVar.populateBuilderWithField(aVar4, hlVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cfn.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(56983);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cad cad = new cad();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cad.populateBuilderWithField(aVar4, cad, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cfn.xeP = cad;
                    }
                    AppMethodBeat.o(56983);
                    return 0;
                case 3:
                    cfn.xeR = aVar3.BTU.readString();
                    AppMethodBeat.o(56983);
                    return 0;
                default:
                    AppMethodBeat.o(56983);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56983);
            return -1;
        }
    }
}
