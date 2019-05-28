package com.tencent.p177mm.plugin.auth;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.kernel.p241b.C7597f;
import com.tencent.p177mm.model.C32773aa;
import com.tencent.p177mm.model.C7484ax;
import com.tencent.p177mm.model.C7484ax.C1817a;
import com.tencent.p177mm.p217ci.C6454a;
import com.tencent.p177mm.p217ci.C6454a.C1387a;
import com.tencent.p177mm.plugin.auth.p1239a.C19933a;
import com.tencent.p177mm.plugin.auth.p1239a.C19934b;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6983p;
import com.tencent.p177mm.protocal.C4824j.C4825f;
import com.tencent.p177mm.protocal.C4824j.C4826g;
import com.tencent.p177mm.protocal.C4842v.C4844b;
import com.tencent.p177mm.vending.p636b.C7358b;

/* renamed from: com.tencent.mm.plugin.auth.PluginAuth */
public class PluginAuth extends C7597f implements C19934b {
    private final C38632a mOg = new C38632a();

    /* renamed from: com.tencent.mm.plugin.auth.PluginAuth$1 */
    class C110691 implements C1817a {
        C110691() {
        }

        /* renamed from: a */
        public final void mo5396a(C4825f c4825f, C4826g c4826g) {
            AppMethodBeat.m2504i(123486);
            C32773aa.m53535a(c4826g.vxV, true);
            PluginAuth.this.getHandleAuthResponseCallbacks().mo5415a(c4825f, c4826g, true);
            AppMethodBeat.m2505o(123486);
        }
    }

    /* renamed from: com.tencent.mm.plugin.auth.PluginAuth$a */
    static final class C38632a extends C6454a<C19933a> implements C19933a {
        private C38632a() {
        }

        /* synthetic */ C38632a(byte b) {
            this();
        }

        /* renamed from: a */
        public final void mo5415a(final C4825f c4825f, final C4826g c4826g, final boolean z) {
            AppMethodBeat.m2504i(123489);
            mo14669a(new C1387a<C19933a>() {
                /* renamed from: ax */
                public final /* synthetic */ void mo4769ax(Object obj) {
                    AppMethodBeat.m2504i(123487);
                    ((C19933a) obj).mo5415a(c4825f, c4826g, z);
                    AppMethodBeat.m2505o(123487);
                }
            });
            AppMethodBeat.m2505o(123489);
        }

        /* renamed from: a */
        public final void mo5416a(C4844b c4844b, String str, int i, String str2, String str3, int i2) {
            AppMethodBeat.m2504i(123490);
            final C4844b c4844b2 = c4844b;
            final String str4 = str;
            final int i3 = i;
            final String str5 = str2;
            final String str6 = str3;
            final int i4 = i2;
            mo14669a(new C1387a<C19933a>() {
                /* renamed from: ax */
                public final /* synthetic */ void mo4769ax(Object obj) {
                    AppMethodBeat.m2504i(123488);
                    ((C19933a) obj).mo5416a(c4844b2, str4, i3, str5, str6, i4);
                    AppMethodBeat.m2505o(123488);
                }
            });
            AppMethodBeat.m2505o(123490);
        }
    }

    public PluginAuth() {
        AppMethodBeat.m2504i(123491);
        AppMethodBeat.m2505o(123491);
    }

    public void installed() {
        AppMethodBeat.m2504i(123492);
        alias(C19934b.class);
        AppMethodBeat.m2505o(123492);
    }

    public void dependency() {
        AppMethodBeat.m2504i(123493);
        dependsOn(C6983p.class);
        AppMethodBeat.m2505o(123493);
    }

    public void configure(C1681g c1681g) {
        AppMethodBeat.m2504i(123494);
        C7484ax.m12917a(new C110691());
        AppMethodBeat.m2505o(123494);
    }

    public void execute(C1681g c1681g) {
    }

    public String toString() {
        return "plugin-auth";
    }

    public C7358b addHandleAuthResponse(C19933a c19933a) {
        AppMethodBeat.m2504i(123495);
        C7358b aD = this.mOg.mo14670aD(c19933a);
        AppMethodBeat.m2505o(123495);
        return aD;
    }

    public C19933a getHandleAuthResponseCallbacks() {
        return this.mOg;
    }
}
