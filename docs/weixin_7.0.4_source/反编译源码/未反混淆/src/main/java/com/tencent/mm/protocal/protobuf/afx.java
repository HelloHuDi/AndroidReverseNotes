package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class afx extends bsr {
    public int Cn;
    public String data;
    public String wbO;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(11767);
        b bVar;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wbO == null) {
                bVar = new b("Not all required fields were included: corp_id");
                AppMethodBeat.o(11767);
                throw bVar;
            } else if (this.data == null) {
                bVar = new b("Not all required fields were included: data");
                AppMethodBeat.o(11767);
                throw bVar;
            } else {
                if (this.BaseRequest != null) {
                    aVar.iy(1, this.BaseRequest.computeSize());
                    this.BaseRequest.writeFields(aVar);
                }
                if (this.wbO != null) {
                    aVar.e(2, this.wbO);
                }
                aVar.iz(3, this.Cn);
                if (this.data != null) {
                    aVar.e(4, this.data);
                }
                AppMethodBeat.o(11767);
                return 0;
            }
        } else if (i == 1) {
            int ix;
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wbO != null) {
                ix += e.a.a.b.b.a.f(2, this.wbO);
            }
            ix += e.a.a.b.b.a.bs(3, this.Cn);
            if (this.data != null) {
                ix += e.a.a.b.b.a.f(4, this.data);
            }
            AppMethodBeat.o(11767);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (int nextFieldNumber = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.ems();
                }
            }
            if (this.wbO == null) {
                bVar = new b("Not all required fields were included: corp_id");
                AppMethodBeat.o(11767);
                throw bVar;
            } else if (bArr == null) {
                bVar = new b("Not all required fields were included: data");
                AppMethodBeat.o(11767);
                throw bVar;
            } else {
                AppMethodBeat.o(11767);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            afx afx = (afx) objArr[1];
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
                        afx.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(11767);
                    return 0;
                case 2:
                    afx.wbO = aVar3.BTU.readString();
                    AppMethodBeat.o(11767);
                    return 0;
                case 3:
                    afx.Cn = aVar3.BTU.vd();
                    AppMethodBeat.o(11767);
                    return 0;
                case 4:
                    afx.data = aVar3.BTU.readString();
                    AppMethodBeat.o(11767);
                    return 0;
                default:
                    AppMethodBeat.o(11767);
                    return -1;
            }
        } else {
            AppMethodBeat.o(11767);
            return -1;
        }
    }
}
