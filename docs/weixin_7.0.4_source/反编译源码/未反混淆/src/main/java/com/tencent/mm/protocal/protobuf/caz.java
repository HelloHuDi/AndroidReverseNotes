package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class caz extends a {
    public long endTime = -1;
    public String feedId;
    public int height = -1;
    public int iev = -1;
    public int lqq = 0;
    public boolean pCS = false;
    public int qDY = -1;
    public int rBZ = 0;
    public long startTime = -1;
    public int xae = 0;
    public int xaf = -1;
    public LinkedList<aby> xag = new LinkedList();
    public long xah = 0;
    public double xai = 0.0d;
    public double xaj = 0.0d;
    public int y = -1;

    public caz() {
        AppMethodBeat.i(73655);
        AppMethodBeat.o(73655);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(73656);
        int f;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.feedId != null) {
                aVar.e(1, this.feedId);
            }
            aVar.iz(2, this.y);
            aVar.iz(3, this.height);
            aVar.iz(4, this.iev);
            aVar.iz(5, this.xae);
            aVar.iz(6, this.qDY);
            aVar.iz(7, this.xaf);
            aVar.iz(8, this.lqq);
            aVar.iz(9, this.rBZ);
            aVar.aO(10, this.pCS);
            aVar.ai(11, this.startTime);
            aVar.ai(12, this.endTime);
            aVar.e(13, 8, this.xag);
            aVar.ai(14, this.xah);
            aVar.f(15, this.xai);
            aVar.f(16, this.xaj);
            AppMethodBeat.o(73656);
            return 0;
        } else if (i == 1) {
            if (this.feedId != null) {
                f = e.a.a.b.b.a.f(1, this.feedId) + 0;
            } else {
                f = 0;
            }
            int bs = ((((((((((((((f + e.a.a.b.b.a.bs(2, this.y)) + e.a.a.b.b.a.bs(3, this.height)) + e.a.a.b.b.a.bs(4, this.iev)) + e.a.a.b.b.a.bs(5, this.xae)) + e.a.a.b.b.a.bs(6, this.qDY)) + e.a.a.b.b.a.bs(7, this.xaf)) + e.a.a.b.b.a.bs(8, this.lqq)) + e.a.a.b.b.a.bs(9, this.rBZ)) + (e.a.a.b.b.a.fv(10) + 1)) + e.a.a.b.b.a.o(11, this.startTime)) + e.a.a.b.b.a.o(12, this.endTime)) + e.a.a.a.c(13, 8, this.xag)) + e.a.a.b.b.a.o(14, this.xah)) + (e.a.a.b.b.a.fv(15) + 8)) + (e.a.a.b.b.a.fv(16) + 8);
            AppMethodBeat.o(73656);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xag.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(73656);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            caz caz = (caz) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    caz.feedId = aVar3.BTU.readString();
                    AppMethodBeat.o(73656);
                    return 0;
                case 2:
                    caz.y = aVar3.BTU.vd();
                    AppMethodBeat.o(73656);
                    return 0;
                case 3:
                    caz.height = aVar3.BTU.vd();
                    AppMethodBeat.o(73656);
                    return 0;
                case 4:
                    caz.iev = aVar3.BTU.vd();
                    AppMethodBeat.o(73656);
                    return 0;
                case 5:
                    caz.xae = aVar3.BTU.vd();
                    AppMethodBeat.o(73656);
                    return 0;
                case 6:
                    caz.qDY = aVar3.BTU.vd();
                    AppMethodBeat.o(73656);
                    return 0;
                case 7:
                    caz.xaf = aVar3.BTU.vd();
                    AppMethodBeat.o(73656);
                    return 0;
                case 8:
                    caz.lqq = aVar3.BTU.vd();
                    AppMethodBeat.o(73656);
                    return 0;
                case 9:
                    caz.rBZ = aVar3.BTU.vd();
                    AppMethodBeat.o(73656);
                    return 0;
                case 10:
                    caz.pCS = aVar3.BTU.ehX();
                    AppMethodBeat.o(73656);
                    return 0;
                case 11:
                    caz.startTime = aVar3.BTU.ve();
                    AppMethodBeat.o(73656);
                    return 0;
                case 12:
                    caz.endTime = aVar3.BTU.ve();
                    AppMethodBeat.o(73656);
                    return 0;
                case 13:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        aby aby = new aby();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = aby.populateBuilderWithField(aVar4, aby, a.getNextFieldNumber(aVar4))) {
                        }
                        caz.xag.add(aby);
                    }
                    AppMethodBeat.o(73656);
                    return 0;
                case 14:
                    caz.xah = aVar3.BTU.ve();
                    AppMethodBeat.o(73656);
                    return 0;
                case 15:
                    caz.xai = Double.longBitsToDouble(aVar3.BTU.eib());
                    AppMethodBeat.o(73656);
                    return 0;
                case 16:
                    caz.xaj = Double.longBitsToDouble(aVar3.BTU.eib());
                    AppMethodBeat.o(73656);
                    return 0;
                default:
                    AppMethodBeat.o(73656);
                    return -1;
            }
        } else {
            AppMethodBeat.o(73656);
            return -1;
        }
    }
}
