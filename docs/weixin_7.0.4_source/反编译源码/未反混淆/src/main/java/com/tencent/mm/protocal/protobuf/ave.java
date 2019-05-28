package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class ave extends a {
    public String vJS;
    public cgv wza;
    public LinkedList<cgd> wzb = new LinkedList();
    public cgv wzc;

    public ave() {
        AppMethodBeat.i(48879);
        AppMethodBeat.o(48879);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(48880);
        int ix;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wza != null) {
                aVar.iy(1, this.wza.computeSize());
                this.wza.writeFields(aVar);
            }
            aVar.e(2, 8, this.wzb);
            if (this.wzc != null) {
                aVar.iy(3, this.wzc.computeSize());
                this.wzc.writeFields(aVar);
            }
            if (this.vJS != null) {
                aVar.e(4, this.vJS);
            }
            AppMethodBeat.o(48880);
            return 0;
        } else if (i == 1) {
            if (this.wza != null) {
                ix = e.a.a.a.ix(1, this.wza.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += e.a.a.a.c(2, 8, this.wzb);
            if (this.wzc != null) {
                ix += e.a.a.a.ix(3, this.wzc.computeSize());
            }
            if (this.vJS != null) {
                ix += e.a.a.b.b.a.f(4, this.vJS);
            }
            AppMethodBeat.o(48880);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wzb.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(48880);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ave ave = (ave) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            cgv cgv;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cgv = new cgv();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cgv.populateBuilderWithField(aVar4, cgv, a.getNextFieldNumber(aVar4))) {
                        }
                        ave.wza = cgv;
                    }
                    AppMethodBeat.o(48880);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cgd cgd = new cgd();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cgd.populateBuilderWithField(aVar4, cgd, a.getNextFieldNumber(aVar4))) {
                        }
                        ave.wzb.add(cgd);
                    }
                    AppMethodBeat.o(48880);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cgv = new cgv();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cgv.populateBuilderWithField(aVar4, cgv, a.getNextFieldNumber(aVar4))) {
                        }
                        ave.wzc = cgv;
                    }
                    AppMethodBeat.o(48880);
                    return 0;
                case 4:
                    ave.vJS = aVar3.BTU.readString();
                    AppMethodBeat.o(48880);
                    return 0;
                default:
                    AppMethodBeat.o(48880);
                    return -1;
            }
        } else {
            AppMethodBeat.o(48880);
            return -1;
        }
    }
}
