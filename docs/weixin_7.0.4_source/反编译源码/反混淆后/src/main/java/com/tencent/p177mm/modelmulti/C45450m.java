package com.tencent.p177mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p217ci.C6454a;
import com.tencent.p177mm.p217ci.C6454a.C1387a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C12527m;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C39367q;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C46071g;
import com.tencent.p177mm.protocal.protobuf.bbe;
import com.tencent.p177mm.storage.C7620bi;

/* renamed from: com.tencent.mm.modelmulti.m */
public final class C45450m implements C39367q {
    private final C26456a fJa = new C26456a();
    private C46071g fJb;

    /* renamed from: com.tencent.mm.modelmulti.m$a */
    static final class C26456a extends C6454a<C12527m> implements C12527m {
        private C26456a() {
        }

        /* synthetic */ C26456a(byte b) {
            this();
        }

        /* renamed from: a */
        public final void mo24450a(final bbe bbe, final C7620bi c7620bi) {
            AppMethodBeat.m2504i(979);
            mo14669a(new C1387a<C12527m>() {
                /* renamed from: ax */
                public final /* synthetic */ void mo4769ax(Object obj) {
                    AppMethodBeat.m2504i(978);
                    ((C12527m) obj).mo24450a(bbe, c7620bi);
                    AppMethodBeat.m2505o(978);
                }
            });
            AppMethodBeat.m2505o(979);
        }
    }

    public C45450m() {
        AppMethodBeat.m2504i(980);
        AppMethodBeat.m2505o(980);
    }

    /* renamed from: B */
    public final String mo62261B(C7620bi c7620bi) {
        AppMethodBeat.m2504i(981);
        if (this.fJb != null) {
            String B = this.fJb.mo68249B(c7620bi);
            AppMethodBeat.m2505o(981);
            return B;
        }
        AppMethodBeat.m2505o(981);
        return null;
    }

    /* renamed from: a */
    public final void mo62263a(C12527m c12527m) {
        AppMethodBeat.m2504i(982);
        this.fJa.mo14670aD(c12527m);
        AppMethodBeat.m2505o(982);
    }

    /* renamed from: a */
    public final void mo62262a(C46071g c46071g) {
        this.fJb = c46071g;
    }

    public final C12527m ahU() {
        return this.fJa;
    }
}
