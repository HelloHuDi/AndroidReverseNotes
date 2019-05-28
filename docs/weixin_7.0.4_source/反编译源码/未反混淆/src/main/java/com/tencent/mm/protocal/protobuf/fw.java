package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class fw extends bsr {
    public String csB;
    public LinkedList<String> vIa = new LinkedList();
    public boolean vIb;
    public int vIc;

    public fw() {
        AppMethodBeat.i(102370);
        AppMethodBeat.o(102370);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(102371);
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.csB != null) {
                aVar.e(2, this.csB);
            }
            aVar.e(3, 1, this.vIa);
            aVar.aO(4, this.vIb);
            aVar.iz(5, this.vIc);
            AppMethodBeat.o(102371);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.csB != null) {
                ix += e.a.a.b.b.a.f(2, this.csB);
            }
            int c = ((ix + e.a.a.a.c(3, 1, this.vIa)) + (e.a.a.b.b.a.fv(4) + 1)) + e.a.a.b.b.a.bs(5, this.vIc);
            AppMethodBeat.o(102371);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vIa.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(102371);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            fw fwVar = (fw) objArr[1];
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
                        fwVar.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(102371);
                    return 0;
                case 2:
                    fwVar.csB = aVar3.BTU.readString();
                    AppMethodBeat.o(102371);
                    return 0;
                case 3:
                    fwVar.vIa.add(aVar3.BTU.readString());
                    AppMethodBeat.o(102371);
                    return 0;
                case 4:
                    fwVar.vIb = aVar3.BTU.ehX();
                    AppMethodBeat.o(102371);
                    return 0;
                case 5:
                    fwVar.vIc = aVar3.BTU.vd();
                    AppMethodBeat.o(102371);
                    return 0;
                default:
                    AppMethodBeat.o(102371);
                    return -1;
            }
        } else {
            AppMethodBeat.o(102371);
            return -1;
        }
    }
}
