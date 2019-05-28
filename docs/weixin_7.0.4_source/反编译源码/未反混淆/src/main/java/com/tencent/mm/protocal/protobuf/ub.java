package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ub extends bsr {
    public String fKh;
    public String vIk;
    public String wbq;
    public String wbr;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28368);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wbq == null) {
                bVar = new b("Not all required fields were included: DeviceId");
                AppMethodBeat.o(28368);
                throw bVar;
            } else if (this.vIk == null) {
                bVar = new b("Not all required fields were included: DeviceType");
                AppMethodBeat.o(28368);
                throw bVar;
            } else if (this.wbr == null) {
                bVar = new b("Not all required fields were included: ClientInfo");
                AppMethodBeat.o(28368);
                throw bVar;
            } else if (this.fKh == null) {
                bVar = new b("Not all required fields were included: AppId");
                AppMethodBeat.o(28368);
                throw bVar;
            } else {
                if (this.BaseRequest != null) {
                    aVar.iy(1, this.BaseRequest.computeSize());
                    this.BaseRequest.writeFields(aVar);
                }
                if (this.wbq != null) {
                    aVar.e(2, this.wbq);
                }
                if (this.vIk != null) {
                    aVar.e(3, this.vIk);
                }
                if (this.wbr != null) {
                    aVar.e(4, this.wbr);
                }
                if (this.fKh != null) {
                    aVar.e(5, this.fKh);
                }
                AppMethodBeat.o(28368);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wbq != null) {
                ix += e.a.a.b.b.a.f(2, this.wbq);
            }
            if (this.vIk != null) {
                ix += e.a.a.b.b.a.f(3, this.vIk);
            }
            if (this.wbr != null) {
                ix += e.a.a.b.b.a.f(4, this.wbr);
            }
            if (this.fKh != null) {
                ix += e.a.a.b.b.a.f(5, this.fKh);
            }
            AppMethodBeat.o(28368);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.wbq == null) {
                bVar = new b("Not all required fields were included: DeviceId");
                AppMethodBeat.o(28368);
                throw bVar;
            } else if (this.vIk == null) {
                bVar = new b("Not all required fields were included: DeviceType");
                AppMethodBeat.o(28368);
                throw bVar;
            } else if (this.wbr == null) {
                bVar = new b("Not all required fields were included: ClientInfo");
                AppMethodBeat.o(28368);
                throw bVar;
            } else if (this.fKh == null) {
                bVar = new b("Not all required fields were included: AppId");
                AppMethodBeat.o(28368);
                throw bVar;
            } else {
                AppMethodBeat.o(28368);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ub ubVar = (ub) objArr[1];
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
                        ubVar.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(28368);
                    return 0;
                case 2:
                    ubVar.wbq = aVar3.BTU.readString();
                    AppMethodBeat.o(28368);
                    return 0;
                case 3:
                    ubVar.vIk = aVar3.BTU.readString();
                    AppMethodBeat.o(28368);
                    return 0;
                case 4:
                    ubVar.wbr = aVar3.BTU.readString();
                    AppMethodBeat.o(28368);
                    return 0;
                case 5:
                    ubVar.fKh = aVar3.BTU.readString();
                    AppMethodBeat.o(28368);
                    return 0;
                default:
                    AppMethodBeat.o(28368);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28368);
            return -1;
        }
    }
}
