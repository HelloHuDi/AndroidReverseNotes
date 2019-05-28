package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class btr extends a {
    public int type;
    public String url;
    public chf wVC;
    public xb wVD;
    public int wVE;
    public boolean wVF;
    public ux wVG;
    public ba wVH;
    public LinkedList<xc> wct = new LinkedList();

    public btr() {
        AppMethodBeat.i(48961);
        AppMethodBeat.o(48961);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(48962);
        int bs;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.type);
            if (this.url != null) {
                aVar.e(2, this.url);
            }
            if (this.wVC != null) {
                aVar.iy(3, this.wVC.computeSize());
                this.wVC.writeFields(aVar);
            }
            if (this.wVD != null) {
                aVar.iy(4, this.wVD.computeSize());
                this.wVD.writeFields(aVar);
            }
            aVar.iz(5, this.wVE);
            aVar.aO(6, this.wVF);
            aVar.e(7, 8, this.wct);
            if (this.wVG != null) {
                aVar.iy(8, this.wVG.computeSize());
                this.wVG.writeFields(aVar);
            }
            if (this.wVH != null) {
                aVar.iy(9, this.wVH.computeSize());
                this.wVH.writeFields(aVar);
            }
            AppMethodBeat.o(48962);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.type) + 0;
            if (this.url != null) {
                bs += e.a.a.b.b.a.f(2, this.url);
            }
            if (this.wVC != null) {
                bs += e.a.a.a.ix(3, this.wVC.computeSize());
            }
            if (this.wVD != null) {
                bs += e.a.a.a.ix(4, this.wVD.computeSize());
            }
            bs = ((bs + e.a.a.b.b.a.bs(5, this.wVE)) + (e.a.a.b.b.a.fv(6) + 1)) + e.a.a.a.c(7, 8, this.wct);
            if (this.wVG != null) {
                bs += e.a.a.a.ix(8, this.wVG.computeSize());
            }
            if (this.wVH != null) {
                bs += e.a.a.a.ix(9, this.wVH.computeSize());
            }
            AppMethodBeat.o(48962);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wct.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(48962);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            btr btr = (btr) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    btr.type = aVar3.BTU.vd();
                    AppMethodBeat.o(48962);
                    return 0;
                case 2:
                    btr.url = aVar3.BTU.readString();
                    AppMethodBeat.o(48962);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        chf chf = new chf();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = chf.populateBuilderWithField(aVar4, chf, a.getNextFieldNumber(aVar4))) {
                        }
                        btr.wVC = chf;
                    }
                    AppMethodBeat.o(48962);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        xb xbVar = new xb();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = xbVar.populateBuilderWithField(aVar4, xbVar, a.getNextFieldNumber(aVar4))) {
                        }
                        btr.wVD = xbVar;
                    }
                    AppMethodBeat.o(48962);
                    return 0;
                case 5:
                    btr.wVE = aVar3.BTU.vd();
                    AppMethodBeat.o(48962);
                    return 0;
                case 6:
                    btr.wVF = aVar3.BTU.ehX();
                    AppMethodBeat.o(48962);
                    return 0;
                case 7:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        xc xcVar = new xc();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = xcVar.populateBuilderWithField(aVar4, xcVar, a.getNextFieldNumber(aVar4))) {
                        }
                        btr.wct.add(xcVar);
                    }
                    AppMethodBeat.o(48962);
                    return 0;
                case 8:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ux uxVar = new ux();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = uxVar.populateBuilderWithField(aVar4, uxVar, a.getNextFieldNumber(aVar4))) {
                        }
                        btr.wVG = uxVar;
                    }
                    AppMethodBeat.o(48962);
                    return 0;
                case 9:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ba baVar = new ba();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = baVar.populateBuilderWithField(aVar4, baVar, a.getNextFieldNumber(aVar4))) {
                        }
                        btr.wVH = baVar;
                    }
                    AppMethodBeat.o(48962);
                    return 0;
                default:
                    AppMethodBeat.o(48962);
                    return -1;
            }
        } else {
            AppMethodBeat.o(48962);
            return -1;
        }
    }
}
