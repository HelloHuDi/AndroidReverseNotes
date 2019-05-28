package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class cji extends a {
    public String desc;
    public String title;
    public LinkedList<cjg> vBz = new LinkedList();
    public int wRi;
    public String xhW;
    public String xhX;
    public ayi xhY;
    public int xhZ;
    public cjh xia;
    public cjh xib;

    public cji() {
        AppMethodBeat.i(48979);
        AppMethodBeat.o(48979);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(48980);
        int f;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.e(1, this.title);
            }
            if (this.desc != null) {
                aVar.e(2, this.desc);
            }
            if (this.xhW != null) {
                aVar.e(3, this.xhW);
            }
            if (this.xhX != null) {
                aVar.e(4, this.xhX);
            }
            if (this.xhY != null) {
                aVar.iy(5, this.xhY.computeSize());
                this.xhY.writeFields(aVar);
            }
            aVar.e(6, 8, this.vBz);
            aVar.iz(7, this.wRi);
            aVar.iz(8, this.xhZ);
            if (this.xia != null) {
                aVar.iy(9, this.xia.computeSize());
                this.xia.writeFields(aVar);
            }
            if (this.xib != null) {
                aVar.iy(10, this.xib.computeSize());
                this.xib.writeFields(aVar);
            }
            AppMethodBeat.o(48980);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                f = e.a.a.b.b.a.f(1, this.title) + 0;
            } else {
                f = 0;
            }
            if (this.desc != null) {
                f += e.a.a.b.b.a.f(2, this.desc);
            }
            if (this.xhW != null) {
                f += e.a.a.b.b.a.f(3, this.xhW);
            }
            if (this.xhX != null) {
                f += e.a.a.b.b.a.f(4, this.xhX);
            }
            if (this.xhY != null) {
                f += e.a.a.a.ix(5, this.xhY.computeSize());
            }
            f = ((f + e.a.a.a.c(6, 8, this.vBz)) + e.a.a.b.b.a.bs(7, this.wRi)) + e.a.a.b.b.a.bs(8, this.xhZ);
            if (this.xia != null) {
                f += e.a.a.a.ix(9, this.xia.computeSize());
            }
            if (this.xib != null) {
                f += e.a.a.a.ix(10, this.xib.computeSize());
            }
            AppMethodBeat.o(48980);
            return f;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vBz.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(48980);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cji cji = (cji) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            e.a.a.a.a aVar4;
            boolean z;
            cjh cjh;
            switch (intValue) {
                case 1:
                    cji.title = aVar3.BTU.readString();
                    AppMethodBeat.o(48980);
                    return 0;
                case 2:
                    cji.desc = aVar3.BTU.readString();
                    AppMethodBeat.o(48980);
                    return 0;
                case 3:
                    cji.xhW = aVar3.BTU.readString();
                    AppMethodBeat.o(48980);
                    return 0;
                case 4:
                    cji.xhX = aVar3.BTU.readString();
                    AppMethodBeat.o(48980);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ayi ayi = new ayi();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ayi.populateBuilderWithField(aVar4, ayi, a.getNextFieldNumber(aVar4))) {
                        }
                        cji.xhY = ayi;
                    }
                    AppMethodBeat.o(48980);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cjg cjg = new cjg();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cjg.populateBuilderWithField(aVar4, cjg, a.getNextFieldNumber(aVar4))) {
                        }
                        cji.vBz.add(cjg);
                    }
                    AppMethodBeat.o(48980);
                    return 0;
                case 7:
                    cji.wRi = aVar3.BTU.vd();
                    AppMethodBeat.o(48980);
                    return 0;
                case 8:
                    cji.xhZ = aVar3.BTU.vd();
                    AppMethodBeat.o(48980);
                    return 0;
                case 9:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cjh = new cjh();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cjh.populateBuilderWithField(aVar4, cjh, a.getNextFieldNumber(aVar4))) {
                        }
                        cji.xia = cjh;
                    }
                    AppMethodBeat.o(48980);
                    return 0;
                case 10:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cjh = new cjh();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cjh.populateBuilderWithField(aVar4, cjh, a.getNextFieldNumber(aVar4))) {
                        }
                        cji.xib = cjh;
                    }
                    AppMethodBeat.o(48980);
                    return 0;
                default:
                    AppMethodBeat.o(48980);
                    return -1;
            }
        } else {
            AppMethodBeat.o(48980);
            return -1;
        }
    }
}
