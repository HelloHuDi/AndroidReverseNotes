package com.tencent.p177mm.plugin.radar;

import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.kernel.p241b.C7597f;
import com.tencent.p177mm.model.C7485q;
import com.tencent.p177mm.p842bp.C9204c;
import com.tencent.p177mm.plugin.radar.p1290a.C21554a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \t2\u00020\u00012\u00020\u0002:\u0001\tB\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\n"}, dWq = {"Lcom/tencent/mm/plugin/radar/PluginRadar;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/radar/api/IPluginRadar;", "()V", "configure", "", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "execute", "Companion", "plugin-radar_release"})
/* renamed from: com.tencent.mm.plugin.radar.PluginRadar */
public final class PluginRadar extends C7597f implements C21554a {
    private static final String TAG = TAG;
    public static final C34760a pAF = new C34760a();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, dWq = {"Lcom/tencent/mm/plugin/radar/PluginRadar$Companion;", "", "()V", "TAG", "", "plugin-radar_release"})
    /* renamed from: com.tencent.mm.plugin.radar.PluginRadar$a */
    public static final class C34760a {
        private C34760a() {
        }

        public /* synthetic */ C34760a(byte b) {
            this();
        }
    }

    public final void configure(C1681g c1681g) {
        AppMethodBeat.m2504i(102846);
        C25052j.m39376p(c1681g, Scopes.PROFILE);
        if (c1681g.mo5181SG()) {
            C4990ab.m7416i(TAG, "PluginRadar configure");
            pin(new C7485q(C34766b.class));
        }
        AppMethodBeat.m2505o(102846);
    }

    public final void execute(C1681g c1681g) {
        AppMethodBeat.m2504i(102847);
        C25052j.m39376p(c1681g, Scopes.PROFILE);
        C9204c.aks("radar");
        AppMethodBeat.m2505o(102847);
    }

    static {
        AppMethodBeat.m2504i(102848);
        AppMethodBeat.m2505o(102848);
    }
}
