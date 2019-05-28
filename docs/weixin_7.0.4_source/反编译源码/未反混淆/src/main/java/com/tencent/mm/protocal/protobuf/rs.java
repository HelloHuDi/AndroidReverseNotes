package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class rs extends bsr {
    public int jCt;
    public String vYZ;
    public LinkedList<bzd> vZa = new LinkedList();
    public LinkedList<bzf> vZb = new LinkedList();
    public LinkedList<bzc> vZc = new LinkedList();
    public LinkedList<bzb> vZd = new LinkedList();
    public LinkedList<bze> vZe = new LinkedList();

    public rs() {
        AppMethodBeat.i(28359);
        AppMethodBeat.o(28359);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28360);
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.iz(2, this.jCt);
            if (this.vYZ != null) {
                aVar.e(3, this.vYZ);
            }
            aVar.e(4, 8, this.vZa);
            aVar.e(5, 8, this.vZb);
            aVar.e(6, 8, this.vZc);
            aVar.e(7, 8, this.vZd);
            aVar.e(8, 8, this.vZe);
            AppMethodBeat.o(28360);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += e.a.a.b.b.a.bs(2, this.jCt);
            if (this.vYZ != null) {
                ix += e.a.a.b.b.a.f(3, this.vYZ);
            }
            int c = ((((ix + e.a.a.a.c(4, 8, this.vZa)) + e.a.a.a.c(5, 8, this.vZb)) + e.a.a.a.c(6, 8, this.vZc)) + e.a.a.a.c(7, 8, this.vZd)) + e.a.a.a.c(8, 8, this.vZe);
            AppMethodBeat.o(28360);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vZa.clear();
            this.vZb.clear();
            this.vZc.clear();
            this.vZd.clear();
            this.vZe.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(28360);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            rs rsVar = (rs) objArr[1];
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
                        hl hlVar = new hl();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = hlVar.populateBuilderWithField(aVar4, hlVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        rsVar.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(28360);
                    return 0;
                case 2:
                    rsVar.jCt = aVar3.BTU.vd();
                    AppMethodBeat.o(28360);
                    return 0;
                case 3:
                    rsVar.vYZ = aVar3.BTU.readString();
                    AppMethodBeat.o(28360);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bzd bzd = new bzd();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bzd.populateBuilderWithField(aVar4, bzd, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        rsVar.vZa.add(bzd);
                    }
                    AppMethodBeat.o(28360);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bzf bzf = new bzf();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bzf.populateBuilderWithField(aVar4, bzf, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        rsVar.vZb.add(bzf);
                    }
                    AppMethodBeat.o(28360);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bzc bzc = new bzc();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bzc.populateBuilderWithField(aVar4, bzc, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        rsVar.vZc.add(bzc);
                    }
                    AppMethodBeat.o(28360);
                    return 0;
                case 7:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bzb bzb = new bzb();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bzb.populateBuilderWithField(aVar4, bzb, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        rsVar.vZd.add(bzb);
                    }
                    AppMethodBeat.o(28360);
                    return 0;
                case 8:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bze bze = new bze();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bze.populateBuilderWithField(aVar4, bze, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        rsVar.vZe.add(bze);
                    }
                    AppMethodBeat.o(28360);
                    return 0;
                default:
                    AppMethodBeat.o(28360);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28360);
            return -1;
        }
    }
}
