package com.tencent.mm.plugin.report.kvdata;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;

public class IMBehaviorMsgOP extends a {
    public int appMsgInnerType;
    public int count;
    public int msgOpType;
    public int msgType;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(79151);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.msgType);
            aVar.iz(2, this.msgOpType);
            aVar.iz(3, this.appMsgInnerType);
            aVar.iz(4, this.count);
            AppMethodBeat.o(79151);
            return 0;
        } else if (i == 1) {
            bs = (((e.a.a.b.b.a.bs(1, this.msgType) + 0) + e.a.a.b.b.a.bs(2, this.msgOpType)) + e.a.a.b.b.a.bs(3, this.appMsgInnerType)) + e.a.a.b.b.a.bs(4, this.count);
            AppMethodBeat.o(79151);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(79151);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            IMBehaviorMsgOP iMBehaviorMsgOP = (IMBehaviorMsgOP) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    iMBehaviorMsgOP.msgType = aVar3.BTU.vd();
                    AppMethodBeat.o(79151);
                    return 0;
                case 2:
                    iMBehaviorMsgOP.msgOpType = aVar3.BTU.vd();
                    AppMethodBeat.o(79151);
                    return 0;
                case 3:
                    iMBehaviorMsgOP.appMsgInnerType = aVar3.BTU.vd();
                    AppMethodBeat.o(79151);
                    return 0;
                case 4:
                    iMBehaviorMsgOP.count = aVar3.BTU.vd();
                    AppMethodBeat.o(79151);
                    return 0;
                default:
                    AppMethodBeat.o(79151);
                    return -1;
            }
        } else {
            AppMethodBeat.o(79151);
            return -1;
        }
    }
}
