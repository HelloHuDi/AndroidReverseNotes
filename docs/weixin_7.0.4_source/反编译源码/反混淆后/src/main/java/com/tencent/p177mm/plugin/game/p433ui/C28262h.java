package com.tencent.p177mm.plugin.game.p433ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import android.view.View;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.game.report.api.C45405b;
import com.tencent.p177mm.modelstat.C26483d;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.downloader.model.C2895c;
import com.tencent.p177mm.plugin.downloader.model.C2896d;
import com.tencent.p177mm.plugin.downloader.p1607f.C42911a;
import com.tencent.p177mm.plugin.game.model.C20992c;
import com.tencent.p177mm.plugin.game.model.C20993e;
import com.tencent.p177mm.plugin.game.model.C20998j;
import com.tencent.p177mm.plugin.game.p1485e.C34277b;
import com.tencent.p177mm.plugin.game.p428f.C46001c;
import com.tencent.p177mm.pluginsdk.model.app.C35800q;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.File;

/* renamed from: com.tencent.mm.plugin.game.ui.h */
public final class C28262h extends C12197c {

    /* renamed from: com.tencent.mm.plugin.game.ui.h$1 */
    class C282631 implements OnClickListener {
        C282631() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(111799);
            C28262h.m44833a(C28262h.this);
            dialogInterface.dismiss();
            AppMethodBeat.m2505o(111799);
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.ui.h$2 */
    class C282642 implements OnClickListener {
        C282642() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(111800);
            dialogInterface.dismiss();
            C4990ab.m7416i("MicroMsg.GameClickListener", "resumeDownloadTask not wifi, user cancel");
            AppMethodBeat.m2505o(111800);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m44833a(C28262h c28262h) {
        AppMethodBeat.m2504i(111805);
        c28262h.bFk();
        AppMethodBeat.m2505o(111805);
    }

    public C28262h(Context context) {
        super(context);
    }

    /* renamed from: eB */
    public final void mo46146eB(String str, String str2) {
        this.nek = str;
        this.nel = str2;
    }

    public final void onClick(View view) {
        AppMethodBeat.m2504i(111801);
        if (view.getTag() instanceof C20992c) {
            this.mVZ = (C20992c) view.getTag();
            C4990ab.m7416i("MicroMsg.GameClickListener", "Clicked appid = " + this.mVZ.field_appId);
            bFc();
            if (C46494g.m87757u(this.mContext, this.mVZ.field_appId)) {
                int i;
                int i2;
                if (this.mVZ instanceof C20992c) {
                    int Or = C46001c.m85447Or(this.mVZ.field_packageName);
                    i = this.mVZ.versionCode;
                    i2 = Or;
                } else {
                    i = 0;
                    i2 = 0;
                }
                if (i > i2) {
                    C4990ab.m7417i("MicroMsg.GameClickListener", "AppId: %s installed, local: %d, server: %d", this.mVZ.field_appId, Integer.valueOf(i2), Integer.valueOf(i));
                    C20998j.m32287a(this.mVZ.dna, this.mVZ.dnf, this.mVZ.cKG, this.mVZ.field_appId, this.nej, "app_update");
                    if (this.neh.status == 1) {
                        C4990ab.m7416i("MicroMsg.GameClickListener", "pauseDownloadTask ret = ".concat(String.valueOf(C28262h.m44834hn(this.neh.f16167id))));
                        AppMethodBeat.m2505o(111801);
                        return;
                    } else if (this.neh.status == 2) {
                        bFj();
                        AppMethodBeat.m2505o(111801);
                        return;
                    } else if (this.neh.status != 3) {
                        mo24029hP(true);
                        AppMethodBeat.m2505o(111801);
                        return;
                    } else if (!C1173e.m2561ct(this.neh.path) || C46001c.m85448Os(this.neh.path) <= i2) {
                        mo24029hP(true);
                        AppMethodBeat.m2505o(111801);
                        return;
                    } else {
                        C35800q.m58697a(this.mContext, Uri.fromFile(new File(this.neh.path)), null);
                        C34277b.m56212a(this.mContext, this.mVZ.scene, this.mVZ.cKG, this.mVZ.position, 8, this.mVZ.field_appId, this.mXC, this.mVZ.ctu, this.nek);
                        AppMethodBeat.m2505o(111801);
                        return;
                    }
                }
                C4990ab.m7417i("MicroMsg.GameClickListener", "launchFromWX, appId = %s, pkg = %s, openId = %s", this.mVZ.field_appId, this.mVZ.field_packageName, this.mVZ.field_openId);
                C34277b.m56212a(this.mContext, this.mVZ.scene, this.mVZ.cKG, this.mVZ.position, 3, this.mVZ.field_appId, this.mXC, this.mVZ.ctu, this.nek);
                bFb();
                AppMethodBeat.m2505o(111801);
                return;
            } else if (this.mVZ.bDP()) {
                C46001c.m85464t(this.mContext, this.mVZ.mVF.ncG, "game_center_hv_game");
                C34277b.m56212a(this.mContext, this.mVZ.scene, this.mVZ.cKG, this.mVZ.position, 29, this.mVZ.field_appId, this.mXC, this.mVZ.ctu, this.nek);
                AppMethodBeat.m2505o(111801);
                return;
            } else {
                C20998j.m32287a(this.mVZ.dna, this.mVZ.dnf, this.mVZ.cKG, this.mVZ.field_appId, this.nej, this.nel);
                switch (this.mStatus) {
                    case 1:
                        C4990ab.m7416i("MicroMsg.GameClickListener", "pauseDownloadTask ret = ".concat(String.valueOf(C28262h.m44834hn(this.neh.f16167id))));
                        AppMethodBeat.m2505o(111801);
                        return;
                    case 2:
                        bFj();
                        AppMethodBeat.m2505o(111801);
                        return;
                    case 3:
                        if (!C5046bo.isNullOrNil(this.neg) && C1173e.m2561ct(this.neg) && C46001c.m85458eC(this.neg, this.nei.field_md5)) {
                            C46001c.m85461iQ(this.nei.field_downloadId);
                            C34277b.m56212a(this.mContext, this.mVZ.scene, this.mVZ.cKG, this.mVZ.position, 8, this.mVZ.field_appId, this.mXC, this.mVZ.ctu, this.nek);
                            AppMethodBeat.m2505o(111801);
                            return;
                        }
                        mo24029hP(false);
                        AppMethodBeat.m2505o(111801);
                        return;
                    default:
                        mo24029hP(false);
                        AppMethodBeat.m2505o(111801);
                        return;
                }
            }
        }
        C4990ab.m7412e("MicroMsg.GameClickListener", "No AppInfo");
        AppMethodBeat.m2505o(111801);
    }

