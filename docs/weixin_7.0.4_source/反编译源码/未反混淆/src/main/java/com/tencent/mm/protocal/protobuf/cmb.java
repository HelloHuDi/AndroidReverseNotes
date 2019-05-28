package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class cmb extends a {
    public int apptype;
    public String csB;
    public String fhH;
    public String kfM;
    public int wGS;
    public LinkedList<cmc> xjN = new LinkedList();
    public String xjO;
    public int xjP;

    public cmb() {
        AppMethodBeat.i(127735);
        AppMethodBeat.o(127735);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(127736);
        int f;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.csB != null) {
                aVar.e(1, this.csB);
            }
            if (this.fhH != null) {
                aVar.e(2, this.fhH);
            }
            aVar.iz(3, this.apptype);
            aVar.e(4, 8, this.xjN);
            aVar.iz(5, this.wGS);
            if (this.xjO != null) {
                aVar.e(6, this.xjO);
            }
            if (this.kfM != null) {
                aVar.e(7, this.kfM);
            }
            aVar.iz(8, this.xjP);
            AppMethodBeat.o(127736);
            return 0;
        } else if (i == 1) {
            if (this.csB != null) {
                f = e.a.a.b.b.a.f(1, this.csB) + 0;
            } else {
                f = 0;
            }
            if (this.fhH != null) {
                f += e.a.a.b.b.a.f(2, this.fhH);
            }
            f = ((f + e.a.a.b.b.a.bs(3, this.apptype)) + e.a.a.a.c(4, 8, this.xjN)) + e.a.a.b.b.a.bs(5, this.wGS);
            if (this.xjO != null) {
                f += e.a.a.b.b.a.f(6, this.xjO);
            }
            if (this.kfM != null) {
                f += e.a.a.b.b.a.f(7, this.kfM);
            }
            int bs = f + e.a.a.b.b.a.bs(8, this.xjP);
            AppMethodBeat.o(127736);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.xjN.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(127736);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            cmb cmb = (cmb) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cmb.csB = aVar3.BTU.readString();
                    AppMethodBeat.o(127736);
                    return 0;
                case 2:
                    cmb.fhH = aVar3.BTU.readString();
                    AppMethodBeat.o(127736);
                    return 0;
                case 3:
                    cmb.apptype = aVar3.BTU.vd();
                    AppMethodBeat.o(127736);
                    return 0;
                case 4:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cmc cmc = new cmc();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = cmc.populateBuilderWithField(aVar4, cmc, a.getNextFieldNumber(aVar4))) {
                        }
                        cmb.xjN.add(cmc);
                    }
                    AppMethodBeat.o(127736);
                    return 0;
                case 5:
                    cmb.wGS = aVar3.BTU.vd();
                    AppMethodBeat.o(127736);
                    return 0;
                case 6:
                    cmb.xjO = aVar3.BTU.readString();
                    AppMethodBeat.o(127736);
                    return 0;
                case 7:
                    cmb.kfM = aVar3.BTU.readString();
                    AppMethodBeat.o(127736);
                    return 0;
                case 8:
                    cmb.xjP = aVar3.BTU.vd();
                    AppMethodBeat.o(127736);
                    return 0;
                default:
                    AppMethodBeat.o(127736);
                    return -1;
            }
        } else {
            AppMethodBeat.o(127736);
            return -1;
        }
    }
}
