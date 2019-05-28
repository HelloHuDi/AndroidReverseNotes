package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class eb extends bsr {
    public String session_id;
    public String url;
    public LinkedList<to> vFN = new LinkedList();
    public int vFO;
    public int vFP;

    public eb() {
        AppMethodBeat.i(14683);
        AppMethodBeat.o(14683);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(14684);
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.url != null) {
                aVar.e(2, this.url);
            }
            aVar.e(4, 8, this.vFN);
            if (this.session_id != null) {
                aVar.e(5, this.session_id);
            }
            aVar.iz(6, this.vFO);
            aVar.iz(7, this.vFP);
            AppMethodBeat.o(14684);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.url != null) {
                ix += e.a.a.b.b.a.f(2, this.url);
            }
            ix += e.a.a.a.c(4, 8, this.vFN);
            if (this.session_id != null) {
                ix += e.a.a.b.b.a.f(5, this.session_id);
            }
            int bs = (ix + e.a.a.b.b.a.bs(6, this.vFO)) + e.a.a.b.b.a.bs(7, this.vFP);
            AppMethodBeat.o(14684);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vFN.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(14684);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            eb ebVar = (eb) objArr[1];
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
                        ebVar.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(14684);
                    return 0;
                case 2:
                    ebVar.url = aVar3.BTU.readString();
                    AppMethodBeat.o(14684);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        to toVar = new to();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = toVar.populateBuilderWithField(aVar4, toVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        ebVar.vFN.add(toVar);
                    }
                    AppMethodBeat.o(14684);
                    return 0;
                case 5:
                    ebVar.session_id = aVar3.BTU.readString();
                    AppMethodBeat.o(14684);
                    return 0;
                case 6:
                    ebVar.vFO = aVar3.BTU.vd();
                    AppMethodBeat.o(14684);
                    return 0;
                case 7:
                    ebVar.vFP = aVar3.BTU.vd();
                    AppMethodBeat.o(14684);
                    return 0;
                default:
                    AppMethodBeat.o(14684);
                    return -1;
            }
        } else {
            AppMethodBeat.o(14684);
            return -1;
        }
    }
}
