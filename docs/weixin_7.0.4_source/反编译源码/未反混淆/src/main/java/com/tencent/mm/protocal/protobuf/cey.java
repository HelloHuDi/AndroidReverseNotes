package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class cey extends a {
    public String ThumbUrl;
    public int jCt;
    public String ncM;
    public String ndF;
    public String ndG;
    public int pcX;
    public long vQE;
    public int wZF;
    public int wZG;
    public int wZH;
    public int xdB;
    public cer xdJ;
    public String xdy;
    public String xdz;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56544);
        int o;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.ai(1, this.vQE);
            if (this.ndG != null) {
                aVar.e(2, this.ndG);
            }
            if (this.ndF != null) {
                aVar.e(3, this.ndF);
            }
            if (this.xdy != null) {
                aVar.e(4, this.xdy);
            }
            if (this.xdz != null) {
                aVar.e(5, this.xdz);
            }
            if (this.ncM != null) {
                aVar.e(6, this.ncM);
            }
            aVar.iz(7, this.jCt);
            aVar.iz(8, this.pcX);
            aVar.iz(9, this.wZG);
            aVar.iz(10, this.wZF);
            aVar.iz(11, this.wZH);
            if (this.ThumbUrl != null) {
                aVar.e(12, this.ThumbUrl);
            }
            if (this.xdJ != null) {
                aVar.iy(13, this.xdJ.computeSize());
                this.xdJ.writeFields(aVar);
            }
            aVar.iz(14, this.xdB);
            AppMethodBeat.o(56544);
            return 0;
        } else if (i == 1) {
            o = e.a.a.b.b.a.o(1, this.vQE) + 0;
            if (this.ndG != null) {
                o += e.a.a.b.b.a.f(2, this.ndG);
            }
            if (this.ndF != null) {
                o += e.a.a.b.b.a.f(3, this.ndF);
            }
            if (this.xdy != null) {
                o += e.a.a.b.b.a.f(4, this.xdy);
            }
            if (this.xdz != null) {
                o += e.a.a.b.b.a.f(5, this.xdz);
            }
            if (this.ncM != null) {
                o += e.a.a.b.b.a.f(6, this.ncM);
            }
            o = ((((o + e.a.a.b.b.a.bs(7, this.jCt)) + e.a.a.b.b.a.bs(8, this.pcX)) + e.a.a.b.b.a.bs(9, this.wZG)) + e.a.a.b.b.a.bs(10, this.wZF)) + e.a.a.b.b.a.bs(11, this.wZH);
            if (this.ThumbUrl != null) {
                o += e.a.a.b.b.a.f(12, this.ThumbUrl);
            }
            if (this.xdJ != null) {
                o += e.a.a.a.ix(13, this.xdJ.computeSize());
            }
            o += e.a.a.b.b.a.bs(14, this.xdB);
            AppMethodBeat.o(56544);
            return o;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (o = a.getNextFieldNumber(aVar2); o > 0; o = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, o)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56544);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cey cey = (cey) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cey.vQE = aVar3.BTU.ve();
                    AppMethodBeat.o(56544);
                    return 0;
                case 2:
                    cey.ndG = aVar3.BTU.readString();
                    AppMethodBeat.o(56544);
                    return 0;
                case 3:
                    cey.ndF = aVar3.BTU.readString();
                    AppMethodBeat.o(56544);
                    return 0;
                case 4:
                    cey.xdy = aVar3.BTU.readString();
                    AppMethodBeat.o(56544);
                    return 0;
                case 5:
                    cey.xdz = aVar3.BTU.readString();
                    AppMethodBeat.o(56544);
                    return 0;
                case 6:
                    cey.ncM = aVar3.BTU.readString();
                    AppMethodBeat.o(56544);
                    return 0;
                case 7:
                    cey.jCt = aVar3.BTU.vd();
                    AppMethodBeat.o(56544);
                    return 0;
                case 8:
                    cey.pcX = aVar3.BTU.vd();
                    AppMethodBeat.o(56544);
                    return 0;
                case 9:
                    cey.wZG = aVar3.BTU.vd();
                    AppMethodBeat.o(56544);
                    return 0;
                case 10:
                    cey.wZF = aVar3.BTU.vd();
                    AppMethodBeat.o(56544);
                    return 0;
                case 11:
                    cey.wZH = aVar3.BTU.vd();
                    AppMethodBeat.o(56544);
                    return 0;
                case 12:
                    cey.ThumbUrl = aVar3.BTU.readString();
                    AppMethodBeat.o(56544);
                    return 0;
                case 13:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        cer cer = new cer();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = cer.populateBuilderWithField(aVar4, cer, a.getNextFieldNumber(aVar4))) {
                        }
                        cey.xdJ = cer;
                    }
                    AppMethodBeat.o(56544);
                    return 0;
                case 14:
                    cey.xdB = aVar3.BTU.vd();
                    AppMethodBeat.o(56544);
                    return 0;
                default:
                    AppMethodBeat.o(56544);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56544);
            return -1;
        }
    }
}
