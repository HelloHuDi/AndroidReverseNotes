package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public class GetEmotionRewardResponse extends btd {
    public int DonorNum;
    public LinkedList<EmotionDonor> Donors = new LinkedList();
    public LinkedList<EmotionPrice> Price = new LinkedList();
    public yi Reward;

    public GetEmotionRewardResponse() {
        AppMethodBeat.i(62567);
        AppMethodBeat.o(62567);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(62568);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(62568);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.iy(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.e(2, 8, this.Price);
            aVar.iz(3, this.DonorNum);
            aVar.e(4, 8, this.Donors);
            if (this.Reward != null) {
                aVar.iy(5, this.Reward.computeSize());
                this.Reward.writeFields(aVar);
            }
            AppMethodBeat.o(62568);
            return 0;
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            ix = ((ix + e.a.a.a.c(2, 8, this.Price)) + e.a.a.b.b.a.bs(3, this.DonorNum)) + e.a.a.a.c(4, 8, this.Donors);
            if (this.Reward != null) {
                ix += e.a.a.a.ix(5, this.Reward.computeSize());
            }
            AppMethodBeat.o(62568);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.Price.clear();
            this.Donors.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(62568);
                throw bVar;
            }
            AppMethodBeat.o(62568);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            GetEmotionRewardResponse getEmotionRewardResponse = (GetEmotionRewardResponse) objArr[1];
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
                        getEmotionRewardResponse.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(62568);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        EmotionPrice emotionPrice = new EmotionPrice();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emotionPrice.populateBuilderWithField(aVar4, emotionPrice, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        getEmotionRewardResponse.Price.add(emotionPrice);
                    }
                    AppMethodBeat.o(62568);
                    return 0;
                case 3:
                    getEmotionRewardResponse.DonorNum = aVar3.BTU.vd();
                    AppMethodBeat.o(62568);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        EmotionDonor emotionDonor = new EmotionDonor();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emotionDonor.populateBuilderWithField(aVar4, emotionDonor, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        getEmotionRewardResponse.Donors.add(emotionDonor);
                    }
                    AppMethodBeat.o(62568);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        yi yiVar = new yi();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = yiVar.populateBuilderWithField(aVar4, yiVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        getEmotionRewardResponse.Reward = yiVar;
                    }
                    AppMethodBeat.o(62568);
                    return 0;
                default:
                    AppMethodBeat.o(62568);
                    return -1;
            }
        } else {
            AppMethodBeat.o(62568);
            return -1;
        }
    }
}
