package com.tencent.mm.plugin.report.kvdata;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import java.util.LinkedList;

public class IMBehavior extends a {
    public IMBehaviorChattingOP chattingOp;
    public IMBehaviorMsgOP msgOp;
    public int opType;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(79149);
        int bs;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.iz(1, this.opType);
            if (this.chattingOp != null) {
                aVar.iy(2, this.chattingOp.computeSize());
                this.chattingOp.writeFields(aVar);
            }
            if (this.msgOp != null) {
                aVar.iy(3, this.msgOp.computeSize());
                this.msgOp.writeFields(aVar);
            }
            AppMethodBeat.o(79149);
            return 0;
        } else if (i == 1) {
            bs = e.a.a.b.b.a.bs(1, this.opType) + 0;
            if (this.chattingOp != null) {
                bs += e.a.a.a.ix(2, this.chattingOp.computeSize());
            }
            if (this.msgOp != null) {
                bs += e.a.a.a.ix(3, this.msgOp.computeSize());
            }
            AppMethodBeat.o(79149);
            return bs;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (bs = a.getNextFieldNumber(aVar2); bs > 0; bs = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, bs)) {
                    aVar2.ems();
                }
            }
            AppMethodBeat.o(79149);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            IMBehavior iMBehavior = (IMBehavior) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    iMBehavior.opType = aVar3.BTU.vd();
                    AppMethodBeat.o(79149);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        IMBehaviorChattingOP iMBehaviorChattingOP = new IMBehaviorChattingOP();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = iMBehaviorChattingOP.populateBuilderWithField(aVar4, iMBehaviorChattingOP, a.getNextFieldNumber(aVar4))) {
                        }
                        iMBehavior.chattingOp = iMBehaviorChattingOP;
                    }
                    AppMethodBeat.o(79149);
                    return 0;
                case 3:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        IMBehaviorMsgOP iMBehaviorMsgOP = new IMBehaviorMsgOP();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = iMBehaviorMsgOP.populateBuilderWithField(aVar4, iMBehaviorMsgOP, a.getNextFieldNumber(aVar4))) {
                        }
                        iMBehavior.msgOp = iMBehaviorMsgOP;
                    }
                    AppMethodBeat.o(79149);
                    return 0;
                default:
                    AppMethodBeat.o(79149);
                    return -1;
            }
        } else {
            AppMethodBeat.o(79149);
            return -1;
        }
    }
}
