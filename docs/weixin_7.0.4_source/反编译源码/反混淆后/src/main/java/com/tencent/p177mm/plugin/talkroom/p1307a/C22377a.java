package com.tencent.p177mm.plugin.talkroom.p1307a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.protocal.protobuf.cgm;
import java.util.LinkedList;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.plugin.talkroom.a.a */
public final class C22377a extends C1331a {
    public LinkedList<cgm> cGh = new LinkedList();
    public int sceneType;
    public String username;

    public C22377a() {
        AppMethodBeat.m2504i(25750);
        AppMethodBeat.m2505o(25750);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(25751);
        C6092b c6092b;
        int f;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.username == null) {
                c6092b = new C6092b("Not all required fields were included: username");
                AppMethodBeat.m2505o(25751);
                throw c6092b;
            }
            if (this.username != null) {
                c6093a.mo13475e(1, this.username);
            }
            c6093a.mo13474e(2, 8, this.cGh);
            c6093a.mo13480iz(3, this.sceneType);
            AppMethodBeat.m2505o(25751);
            return 0;
        } else if (i == 1) {
            if (this.username != null) {
                f = C6091a.m9575f(1, this.username) + 0;
            } else {
                f = 0;
            }
            int c = (f + C6087a.m9552c(2, 8, this.cGh)) + C6091a.m9572bs(3, this.sceneType);
            AppMethodBeat.m2505o(25751);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.cGh.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            if (this.username == null) {
                c6092b = new C6092b("Not all required fields were included: username");
                AppMethodBeat.m2505o(25751);
                throw c6092b;
            }
            AppMethodBeat.m2505o(25751);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C22377a c22377a = (C22377a) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    c22377a.username = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(25751);
                    return 0;
                case 2:
                    LinkedList Vh = c6086a2.mo13445Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        cgm cgm = new cgm();
                        C6086a c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = cgm.populateBuilderWithField(c6086a3, cgm, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c22377a.cGh.add(cgm);
                    }
                    AppMethodBeat.m2505o(25751);
                    return 0;
                case 3:
                    c22377a.sceneType = c6086a2.BTU.mo13458vd();
                    AppMethodBeat.m2505o(25751);
                    return 0;
                default:
                    AppMethodBeat.m2505o(25751);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(25751);
            return -1;
        }
    }
}
