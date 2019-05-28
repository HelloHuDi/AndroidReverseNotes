package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class avo extends bsr {
    public String csB;
    public String cvO;
    public int scene;
    public String signature;
    public String url;
    public String wzf;
    public String wzg;
    public LinkedList<String> wzx = new LinkedList();
    public String wzy;

    public avo() {
        AppMethodBeat.i(10203);
        AppMethodBeat.o(10203);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(10204);
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.url != null) {
                aVar.e(2, this.url);
            }
            if (this.csB != null) {
                aVar.e(3, this.csB);
            }
            aVar.e(4, 1, this.wzx);
            if (this.cvO != null) {
                aVar.e(5, this.cvO);
            }
            if (this.wzf != null) {
                aVar.e(6, this.wzf);
            }
            if (this.signature != null) {
                aVar.e(7, this.signature);
            }
            if (this.wzg != null) {
                aVar.e(8, this.wzg);
            }
            aVar.iz(9, this.scene);
            if (this.wzy != null) {
                aVar.e(10, this.wzy);
            }
            AppMethodBeat.o(10204);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.url != null) {
                ix += e.a.a.b.b.a.f(2, this.url);
            }
            if (this.csB != null) {
                ix += e.a.a.b.b.a.f(3, this.csB);
            }
            ix += e.a.a.a.c(4, 1, this.wzx);
            if (this.cvO != null) {
                ix += e.a.a.b.b.a.f(5, this.cvO);
            }
            if (this.wzf != null) {
                ix += e.a.a.b.b.a.f(6, this.wzf);
            }
            if (this.signature != null) {
                ix += e.a.a.b.b.a.f(7, this.signature);
            }
            if (this.wzg != null) {
                ix += e.a.a.b.b.a.f(8, this.wzg);
            }
            ix += e.a.a.b.b.a.bs(9, this.scene);
            if (this.wzy != null) {
                ix += e.a.a.b.b.a.f(10, this.wzy);
            }
            AppMethodBeat.o(10204);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wzx.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(10204);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            avo avo = (avo) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        hl hlVar = new hl();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = hlVar.populateBuilderWithField(aVar4, hlVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        avo.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(10204);
                    return 0;
                case 2:
                    avo.url = aVar3.BTU.readString();
                    AppMethodBeat.o(10204);
                    return 0;
                case 3:
                    avo.csB = aVar3.BTU.readString();
                    AppMethodBeat.o(10204);
                    return 0;
                case 4:
                    avo.wzx.add(aVar3.BTU.readString());
                    AppMethodBeat.o(10204);
                    return 0;
                case 5:
                    avo.cvO = aVar3.BTU.readString();
                    AppMethodBeat.o(10204);
                    return 0;
                case 6:
                    avo.wzf = aVar3.BTU.readString();
                    AppMethodBeat.o(10204);
                    return 0;
                case 7:
                    avo.signature = aVar3.BTU.readString();
                    AppMethodBeat.o(10204);
                    return 0;
                case 8:
                    avo.wzg = aVar3.BTU.readString();
                    AppMethodBeat.o(10204);
                    return 0;
                case 9:
                    avo.scene = aVar3.BTU.vd();
                    AppMethodBeat.o(10204);
                    return 0;
                case 10:
                    avo.wzy = aVar3.BTU.readString();
                    AppMethodBeat.o(10204);
                    return 0;
                default:
                    AppMethodBeat.o(10204);
                    return -1;
            }
        } else {
            AppMethodBeat.o(10204);
            return -1;
        }
    }
}
