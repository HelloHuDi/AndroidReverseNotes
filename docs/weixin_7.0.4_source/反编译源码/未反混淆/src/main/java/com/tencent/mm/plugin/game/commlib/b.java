package com.tencent.mm.plugin.game.commlib;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.vfs.e;
import com.tencent.smtt.sdk.TbsDownloadConfig;

public class b implements f {
    private static b mTt;
    private boolean fpA = false;

    public static b bDn() {
        AppMethodBeat.i(59399);
        if (mTt == null) {
            synchronized (b.class) {
                try {
                    if (mTt == null) {
                        mTt = new b();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(59399);
                    }
                }
            }
        }
        b bVar = mTt;
        AppMethodBeat.o(59399);
        return bVar;
    }

    private void release() {
        AppMethodBeat.i(59401);
        this.fpA = false;
        g.Rg().b(1311, (f) this);
        AppMethodBeat.o(59401);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(59402);
        if (mVar.getType() == 1311) {
            ab.i("MicroMsg.GameConfigUpdater", "getGameCenterGlobalSetting sceneEnd, %s, %s", Integer.valueOf(i), Integer.valueOf(i2));
            if (g.RN().QY()) {
                g.RP().Ry().set(a.USERINFO_GAME_GLOBAL_CONFIG_UPDATE_TIME_LONG, Long.valueOf(bo.anT()));
            } else {
                ab.w("MicroMsg.GameConfigUpdater", "account not init.");
            }
            release();
        }
        AppMethodBeat.o(59402);
    }

    /* JADX WARNING: Missing block: B:11:0x0017, code skipped:
            if (r0 != null) goto L_0x0019;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void hI(boolean z) {
        Object obj;
        AppMethodBeat.i(59400);
        if (z) {
            obj = 1;
        } else if (bo.fp(bo.c((Long) g.RP().Ry().get(a.USERINFO_GAME_GLOBAL_CONFIG_UPDATE_TIME_LONG, Long.valueOf(0)))) > TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC) {
            int obj2 = 1;
        } else {
            obj2 = null;
        }
        if (obj2 == null) {
            if (e.ct(a.mTr)) {
                obj2 = null;
            } else {
                obj2 = 1;
            }
        }
        if (!this.fpA) {
            ab.i("MicroMsg.GameConfigUpdater", "Game config start update. force update(%b)", Boolean.valueOf(z));
            release();
            this.fpA = true;
            g.Rg().a(1311, (f) this);
            g.Rg().a(new c(), 0);
        }
        AppMethodBeat.o(59400);
    }
}
