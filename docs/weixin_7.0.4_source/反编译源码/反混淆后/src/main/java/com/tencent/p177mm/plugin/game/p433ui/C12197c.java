package com.tencent.p177mm.plugin.game.p433ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.Settings.Secure;
import android.provider.Settings.SettingNotFoundException;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C1445f;
import com.tencent.p177mm.game.report.api.C45405b;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelstat.C26483d;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.downloader.model.C2895c;
import com.tencent.p177mm.plugin.downloader.model.C2896d;
import com.tencent.p177mm.plugin.downloader.model.C2900e.C2901a;
import com.tencent.p177mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.p177mm.plugin.downloader.p1607f.C42911a;
import com.tencent.p177mm.plugin.downloader.p939a.C11498a;
import com.tencent.p177mm.plugin.game.model.C20992c;
import com.tencent.p177mm.plugin.game.model.C20993e;
import com.tencent.p177mm.plugin.game.model.C20998j;
import com.tencent.p177mm.plugin.game.p1485e.C34277b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.model.app.C35800q;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.game.ui.c */
public abstract class C12197c implements OnClickListener {
    protected long hxO = -1;
    protected Context mContext;
    protected int mStatus = -1;
    protected C20992c mVZ = null;
    protected int mXC;
    protected String neg;
    protected FileDownloadTaskInfo neh;
    protected C42911a nei;
    protected String nej;
    protected String nek;
    protected String nel;
    private String nem = "xiaomi";

    /* renamed from: com.tencent.mm.plugin.game.ui.c$2 */
    class C121982 implements DialogInterface.OnClickListener {
        C121982() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(111699);
            C7060h.pYm.mo8381e(14217, C12197c.this.mVZ.field_appId, Integer.valueOf(6), "", C12197c.this.mVZ.dna, Integer.valueOf(2));
            dialogInterface.dismiss();
            C4990ab.m7416i("MicroMsg.CommonGameClickLinstener", "addDownloadTask not wifi, user cancel");
            AppMethodBeat.m2505o(111699);
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.ui.c$3 */
    class C121993 implements DialogInterface.OnClickListener {
        C121993() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(111700);
            C12197c.this.mContext.startActivity(new Intent("android.settings.SECURITY_SETTINGS"));
            dialogInterface.cancel();
            AppMethodBeat.m2505o(111700);
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.ui.c$4 */
    class C122004 implements DialogInterface.OnClickListener {
        C122004() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(111701);
            dialogInterface.cancel();
            AppMethodBeat.m2505o(111701);
        }
    }

    public C12197c(Context context) {
        this.mContext = context;
    }

    public final void setSourceScene(int i) {
        this.mXC = i;
    }

