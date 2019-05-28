package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public class EmotionSummary extends a {
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

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(62545);
        int f;
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
            if (this.CoverUrl != null) {
                aVar.e(9, this.CoverUrl);
            }
            aVar.iz(10, this.PackExpire);
            if (this.PackCopyright != null) {
                aVar.e(11, this.PackCopyright);
            }
            aVar.iz(12, this.Timestamp);
            if (this.PanelUrl != null) {
                aVar.e(13, this.PanelUrl);
            }
            if (this.PriceNum != null) {
                aVar.e(14, this.PriceNum);
            }
            if (this.PriceType != null) {
                aVar.e(15, this.PriceType);
            }
            if (this.SendInfo != null) {
                aVar.e(16, this.SendInfo);
            }
            if (this.TimeLimitStr != null) {
                aVar.e(17, this.TimeLimitStr);
            }
            if (this.Introduce != null) {
                aVar.e(18, this.Introduce);
            }
            if (this.TagUri != null) {
                aVar.e(19, this.TagUri);
            }
            if (this.ExptDesc != null) {
                aVar.e(20, this.ExptDesc);
            }
            AppMethodBeat.o(62545);
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
            f = (f + e.a.a.b.b.a.bs(7, this.PackType)) + e.a.a.b.b.a.bs(8, this.PackFlag);
            if (this.CoverUrl != null) {
                f += e.a.a.b.b.a.f(9, this.CoverUrl);
            }
            f += e.a.a.b.b.a.bs(10, this.PackExpire);
            if (this.PackCopyright != null) {
                f += e.a.a.b.b.a.f(11, this.PackCopyright);
            }
            f += e.a.a.b.b.a.bs(12, this.Timestamp);
            if (this.PanelUrl != null) {
                f += e.a.a.b.b.a.f(13, this.PanelUrl);
            }
            if (this.PriceNum != null) {
                f += e.a.a.b.b.a.f(14, this.PriceNum);
            }
            if (this.PriceType != null) {
                f += e.a.a.b.b.a.f(15, this.PriceType);
            }
            if (this.SendInfo != null) {
                f += e.a.a.b.b.a.f(16, this.SendInfo);
            }
            if (this.TimeLimitStr != null) {
                f += e.a.a.b.b.a.f(17, this.TimeLimitStr);
            }
            if (this.Introduce != null) {
                f += e.a.a.b.b.a.f(18, this.Introduce);
            }
            if (this.TagUri != null) {
                f += e.a.a.b.b.a.f(19, this.TagUri);
            }
            if (this.ExptDesc != null) {
                f += e.a.a.b.b.a.f(20, this.ExptDesc);
            }
            AppMethodBeat.o(62545);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(62545);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            EmotionSummary emotionSummary = (EmotionSummary) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    emotionSummary.ProductID = aVar3.BTU.readString();
                    AppMethodBeat.o(62545);
                    return 0;
                case 2:
                    emotionSummary.IconUrl = aVar3.BTU.readString();
                    AppMethodBeat.o(62545);
                    return 0;
                case 3:
                    emotionSummary.PackName = aVar3.BTU.readString();
                    AppMethodBeat.o(62545);
                    return 0;
                case 4:
                    emotionSummary.PackDesc = aVar3.BTU.readString();
                    AppMethodBeat.o(62545);
                    return 0;
                case 5:
                    emotionSummary.PackAuthInfo = aVar3.BTU.readString();
                    AppMethodBeat.o(62545);
                    return 0;
                case 6:
                    emotionSummary.PackPrice = aVar3.BTU.readString();
                    AppMethodBeat.o(62545);
                    return 0;
                case 7:
                    emotionSummary.PackType = aVar3.BTU.vd();
                    AppMethodBeat.o(62545);
                    return 0;
                case 8:
                    emotionSummary.PackFlag = aVar3.BTU.vd();
                    AppMethodBeat.o(62545);
                    return 0;
                case 9:
                    emotionSummary.CoverUrl = aVar3.BTU.readString();
                    AppMethodBeat.o(62545);
                    return 0;
                case 10:
                    emotionSummary.PackExpire = aVar3.BTU.vd();
                    AppMethodBeat.o(62545);
                    return 0;
                case 11:
                    emotionSummary.PackCopyright = aVar3.BTU.readString();
                    AppMethodBeat.o(62545);
                    return 0;
                case 12:
                    emotionSummary.Timestamp = aVar3.BTU.vd();
                    AppMethodBeat.o(62545);
                    return 0;
                case 13:
                    emotionSummary.PanelUrl = aVar3.BTU.readString();
                    AppMethodBeat.o(62545);
                    return 0;
                case 14:
                    emotionSummary.PriceNum = aVar3.BTU.readString();
                    AppMethodBeat.o(62545);
                    return 0;
                case 15:
                    emotionSummary.PriceType = aVar3.BTU.readString();
                    AppMethodBeat.o(62545);
                    return 0;
                case 16:
                    emotionSummary.SendInfo = aVar3.BTU.readString();
                    AppMethodBeat.o(62545);
                    return 0;
                case 17:
                    emotionSummary.TimeLimitStr = aVar3.BTU.readString();
                    AppMethodBeat.o(62545);
                    return 0;
                case 18:
                    emotionSummary.Introduce = aVar3.BTU.readString();
                    AppMethodBeat.o(62545);
                    return 0;
                case 19:
                    emotionSummary.TagUri = aVar3.BTU.readString();
                    AppMethodBeat.o(62545);
                    return 0;
                case 20:
                    emotionSummary.ExptDesc = aVar3.BTU.readString();
                    AppMethodBeat.o(62545);
                    return 0;
                default:
                    AppMethodBeat.o(62545);
                    return -1;
            }
        } else {
            AppMethodBeat.o(62545);
            return -1;
        }
    }
}
