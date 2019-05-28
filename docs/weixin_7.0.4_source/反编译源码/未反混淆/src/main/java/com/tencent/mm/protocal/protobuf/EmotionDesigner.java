package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public class EmotionDesigner extends a {
    public String BigImgUrl;
    public String Desc;
    public String Motto;
    public String SmallImgUrl;
    public String Title;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(62539);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.Title != null) {
                aVar.e(1, this.Title);
            }
            if (this.SmallImgUrl != null) {
                aVar.e(2, this.SmallImgUrl);
            }
            if (this.BigImgUrl != null) {
                aVar.e(3, this.BigImgUrl);
            }
            if (this.Desc != null) {
                aVar.e(4, this.Desc);
            }
            if (this.Motto != null) {
                aVar.e(5, this.Motto);
            }
            AppMethodBeat.o(62539);
            return 0;
        } else if (i == 1) {
            if (this.Title != null) {
                f = e.a.a.b.b.a.f(1, this.Title) + 0;
            } else {
                f = 0;
            }
            if (this.SmallImgUrl != null) {
                f += e.a.a.b.b.a.f(2, this.SmallImgUrl);
            }
            if (this.BigImgUrl != null) {
                f += e.a.a.b.b.a.f(3, this.BigImgUrl);
            }
            if (this.Desc != null) {
                f += e.a.a.b.b.a.f(4, this.Desc);
            }
            if (this.Motto != null) {
                f += e.a.a.b.b.a.f(5, this.Motto);
            }
            AppMethodBeat.o(62539);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(62539);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            EmotionDesigner emotionDesigner = (EmotionDesigner) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    emotionDesigner.Title = aVar3.BTU.readString();
                    AppMethodBeat.o(62539);
                    return 0;
                case 2:
                    emotionDesigner.SmallImgUrl = aVar3.BTU.readString();
                    AppMethodBeat.o(62539);
                    return 0;
                case 3:
                    emotionDesigner.BigImgUrl = aVar3.BTU.readString();
                    AppMethodBeat.o(62539);
                    return 0;
                case 4:
                    emotionDesigner.Desc = aVar3.BTU.readString();
                    AppMethodBeat.o(62539);
                    return 0;
                case 5:
                    emotionDesigner.Motto = aVar3.BTU.readString();
                    AppMethodBeat.o(62539);
                    return 0;
                default:
                    AppMethodBeat.o(62539);
                    return -1;
            }
        } else {
            AppMethodBeat.o(62539);
            return -1;
        }
    }
}
