package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class aut extends bsr {
    public int ehB;
    public LinkedList<bay> vEh = new LinkedList();
    public bts vEi;
    public int wyV;
    public String wyW;

    public aut() {
        AppMethodBeat.i(5590);
        AppMethodBeat.o(5590);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(5591);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.vEi == null) {
                bVar = new b("Not all required fields were included: ChatRoomName");
                AppMethodBeat.o(5591);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.iz(2, this.ehB);
            aVar.e(3, 8, this.vEh);
            if (this.vEi != null) {
                aVar.iy(4, this.vEi.computeSize());
                this.vEi.writeFields(aVar);
            }
            aVar.iz(5, this.wyV);
            if (this.wyW != null) {
                aVar.e(6, this.wyW);
            }
            AppMethodBeat.o(5591);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (ix + e.a.a.b.b.a.bs(2, this.ehB)) + e.a.a.a.c(3, 8, this.vEh);
            if (this.vEi != null) {
                ix += e.a.a.a.ix(4, this.vEi.computeSize());
            }
            ix += e.a.a.b.b.a.bs(5, this.wyV);
            if (this.wyW != null) {
                ix += e.a.a.b.b.a.f(6, this.wyW);
            }
            AppMethodBeat.o(5591);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vEh.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.vEi == null) {
                bVar = new b("Not all required fields were included: ChatRoomName");
                AppMethodBeat.o(5591);
                throw bVar;
            }
            AppMethodBeat.o(5591);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aut aut = (aut) objArr[1];
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
                        aut.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(5591);
                    return 0;
                case 2:
                    aut.ehB = aVar3.BTU.vd();
                    AppMethodBeat.o(5591);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bay bay = new bay();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bay.populateBuilderWithField(aVar4, bay, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        aut.vEh.add(bay);
                    }
                    AppMethodBeat.o(5591);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        aut.vEi = bts;
                    }
                    AppMethodBeat.o(5591);
                    return 0;
                case 5:
                    aut.wyV = aVar3.BTU.vd();
                    AppMethodBeat.o(5591);
                    return 0;
                case 6:
                    aut.wyW = aVar3.BTU.readString();
                    AppMethodBeat.o(5591);
                    return 0;
                default:
                    AppMethodBeat.o(5591);
                    return -1;
            }
        } else {
            AppMethodBeat.o(5591);
            return -1;
        }
    }
}
