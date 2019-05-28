package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class f extends bsr {
    public int scene;
    public String title;
    public String vzM;
    public int vzO;
    public long vzP;
    public LinkedList<String> vzQ = new LinkedList();
    public aw vzR;
    public long vzS;

    public f() {
        AppMethodBeat.i(56672);
        AppMethodBeat.o(56672);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56673);
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.iz(2, this.vzO);
            aVar.ai(3, this.vzP);
            if (this.title != null) {
                aVar.e(4, this.title);
            }
            aVar.e(5, 1, this.vzQ);
            aVar.iz(6, this.scene);
            if (this.vzM != null) {
                aVar.e(7, this.vzM);
            }
            if (this.vzR != null) {
                aVar.iy(8, this.vzR.computeSize());
                this.vzR.writeFields(aVar);
            }
            aVar.ai(9, this.vzS);
            AppMethodBeat.o(56673);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (ix + e.a.a.b.b.a.bs(2, this.vzO)) + e.a.a.b.b.a.o(3, this.vzP);
            if (this.title != null) {
                ix += e.a.a.b.b.a.f(4, this.title);
            }
            ix = (ix + e.a.a.a.c(5, 1, this.vzQ)) + e.a.a.b.b.a.bs(6, this.scene);
            if (this.vzM != null) {
                ix += e.a.a.b.b.a.f(7, this.vzM);
            }
            if (this.vzR != null) {
                ix += e.a.a.a.ix(8, this.vzR.computeSize());
            }
            int o = ix + e.a.a.b.b.a.o(9, this.vzS);
            AppMethodBeat.o(56673);
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
            AppMethodBeat.o(56673);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            f fVar = (f) objArr[1];
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
                        fVar.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(56673);
                    return 0;
                case 2:
                    fVar.vzO = aVar3.BTU.vd();
                    AppMethodBeat.o(56673);
                    return 0;
                case 3:
                    fVar.vzP = aVar3.BTU.ve();
                    AppMethodBeat.o(56673);
                    return 0;
                case 4:
                    fVar.title = aVar3.BTU.readString();
                    AppMethodBeat.o(56673);
                    return 0;
                case 5:
                    fVar.vzQ.add(aVar3.BTU.readString());
                    AppMethodBeat.o(56673);
                    return 0;
                case 6:
                    fVar.scene = aVar3.BTU.vd();
                    AppMethodBeat.o(56673);
                    return 0;
                case 7:
                    fVar.vzM = aVar3.BTU.readString();
                    AppMethodBeat.o(56673);
                    return 0;
                case 8:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        aw awVar = new aw();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = awVar.populateBuilderWithField(aVar4, awVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        fVar.vzR = awVar;
                    }
                    AppMethodBeat.o(56673);
                    return 0;
                case 9:
                    fVar.vzS = aVar3.BTU.ve();
                    AppMethodBeat.o(56673);
                    return 0;
                default:
                    AppMethodBeat.o(56673);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56673);
            return -1;
        }
    }
}
