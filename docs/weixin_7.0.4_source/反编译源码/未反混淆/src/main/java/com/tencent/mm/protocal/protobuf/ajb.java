package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ajb extends bsr {
    public String vBa;
    public String woV;
    public String woW;
    public mk woX;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(59563);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.woV == null) {
                bVar = new b("Not all required fields were included: FunctionMsgID");
                AppMethodBeat.o(59563);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.woV != null) {
                aVar.e(2, this.woV);
            }
            if (this.woW != null) {
                aVar.e(3, this.woW);
            }
            if (this.vBa != null) {
                aVar.e(4, this.vBa);
            }
            if (this.woX != null) {
                aVar.iy(5, this.woX.computeSize());
                this.woX.writeFields(aVar);
            }
            AppMethodBeat.o(59563);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.woV != null) {
                ix += e.a.a.b.b.a.f(2, this.woV);
            }
            if (this.woW != null) {
                ix += e.a.a.b.b.a.f(3, this.woW);
            }
            if (this.vBa != null) {
                ix += e.a.a.b.b.a.f(4, this.vBa);
            }
            if (this.woX != null) {
                ix += e.a.a.a.ix(5, this.woX.computeSize());
            }
            AppMethodBeat.o(59563);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.woV == null) {
                bVar = new b("Not all required fields were included: FunctionMsgID");
                AppMethodBeat.o(59563);
                throw bVar;
            }
            AppMethodBeat.o(59563);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ajb ajb = (ajb) objArr[1];
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
                        ajb.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(59563);
                    return 0;
                case 2:
                    ajb.woV = aVar3.BTU.readString();
                    AppMethodBeat.o(59563);
                    return 0;
                case 3:
                    ajb.woW = aVar3.BTU.readString();
                    AppMethodBeat.o(59563);
                    return 0;
                case 4:
                    ajb.vBa = aVar3.BTU.readString();
                    AppMethodBeat.o(59563);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        mk mkVar = new mk();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = mkVar.populateBuilderWithField(aVar4, mkVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        ajb.woX = mkVar;
                    }
                    AppMethodBeat.o(59563);
                    return 0;
                default:
                    AppMethodBeat.o(59563);
                    return -1;
            }
        } else {
            AppMethodBeat.o(59563);
            return -1;
        }
    }
}
