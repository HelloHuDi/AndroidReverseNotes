package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class cfb extends a {
    public String Id;
    public String jBB;
    public int pcX;
    public long timeStamp;
    public cea xeA;
    public String xeB;
    public int xeC;
    public int xeD;
    public cei xez;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56547);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.Id != null) {
                aVar.e(1, this.Id);
            }
            if (this.jBB != null) {
                aVar.e(2, this.jBB);
            }
            aVar.iz(3, this.pcX);
            if (this.xez != null) {
                aVar.iy(4, this.xez.computeSize());
                this.xez.writeFields(aVar);
            }
            if (this.xeA != null) {
                aVar.iy(5, this.xeA.computeSize());
                this.xeA.writeFields(aVar);
            }
            aVar.ai(6, this.timeStamp);
            if (this.xeB != null) {
                aVar.e(7, this.xeB);
            }
            aVar.iz(8, this.xeC);
            aVar.iz(9, this.xeD);
            AppMethodBeat.o(56547);
            return 0;
        } else if (i == 1) {
            if (this.Id != null) {
                f = e.a.a.b.b.a.f(1, this.Id) + 0;
            } else {
                f = 0;
            }
            if (this.jBB != null) {
                f += e.a.a.b.b.a.f(2, this.jBB);
            }
            f += e.a.a.b.b.a.bs(3, this.pcX);
            if (this.xez != null) {
                f += e.a.a.a.ix(4, this.xez.computeSize());
            }
            if (this.xeA != null) {
                f += e.a.a.a.ix(5, this.xeA.computeSize());
            }
            f += e.a.a.b.b.a.o(6, this.timeStamp);
            if (this.xeB != null) {
                f += e.a.a.b.b.a.f(7, this.xeB);
            }
            int bs = (f + e.a.a.b.b.a.bs(8, this.xeC)) + e.a.a.b.b.a.bs(9, this.xeD);
            AppMethodBeat.o(56547);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56547);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cfb cfb = (cfb) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    cfb.Id = aVar3.BTU.readString();
                    AppMethodBeat.o(56547);
                    return 0;
                case 2:
                    cfb.jBB = aVar3.BTU.readString();
                    AppMethodBeat.o(56547);
                    return 0;
                case 3:
                    cfb.pcX = aVar3.BTU.vd();
                    AppMethodBeat.o(56547);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cei cei = new cei();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cei.populateBuilderWithField(aVar4, cei, a.getNextFieldNumber(aVar4))) {
                        }
                        cfb.xez = cei;
                    }
                    AppMethodBeat.o(56547);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cea cea = new cea();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cea.populateBuilderWithField(aVar4, cea, a.getNextFieldNumber(aVar4))) {
                        }
                        cfb.xeA = cea;
                    }
                    AppMethodBeat.o(56547);
                    return 0;
                case 6:
                    cfb.timeStamp = aVar3.BTU.ve();
                    AppMethodBeat.o(56547);
                    return 0;
                case 7:
                    cfb.xeB = aVar3.BTU.readString();
                    AppMethodBeat.o(56547);
                    return 0;
                case 8:
                    cfb.xeC = aVar3.BTU.vd();
                    AppMethodBeat.o(56547);
                    return 0;
                case 9:
                    cfb.xeD = aVar3.BTU.vd();
                    AppMethodBeat.o(56547);
                    return 0;
                default:
                    AppMethodBeat.o(56547);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56547);
            return -1;
        }
    }
}
