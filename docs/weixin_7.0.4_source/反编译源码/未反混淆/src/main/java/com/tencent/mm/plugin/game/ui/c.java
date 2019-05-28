package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.Settings.Secure;
import android.provider.Settings.SettingNotFoundException;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.f.a;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.game.e.b;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.plugin.game.model.j;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;

public abstract class c implements OnClickListener {
    protected long hxO = -1;
    protected Context mContext;
    protected int mStatus = -1;
    protected com.tencent.mm.plugin.game.model.c mVZ = null;
    protected int mXC;
    protected String neg;
    protected FileDownloadTaskInfo neh;
    protected a nei;
    protected String nej;
    protected String nek;
    protected String nel;
    private String nem = "xiaomi";

    public c(Context context) {
        this.mContext = context;
    }

    public final void setSourceScene(int i) {
        this.mXC = i;
    }

    /* Access modifiers changed, original: protected|final */
    public final void bFb() {
        e.ak(this.mContext, this.mVZ.field_appId);
    }

    /* Access modifiers changed, original: protected|final */
    public final void hP(final boolean z) {
        if (at.isNetworkConnected(this.mContext)) {
            g.RQ();
            if (!g.RP().isSDCardAvailable()) {
                Toast.makeText(this.mContext, this.mContext.getString(R.string.c5h), 0).show();
                j.bEg();
                j.a(this.mVZ.field_appId, com.tencent.mm.plugin.downloader.a.a.kJY, false, null);
                return;
            } else if (f.eW(this.mVZ.mVE)) {
                if (d.vxi.toLowerCase().contains(this.nem)) {
                    try {
                        if (Secure.getInt(this.mContext.getContentResolver(), "install_non_market_apps") == 0 && !e.dZ(this.mContext)) {
                            h.a(this.mContext, (int) R.string.c84, (int) R.string.c85, (int) R.string.c5v, (int) R.string.or, false, new DialogInterface.OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.i(111700);
                                    c.this.mContext.startActivity(new Intent("android.settings.SECURITY_SETTINGS"));
                                    dialogInterface.cancel();
                                    AppMethodBeat.o(111700);
                                }
                            }, new DialogInterface.OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.i(111701);
                                    dialogInterface.cancel();
                                    AppMethodBeat.o(111701);
                                }
                            });
                            e.ea(this.mContext);
                        }
                    } catch (SettingNotFoundException e) {
                        ab.e("MicroMsg.CommonGameClickLinstener", "SettingNotFoundException ; %S", e.getMessage());
                    }
                }
                if (bo.isNullOrNil(this.mVZ.dna) || bo.isNullOrNil(this.mVZ.dnf)) {
                    ab.d("MicroMsg.CommonGameClickLinstener", "downloadApk: appdownloadurl is null or appmd5 is null, try gpDownload");
                    if (bo.isNullOrNil(this.mVZ.dng)) {
                        ab.e("MicroMsg.CommonGameClickLinstener", "downloadApk fail, gpDownloadUrl is null");
                    } else {
                        boolean by = q.by(this.mContext, this.mVZ.dng);
                        ab.d("MicroMsg.CommonGameClickLinstener", "downloadApk with gp, ret = %b", Boolean.valueOf(by));
                    }
                    if (bo.isNullOrNil(this.mVZ.dna)) {
                        j.bEg();
                        j.a(this.mVZ.field_appId, com.tencent.mm.plugin.downloader.a.a.DOWNLOAD_ERR_URL_INVALID, false, null);
                    }
                    if (bo.isNullOrNil(this.mVZ.dnf)) {
                        j.bEg();
                        j.a(this.mVZ.field_appId, com.tencent.mm.plugin.downloader.a.a.kJV, false, null);
                        return;
                    }
                    return;
                }
                b.a(this.mContext, this.mVZ.scene, this.mVZ.cKG, this.mVZ.position, 4, this.mVZ.field_appId, this.mXC, this.mVZ.ctu, this.nek);
                if (at.isWifi(this.mContext)) {
                    hQ(z);
                    return;
                }
                com.tencent.mm.plugin.report.service.h.pYm.e(14217, this.mVZ.field_appId, Integer.valueOf(4), "", this.mVZ.dna, Integer.valueOf(2));
                h.a(this.mContext, this.mContext.getString(R.string.fy6), this.mContext.getString(R.string.fy7), this.mContext.getString(R.string.fy1), this.mContext.getString(R.string.or), false, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(111698);
                        com.tencent.mm.plugin.report.service.h.pYm.e(14217, c.this.mVZ.field_appId, Integer.valueOf(5), "", c.this.mVZ.dna, Integer.valueOf(2));
                        c.this.hQ(z);
                        dialogInterface.dismiss();
                        AppMethodBeat.o(111698);
                    }
                }, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(111699);
                        com.tencent.mm.plugin.report.service.h.pYm.e(14217, c.this.mVZ.field_appId, Integer.valueOf(6), "", c.this.mVZ.dna, Integer.valueOf(2));
                        dialogInterface.dismiss();
                        ab.i("MicroMsg.CommonGameClickLinstener", "addDownloadTask not wifi, user cancel");
                        AppMethodBeat.o(111699);
                    }
                }, (int) R.color.a61);
                return;
            } else {
                Toast.makeText(this.mContext, this.mContext.getString(R.string.c5e), 0).show();
                j.bEg();
                j.a(this.mVZ.field_appId, com.tencent.mm.plugin.downloader.a.a.kJY, false, null);
                return;
            }
        }
        Toast.makeText(this.mContext, this.mContext.getString(R.string.c5d), 0).show();
        j.bEg();
        j.a(this.mVZ.field_appId, com.tencent.mm.plugin.downloader.a.a.kJX, false, null);
    }

    private void hQ(boolean z) {
        long b;
        if (z) {
            j.a(this.mVZ.dna, this.mVZ.dnf, this.mVZ.cKG, this.mVZ.field_appId, this.nej, "app_update");
        } else {
            j.a(this.mVZ.dna, this.mVZ.dnf, this.mVZ.cKG, this.mVZ.field_appId, this.nej, this.nel);
        }
        com.tencent.mm.plugin.downloader.model.e.a aVar = new com.tencent.mm.plugin.downloader.model.e.a();
        aVar.It(this.mVZ.dna);
        aVar.Iu(this.mVZ.mVD);
        aVar.hA(this.mVZ.mVE);
        aVar.Iv(com.tencent.mm.pluginsdk.model.app.g.b(this.mContext, this.mVZ, null));
        aVar.setAppId(this.mVZ.field_appId);
        aVar.Iw(this.mVZ.dnf);
        aVar.ga(true);
        aVar.tN(1);
        aVar.cY(this.mVZ.field_packageName);
        aVar.setScene(this.mVZ.cKG);
        if (this.mVZ.cBA == 1) {
            b = com.tencent.mm.plugin.downloader.model.d.bij().b(aVar.kNl);
        } else {
            b = com.tencent.mm.plugin.downloader.model.d.bij().a(aVar.kNl);
        }
        ab.i("MicroMsg.CommonGameClickLinstener", " add download task result:[%d], appid[%s]，downloaerType[%d]", Long.valueOf(b), this.mVZ.field_appId, Integer.valueOf(this.mVZ.cBA));
        e.ar(this.mContext, this.mVZ.field_appId);
        com.tencent.mm.game.report.api.b.eBF.a(this.mVZ.field_appId, this.mVZ.cKG, 9, b, "", null);
        com.tencent.mm.modelstat.d.b(10, "CommonGameClickListener_addDownloadTask", hashCode());
    }

    /* Access modifiers changed, original: protected|final */
    public final void bFc() {
        this.nei = com.tencent.mm.plugin.downloader.model.c.In(this.mVZ.field_appId);
        this.neh = com.tencent.mm.plugin.downloader.model.d.bij().Ir(this.mVZ.field_appId);
        this.hxO = this.neh.id;
        this.mStatus = this.neh.status;
        this.neg = this.neh.path;
    }
}