    /* Access modifiers changed, original: protected|final */
    public final void bFb() {
        C20993e.m32265ak(this.mContext, this.mVZ.field_appId);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: hP */
    public final void mo24029hP(final boolean z) {
        if (C5023at.isNetworkConnected(this.mContext)) {
            C1720g.m3537RQ();
            if (!C1720g.m3536RP().isSDCardAvailable()) {
                Toast.makeText(this.mContext, this.mContext.getString(C25738R.string.c5h), 0).show();
                C20998j.bEg();
                C20998j.m32285a(this.mVZ.field_appId, C11498a.kJY, false, null);
                return;
            } else if (C1445f.m3072eW(this.mVZ.mVE)) {
                if (C7243d.vxi.toLowerCase().contains(this.nem)) {
                    try {
                        if (Secure.getInt(this.mContext.getContentResolver(), "install_non_market_apps") == 0 && !C20993e.m32273dZ(this.mContext)) {
                            C30379h.m48429a(this.mContext, (int) C25738R.string.c84, (int) C25738R.string.c85, (int) C25738R.string.c5v, (int) C25738R.string.f9076or, false, new C121993(), new C122004());
                            C20993e.m32274ea(this.mContext);
                        }
                    } catch (SettingNotFoundException e) {
                        C4990ab.m7413e("MicroMsg.CommonGameClickLinstener", "SettingNotFoundException ; %S", e.getMessage());
                    }
                }
                if (C5046bo.isNullOrNil(this.mVZ.dna) || C5046bo.isNullOrNil(this.mVZ.dnf)) {
                    C4990ab.m7410d("MicroMsg.CommonGameClickLinstener", "downloadApk: appdownloadurl is null or appmd5 is null, try gpDownload");
                    if (C5046bo.isNullOrNil(this.mVZ.dng)) {
                        C4990ab.m7412e("MicroMsg.CommonGameClickLinstener", "downloadApk fail, gpDownloadUrl is null");
                    } else {
                        boolean by = C35800q.m58699by(this.mContext, this.mVZ.dng);
                        C4990ab.m7411d("MicroMsg.CommonGameClickLinstener", "downloadApk with gp, ret = %b", Boolean.valueOf(by));
                    }
                    if (C5046bo.isNullOrNil(this.mVZ.dna)) {
                        C20998j.bEg();
                        C20998j.m32285a(this.mVZ.field_appId, C11498a.DOWNLOAD_ERR_URL_INVALID, false, null);
                    }
                    if (C5046bo.isNullOrNil(this.mVZ.dnf)) {
                        C20998j.bEg();
                        C20998j.m32285a(this.mVZ.field_appId, C11498a.kJV, false, null);
                        return;
                    }
                    return;
                }
                C34277b.m56212a(this.mContext, this.mVZ.scene, this.mVZ.cKG, this.mVZ.position, 4, this.mVZ.field_appId, this.mXC, this.mVZ.ctu, this.nek);
                if (C5023at.isWifi(this.mContext)) {
                    m20130hQ(z);
                    return;
                }
                C7060h.pYm.mo8381e(14217, this.mVZ.field_appId, Integer.valueOf(4), "", this.mVZ.dna, Integer.valueOf(2));
                C30379h.m48446a(this.mContext, this.mContext.getString(C25738R.string.fy6), this.mContext.getString(C25738R.string.fy7), this.mContext.getString(C25738R.string.fy1), this.mContext.getString(C25738R.string.f9076or), false, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(111698);
                        C7060h.pYm.mo8381e(14217, C12197c.this.mVZ.field_appId, Integer.valueOf(5), "", C12197c.this.mVZ.dna, Integer.valueOf(2));
                        C12197c.this.m20130hQ(z);
                        dialogInterface.dismiss();
                        AppMethodBeat.m2505o(111698);
                    }
                }, new C121982(), (int) C25738R.color.a61);
                return;
            } else {
                Toast.makeText(this.mContext, this.mContext.getString(C25738R.string.c5e), 0).show();
                C20998j.bEg();
                C20998j.m32285a(this.mVZ.field_appId, C11498a.kJY, false, null);
                return;
            }
        }
        Toast.makeText(this.mContext, this.mContext.getString(C25738R.string.c5d), 0).show();
        C20998j.bEg();
        C20998j.m32285a(this.mVZ.field_appId, C11498a.kJX, false, null);
    }

    /* renamed from: hQ */
    private void m20130hQ(boolean z) {
        long b;
        if (z) {
            C20998j.m32287a(this.mVZ.dna, this.mVZ.dnf, this.mVZ.cKG, this.mVZ.field_appId, this.nej, "app_update");
        } else {
            C20998j.m32287a(this.mVZ.dna, this.mVZ.dnf, this.mVZ.cKG, this.mVZ.field_appId, this.nej, this.nel);
        }
        C2901a c2901a = new C2901a();
        c2901a.mo7055It(this.mVZ.dna);
        c2901a.mo7056Iu(this.mVZ.mVD);
        c2901a.mo7066hA(this.mVZ.mVE);
        c2901a.mo7057Iv(C46494g.m87733b(this.mContext, this.mVZ, null));
        c2901a.setAppId(this.mVZ.field_appId);
        c2901a.mo7058Iw(this.mVZ.dnf);
        c2901a.mo7063ga(true);
        c2901a.mo7069tN(1);
        c2901a.mo7062cY(this.mVZ.field_packageName);
        c2901a.setScene(this.mVZ.cKG);
        if (this.mVZ.cBA == 1) {
            b = C2896d.bij().mo7043b(c2901a.kNl);
        } else {
            b = C2896d.bij().mo7042a(c2901a.kNl);
        }
        C4990ab.m7417i("MicroMsg.CommonGameClickLinstener", " add download task result:[%d], appid[%s]，downloaerType[%d]", Long.valueOf(b), this.mVZ.field_appId, Integer.valueOf(this.mVZ.cBA));
        C20993e.m32266ar(this.mContext, this.mVZ.field_appId);
        C45405b.eBF.mo73200a(this.mVZ.field_appId, this.mVZ.cKG, 9, b, "", null);
        C26483d.m42196b(10, "CommonGameClickListener_addDownloadTask", hashCode());
    }

    /* Access modifiers changed, original: protected|final */
    public final void bFc() {
        this.nei = C2895c.m5140In(this.mVZ.field_appId);
        this.neh = C2896d.bij().mo7040Ir(this.mVZ.field_appId);
        this.hxO = this.neh.f16167id;
        this.mStatus = this.neh.status;
        this.neg = this.neh.path;
    }
}
