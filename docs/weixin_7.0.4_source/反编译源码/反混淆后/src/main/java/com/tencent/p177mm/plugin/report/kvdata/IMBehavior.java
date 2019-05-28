package com.tencent.p177mm.plugin.report.kvdata;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.report.kvdata.IMBehavior */
public class IMBehavior extends C1331a {
    public IMBehaviorChattingOP chattingOp;
    public IMBehaviorMsgOP msgOp;
    public int opType;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(79149);
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            c6093a.mo13480iz(1, this.opType);
            if (this.chattingOp != null) {
                c6093a.mo13479iy(2, this.chattingOp.computeSize());
                this.chattingOp.writeFields(c6093a);
            }
            if (this.msgOp != null) {
                c6093a.mo13479iy(3, this.msgOp.computeSize());
                this.msgOp.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(79149);
            return 0;
        } else if (i == 1) {
            bs = C6091a.m9572bs(1, this.opType) + 0;
            if (this.chattingOp != null) {
                bs += C6087a.m9557ix(2, this.chattingOp.computeSize());
            }
            if (this.msgOp != null) {
                bs += C6087a.m9557ix(3, this.msgOp.computeSize());
            }
            AppMethodBeat.m2505o(79149);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(79149);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            IMBehavior iMBehavior = (IMBehavior) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    iMBehavior.opType = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(79149);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        IMBehaviorChattingOP iMBehaviorChattingOP = new IMBehaviorChattingOP();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = iMBehaviorChattingOP.populateBuilderWithField(c6086a3, iMBehaviorChattingOP, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        iMBehavior.chattingOp = iMBehaviorChattingOP;
                    }
                    AppMethodBeat.m2505o(79149);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        IMBehaviorMsgOP iMBehaviorMsgOP = new IMBehaviorMsgOP();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = iMBehaviorMsgOP.populateBuilderWithField(c6086a3, iMBehaviorMsgOP, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        iMBehavior.msgOp = iMBehaviorMsgOP;
                    }
                    AppMethodBeat.m2505o(79149);
                    return 0;
                default:
                    AppMethodBeat.m2505o(79149);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(79149);
            return -1;
        }
    }
}
