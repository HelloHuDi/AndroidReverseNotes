package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bqp extends bsr {
    public String tgu;
    public int wOi;
    public String wOm;
    public String wOn;
    public String wan;
    public int wao;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(56954);
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.iy(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.iz(2, this.wOi);
            if (this.wOn != null) {
                aVar.e(3, this.wOn);
            }
            if (this.wan != null) {
                aVar.e(4, this.wan);
            }
            aVar.iz(5, this.wao);
            if (this.wOm != null) {
                aVar.e(6, this.wOm);
            }
            if (this.tgu != null) {
                aVar.e(100, this.tgu);
            }
            AppMethodBeat.o(56954);
            return 0;
        } else if (i == 1) {
            if (this.BaseRequest != null) {
                ix = e.a.a.a.ix(1, this.BaseRequest.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += e.a.a.b.b.a.bs(2, this.wOi);
            if (this.wOn != null) {
                ix += e.a.a.b.b.a.f(3, this.wOn);
            }
            if (this.wan != null) {
                ix += e.a.a.b.b.a.f(4, this.wan);
            }
            ix += e.a.a.b.b.a.bs(5, this.wao);
            if (this.wOm != null) {
                ix += e.a.a.b.b.a.f(6, this.wOm);
            }
            if (this.tgu != null) {
                ix += e.a.a.b.b.a.f(100, this.tgu);
            }
            AppMethodBeat.o(56954);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(56954);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bqp bqp = (bqp) objArr[1];
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
                        bqp.BaseRequest = hlVar;
                    }
                    AppMethodBeat.o(56954);
                    return 0;
                case 2:
                    bqp.wOi = aVar3.BTU.vd();
                    AppMethodBeat.o(56954);
                    return 0;
                case 3:
                    bqp.wOn = aVar3.BTU.readString();
                    AppMethodBeat.o(56954);
                    return 0;
                case 4:
                    bqp.wan = aVar3.BTU.readString();
                    AppMethodBeat.o(56954);
                    return 0;
                case 5:
                    bqp.wao = aVar3.BTU.vd();
                    AppMethodBeat.o(56954);
                    return 0;
                case 6:
                    bqp.wOm = aVar3.BTU.readString();
                    AppMethodBeat.o(56954);
                    return 0;
                case 100:
                    bqp.tgu = aVar3.BTU.readString();
                    AppMethodBeat.o(56954);
                    return 0;
                default:
                    AppMethodBeat.o(56954);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56954);
            return -1;
        }
    }
}
