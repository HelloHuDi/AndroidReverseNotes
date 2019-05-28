package com.tencent.mm.plugin.report.kvdata;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public class HeavyDetailInfo extends a {
    public long chatroom_;
    public long contact_;
    public long conversation_;
    public long dbSize_;
    public long favDbSize_;
    public long flag_;
    public long message_;
    public long sdFileRatio_;
    public long sdFileSize_;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(79148);
        int o;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.ai(1, this.flag_);
            aVar.ai(2, this.sdFileSize_);
            aVar.ai(3, this.sdFileRatio_);
            aVar.ai(4, this.dbSize_);
            aVar.ai(5, this.message_);
            aVar.ai(6, this.conversation_);
            aVar.ai(7, this.contact_);
            aVar.ai(8, this.chatroom_);
            aVar.ai(9, this.favDbSize_);
            AppMethodBeat.o(79148);
            return 0;
        } else if (i == 1) {
            o = ((((((((e.a.a.b.b.a.o(1, this.flag_) + 0) + e.a.a.b.b.a.o(2, this.sdFileSize_)) + e.a.a.b.b.a.o(3, this.sdFileRatio_)) + e.a.a.b.b.a.o(4, this.dbSize_)) + e.a.a.b.b.a.o(5, this.message_)) + e.a.a.b.b.a.o(6, this.conversation_)) + e.a.a.b.b.a.o(7, this.contact_)) + e.a.a.b.b.a.o(8, this.chatroom_)) + e.a.a.b.b.a.o(9, this.favDbSize_);
            AppMethodBeat.o(79148);
            return o;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (o = a.getNextFieldNumber(aVar2); o > 0; o = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, o)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(79148);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            HeavyDetailInfo heavyDetailInfo = (HeavyDetailInfo) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    heavyDetailInfo.flag_ = aVar3.BTU.ve();
                    AppMethodBeat.o(79148);
                    return 0;
                case 2:
                    heavyDetailInfo.sdFileSize_ = aVar3.BTU.ve();
                    AppMethodBeat.o(79148);
                    return 0;
                case 3:
                    heavyDetailInfo.sdFileRatio_ = aVar3.BTU.ve();
                    AppMethodBeat.o(79148);
                    return 0;
                case 4:
                    heavyDetailInfo.dbSize_ = aVar3.BTU.ve();
                    AppMethodBeat.o(79148);
                    return 0;
                case 5:
                    heavyDetailInfo.message_ = aVar3.BTU.ve();
                    AppMethodBeat.o(79148);
                    return 0;
                case 6:
                    heavyDetailInfo.conversation_ = aVar3.BTU.ve();
                    AppMethodBeat.o(79148);
                    return 0;
                case 7:
                    heavyDetailInfo.contact_ = aVar3.BTU.ve();
                    AppMethodBeat.o(79148);
                    return 0;
                case 8:
                    heavyDetailInfo.chatroom_ = aVar3.BTU.ve();
                    AppMethodBeat.o(79148);
                    return 0;
                case 9:
                    heavyDetailInfo.favDbSize_ = aVar3.BTU.ve();
                    AppMethodBeat.o(79148);
                    return 0;
                default:
                    AppMethodBeat.o(79148);
                    return -1;
            }
        } else {
            AppMethodBeat.o(79148);
            return -1;
        }
    }
}
