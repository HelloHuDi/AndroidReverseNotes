package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class bbe extends a {
    public int jCt;
    public String ncM;
    public int pcX;
    public bts vEC;
    public String vEG;
    public int wFW;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(60044);
        b bVar;
        int ix;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vEC == null) {
                bVar = new b("Not all required fields were included: ToUserName");
                AppMethodBeat.o(60044);
                throw bVar;
            }
            if (this.vEC != null) {
                aVar.iy(1, this.vEC.computeSize());
                this.vEC.writeFields(aVar);
            }
            if (this.ncM != null) {
                aVar.e(2, this.ncM);
            }
            aVar.iz(3, this.jCt);
            aVar.iz(4, this.pcX);
            aVar.iz(5, this.wFW);
            if (this.vEG != null) {
                aVar.e(6, this.vEG);
            }
            AppMethodBeat.o(60044);
            return 0;
        } else if (i == 1) {
            if (this.vEC != null) {
                ix = e.a.a.a.ix(1, this.vEC.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.ncM != null) {
                ix += e.a.a.b.b.a.f(2, this.ncM);
            }
            ix = ((ix + e.a.a.b.b.a.bs(3, this.jCt)) + e.a.a.b.b.a.bs(4, this.pcX)) + e.a.a.b.b.a.bs(5, this.wFW);
            if (this.vEG != null) {
                ix += e.a.a.b.b.a.f(6, this.vEG);
            }
            AppMethodBeat.o(60044);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.vEC == null) {
                bVar = new b("Not all required fields were included: ToUserName");
                AppMethodBeat.o(60044);
                throw bVar;
            }
            AppMethodBeat.o(60044);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bbe bbe = (bbe) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        bts bts = new bts();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bts.populateBuilderWithField(aVar4, bts, a.getNextFieldNumber(aVar4))) {
                        }
                        bbe.vEC = bts;
                    }
                    AppMethodBeat.o(60044);
                    return 0;
                case 2:
                    bbe.ncM = aVar3.BTU.readString();
                    AppMethodBeat.o(60044);
                    return 0;
                case 3:
                    bbe.jCt = aVar3.BTU.vd();
                    AppMethodBeat.o(60044);
                    return 0;
                case 4:
                    bbe.pcX = aVar3.BTU.vd();
                    AppMethodBeat.o(60044);
                    return 0;
                case 5:
                    bbe.wFW = aVar3.BTU.vd();
                    AppMethodBeat.o(60044);
                    return 0;
                case 6:
                    bbe.vEG = aVar3.BTU.readString();
                    AppMethodBeat.o(60044);
                    return 0;
                default:
                    AppMethodBeat.o(60044);
                    return -1;
            }
        } else {
            AppMethodBeat.o(60044);
            return -1;
        }
    }
}
