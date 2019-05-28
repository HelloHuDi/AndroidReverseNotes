package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class acf extends bsr {
    public String pdB;
    public String vLs;
    public String wdB;
    public String wjV;
    public String wjW;
    public String wjX;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56796);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.wjV != null) {
                aVar.e(2, this.wjV);
            }
            if (this.vLs != null) {
                aVar.e(3, this.vLs);
            }
            if (this.pdB != null) {
                aVar.e(4, this.pdB);
            }
            if (this.wjW != null) {
                aVar.e(5, this.wjW);
            }
            if (this.wjX != null) {
                aVar.e(6, this.wjX);
            }
            if (this.wdB != null) {
                aVar.e(7, this.wdB);
            }
            AppMethodBeat.o(56796);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wjV != null) {
                ix += e.a.a.b.b.a.f(2, this.wjV);
            }
            if (this.vLs != null) {
                ix += e.a.a.b.b.a.f(3, this.vLs);
            }
            if (this.pdB != null) {
                ix += e.a.a.b.b.a.f(4, this.pdB);
            }
            if (this.wjW != null) {
                ix += e.a.a.b.b.a.f(5, this.wjW);
            }
            if (this.wjX != null) {
                ix += e.a.a.b.b.a.f(6, this.wjX);
            }
            if (this.wdB != null) {
                ix += e.a.a.b.b.a.f(7, this.wdB);
            }
            AppMethodBeat.o(56796);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56796);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            acf acf = (acf) objArr[1];
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
                        acf.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(56796);
                    return 0;
                case 2:
                    acf.wjV = aVar3.BTU.readString();
                    AppMethodBeat.o(56796);
                    return 0;
                case 3:
                    acf.vLs = aVar3.BTU.readString();
                    AppMethodBeat.o(56796);
                    return 0;
                case 4:
                    acf.pdB = aVar3.BTU.readString();
                    AppMethodBeat.o(56796);
                    return 0;
                case 5:
                    acf.wjW = aVar3.BTU.readString();
                    AppMethodBeat.o(56796);
                    return 0;
                case 6:
                    acf.wjX = aVar3.BTU.readString();
                    AppMethodBeat.o(56796);
                    return 0;
                case 7:
                    acf.wdB = aVar3.BTU.readString();
                    AppMethodBeat.o(56796);
                    return 0;
                default:
                    AppMethodBeat.o(56796);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56796);
            return -1;
        }
    }
}
