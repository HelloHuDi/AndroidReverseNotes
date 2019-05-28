package com.tencent.p177mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1331a;
import p690e.p691a.p692a.C6092b;
import p690e.p691a.p692a.p693a.C6086a;
import p690e.p691a.p692a.p695b.p697b.C6091a;
import p690e.p691a.p692a.p698c.C6093a;

/* renamed from: com.tencent.mm.protocal.protobuf.btt */
public final class btt extends C1331a {
    public int wVK;
    private boolean wVL;

    public final /* synthetic */ C1331a validate() {
        AppMethodBeat.m2504i(51852);
        btt dmA = dmA();
        AppMethodBeat.m2505o(51852);
        return dmA;
    }

    /* renamed from: LQ */
    public final btt mo64053LQ(int i) {
        this.wVK = i;
        this.wVL = true;
        return this;
    }

    public final String toString() {
        AppMethodBeat.m2504i(51845);
        String stringBuilder = new StringBuilder(String.valueOf(new StringBuilder(String.valueOf("" + getClass().getName() + "(")).append("uiVal = ").append(this.wVK).append("   ").toString())).append(")").toString();
        AppMethodBeat.m2505o(51845);
        return stringBuilder;
    }

    private btt dmA() {
        AppMethodBeat.m2504i(51846);
        if (this.wVL) {
            AppMethodBeat.m2505o(51846);
            return this;
        }
        C6092b c6092b = new C6092b("Not all required fields were included (false = not included in message),  uiVal:" + this.wVL);
        AppMethodBeat.m2505o(51846);
        throw c6092b;
    }

    public final int computeSize() {
        AppMethodBeat.m2504i(51847);
        int bs = (C6091a.m9572bs(1, this.wVK) + 0) + 0;
        AppMethodBeat.m2505o(51847);
        return bs;
    }

    public final byte[] toByteArray() {
        AppMethodBeat.m2504i(51848);
        dmA();
        byte[] toByteArray = super.toByteArray();
        AppMethodBeat.m2505o(51848);
        return toByteArray;
    }

    public final void writeFields(C6093a c6093a) {
        AppMethodBeat.m2504i(51849);
        c6093a.mo13480iz(1, this.wVK);
        AppMethodBeat.m2505o(51849);
    }

    public final boolean populateBuilderWithField(C6086a c6086a, C1331a c1331a, int i) {
        AppMethodBeat.m2504i(51850);
        btt btt = (btt) c1331a;
        boolean z = true;
        switch (i) {
            case 1:
                btt.mo64053LQ(c6086a.BTU.mo13458vd());
                break;
            default:
                z = false;
                break;
        }
        AppMethodBeat.m2505o(51850);
        return z;
    }

    public final /* synthetic */ C1331a parseFrom(byte[] bArr) {
        AppMethodBeat.m2504i(51851);
        C6086a c6086a = new C6086a(bArr, unknownTagHandler);
        for (int nextFieldNumber = C1331a.getNextFieldNumber(c6086a); nextFieldNumber > 0; nextFieldNumber = C1331a.getNextFieldNumber(c6086a)) {
            if (!populateBuilderWithField(c6086a, this, nextFieldNumber)) {
                c6086a.ems();
            }
        }
        btt dmA = dmA();
        AppMethodBeat.m2505o(51851);
        return dmA;
    }
}
