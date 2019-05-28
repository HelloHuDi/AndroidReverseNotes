package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class aml extends btd {
    public String Desc;
    public LinkedList<EmotionSummary> EmotionList = new LinkedList();
    public String HeadUrl;
    public String Name;
    public SKBuiltinBuffer_t ReqBuf;
    public String vKE;
    public LinkedList<xx> vKl = new LinkedList();
    public String wrl;

    public aml() {
        AppMethodBeat.i(62570);
        AppMethodBeat.o(62570);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(62571);
        b bVar;
        int ix;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(62571);
                throw bVar;
            } else if (this.wrl == null) {
                bVar = new b("Not all required fields were included: BannerUrl");
                AppMethodBeat.o(62571);
                throw bVar;
            } else if (this.Name == null) {
                bVar = new b("Not all required fields were included: Name");
                AppMethodBeat.o(62571);
                throw bVar;
            } else if (this.Desc == null) {
                bVar = new b("Not all required fields were included: Desc");
                AppMethodBeat.o(62571);
                throw bVar;
            } else if (this.HeadUrl == null) {
                bVar = new b("Not all required fields were included: HeadUrl");
                AppMethodBeat.o(62571);
                throw bVar;
            } else if (this.vKE == null) {
                bVar = new b("Not all required fields were included: BizName");
                AppMethodBeat.o(62571);
                throw bVar;
            } else if (this.ReqBuf == null) {
                bVar = new b("Not all required fields were included: ReqBuf");
                AppMethodBeat.o(62571);
                throw bVar;
            } else {
                if (this.BaseResponse != null) {
                    aVar.iy(1, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(aVar);
                }
                if (this.wrl != null) {
                    aVar.e(2, this.wrl);
                }
                if (this.Name != null) {
                    aVar.e(3, this.Name);
                }
                if (this.Desc != null) {
                    aVar.e(4, this.Desc);
                }
                if (this.HeadUrl != null) {
                    aVar.e(5, this.HeadUrl);
                }
                if (this.vKE != null) {
                    aVar.e(6, this.vKE);
                }
                aVar.e(7, 8, this.EmotionList);
                if (this.ReqBuf != null) {
                    aVar.iy(8, this.ReqBuf.computeSize());
                    this.ReqBuf.writeFields(aVar);
                }
                aVar.e(9, 8, this.vKl);
                AppMethodBeat.o(62571);
                return 0;
            }
        } else if (i == 1) {
            if (this.BaseResponse != null) {
                ix = e.a.a.a.ix(1, this.BaseResponse.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.wrl != null) {
                ix += e.a.a.b.b.a.f(2, this.wrl);
            }
            if (this.Name != null) {
                ix += e.a.a.b.b.a.f(3, this.Name);
            }
            if (this.Desc != null) {
                ix += e.a.a.b.b.a.f(4, this.Desc);
            }
            if (this.HeadUrl != null) {
                ix += e.a.a.b.b.a.f(5, this.HeadUrl);
            }
            if (this.vKE != null) {
                ix += e.a.a.b.b.a.f(6, this.vKE);
            }
            ix += e.a.a.a.c(7, 8, this.EmotionList);
            if (this.ReqBuf != null) {
                ix += e.a.a.a.ix(8, this.ReqBuf.computeSize());
            }
            int c = ix + e.a.a.a.c(9, 8, this.vKl);
            AppMethodBeat.o(62571);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.EmotionList.clear();
            this.vKl.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2); ix > 0; ix = com.tencent.mm.bt.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BaseResponse == null) {
                bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(62571);
                throw bVar;
            } else if (this.wrl == null) {
                bVar = new b("Not all required fields were included: BannerUrl");
                AppMethodBeat.o(62571);
                throw bVar;
            } else if (this.Name == null) {
                bVar = new b("Not all required fields were included: Name");
                AppMethodBeat.o(62571);
                throw bVar;
            } else if (this.Desc == null) {
                bVar = new b("Not all required fields were included: Desc");
                AppMethodBeat.o(62571);
                throw bVar;
            } else if (this.HeadUrl == null) {
                bVar = new b("Not all required fields were included: HeadUrl");
                AppMethodBeat.o(62571);
                throw bVar;
            } else if (this.vKE == null) {
                bVar = new b("Not all required fields were included: BizName");
                AppMethodBeat.o(62571);
                throw bVar;
            } else if (this.ReqBuf == null) {
                bVar = new b("Not all required fields were included: ReqBuf");
                AppMethodBeat.o(62571);
                throw bVar;
            } else {
                AppMethodBeat.o(62571);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            aml aml = (aml) objArr[1];
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
                        aml.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(62571);
                    return 0;
                case 2:
                    aml.wrl = aVar3.BTU.readString();
                    AppMethodBeat.o(62571);
                    return 0;
                case 3:
                    aml.Name = aVar3.BTU.readString();
                    AppMethodBeat.o(62571);
                    return 0;
                case 4:
                    aml.Desc = aVar3.BTU.readString();
                    AppMethodBeat.o(62571);
                    return 0;
                case 5:
                    aml.HeadUrl = aVar3.BTU.readString();
                    AppMethodBeat.o(62571);
                    return 0;
                case 6:
                    aml.vKE = aVar3.BTU.readString();
                    AppMethodBeat.o(62571);
                    return 0;
                case 7:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        EmotionSummary emotionSummary = new EmotionSummary();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emotionSummary.populateBuilderWithField(aVar4, emotionSummary, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        aml.EmotionList.add(emotionSummary);
                    }
                    AppMethodBeat.o(62571);
                    return 0;
                case 8:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        aml.ReqBuf = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(62571);
                    return 0;
                case 9:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        xx xxVar = new xx();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = xxVar.populateBuilderWithField(aVar4, xxVar, com.tencent.mm.bt.a.getNextFieldNumber(aVar4))) {
                        }
                        aml.vKl.add(xxVar);
                    }
                    AppMethodBeat.o(62571);
                    return 0;
                default:
                    AppMethodBeat.o(62571);
                    return -1;
            }
        } else {
            AppMethodBeat.o(62571);
            return -1;
        }
    }
}
