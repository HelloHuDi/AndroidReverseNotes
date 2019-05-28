package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class aph extends btd {
    public int wti;
    public String wtj;
    public int wtk;
    public String wtl;
    public int wtm;
    public LinkedList<bts> wtn = new LinkedList();
    public String wto;
    public int wtp;
    public String wtq;
    public int wtr;
    public SKBuiltinBuffer_t wts;

    public aph() {
        AppMethodBeat.i(80102);
        AppMethodBeat.o(80102);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(80103);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(80103);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.iz(2, this.wti);
            if (this.wtj != null) {
                aVar.e(3, this.wtj);
            }
            aVar.iz(4, this.wtk);
            if (this.wtl != null) {
                aVar.e(5, this.wtl);
            }
            aVar.iz(6, this.wtm);
            aVar.e(7, 8, this.wtn);
            if (this.wto != null) {
                aVar.e(8, this.wto);
            }
            aVar.iz(9, this.wtp);
            if (this.wtq != null) {
                aVar.e(10, this.wtq);
            }
            aVar.iz(11, this.wtr);
            if (this.wts != null) {
                aVar.iy(12, this.wts.computeSize());
                this.wts.writeFields(aVar);
            }
            AppMethodBeat.o(80103);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix += e.a.a.b.b.a.bs(2, this.wti);
            if (this.wtj != null) {
                ix += e.a.a.b.b.a.f(3, this.wtj);
            }
            ix += e.a.a.b.b.a.bs(4, this.wtk);
            if (this.wtl != null) {
                ix += e.a.a.b.b.a.f(5, this.wtl);
            }
            ix = (ix + e.a.a.b.b.a.bs(6, this.wtm)) + e.a.a.a.c(7, 8, this.wtn);
            if (this.wto != null) {
                ix += e.a.a.b.b.a.f(8, this.wto);
            }
            ix += e.a.a.b.b.a.bs(9, this.wtp);
            if (this.wtq != null) {
                ix += e.a.a.b.b.a.f(10, this.wtq);
            }
            ix += e.a.a.b.b.a.bs(11, this.wtr);
            if (this.wts != null) {
                ix += e.a.a.a.ix(12, this.wts.computeSize());
            }
            AppMethodBeat.o(80103);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wtn.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(80103);
                throw bVar;
            }
            AppMethodBeat.o(80103);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aph aph = (aph) objArr[1];
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
                        BaseResponse baseResponse = new BaseResponse();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = baseResponse.populateBuilderWithField(aVar4, baseResponse, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        aph.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(80103);
                    return 0;
                case 2:
                    aph.wti = aVar3.BTU.vd();
                    AppMethodBeat.o(80103);
                    return 0;
                case 3:
                    aph.wtj = aVar3.BTU.readString();
                    AppMethodBeat.o(80103);
                    return 0;
                case 4:
                    aph.wtk = aVar3.BTU.vd();
                    AppMethodBeat.o(80103);
                    return 0;
                case 5:
                    aph.wtl = aVar3.BTU.readString();
                    AppMethodBeat.o(80103);
                    return 0;
                case 6:
                    aph.wtm = aVar3.BTU.vd();
                    AppMethodBeat.o(80103);
                    return 0;
                case 7:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        aph.wtn.add(bts);
                    }
                    AppMethodBeat.o(80103);
                    return 0;
                case 8:
                    aph.wto = aVar3.BTU.readString();
                    AppMethodBeat.o(80103);
                    return 0;
                case 9:
                    aph.wtp = aVar3.BTU.vd();
                    AppMethodBeat.o(80103);
                    return 0;
                case 10:
                    aph.wtq = aVar3.BTU.readString();
                    AppMethodBeat.o(80103);
                    return 0;
                case 11:
                    aph.wtr = aVar3.BTU.vd();
                    AppMethodBeat.o(80103);
                    return 0;
                case 12:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        aph.wts = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(80103);
                    return 0;
                default:
                    AppMethodBeat.o(80103);
                    return -1;
            }
        } else {
            AppMethodBeat.o(80103);
            return -1;
        }
    }
}
