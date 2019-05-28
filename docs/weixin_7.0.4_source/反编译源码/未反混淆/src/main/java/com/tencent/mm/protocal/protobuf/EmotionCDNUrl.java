package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public class EmotionCDNUrl extends a {
    public String AesKey;
    public int FileSize;
    public String Url;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(62535);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.Url != null) {
                aVar.e(1, this.Url);
            }
            if (this.AesKey != null) {
                aVar.e(2, this.AesKey);
            }
            aVar.iz(3, this.FileSize);
            AppMethodBeat.o(62535);
            return 0;
        } else if (i == 1) {
            if (this.Url != null) {
                f = e.a.a.b.b.a.f(1, this.Url) + 0;
            } else {
                f = 0;
            }
            if (this.AesKey != null) {
                f += e.a.a.b.b.a.f(2, this.AesKey);
            }
            int bs = f + e.a.a.b.b.a.bs(3, this.FileSize);
            AppMethodBeat.o(62535);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(62535);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            EmotionCDNUrl emotionCDNUrl = (EmotionCDNUrl) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    emotionCDNUrl.Url = aVar3.BTU.readString();
                    AppMethodBeat.o(62535);
                    return 0;
                case 2:
                    emotionCDNUrl.AesKey = aVar3.BTU.readString();
                    AppMethodBeat.o(62535);
                    return 0;
                case 3:
                    emotionCDNUrl.FileSize = aVar3.BTU.vd();
                    AppMethodBeat.o(62535);
                    return 0;
                default:
                    AppMethodBeat.o(62535);
                    return -1;
            }
        } else {
            AppMethodBeat.o(62535);
            return -1;
        }
    }
}
