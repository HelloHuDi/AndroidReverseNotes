package com.tencent.p177mm.plugin.report.kvdata;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.report.kvdata.HeavyDetailInfo */
public class HeavyDetailInfo extends C1331a {
    public long chatroom_;
    public long contact_;
    public long conversation_;
    public long dbSize_;
    public long favDbSize_;
    public long flag_;
    public long message_;
    public long sdFileRatio_;
    public long sdFileSize_;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(79148);
        int o;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13472ai(1, this.flag_);
            c6093a.mo13472ai(2, this.sdFileSize_);
            c6093a.mo13472ai(3, this.sdFileRatio_);
            c6093a.mo13472ai(4, this.dbSize_);
            c6093a.mo13472ai(5, this.message_);
            c6093a.mo13472ai(6, this.conversation_);
            c6093a.mo13472ai(7, this.contact_);
            c6093a.mo13472ai(8, this.chatroom_);
            c6093a.mo13472ai(9, this.favDbSize_);
            AppMethodBeat.m2505o(79148);
            return 0;
        } else if (i == 1) {
            o = ((((((((C6091a.m9578o(1, this.flag_) + 0) + C6091a.m9578o(2, this.sdFileSize_)) + C6091a.m9578o(3, this.sdFileRatio_)) + C6091a.m9578o(4, this.dbSize_)) + C6091a.m9578o(5, this.message_)) + C6091a.m9578o(6, this.conversation_)) + C6091a.m9578o(7, this.contact_)) + C6091a.m9578o(8, this.chatroom_)) + C6091a.m9578o(9, this.favDbSize_);
            AppMethodBeat.m2505o(79148);
            return o;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (o = C1331a.getNextFieldNumber(c6086a); o > 0; o = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, o)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(79148);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            HeavyDetailInfo heavyDetailInfo = (HeavyDetailInfo) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    heavyDetailInfo.flag_ = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(79148);
                    return 0;
                case 2:
                    heavyDetailInfo.sdFileSize_ = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(79148);
                    return 0;
                case 3:
                    heavyDetailInfo.sdFileRatio_ = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(79148);
                    return 0;
                case 4:
                    heavyDetailInfo.dbSize_ = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(79148);
                    return 0;
                case 5:
                    heavyDetailInfo.message_ = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(79148);
                    return 0;
                case 6:
                    heavyDetailInfo.conversation_ = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(79148);
                    return 0;
                case 7:
                    heavyDetailInfo.contact_ = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(79148);
                    return 0;
                case 8:
                    heavyDetailInfo.chatroom_ = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(79148);
                    return 0;
                case 9:
                    heavyDetailInfo.favDbSize_ = c6086a2.BTU.mo13459ve();
                    AppMethodBeat.m2505o(79148);
                    return 0;
                default:
                    AppMethodBeat.m2505o(79148);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(79148);
            return -1;
        }
    }
}
