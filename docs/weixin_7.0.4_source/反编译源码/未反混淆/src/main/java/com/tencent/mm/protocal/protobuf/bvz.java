package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bvz extends bsr {
    public String csB;
    public int cvd;
    public int scene;
    public String url;
    public int vOP;
    public String vTT;
    public String wWO;
    public String wap;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56967);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.wap != null) {
                aVar.e(2, this.wap);
            }
            if (this.csB != null) {
                aVar.e(3, this.csB);
            }
            if (this.url != null) {
                aVar.e(4, this.url);
            }
            if (this.wWO != null) {
                aVar.e(5, this.wWO);
            }
            aVar.iz(6, this.scene);
            aVar.iz(7, this.cvd);
            if (this.vTT != null) {
                aVar.e(8, this.vTT);
            }
            aVar.iz(9, this.vOP);
            AppMethodBeat.o(56967);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wap != null) {
                ix += e.a.a.b.b.a.f(2, this.wap);
            }
            if (this.csB != null) {
                ix += e.a.a.b.b.a.f(3, this.csB);
            }
            if (this.url != null) {
                ix += e.a.a.b.b.a.f(4, this.url);
            }
            if (this.wWO != null) {
                ix += e.a.a.b.b.a.f(5, this.wWO);
            }
            ix = (ix + e.a.a.b.b.a.bs(6, this.scene)) + e.a.a.b.b.a.bs(7, this.cvd);
            if (this.vTT != null) {
                ix += e.a.a.b.b.a.f(8, this.vTT);
            }
            int bs = ix + e.a.a.b.b.a.bs(9, this.vOP);
            AppMethodBeat.o(56967);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56967);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bvz bvz = (bvz) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        hl hlVar = new hl();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = hlVar.populateBuilderWithField(aVar4, hlVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        bvz.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(56967);
                    return 0;
                case 2:
                    bvz.wap = aVar3.BTU.readString();
                    AppMethodBeat.o(56967);
                    return 0;
                case 3:
                    bvz.csB = aVar3.BTU.readString();
                    AppMethodBeat.o(56967);
                    return 0;
                case 4:
                    bvz.url = aVar3.BTU.readString();
                    AppMethodBeat.o(56967);
                    return 0;
                case 5:
                    bvz.wWO = aVar3.BTU.readString();
                    AppMethodBeat.o(56967);
                    return 0;
                case 6:
                    bvz.scene = aVar3.BTU.vd();
                    AppMethodBeat.o(56967);
                    return 0;
                case 7:
                    bvz.cvd = aVar3.BTU.vd();
                    AppMethodBeat.o(56967);
                    return 0;
                case 8:
                    bvz.vTT = aVar3.BTU.readString();
                    AppMethodBeat.o(56967);
                    return 0;
                case 9:
                    bvz.vOP = aVar3.BTU.vd();
                    AppMethodBeat.o(56967);
                    return 0;
                default:
                    AppMethodBeat.o(56967);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56967);
            return -1;
        }
    }
}
