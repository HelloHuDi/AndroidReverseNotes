package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ed extends bsr {
    public int kdC;
    public int offset;
    public int scene;
    public String session_id;
    public String url;
    public int vFO;
    public int vFP;
    public int vFQ;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(14686);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.url != null) {
                aVar.e(2, this.url);
            }
            aVar.iz(4, this.offset);
            aVar.iz(6, this.kdC);
            aVar.iz(7, this.scene);
            aVar.iz(8, this.vFQ);
            aVar.iz(9, this.vFP);
            aVar.iz(10, this.vFO);
            if (this.session_id != null) {
                aVar.e(11, this.session_id);
            }
            AppMethodBeat.o(14686);
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
            ix = (((((ix + e.a.a.b.b.a.bs(4, this.offset)) + e.a.a.b.b.a.bs(6, this.kdC)) + e.a.a.b.b.a.bs(7, this.scene)) + e.a.a.b.b.a.bs(8, this.vFQ)) + e.a.a.b.b.a.bs(9, this.vFP)) + e.a.a.b.b.a.bs(10, this.vFO);
            if (this.session_id != null) {
                ix += e.a.a.b.b.a.f(11, this.session_id);
            }
            AppMethodBeat.o(14686);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(14686);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ed edVar = (ed) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        hl hlVar = new hl();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = hlVar.populateBuilderWithField(aVar4, hlVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        edVar.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(14686);
                    return 0;
                case 2:
                    edVar.url = aVar3.BTU.readString();
                    AppMethodBeat.o(14686);
                    return 0;
                case 4:
                    edVar.offset = aVar3.BTU.vd();
                    AppMethodBeat.o(14686);
                    return 0;
                case 6:
                    edVar.kdC = aVar3.BTU.vd();
                    AppMethodBeat.o(14686);
                    return 0;
                case 7:
                    edVar.scene = aVar3.BTU.vd();
                    AppMethodBeat.o(14686);
                    return 0;
                case 8:
                    edVar.vFQ = aVar3.BTU.vd();
                    AppMethodBeat.o(14686);
                    return 0;
                case 9:
                    edVar.vFP = aVar3.BTU.vd();
                    AppMethodBeat.o(14686);
                    return 0;
                case 10:
                    edVar.vFO = aVar3.BTU.vd();
                    AppMethodBeat.o(14686);
                    return 0;
                case 11:
                    edVar.session_id = aVar3.BTU.readString();
                    AppMethodBeat.o(14686);
                    return 0;
                default:
                    AppMethodBeat.o(14686);
                    return -1;
            }
        } else {
            AppMethodBeat.o(14686);
            return -1;
        }
    }
}
