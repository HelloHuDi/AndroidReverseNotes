package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class cgt extends a {
    public float size;
    public String text;
    public btr vCP;
    public String vJS;
    public long xfA;
    public String xfB;
    public int xfC;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(48969);
        int o;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.ai(1, this.xfA);
            if (this.xfB != null) {
                aVar.e(2, this.xfB);
            }
            if (this.text != null) {
                aVar.e(3, this.text);
            }
            aVar.r(4, this.size);
            if (this.vCP != null) {
                aVar.iy(5, this.vCP.computeSize());
                this.vCP.writeFields(aVar);
            }
            aVar.iz(6, this.xfC);
            if (this.vJS != null) {
                aVar.e(7, this.vJS);
            }
            AppMethodBeat.o(48969);
            return 0;
        } else if (i == 1) {
            o = e.a.a.b.b.a.o(1, this.xfA) + 0;
            if (this.xfB != null) {
                o += e.a.a.b.b.a.f(2, this.xfB);
            }
            if (this.text != null) {
                o += e.a.a.b.b.a.f(3, this.text);
            }
            o += e.a.a.b.b.a.fv(4) + 4;
            if (this.vCP != null) {
                o += e.a.a.a.ix(5, this.vCP.computeSize());
            }
            o += e.a.a.b.b.a.bs(6, this.xfC);
            if (this.vJS != null) {
                o += e.a.a.b.b.a.f(7, this.vJS);
            }
            AppMethodBeat.o(48969);
            return o;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (o = a.getNextFieldNumber(aVar2); o > 0; o = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, o)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(48969);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cgt cgt = (cgt) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cgt.xfA = aVar3.BTU.ve();
                    AppMethodBeat.o(48969);
                    return 0;
                case 2:
                    cgt.xfB = aVar3.BTU.readString();
                    AppMethodBeat.o(48969);
                    return 0;
                case 3:
                    cgt.text = aVar3.BTU.readString();
                    AppMethodBeat.o(48969);
                    return 0;
                case 4:
                    cgt.size = Float.intBitsToFloat(aVar3.BTU.eia());
                    AppMethodBeat.o(48969);
                    return 0;
                case 5:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        btr btr = new btr();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = btr.populateBuilderWithField(aVar4, btr, a.getNextFieldNumber(aVar4))) {
                        }
                        cgt.vCP = btr;
                    }
                    AppMethodBeat.o(48969);
                    return 0;
                case 6:
                    cgt.xfC = aVar3.BTU.vd();
                    AppMethodBeat.o(48969);
                    return 0;
                case 7:
                    cgt.vJS = aVar3.BTU.readString();
                    AppMethodBeat.o(48969);
                    return 0;
                default:
                    AppMethodBeat.o(48969);
                    return -1;
            }
        } else {
            AppMethodBeat.o(48969);
            return -1;
        }
    }
}
