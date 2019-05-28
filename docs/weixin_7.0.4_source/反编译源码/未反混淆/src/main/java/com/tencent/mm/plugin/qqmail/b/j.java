package com.tencent.mm.plugin.qqmail.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public final class j extends a {
    public String content;
    public int ptH;
    public String ptI;
    public LinkedList<o> ptJ = new LinkedList();
    public LinkedList<o> ptK = new LinkedList();
    public LinkedList<o> ptL = new LinkedList();
    public LinkedList<ai> ptM = new LinkedList();
    public String ptN;
    public int ptO = 5;

    public j() {
        AppMethodBeat.i(67931);
        AppMethodBeat.o(67931);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(67932);
        b bVar;
        int bs;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.content == null) {
                bVar = new b("Not all required fields were included: content");
                AppMethodBeat.o(67932);
                throw bVar;
            }
            aVar.iz(1, this.ptH);
            if (this.ptI != null) {
                aVar.e(2, this.ptI);
            }
            aVar.e(3, 8, this.ptJ);
            aVar.e(4, 8, this.ptK);
            aVar.e(5, 8, this.ptL);
            aVar.e(6, 8, this.ptM);
            if (this.ptN != null) {
                aVar.e(7, this.ptN);
            }
            if (this.content != null) {
                aVar.e(8, this.content);
            }
            aVar.iz(9, this.ptO);
            AppMethodBeat.o(67932);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.ptH) + 0;
            if (this.ptI != null) {
                bs += e.a.a.b.b.a.f(2, this.ptI);
            }
            bs = (((bs + e.a.a.a.c(3, 8, this.ptJ)) + e.a.a.a.c(4, 8, this.ptK)) + e.a.a.a.c(5, 8, this.ptL)) + e.a.a.a.c(6, 8, this.ptM);
            if (this.ptN != null) {
                bs += e.a.a.b.b.a.f(7, this.ptN);
            }
            if (this.content != null) {
                bs += e.a.a.b.b.a.f(8, this.content);
            }
            bs += e.a.a.b.b.a.bs(9, this.ptO);
            AppMethodBeat.o(67932);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.ptJ.clear();
            this.ptK.clear();
            this.ptL.clear();
            this.ptM.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            if (this.content == null) {
                bVar = new b("Not all required fields were included: content");
                AppMethodBeat.o(67932);
                throw bVar;
            }
            AppMethodBeat.o(67932);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            j jVar = (j) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            o oVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    jVar.ptH = aVar3.BTU.vd();
                    AppMethodBeat.o(67932);
                    return 0;
                case 2:
                    jVar.ptI = aVar3.BTU.readString();
                    AppMethodBeat.o(67932);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        oVar = new o();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = oVar.populateBuilderWithField(aVar4, oVar, a.getNextFieldNumber(aVar4))) {
                        }
                        jVar.ptJ.add(oVar);
                    }
                    AppMethodBeat.o(67932);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        oVar = new o();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = oVar.populateBuilderWithField(aVar4, oVar, a.getNextFieldNumber(aVar4))) {
                        }
                        jVar.ptK.add(oVar);
                    }
                    AppMethodBeat.o(67932);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        oVar = new o();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = oVar.populateBuilderWithField(aVar4, oVar, a.getNextFieldNumber(aVar4))) {
                        }
                        jVar.ptL.add(oVar);
                    }
                    AppMethodBeat.o(67932);
                    return 0;
                case 6:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ai aiVar = new ai();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aiVar.populateBuilderWithField(aVar4, aiVar, a.getNextFieldNumber(aVar4))) {
                        }
                        jVar.ptM.add(aiVar);
                    }
                    AppMethodBeat.o(67932);
                    return 0;
                case 7:
                    jVar.ptN = aVar3.BTU.readString();
                    AppMethodBeat.o(67932);
                    return 0;
                case 8:
                    jVar.content = aVar3.BTU.readString();
                    AppMethodBeat.o(67932);
                    return 0;
                case 9:
                    jVar.ptO = aVar3.BTU.vd();
                    AppMethodBeat.o(67932);
                    return 0;
                default:
                    AppMethodBeat.o(67932);
                    return -1;
            }
        } else {
            AppMethodBeat.o(67932);
            return -1;
        }
    }
}
