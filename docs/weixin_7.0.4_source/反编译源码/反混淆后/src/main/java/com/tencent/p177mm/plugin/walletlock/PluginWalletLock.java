package com.tencent.p177mm.plugin.walletlock;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1706e.C1705c;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.api.C1671c;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.kernel.p241b.C7597f;
import com.tencent.p177mm.kernel.p242c.C6625e;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C21281u;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C28495s;
import com.tencent.p177mm.plugin.soter.p1503a.C35148a;
import com.tencent.p177mm.plugin.walletlock.gesture.p1059a.C29714a;
import com.tencent.p177mm.plugin.walletlock.p1319c.C22716e;
import com.tencent.p177mm.plugin.walletlock.p1319c.C22717f;
import com.tencent.p177mm.plugin.walletlock.p1319c.C40172i;
import com.tencent.p177mm.plugin.walletlock.p1418a.C29709a;
import com.tencent.p177mm.plugin.walletlock.p1418a.C40167b;
import com.tencent.p177mm.plugin.zero.p757b.C7234a;
import com.tencent.p177mm.protocal.protobuf.bcr;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.walletlock.PluginWalletLock */
public class PluginWalletLock extends C7597f implements C1671c, C29709a {
    private C22717f tUZ = null;

    /* renamed from: com.tencent.mm.plugin.walletlock.PluginWalletLock$a */
    class C35537a implements C28495s<bcr> {
        private C35537a() {
        }

        /* synthetic */ C35537a(PluginWalletLock pluginWalletLock, byte b) {
            this();
        }

        /* renamed from: f */
        public final /* bridge */ /* synthetic */ void mo35244f(C1331a c1331a) {
        }

        /* renamed from: e */
        public final /* synthetic */ void mo35243e(C1331a c1331a) {
            AppMethodBeat.m2504i(51439);
            C4990ab.m7416i("MicroMsg.PluginWalletLock", "alvinluo afterSyncDoCmd");
            ((C40167b) C1720g.m3528K(C40167b.class)).init();
            AppMethodBeat.m2505o(51439);
        }
    }

    public void installed() {
        AppMethodBeat.m2504i(51440);
        alias(C29709a.class);
        AppMethodBeat.m2505o(51440);
    }

    public void dependency() {
        AppMethodBeat.m2504i(51441);
        dependsOn(C35148a.class);
        AppMethodBeat.m2505o(51441);
    }

    public void configure(C1681g c1681g) {
        AppMethodBeat.m2504i(51442);
        if (c1681g.mo5181SG()) {
            C4990ab.m7416i("MicroMsg.PluginWalletLock", "alvinluo registerService IWalletLock and add listeners");
            C1720g.m3543a(C40167b.class, new C6625e(new C22716e()));
            C21281u.m32651a(1, new C35537a(this, (byte) 0));
        }
        AppMethodBeat.m2505o(51442);
    }

    public void execute(C1681g c1681g) {
    }

    public String name() {
        return "plugin-wallet-lock";
    }

    public void onAccountInitialized(C1705c c1705c) {
        String value;
        AppMethodBeat.m2504i(51443);
        C4990ab.m7416i("MicroMsg.PluginWalletLock", "alvinluo PluginWalletLock onAccountInitialized");
        this.tUZ = new C22717f();
        C22717f c22717f = this.tUZ;
        if (!C4879a.xxA.mo10054e(c22717f.tWT)) {
            C4879a.xxA.mo10052c(c22717f.tWT);
        }
        if (!C4879a.xxA.mo10054e(c22717f.tWU)) {
            C4879a.xxA.mo10052c(c22717f.tWU);
        }
        if (!C4879a.xxA.mo10054e(c22717f.tWW)) {
            C4879a.xxA.mo10052c(c22717f.tWW);
        }
        try {
            value = ((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getValue("PatternLockTimeInterval");
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.WalletLockInitTask", e, "", new Object[0]);
            value = null;
        }
        if (C5046bo.isNullOrNil(value)) {
            C4990ab.m7410d("MicroMsg.WalletLockInitTask", "PatternLockInterval keeps default value.");
            C29714a.tVy = 300;
        } else {
            int i = C5046bo.getInt(value, 0);
            if (i >= 0) {
                C4990ab.m7410d("MicroMsg.WalletLockInitTask", String.format("Dynamic config for PatternLockInterval override default config, newval=%d", new Object[]{Integer.valueOf(i)}));
                C29714a.tVy = i;
            } else {
                C4990ab.m7410d("MicroMsg.WalletLockInitTask", "PatternLockInterval keeps default value.");
                C29714a.tVy = 300;
            }
        }
        ((C40167b) C1720g.m3528K(C40167b.class)).init();
        AppMethodBeat.m2505o(51443);
    }

    public void onAccountRelease() {
        AppMethodBeat.m2504i(51444);
        C4990ab.m7416i("MicroMsg.PluginWalletLock", "alvinluo PluginWalletLock onAccountRelease");
        if (this.tUZ != null) {
            C22717f c22717f = this.tUZ;
            if (C4879a.xxA.mo10054e(c22717f.tWT)) {
                C4879a.xxA.mo10053d(c22717f.tWT);
            }
            if (C4879a.xxA.mo10054e(c22717f.tWU)) {
                C4879a.xxA.mo10053d(c22717f.tWU);
            }
            if (C4879a.xxA.mo10054e(c22717f.tWW)) {
                C4879a.xxA.mo10053d(c22717f.tWW);
            }
            C40172i c40172i = C40172i.tXc;
            if (c40172i.tXg != null) {
                c40172i.tXg.clear();
            }
        }
        AppMethodBeat.m2505o(51444);
    }
}
