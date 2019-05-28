package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public class bqd extends a {
    public String iAa;
    public String iAb;
    public String iAc;
    public int iAd;
    public String iAe;
    public String izZ;
    public String kLg;
    public double score;
    public int wSp;
    public String wSq;
    public String wSr;
    public String wSs;
    public String wSt;
    public String wSu;
    public ars wSv;
    public String wSw;
    public String wSx;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(134439);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.iAd);
            aVar.iz(2, this.wSp);
            if (this.wSq != null) {
                aVar.e(3, this.wSq);
            }
            if (this.iAb != null) {
                aVar.e(4, this.iAb);
            }
            if (this.iAc != null) {
                aVar.e(5, this.iAc);
            }
            if (this.wSr != null) {
                aVar.e(6, this.wSr);
            }
            if (this.kLg != null) {
                aVar.e(7, this.kLg);
            }
            if (this.wSs != null) {
                aVar.e(8, this.wSs);
            }
            if (this.wSt != null) {
                aVar.e(9, this.wSt);
            }
            aVar.f(10, this.score);
            if (this.wSu != null) {
                aVar.e(11, this.wSu);
            }
            if (this.izZ != null) {
                aVar.e(12, this.izZ);
            }
            if (this.wSv != null) {
                aVar.iy(14, this.wSv.computeSize());
                this.wSv.writeFields(aVar);
            }
            if (this.iAa != null) {
                aVar.e(15, this.iAa);
            }
            if (this.wSw != null) {
                aVar.e(16, this.wSw);
            }
            if (this.wSx != null) {
                aVar.e(17, this.wSx);
            }
            if (this.iAe != null) {
                aVar.e(18, this.iAe);
            }
            AppMethodBeat.o(134439);
            return 0;
        } else if (i == 1) {
            bs = (e.a.a.b.b.a.bs(1, this.iAd) + 0) + e.a.a.b.b.a.bs(2, this.wSp);
            if (this.wSq != null) {
                bs += e.a.a.b.b.a.f(3, this.wSq);
            }
            if (this.iAb != null) {
                bs += e.a.a.b.b.a.f(4, this.iAb);
            }
            if (this.iAc != null) {
                bs += e.a.a.b.b.a.f(5, this.iAc);
            }
            if (this.wSr != null) {
                bs += e.a.a.b.b.a.f(6, this.wSr);
            }
            if (this.kLg != null) {
                bs += e.a.a.b.b.a.f(7, this.kLg);
            }
            if (this.wSs != null) {
                bs += e.a.a.b.b.a.f(8, this.wSs);
            }
            if (this.wSt != null) {
                bs += e.a.a.b.b.a.f(9, this.wSt);
            }
            bs += e.a.a.b.b.a.fv(10) + 8;
            if (this.wSu != null) {
                bs += e.a.a.b.b.a.f(11, this.wSu);
            }
            if (this.izZ != null) {
                bs += e.a.a.b.b.a.f(12, this.izZ);
            }
            if (this.wSv != null) {
                bs += e.a.a.a.ix(14, this.wSv.computeSize());
            }
            if (this.iAa != null) {
                bs += e.a.a.b.b.a.f(15, this.iAa);
            }
            if (this.wSw != null) {
                bs += e.a.a.b.b.a.f(16, this.wSw);
            }
            if (this.wSx != null) {
                bs += e.a.a.b.b.a.f(17, this.wSx);
            }
            if (this.iAe != null) {
                bs += e.a.a.b.b.a.f(18, this.iAe);
            }
            AppMethodBeat.o(134439);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(134439);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bqd bqd = (bqd) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bqd.iAd = aVar3.BTU.vd();
                    AppMethodBeat.o(134439);
                    return 0;
                case 2:
                    bqd.wSp = aVar3.BTU.vd();
                    AppMethodBeat.o(134439);
                    return 0;
                case 3:
                    bqd.wSq = aVar3.BTU.readString();
                    AppMethodBeat.o(134439);
                    return 0;
                case 4:
                    bqd.iAb = aVar3.BTU.readString();
                    AppMethodBeat.o(134439);
                    return 0;
                case 5:
                    bqd.iAc = aVar3.BTU.readString();
                    AppMethodBeat.o(134439);
                    return 0;
                case 6:
                    bqd.wSr = aVar3.BTU.readString();
                    AppMethodBeat.o(134439);
                    return 0;
                case 7:
                    bqd.kLg = aVar3.BTU.readString();
                    AppMethodBeat.o(134439);
                    return 0;
                case 8:
                    bqd.wSs = aVar3.BTU.readString();
                    AppMethodBeat.o(134439);
                    return 0;
                case 9:
                    bqd.wSt = aVar3.BTU.readString();
                    AppMethodBeat.o(134439);
                    return 0;
                case 10:
                    bqd.score = Double.longBitsToDouble(aVar3.BTU.eib());
                    AppMethodBeat.o(134439);
                    return 0;
                case 11:
                    bqd.wSu = aVar3.BTU.readString();
                    AppMethodBeat.o(134439);
                    return 0;
                case 12:
                    bqd.izZ = aVar3.BTU.readString();
                    AppMethodBeat.o(134439);
                    return 0;
                case 14:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        ars ars = new ars();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = ars.populateBuilderWithField(aVar4, ars, a.getNextFieldNumber(aVar4))) {
                        }
                        bqd.wSv = ars;
                    }
                    AppMethodBeat.o(134439);
                    return 0;
                case 15:
                    bqd.iAa = aVar3.BTU.readString();
                    AppMethodBeat.o(134439);
                    return 0;
                case 16:
                    bqd.wSw = aVar3.BTU.readString();
                    AppMethodBeat.o(134439);
                    return 0;
                case 17:
                    bqd.wSx = aVar3.BTU.readString();
                    AppMethodBeat.o(134439);
                    return 0;
                case 18:
                    bqd.iAe = aVar3.BTU.readString();
                    AppMethodBeat.o(134439);
                    return 0;
                default:
                    AppMethodBeat.o(134439);
                    return -1;
            }
        } else {
            AppMethodBeat.o(134439);
            return -1;
        }
    }
}
