package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class mh extends a {
    public String Title;
    public int jBV;
    public LinkedList<mn> naO = new LinkedList();
    public int vOq;
    public long vQd;
    public int vQe;
    public LinkedList<String> vQf = new LinkedList();
    public String vQg;

    public mh() {
        AppMethodBeat.i(124294);
        AppMethodBeat.o(124294);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(124295);
        b bVar;
        int o;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.vQg == null) {
                bVar = new b("Not all required fields were included: SearchID");
                AppMethodBeat.o(124295);
                throw bVar;
            }
            aVar.ai(1, this.vQd);
            aVar.iz(2, this.vQe);
            if (this.Title != null) {
                aVar.e(3, this.Title);
            }
            aVar.e(4, 1, this.vQf);
            aVar.e(5, 8, this.naO);
            aVar.iz(6, this.jBV);
            if (this.vQg != null) {
                aVar.e(7, this.vQg);
            }
            aVar.iz(8, this.vOq);
            AppMethodBeat.o(124295);
            return 0;
        } else if (i == 1) {
            o = (e.a.a.b.b.a.o(1, this.vQd) + 0) + e.a.a.b.b.a.bs(2, this.vQe);
            if (this.Title != null) {
                o += e.a.a.b.b.a.f(3, this.Title);
            }
            o = ((o + e.a.a.a.c(4, 1, this.vQf)) + e.a.a.a.c(5, 8, this.naO)) + e.a.a.b.b.a.bs(6, this.jBV);
            if (this.vQg != null) {
                o += e.a.a.b.b.a.f(7, this.vQg);
            }
            o += e.a.a.b.b.a.bs(8, this.vOq);
            AppMethodBeat.o(124295);
            return o;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vQf.clear();
            this.naO.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (o = a.getNextFieldNumber(aVar2); o > 0; o = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, o)) {
                    aVar2.ems();
                }
            }
            if (this.vQg == null) {
                bVar = new b("Not all required fields were included: SearchID");
                AppMethodBeat.o(124295);
                throw bVar;
            }
            AppMethodBeat.o(124295);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            mh mhVar = (mh) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    mhVar.vQd = aVar3.BTU.ve();
                    AppMethodBeat.o(124295);
                    return 0;
                case 2:
                    mhVar.vQe = aVar3.BTU.vd();
                    AppMethodBeat.o(124295);
                    return 0;
                case 3:
                    mhVar.Title = aVar3.BTU.readString();
                    AppMethodBeat.o(124295);
                    return 0;
                case 4:
                    mhVar.vQf.add(aVar3.BTU.readString());
                    AppMethodBeat.o(124295);
                    return 0;
                case 5:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        mn mnVar = new mn();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = mnVar.populateBuilderWithField(aVar4, mnVar, a.getNextFieldNumber(aVar4))) {
                        }
                        mhVar.naO.add(mnVar);
                    }
                    AppMethodBeat.o(124295);
                    return 0;
                case 6:
                    mhVar.jBV = aVar3.BTU.vd();
                    AppMethodBeat.o(124295);
                    return 0;
                case 7:
                    mhVar.vQg = aVar3.BTU.readString();
                    AppMethodBeat.o(124295);
                    return 0;
                case 8:
                    mhVar.vOq = aVar3.BTU.vd();
                    AppMethodBeat.o(124295);
                    return 0;
                default:
                    AppMethodBeat.o(124295);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124295);
            return -1;
        }
    }
}
