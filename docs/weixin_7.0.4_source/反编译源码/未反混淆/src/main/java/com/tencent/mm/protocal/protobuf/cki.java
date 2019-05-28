package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class cki extends bsr {
    public String username;
    public int xin;
    public yr xio;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(114995);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.username != null) {
                aVar.e(2, this.username);
            }
            aVar.iz(3, this.xin);
            if (this.xio != null) {
                aVar.iy(4, this.xio.computeSize());
                this.xio.writeFields(aVar);
            }
            AppMethodBeat.o(114995);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.username != null) {
                ix += e.a.a.b.b.a.f(2, this.username);
            }
            ix += e.a.a.b.b.a.bs(3, this.xin);
            if (this.xio != null) {
                ix += e.a.a.a.ix(4, this.xio.computeSize());
            }
            AppMethodBeat.o(114995);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(114995);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cki cki = (cki) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
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
                        cki.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(114995);
                    return 0;
                case 2:
                    cki.username = aVar3.BTU.readString();
                    AppMethodBeat.o(114995);
                    return 0;
                case 3:
                    cki.xin = aVar3.BTU.vd();
                    AppMethodBeat.o(114995);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        yr yrVar = new yr();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = yrVar.populateBuilderWithField(aVar4, yrVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cki.xio = yrVar;
                    }
                    AppMethodBeat.o(114995);
                    return 0;
                default:
                    AppMethodBeat.o(114995);
                    return -1;
            }
        } else {
            AppMethodBeat.o(114995);
            return -1;
        }
    }
}
