package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class bqc extends a {
    public int type;
    public big wSn;
    public dn wSo;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(134438);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.type);
            if (this.wSn != null) {
                aVar.iy(2, this.wSn.computeSize());
                this.wSn.writeFields(aVar);
            }
            if (this.wSo != null) {
                aVar.iy(3, this.wSo.computeSize());
                this.wSo.writeFields(aVar);
            }
            AppMethodBeat.o(134438);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.type) + 0;
            if (this.wSn != null) {
                bs += e.a.a.a.ix(2, this.wSn.computeSize());
            }
            if (this.wSo != null) {
                bs += e.a.a.a.ix(3, this.wSo.computeSize());
            }
            AppMethodBeat.o(134438);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(134438);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bqc bqc = (bqc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    bqc.type = aVar3.BTU.vd();
                    AppMethodBeat.o(134438);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        big big = new big();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = big.populateBuilderWithField(aVar4, big, a.getNextFieldNumber(aVar4))) {
                        }
                        bqc.wSn = big;
                    }
                    AppMethodBeat.o(134438);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        dn dnVar = new dn();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = dnVar.populateBuilderWithField(aVar4, dnVar, a.getNextFieldNumber(aVar4))) {
                        }
                        bqc.wSo = dnVar;
                    }
                    AppMethodBeat.o(134438);
                    return 0;
                default:
                    AppMethodBeat.o(134438);
                    return -1;
            }
        } else {
            AppMethodBeat.o(134438);
            return -1;
        }
    }
}
