package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.EmotionSummary */
public class EmotionSummary extends C1331a {
    public String CoverUrl;
    public String ExptDesc;
    public String IconUrl;
    public String Introduce;
    public String PackAuthInfo;
    public String PackCopyright;
    public String PackDesc;
    public int PackExpire;
    public int PackFlag;
    public String PackName;
    public String PackPrice;
    public int PackType;
    public String PanelUrl;
    public String PriceNum;
    public String PriceType;
    public String ProductID;
    public String SendInfo;
    public String TagUri;
    public String TimeLimitStr;
    public int Timestamp;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(62545);
        int f;
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
            if (this.CoverUrl != null) {
                c6093a.mo13475e(9, this.CoverUrl);
            }
            c6093a.mo13480iz(10, this.PackExpire);
            if (this.PackCopyright != null) {
                c6093a.mo13475e(11, this.PackCopyright);
            }
            c6093a.mo13480iz(12, this.Timestamp);
            if (this.PanelUrl != null) {
                c6093a.mo13475e(13, this.PanelUrl);
            }
            if (this.PriceNum != null) {
                c6093a.mo13475e(14, this.PriceNum);
            }
            if (this.PriceType != null) {
                c6093a.mo13475e(15, this.PriceType);
            }
            if (this.SendInfo != null) {
                c6093a.mo13475e(16, this.SendInfo);
            }
            if (this.TimeLimitStr != null) {
                c6093a.mo13475e(17, this.TimeLimitStr);
            }
            if (this.Introduce != null) {
                c6093a.mo13475e(18, this.Introduce);
            }
            if (this.TagUri != null) {
                c6093a.mo13475e(19, this.TagUri);
            }
            if (this.ExptDesc != null) {
                c6093a.mo13475e(20, this.ExptDesc);
            }
            AppMethodBeat.m2505o(62545);
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
            f = (f + C6091a.m9572bs(7, this.PackType)) + C6091a.m9572bs(8, this.PackFlag);
            if (this.CoverUrl != null) {
                f += C6091a.m9575f(9, this.CoverUrl);
            }
            f += C6091a.m9572bs(10, this.PackExpire);
            if (this.PackCopyright != null) {
                f += C6091a.m9575f(11, this.PackCopyright);
            }
            f += C6091a.m9572bs(12, this.Timestamp);
            if (this.PanelUrl != null) {
                f += C6091a.m9575f(13, this.PanelUrl);
            }
            if (this.PriceNum != null) {
                f += C6091a.m9575f(14, this.PriceNum);
            }
            if (this.PriceType != null) {
                f += C6091a.m9575f(15, this.PriceType);
            }
            if (this.SendInfo != null) {
                f += C6091a.m9575f(16, this.SendInfo);
            }
            if (this.TimeLimitStr != null) {
                f += C6091a.m9575f(17, this.TimeLimitStr);
            }
            if (this.Introduce != null) {
                f += C6091a.m9575f(18, this.Introduce);
            }
            if (this.TagUri != null) {
                f += C6091a.m9575f(19, this.TagUri);
            }
            if (this.ExptDesc != null) {
                f += C6091a.m9575f(20, this.ExptDesc);
            }
            AppMethodBeat.m2505o(62545);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(62545);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            EmotionSummary emotionSummary = (EmotionSummary) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    emotionSummary.ProductID = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(62545);
                    return 0;
                case 2:
                    emotionSummary.IconUrl = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(62545);
                    return 0;
                case 3:
                    emotionSummary.PackName = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(62545);
                    return 0;
                case 4:
                    emotionSummary.PackDesc = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(62545);
                    return 0;
                case 5:
                    emotionSummary.PackAuthInfo = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(62545);
                    return 0;
                case 6:
                    emotionSummary.PackPrice = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(62545);
                    return 0;
                case 7:
                    emotionSummary.PackType = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(62545);
                    return 0;
                case 8:
                    emotionSummary.PackFlag = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(62545);
                    return 0;
                case 9:
                    emotionSummary.CoverUrl = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(62545);
                    return 0;
                case 10:
                    emotionSummary.PackExpire = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(62545);
                    return 0;
                case 11:
                    emotionSummary.PackCopyright = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(62545);
                    return 0;
                case 12:
                    emotionSummary.Timestamp = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(62545);
                    return 0;
                case 13:
                    emotionSummary.PanelUrl = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(62545);
                    return 0;
                case 14:
                    emotionSummary.PriceNum = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(62545);
                    return 0;
                case 15:
                    emotionSummary.PriceType = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(62545);
                    return 0;
                case 16:
                    emotionSummary.SendInfo = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(62545);
                    return 0;
                case 17:
                    emotionSummary.TimeLimitStr = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(62545);
                    return 0;
                case 18:
                    emotionSummary.Introduce = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(62545);
                    return 0;
                case 19:
                    emotionSummary.TagUri = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(62545);
                    return 0;
                case 20:
                    emotionSummary.ExptDesc = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(62545);
                    return 0;
                default:
                    AppMethodBeat.m2505o(62545);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(62545);
            return -1;
        }
    }
}
