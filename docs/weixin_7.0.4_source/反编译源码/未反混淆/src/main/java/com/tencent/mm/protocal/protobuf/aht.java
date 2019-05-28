package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class aht extends bsr {
    public LinkedList<bts> vEg = new LinkedList();
    public int wnW;
    public int wnX;
    public LinkedList<bts> wnY = new LinkedList();
    public int wnZ;
    public LinkedList<bts> woa = new LinkedList();
    public int wob;
    public bts woc;

    public aht() {
        AppMethodBeat.i(28428);
        AppMethodBeat.o(28428);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(28429);
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.iz(2, this.wnW);
            aVar.e(3, 8, this.vEg);
            aVar.iz(4, this.wnX);
            aVar.e(5, 8, this.wnY);
            aVar.iz(6, this.wnZ);
            aVar.e(7, 8, this.woa);
            aVar.iz(8, this.wob);
            if (this.woc != null) {
                aVar.iy(9, this.woc.computeSize());
                this.woc.writeFields(aVar);
            }
            AppMethodBeat.o(28429);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = ((((((ix + e.a.a.b.b.a.bs(2, this.wnW)) + e.a.a.a.c(3, 8, this.vEg)) + e.a.a.b.b.a.bs(4, this.wnX)) + e.a.a.a.c(5, 8, this.wnY)) + e.a.a.b.b.a.bs(6, this.wnZ)) + e.a.a.a.c(7, 8, this.woa)) + e.a.a.b.b.a.bs(8, this.wob);
            if (this.woc != null) {
                ix += e.a.a.a.ix(9, this.woc.computeSize());
            }
            AppMethodBeat.o(28429);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vEg.clear();
            this.wnY.clear();
            this.woa.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(28429);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aht aht = (aht) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            e.a.a.a.a aVar4;
            boolean z;
            bts bts;
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
                        aht.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(28429);
                    return 0;
                case 2:
                    aht.wnW = aVar3.BTU.vd();
                    AppMethodBeat.o(28429);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        aht.vEg.add(bts);
                    }
                    AppMethodBeat.o(28429);
                    return 0;
                case 4:
                    aht.wnX = aVar3.BTU.vd();
                    AppMethodBeat.o(28429);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        aht.wnY.add(bts);
                    }
                    AppMethodBeat.o(28429);
                    return 0;
                case 6:
                    aht.wnZ = aVar3.BTU.vd();
                    AppMethodBeat.o(28429);
                    return 0;
                case 7:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        aht.woa.add(bts);
                    }
                    AppMethodBeat.o(28429);
                    return 0;
                case 8:
                    aht.wob = aVar3.BTU.vd();
                    AppMethodBeat.o(28429);
                    return 0;
                case 9:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        aht.woc = bts;
                    }
                    AppMethodBeat.o(28429);
                    return 0;
                default:
                    AppMethodBeat.o(28429);
                    return -1;
            }
        } else {
            AppMethodBeat.o(28429);
            return -1;
        }
    }
}
