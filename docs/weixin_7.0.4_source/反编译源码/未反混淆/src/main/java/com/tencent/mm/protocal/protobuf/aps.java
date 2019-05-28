package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class aps extends bsr {
    public String fha;
    public String lCH;
    public boolean wtL;
    public String wtM;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28481);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.lCH == null) {
                bVar = new b("Not all required fields were included: appusername");
                AppMethodBeat.o(28481);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.aO(2, this.wtL);
            if (this.fha != null) {
                aVar.e(3, this.fha);
            }
            if (this.lCH != null) {
                aVar.e(4, this.lCH);
            }
            if (this.wtM != null) {
                aVar.e(5, this.wtM);
            }
            AppMethodBeat.o(28481);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += e.a.a.b.b.a.fv(2) + 1;
            if (this.fha != null) {
                ix += e.a.a.b.b.a.f(3, this.fha);
            }
            if (this.lCH != null) {
                ix += e.a.a.b.b.a.f(4, this.lCH);
            }
            if (this.wtM != null) {
                ix += e.a.a.b.b.a.f(5, this.wtM);
            }
            AppMethodBeat.o(28481);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.lCH == null) {
                bVar = new b("Not all required fields were included: appusername");
                AppMethodBeat.o(28481);
                throw bVar;
            }
            AppMethodBeat.o(28481);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aps aps = (aps) objArr[1];
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
                        aps.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(28481);
                    return 0;
                case 2:
                    aps.wtL = aVar3.BTU.ehX();
                    AppMethodBeat.o(28481);
                    return 0;
                case 3:
                    aps.fha = aVar3.BTU.readString();
                    AppMethodBeat.o(28481);
                    return 0;
                case 4:
                    aps.lCH = aVar3.BTU.readString();
                    AppMethodBeat.o(28481);
                    return 0;
                case 5:
                    aps.wtM = aVar3.BTU.readString();
                    AppMethodBeat.o(28481);
                    return 0;
                default:
                    AppMethodBeat.o(28481);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28481);
            return -1;
        }
    }
}
