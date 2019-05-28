package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.GetEmotionListResponse */
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
        AppMethodBeat.m2504i(62564);
        AppMethodBeat.m2505o(62564);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(62565);
        C6092b c6092b;
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(62565);
                throw c6092b;
            } else if (this.ReqBuf == null) {
                c6092b = new C6092b("Not all required fields were included: ReqBuf");
                AppMethodBeat.m2505o(62565);
                throw c6092b;
            } else {
                if (this.BaseResponse != null) {
                    c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(c6093a);
                }
                if (this.ReqBuf != null) {
                    c6093a.mo13479iy(2, this.ReqBuf.computeSize());
                    this.ReqBuf.writeFields(c6093a);
                }
                c6093a.mo13480iz(3, this.EmotionCount);
                c6093a.mo13474e(4, 8, this.EmotionList);
                if (this.Banner != null) {
                    c6093a.mo13479iy(5, this.Banner.computeSize());
                    this.Banner.writeFields(c6093a);
                }
                c6093a.mo13480iz(6, this.NewBannerCount);
                c6093a.mo13474e(7, 8, this.NewBannerList);
                c6093a.mo13480iz(8, this.CellCount);
                c6093a.mo13474e(9, 8, this.CellList);
                c6093a.mo13480iz(10, this.BannerSetCount);
                c6093a.mo13474e(11, 8, this.BannerSetList);
                c6093a.mo13480iz(12, this.TopHotNum);
                c6093a.mo13480iz(13, this.RecentHotNum);
                c6093a.mo13480iz(14, this.CellSetCount);
                c6093a.mo13474e(15, 8, this.CellSetList);
                if (this.EmotionExptConfig != null) {
                    c6093a.mo13475e(16, this.EmotionExptConfig);
                }
                AppMethodBeat.m2505o(62565);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.ReqBuf != null) {
                ix += C6087a.m9557ix(2, this.ReqBuf.computeSize());
            }
            ix = (ix + C6091a.m9572bs(3, this.EmotionCount)) + C6087a.m9552c(4, 8, this.EmotionList);
            if (this.Banner != null) {
                ix += C6087a.m9557ix(5, this.Banner.computeSize());
            }
            ix = (((((((((ix + C6091a.m9572bs(6, this.NewBannerCount)) + C6087a.m9552c(7, 8, this.NewBannerList)) + C6091a.m9572bs(8, this.CellCount)) + C6087a.m9552c(9, 8, this.CellList)) + C6091a.m9572bs(10, this.BannerSetCount)) + C6087a.m9552c(11, 8, this.BannerSetList)) + C6091a.m9572bs(12, this.TopHotNum)) + C6091a.m9572bs(13, this.RecentHotNum)) + C6091a.m9572bs(14, this.CellSetCount)) + C6087a.m9552c(15, 8, this.CellSetList);
            if (this.EmotionExptConfig != null) {
                ix += C6091a.m9575f(16, this.EmotionExptConfig);
            }
            AppMethodBeat.m2505o(62565);
            return ix;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.EmotionList.clear();
            this.NewBannerList.clear();
            this.CellList.clear();
            this.BannerSetList.clear();
            this.CellSetList.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(62565);
                throw c6092b;
            } else if (this.ReqBuf == null) {
                c6092b = new C6092b("Not all required fields were included: ReqBuf");
                AppMethodBeat.m2505o(62565);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(62565);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            GetEmotionListResponse getEmotionListResponse = (GetEmotionListResponse) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            C6086a c6086a3;
            boolean z;
            EmotionBanner emotionBanner;
            EmotionBannerSet emotionBannerSet;
            switch (intValue) {
                case 1:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        BaseResponse baseResponse = new BaseResponse();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = baseResponse.populateBuilderWithField(c6086a3, baseResponse, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        getEmotionListResponse.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(62565);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        getEmotionListResponse.ReqBuf = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(62565);
                    return 0;
                case 3:
                    getEmotionListResponse.EmotionCount = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(62565);
                    return 0;
                case 4:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        EmotionSummary emotionSummary = new EmotionSummary();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = emotionSummary.populateBuilderWithField(c6086a3, emotionSummary, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        getEmotionListResponse.EmotionList.add(emotionSummary);
                    }
                    AppMethodBeat.m2505o(62565);
                    return 0;
                case 5:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        emotionBanner = new EmotionBanner();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = emotionBanner.populateBuilderWithField(c6086a3, emotionBanner, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        getEmotionListResponse.Banner = emotionBanner;
                    }
                    AppMethodBeat.m2505o(62565);
                    return 0;
                case 6:
                    getEmotionListResponse.NewBannerCount = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(62565);
                    return 0;
                case 7:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        emotionBanner = new EmotionBanner();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = emotionBanner.populateBuilderWithField(c6086a3, emotionBanner, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        getEmotionListResponse.NewBannerList.add(emotionBanner);
                    }
                    AppMethodBeat.m2505o(62565);
                    return 0;
                case 8:
                    getEmotionListResponse.CellCount = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(62565);
                    return 0;
                case 9:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        EmotionCell emotionCell = new EmotionCell();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = emotionCell.populateBuilderWithField(c6086a3, emotionCell, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        getEmotionListResponse.CellList.add(emotionCell);
                    }
                    AppMethodBeat.m2505o(62565);
                    return 0;
                case 10:
                    getEmotionListResponse.BannerSetCount = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(62565);
                    return 0;
                case 11:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        emotionBannerSet = new EmotionBannerSet();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = emotionBannerSet.populateBuilderWithField(c6086a3, emotionBannerSet, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        getEmotionListResponse.BannerSetList.add(emotionBannerSet);
                    }
                    AppMethodBeat.m2505o(62565);
                    return 0;
                case 12:
                    getEmotionListResponse.TopHotNum = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(62565);
                    return 0;
                case 13:
                    getEmotionListResponse.RecentHotNum = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(62565);
                    return 0;
                case 14:
                    getEmotionListResponse.CellSetCount = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(62565);
                    return 0;
                case 15:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        emotionBannerSet = new EmotionBannerSet();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = emotionBannerSet.populateBuilderWithField(c6086a3, emotionBannerSet, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        getEmotionListResponse.CellSetList.add(emotionBannerSet);
                    }
                    AppMethodBeat.m2505o(62565);
                    return 0;
                case 16:
                    getEmotionListResponse.EmotionExptConfig = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(62565);
                    return 0;
                default:
                    AppMethodBeat.m2505o(62565);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(62565);
            return -1;
        }
    }
}
