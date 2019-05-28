package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public class GetEmotionListResponse extends btd {
    public EmotionBanner Banner;
    public int BannerSetCount;
    public LinkedList<EmotionBannerSet> BannerSetList = new LinkedList();
    public int CellCount;
    public LinkedList<EmotionCell> CellList = new LinkedList();
    public int CellSetCount;
    public LinkedList<EmotionBannerSet> CellSetList = new LinkedList();
    public int EmotionCount;
    public String EmotionExptConfig;
    public LinkedList<EmotionSummary> EmotionList = new LinkedList();
    public int NewBannerCount;
    public LinkedList<EmotionBanner> NewBannerList = new LinkedList();
    public int RecentHotNum;
    public SKBuiltinBuffer_t ReqBuf;
    public int TopHotNum;

    public GetEmotionListResponse() {
        AppMethodBeat.i(62564);
        AppMethodBeat.o(62564);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(62565);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(62565);
                throw bVar;
            } else if (this.ReqBuf == null) {
                bVar = new b("Not all required fields were included: ReqBuf");
                AppMethodBeat.o(62565);
                throw bVar;
            } else {
                if (this.BaseResponse != null) {
                    aVar.iy(1, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(aVar);
                }
                if (this.ReqBuf != null) {
                    aVar.iy(2, this.ReqBuf.computeSize());
                    this.ReqBuf.writeFields(aVar);
                }
                aVar.iz(3, this.EmotionCount);
                aVar.e(4, 8, this.EmotionList);
                if (this.Banner != null) {
                    aVar.iy(5, this.Banner.computeSize());
                    this.Banner.writeFields(aVar);
                }
                aVar.iz(6, this.NewBannerCount);
                aVar.e(7, 8, this.NewBannerList);
                aVar.iz(8, this.CellCount);
                aVar.e(9, 8, this.CellList);
                aVar.iz(10, this.BannerSetCount);
                aVar.e(11, 8, this.BannerSetList);
                aVar.iz(12, this.TopHotNum);
                aVar.iz(13, this.RecentHotNum);
                aVar.iz(14, this.CellSetCount);
                aVar.e(15, 8, this.CellSetList);
                if (this.EmotionExptConfig != null) {
                    aVar.e(16, this.EmotionExptConfig);
                }
                AppMethodBeat.o(62565);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.ReqBuf != null) {
                ix += e.a.a.a.ix(2, this.ReqBuf.computeSize());
            }
            ix = (ix + e.a.a.b.b.a.bs(3, this.EmotionCount)) + e.a.a.a.c(4, 8, this.EmotionList);
            if (this.Banner != null) {
                ix += e.a.a.a.ix(5, this.Banner.computeSize());
            }
            ix = (((((((((ix + e.a.a.b.b.a.bs(6, this.NewBannerCount)) + e.a.a.a.c(7, 8, this.NewBannerList)) + e.a.a.b.b.a.bs(8, this.CellCount)) + e.a.a.a.c(9, 8, this.CellList)) + e.a.a.b.b.a.bs(10, this.BannerSetCount)) + e.a.a.a.c(11, 8, this.BannerSetList)) + e.a.a.b.b.a.bs(12, this.TopHotNum)) + e.a.a.b.b.a.bs(13, this.RecentHotNum)) + e.a.a.b.b.a.bs(14, this.CellSetCount)) + e.a.a.a.c(15, 8, this.CellSetList);
            if (this.EmotionExptConfig != null) {
                ix += e.a.a.b.b.a.f(16, this.EmotionExptConfig);
            }
            AppMethodBeat.o(62565);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.EmotionList.clear();
            this.NewBannerList.clear();
            this.CellList.clear();
            this.BannerSetList.clear();
            this.CellSetList.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(62565);
                throw bVar;
            } else if (this.ReqBuf == null) {
                bVar = new b("Not all required fields were included: ReqBuf");
                AppMethodBeat.o(62565);
                throw bVar;
            } else {
                AppMethodBeat.o(62565);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            GetEmotionListResponse getEmotionListResponse = (GetEmotionListResponse) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            e.a.a.a.a aVar4;
            boolean z;
            EmotionBanner emotionBanner;
            EmotionBannerSet emotionBannerSet;
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
                        getEmotionListResponse.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(62565);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        getEmotionListResponse.ReqBuf = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(62565);
                    return 0;
                case 3:
                    getEmotionListResponse.EmotionCount = aVar3.BTU.vd();
                    AppMethodBeat.o(62565);
                    return 0;
                case 4:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        EmotionSummary emotionSummary = new EmotionSummary();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emotionSummary.populateBuilderWithField(aVar4, emotionSummary, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        getEmotionListResponse.EmotionList.add(emotionSummary);
                    }
                    AppMethodBeat.o(62565);
                    return 0;
                case 5:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        emotionBanner = new EmotionBanner();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emotionBanner.populateBuilderWithField(aVar4, emotionBanner, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        getEmotionListResponse.Banner = emotionBanner;
                    }
                    AppMethodBeat.o(62565);
                    return 0;
                case 6:
                    getEmotionListResponse.NewBannerCount = aVar3.BTU.vd();
                    AppMethodBeat.o(62565);
                    return 0;
                case 7:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        emotionBanner = new EmotionBanner();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emotionBanner.populateBuilderWithField(aVar4, emotionBanner, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        getEmotionListResponse.NewBannerList.add(emotionBanner);
                    }
                    AppMethodBeat.o(62565);
                    return 0;
                case 8:
                    getEmotionListResponse.CellCount = aVar3.BTU.vd();
                    AppMethodBeat.o(62565);
                    return 0;
                case 9:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        EmotionCell emotionCell = new EmotionCell();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emotionCell.populateBuilderWithField(aVar4, emotionCell, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        getEmotionListResponse.CellList.add(emotionCell);
                    }
                    AppMethodBeat.o(62565);
                    return 0;
                case 10:
                    getEmotionListResponse.BannerSetCount = aVar3.BTU.vd();
                    AppMethodBeat.o(62565);
                    return 0;
                case 11:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        emotionBannerSet = new EmotionBannerSet();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emotionBannerSet.populateBuilderWithField(aVar4, emotionBannerSet, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        getEmotionListResponse.BannerSetList.add(emotionBannerSet);
                    }
                    AppMethodBeat.o(62565);
                    return 0;
                case 12:
                    getEmotionListResponse.TopHotNum = aVar3.BTU.vd();
                    AppMethodBeat.o(62565);
                    return 0;
                case 13:
                    getEmotionListResponse.RecentHotNum = aVar3.BTU.vd();
                    AppMethodBeat.o(62565);
                    return 0;
                case 14:
                    getEmotionListResponse.CellSetCount = aVar3.BTU.vd();
                    AppMethodBeat.o(62565);
                    return 0;
                case 15:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        emotionBannerSet = new EmotionBannerSet();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emotionBannerSet.populateBuilderWithField(aVar4, emotionBannerSet, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        getEmotionListResponse.CellSetList.add(emotionBannerSet);
                    }
                    AppMethodBeat.o(62565);
                    return 0;
                case 16:
                    getEmotionListResponse.EmotionExptConfig = aVar3.BTU.readString();
                    AppMethodBeat.o(62565);
                    return 0;
                default:
                    AppMethodBeat.o(62565);
                    return -1;
            }
        } else {
            AppMethodBeat.o(62565);
            return -1;
        }
    }
}
