package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.aui */
public final class aui extends C1331a {
    public int cIf;
    public String wym;
    public String wyq;
    public String wyr;
    public String wys;
    public bid wyt;

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(48874);
        C6092b c6092b;
        int bs;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.wym == null) {
                c6092b = new C6092b("Not all required fields were included: session_data");
                AppMethodBeat.m2505o(48874);
                throw c6092b;
            }
            c6093a.mo13480iz(1, this.cIf);
            if (this.wym != null) {
                c6093a.mo13475e(2, this.wym);
            }
            if (this.wyq != null) {
                c6093a.mo13475e(3, this.wyq);
            }
            if (this.wyr != null) {
                c6093a.mo13475e(4, this.wyr);
            }
            if (this.wys != null) {
                c6093a.mo13475e(5, this.wys);
            }
            if (this.wyt != null) {
                c6093a.mo13479iy(6, this.wyt.computeSize());
                this.wyt.writeFields(c6093a);
            }
            AppMethodBeat.m2505o(48874);
            return 0;
        } else if (i == 1) {
            bs = C6091a.m9572bs(1, this.cIf) + 0;
            if (this.wym != null) {
                bs += C6091a.m9575f(2, this.wym);
            }
            if (this.wyq != null) {
                bs += C6091a.m9575f(3, this.wyq);
            }
            if (this.wyr != null) {
                bs += C6091a.m9575f(4, this.wyr);
            }
            if (this.wys != null) {
                bs += C6091a.m9575f(5, this.wys);
            }
            if (this.wyt != null) {
                bs += C6087a.m9557ix(6, this.wyt.computeSize());
            }
            AppMethodBeat.m2505o(48874);
            return bs;
        } else if (i == 2) {
            C6086a c6086a = new C6086a((byte[]) objArr[0], unknownTagHandler);
            for (bs = C1331a.getNextFieldNumber(c6086a); bs > 0; bs = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, bs)) {
                    c6086a.ems();
                }
            }
            if (this.wym == null) {
                c6092b = new C6092b("Not all required fields were included: session_data");
                AppMethodBeat.m2505o(48874);
                throw c6092b;
            }
            AppMethodBeat.m2505o(48874);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            aui aui = (aui) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    aui.cIf = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(48874);
                    return 0;
                case 2:
                    aui.wym = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48874);
                    return 0;
                case 3:
                    aui.wyq = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48874);
                    return 0;
                case 4:
                    aui.wyr = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48874);
                    return 0;
                case 5:
                    aui.wys = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(48874);
                    return 0;
                case 6:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        bid bid = new bid();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bid.populateBuilderWithField(c6086a3, bid, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        aui.wyt = bid;
                    }
                    AppMethodBeat.m2505o(48874);
                    return 0;
                default:
                    AppMethodBeat.m2505o(48874);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(48874);
            return -1;
        }
    }
}
