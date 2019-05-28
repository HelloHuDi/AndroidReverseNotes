package com.tencent.p177mm.plugin.wepkg;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1706e.C1705c;
import com.tencent.p177mm.kernel.api.bucket.C9562c;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.kernel.p241b.C7597f;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.plugin.game.commlib.C45985a;
import com.tencent.p177mm.plugin.game.commlib.p1403c.C28179a;
import com.tencent.p177mm.plugin.game.commlib.p1403c.C39182b;
import com.tencent.p177mm.plugin.game.p1268a.C43155a;
import com.tencent.p177mm.plugin.game.p1268a.C43155a.C20928a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.wepkg.downloader.C35757i;
import com.tencent.p177mm.plugin.wepkg.p1076b.C44021f;
import com.tencent.p177mm.plugin.wepkg.p1566a.C40392a;
import com.tencent.p177mm.plugin.wepkg.utils.C30022d;
import com.tencent.p177mm.plugin.wepkg.utils.C35769c;
import com.tencent.p177mm.plugin.wepkg.version.WepkgVersionUpdater;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.wepkg.PluginWePkg */
public class PluginWePkg extends C7597f implements C9562c, C40392a {
    private C35769c uVp;

    /* renamed from: com.tencent.mm.plugin.wepkg.PluginWePkg$1 */
    class C231941 implements C39182b {

        /* renamed from: com.tencent.mm.plugin.wepkg.PluginWePkg$1$1 */
        class C231951 implements Runnable {
            C231951() {
            }

            public final void run() {
                boolean bCS;
                boolean z;
                AppMethodBeat.m2504i(63345);
                C43155a bDb = C20928a.bDb();
                if (bDb != null) {
                    C4996ah.getContext();
                    bCS = bDb.bCS();
                } else {
                    bCS = false;
                }
                int i = (C1853r.m3823YE() & 8388608) != 0 ? 1 : 0;
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
                C4990ab.m7417i(str, str2, objArr);
                if (bCS && i == 0) {
                    List bDj = C45985a.bDj();
                    List bDk = C45985a.bDk();
                    if (bDj == null) {
                        bDj = new ArrayList();
                    }
                    C4990ab.m7417i("MicroMsg.Wepkg.WepkgVersionUpdater", "pkgIdsForAll size:%d", Integer.valueOf(bDj.size()));
                    if (bDk == null) {
                        bDk = new ArrayList();
                    }
                    C4990ab.m7417i("MicroMsg.Wepkg.WepkgVersionUpdater", "pkgIdsIfExists size:%d", Integer.valueOf(bDk.size()));
                    List dgq = C44021f.dgp().dgq();
                    if (dgq == null) {
                        dgq = new ArrayList();
                    }
                    C4990ab.m7417i("MicroMsg.Wepkg.WepkgVersionUpdater", "localPkgIdList size:%d", Integer.valueOf(dgq.size()));
                    HashSet hashSet = new HashSet();
                    hashSet.addAll(dgq);
                    hashSet.retainAll(bDk);
                    hashSet.addAll(bDj);
                    WepkgVersionUpdater.m23052a(hashSet, 2, true);
                }
                AppMethodBeat.m2505o(63345);
            }
        }

        C231941() {
        }

        /* renamed from: Pi */
        public final void mo38820Pi() {
            AppMethodBeat.m2504i(63346);
            C30022d.aNS().mo10302aa(new C231951());
            AppMethodBeat.m2505o(63346);
        }
    }

    public void configure(C1681g c1681g) {
    }

    public void execute(C1681g c1681g) {
        AppMethodBeat.m2504i(63347);
        if (c1681g.mo5181SG()) {
            C28179a.m44758a(new C231941());
        }
        if (c1681g.mo5183lQ(":tools")) {
            try {
                C40393b.biO();
                AppMethodBeat.m2505o(63347);
                return;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.WePkg.PluginWePkg", e, "", new Object[0]);
                C7060h.pYm.mo8378a(859, 19, 1, false);
            }
        }
        AppMethodBeat.m2505o(63347);
    }

    public void onAccountInitialized(C1705c c1705c) {
        AppMethodBeat.m2504i(63348);
        if (this.uVp == null) {
            this.uVp = new C35769c();
        }
        C35769c c35769c = this.uVp;
        C4990ab.m7416i("MicroMsg.Wepkg.WepkgListener", "wepkg start listen");
        C4879a.xxA.mo10052c(c35769c.uXX);
        C4879a.xxA.mo10052c(c35769c.uXW);
        C35757i.bie();
        Context context = C4996ah.getContext();
        if (context != null) {
            try {
                SharedPreferences sharedPreferences = context.getSharedPreferences("we_pkg_sp", 4);
                if (sharedPreferences == null) {
                    C4990ab.m7412e("MicroMsg.Wepkg.WepkgListener", "sp is null");
                    AppMethodBeat.m2505o(63348);
                    return;
                }
                if (sharedPreferences.getBoolean("disable_we_pkg", false)) {
                    C4990ab.m7416i("MicroMsg.Wepkg.WepkgListener", "enable wepkg");
                    sharedPreferences.edit().putBoolean("disable_we_pkg", false).commit();
                }
                sharedPreferences.edit().putInt("white_screen_times", 0).commit();
                AppMethodBeat.m2505o(63348);
                return;
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.Wepkg.WepkgListener", e.getMessage());
            }
        }
        AppMethodBeat.m2505o(63348);
    }

    public void onAccountRelease() {
        AppMethodBeat.m2504i(63349);
        C35769c c35769c = this.uVp;
        C4990ab.m7416i("MicroMsg.Wepkg.WepkgListener", "wepkg stop listen");
        C4879a.xxA.mo10053d(c35769c.uXX);
        C4879a.xxA.mo10053d(c35769c.uXW);
        C35757i.bgr();
        C30022d.aNR();
        this.uVp = null;
        AppMethodBeat.m2505o(63349);
    }
}
