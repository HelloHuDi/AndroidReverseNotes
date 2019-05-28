package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class xc extends a {
    public String title;
    public int type;
    public btr vCP;
    public ta vQL;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(48839);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.type);
            if (this.title != null) {
                aVar.e(2, this.title);
            }
            if (this.vCP != null) {
                aVar.iy(3, this.vCP.computeSize());
                this.vCP.writeFields(aVar);
            }
            if (this.vQL != null) {
                aVar.iy(4, this.vQL.computeSize());
                this.vQL.writeFields(aVar);
            }
            AppMethodBeat.o(48839);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.type) + 0;
            if (this.title != null) {
                bs += e.a.a.b.b.a.f(2, this.title);
            }
            if (this.vCP != null) {
                bs += e.a.a.a.ix(3, this.vCP.computeSize());
            }
            if (this.vQL != null) {
                bs += e.a.a.a.ix(4, this.vQL.computeSize());
            }
            AppMethodBeat.o(48839);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(48839);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            xc xcVar = (xc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    xcVar.type = aVar3.BTU.vd();
                    AppMethodBeat.o(48839);
                    return 0;
                case 2:
                    xcVar.title = aVar3.BTU.readString();
                    AppMethodBeat.o(48839);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        btr btr = new btr();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = btr.populateBuilderWithField(aVar4, btr, a.getNextFieldNumber(aVar4))) {
                        }
                        xcVar.vCP = btr;
                    }
                    AppMethodBeat.o(48839);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ta taVar = new ta();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = taVar.populateBuilderWithField(aVar4, taVar, a.getNextFieldNumber(aVar4))) {
                        }
                        xcVar.vQL = taVar;
                    }
                    AppMethodBeat.o(48839);
                    return 0;
                default:
                    AppMethodBeat.o(48839);
                    return -1;
            }
        } else {
            AppMethodBeat.o(48839);
            return -1;
        }
    }
}
