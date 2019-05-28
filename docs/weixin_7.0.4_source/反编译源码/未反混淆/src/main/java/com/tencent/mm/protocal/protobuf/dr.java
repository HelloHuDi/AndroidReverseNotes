package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class dr extends a {
    public LinkedList<bha> ckO = new LinkedList();
    public LinkedList<bhb> vCr = new LinkedList();
    public int vFv;

    public dr() {
        AppMethodBeat.i(80016);
        AppMethodBeat.o(80016);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(80017);
        int bs;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.vFv);
            aVar.e(2, 8, this.vCr);
            aVar.e(3, 8, this.ckO);
            AppMethodBeat.o(80017);
            return 0;
        } else if (i == 1) {
            bs = ((e.a.a.b.b.a.bs(1, this.vFv) + 0) + e.a.a.a.c(2, 8, this.vCr)) + e.a.a.a.c(3, 8, this.ckO);
            AppMethodBeat.o(80017);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vCr.clear();
            this.ckO.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(80017);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            dr drVar = (dr) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    drVar.vFv = aVar3.BTU.vd();
                    AppMethodBeat.o(80017);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bhb bhb = new bhb();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhb.populateBuilderWithField(aVar4, bhb, a.getNextFieldNumber(aVar4))) {
                        }
                        drVar.vCr.add(bhb);
                    }
                    AppMethodBeat.o(80017);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bha bha = new bha();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bha.populateBuilderWithField(aVar4, bha, a.getNextFieldNumber(aVar4))) {
                        }
                        drVar.ckO.add(bha);
                    }
                    AppMethodBeat.o(80017);
                    return 0;
                default:
                    AppMethodBeat.o(80017);
                    return -1;
            }
        } else {
            AppMethodBeat.o(80017);
            return -1;
        }
    }
}
