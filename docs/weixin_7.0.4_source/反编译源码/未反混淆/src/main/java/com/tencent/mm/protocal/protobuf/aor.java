package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class aor extends btd {
    public int jBv;
    public LinkedList<bts> jBw = new LinkedList();
    public String wsL;
    public SKBuiltinBuffer_t wsO;
    public int wsP;

    public aor() {
        AppMethodBeat.i(73717);
        AppMethodBeat.o(73717);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(73718);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(73718);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.iz(2, this.jBv);
            aVar.e(3, 8, this.jBw);
            if (this.wsL != null) {
                aVar.e(4, this.wsL);
            }
            if (this.wsO != null) {
                aVar.iy(5, this.wsO.computeSize());
                this.wsO.writeFields(aVar);
            }
            aVar.iz(6, this.wsP);
            AppMethodBeat.o(73718);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (ix + e.a.a.b.b.a.bs(2, this.jBv)) + e.a.a.a.c(3, 8, this.jBw);
            if (this.wsL != null) {
                ix += e.a.a.b.b.a.f(4, this.wsL);
            }
            if (this.wsO != null) {
                ix += e.a.a.a.ix(5, this.wsO.computeSize());
            }
            int bs = ix + e.a.a.b.b.a.bs(6, this.wsP);
            AppMethodBeat.o(73718);
            return bs;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.jBw.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(73718);
                throw bVar;
            }
            AppMethodBeat.o(73718);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aor aor = (aor) objArr[1];
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
                        aor.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(73718);
                    return 0;
                case 2:
                    aor.jBv = aVar3.BTU.vd();
                    AppMethodBeat.o(73718);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        aor.jBw.add(bts);
                    }
                    AppMethodBeat.o(73718);
                    return 0;
                case 4:
                    aor.wsL = aVar3.BTU.readString();
                    AppMethodBeat.o(73718);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        aor.wsO = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(73718);
                    return 0;
                case 6:
                    aor.wsP = aVar3.BTU.vd();
                    AppMethodBeat.o(73718);
                    return 0;
                default:
                    AppMethodBeat.o(73718);
                    return -1;
            }
        } else {
            AppMethodBeat.o(73718);
            return -1;
        }
    }
}
