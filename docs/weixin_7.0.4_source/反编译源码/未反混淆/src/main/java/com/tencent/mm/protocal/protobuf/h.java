package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class h extends bsr {
    public int scene;
    public String title;
    public String vzM;
    public LinkedList<j> vzQ = new LinkedList();
    public aw vzR;
    public long vzS;
    public long vzU;

    public h() {
        AppMethodBeat.i(56675);
        AppMethodBeat.o(56675);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56676);
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.title != null) {
                aVar.e(2, this.title);
            }
            aVar.ai(3, this.vzU);
            aVar.e(5, 8, this.vzQ);
            aVar.iz(7, this.scene);
            if (this.vzM != null) {
                aVar.e(8, this.vzM);
            }
            if (this.vzR != null) {
                aVar.iy(9, this.vzR.computeSize());
                this.vzR.writeFields(aVar);
            }
            aVar.ai(10, this.vzS);
            AppMethodBeat.o(56676);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.title != null) {
                ix += e.a.a.b.b.a.f(2, this.title);
            }
            ix = ((ix + e.a.a.b.b.a.o(3, this.vzU)) + e.a.a.a.c(5, 8, this.vzQ)) + e.a.a.b.b.a.bs(7, this.scene);
            if (this.vzM != null) {
                ix += e.a.a.b.b.a.f(8, this.vzM);
            }
            if (this.vzR != null) {
                ix += e.a.a.a.ix(9, this.vzR.computeSize());
            }
            int o = ix + e.a.a.b.b.a.o(10, this.vzS);
            AppMethodBeat.o(56676);
            return o;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vzQ.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56676);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            h hVar = (h) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        hl hlVar = new hl();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = hlVar.populateBuilderWithField(aVar4, hlVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        hVar.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(56676);
                    return 0;
                case 2:
                    hVar.title = aVar3.BTU.readString();
                    AppMethodBeat.o(56676);
                    return 0;
                case 3:
                    hVar.vzU = aVar3.BTU.ve();
                    AppMethodBeat.o(56676);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        j jVar = new j();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = jVar.populateBuilderWithField(aVar4, jVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        hVar.vzQ.add(jVar);
                    }
                    AppMethodBeat.o(56676);
                    return 0;
                case 7:
                    hVar.scene = aVar3.BTU.vd();
                    AppMethodBeat.o(56676);
                    return 0;
                case 8:
                    hVar.vzM = aVar3.BTU.readString();
                    AppMethodBeat.o(56676);
                    return 0;
                case 9:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        aw awVar = new aw();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = awVar.populateBuilderWithField(aVar4, awVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        hVar.vzR = awVar;
                    }
                    AppMethodBeat.o(56676);
                    return 0;
                case 10:
                    hVar.vzS = aVar3.BTU.ve();
                    AppMethodBeat.o(56676);
                    return 0;
                default:
                    AppMethodBeat.o(56676);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56676);
            return -1;
        }
    }
}
