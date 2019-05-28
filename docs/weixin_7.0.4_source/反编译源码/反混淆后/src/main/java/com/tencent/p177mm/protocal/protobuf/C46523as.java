package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import java.util.LinkedList;
import org.xwalk.core.XWalkCoreWrapper;
import p690e.p691a.p692a.C6087a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.as */
public final class C46523as extends C1331a {
    public LinkedList<bha> ckO = new LinkedList();
    public String vCq;
    public LinkedList<bhb> vCr = new LinkedList();

    public C46523as() {
        AppMethodBeat.m2504i(80004);
        AppMethodBeat.m2505o(80004);
    }

    /* renamed from: op */
    public final int mo4669op(int i, Object... objArr) {
        AppMethodBeat.m2504i(XWalkCoreWrapper.INVOKE_RUNTIME_ID_SET_RUNTIME_TO_SDK_CHANNEL);
        int f;
        byte[] bArr;
        if (i == 0) {
            C6093a c6093a = (C6093a) objArr[0];
            if (this.vCq != null) {
                c6093a.mo13475e(1, this.vCq);
            }
            c6093a.mo13474e(2, 8, this.vCr);
            c6093a.mo13474e(3, 8, this.ckO);
            AppMethodBeat.m2505o(XWalkCoreWrapper.INVOKE_RUNTIME_ID_SET_RUNTIME_TO_SDK_CHANNEL);
            return 0;
        } else if (i == 1) {
            if (this.vCq != null) {
                f = C6091a.m9575f(1, this.vCq) + 0;
            } else {
                f = 0;
            }
            int c = (f + C6087a.m9552c(2, 8, this.vCr)) + C6087a.m9552c(3, 8, this.ckO);
            AppMethodBeat.m2505o(XWalkCoreWrapper.INVOKE_RUNTIME_ID_SET_RUNTIME_TO_SDK_CHANNEL);
            return c;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.vCr.clear();
            this.ckO.clear();
            C6086a c6086a = new C6086a(bArr, unknownTagHandler);
            for (f = C1331a.getNextFieldNumber(c6086a); f > 0; f = C1331a.getNextFieldNumber(c6086a)) {
                if (!super.populateBuilderWithField(c6086a, this, f)) {
                    c6086a.ems();
                }
            }
            AppMethodBeat.m2505o(XWalkCoreWrapper.INVOKE_RUNTIME_ID_SET_RUNTIME_TO_SDK_CHANNEL);
            return 0;
        } else if (i == 3) {
            C6086a c6086a2 = (C6086a) objArr[0];
            C46523as c46523as = (C46523as) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            C6086a c6086a3;
            boolean z;
            switch (intValue) {
                case 1:
                    c46523as.vCq = c6086a2.BTU.readString();
                    AppMethodBeat.m2505o(XWalkCoreWrapper.INVOKE_RUNTIME_ID_SET_RUNTIME_TO_SDK_CHANNEL);
                    return 0;
                case 2:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bhb bhb = new bhb();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhb.populateBuilderWithField(c6086a3, bhb, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c46523as.vCr.add(bhb);
                    }
                    AppMethodBeat.m2505o(XWalkCoreWrapper.INVOKE_RUNTIME_ID_SET_RUNTIME_TO_SDK_CHANNEL);
                    return 0;
                case 3:
                    Vh = c6086a2.mo13445Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        bha bha = new bha();
                        c6086a3 = new C6086a(bArr, unknownTagHandler);
                        for (z = true; z; z = bha.populateBuilderWithField(c6086a3, bha, C1331a.getNextFieldNumber(c6086a3))) {
                        }
                        c46523as.ckO.add(bha);
                    }
                    AppMethodBeat.m2505o(XWalkCoreWrapper.INVOKE_RUNTIME_ID_SET_RUNTIME_TO_SDK_CHANNEL);
                    return 0;
                default:
                    AppMethodBeat.m2505o(XWalkCoreWrapper.INVOKE_RUNTIME_ID_SET_RUNTIME_TO_SDK_CHANNEL);
                    return -1;
            }
        } else {
            AppMethodBeat.m2505o(XWalkCoreWrapper.INVOKE_RUNTIME_ID_SET_RUNTIME_TO_SDK_CHANNEL);
            return -1;
        }
    }
}
