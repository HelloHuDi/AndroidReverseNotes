package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public final class hd extends a {
    public String nuL;
    public String pLH;
    public int pLI;
    public int pLJ;
    public String pLK;
    public String pLL;
    public String pLM;
    public long pLP;
    public String pbn;
    public LinkedList<yq> vJM = new LinkedList();
    public String vJN;
    public String vJO;

    public hd() {
        AppMethodBeat.i(48776);
        AppMethodBeat.o(48776);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(48777);
        int f;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.pbn != null) {
                aVar.e(1, this.pbn);
            }
            if (this.nuL != null) {
                aVar.e(2, this.nuL);
            }
            if (this.pLH != null) {
                aVar.e(3, this.pLH);
            }
            aVar.iz(4, this.pLI);
            aVar.iz(5, this.pLJ);
            aVar.e(6, 8, this.vJM);
            if (this.pLK != null) {
                aVar.e(7, this.pLK);
            }
            if (this.pLL != null) {
                aVar.e(8, this.pLL);
            }
            if (this.pLM != null) {
                aVar.e(9, this.pLM);
            }
            if (this.vJN != null) {
                aVar.e(10, this.vJN);
            }
            if (this.vJO != null) {
                aVar.e(11, this.vJO);
            }
            aVar.ai(12, this.pLP);
            AppMethodBeat.o(48777);
            return 0;
        } else if (i == 1) {
            if (this.pbn != null) {
                f = e.a.a.b.b.a.f(1, this.pbn) + 0;
            } else {
                f = 0;
            }
            if (this.nuL != null) {
                f += e.a.a.b.b.a.f(2, this.nuL);
            }
            if (this.pLH != null) {
                f += e.a.a.b.b.a.f(3, this.pLH);
            }
            f = ((f + e.a.a.b.b.a.bs(4, this.pLI)) + e.a.a.b.b.a.bs(5, this.pLJ)) + e.a.a.a.c(6, 8, this.vJM);
            if (this.pLK != null) {
                f += e.a.a.b.b.a.f(7, this.pLK);
            }
            if (this.pLL != null) {
                f += e.a.a.b.b.a.f(8, this.pLL);
            }
            if (this.pLM != null) {
                f += e.a.a.b.b.a.f(9, this.pLM);
            }
            if (this.vJN != null) {
                f += e.a.a.b.b.a.f(10, this.vJN);
            }
            if (this.vJO != null) {
                f += e.a.a.b.b.a.f(11, this.vJO);
            }
            int o = f + e.a.a.b.b.a.o(12, this.pLP);
            AppMethodBeat.o(48777);
            return o;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vJM.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(48777);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            hd hdVar = (hd) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    hdVar.pbn = aVar3.BTU.readString();
                    AppMethodBeat.o(48777);
                    return 0;
                case 2:
                    hdVar.nuL = aVar3.BTU.readString();
                    AppMethodBeat.o(48777);
                    return 0;
                case 3:
                    hdVar.pLH = aVar3.BTU.readString();
                    AppMethodBeat.o(48777);
                    return 0;
                case 4:
                    hdVar.pLI = aVar3.BTU.vd();
                    AppMethodBeat.o(48777);
                    return 0;
                case 5:
                    hdVar.pLJ = aVar3.BTU.vd();
                    AppMethodBeat.o(48777);
                    return 0;
                case 6:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        yq yqVar = new yq();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = yqVar.populateBuilderWithField(aVar4, yqVar, a.getNextFieldNumber(aVar4))) {
                        }
                        hdVar.vJM.add(yqVar);
                    }
                    AppMethodBeat.o(48777);
                    return 0;
                case 7:
                    hdVar.pLK = aVar3.BTU.readString();
                    AppMethodBeat.o(48777);
                    return 0;
                case 8:
                    hdVar.pLL = aVar3.BTU.readString();
                    AppMethodBeat.o(48777);
                    return 0;
                case 9:
                    hdVar.pLM = aVar3.BTU.readString();
                    AppMethodBeat.o(48777);
                    return 0;
                case 10:
                    hdVar.vJN = aVar3.BTU.readString();
                    AppMethodBeat.o(48777);
                    return 0;
                case 11:
                    hdVar.vJO = aVar3.BTU.readString();
                    AppMethodBeat.o(48777);
                    return 0;
                case 12:
                    hdVar.pLP = aVar3.BTU.ve();
                    AppMethodBeat.o(48777);
                    return 0;
                default:
                    AppMethodBeat.o(48777);
                    return -1;
            }
        } else {
            AppMethodBeat.o(48777);
            return -1;
        }
    }
}
