package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bid */
public final class bid extends C1331a {
    public String app_id;
    public String kmr;
    public String kmt;
    public String tyv;
    public String wLu;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(48915);
        int f;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.app_id != null) {
                c6093a.mo13475e(1, this.app_id);
            }
            if (this.tyv != null) {
                c6093a.mo13475e(2, this.tyv);
            }
            if (this.kmt != null) {
                c6093a.mo13475e(3, this.kmt);
            }
            if (this.kmr != null) {
                c6093a.mo13475e(4, this.kmr);
            }
            if (this.wLu != null) {
                c6093a.mo13475e(5, this.wLu);
            }
            AppMethodBeat.m2505o(48915);
            return 0;
        } else if (i == 1) {
            if (this.app_id != null) {
                f = C6091a.m9575f(1, this.app_id) + 0;
            } else {
                f = 0;
            }
            if (this.tyv != null) {
                f += C6091a.m9575f(2, this.tyv);
            }
            if (this.kmt != null) {
                f += C6091a.m9575f(3, this.kmt);
            }
            if (this.kmr != null) {
                f += C6091a.m9575f(4, this.kmr);
            }
            if (this.wLu != null) {
                f += C6091a.m9575f(5, this.wLu);
            }
            AppMethodBeat.m2505o(48915);
            return f;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(48915);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            bid bid = (bid) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bid.app_id = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48915);
                    return 0;
                case 2:
                    bid.tyv = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48915);
                    return 0;
                case 3:
                    bid.kmt = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48915);
                    return 0;
                case 4:
                    bid.kmr = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48915);
                    return 0;
                case 5:
                    bid.wLu = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48915);
                    return 0;
                default:
                    AppMethodBeat.m2505o(48915);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(48915);
            return -1;
        }
    }
}
