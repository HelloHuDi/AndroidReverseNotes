package com.tencent.mm.plugin.auth;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ax;
import com.tencent.mm.plugin.auth.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.protocal.j;
import com.tencent.mm.protocal.j.g;
import com.tencent.mm.protocal.v;

public class PluginAuth extends f implements b {
    private final a mOg = new a();

    static final class a extends com.tencent.mm.ci.a<com.tencent.mm.plugin.auth.a.a> implements com.tencent.mm.plugin.auth.a.a {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final void a(final j.f fVar, final g gVar, final boolean z) {
            AppMethodBeat.i(123489);
            a(new com.tencent.mm.ci.a.a<com.tencent.mm.plugin.auth.a.a>() {
                public final /* synthetic */ void ax(Object obj) {
                    AppMethodBeat.i(123487);
                    ((com.tencent.mm.plugin.auth.a.a) obj).a(fVar, gVar, z);
                    AppMethodBeat.o(123487);
                }
            });
            AppMethodBeat.o(123489);
        }

        public final void a(v.b bVar, String str, int i, String str2, String str3, int i2) {
            AppMethodBeat.i(123490);
            final v.b bVar2 = bVar;
            final String str4 = str;
            final int i3 = i;
            final String str5 = str2;
            final String str6 = str3;
            final int i4 = i2;
            a(new com.tencent.mm.ci.a.a<com.tencent.mm.plugin.auth.a.a>() {
                public final /* synthetic */ void ax(Object obj) {
                    AppMethodBeat.i(123488);
                    ((com.tencent.mm.plugin.auth.a.a) obj).a(bVar2, str4, i3, str5, str6, i4);
                    AppMethodBeat.o(123488);
                }
            });
            AppMethodBeat.o(123490);
        }
    }

    public PluginAuth() {
        AppMethodBeat.i(123491);
        AppMethodBeat.o(123491);
    }

    public void installed() {
        AppMethodBeat.i(123492);
        alias(b.class);
        AppMethodBeat.o(123492);
    }

    public void dependency() {
        AppMethodBeat.i(123493);
        dependsOn(p.class);
        AppMethodBeat.o(123493);
    }

    public void configure(com.tencent.mm.kernel.b.g gVar) {
        AppMethodBeat.i(123494);
        ax.a(new com.tencent.mm.model.ax.a() {
            public final void a(j.f fVar, g gVar) {
                AppMethodBeat.i(123486);
                aa.a(gVar.vxV, true);
                PluginAuth.this.getHandleAuthResponseCallbacks().a(fVar, gVar, true);
                AppMethodBeat.o(123486);
            }
        });
        AppMethodBeat.o(123494);
    }

    public void execute(com.tencent.mm.kernel.b.g gVar) {
    }

    public String toString() {
        return "plugin-auth";
    }

    public com.tencent.mm.vending.b.b addHandleAuthResponse(com.tencent.mm.plugin.auth.a.a aVar) {
        AppMethodBeat.i(123495);
        com.tencent.mm.vending.b.b aD = this.mOg.aD(aVar);
        AppMethodBeat.o(123495);
        return aD;
    }

    public com.tencent.mm.plugin.auth.a.a getHandleAuthResponseCallbacks() {
        return this.mOg;
    }
}
