package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.bts */
public final class bts extends C1331a {
    public String wVI;
    private boolean wVJ;

    public final /* bridge */ /* synthetic */ C1331a validate() {
        return this;
    }

    public final bts alV(String str) {
        this.wVI = str;
        this.wVJ = true;
        return this;
    }

    public final int computeSize() {
        AppMethodBeat.m2504i(51853);
        int i = 0;
        if (this.wVJ) {
            i = C6091a.m9575f(1, this.wVI) + 0;
        }
        i += 0;
        AppMethodBeat.m2505o(51853);
        return i;
    }

    public final byte[] toByteArray() {
        AppMethodBeat.m2504i(51854);
        byte[] toByteArray = super.toByteArray();
        AppMethodBeat.m2505o(51854);
        return toByteArray;
    }

    public final void writeFields(C6093a c6093a) {
        AppMethodBeat.m2504i(51855);
        if (this.wVJ) {
            c6093a.mo13475e(1, this.wVI);
        }
        AppMethodBeat.m2505o(51855);
    }

    public final boolean populateBuilderWithField(C6086a c6086a, C1331a c1331a, int i) {
        AppMethodBeat.m2504i(51856);
        bts bts = (bts) c1331a;
        boolean z = true;
        switch (i) {
            case 1:
                bts.alV(c6086a.BTU.readString());
                break;
            default:
                z = false;
                break;
        }
        AppMethodBeat.m2505o(51856);
        return z;
    }

    public final String toString() {
        return this.wVI;
    }

    public final /* synthetic */ C1331a parseFrom(byte[] bArr) {
        AppMethodBeat.m2504i(51857);
        C6086a c6086a = new C6086a(bArr, unknownTagHandler);
        for (int nextFieldNumber = C1331a.getNextFieldNumber(c6086a); nextFieldNumber > 0; nextFieldNumber = C1331a.getNextFieldNumber(c6086a)) {
            if (!populateBuilderWithField(c6086a, this, nextFieldNumber)) {
                c6086a.ems();
            }
        }
        AppMethodBeat.m2505o(51857);
        return this;
    }
}
