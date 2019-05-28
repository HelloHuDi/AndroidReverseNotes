package com.tencent.mm.plugin.wepkg;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.game.commlib.c.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wepkg.a.a;
import com.tencent.mm.plugin.wepkg.downloader.i;
import com.tencent.mm.plugin.wepkg.utils.d;
import com.tencent.mm.plugin.wepkg.version.WepkgVersionUpdater;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PluginWePkg extends f implements c, a {
    private com.tencent.mm.plugin.wepkg.utils.c uVp;

    public void configure(g gVar) {
    }

    public void execute(g gVar) {
        AppMethodBeat.i(63347);
        if (gVar.SG()) {
            com.tencent.mm.plugin.game.commlib.c.a.a(new b() {
                public final void Pi() {
                    AppMethodBeat.i(63346);
                    d.aNS().aa(new Runnable() {
                        public final void run() {
                            boolean bCS;
                            boolean z;
                            AppMethodBeat.i(63345);
                            com.tencent.mm.plugin.game.a.a bDb = com.tencent.mm.plugin.game.a.a.a.bDb();
                            if (bDb != null) {
                                ah.getContext();
                                bCS = bDb.bCS();
                            } else {
                                bCS = false;
                            }
                            int i = (r.YE() & 8388608) != 0 ? 1 : 0;
                            String str = "MicroMsg.WePkg.PluginWePkg";
                            String str2 = "shouldShowGame %s, openGameEntry %s";
                            Object[] objArr = new Object[2];
                            objArr[0] = Boolean.valueOf(bCS);
                            if (i == 0) {
                                z = true;
                            } else {
                                z = false;
                            }
                            objArr[1] = Boolean.valueOf(z);
                            ab.i(str, str2, objArr);
                            if (bCS && i == 0) {
                                List bDj = com.tencent.mm.plugin.game.commlib.a.bDj();
                                List bDk = com.tencent.mm.plugin.game.commlib.a.bDk();
                                if (bDj == null) {
                                    bDj = new ArrayList();
                                }
                                ab.i("MicroMsg.Wepkg.WepkgVersionUpdater", "pkgIdsForAll size:%d", Integer.valueOf(bDj.size()));
                                if (bDk == null) {
                                    bDk = new ArrayList();
                                }
                                ab.i("MicroMsg.Wepkg.WepkgVersionUpdater", "pkgIdsIfExists size:%d", Integer.valueOf(bDk.size()));
                                List dgq = com.tencent.mm.plugin.wepkg.b.f.dgp().dgq();
                                if (dgq == null) {
                                    dgq = new ArrayList();
                                }
                                ab.i("MicroMsg.Wepkg.WepkgVersionUpdater", "localPkgIdList size:%d", Integer.valueOf(dgq.size()));
                                HashSet hashSet = new HashSet();
                                hashSet.addAll(dgq);
                                hashSet.retainAll(bDk);
                                hashSet.addAll(bDj);
                                WepkgVersionUpdater.a(hashSet, 2, true);
                            }
                            AppMethodBeat.o(63345);
                        }
                    });
                    AppMethodBeat.o(63346);
                }
            });
        }
        if (gVar.lQ(":tools")) {
            try {
                b.biO();
                AppMethodBeat.o(63347);
                return;
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.WePkg.PluginWePkg", e, "", new Object[0]);
                h.pYm.a(859, 19, 1, false);
            }
        }
        AppMethodBeat.o(63347);
    }

    public void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(63348);
        if (this.uVp == null) {
            this.uVp = new com.tencent.mm.plugin.wepkg.utils.c();
        }
        com.tencent.mm.plugin.wepkg.utils.c cVar2 = this.uVp;
        ab.i("MicroMsg.Wepkg.WepkgListener", "wepkg start listen");
        com.tencent.mm.sdk.b.a.xxA.c(cVar2.uXX);
        com.tencent.mm.sdk.b.a.xxA.c(cVar2.uXW);
        i.bie();
        Context context = ah.getContext();
        if (context != null) {
            try {
                SharedPreferences sharedPreferences = context.getSharedPreferences("we_pkg_sp", 4);
                if (sharedPreferences == null) {
                    ab.e("MicroMsg.Wepkg.WepkgListener", "sp is null");
                    AppMethodBeat.o(63348);
                    return;
                }
                if (sharedPreferences.getBoolean("disable_we_pkg", false)) {
                    ab.i("MicroMsg.Wepkg.WepkgListener", "enable wepkg");
                    sharedPreferences.edit().putBoolean("disable_we_pkg", false).commit();
                }
                sharedPreferences.edit().putInt("white_screen_times", 0).commit();
                AppMethodBeat.o(63348);
                return;
            } catch (Exception e) {
                ab.e("MicroMsg.Wepkg.WepkgListener", e.getMessage());
            }
        }
        AppMethodBeat.o(63348);
    }

    public void onAccountRelease() {
        AppMethodBeat.i(63349);
        com.tencent.mm.plugin.wepkg.utils.c cVar = this.uVp;
        ab.i("MicroMsg.Wepkg.WepkgListener", "wepkg stop listen");
        com.tencent.mm.sdk.b.a.xxA.d(cVar.uXX);
        com.tencent.mm.sdk.b.a.xxA.d(cVar.uXW);
        i.bgr();
        d.aNR();
        this.uVp = null;
        AppMethodBeat.o(63349);
    }
}
