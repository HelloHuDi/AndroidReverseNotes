package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class bvk extends a {
    public String fKh;
    public int guN;
    public String jBB;
    public String jCH;
    public String vXm;
    public String vXn;
    public int wWh;
    public bgg wWy;
    public String wbs;
    public String wbt;
    public String wlF;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(80179);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.jBB != null) {
                aVar.e(1, this.jBB);
            }
            if (this.jCH != null) {
                aVar.e(2, this.jCH);
            }
            if (this.wbs != null) {
                aVar.e(3, this.wbs);
            }
            if (this.wbt != null) {
                aVar.e(4, this.wbt);
            }
            aVar.iz(5, this.guN);
            if (this.vXm != null) {
                aVar.e(6, this.vXm);
            }
            if (this.vXn != null) {
                aVar.e(7, this.vXn);
            }
            if (this.fKh != null) {
                aVar.e(8, this.fKh);
            }
            aVar.iz(9, this.wWh);
            if (this.wWy != null) {
                aVar.iy(10, this.wWy.computeSize());
                this.wWy.writeFields(aVar);
            }
            if (this.wlF != null) {
                aVar.e(11, this.wlF);
            }
            AppMethodBeat.o(80179);
            return 0;
        } else if (i == 1) {
            if (this.jBB != null) {
                f = e.a.a.b.b.a.f(1, this.jBB) + 0;
            } else {
                f = 0;
            }
            if (this.jCH != null) {
                f += e.a.a.b.b.a.f(2, this.jCH);
            }
            if (this.wbs != null) {
                f += e.a.a.b.b.a.f(3, this.wbs);
            }
            if (this.wbt != null) {
                f += e.a.a.b.b.a.f(4, this.wbt);
            }
            f += e.a.a.b.b.a.bs(5, this.guN);
            if (this.vXm != null) {
                f += e.a.a.b.b.a.f(6, this.vXm);
            }
            if (this.vXn != null) {
                f += e.a.a.b.b.a.f(7, this.vXn);
            }
            if (this.fKh != null) {
                f += e.a.a.b.b.a.f(8, this.fKh);
            }
            f += e.a.a.b.b.a.bs(9, this.wWh);
            if (this.wWy != null) {
                f += e.a.a.a.ix(10, this.wWy.computeSize());
            }
            if (this.wlF != null) {
                f += e.a.a.b.b.a.f(11, this.wlF);
            }
            AppMethodBeat.o(80179);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(80179);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bvk bvk = (bvk) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bvk.jBB = aVar3.BTU.readString();
                    AppMethodBeat.o(80179);
                    return 0;
                case 2:
                    bvk.jCH = aVar3.BTU.readString();
                    AppMethodBeat.o(80179);
                    return 0;
                case 3:
                    bvk.wbs = aVar3.BTU.readString();
                    AppMethodBeat.o(80179);
                    return 0;
                case 4:
                    bvk.wbt = aVar3.BTU.readString();
                    AppMethodBeat.o(80179);
                    return 0;
                case 5:
                    bvk.guN = aVar3.BTU.vd();
                    AppMethodBeat.o(80179);
                    return 0;
                case 6:
                    bvk.vXm = aVar3.BTU.readString();
                    AppMethodBeat.o(80179);
                    return 0;
                case 7:
                    bvk.vXn = aVar3.BTU.readString();
                    AppMethodBeat.o(80179);
                    return 0;
                case 8:
                    bvk.fKh = aVar3.BTU.readString();
                    AppMethodBeat.o(80179);
                    return 0;
                case 9:
                    bvk.wWh = aVar3.BTU.vd();
                    AppMethodBeat.o(80179);
                    return 0;
                case 10:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        bgg bgg = new bgg();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bgg.populateBuilderWithField(aVar4, bgg, a.getNextFieldNumber(aVar4))) {
                        }
                        bvk.wWy = bgg;
                    }
                    AppMethodBeat.o(80179);
                    return 0;
                case 11:
                    bvk.wlF = aVar3.BTU.readString();
                    AppMethodBeat.o(80179);
                    return 0;
                default:
                    AppMethodBeat.o(80179);
                    return -1;
            }
        } else {
            AppMethodBeat.o(80179);
            return -1;
        }
    }
}
