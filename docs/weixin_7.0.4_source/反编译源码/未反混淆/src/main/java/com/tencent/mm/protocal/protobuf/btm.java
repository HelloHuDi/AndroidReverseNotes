package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class btm extends a {
    public int type;
    public bki wVu;
    public cnr wVv;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(134446);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.type);
            if (this.wVu != null) {
                aVar.iy(2, this.wVu.computeSize());
                this.wVu.writeFields(aVar);
            }
            if (this.wVv != null) {
                aVar.iy(3, this.wVv.computeSize());
                this.wVv.writeFields(aVar);
            }
            AppMethodBeat.o(134446);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.type) + 0;
            if (this.wVu != null) {
                bs += e.a.a.a.ix(2, this.wVu.computeSize());
            }
            if (this.wVv != null) {
                bs += e.a.a.a.ix(3, this.wVv.computeSize());
            }
            AppMethodBeat.o(134446);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(134446);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            btm btm = (btm) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    btm.type = aVar3.BTU.vd();
                    AppMethodBeat.o(134446);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bki bki = new bki();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bki.populateBuilderWithField(aVar4, bki, a.getNextFieldNumber(aVar4))) {
                        }
                        btm.wVu = bki;
                    }
                    AppMethodBeat.o(134446);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cnr cnr = new cnr();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cnr.populateBuilderWithField(aVar4, cnr, a.getNextFieldNumber(aVar4))) {
                        }
                        btm.wVv = cnr;
                    }
                    AppMethodBeat.o(134446);
                    return 0;
                default:
                    AppMethodBeat.o(134446);
                    return -1;
            }
        } else {
            AppMethodBeat.o(134446);
            return -1;
        }
    }
}
