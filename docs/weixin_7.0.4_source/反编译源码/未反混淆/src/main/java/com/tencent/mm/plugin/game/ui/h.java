package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import android.view.View;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.downloader.f.a;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.game.e.b;
import com.tencent.mm.plugin.game.model.c;
import com.tencent.mm.plugin.game.model.j;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;

public final class h extends c {
    static /* synthetic */ void a(h hVar) {
        AppMethodBeat.i(111805);
        hVar.bFk();
        AppMethodBeat.o(111805);
    }

    public h(Context context) {
        super(context);
    }

    public final void eB(String str, String str2) {
        this.nek = str;
        this.nel = str2;
    }

    public final void onClick(View view) {
        AppMethodBeat.i(111801);
        if (view.getTag() instanceof c) {
            this.mVZ = (c) view.getTag();
            ab.i("MicroMsg.GameClickListener", "Clicked appid = " + this.mVZ.field_appId);
            bFc();
            if (g.u(this.mContext, this.mVZ.field_appId)) {
                int i;
                int i2;
                if (this.mVZ instanceof c) {
                    int Or = com.tencent.mm.plugin.game.f.c.Or(this.mVZ.field_packageName);
                    i = this.mVZ.versionCode;
                    i2 = Or;
                } else {
                    i = 0;
                    i2 = 0;
                }
                if (i > i2) {
                    ab.i("MicroMsg.GameClickListener", "AppId: %s installed, local: %d, server: %d", this.mVZ.field_appId, Integer.valueOf(i2), Integer.valueOf(i));
                    j.a(this.mVZ.dna, this.mVZ.dnf, this.mVZ.cKG, this.mVZ.field_appId, this.nej, "app_update");
                    if (this.neh.status == 1) {
                        ab.i("MicroMsg.GameClickListener", "pauseDownloadTask ret = ".concat(String.valueOf(hn(this.neh.id))));
                        AppMethodBeat.o(111801);
                        return;
                    } else if (this.neh.status == 2) {
                        bFj();
                        AppMethodBeat.o(111801);
                        return;
                    } else if (this.neh.status != 3) {
                        hP(true);
                        AppMethodBeat.o(111801);
                        return;
                    } else if (!e.ct(this.neh.path) || com.tencent.mm.plugin.game.f.c.Os(this.neh.path) <= i2) {
                        hP(true);
                        AppMethodBeat.o(111801);
                        return;
                    } else {
                        q.a(this.mContext, Uri.fromFile(new File(this.neh.path)), null);
                        b.a(this.mContext, this.mVZ.scene, this.mVZ.cKG, this.mVZ.position, 8, this.mVZ.field_appId, this.mXC, this.mVZ.ctu, this.nek);
                        AppMethodBeat.o(111801);
                        return;
                    }
                }
                ab.i("MicroMsg.GameClickListener", "launchFromWX, appId = %s, pkg = %s, openId = %s", this.mVZ.field_appId, this.mVZ.field_packageName, this.mVZ.field_openId);
                b.a(this.mContext, this.mVZ.scene, this.mVZ.cKG, this.mVZ.position, 3, this.mVZ.field_appId, this.mXC, this.mVZ.ctu, this.nek);
                bFb();
                AppMethodBeat.o(111801);
                return;
            } else if (this.mVZ.bDP()) {
                com.tencent.mm.plugin.game.f.c.t(this.mContext, this.mVZ.mVF.ncG, "game_center_hv_game");
                b.a(this.mContext, this.mVZ.scene, this.mVZ.cKG, this.mVZ.position, 29, this.mVZ.field_appId, this.mXC, this.mVZ.ctu, this.nek);
                AppMethodBeat.o(111801);
                return;
            } else {
                j.a(this.mVZ.dna, this.mVZ.dnf, this.mVZ.cKG, this.mVZ.field_appId, this.nej, this.nel);
                switch (this.mStatus) {
                    case 1:
                        ab.i("MicroMsg.GameClickListener", "pauseDownloadTask ret = ".concat(String.valueOf(hn(this.neh.id))));
                        AppMethodBeat.o(111801);
                        return;
                    case 2:
                        bFj();
                        AppMethodBeat.o(111801);
                        return;
                    case 3:
                        if (!bo.isNullOrNil(this.neg) && e.ct(this.neg) && com.tencent.mm.plugin.game.f.c.eC(this.neg, this.nei.field_md5)) {
                            com.tencent.mm.plugin.game.f.c.iQ(this.nei.field_downloadId);
                            b.a(this.mContext, this.mVZ.scene, this.mVZ.cKG, this.mVZ.position, 8, this.mVZ.field_appId, this.mXC, this.mVZ.ctu, this.nek);
                            AppMethodBeat.o(111801);
                            return;
                        }
                        hP(false);
                        AppMethodBeat.o(111801);
                        return;
                    default:
                        hP(false);
                        AppMethodBeat.o(111801);
                        return;
                }
            }
        }
        ab.e("MicroMsg.GameClickListener", "No AppInfo");
        AppMethodBeat.o(111801);
    }

    private void bFj() {
        AppMethodBeat.i(111802);
        if (!at.isNetworkConnected(this.mContext)) {
            Toast.makeText(this.mContext, this.mContext.getString(R.string.c5d), 0).show();
            AppMethodBeat.o(111802);
        } else if (at.isWifi(this.mContext)) {
            bFk();
            AppMethodBeat.o(111802);
        } else {
            com.tencent.mm.ui.base.h.a(this.mContext, this.mContext.getString(R.string.fy6), this.mContext.getString(R.string.fy7), this.mContext.getString(R.string.fy1), this.mContext.getString(R.string.or), false, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(111799);
                    h.a(h.this);
                    dialogInterface.dismiss();
                    AppMethodBeat.o(111799);
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(111800);
                    dialogInterface.dismiss();
                    ab.i("MicroMsg.GameClickListener", "resumeDownloadTask not wifi, user cancel");
                    AppMethodBeat.o(111800);
                }
            }, (int) R.color.a61);
            AppMethodBeat.o(111802);
        }
    }

    private static boolean hn(long j) {
        AppMethodBeat.i(111804);
        a hv = com.tencent.mm.plugin.downloader.model.c.hv(j);
        if (hv != null && hv.field_downloadInWifi) {
            hv.field_downloadInWifi = false;
            com.tencent.mm.plugin.downloader.model.c.e(hv);
        }
        boolean hn = d.bij().hn(j);
        AppMethodBeat.o(111804);
        return hn;
    }

    private void bFk() {
        AppMethodBeat.i(111803);
        com.tencent.mm.game.report.api.b.eBF.a(this.mVZ.field_appId, this.mVZ.cKG, 10, this.nei.field_downloadId, "", null);
        com.tencent.mm.modelstat.d.b(10, "GameClickListener_resumeDownloadTask", hashCode());
        if (d.bij().ho(this.nei.field_downloadId)) {
            com.tencent.mm.plugin.game.model.e.ar(this.mContext, this.mVZ.field_appId);
            b.a(this.mContext, this.mVZ.scene, this.mVZ.cKG, this.mVZ.position, 4, this.mVZ.field_appId, this.mXC, this.mVZ.ctu, this.nek);
            AppMethodBeat.o(111803);
            return;
        }
        ab.e("MicroMsg.GameClickListener", "resumeDownloadTask false");
        d.bij().hl(this.nei.field_downloadId);
        hP(false);
        AppMethodBeat.o(111803);
    }
}
