package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class csu extends bsr {
    public int jCt;
    public int vOq;
    public String vQg;
    public int wCu;
    public int wCv = 2;
    public double wCw;
    public double wCx;
    public String wCy;
    public int wOI;
    public String wol;
    public String xqb;
    public String xqc;
    public String xqd;
    public int xqe;
    public String xqf;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(93809);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.wol != null) {
                aVar.e(2, this.wol);
            }
            aVar.iz(3, this.vOq);
            aVar.iz(4, this.wCu);
            if (this.vQg != null) {
                aVar.e(5, this.vQg);
            }
            aVar.iz(6, this.wCv);
            aVar.f(7, this.wCw);
            aVar.f(8, this.wCx);
            aVar.iz(9, this.jCt);
            aVar.iz(10, this.wOI);
            if (this.wCy != null) {
                aVar.e(99, this.wCy);
            }
            if (this.xqb != null) {
                aVar.e(100, this.xqb);
            }
            if (this.xqc != null) {
                aVar.e(101, this.xqc);
            }
            if (this.xqd != null) {
                aVar.e(102, this.xqd);
            }
            aVar.iz(103, this.xqe);
            if (this.xqf != null) {
                aVar.e(104, this.xqf);
            }
            AppMethodBeat.o(93809);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wol != null) {
                ix += e.a.a.b.b.a.f(2, this.wol);
            }
            ix = (ix + e.a.a.b.b.a.bs(3, this.vOq)) + e.a.a.b.b.a.bs(4, this.wCu);
            if (this.vQg != null) {
                ix += e.a.a.b.b.a.f(5, this.vQg);
            }
            ix = ((((ix + e.a.a.b.b.a.bs(6, this.wCv)) + (e.a.a.b.b.a.fv(7) + 8)) + (e.a.a.b.b.a.fv(8) + 8)) + e.a.a.b.b.a.bs(9, this.jCt)) + e.a.a.b.b.a.bs(10, this.wOI);
            if (this.wCy != null) {
                ix += e.a.a.b.b.a.f(99, this.wCy);
            }
            if (this.xqb != null) {
                ix += e.a.a.b.b.a.f(100, this.xqb);
            }
            if (this.xqc != null) {
                ix += e.a.a.b.b.a.f(101, this.xqc);
            }
            if (this.xqd != null) {
                ix += e.a.a.b.b.a.f(102, this.xqd);
            }
            ix += e.a.a.b.b.a.bs(103, this.xqe);
            if (this.xqf != null) {
                ix += e.a.a.b.b.a.f(104, this.xqf);
            }
            AppMethodBeat.o(93809);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(93809);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            csu csu = (csu) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        hl hlVar = new hl();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = hlVar.populateBuilderWithField(aVar4, hlVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        csu.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(93809);
                    return 0;
                case 2:
                    csu.wol = aVar3.BTU.readString();
                    AppMethodBeat.o(93809);
                    return 0;
                case 3:
                    csu.vOq = aVar3.BTU.vd();
                    AppMethodBeat.o(93809);
                    return 0;
                case 4:
                    csu.wCu = aVar3.BTU.vd();
                    AppMethodBeat.o(93809);
                    return 0;
                case 5:
                    csu.vQg = aVar3.BTU.readString();
                    AppMethodBeat.o(93809);
                    return 0;
                case 6:
                    csu.wCv = aVar3.BTU.vd();
                    AppMethodBeat.o(93809);
                    return 0;
                case 7:
                    csu.wCw = Double.longBitsToDouble(aVar3.BTU.eib());
                    AppMethodBeat.o(93809);
                    return 0;
                case 8:
                    csu.wCx = Double.longBitsToDouble(aVar3.BTU.eib());
                    AppMethodBeat.o(93809);
                    return 0;
                case 9:
                    csu.jCt = aVar3.BTU.vd();
                    AppMethodBeat.o(93809);
                    return 0;
                case 10:
                    csu.wOI = aVar3.BTU.vd();
                    AppMethodBeat.o(93809);
                    return 0;
                case 99:
                    csu.wCy = aVar3.BTU.readString();
                    AppMethodBeat.o(93809);
                    return 0;
                case 100:
                    csu.xqb = aVar3.BTU.readString();
                    AppMethodBeat.o(93809);
                    return 0;
                case 101:
                    csu.xqc = aVar3.BTU.readString();
                    AppMethodBeat.o(93809);
                    return 0;
                case 102:
                    csu.xqd = aVar3.BTU.readString();
                    AppMethodBeat.o(93809);
                    return 0;
                case 103:
                    csu.xqe = aVar3.BTU.vd();
                    AppMethodBeat.o(93809);
                    return 0;
                case 104:
                    csu.xqf = aVar3.BTU.readString();
                    AppMethodBeat.o(93809);
                    return 0;
                default:
                    AppMethodBeat.o(93809);
                    return -1;
            }
        } else {
            AppMethodBeat.o(93809);
            return -1;
        }
    }
}
