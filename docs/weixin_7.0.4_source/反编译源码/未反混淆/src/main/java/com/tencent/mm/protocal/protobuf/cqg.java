package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class cqg extends bsr {
    public long xlQ;
    public cqf xmK;
    public cqf xok;
    public cqf xol;
    public cqf xom;
    public cqf xon;
    public int xoo;
    public LinkedList<bts> xop = new LinkedList();

    public cqg() {
        AppMethodBeat.i(5275);
        AppMethodBeat.o(5275);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(5276);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.xmK == null) {
                bVar = new b("Not all required fields were included: ReportData");
                AppMethodBeat.o(5276);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.xmK != null) {
                aVar.iy(2, this.xmK.computeSize());
                this.xmK.writeFields(aVar);
            }
            if (this.xok != null) {
                aVar.iy(3, this.xok.computeSize());
                this.xok.writeFields(aVar);
            }
            if (this.xol != null) {
                aVar.iy(4, this.xol.computeSize());
                this.xol.writeFields(aVar);
            }
            if (this.xom != null) {
                aVar.iy(5, this.xom.computeSize());
                this.xom.writeFields(aVar);
            }
            aVar.ai(6, this.xlQ);
            if (this.xon != null) {
                aVar.iy(7, this.xon.computeSize());
                this.xon.writeFields(aVar);
            }
            aVar.iz(8, this.xoo);
            aVar.e(9, 8, this.xop);
            AppMethodBeat.o(5276);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.xmK != null) {
                ix += e.a.a.a.ix(2, this.xmK.computeSize());
            }
            if (this.xok != null) {
                ix += e.a.a.a.ix(3, this.xok.computeSize());
            }
            if (this.xol != null) {
                ix += e.a.a.a.ix(4, this.xol.computeSize());
            }
            if (this.xom != null) {
                ix += e.a.a.a.ix(5, this.xom.computeSize());
            }
            ix += e.a.a.b.b.a.o(6, this.xlQ);
            if (this.xon != null) {
                ix += e.a.a.a.ix(7, this.xon.computeSize());
            }
            int bs = (ix + e.a.a.b.b.a.bs(8, this.xoo)) + e.a.a.a.c(9, 8, this.xop);
            AppMethodBeat.o(5276);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xop.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.xmK == null) {
                bVar = new b("Not all required fields were included: ReportData");
                AppMethodBeat.o(5276);
                throw bVar;
            }
            AppMethodBeat.o(5276);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cqg cqg = (cqg) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            e.a.a.a.a aVar4;
            boolean z;
            cqf cqf;
            switch (intValue) {
                case 1:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        hl hlVar = new hl();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = hlVar.populateBuilderWithField(aVar4, hlVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cqg.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(5276);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cqf = new cqf();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cqf.populateBuilderWithField(aVar4, cqf, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cqg.xmK = cqf;
                    }
                    AppMethodBeat.o(5276);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cqf = new cqf();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cqf.populateBuilderWithField(aVar4, cqf, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cqg.xok = cqf;
                    }
                    AppMethodBeat.o(5276);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cqf = new cqf();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cqf.populateBuilderWithField(aVar4, cqf, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cqg.xol = cqf;
                    }
                    AppMethodBeat.o(5276);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cqf = new cqf();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cqf.populateBuilderWithField(aVar4, cqf, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cqg.xom = cqf;
                    }
                    AppMethodBeat.o(5276);
                    return 0;
                case 6:
                    cqg.xlQ = aVar3.BTU.ve();
                    AppMethodBeat.o(5276);
                    return 0;
                case 7:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cqf = new cqf();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cqf.populateBuilderWithField(aVar4, cqf, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cqg.xon = cqf;
                    }
                    AppMethodBeat.o(5276);
                    return 0;
                case 8:
                    cqg.xoo = aVar3.BTU.vd();
                    AppMethodBeat.o(5276);
                    return 0;
                case 9:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        cqg.xop.add(bts);
                    }
                    AppMethodBeat.o(5276);
                    return 0;
                default:
                    AppMethodBeat.o(5276);
                    return -1;
            }
        } else {
            AppMethodBeat.o(5276);
            return -1;
        }
    }
}
