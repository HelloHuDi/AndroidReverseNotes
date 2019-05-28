package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class ajs extends btd {
    public int kdT;
    public String kdU;
    public ask vYe;
    public bab woj;
    public mu wpq;
    public asi wpr;
    public atk wps;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(48855);
        b bVar;
        int ix;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(48855);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.iz(2, this.kdT);
            if (this.kdU != null) {
                aVar.e(3, this.kdU);
            }
            if (this.vYe != null) {
                aVar.iy(4, this.vYe.computeSize());
                this.vYe.writeFields(aVar);
            }
            if (this.wpq != null) {
                aVar.iy(8, this.wpq.computeSize());
                this.wpq.writeFields(aVar);
            }
            if (this.woj != null) {
                aVar.iy(9, this.woj.computeSize());
                this.woj.writeFields(aVar);
            }
            if (this.wpr != null) {
                aVar.iy(10, this.wpr.computeSize());
                this.wpr.writeFields(aVar);
            }
            if (this.wps != null) {
                aVar.iy(11, this.wps.computeSize());
                this.wps.writeFields(aVar);
            }
            AppMethodBeat.o(48855);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += e.a.a.b.b.a.bs(2, this.kdT);
            if (this.kdU != null) {
                ix += e.a.a.b.b.a.f(3, this.kdU);
            }
            if (this.vYe != null) {
                ix += e.a.a.a.ix(4, this.vYe.computeSize());
            }
            if (this.wpq != null) {
                ix += e.a.a.a.ix(8, this.wpq.computeSize());
            }
            if (this.woj != null) {
                ix += e.a.a.a.ix(9, this.woj.computeSize());
            }
            if (this.wpr != null) {
                ix += e.a.a.a.ix(10, this.wpr.computeSize());
            }
            if (this.wps != null) {
                ix += e.a.a.a.ix(11, this.wps.computeSize());
            }
            AppMethodBeat.o(48855);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(48855);
                throw bVar;
            }
            AppMethodBeat.o(48855);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            ajs ajs = (ajs) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        BaseResponse baseResponse = new BaseResponse();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = baseResponse.populateBuilderWithField(aVar4, baseResponse, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        ajs.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(48855);
                    return 0;
                case 2:
                    ajs.kdT = aVar3.BTU.vd();
                    AppMethodBeat.o(48855);
                    return 0;
                case 3:
                    ajs.kdU = aVar3.BTU.readString();
                    AppMethodBeat.o(48855);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        ask ask = new ask();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ask.populateBuilderWithField(aVar4, ask, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        ajs.vYe = ask;
                    }
                    AppMethodBeat.o(48855);
                    return 0;
                case 8:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        mu muVar = new mu();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = muVar.populateBuilderWithField(aVar4, muVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        ajs.wpq = muVar;
                    }
                    AppMethodBeat.o(48855);
                    return 0;
                case 9:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bab bab = new bab();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bab.populateBuilderWithField(aVar4, bab, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        ajs.woj = bab;
                    }
                    AppMethodBeat.o(48855);
                    return 0;
                case 10:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        asi asi = new asi();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = asi.populateBuilderWithField(aVar4, asi, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        ajs.wpr = asi;
                    }
                    AppMethodBeat.o(48855);
                    return 0;
                case 11:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        atk atk = new atk();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = atk.populateBuilderWithField(aVar4, atk, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        ajs.wps = atk;
                    }
                    AppMethodBeat.o(48855);
                    return 0;
                default:
                    AppMethodBeat.o(48855);
                    return -1;
            }
        } else {
            AppMethodBeat.o(48855);
            return -1;
        }
    }
}
