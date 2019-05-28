package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class vh extends bsr {
    public String vEf;
    public LinkedList<String> vEg = new LinkedList();

    public vh() {
        AppMethodBeat.i(118268);
        AppMethodBeat.o(118268);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(118269);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.vEf == null) {
                bVar = new b("Not all required fields were included: ChatRoomName");
                AppMethodBeat.o(118269);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.vEf != null) {
                aVar.e(2, this.vEf);
            }
            aVar.e(3, 1, this.vEg);
            AppMethodBeat.o(118269);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.vEf != null) {
                ix += e.a.a.b.b.a.f(2, this.vEf);
            }
            int c = ix + e.a.a.a.c(3, 1, this.vEg);
            AppMethodBeat.o(118269);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vEg.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.vEf == null) {
                bVar = new b("Not all required fields were included: ChatRoomName");
                AppMethodBeat.o(118269);
                throw bVar;
            }
            AppMethodBeat.o(118269);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            vh vhVar = (vh) objArr[1];
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
                        vhVar.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(118269);
                    return 0;
                case 2:
                    vhVar.vEf = aVar3.BTU.readString();
                    AppMethodBeat.o(118269);
                    return 0;
                case 3:
                    vhVar.vEg.add(aVar3.BTU.readString());
                    AppMethodBeat.o(118269);
                    return 0;
                default:
                    AppMethodBeat.o(118269);
                    return -1;
            }
        } else {
            AppMethodBeat.o(118269);
            return -1;
        }
    }
}
