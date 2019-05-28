package com.tencent.p177mm.plugin.game.commlib;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.smtt.sdk.TbsDownloadConfig;

/* renamed from: com.tencent.mm.plugin.game.commlib.b */
public class C20945b implements C1202f {
    private static C20945b mTt;
    private boolean fpA = false;

    public static C20945b bDn() {
        AppMethodBeat.m2504i(59399);
        if (mTt == null) {
            synchronized (C20945b.class) {
                try {
                    if (mTt == null) {
                        mTt = new C20945b();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(59399);
                    }
                }
            }
        }
        C20945b c20945b = mTt;
        AppMethodBeat.m2505o(59399);
        return c20945b;
    }

    private void release() {
        AppMethodBeat.m2504i(59401);
        this.fpA = false;
        C1720g.m3540Rg().mo14546b(1311, (C1202f) this);
        AppMethodBeat.m2505o(59401);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(59402);
        if (c1207m.getType() == 1311) {
            C4990ab.m7417i("MicroMsg.GameConfigUpdater", "getGameCenterGlobalSetting sceneEnd, %s, %s", Integer.valueOf(i), Integer.valueOf(i2));
            if (C1720g.m3534RN().mo5161QY()) {
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_GAME_GLOBAL_CONFIG_UPDATE_TIME_LONG, Long.valueOf(C5046bo.anT()));
            } else {
                C4990ab.m7420w("MicroMsg.GameConfigUpdater", "account not init.");
            }
            release();
        }
        AppMethodBeat.m2505o(59402);
    }

    /* JADX WARNING: Missing block: B:11:0x0017, code skipped:
            if (r0 != null) goto L_0x0019;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: hI */
    public final synchronized void mo36287hI(boolean z) {
        Object obj;
        AppMethodBeat.m2504i(59400);
        if (z) {
            obj = 1;
        } else if (C5046bo.m7549fp(C5046bo.m7534c((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_GAME_GLOBAL_CONFIG_UPDATE_TIME_LONG, Long.valueOf(0)))) > TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC) {
            int obj2 = 1;
        } else {
            obj2 = null;
        }
        if (obj2 == null) {
            if (C5730e.m8628ct(C45985a.mTr)) {
                obj2 = null;
            } else {
                obj2 = 1;
            }
        }
        if (!this.fpA) {
            C4990ab.m7417i("MicroMsg.GameConfigUpdater", "Game config start update. force update(%b)", Boolean.valueOf(z));
            release();
            this.fpA = true;
            C1720g.m3540Rg().mo14539a(1311, (C1202f) this);
            C1720g.m3540Rg().mo14541a(new C34262c(), 0);
        }
        AppMethodBeat.m2505o(59400);
    }
}
