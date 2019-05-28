package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.EmotionCell */
public class EmotionCell extends C1331a {
    public String CellTitle;
    public String IconUrl;
    public int Position;
    public int ReqType;
    public String TagUrl;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(62536);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.CellTitle != null) {
                c6093a.mo13475e(1, this.CellTitle);
            }
            c6093a.mo13480iz(2, this.ReqType);
            c6093a.mo13480iz(3, this.Position);
            if (this.IconUrl != null) {
                c6093a.mo13475e(4, this.IconUrl);
            }
            if (this.TagUrl != null) {
                c6093a.mo13475e(5, this.TagUrl);
            }
            AppMethodBeat.m2505o(62536);
            return 0;
        } else if (i == 1) {
            if (this.CellTitle != null) {
                f = C6091a.m9575f(1, this.CellTitle) + 0;
            } else {
                f = 0;
            }
            f = (f + C6091a.m9572bs(2, this.ReqType)) + C6091a.m9572bs(3, this.Position);
            if (this.IconUrl != null) {
                f += C6091a.m9575f(4, this.IconUrl);
            }
            if (this.TagUrl != null) {
                f += C6091a.m9575f(5, this.TagUrl);
            }
            AppMethodBeat.m2505o(62536);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(62536);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            EmotionCell emotionCell = (EmotionCell) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    emotionCell.CellTitle = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(62536);
                    return 0;
                case 2:
                    emotionCell.ReqType = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(62536);
                    return 0;
                case 3:
                    emotionCell.Position = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(62536);
                    return 0;
                case 4:
                    emotionCell.IconUrl = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(62536);
                    return 0;
                case 5:
                    emotionCell.TagUrl = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(62536);
                    return 0;
                default:
                    AppMethodBeat.m2505o(62536);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(62536);
            return -1;
        }
    }
}