    private void bFj() {
        AppMethodBeat.m2504i(111802);
        if (!C5023at.isNetworkConnected(this.mContext)) {
            Toast.makeText(this.mContext, this.mContext.getString(C25738R.string.c5d), 0).show();
            AppMethodBeat.m2505o(111802);
        } else if (C5023at.isWifi(this.mContext)) {
            bFk();
            AppMethodBeat.m2505o(111802);
        } else {
            C30379h.m48446a(this.mContext, this.mContext.getString(C25738R.string.fy6), this.mContext.getString(C25738R.string.fy7), this.mContext.getString(C25738R.string.fy1), this.mContext.getString(C25738R.string.f9076or), false, new C282631(), new C282642(), (int) C25738R.color.a61);
            AppMethodBeat.m2505o(111802);
        }
    }

    /* renamed from: hn */
    private static boolean m44834hn(long j) {
        AppMethodBeat.m2504i(111804);
        C42911a hv = C2895c.m5147hv(j);
        if (hv != null && hv.field_downloadInWifi) {
            hv.field_downloadInWifi = false;
            C2895c.m5146e(hv);
        }
        boolean hn = C2896d.bij().mo7049hn(j);
        AppMethodBeat.m2505o(111804);
        return hn;
    }

    private void bFk() {
        AppMethodBeat.m2504i(111803);
        C45405b.eBF.mo73200a(this.mVZ.field_appId, this.mVZ.cKG, 10, this.nei.field_downloadId, "", null);
        C26483d.m42196b(10, "GameClickListener_resumeDownloadTask", hashCode());
        if (C2896d.bij().mo7050ho(this.nei.field_downloadId)) {
            C20993e.m32266ar(this.mContext, this.mVZ.field_appId);
            C34277b.m56212a(this.mContext, this.mVZ.scene, this.mVZ.cKG, this.mVZ.position, 4, this.mVZ.field_appId, this.mXC, this.mVZ.ctu, this.nek);
            AppMethodBeat.m2505o(111803);
            return;
        }
        C4990ab.m7412e("MicroMsg.GameClickListener", "resumeDownloadTask false");
        C2896d.bij().mo7047hl(this.nei.field_downloadId);
        mo24029hP(false);
        AppMethodBeat.m2505o(111803);
    }
}
