package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class arb extends bsr {
    public String csB;
    public int type;
    public int vOP;
    public String wsY;
    public int wtb;
    public String wuL;
    public int wuM;
    public bie wuN;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(96234);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.iz(2, this.type);
            if (this.csB != null) {
                aVar.e(3, this.csB);
            }
            aVar.iz(4, this.vOP);
            if (this.wuL != null) {
                aVar.e(5, this.wuL);
            }
            aVar.iz(6, this.wtb);
            aVar.iz(7, this.wuM);
            if (this.wsY != null) {
                aVar.e(8, this.wsY);
            }
            if (this.wuN != null) {
                aVar.iy(10, this.wuN.computeSize());
                this.wuN.writeFields(aVar);
            }
            AppMethodBeat.o(96234);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += e.a.a.b.b.a.bs(2, this.type);
            if (this.csB != null) {
                ix += e.a.a.b.b.a.f(3, this.csB);
            }
            ix += e.a.a.b.b.a.bs(4, this.vOP);
            if (this.wuL != null) {
                ix += e.a.a.b.b.a.f(5, this.wuL);
            }
            ix = (ix + e.a.a.b.b.a.bs(6, this.wtb)) + e.a.a.b.b.a.bs(7, this.wuM);
            if (this.wsY != null) {
                ix += e.a.a.b.b.a.f(8, this.wsY);
            }
            if (this.wuN != null) {
                ix += e.a.a.a.ix(10, this.wuN.computeSize());
            }
            AppMethodBeat.o(96234);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(96234);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            arb arb = (arb) objArr[1];
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
                        arb.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(96234);
                    return 0;
                case 2:
                    arb.type = aVar3.BTU.vd();
                    AppMethodBeat.o(96234);
                    return 0;
                case 3:
                    arb.csB = aVar3.BTU.readString();
                    AppMethodBeat.o(96234);
                    return 0;
                case 4:
                    arb.vOP = aVar3.BTU.vd();
                    AppMethodBeat.o(96234);
                    return 0;
                case 5:
                    arb.wuL = aVar3.BTU.readString();
                    AppMethodBeat.o(96234);
                    return 0;
                case 6:
                    arb.wtb = aVar3.BTU.vd();
                    AppMethodBeat.o(96234);
                    return 0;
                case 7:
                    arb.wuM = aVar3.BTU.vd();
                    AppMethodBeat.o(96234);
                    return 0;
                case 8:
                    arb.wsY = aVar3.BTU.readString();
                    AppMethodBeat.o(96234);
                    return 0;
                case 10:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bie bie = new bie();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bie.populateBuilderWithField(aVar4, bie, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        arb.wuN = bie;
                    }
                    AppMethodBeat.o(96234);
                    return 0;
                default:
                    AppMethodBeat.o(96234);
                    return -1;
            }
        } else {
            AppMethodBeat.o(96234);
            return -1;
        }
    }
}
