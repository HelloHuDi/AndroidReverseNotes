package com.tencent.p177mm.pluginsdk.p592g.p593a.p594a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C6297k;
import com.tencent.p177mm.protocal.C40596q.C40597a;
import com.tencent.p177mm.protocal.C40596q.C40599b;
import com.tencent.p177mm.protocal.C4815f;
import com.tencent.p177mm.protocal.C4836l.C4834d;
import com.tencent.p177mm.protocal.C4836l.C4835e;
import com.tencent.p177mm.protocal.protobuf.C40567rr;

/* renamed from: com.tencent.mm.pluginsdk.g.a.a.o */
public final class C44797o extends C44047n {

    /* renamed from: com.tencent.mm.pluginsdk.g.a.a.o$a */
    static class C30042a extends C6297k {
        final C40597a veS = new C40597a();
        final C40599b veT = new C40599b();

        public C30042a() {
            AppMethodBeat.m2504i(79559);
            AppMethodBeat.m2505o(79559);
        }

        /* renamed from: ZR */
        public final C4834d mo14537ZR() {
            return this.veS;
        }

        public final int getType() {
            return C4815f.vxx ? 784 : 722;
        }

        public final String getUri() {
            return C4815f.vxx ? "/cgi-bin/micromsg-bin/secencryptcheckresupdate" : "/cgi-bin/micromsg-bin/encryptcheckresupdate";
        }

        /* renamed from: ZS */
        public final C4835e mo5618ZS() {
            return this.veT;
        }

        public final int acC() {
            return 1;
        }
    }

    public static void aVi() {
        AppMethodBeat.m2504i(79560);
        C1720g.m3535RO().eJo.mo14541a(new C44797o(), 0);
        AppMethodBeat.m2505o(79560);
    }

    /* Access modifiers changed, original: protected|final */
    public final String getTag() {
        return "MicroMsg.NetSceneEncryptCheckResUpdate";
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: i */
    public final C40567rr mo69735i(C1929q c1929q) {
        return ((C30042a) c1929q).veT.vyB;
    }

    public final int getType() {
        return C4815f.vxx ? 784 : 722;
    }

    /* Access modifiers changed, original: protected|final */
    public final C1929q diq() {
        AppMethodBeat.m2504i(79561);
        C30042a c30042a = new C30042a();
        C40597a c40597a = c30042a.veS;
        c40597a.mo10000hB(0);
        c40597a.vyy.wek.wei.vYX.addAll(this.veO);
        AppMethodBeat.m2505o(79561);
        return c30042a;
    }
}
