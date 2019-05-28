package com.tencent.mm.plugin.report.kvdata;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public class IMBehaviorChattingOP extends a {
    public int changeNotifyStatus;
    public int changeSaveAddress;
    public int changeTop;
    public int changeUnread;
    public int expose;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(79150);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.changeUnread);
            aVar.iz(2, this.changeTop);
            aVar.iz(3, this.changeNotifyStatus);
            aVar.iz(4, this.changeSaveAddress);
            aVar.iz(5, this.expose);
            AppMethodBeat.o(79150);
            return 0;
        } else if (i == 1) {
            bs = ((((e.a.a.b.b.a.bs(1, this.changeUnread) + 0) + e.a.a.b.b.a.bs(2, this.changeTop)) + e.a.a.b.b.a.bs(3, this.changeNotifyStatus)) + e.a.a.b.b.a.bs(4, this.changeSaveAddress)) + e.a.a.b.b.a.bs(5, this.expose);
            AppMethodBeat.o(79150);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(79150);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            IMBehaviorChattingOP iMBehaviorChattingOP = (IMBehaviorChattingOP) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    iMBehaviorChattingOP.changeUnread = aVar3.BTU.vd();
                    AppMethodBeat.o(79150);
                    return 0;
                case 2:
                    iMBehaviorChattingOP.changeTop = aVar3.BTU.vd();
                    AppMethodBeat.o(79150);
                    return 0;
                case 3:
                    iMBehaviorChattingOP.changeNotifyStatus = aVar3.BTU.vd();
                    AppMethodBeat.o(79150);
                    return 0;
                case 4:
                    iMBehaviorChattingOP.changeSaveAddress = aVar3.BTU.vd();
                    AppMethodBeat.o(79150);
                    return 0;
                case 5:
                    iMBehaviorChattingOP.expose = aVar3.BTU.vd();
                    AppMethodBeat.o(79150);
                    return 0;
                default:
                    AppMethodBeat.o(79150);
                    return -1;
            }
        } else {
            AppMethodBeat.o(79150);
            return -1;
        }
    }
}
