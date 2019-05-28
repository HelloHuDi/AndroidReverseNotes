package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class gq extends bsr {
    public int Scene;
    public long jBP;
    public int vIN;
    public LinkedList<ua> vIO = new LinkedList();
    public String vIP;
    public String vIQ;
    public String vIR;
    public String vIS;

    public gq() {
        AppMethodBeat.i(28327);
        AppMethodBeat.o(28327);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28328);
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.iz(2, this.vIN);
            aVar.e(3, 8, this.vIO);
            if (this.vIP != null) {
                aVar.e(4, this.vIP);
            }
            if (this.vIQ != null) {
                aVar.e(5, this.vIQ);
            }
            aVar.iz(6, this.Scene);
            aVar.ai(7, this.jBP);
            if (this.vIR != null) {
                aVar.e(8, this.vIR);
            }
            if (this.vIS != null) {
                aVar.e(9, this.vIS);
            }
            AppMethodBeat.o(28328);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (ix + e.a.a.b.b.a.bs(2, this.vIN)) + e.a.a.a.c(3, 8, this.vIO);
            if (this.vIP != null) {
                ix += e.a.a.b.b.a.f(4, this.vIP);
            }
            if (this.vIQ != null) {
                ix += e.a.a.b.b.a.f(5, this.vIQ);
            }
            ix = (ix + e.a.a.b.b.a.bs(6, this.Scene)) + e.a.a.b.b.a.o(7, this.jBP);
            if (this.vIR != null) {
                ix += e.a.a.b.b.a.f(8, this.vIR);
            }
            if (this.vIS != null) {
                ix += e.a.a.b.b.a.f(9, this.vIS);
            }
            AppMethodBeat.o(28328);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vIO.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(28328);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            gq gqVar = (gq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
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
                        gqVar.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(28328);
                    return 0;
                case 2:
                    gqVar.vIN = aVar3.BTU.vd();
                    AppMethodBeat.o(28328);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ua uaVar = new ua();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = uaVar.populateBuilderWithField(aVar4, uaVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        gqVar.vIO.add(uaVar);
                    }
                    AppMethodBeat.o(28328);
                    return 0;
                case 4:
                    gqVar.vIP = aVar3.BTU.readString();
                    AppMethodBeat.o(28328);
                    return 0;
                case 5:
                    gqVar.vIQ = aVar3.BTU.readString();
                    AppMethodBeat.o(28328);
                    return 0;
                case 6:
                    gqVar.Scene = aVar3.BTU.vd();
                    AppMethodBeat.o(28328);
                    return 0;
                case 7:
                    gqVar.jBP = aVar3.BTU.ve();
                    AppMethodBeat.o(28328);
                    return 0;
                case 8:
                    gqVar.vIR = aVar3.BTU.readString();
                    AppMethodBeat.o(28328);
                    return 0;
                case 9:
                    gqVar.vIS = aVar3.BTU.readString();
                    AppMethodBeat.o(28328);
                    return 0;
                default:
                    AppMethodBeat.o(28328);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28328);
            return -1;
        }
    }
}
