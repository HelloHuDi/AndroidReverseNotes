package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.g;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.protocal.protobuf.bbe;
import com.tencent.mm.storage.bi;

public final class m implements q {
    private final a fJa = new a();
    private g fJb;

    static final class a extends com.tencent.mm.ci.a<com.tencent.mm.plugin.messenger.foundation.a.m> implements com.tencent.mm.plugin.messenger.foundation.a.m {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final void a(final bbe bbe, final bi biVar) {
            AppMethodBeat.i(979);
            a(new com.tencent.mm.ci.a.a<com.tencent.mm.plugin.messenger.foundation.a.m>() {
                public final /* synthetic */ void ax(Object obj) {
                    AppMethodBeat.i(978);
                    ((com.tencent.mm.plugin.messenger.foundation.a.m) obj).a(bbe, biVar);
                    AppMethodBeat.o(978);
                }
            });
            AppMethodBeat.o(979);
        }
    }

    public m() {
        AppMethodBeat.i(980);
        AppMethodBeat.o(980);
    }

    public final String B(bi biVar) {
        AppMethodBeat.i(981);
        if (this.fJb != null) {
            String B = this.fJb.B(biVar);
            AppMethodBeat.o(981);
            return B;
        }
        AppMethodBeat.o(981);
        return null;
    }

    public final void a(com.tencent.mm.plugin.messenger.foundation.a.m mVar) {
        AppMethodBeat.i(982);
        this.fJa.aD(mVar);
        AppMethodBeat.o(982);
    }

    public final void a(g gVar) {
        this.fJb = gVar;
    }

    public final com.tencent.mm.plugin.messenger.foundation.a.m ahU() {
        return this.fJa;
    }
}
