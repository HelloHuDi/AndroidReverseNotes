package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class bjj extends a {
    public String fFZ;
    public String pQe;
    public String pcl;
    public int wMI;
    public String wMJ;
    public int wMK;
    public String wML;
    public int wMM;
    public String wMN;
    public long wMO;
    public LinkedList<bja> wMP = new LinkedList();
    public String wyq;

    public bjj() {
        AppMethodBeat.i(56898);
        AppMethodBeat.o(56898);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56899);
        int bs;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.wMI);
            if (this.wMJ != null) {
                aVar.e(2, this.wMJ);
            }
            if (this.wyq != null) {
                aVar.e(3, this.wyq);
            }
            aVar.iz(4, this.wMK);
            if (this.pcl != null) {
                aVar.e(5, this.pcl);
            }
            if (this.wML != null) {
                aVar.e(6, this.wML);
            }
            if (this.pQe != null) {
                aVar.e(7, this.pQe);
            }
            aVar.iz(8, this.wMM);
            if (this.fFZ != null) {
                aVar.e(9, this.fFZ);
            }
            if (this.wMN != null) {
                aVar.e(10, this.wMN);
            }
            aVar.ai(11, this.wMO);
            aVar.e(12, 8, this.wMP);
            AppMethodBeat.o(56899);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.wMI) + 0;
            if (this.wMJ != null) {
                bs += e.a.a.b.b.a.f(2, this.wMJ);
            }
            if (this.wyq != null) {
                bs += e.a.a.b.b.a.f(3, this.wyq);
            }
            bs += e.a.a.b.b.a.bs(4, this.wMK);
            if (this.pcl != null) {
                bs += e.a.a.b.b.a.f(5, this.pcl);
            }
            if (this.wML != null) {
                bs += e.a.a.b.b.a.f(6, this.wML);
            }
            if (this.pQe != null) {
                bs += e.a.a.b.b.a.f(7, this.pQe);
            }
            bs += e.a.a.b.b.a.bs(8, this.wMM);
            if (this.fFZ != null) {
                bs += e.a.a.b.b.a.f(9, this.fFZ);
            }
            if (this.wMN != null) {
                bs += e.a.a.b.b.a.f(10, this.wMN);
            }
            bs = (bs + e.a.a.b.b.a.o(11, this.wMO)) + e.a.a.a.c(12, 8, this.wMP);
            AppMethodBeat.o(56899);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wMP.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56899);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bjj bjj = (bjj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bjj.wMI = aVar3.BTU.vd();
                    AppMethodBeat.o(56899);
                    return 0;
                case 2:
                    bjj.wMJ = aVar3.BTU.readString();
                    AppMethodBeat.o(56899);
                    return 0;
                case 3:
                    bjj.wyq = aVar3.BTU.readString();
                    AppMethodBeat.o(56899);
                    return 0;
                case 4:
                    bjj.wMK = aVar3.BTU.vd();
                    AppMethodBeat.o(56899);
                    return 0;
                case 5:
                    bjj.pcl = aVar3.BTU.readString();
                    AppMethodBeat.o(56899);
                    return 0;
                case 6:
                    bjj.wML = aVar3.BTU.readString();
                    AppMethodBeat.o(56899);
                    return 0;
                case 7:
                    bjj.pQe = aVar3.BTU.readString();
                    AppMethodBeat.o(56899);
                    return 0;
                case 8:
                    bjj.wMM = aVar3.BTU.vd();
                    AppMethodBeat.o(56899);
                    return 0;
                case 9:
                    bjj.fFZ = aVar3.BTU.readString();
                    AppMethodBeat.o(56899);
                    return 0;
                case 10:
                    bjj.wMN = aVar3.BTU.readString();
                    AppMethodBeat.o(56899);
                    return 0;
                case 11:
                    bjj.wMO = aVar3.BTU.ve();
                    AppMethodBeat.o(56899);
                    return 0;
                case 12:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bja bja = new bja();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bja.populateBuilderWithField(aVar4, bja, a.getNextFieldNumber(aVar4))) {
                        }
                        bjj.wMP.add(bja);
                    }
                    AppMethodBeat.o(56899);
                    return 0;
                default:
                    AppMethodBeat.o(56899);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56899);
            return -1;
        }
    }
}
