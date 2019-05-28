package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class axo extends bsr {
    public int cvd;
    public String query;
    public String wBx;
    public String wBy;
    public String wBz;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(114976);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.wBx != null) {
                aVar.e(2, this.wBx);
            }
            if (this.query != null) {
                aVar.e(3, this.query);
            }
            if (this.wBy != null) {
                aVar.e(4, this.wBy);
            }
            if (this.wBz != null) {
                aVar.e(5, this.wBz);
            }
            aVar.iz(6, this.cvd);
            AppMethodBeat.o(114976);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wBx != null) {
                ix += e.a.a.b.b.a.f(2, this.wBx);
            }
            if (this.query != null) {
                ix += e.a.a.b.b.a.f(3, this.query);
            }
            if (this.wBy != null) {
                ix += e.a.a.b.b.a.f(4, this.wBy);
            }
            if (this.wBz != null) {
                ix += e.a.a.b.b.a.f(5, this.wBz);
            }
            int bs = ix + e.a.a.b.b.a.bs(6, this.cvd);
            AppMethodBeat.o(114976);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(114976);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            axo axo = (axo) objArr[1];
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
                        axo.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(114976);
                    return 0;
                case 2:
                    axo.wBx = aVar3.BTU.readString();
                    AppMethodBeat.o(114976);
                    return 0;
                case 3:
                    axo.query = aVar3.BTU.readString();
                    AppMethodBeat.o(114976);
                    return 0;
                case 4:
                    axo.wBy = aVar3.BTU.readString();
                    AppMethodBeat.o(114976);
                    return 0;
                case 5:
                    axo.wBz = aVar3.BTU.readString();
                    AppMethodBeat.o(114976);
                    return 0;
                case 6:
                    axo.cvd = aVar3.BTU.vd();
                    AppMethodBeat.o(114976);
                    return 0;
                default:
                    AppMethodBeat.o(114976);
                    return -1;
            }
        } else {
            AppMethodBeat.o(114976);
            return -1;
        }
    }
}
