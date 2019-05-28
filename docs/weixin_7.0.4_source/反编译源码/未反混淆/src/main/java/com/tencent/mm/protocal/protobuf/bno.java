package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bno extends bsr {
    public String pQe;
    public String tgu;
    public String wOm;
    public int wPw;
    public String wQm;
    public int wao;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56938);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.wQm != null) {
                aVar.e(2, this.wQm);
            }
            if (this.pQe != null) {
                aVar.e(3, this.pQe);
            }
            aVar.iz(4, this.wPw);
            aVar.iz(5, this.wao);
            if (this.wOm != null) {
                aVar.e(6, this.wOm);
            }
            if (this.tgu != null) {
                aVar.e(100, this.tgu);
            }
            AppMethodBeat.o(56938);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wQm != null) {
                ix += e.a.a.b.b.a.f(2, this.wQm);
            }
            if (this.pQe != null) {
                ix += e.a.a.b.b.a.f(3, this.pQe);
            }
            ix = (ix + e.a.a.b.b.a.bs(4, this.wPw)) + e.a.a.b.b.a.bs(5, this.wao);
            if (this.wOm != null) {
                ix += e.a.a.b.b.a.f(6, this.wOm);
            }
            if (this.tgu != null) {
                ix += e.a.a.b.b.a.f(100, this.tgu);
            }
            AppMethodBeat.o(56938);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56938);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bno bno = (bno) objArr[1];
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
                        bno.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(56938);
                    return 0;
                case 2:
                    bno.wQm = aVar3.BTU.readString();
                    AppMethodBeat.o(56938);
                    return 0;
                case 3:
                    bno.pQe = aVar3.BTU.readString();
                    AppMethodBeat.o(56938);
                    return 0;
                case 4:
                    bno.wPw = aVar3.BTU.vd();
                    AppMethodBeat.o(56938);
                    return 0;
                case 5:
                    bno.wao = aVar3.BTU.vd();
                    AppMethodBeat.o(56938);
                    return 0;
                case 6:
                    bno.wOm = aVar3.BTU.readString();
                    AppMethodBeat.o(56938);
                    return 0;
                case 100:
                    bno.tgu = aVar3.BTU.readString();
                    AppMethodBeat.o(56938);
                    return 0;
                default:
                    AppMethodBeat.o(56938);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56938);
            return -1;
        }
    }
}
