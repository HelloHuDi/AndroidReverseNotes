package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class xe extends a {
    public int wcX;
    public xf wcY;
    public int wcZ;
    public xf wda;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(60034);
        b bVar;
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wcY == null) {
                bVar = new b("Not all required fields were included: NightTime");
                AppMethodBeat.o(60034);
                throw bVar;
            } else if (this.wda == null) {
                bVar = new b("Not all required fields were included: AllDayTime");
                AppMethodBeat.o(60034);
                throw bVar;
            } else {
                aVar.iz(1, this.wcX);
                if (this.wcY != null) {
                    aVar.iy(2, this.wcY.computeSize());
                    this.wcY.writeFields(aVar);
                }
                aVar.iz(3, this.wcZ);
                if (this.wda != null) {
                    aVar.iy(4, this.wda.computeSize());
                    this.wda.writeFields(aVar);
                }
                AppMethodBeat.o(60034);
                return 0;
            }
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.wcX) + 0;
            if (this.wcY != null) {
                bs += e.a.a.a.ix(2, this.wcY.computeSize());
            }
            bs += e.a.a.b.b.a.bs(3, this.wcZ);
            if (this.wda != null) {
                bs += e.a.a.a.ix(4, this.wda.computeSize());
            }
            AppMethodBeat.o(60034);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            if (this.wcY == null) {
                bVar = new b("Not all required fields were included: NightTime");
                AppMethodBeat.o(60034);
                throw bVar;
            } else if (this.wda == null) {
                bVar = new b("Not all required fields were included: AllDayTime");
                AppMethodBeat.o(60034);
                throw bVar;
            } else {
                AppMethodBeat.o(60034);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            xe xeVar = (xe) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            xf xfVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    xeVar.wcX = aVar3.BTU.vd();
                    AppMethodBeat.o(60034);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        xfVar = new xf();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = xfVar.populateBuilderWithField(aVar4, xfVar, a.getNextFieldNumber(aVar4))) {
                        }
                        xeVar.wcY = xfVar;
                    }
                    AppMethodBeat.o(60034);
                    return 0;
                case 3:
                    xeVar.wcZ = aVar3.BTU.vd();
                    AppMethodBeat.o(60034);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        xfVar = new xf();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = xfVar.populateBuilderWithField(aVar4, xfVar, a.getNextFieldNumber(aVar4))) {
                        }
                        xeVar.wda = xfVar;
                    }
                    AppMethodBeat.o(60034);
                    return 0;
                default:
                    AppMethodBeat.o(60034);
                    return -1;
            }
        } else {
            AppMethodBeat.o(60034);
            return -1;
        }
    }
}
