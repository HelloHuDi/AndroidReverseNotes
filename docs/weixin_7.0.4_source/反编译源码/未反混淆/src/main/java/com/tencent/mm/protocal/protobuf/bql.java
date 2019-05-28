package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class bql extends a {
    public String fjK;
    public String kLS;
    public int wSJ;
    public float wSN;
    public float wSO;
    public String wSP;
    public LinkedList<String> wSQ = new LinkedList();
    public String wSR;
    public LinkedList<String> wSS = new LinkedList();
    public LinkedList<bqm> wST = new LinkedList();

    public bql() {
        AppMethodBeat.i(108899);
        AppMethodBeat.o(108899);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(108900);
        b bVar;
        int bs;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.wSP == null) {
                bVar = new b("Not all required fields were included: music_url");
                AppMethodBeat.o(108900);
                throw bVar;
            }
            aVar.iz(1, this.wSJ);
            aVar.r(2, this.wSN);
            aVar.r(3, this.wSO);
            if (this.wSP != null) {
                aVar.e(4, this.wSP);
            }
            aVar.e(5, 1, this.wSQ);
            if (this.wSR != null) {
                aVar.e(6, this.wSR);
            }
            aVar.e(7, 1, this.wSS);
            aVar.e(8, 8, this.wST);
            if (this.kLS != null) {
                aVar.e(9, this.kLS);
            }
            if (this.fjK != null) {
                aVar.e(10, this.fjK);
            }
            AppMethodBeat.o(108900);
            return 0;
        } else if (i == 1) {
            bs = ((e.a.a.b.b.a.bs(1, this.wSJ) + 0) + (e.a.a.b.b.a.fv(2) + 4)) + (e.a.a.b.b.a.fv(3) + 4);
            if (this.wSP != null) {
                bs += e.a.a.b.b.a.f(4, this.wSP);
            }
            bs += e.a.a.a.c(5, 1, this.wSQ);
            if (this.wSR != null) {
                bs += e.a.a.b.b.a.f(6, this.wSR);
            }
            bs = (bs + e.a.a.a.c(7, 1, this.wSS)) + e.a.a.a.c(8, 8, this.wST);
            if (this.kLS != null) {
                bs += e.a.a.b.b.a.f(9, this.kLS);
            }
            if (this.fjK != null) {
                bs += e.a.a.b.b.a.f(10, this.fjK);
            }
            AppMethodBeat.o(108900);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wSQ.clear();
            this.wSS.clear();
            this.wST.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            if (this.wSP == null) {
                bVar = new b("Not all required fields were included: music_url");
                AppMethodBeat.o(108900);
                throw bVar;
            }
            AppMethodBeat.o(108900);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bql bql = (bql) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bql.wSJ = aVar3.BTU.vd();
                    AppMethodBeat.o(108900);
                    return 0;
                case 2:
                    bql.wSN = Float.intBitsToFloat(aVar3.BTU.eia());
                    AppMethodBeat.o(108900);
                    return 0;
                case 3:
                    bql.wSO = Float.intBitsToFloat(aVar3.BTU.eia());
                    AppMethodBeat.o(108900);
                    return 0;
                case 4:
                    bql.wSP = aVar3.BTU.readString();
                    AppMethodBeat.o(108900);
                    return 0;
                case 5:
                    bql.wSQ.add(aVar3.BTU.readString());
                    AppMethodBeat.o(108900);
                    return 0;
                case 6:
                    bql.wSR = aVar3.BTU.readString();
                    AppMethodBeat.o(108900);
                    return 0;
                case 7:
                    bql.wSS.add(aVar3.BTU.readString());
                    AppMethodBeat.o(108900);
                    return 0;
                case 8:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bqm bqm = new bqm();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bqm.populateBuilderWithField(aVar4, bqm, a.getNextFieldNumber(aVar4))) {
                        }
                        bql.wST.add(bqm);
                    }
                    AppMethodBeat.o(108900);
                    return 0;
                case 9:
                    bql.kLS = aVar3.BTU.readString();
                    AppMethodBeat.o(108900);
                    return 0;
                case 10:
                    bql.fjK = aVar3.BTU.readString();
                    AppMethodBeat.o(108900);
                    return 0;
                default:
                    AppMethodBeat.o(108900);
                    return -1;
            }
        } else {
            AppMethodBeat.o(108900);
            return -1;
        }
    }
}
