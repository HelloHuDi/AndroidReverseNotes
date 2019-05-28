package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class cwu extends a {
    public String wYs;
    public boolean xsf;
    public String xsu;
    public bzj xsv;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(115004);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.xsu != null) {
                aVar.e(1, this.xsu);
            }
            if (this.wYs != null) {
                aVar.e(2, this.wYs);
            }
            if (this.xsv != null) {
                aVar.iy(3, this.xsv.computeSize());
                this.xsv.writeFields(aVar);
            }
            aVar.aO(4, this.xsf);
            AppMethodBeat.o(115004);
            return 0;
        } else if (i == 1) {
            if (this.xsu != null) {
                f = e.a.a.b.b.a.f(1, this.xsu) + 0;
            } else {
                f = 0;
            }
            if (this.wYs != null) {
                f += e.a.a.b.b.a.f(2, this.wYs);
            }
            if (this.xsv != null) {
                f += e.a.a.a.ix(3, this.xsv.computeSize());
            }
            int fv = f + (e.a.a.b.b.a.fv(4) + 1);
            AppMethodBeat.o(115004);
            return fv;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(115004);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cwu cwu = (cwu) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cwu.xsu = aVar3.BTU.readString();
                    AppMethodBeat.o(115004);
                    return 0;
                case 2:
                    cwu.wYs = aVar3.BTU.readString();
                    AppMethodBeat.o(115004);
                    return 0;
                case 3:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        bzj bzj = new bzj();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bzj.populateBuilderWithField(aVar4, bzj, a.getNextFieldNumber(aVar4))) {
                        }
                        cwu.xsv = bzj;
                    }
                    AppMethodBeat.o(115004);
                    return 0;
                case 4:
                    cwu.xsf = aVar3.BTU.ehX();
                    AppMethodBeat.o(115004);
                    return 0;
                default:
                    AppMethodBeat.o(115004);
                    return -1;
            }
        } else {
            AppMethodBeat.o(115004);
            return -1;
        }
    }
}
