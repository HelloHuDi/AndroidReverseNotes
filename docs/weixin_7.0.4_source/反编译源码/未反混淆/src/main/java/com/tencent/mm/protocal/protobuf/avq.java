package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class avq extends bsr {
    public String csB;
    public String cvO;
    public String signature;
    public String url;
    public String wzd;
    public String wzf;
    public String wzg;
    public b wzh;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(10207);
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
            if (this.csB != null) {
                aVar.e(3, this.csB);
            }
            if (this.wzd != null) {
                aVar.e(4, this.wzd);
            }
            if (this.cvO != null) {
                aVar.e(5, this.cvO);
            }
            if (this.wzf != null) {
                aVar.e(6, this.wzf);
            }
            if (this.signature != null) {
                aVar.e(7, this.signature);
            }
            if (this.wzg != null) {
                aVar.e(8, this.wzg);
            }
            if (this.wzh != null) {
                aVar.c(9, this.wzh);
            }
            AppMethodBeat.o(10207);
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
            if (this.csB != null) {
                ix += e.a.a.b.b.a.f(3, this.csB);
            }
            if (this.wzd != null) {
                ix += e.a.a.b.b.a.f(4, this.wzd);
            }
            if (this.cvO != null) {
                ix += e.a.a.b.b.a.f(5, this.cvO);
            }
            if (this.wzf != null) {
                ix += e.a.a.b.b.a.f(6, this.wzf);
            }
            if (this.signature != null) {
                ix += e.a.a.b.b.a.f(7, this.signature);
            }
            if (this.wzg != null) {
                ix += e.a.a.b.b.a.f(8, this.wzg);
            }
            if (this.wzh != null) {
                ix += e.a.a.b.b.a.b(9, this.wzh);
            }
            AppMethodBeat.o(10207);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(10207);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            avq avq = (avq) objArr[1];
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
                        avq.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(10207);
                    return 0;
                case 2:
                    avq.url = aVar3.BTU.readString();
                    AppMethodBeat.o(10207);
                    return 0;
                case 3:
                    avq.csB = aVar3.BTU.readString();
                    AppMethodBeat.o(10207);
                    return 0;
                case 4:
                    avq.wzd = aVar3.BTU.readString();
                    AppMethodBeat.o(10207);
                    return 0;
                case 5:
                    avq.cvO = aVar3.BTU.readString();
                    AppMethodBeat.o(10207);
                    return 0;
                case 6:
                    avq.wzf = aVar3.BTU.readString();
                    AppMethodBeat.o(10207);
                    return 0;
                case 7:
                    avq.signature = aVar3.BTU.readString();
                    AppMethodBeat.o(10207);
                    return 0;
                case 8:
                    avq.wzg = aVar3.BTU.readString();
                    AppMethodBeat.o(10207);
                    return 0;
                case 9:
                    avq.wzh = aVar3.BTU.emu();
                    AppMethodBeat.o(10207);
                    return 0;
                default:
                    AppMethodBeat.o(10207);
                    return -1;
            }
        } else {
            AppMethodBeat.o(10207);
            return -1;
        }
    }
}
