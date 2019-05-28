package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class bdn extends a {
    public int type;
    public String vJS;
    public cgv wHp;
    public LinkedList<bto> wHq = new LinkedList();

    public bdn() {
        AppMethodBeat.i(48896);
        AppMethodBeat.o(48896);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(48897);
        int ix;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wHp != null) {
                aVar.iy(1, this.wHp.computeSize());
                this.wHp.writeFields(aVar);
            }
            aVar.e(2, 8, this.wHq);
            aVar.iz(3, this.type);
            if (this.vJS != null) {
                aVar.e(4, this.vJS);
            }
            AppMethodBeat.o(48897);
            return 0;
        } else if (i == 1) {
            if (this.wHp != null) {
                ix = e.a.a.a.ix(1, this.wHp.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (ix + e.a.a.a.c(2, 8, this.wHq)) + e.a.a.b.b.a.bs(3, this.type);
            if (this.vJS != null) {
                ix += e.a.a.b.b.a.f(4, this.vJS);
            }
            AppMethodBeat.o(48897);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wHq.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(48897);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bdn bdn = (bdn) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cgv cgv = new cgv();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cgv.populateBuilderWithField(aVar4, cgv, a.getNextFieldNumber(aVar4))) {
                        }
                        bdn.wHp = cgv;
                    }
                    AppMethodBeat.o(48897);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bto bto = new bto();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bto.populateBuilderWithField(aVar4, bto, a.getNextFieldNumber(aVar4))) {
                        }
                        bdn.wHq.add(bto);
                    }
                    AppMethodBeat.o(48897);
                    return 0;
                case 3:
                    bdn.type = aVar3.BTU.vd();
                    AppMethodBeat.o(48897);
                    return 0;
                case 4:
                    bdn.vJS = aVar3.BTU.readString();
                    AppMethodBeat.o(48897);
                    return 0;
                default:
                    AppMethodBeat.o(48897);
                    return -1;
            }
        } else {
            AppMethodBeat.o(48897);
            return -1;
        }
    }
}
