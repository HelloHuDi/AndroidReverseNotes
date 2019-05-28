package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.EmotionBannerImg */
public class EmotionBannerImg extends C1331a {
    public int Height;
    public String ImgUrl;
    public String StripUrl;
    public int Width;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(62533);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.ImgUrl != null) {
                c6093a.mo13475e(1, this.ImgUrl);
            }
            c6093a.mo13480iz(2, this.Width);
            c6093a.mo13480iz(3, this.Height);
            if (this.StripUrl != null) {
                c6093a.mo13475e(4, this.StripUrl);
            }
            AppMethodBeat.m2505o(62533);
            return 0;
        } else if (i == 1) {
            if (this.ImgUrl != null) {
                f = C6091a.m9575f(1, this.ImgUrl) + 0;
            } else {
                f = 0;
            }
            f = (f + C6091a.m9572bs(2, this.Width)) + C6091a.m9572bs(3, this.Height);
            if (this.StripUrl != null) {
                f += C6091a.m9575f(4, this.StripUrl);
            }
            AppMethodBeat.m2505o(62533);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(62533);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            EmotionBannerImg emotionBannerImg = (EmotionBannerImg) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    emotionBannerImg.ImgUrl = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(62533);
                    return 0;
                case 2:
                    emotionBannerImg.Width = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(62533);
                    return 0;
                case 3:
                    emotionBannerImg.Height = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(62533);
                    return 0;
                case 4:
                    emotionBannerImg.StripUrl = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(62533);
                    return 0;
                default:
                    AppMethodBeat.m2505o(62533);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(62533);
            return -1;
        }
    }
}
