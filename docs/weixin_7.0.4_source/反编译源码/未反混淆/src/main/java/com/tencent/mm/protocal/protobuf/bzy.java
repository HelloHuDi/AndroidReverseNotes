package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class bzy extends a {
    public int type;
    public String vJS;
    public cgv wHp;
    public bto wYU;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(48963);
        int ix;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wHp != null) {
                aVar.iy(1, this.wHp.computeSize());
                this.wHp.writeFields(aVar);
            }
            if (this.wYU != null) {
                aVar.iy(2, this.wYU.computeSize());
                this.wYU.writeFields(aVar);
            }
            aVar.iz(3, this.type);
            if (this.vJS != null) {
                aVar.e(4, this.vJS);
            }
            AppMethodBeat.o(48963);
            return 0;
        } else if (i == 1) {
            if (this.wHp != null) {
                ix = e.a.a.a.ix(1, this.wHp.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wYU != null) {
                ix += e.a.a.a.ix(2, this.wYU.computeSize());
            }
            ix += e.a.a.b.b.a.bs(3, this.type);
            if (this.vJS != null) {
                ix += e.a.a.b.b.a.f(4, this.vJS);
            }
            AppMethodBeat.o(48963);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(48963);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bzy bzy = (bzy) objArr[1];
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
                        cgv cgv = new cgv();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cgv.populateBuilderWithField(aVar4, cgv, a.getNextFieldNumber(aVar4))) {
                        }
                        bzy.wHp = cgv;
                    }
                    AppMethodBeat.o(48963);
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
                        bzy.wYU = bto;
                    }
                    AppMethodBeat.o(48963);
                    return 0;
                case 3:
                    bzy.type = aVar3.BTU.vd();
                    AppMethodBeat.o(48963);
                    return 0;
                case 4:
                    bzy.vJS = aVar3.BTU.readString();
                    AppMethodBeat.o(48963);
                    return 0;
                default:
                    AppMethodBeat.o(48963);
                    return -1;
            }
        } else {
            AppMethodBeat.o(48963);
            return -1;
        }
    }
}
