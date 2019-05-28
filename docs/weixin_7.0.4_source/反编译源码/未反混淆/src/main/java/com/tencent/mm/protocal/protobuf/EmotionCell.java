package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public class EmotionCell extends a {
    public String CellTitle;
    public String IconUrl;
    public int Position;
    public int ReqType;
    public String TagUrl;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(62536);
        int f;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.CellTitle != null) {
                aVar.e(1, this.CellTitle);
            }
            aVar.iz(2, this.ReqType);
            aVar.iz(3, this.Position);
            if (this.IconUrl != null) {
                aVar.e(4, this.IconUrl);
            }
            if (this.TagUrl != null) {
                aVar.e(5, this.TagUrl);
            }
            AppMethodBeat.o(62536);
            return 0;
        } else if (i == 1) {
            if (this.CellTitle != null) {
                f = e.a.a.b.b.a.f(1, this.CellTitle) + 0;
            } else {
                f = 0;
            }
            f = (f + e.a.a.b.b.a.bs(2, this.ReqType)) + e.a.a.b.b.a.bs(3, this.Position);
            if (this.IconUrl != null) {
                f += e.a.a.b.b.a.f(4, this.IconUrl);
            }
            if (this.TagUrl != null) {
                f += e.a.a.b.b.a.f(5, this.TagUrl);
            }
            AppMethodBeat.o(62536);
            return f;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (f = a.getNextFieldNumber(aVar2); f > 0; f = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, f)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(62536);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            EmotionCell emotionCell = (EmotionCell) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    emotionCell.CellTitle = aVar3.BTU.readString();
                    AppMethodBeat.o(62536);
                    return 0;
                case 2:
                    emotionCell.ReqType = aVar3.BTU.vd();
                    AppMethodBeat.o(62536);
                    return 0;
                case 3:
                    emotionCell.Position = aVar3.BTU.vd();
                    AppMethodBeat.o(62536);
                    return 0;
                case 4:
                    emotionCell.IconUrl = aVar3.BTU.readString();
                    AppMethodBeat.o(62536);
                    return 0;
                case 5:
                    emotionCell.TagUrl = aVar3.BTU.readString();
                    AppMethodBeat.o(62536);
                    return 0;
                default:
                    AppMethodBeat.o(62536);
                    return -1;
            }
        } else {
            AppMethodBeat.o(62536);
            return -1;
        }
    }
}
