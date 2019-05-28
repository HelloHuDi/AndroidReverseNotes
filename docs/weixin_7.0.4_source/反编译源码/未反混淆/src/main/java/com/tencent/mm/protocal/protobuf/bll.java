package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bll extends bsr {
    public String ProductID;
    public String ndT;
    public int pdc;
    public String wOs;
    public String wOt;
    public int wOu;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56931);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.ProductID != null) {
                aVar.e(2, this.ProductID);
            }
            if (this.wOs != null) {
                aVar.e(3, this.wOs);
            }
            if (this.wOt != null) {
                aVar.e(4, this.wOt);
            }
            aVar.iz(5, this.pdc);
            if (this.ndT != null) {
                aVar.e(7, this.ndT);
            }
            aVar.iz(8, this.wOu);
            AppMethodBeat.o(56931);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.ProductID != null) {
                ix += e.a.a.b.b.a.f(2, this.ProductID);
            }
            if (this.wOs != null) {
                ix += e.a.a.b.b.a.f(3, this.wOs);
            }
            if (this.wOt != null) {
                ix += e.a.a.b.b.a.f(4, this.wOt);
            }
            ix += e.a.a.b.b.a.bs(5, this.pdc);
            if (this.ndT != null) {
                ix += e.a.a.b.b.a.f(7, this.ndT);
            }
            int bs = ix + e.a.a.b.b.a.bs(8, this.wOu);
            AppMethodBeat.o(56931);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56931);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bll bll = (bll) objArr[1];
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
                        bll.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(56931);
                    return 0;
                case 2:
                    bll.ProductID = aVar3.BTU.readString();
                    AppMethodBeat.o(56931);
                    return 0;
                case 3:
                    bll.wOs = aVar3.BTU.readString();
                    AppMethodBeat.o(56931);
                    return 0;
                case 4:
                    bll.wOt = aVar3.BTU.readString();
                    AppMethodBeat.o(56931);
                    return 0;
                case 5:
                    bll.pdc = aVar3.BTU.vd();
                    AppMethodBeat.o(56931);
                    return 0;
                case 7:
                    bll.ndT = aVar3.BTU.readString();
                    AppMethodBeat.o(56931);
                    return 0;
                case 8:
                    bll.wOu = aVar3.BTU.vd();
                    AppMethodBeat.o(56931);
                    return 0;
                default:
                    AppMethodBeat.o(56931);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56931);
            return -1;
        }
    }
}
