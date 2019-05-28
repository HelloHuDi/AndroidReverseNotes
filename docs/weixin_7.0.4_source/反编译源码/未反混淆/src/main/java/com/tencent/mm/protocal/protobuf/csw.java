package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class csw extends bsr {
    public String query;
    public int wCu;
    public String wCy;
    public String xqb;
    public String xqg;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(93811);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.query != null) {
                aVar.e(2, this.query);
            }
            aVar.iz(3, this.wCu);
            if (this.wCy != null) {
                aVar.e(99, this.wCy);
            }
            if (this.xqb != null) {
                aVar.e(100, this.xqb);
            }
            if (this.xqg != null) {
                aVar.e(101, this.xqg);
            }
            AppMethodBeat.o(93811);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.query != null) {
                ix += e.a.a.b.b.a.f(2, this.query);
            }
            ix += e.a.a.b.b.a.bs(3, this.wCu);
            if (this.wCy != null) {
                ix += e.a.a.b.b.a.f(99, this.wCy);
            }
            if (this.xqb != null) {
                ix += e.a.a.b.b.a.f(100, this.xqb);
            }
            if (this.xqg != null) {
                ix += e.a.a.b.b.a.f(101, this.xqg);
            }
            AppMethodBeat.o(93811);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(93811);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            csw csw = (csw) objArr[1];
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
                        csw.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(93811);
                    return 0;
                case 2:
                    csw.query = aVar3.BTU.readString();
                    AppMethodBeat.o(93811);
                    return 0;
                case 3:
                    csw.wCu = aVar3.BTU.vd();
                    AppMethodBeat.o(93811);
                    return 0;
                case 99:
                    csw.wCy = aVar3.BTU.readString();
                    AppMethodBeat.o(93811);
                    return 0;
                case 100:
                    csw.xqb = aVar3.BTU.readString();
                    AppMethodBeat.o(93811);
                    return 0;
                case 101:
                    csw.xqg = aVar3.BTU.readString();
                    AppMethodBeat.o(93811);
                    return 0;
                default:
                    AppMethodBeat.o(93811);
                    return -1;
            }
        } else {
            AppMethodBeat.o(93811);
            return -1;
        }
    }
}
