package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.aml */
public final class aml extends btd {
    public String Desc;
    public LinkedList<EmotionSummary> EmotionList = new LinkedList();
    public String HeadUrl;
    public String Name;
    public SKBuiltinBuffer_t ReqBuf;
    public String vKE;
    public LinkedList<C40588xx> vKl = new LinkedList();
    public String wrl;

    public aml() {
        AppMethodBeat.m2504i(62570);
        AppMethodBeat.m2505o(62570);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(62571);
        C6092b c6092b;
        int ix;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(62571);
                throw c6092b;
            } else if (this.wrl == null) {
                c6092b = new C6092b("Not all required fields were included: BannerUrl");
                AppMethodBeat.m2505o(62571);
                throw c6092b;
            } else if (this.Name == null) {
                c6092b = new C6092b("Not all required fields were included: Name");
                AppMethodBeat.m2505o(62571);
                throw c6092b;
            } else if (this.Desc == null) {
                c6092b = new C6092b("Not all required fields were included: Desc");
                AppMethodBeat.m2505o(62571);
                throw c6092b;
            } else if (this.HeadUrl == null) {
                c6092b = new C6092b("Not all required fields were included: HeadUrl");
                AppMethodBeat.m2505o(62571);
                throw c6092b;
            } else if (this.vKE == null) {
                c6092b = new C6092b("Not all required fields were included: BizName");
                AppMethodBeat.m2505o(62571);
                throw c6092b;
            } else if (this.ReqBuf == null) {
                c6092b = new C6092b("Not all required fields were included: ReqBuf");
                AppMethodBeat.m2505o(62571);
                throw c6092b;
            } else {
                if (this.BaseResponse != null) {
                    c6093a.mo13479iy(1, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(c6093a);
                }
                if (this.wrl != null) {
                    c6093a.mo13475e(2, this.wrl);
                }
                if (this.Name != null) {
                    c6093a.mo13475e(3, this.Name);
                }
                if (this.Desc != null) {
                    c6093a.mo13475e(4, this.Desc);
                }
                if (this.HeadUrl != null) {
                    c6093a.mo13475e(5, this.HeadUrl);
                }
                if (this.vKE != null) {
                    c6093a.mo13475e(6, this.vKE);
                }
                c6093a.mo13474e(7, 8, this.EmotionList);
                if (this.ReqBuf != null) {
                    c6093a.mo13479iy(8, this.ReqBuf.computeSize());
                    this.ReqBuf.writeFields(c6093a);
                }
                c6093a.mo13474e(9, 8, this.vKl);
                AppMethodBeat.m2505o(62571);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = C6087a.m9557ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wrl != null) {
                ix += C6091a.m9575f(2, this.wrl);
            }
            if (this.Name != null) {
                ix += C6091a.m9575f(3, this.Name);
            }
            if (this.Desc != null) {
                ix += C6091a.m9575f(4, this.Desc);
            }
            if (this.HeadUrl != null) {
                ix += C6091a.m9575f(5, this.HeadUrl);
            }
            if (this.vKE != null) {
                ix += C6091a.m9575f(6, this.vKE);
            }
            ix += C6087a.m9552c(7, 8, this.EmotionList);
            if (this.ReqBuf != null) {
                ix += C6087a.m9557ix(8, this.ReqBuf.computeSize());
            }
            int c = ix + C6087a.m9552c(9, 8, this.vKl);
            AppMethodBeat.m2505o(62571);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.EmotionList.clear();
            this.vKl.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.BaseResponse == null) {
                c6092b = new C6092b("Not all required fields were included: BaseResponse");
                AppMethodBeat.m2505o(62571);
                throw c6092b;
            } else if (this.wrl == null) {
                c6092b = new C6092b("Not all required fields were included: BannerUrl");
                AppMethodBeat.m2505o(62571);
                throw c6092b;
            } else if (this.Name == null) {
                c6092b = new C6092b("Not all required fields were included: Name");
                AppMethodBeat.m2505o(62571);
                throw c6092b;
            } else if (this.Desc == null) {
                c6092b = new C6092b("Not all required fields were included: Desc");
                AppMethodBeat.m2505o(62571);
                throw c6092b;
            } else if (this.HeadUrl == null) {
                c6092b = new C6092b("Not all required fields were included: HeadUrl");
                AppMethodBeat.m2505o(62571);
                throw c6092b;
            } else if (this.vKE == null) {
                c6092b = new C6092b("Not all required fields were included: BizName");
                AppMethodBeat.m2505o(62571);
                throw c6092b;
            } else if (this.ReqBuf == null) {
                c6092b = new C6092b("Not all required fields were included: ReqBuf");
                AppMethodBeat.m2505o(62571);
                throw c6092b;
            } else {
                AppMethodBeat.m2505o(62571);
                return 0;
            }
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            aml aml = (aml) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            C6086a c6086a3;
            boolean z;
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
                        aml.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.m2505o(62571);
                    return 0;
                case 2:
                    aml.wrl = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(62571);
                    return 0;
                case 3:
                    aml.Name = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(62571);
                    return 0;
                case 4:
                    aml.Desc = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(62571);
                    return 0;
                case 5:
                    aml.HeadUrl = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(62571);
                    return 0;
                case 6:
                    aml.vKE = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(62571);
                    return 0;
                case 7:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        EmotionSummary emotionSummary = new EmotionSummary();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = emotionSummary.populateBuilderWithField(c6086a3, emotionSummary, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        aml.EmotionList.add(emotionSummary);
                    }
                    AppMethodBeat.m2505o(62571);
                    return 0;
                case 8:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(c6086a3, sKBuiltinBuffer_t, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        aml.ReqBuf = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.m2505o(62571);
                    return 0;
                case 9:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        C40588xx c40588xx = new C40588xx();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = c40588xx.populateBuilderWithField(c6086a3, c40588xx, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        aml.vKl.add(c40588xx);
                    }
                    AppMethodBeat.m2505o(62571);
                    return 0;
                default:
                    AppMethodBeat.m2505o(62571);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(62571);
            return -1;
        }
    }
}
