package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class kl extends a {
    public String content;
    public String kKw;
    public String kbV;
    public int vGr;
    public String vGs;
    public int vMO;
    public int vMP;
    public int vNl;
    public int vNm;
    public int vNn;
    public tq vNo;
    public int vNp;
    public int vNq;
    public int vNr = 0;
    public int vNs;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(14712);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.vNl);
            aVar.iz(2, this.vGr);
            if (this.vGs != null) {
                aVar.e(3, this.vGs);
            }
            if (this.kKw != null) {
                aVar.e(4, this.kKw);
            }
            if (this.kbV != null) {
                aVar.e(5, this.kbV);
            }
            if (this.content != null) {
                aVar.e(6, this.content);
            }
            aVar.iz(7, this.vNm);
            aVar.iz(8, this.vNn);
            aVar.iz(9, this.vMO);
            aVar.iz(10, this.vMP);
            if (this.vNo != null) {
                aVar.iy(11, this.vNo.computeSize());
                this.vNo.writeFields(aVar);
            }
            aVar.iz(12, this.vNp);
            aVar.iz(13, this.vNq);
            aVar.iz(14, this.vNr);
            aVar.iz(15, this.vNs);
            AppMethodBeat.o(14712);
            return 0;
        } else if (i == 1) {
            bs = (e.a.a.b.b.a.bs(1, this.vNl) + 0) + e.a.a.b.b.a.bs(2, this.vGr);
            if (this.vGs != null) {
                bs += e.a.a.b.b.a.f(3, this.vGs);
            }
            if (this.kKw != null) {
                bs += e.a.a.b.b.a.f(4, this.kKw);
            }
            if (this.kbV != null) {
                bs += e.a.a.b.b.a.f(5, this.kbV);
            }
            if (this.content != null) {
                bs += e.a.a.b.b.a.f(6, this.content);
            }
            bs = (((bs + e.a.a.b.b.a.bs(7, this.vNm)) + e.a.a.b.b.a.bs(8, this.vNn)) + e.a.a.b.b.a.bs(9, this.vMO)) + e.a.a.b.b.a.bs(10, this.vMP);
            if (this.vNo != null) {
                bs += e.a.a.a.ix(11, this.vNo.computeSize());
            }
            bs = (((bs + e.a.a.b.b.a.bs(12, this.vNp)) + e.a.a.b.b.a.bs(13, this.vNq)) + e.a.a.b.b.a.bs(14, this.vNr)) + e.a.a.b.b.a.bs(15, this.vNs);
            AppMethodBeat.o(14712);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(14712);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            kl klVar = (kl) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    klVar.vNl = aVar3.BTU.vd();
                    AppMethodBeat.o(14712);
                    return 0;
                case 2:
                    klVar.vGr = aVar3.BTU.vd();
                    AppMethodBeat.o(14712);
                    return 0;
                case 3:
                    klVar.vGs = aVar3.BTU.readString();
                    AppMethodBeat.o(14712);
                    return 0;
                case 4:
                    klVar.kKw = aVar3.BTU.readString();
                    AppMethodBeat.o(14712);
                    return 0;
                case 5:
                    klVar.kbV = aVar3.BTU.readString();
                    AppMethodBeat.o(14712);
                    return 0;
                case 6:
                    klVar.content = aVar3.BTU.readString();
                    AppMethodBeat.o(14712);
                    return 0;
                case 7:
                    klVar.vNm = aVar3.BTU.vd();
                    AppMethodBeat.o(14712);
                    return 0;
                case 8:
                    klVar.vNn = aVar3.BTU.vd();
                    AppMethodBeat.o(14712);
                    return 0;
                case 9:
                    klVar.vMO = aVar3.BTU.vd();
                    AppMethodBeat.o(14712);
                    return 0;
                case 10:
                    klVar.vMP = aVar3.BTU.vd();
                    AppMethodBeat.o(14712);
                    return 0;
                case 11:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        tq tqVar = new tq();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = tqVar.populateBuilderWithField(aVar4, tqVar, a.getNextFieldNumber(aVar4))) {
                        }
                        klVar.vNo = tqVar;
                    }
                    AppMethodBeat.o(14712);
                    return 0;
                case 12:
                    klVar.vNp = aVar3.BTU.vd();
                    AppMethodBeat.o(14712);
                    return 0;
                case 13:
                    klVar.vNq = aVar3.BTU.vd();
                    AppMethodBeat.o(14712);
                    return 0;
                case 14:
                    klVar.vNr = aVar3.BTU.vd();
                    AppMethodBeat.o(14712);
                    return 0;
                case 15:
                    klVar.vNs = aVar3.BTU.vd();
                    AppMethodBeat.o(14712);
                    return 0;
                default:
                    AppMethodBeat.o(14712);
                    return -1;
            }
        } else {
            AppMethodBeat.o(14712);
            return -1;
        }
    }
}
