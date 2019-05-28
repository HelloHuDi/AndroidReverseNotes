package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class aup extends bsr {
    public String wbO;
    public String wyL;
    public LinkedList<String> wyM = new LinkedList();

    public aup() {
        AppMethodBeat.i(11774);
        AppMethodBeat.o(11774);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(11775);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wbO == null) {
                bVar = new b("Not all required fields were included: corp_id");
                AppMethodBeat.o(11775);
                throw bVar;
            } else if (this.wyL == null) {
                bVar = new b("Not all required fields were included: bizchat_name");
                AppMethodBeat.o(11775);
                throw bVar;
            } else {
                if (this.BaseRequest != null) {
                    aVar.iy(1, this.BaseRequest.computeSize());
                    this.BaseRequest.writeFields(aVar);
                }
                if (this.wbO != null) {
                    aVar.e(2, this.wbO);
                }
                if (this.wyL != null) {
                    aVar.e(3, this.wyL);
                }
                aVar.e(4, 1, this.wyM);
                AppMethodBeat.o(11775);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wbO != null) {
                ix += e.a.a.b.b.a.f(2, this.wbO);
            }
            if (this.wyL != null) {
                ix += e.a.a.b.b.a.f(3, this.wyL);
            }
            int c = ix + e.a.a.a.c(4, 1, this.wyM);
            AppMethodBeat.o(11775);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wyM.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.wbO == null) {
                bVar = new b("Not all required fields were included: corp_id");
                AppMethodBeat.o(11775);
                throw bVar;
            } else if (this.wyL == null) {
                bVar = new b("Not all required fields were included: bizchat_name");
                AppMethodBeat.o(11775);
                throw bVar;
            } else {
                AppMethodBeat.o(11775);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aup aup = (aup) objArr[1];
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
                        aup.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(11775);
                    return 0;
                case 2:
                    aup.wbO = aVar3.BTU.readString();
                    AppMethodBeat.o(11775);
                    return 0;
                case 3:
                    aup.wyL = aVar3.BTU.readString();
                    AppMethodBeat.o(11775);
                    return 0;
                case 4:
                    aup.wyM.add(aVar3.BTU.readString());
                    AppMethodBeat.o(11775);
                    return 0;
                default:
                    AppMethodBeat.o(11775);
                    return -1;
            }
        } else {
            AppMethodBeat.o(11775);
            return -1;
        }
    }
}
