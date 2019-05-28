package com.tencent.mm.plugin.walletlock;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.c.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.plugin.messenger.foundation.a.u;
import com.tencent.mm.plugin.walletlock.a.b;
import com.tencent.mm.plugin.walletlock.c.i;
import com.tencent.mm.protocal.protobuf.bcr;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public class PluginWalletLock extends f implements c, com.tencent.mm.plugin.walletlock.a.a {
    private com.tencent.mm.plugin.walletlock.c.f tUZ = null;

    class a implements s<bcr> {
        private a() {
        }

        /* synthetic */ a(PluginWalletLock pluginWalletLock, byte b) {
            this();
        }

        public final /* bridge */ /* synthetic */ void f(com.tencent.mm.bt.a aVar) {
        }

        public final /* synthetic */ void e(com.tencent.mm.bt.a aVar) {
            AppMethodBeat.i(51439);
            ab.i("MicroMsg.PluginWalletLock", "alvinluo afterSyncDoCmd");
            ((b) g.K(b.class)).init();
            AppMethodBeat.o(51439);
        }
    }

    public void installed() {
        AppMethodBeat.i(51440);
        alias(com.tencent.mm.plugin.walletlock.a.a.class);
        AppMethodBeat.o(51440);
    }

    public void dependency() {
        AppMethodBeat.i(51441);
        dependsOn(com.tencent.mm.plugin.soter.a.a.class);
        AppMethodBeat.o(51441);
    }

    public void configure(com.tencent.mm.kernel.b.g gVar) {
        AppMethodBeat.i(51442);
        if (gVar.SG()) {
            ab.i("MicroMsg.PluginWalletLock", "alvinluo registerService IWalletLock and add listeners");
            g.a(b.class, new e(new com.tencent.mm.plugin.walletlock.c.e()));
            u.a(1, new a(this, (byte) 0));
        }
        AppMethodBeat.o(51442);
    }

    public void execute(com.tencent.mm.kernel.b.g gVar) {
    }

    public String name() {
        return "plugin-wallet-lock";
    }

    public void onAccountInitialized(com.tencent.mm.kernel.e.c cVar) {
        String value;
        AppMethodBeat.i(51443);
        ab.i("MicroMsg.PluginWalletLock", "alvinluo PluginWalletLock onAccountInitialized");
        this.tUZ = new com.tencent.mm.plugin.walletlock.c.f();
        com.tencent.mm.plugin.walletlock.c.f fVar = this.tUZ;
        if (!com.tencent.mm.sdk.b.a.xxA.e(fVar.tWT)) {
            com.tencent.mm.sdk.b.a.xxA.c(fVar.tWT);
        }
        if (!com.tencent.mm.sdk.b.a.xxA.e(fVar.tWU)) {
            com.tencent.mm.sdk.b.a.xxA.c(fVar.tWU);
        }
        if (!com.tencent.mm.sdk.b.a.xxA.e(fVar.tWW)) {
            com.tencent.mm.sdk.b.a.xxA.c(fVar.tWW);
        }
        try {
            value = ((com.tencent.mm.plugin.zero.b.a) g.K(com.tencent.mm.plugin.zero.b.a.class)).Nu().getValue("PatternLockTimeInterval");
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.WalletLockInitTask", e, "", new Object[0]);
            value = null;
        }
        if (bo.isNullOrNil(value)) {
            ab.d("MicroMsg.WalletLockInitTask", "PatternLockInterval keeps default value.");
            com.tencent.mm.plugin.walletlock.gesture.a.a.tVy = 300;
        } else {
            int i = bo.getInt(value, 0);
            if (i >= 0) {
                ab.d("MicroMsg.WalletLockInitTask", String.format("Dynamic config for PatternLockInterval override default config, newval=%d", new Object[]{Integer.valueOf(i)}));
                com.tencent.mm.plugin.walletlock.gesture.a.a.tVy = i;
            } else {
                ab.d("MicroMsg.WalletLockInitTask", "PatternLockInterval keeps default value.");
                com.tencent.mm.plugin.walletlock.gesture.a.a.tVy = 300;
            }
        }
        ((b) g.K(b.class)).init();
        AppMethodBeat.o(51443);
    }

    public void onAccountRelease() {
        AppMethodBeat.i(51444);
        ab.i("MicroMsg.PluginWalletLock", "alvinluo PluginWalletLock onAccountRelease");
        if (this.tUZ != null) {
            com.tencent.mm.plugin.walletlock.c.f fVar = this.tUZ;
            if (com.tencent.mm.sdk.b.a.xxA.e(fVar.tWT)) {
                com.tencent.mm.sdk.b.a.xxA.d(fVar.tWT);
            }
            if (com.tencent.mm.sdk.b.a.xxA.e(fVar.tWU)) {
                com.tencent.mm.sdk.b.a.xxA.d(fVar.tWU);
            }
            if (com.tencent.mm.sdk.b.a.xxA.e(fVar.tWW)) {
                com.tencent.mm.sdk.b.a.xxA.d(fVar.tWW);
            }
            i iVar = i.tXc;
            if (iVar.tXg != null) {
                iVar.tXg.clear();
            }
        }
        AppMethodBeat.o(51444);
    }
}
