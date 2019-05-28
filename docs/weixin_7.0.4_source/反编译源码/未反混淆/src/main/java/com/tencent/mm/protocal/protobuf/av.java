package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class av extends a {
    public int Scene;
    public String Url;
    public int jCt;
    public dj vCA;
    public du vCB;
    public dt vCC;
    public dt vCD;
    public String vCv;
    public String vCw;
    public String vCx;
    public at vCy;
    public String vCz;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(94490);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.jCt);
            if (this.Url != null) {
                aVar.e(2, this.Url);
            }
            aVar.iz(3, this.Scene);
            if (this.vCv != null) {
                aVar.e(4, this.vCv);
            }
            if (this.vCw != null) {
                aVar.e(5, this.vCw);
            }
            if (this.vCx != null) {
                aVar.e(6, this.vCx);
            }
            if (this.vCy != null) {
                aVar.iy(7, this.vCy.computeSize());
                this.vCy.writeFields(aVar);
            }
            if (this.vCz != null) {
                aVar.e(8, this.vCz);
            }
            if (this.vCA != null) {
                aVar.iy(9, this.vCA.computeSize());
                this.vCA.writeFields(aVar);
            }
            if (this.vCB != null) {
                aVar.iy(10, this.vCB.computeSize());
                this.vCB.writeFields(aVar);
            }
            if (this.vCC != null) {
                aVar.iy(11, this.vCC.computeSize());
                this.vCC.writeFields(aVar);
            }
            if (this.vCD != null) {
                aVar.iy(12, this.vCD.computeSize());
                this.vCD.writeFields(aVar);
            }
            AppMethodBeat.o(94490);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.jCt) + 0;
            if (this.Url != null) {
                bs += e.a.a.b.b.a.f(2, this.Url);
            }
            bs += e.a.a.b.b.a.bs(3, this.Scene);
            if (this.vCv != null) {
                bs += e.a.a.b.b.a.f(4, this.vCv);
            }
            if (this.vCw != null) {
                bs += e.a.a.b.b.a.f(5, this.vCw);
            }
            if (this.vCx != null) {
                bs += e.a.a.b.b.a.f(6, this.vCx);
            }
            if (this.vCy != null) {
                bs += e.a.a.a.ix(7, this.vCy.computeSize());
            }
            if (this.vCz != null) {
                bs += e.a.a.b.b.a.f(8, this.vCz);
            }
            if (this.vCA != null) {
                bs += e.a.a.a.ix(9, this.vCA.computeSize());
            }
            if (this.vCB != null) {
                bs += e.a.a.a.ix(10, this.vCB.computeSize());
            }
            if (this.vCC != null) {
                bs += e.a.a.a.ix(11, this.vCC.computeSize());
            }
            if (this.vCD != null) {
                bs += e.a.a.a.ix(12, this.vCD.computeSize());
            }
            AppMethodBeat.o(94490);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(94490);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            av avVar = (av) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            e.a.a.a.a aVar4;
            boolean z;
            dt dtVar;
            switch (intValue) {
                case 1:
                    avVar.jCt = aVar3.BTU.vd();
                    AppMethodBeat.o(94490);
                    return 0;
                case 2:
                    avVar.Url = aVar3.BTU.readString();
                    AppMethodBeat.o(94490);
                    return 0;
                case 3:
                    avVar.Scene = aVar3.BTU.vd();
                    AppMethodBeat.o(94490);
                    return 0;
                case 4:
                    avVar.vCv = aVar3.BTU.readString();
                    AppMethodBeat.o(94490);
                    return 0;
                case 5:
                    avVar.vCw = aVar3.BTU.readString();
                    AppMethodBeat.o(94490);
                    return 0;
                case 6:
                    avVar.vCx = aVar3.BTU.readString();
                    AppMethodBeat.o(94490);
                    return 0;
                case 7:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        at atVar = new at();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = atVar.populateBuilderWithField(aVar4, atVar, a.getNextFieldNumber(aVar4))) {
                        }
                        avVar.vCy = atVar;
                    }
                    AppMethodBeat.o(94490);
                    return 0;
                case 8:
                    avVar.vCz = aVar3.BTU.readString();
                    AppMethodBeat.o(94490);
                    return 0;
                case 9:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        dj djVar = new dj();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = djVar.populateBuilderWithField(aVar4, djVar, a.getNextFieldNumber(aVar4))) {
                        }
                        avVar.vCA = djVar;
                    }
                    AppMethodBeat.o(94490);
                    return 0;
                case 10:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        du duVar = new du();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = duVar.populateBuilderWithField(aVar4, duVar, a.getNextFieldNumber(aVar4))) {
                        }
                        avVar.vCB = duVar;
                    }
                    AppMethodBeat.o(94490);
                    return 0;
                case 11:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        dtVar = new dt();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = dtVar.populateBuilderWithField(aVar4, dtVar, a.getNextFieldNumber(aVar4))) {
                        }
                        avVar.vCC = dtVar;
                    }
                    AppMethodBeat.o(94490);
                    return 0;
                case 12:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        dtVar = new dt();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = dtVar.populateBuilderWithField(aVar4, dtVar, a.getNextFieldNumber(aVar4))) {
                        }
                        avVar.vCD = dtVar;
                    }
                    AppMethodBeat.o(94490);
                    return 0;
                default:
                    AppMethodBeat.o(94490);
                    return -1;
            }
        } else {
            AppMethodBeat.o(94490);
            return -1;
        }
    }
}
