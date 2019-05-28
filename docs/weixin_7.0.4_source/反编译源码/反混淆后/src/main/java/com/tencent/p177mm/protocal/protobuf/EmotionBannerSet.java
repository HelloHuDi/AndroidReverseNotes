package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.EmotionBannerSet */
public class EmotionBannerSet extends C1331a {
    public EmotionBannerImg BannerImg;
    public String Desc;
    /* renamed from: ID */
    public int f15073ID;
    public String IconUrl;
    public String LocateUrl;
    public String ProductID;
    public String SecondUrl;
    public int SetType;
    public String TagUrl;
    public String Title;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(62534);
        C6092b c6092b;
        int ix;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.BannerImg == null) {
                c6092b = new C6092b("Not all required fields were included: BannerImg");
                AppMethodBeat.m2505o(62534);
                throw c6092b;
            }
            if (this.BannerImg != null) {
                c6093a.mo13479iy(1, this.BannerImg.computeSize());
                this.BannerImg.writeFields(c6093a);
            }
            if (this.Title != null) {
                c6093a.mo13475e(2, this.Title);
            }
            if (this.LocateUrl != null) {
                c6093a.mo13475e(3, this.LocateUrl);
            }
            c6093a.mo13480iz(4, this.f15073ID);
            if (this.SecondUrl != null) {
                c6093a.mo13475e(5, this.SecondUrl);
            }
            c6093a.mo13480iz(6, this.SetType);
            if (this.IconUrl != null) {
                c6093a.mo13475e(7, this.IconUrl);
            }
            if (this.Desc != null) {
                c6093a.mo13475e(8, this.Desc);
            }
            if (this.ProductID != null) {
                c6093a.mo13475e(9, this.ProductID);
            }
            if (this.TagUrl != null) {
                c6093a.mo13475e(10, this.TagUrl);
            }
            AppMethodBeat.m2505o(62534);
            return 0;
        } else if (i == 1) {
            if (this.BannerImg != null) {
                ix = C6087a.m9557ix(1, this.BannerImg.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.Title != null) {
                ix += C6091a.m9575f(2, this.Title);
            }
            if (this.LocateUrl != null) {
                ix += C6091a.m9575f(3, this.LocateUrl);
            }
            ix += C6091a.m9572bs(4, this.f15073ID);
            if (this.SecondUrl != null) {
                ix += C6091a.m9575f(5, this.SecondUrl);
            }
            ix += C6091a.m9572bs(6, this.SetType);
            if (this.IconUrl != null) {
                ix += C6091a.m9575f(7, this.IconUrl);
            }
            if (this.Desc != null) {
                ix += C6091a.m9575f(8, this.Desc);
            }
            if (this.ProductID != null) {
                ix += C6091a.m9575f(9, this.ProductID);
            }
            if (this.TagUrl != null) {
                ix += C6091a.m9575f(10, this.TagUrl);
            }
            AppMethodBeat.m2505o(62534);
            return ix;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (ix = C1331a.getNextFieldNumber(c6086a); ix > 0; ix = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, ix)) {
                    c6086a.ems();
                }
            }
            if (this.BannerImg == null) {
                c6092b = new C6092b("Not all required fields were included: BannerImg");
                AppMethodBeat.m2505o(62534);
                throw c6092b;
            }
            AppMethodBeat.m2505o(62534);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            EmotionBannerSet emotionBannerSet = (EmotionBannerSet) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        EmotionBannerImg emotionBannerImg = new EmotionBannerImg();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = emotionBannerImg.populateBuilderWithField(c6086a3, emotionBannerImg, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        emotionBannerSet.BannerImg = emotionBannerImg;
                    }
                    AppMethodBeat.m2505o(62534);
                    return 0;
                case 2:
                    emotionBannerSet.Title = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(62534);
                    return 0;
                case 3:
                    emotionBannerSet.LocateUrl = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(62534);
                    return 0;
                case 4:
                    emotionBannerSet.f15073ID = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(62534);
                    return 0;
                case 5:
                    emotionBannerSet.SecondUrl = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(62534);
                    return 0;
                case 6:
                    emotionBannerSet.SetType = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(62534);
                    return 0;
                case 7:
                    emotionBannerSet.IconUrl = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(62534);
                    return 0;
                case 8:
                    emotionBannerSet.Desc = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(62534);
                    return 0;
                case 9:
                    emotionBannerSet.ProductID = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(62534);
                    return 0;
                case 10:
                    emotionBannerSet.TagUrl = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(62534);
                    return 0;
                default:
                    AppMethodBeat.m2505o(62534);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(62534);
            return -1;
        }
    }
}
