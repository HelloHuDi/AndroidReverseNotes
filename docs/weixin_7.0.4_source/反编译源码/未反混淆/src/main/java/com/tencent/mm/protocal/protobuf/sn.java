package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class sn extends bsr {
    public int scene;
    public String vEG;
    public String vMR;
    public int vZW;
    public String vZX;
    public LinkedList<sm> vZY = new LinkedList();
    public int vZZ;
    public bxk waa;
    public byj wab;

    public sn() {
        AppMethodBeat.i(11737);
        AppMethodBeat.o(11737);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(11738);
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.iz(2, this.vZW);
            if (this.vZX != null) {
                aVar.e(3, this.vZX);
            }
            if (this.vMR != null) {
                aVar.e(4, this.vMR);
            }
            if (this.vEG != null) {
                aVar.e(5, this.vEG);
            }
            aVar.e(6, 8, this.vZY);
            aVar.iz(7, this.scene);
            aVar.iz(8, this.vZZ);
            if (this.waa != null) {
                aVar.iy(9, this.waa.computeSize());
                this.waa.writeFields(aVar);
            }
            if (this.wab != null) {
                aVar.iy(10, this.wab.computeSize());
                this.wab.writeFields(aVar);
            }
            AppMethodBeat.o(11738);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += e.a.a.b.b.a.bs(2, this.vZW);
            if (this.vZX != null) {
                ix += e.a.a.b.b.a.f(3, this.vZX);
            }
            if (this.vMR != null) {
                ix += e.a.a.b.b.a.f(4, this.vMR);
            }
            if (this.vEG != null) {
                ix += e.a.a.b.b.a.f(5, this.vEG);
            }
            ix = ((ix + e.a.a.a.c(6, 8, this.vZY)) + e.a.a.b.b.a.bs(7, this.scene)) + e.a.a.b.b.a.bs(8, this.vZZ);
            if (this.waa != null) {
                ix += e.a.a.a.ix(9, this.waa.computeSize());
            }
            if (this.wab != null) {
                ix += e.a.a.a.ix(10, this.wab.computeSize());
            }
            AppMethodBeat.o(11738);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vZY.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(11738);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            sn snVar = (sn) objArr[1];
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
                        snVar.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(11738);
                    return 0;
                case 2:
                    snVar.vZW = aVar3.BTU.vd();
                    AppMethodBeat.o(11738);
                    return 0;
                case 3:
                    snVar.vZX = aVar3.BTU.readString();
                    AppMethodBeat.o(11738);
                    return 0;
                case 4:
                    snVar.vMR = aVar3.BTU.readString();
                    AppMethodBeat.o(11738);
                    return 0;
                case 5:
                    snVar.vEG = aVar3.BTU.readString();
                    AppMethodBeat.o(11738);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        sm smVar = new sm();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = smVar.populateBuilderWithField(aVar4, smVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        snVar.vZY.add(smVar);
                    }
                    AppMethodBeat.o(11738);
                    return 0;
                case 7:
                    snVar.scene = aVar3.BTU.vd();
                    AppMethodBeat.o(11738);
                    return 0;
                case 8:
                    snVar.vZZ = aVar3.BTU.vd();
                    AppMethodBeat.o(11738);
                    return 0;
                case 9:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bxk bxk = new bxk();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bxk.populateBuilderWithField(aVar4, bxk, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        snVar.waa = bxk;
                    }
                    AppMethodBeat.o(11738);
                    return 0;
                case 10:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        byj byj = new byj();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = byj.populateBuilderWithField(aVar4, byj, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        snVar.wab = byj;
                    }
                    AppMethodBeat.o(11738);
                    return 0;
                default:
                    AppMethodBeat.o(11738);
                    return -1;
            }
        } else {
            AppMethodBeat.o(11738);
            return -1;
        }
    }
}
