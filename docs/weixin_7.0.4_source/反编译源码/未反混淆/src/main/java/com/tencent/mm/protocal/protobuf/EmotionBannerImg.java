package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public class EmotionBannerImg extends a {
    public int Height;
    public String ImgUrl;
    public String StripUrl;
    public int Width;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(62533);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.ImgUrl != null) {
                aVar.e(1, this.ImgUrl);
            }
            aVar.iz(2, this.Width);
            aVar.iz(3, this.Height);
            if (this.StripUrl != null) {
                aVar.e(4, this.StripUrl);
            }
            AppMethodBeat.o(62533);
            return 0;
        } else if (i == 1) {
            if (this.ImgUrl != null) {
                f = e.a.a.b.b.a.f(1, this.ImgUrl) + 0;
            } else {
                f = 0;
            }
            f = (f + e.a.a.b.b.a.bs(2, this.Width)) + e.a.a.b.b.a.bs(3, this.Height);
            if (this.StripUrl != null) {
                f += e.a.a.b.b.a.f(4, this.StripUrl);
            }
            AppMethodBeat.o(62533);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(62533);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            EmotionBannerImg emotionBannerImg = (EmotionBannerImg) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    emotionBannerImg.ImgUrl = aVar3.BTU.readString();
                    AppMethodBeat.o(62533);
                    return 0;
                case 2:
                    emotionBannerImg.Width = aVar3.BTU.vd();
                    AppMethodBeat.o(62533);
                    return 0;
                case 3:
                    emotionBannerImg.Height = aVar3.BTU.vd();
                    AppMethodBeat.o(62533);
                    return 0;
                case 4:
                    emotionBannerImg.StripUrl = aVar3.BTU.readString();
                    AppMethodBeat.o(62533);
                    return 0;
                default:
                    AppMethodBeat.o(62533);
                    return -1;
            }
        } else {
            AppMethodBeat.o(62533);
            return -1;
        }
    }
}
