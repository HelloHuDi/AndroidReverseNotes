package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class my extends bsr {
    public int Scene;
    public String fKh;
    public String ndF;
    public String ndG;
    public String vCs;
    public String vCt;
    public String vCu;
    public String vEG;
    public int vFH;
    public String vRl;
    public int vRm;
    public int vRn;
    public SKBuiltinBuffer_t vRo;
    public float vRp;
    public float vRq;
    public String vRr;
    public int vRs;
    public int vRt;
    public int vRu;
    public int vRv;
    public String vRw;
    public int vRx;
    public int vRy;
    public int vRz;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(80031);
        int f;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.vRl != null) {
                aVar.e(1, this.vRl);
            }
            if (this.ndG != null) {
                aVar.e(2, this.ndG);
            }
            if (this.ndF != null) {
                aVar.e(3, this.ndF);
            }
            aVar.iz(4, this.vRm);
            aVar.iz(5, this.vRn);
            if (this.vEG != null) {
                aVar.e(6, this.vEG);
            }
            if (this.vRo != null) {
                aVar.iy(7, this.vRo.computeSize());
                this.vRo.writeFields(aVar);
            }
            aVar.iz(8, this.Scene);
            aVar.r(9, this.vRp);
            aVar.r(10, this.vRq);
            if (this.vRr != null) {
                aVar.e(11, this.vRr);
            }
            aVar.iz(12, this.vRs);
            aVar.iz(13, this.vRt);
            aVar.iz(14, this.vRu);
            aVar.iz(15, this.vRv);
            if (this.vRw != null) {
                aVar.e(16, this.vRw);
            }
            aVar.iz(17, this.vRx);
            aVar.iz(18, this.vRy);
            aVar.iz(19, this.vRz);
            aVar.iz(20, this.vFH);
            if (this.fKh != null) {
                aVar.e(21, this.fKh);
            }
            if (this.vCu != null) {
                aVar.e(22, this.vCu);
            }
            if (this.vCt != null) {
                aVar.e(23, this.vCt);
            }
            if (this.vCs != null) {
                aVar.e(24, this.vCs);
            }
            AppMethodBeat.o(80031);
            return 0;
        } else if (i == 1) {
            if (this.vRl != null) {
                f = e.a.a.b.b.a.f(1, this.vRl) + 0;
            } else {
                f = 0;
            }
            if (this.ndG != null) {
                f += e.a.a.b.b.a.f(2, this.ndG);
            }
            if (this.ndF != null) {
                f += e.a.a.b.b.a.f(3, this.ndF);
            }
            f = (f + e.a.a.b.b.a.bs(4, this.vRm)) + e.a.a.b.b.a.bs(5, this.vRn);
            if (this.vEG != null) {
                f += e.a.a.b.b.a.f(6, this.vEG);
            }
            if (this.vRo != null) {
                f += e.a.a.a.ix(7, this.vRo.computeSize());
            }
            f = ((f + e.a.a.b.b.a.bs(8, this.Scene)) + (e.a.a.b.b.a.fv(9) + 4)) + (e.a.a.b.b.a.fv(10) + 4);
            if (this.vRr != null) {
                f += e.a.a.b.b.a.f(11, this.vRr);
            }
            f = (((f + e.a.a.b.b.a.bs(12, this.vRs)) + e.a.a.b.b.a.bs(13, this.vRt)) + e.a.a.b.b.a.bs(14, this.vRu)) + e.a.a.b.b.a.bs(15, this.vRv);
            if (this.vRw != null) {
                f += e.a.a.b.b.a.f(16, this.vRw);
            }
            f = (((f + e.a.a.b.b.a.bs(17, this.vRx)) + e.a.a.b.b.a.bs(18, this.vRy)) + e.a.a.b.b.a.bs(19, this.vRz)) + e.a.a.b.b.a.bs(20, this.vFH);
            if (this.fKh != null) {
                f += e.a.a.b.b.a.f(21, this.fKh);
            }
            if (this.vCu != null) {
                f += e.a.a.b.b.a.f(22, this.vCu);
            }
            if (this.vCt != null) {
                f += e.a.a.b.b.a.f(23, this.vCt);
            }
            if (this.vCs != null) {
                f += e.a.a.b.b.a.f(24, this.vCs);
            }
            AppMethodBeat.o(80031);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); f > 0; f = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(80031);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            my myVar = (my) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    myVar.vRl = aVar3.BTU.readString();
                    AppMethodBeat.o(80031);
                    return 0;
                case 2:
                    myVar.ndG = aVar3.BTU.readString();
                    AppMethodBeat.o(80031);
                    return 0;
                case 3:
                    myVar.ndF = aVar3.BTU.readString();
                    AppMethodBeat.o(80031);
                    return 0;
                case 4:
                    myVar.vRm = aVar3.BTU.vd();
                    AppMethodBeat.o(80031);
                    return 0;
                case 5:
                    myVar.vRn = aVar3.BTU.vd();
                    AppMethodBeat.o(80031);
                    return 0;
                case 6:
                    myVar.vEG = aVar3.BTU.readString();
                    AppMethodBeat.o(80031);
                    return 0;
                case 7:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        myVar.vRo = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(80031);
                    return 0;
                case 8:
                    myVar.Scene = aVar3.BTU.vd();
                    AppMethodBeat.o(80031);
                    return 0;
                case 9:
                    myVar.vRp = Float.intBitsToFloat(aVar3.BTU.eia());
                    AppMethodBeat.o(80031);
                    return 0;
                case 10:
                    myVar.vRq = Float.intBitsToFloat(aVar3.BTU.eia());
                    AppMethodBeat.o(80031);
                    return 0;
                case 11:
                    myVar.vRr = aVar3.BTU.readString();
                    AppMethodBeat.o(80031);
                    return 0;
                case 12:
                    myVar.vRs = aVar3.BTU.vd();
                    AppMethodBeat.o(80031);
                    return 0;
                case 13:
                    myVar.vRt = aVar3.BTU.vd();
                    AppMethodBeat.o(80031);
                    return 0;
                case 14:
                    myVar.vRu = aVar3.BTU.vd();
                    AppMethodBeat.o(80031);
                    return 0;
                case 15:
                    myVar.vRv = aVar3.BTU.vd();
                    AppMethodBeat.o(80031);
                    return 0;
                case 16:
                    myVar.vRw = aVar3.BTU.readString();
                    AppMethodBeat.o(80031);
                    return 0;
                case 17:
                    myVar.vRx = aVar3.BTU.vd();
                    AppMethodBeat.o(80031);
                    return 0;
                case 18:
                    myVar.vRy = aVar3.BTU.vd();
                    AppMethodBeat.o(80031);
                    return 0;
                case 19:
                    myVar.vRz = aVar3.BTU.vd();
                    AppMethodBeat.o(80031);
                    return 0;
                case 20:
                    myVar.vFH = aVar3.BTU.vd();
                    AppMethodBeat.o(80031);
                    return 0;
                case 21:
                    myVar.fKh = aVar3.BTU.readString();
                    AppMethodBeat.o(80031);
                    return 0;
                case 22:
                    myVar.vCu = aVar3.BTU.readString();
                    AppMethodBeat.o(80031);
                    return 0;
                case 23:
                    myVar.vCt = aVar3.BTU.readString();
                    AppMethodBeat.o(80031);
                    return 0;
                case 24:
                    myVar.vCs = aVar3.BTU.readString();
                    AppMethodBeat.o(80031);
                    return 0;
                default:
                    AppMethodBeat.o(80031);
                    return -1;
            }
        } else {
            AppMethodBeat.o(80031);
            return -1;
        }
    }
}
