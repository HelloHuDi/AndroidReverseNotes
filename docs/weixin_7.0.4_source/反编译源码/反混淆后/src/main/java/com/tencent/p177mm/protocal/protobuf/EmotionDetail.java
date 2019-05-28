package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.EmotionDetail */
public class EmotionDetail extends C1331a {
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
        AppMethodBeat.m2504i(62540);
        AppMethodBeat.m2505o(62540);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(62541);
        int f;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.ProductID != null) {
                c6093a.mo13475e(1, this.ProductID);
            }
            if (this.IconUrl != null) {
                c6093a.mo13475e(2, this.IconUrl);
            }
            if (this.PackName != null) {
                c6093a.mo13475e(3, this.PackName);
            }
            if (this.PackDesc != null) {
                c6093a.mo13475e(4, this.PackDesc);
            }
            if (this.PackAuthInfo != null) {
                c6093a.mo13475e(5, this.PackAuthInfo);
            }
            if (this.PackPrice != null) {
                c6093a.mo13475e(6, this.PackPrice);
            }
            c6093a.mo13480iz(7, this.PackType);
            c6093a.mo13480iz(8, this.PackFlag);
            c6093a.mo13480iz(9, this.PackThumbCnt);
            c6093a.mo13474e(10, 8, this.PackThumbList);
            if (this.CoverUrl != null) {
                c6093a.mo13475e(11, this.CoverUrl);
            }
            c6093a.mo13480iz(12, this.PackExpire);
            if (this.PackCopyright != null) {
                c6093a.mo13475e(13, this.PackCopyright);
            }
            if (this.PriceNum != null) {
                c6093a.mo13475e(14, this.PriceNum);
            }
            if (this.PriceType != null) {
                c6093a.mo13475e(15, this.PriceType);
            }
            if (this.PanelUrl != null) {
                c6093a.mo13475e(16, this.PanelUrl);
            }
            if (this.ConsumeProductID != null) {
                c6093a.mo13475e(17, this.ConsumeProductID);
            }
            c6093a.mo13480iz(18, this.ThumbExtCount);
            c6093a.mo13474e(19, 8, this.ThumbExtList);
            c6093a.mo13480iz(20, this.Version);
            if (this.TimeLimitStr != null) {
                c6093a.mo13475e(21, this.TimeLimitStr);
            }
            if (this.ShareDesc != null) {
                c6093a.mo13475e(22, this.ShareDesc);
            }
            if (this.OldRedirectUrl != null) {
                c6093a.mo13475e(23, this.OldRedirectUrl);
            }
            if (this.EmotionDesigner != null) {
                c6093a.mo13479iy(24, this.EmotionDesigner.computeSize());
                this.EmotionDesigner.writeFields(c6093a);
            }
            if (this.PersonalDesigner != null) {
                c6093a.mo13479iy(25, this.PersonalDesigner.computeSize());
                this.PersonalDesigner.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(62541);
            return 0;
        } else if (i == 1) {
            if (this.ProductID != null) {
                f = C6091a.m9575f(1, this.ProductID) + 0;
            } else {
                f = 0;
            }
            if (this.IconUrl != null) {
                f += C6091a.m9575f(2, this.IconUrl);
            }
            if (this.PackName != null) {
                f += C6091a.m9575f(3, this.PackName);
            }
            if (this.PackDesc != null) {
                f += C6091a.m9575f(4, this.PackDesc);
            }
            if (this.PackAuthInfo != null) {
                f += C6091a.m9575f(5, this.PackAuthInfo);
            }
            if (this.PackPrice != null) {
                f += C6091a.m9575f(6, this.PackPrice);
            }
            f = (((f + C6091a.m9572bs(7, this.PackType)) + C6091a.m9572bs(8, this.PackFlag)) + C6091a.m9572bs(9, this.PackThumbCnt)) + C6087a.m9552c(10, 8, this.PackThumbList);
            if (this.CoverUrl != null) {
                f += C6091a.m9575f(11, this.CoverUrl);
            }
            f += C6091a.m9572bs(12, this.PackExpire);
            if (this.PackCopyright != null) {
                f += C6091a.m9575f(13, this.PackCopyright);
            }
            if (this.PriceNum != null) {
                f += C6091a.m9575f(14, this.PriceNum);
            }
            if (this.PriceType != null) {
                f += C6091a.m9575f(15, this.PriceType);
            }
            if (this.PanelUrl != null) {
                f += C6091a.m9575f(16, this.PanelUrl);
            }
            if (this.ConsumeProductID != null) {
                f += C6091a.m9575f(17, this.ConsumeProductID);
            }
            f = ((f + C6091a.m9572bs(18, this.ThumbExtCount)) + C6087a.m9552c(19, 8, this.ThumbExtList)) + C6091a.m9572bs(20, this.Version);
            if (this.TimeLimitStr != null) {
                f += C6091a.m9575f(21, this.TimeLimitStr);
            }
            if (this.ShareDesc != null) {
                f += C6091a.m9575f(22, this.ShareDesc);
            }
            if (this.OldRedirectUrl != null) {
                f += C6091a.m9575f(23, this.OldRedirectUrl);
            }
            if (this.EmotionDesigner != null) {
                f += C6087a.m9557ix(24, this.EmotionDesigner.computeSize());
            }
            if (this.PersonalDesigner != null) {
                f += C6087a.m9557ix(25, this.PersonalDesigner.computeSize());
            }
            AppMethodBeat.m2505o(62541);
            return f;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.PackThumbList.clear();
            this.ThumbExtList.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(62541);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            EmotionDetail emotionDetail = (EmotionDetail) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    emotionDetail.ProductID = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(62541);
                    return 0;
                case 2:
                    emotionDetail.IconUrl = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(62541);
                    return 0;
                case 3:
                    emotionDetail.PackName = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(62541);
                    return 0;
                case 4:
                    emotionDetail.PackDesc = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(62541);
                    return 0;
                case 5:
                    emotionDetail.PackAuthInfo = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(62541);
                    return 0;
                case 6:
                    emotionDetail.PackPrice = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(62541);
                    return 0;
                case 7:
                    emotionDetail.PackType = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(62541);
                    return 0;
                case 8:
                    emotionDetail.PackFlag = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(62541);
                    return 0;
                case 9:
                    emotionDetail.PackThumbCnt = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(62541);
                    return 0;
                case 10:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bts bts = new bts();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bts.populateBuilderWithField(c6086a3, bts, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        emotionDetail.PackThumbList.add(bts);
                    }
                    AppMethodBeat.m2505o(62541);
                    return 0;
                case 11:
                    emotionDetail.CoverUrl = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(62541);
                    return 0;
                case 12:
                    emotionDetail.PackExpire = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(62541);
                    return 0;
                case 13:
                    emotionDetail.PackCopyright = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(62541);
                    return 0;
                case 14:
                    emotionDetail.PriceNum = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(62541);
                    return 0;
                case 15:
                    emotionDetail.PriceType = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(62541);
                    return 0;
                case 16:
                    emotionDetail.PanelUrl = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(62541);
                    return 0;
                case 17:
                    emotionDetail.ConsumeProductID = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(62541);
                    return 0;
                case 18:
                    emotionDetail.ThumbExtCount = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(62541);
                    return 0;
                case 19:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        PackThumbExt packThumbExt = new PackThumbExt();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = packThumbExt.populateBuilderWithField(c6086a3, packThumbExt, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        emotionDetail.ThumbExtList.add(packThumbExt);
                    }
                    AppMethodBeat.m2505o(62541);
                    return 0;
                case 20:
                    emotionDetail.Version = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(62541);
                    return 0;
                case 21:
                    emotionDetail.TimeLimitStr = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(62541);
                    return 0;
                case 22:
                    emotionDetail.ShareDesc = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(62541);
                    return 0;
                case 23:
                    emotionDetail.OldRedirectUrl = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(62541);
                    return 0;
                case 24:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        EmotionDesigner emotionDesigner = new EmotionDesigner();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = emotionDesigner.populateBuilderWithField(c6086a3, emotionDesigner, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        emotionDetail.EmotionDesigner = emotionDesigner;
                    }
                    AppMethodBeat.m2505o(62541);
                    return 0;
                case 25:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        PersonalDesigner personalDesigner = new PersonalDesigner();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = personalDesigner.populateBuilderWithField(c6086a3, personalDesigner, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        emotionDetail.PersonalDesigner = personalDesigner;
                    }
                    AppMethodBeat.m2505o(62541);
                    return 0;
                default:
                    AppMethodBeat.m2505o(62541);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(62541);
            return -1;
        }
    }
}
