package com.tencent.p177mm.plugin.secinforeport.p1293a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.secinforeport.a.d */
public enum C44761d implements C43500c {
    ;
    
    private static C43500c qjq;

    /* renamed from: com.tencent.mm.plugin.secinforeport.a.d$a */
    static class C39645a implements C43500c {
        private C39645a() {
        }

        /* synthetic */ C39645a(byte b) {
            this();
        }

        /* renamed from: Y */
        public final boolean mo8447Y(int i, long j) {
            AppMethodBeat.m2504i(126178);
            C4990ab.m7420w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
            AppMethodBeat.m2505o(126178);
            return false;
        }

        /* renamed from: ff */
        public final void mo8448ff(int i, int i2) {
            AppMethodBeat.m2504i(126179);
            C4990ab.m7420w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
            AppMethodBeat.m2505o(126179);
        }

        /* renamed from: Ch */
        public final void mo8446Ch(int i) {
            AppMethodBeat.m2504i(126180);
            C4990ab.m7420w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
            AppMethodBeat.m2505o(126180);
        }

        /* renamed from: o */
        public final void mo8449o(int i, byte[] bArr) {
            AppMethodBeat.m2504i(126181);
            C4990ab.m7420w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
            AppMethodBeat.m2505o(126181);
        }
    }

    private C44761d(String str) {
    }

    static {
        qjq = new C39645a();
        AppMethodBeat.m2505o(126188);
    }

    /* renamed from: a */
    public static void m81619a(C43500c c43500c) {
        if (c43500c != null) {
            qjq = c43500c;
        }
    }

    /* renamed from: Y */
    public final boolean mo8447Y(int i, long j) {
        AppMethodBeat.m2504i(126184);
        boolean Y = qjq.mo8447Y(i, j);
        AppMethodBeat.m2505o(126184);
        return Y;
    }

    /* renamed from: ff */
    public final void mo8448ff(int i, int i2) {
        AppMethodBeat.m2504i(126185);
        qjq.mo8448ff(i, i2);
        AppMethodBeat.m2505o(126185);
    }

    /* renamed from: Ch */
    public final void mo8446Ch(int i) {
        AppMethodBeat.m2504i(126186);
        qjq.mo8446Ch(i);
        AppMethodBeat.m2505o(126186);
    }

    /* renamed from: o */
    public final void mo8449o(int i, byte[] bArr) {
        AppMethodBeat.m2504i(126187);
        qjq.mo8449o(i, bArr);
        AppMethodBeat.m2505o(126187);
    }
}
