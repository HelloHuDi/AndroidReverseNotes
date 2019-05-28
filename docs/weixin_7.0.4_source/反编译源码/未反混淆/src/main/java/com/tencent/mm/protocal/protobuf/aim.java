package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class aim extends btd {
    public int DonorNum;
    public LinkedList<EmotionDonor> Donors = new LinkedList();
    public SKBuiltinBuffer_t vFq;

    public aim() {
        AppMethodBeat.i(62561);
        AppMethodBeat.o(62561);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(62562);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(62562);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.iz(2, this.DonorNum);
            aVar.e(3, 8, this.Donors);
            if (this.vFq != null) {
                aVar.iy(4, this.vFq.computeSize());
                this.vFq.writeFields(aVar);
            }
            AppMethodBeat.o(62562);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = (ix + e.a.a.b.b.a.bs(2, this.DonorNum)) + e.a.a.a.c(3, 8, this.Donors);
            if (this.vFq != null) {
                ix += e.a.a.a.ix(4, this.vFq.computeSize());
            }
            AppMethodBeat.o(62562);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.Donors.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(62562);
                throw bVar;
            }
            AppMethodBeat.o(62562);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aim aim = (aim) objArr[1];
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
                        aim.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(62562);
                    return 0;
                case 2:
                    aim.DonorNum = aVar3.BTU.vd();
                    AppMethodBeat.o(62562);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        EmotionDonor emotionDonor = new EmotionDonor();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emotionDonor.populateBuilderWithField(aVar4, emotionDonor, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        aim.Donors.add(emotionDonor);
                    }
                    AppMethodBeat.o(62562);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        aim.vFq = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(62562);
                    return 0;
                default:
                    AppMethodBeat.o(62562);
                    return -1;
            }
        } else {
            AppMethodBeat.o(62562);
            return -1;
        }
    }
}
