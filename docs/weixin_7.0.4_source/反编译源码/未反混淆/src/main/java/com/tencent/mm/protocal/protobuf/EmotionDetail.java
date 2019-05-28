package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public class EmotionDetail extends a {
    public String ConsumeProductID;
    public String CoverUrl;
    public EmotionDesigner EmotionDesigner;
    public String IconUrl;
    public String OldRedirectUrl;
    public String PackAuthInfo;
    public String PackCopyright;
    public String PackDesc;
    public int PackExpire;
    public int PackFlag;
    public String PackName;
    public String PackPrice;
    public int PackThumbCnt;
    public LinkedList<bts> PackThumbList = new LinkedList();
    public int PackType;
    public String PanelUrl;
    public PersonalDesigner PersonalDesigner;
    public String PriceNum;
    public String PriceType;
    public String ProductID;
    public String ShareDesc;
    public int ThumbExtCount;
    public LinkedList<PackThumbExt> ThumbExtList = new LinkedList();
    public String TimeLimitStr;
    public int Version;

    public EmotionDetail() {
        AppMethodBeat.i(62540);
        AppMethodBeat.o(62540);
    }

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(62541);
        int f;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.ProductID != null) {
                aVar.e(1, this.ProductID);
            }
            if (this.IconUrl != null) {
                aVar.e(2, this.IconUrl);
            }
            if (this.PackName != null) {
                aVar.e(3, this.PackName);
            }
            if (this.PackDesc != null) {
                aVar.e(4, this.PackDesc);
            }
            if (this.PackAuthInfo != null) {
                aVar.e(5, this.PackAuthInfo);
            }
            if (this.PackPrice != null) {
                aVar.e(6, this.PackPrice);
            }
            aVar.iz(7, this.PackType);
            aVar.iz(8, this.PackFlag);
            aVar.iz(9, this.PackThumbCnt);
            aVar.e(10, 8, this.PackThumbList);
            if (this.CoverUrl != null) {
                aVar.e(11, this.CoverUrl);
            }
            aVar.iz(12, this.PackExpire);
            if (this.PackCopyright != null) {
                aVar.e(13, this.PackCopyright);
            }
            if (this.PriceNum != null) {
                aVar.e(14, this.PriceNum);
            }
            if (this.PriceType != null) {
                aVar.e(15, this.PriceType);
            }
            if (this.PanelUrl != null) {
                aVar.e(16, this.PanelUrl);
            }
            if (this.ConsumeProductID != null) {
                aVar.e(17, this.ConsumeProductID);
            }
            aVar.iz(18, this.ThumbExtCount);
            aVar.e(19, 8, this.ThumbExtList);
            aVar.iz(20, this.Version);
            if (this.TimeLimitStr != null) {
                aVar.e(21, this.TimeLimitStr);
            }
            if (this.ShareDesc != null) {
                aVar.e(22, this.ShareDesc);
            }
            if (this.OldRedirectUrl != null) {
                aVar.e(23, this.OldRedirectUrl);
            }
            if (this.EmotionDesigner != null) {
                aVar.iy(24, this.EmotionDesigner.computeSize());
                this.EmotionDesigner.writeFields(aVar);
            }
            if (this.PersonalDesigner != null) {
                aVar.iy(25, this.PersonalDesigner.computeSize());
                this.PersonalDesigner.writeFields(aVar);
            }
            AppMethodBeat.o(62541);
            return 0;
        } else if (i == 1) {
            if (this.ProductID != null) {
                f = e.a.a.b.b.a.f(1, this.ProductID) + 0;
            } else {
                f = 0;
            }
            if (this.IconUrl != null) {
                f += e.a.a.b.b.a.f(2, this.IconUrl);
            }
            if (this.PackName != null) {
                f += e.a.a.b.b.a.f(3, this.PackName);
            }
            if (this.PackDesc != null) {
                f += e.a.a.b.b.a.f(4, this.PackDesc);
            }
            if (this.PackAuthInfo != null) {
                f += e.a.a.b.b.a.f(5, this.PackAuthInfo);
            }
            if (this.PackPrice != null) {
                f += e.a.a.b.b.a.f(6, this.PackPrice);
            }
            f = (((f + e.a.a.b.b.a.bs(7, this.PackType)) + e.a.a.b.b.a.bs(8, this.PackFlag)) + e.a.a.b.b.a.bs(9, this.PackThumbCnt)) + e.a.a.a.c(10, 8, this.PackThumbList);
            if (this.CoverUrl != null) {
                f += e.a.a.b.b.a.f(11, this.CoverUrl);
            }
            f += e.a.a.b.b.a.bs(12, this.PackExpire);
            if (this.PackCopyright != null) {
                f += e.a.a.b.b.a.f(13, this.PackCopyright);
            }
            if (this.PriceNum != null) {
                f += e.a.a.b.b.a.f(14, this.PriceNum);
            }
            if (this.PriceType != null) {
                f += e.a.a.b.b.a.f(15, this.PriceType);
            }
            if (this.PanelUrl != null) {
                f += e.a.a.b.b.a.f(16, this.PanelUrl);
            }
            if (this.ConsumeProductID != null) {
                f += e.a.a.b.b.a.f(17, this.ConsumeProductID);
            }
            f = ((f + e.a.a.b.b.a.bs(18, this.ThumbExtCount)) + e.a.a.a.c(19, 8, this.ThumbExtList)) + e.a.a.b.b.a.bs(20, this.Version);
            if (this.TimeLimitStr != null) {
                f += e.a.a.b.b.a.f(21, this.TimeLimitStr);
            }
            if (this.ShareDesc != null) {
                f += e.a.a.b.b.a.f(22, this.ShareDesc);
            }
            if (this.OldRedirectUrl != null) {
                f += e.a.a.b.b.a.f(23, this.OldRedirectUrl);
            }
            if (this.EmotionDesigner != null) {
                f += e.a.a.a.ix(24, this.EmotionDesigner.computeSize());
            }
            if (this.PersonalDesigner != null) {
                f += e.a.a.a.ix(25, this.PersonalDesigner.computeSize());
            }
            AppMethodBeat.o(62541);
            return f;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.PackThumbList.clear();
            this.ThumbExtList.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(62541);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            EmotionDetail emotionDetail = (EmotionDetail) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    emotionDetail.ProductID = aVar3.BTU.readString();
                    AppMethodBeat.o(62541);
                    return 0;
                case 2:
                    emotionDetail.IconUrl = aVar3.BTU.readString();
                    AppMethodBeat.o(62541);
                    return 0;
                case 3:
                    emotionDetail.PackName = aVar3.BTU.readString();
                    AppMethodBeat.o(62541);
                    return 0;
                case 4:
                    emotionDetail.PackDesc = aVar3.BTU.readString();
                    AppMethodBeat.o(62541);
                    return 0;
                case 5:
                    emotionDetail.PackAuthInfo = aVar3.BTU.readString();
                    AppMethodBeat.o(62541);
                    return 0;
                case 6:
                    emotionDetail.PackPrice = aVar3.BTU.readString();
                    AppMethodBeat.o(62541);
                    return 0;
                case 7:
                    emotionDetail.PackType = aVar3.BTU.vd();
                    AppMethodBeat.o(62541);
                    return 0;
                case 8:
                    emotionDetail.PackFlag = aVar3.BTU.vd();
                    AppMethodBeat.o(62541);
                    return 0;
                case 9:
                    emotionDetail.PackThumbCnt = aVar3.BTU.vd();
                    AppMethodBeat.o(62541);
                    return 0;
                case 10:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts bts = new bts();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(aVar4, bts, a.getNextFieldNumber(aVar4))) {
                        }
                        emotionDetail.PackThumbList.add(bts);
                    }
                    AppMethodBeat.o(62541);
                    return 0;
                case 11:
                    emotionDetail.CoverUrl = aVar3.BTU.readString();
                    AppMethodBeat.o(62541);
                    return 0;
                case 12:
                    emotionDetail.PackExpire = aVar3.BTU.vd();
                    AppMethodBeat.o(62541);
                    return 0;
                case 13:
                    emotionDetail.PackCopyright = aVar3.BTU.readString();
                    AppMethodBeat.o(62541);
                    return 0;
                case 14:
                    emotionDetail.PriceNum = aVar3.BTU.readString();
                    AppMethodBeat.o(62541);
                    return 0;
                case 15:
                    emotionDetail.PriceType = aVar3.BTU.readString();
                    AppMethodBeat.o(62541);
                    return 0;
                case 16:
                    emotionDetail.PanelUrl = aVar3.BTU.readString();
                    AppMethodBeat.o(62541);
                    return 0;
                case 17:
                    emotionDetail.ConsumeProductID = aVar3.BTU.readString();
                    AppMethodBeat.o(62541);
                    return 0;
                case 18:
                    emotionDetail.ThumbExtCount = aVar3.BTU.vd();
                    AppMethodBeat.o(62541);
                    return 0;
                case 19:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        PackThumbExt packThumbExt = new PackThumbExt();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = packThumbExt.populateBuilderWithField(aVar4, packThumbExt, a.getNextFieldNumber(aVar4))) {
                        }
                        emotionDetail.ThumbExtList.add(packThumbExt);
                    }
                    AppMethodBeat.o(62541);
                    return 0;
                case 20:
                    emotionDetail.Version = aVar3.BTU.vd();
                    AppMethodBeat.o(62541);
                    return 0;
                case 21:
                    emotionDetail.TimeLimitStr = aVar3.BTU.readString();
                    AppMethodBeat.o(62541);
                    return 0;
                case 22:
                    emotionDetail.ShareDesc = aVar3.BTU.readString();
                    AppMethodBeat.o(62541);
                    return 0;
                case 23:
                    emotionDetail.OldRedirectUrl = aVar3.BTU.readString();
                    AppMethodBeat.o(62541);
                    return 0;
                case 24:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        EmotionDesigner emotionDesigner = new EmotionDesigner();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emotionDesigner.populateBuilderWithField(aVar4, emotionDesigner, a.getNextFieldNumber(aVar4))) {
                        }
                        emotionDetail.EmotionDesigner = emotionDesigner;
                    }
                    AppMethodBeat.o(62541);
                    return 0;
                case 25:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        PersonalDesigner personalDesigner = new PersonalDesigner();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = personalDesigner.populateBuilderWithField(aVar4, personalDesigner, a.getNextFieldNumber(aVar4))) {
                        }
                        emotionDetail.PersonalDesigner = personalDesigner;
                    }
                    AppMethodBeat.o(62541);
                    return 0;
                default:
                    AppMethodBeat.o(62541);
                    return -1;
            }
        } else {
            AppMethodBeat.o(62541);
            return -1;
        }
    }
}
