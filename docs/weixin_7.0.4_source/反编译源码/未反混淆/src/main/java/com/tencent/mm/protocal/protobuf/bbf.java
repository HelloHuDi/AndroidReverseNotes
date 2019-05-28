package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bbf extends btd {
    public int Ret;
    public int jCt;
    public int pcX;
    public int ptD;
    public long ptF;
    public bts vEC;
    public int vHX;
    public int wFW;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(60045);
        b bVar;
        int bs;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.vEC == null) {
                bVar = new b("Not all required fields were included: ToUserName");
                AppMethodBeat.o(60045);
                throw bVar;
            }
            aVar.iz(1, this.Ret);
            if (this.vEC != null) {
                aVar.iy(2, this.vEC.computeSize());
                this.vEC.writeFields(aVar);
            }
            aVar.iz(3, this.ptD);
            aVar.iz(4, this.wFW);
            aVar.iz(5, this.pcX);
            aVar.iz(6, this.vHX);
            aVar.iz(7, this.jCt);
            aVar.ai(8, this.ptF);
            AppMethodBeat.o(60045);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.Ret) + 0;
            if (this.vEC != null) {
                bs += e.a.a.a.ix(2, this.vEC.computeSize());
            }
            bs = (((((bs + e.a.a.b.b.a.bs(3, this.ptD)) + e.a.a.b.b.a.bs(4, this.wFW)) + e.a.a.b.b.a.bs(5, this.pcX)) + e.a.a.b.b.a.bs(6, this.vHX)) + e.a.a.b.b.a.bs(7, this.jCt)) + e.a.a.b.b.a.o(8, this.ptF);
            AppMethodBeat.o(60045);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); bs > 0; bs = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            if (this.vEC == null) {
                bVar = new b("Not all required fields were included: ToUserName");
                AppMethodBeat.o(60045);
                throw bVar;
            }
            AppMethodBeat.o(60045);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bbf bbf = (bbf) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bbf.Ret = aVar3.BTU.vd();
                    AppMethodBeat.o(60045);
                    return 0;
                case 2:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        bts bts = new bts();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bts.populateBuilderWithField(aVar4, bts, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bbf.vEC = bts;
                    }
                    AppMethodBeat.o(60045);
                    return 0;
                case 3:
                    bbf.ptD = aVar3.BTU.vd();
                    AppMethodBeat.o(60045);
                    return 0;
                case 4:
                    bbf.wFW = aVar3.BTU.vd();
                    AppMethodBeat.o(60045);
                    return 0;
                case 5:
                    bbf.pcX = aVar3.BTU.vd();
                    AppMethodBeat.o(60045);
                    return 0;
                case 6:
                    bbf.vHX = aVar3.BTU.vd();
                    AppMethodBeat.o(60045);
                    return 0;
                case 7:
                    bbf.jCt = aVar3.BTU.vd();
                    AppMethodBeat.o(60045);
                    return 0;
                case 8:
                    bbf.ptF = aVar3.BTU.ve();
                    AppMethodBeat.o(60045);
                    return 0;
                default:
                    AppMethodBeat.o(60045);
                    return -1;
            }
        } else {
            AppMethodBeat.o(60045);
            return -1;
        }
    }
}
