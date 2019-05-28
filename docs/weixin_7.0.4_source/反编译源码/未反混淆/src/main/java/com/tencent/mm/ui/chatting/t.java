package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.Base64;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.a.m;
import com.tencent.mm.bp.d;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.f.i;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.ui.tools.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public final class t {
    SharedPreferences ehZ;
    public LinearLayout lfQ = null;
    long lwo = -1;
    Context mContext;
    public String pzJ;
    String pzK;
    String pzL;
    public ChatFooterCustom yJS;
    public FrameLayout yJT;
    public FrameLayout yJU;
    public TextView yJV;
    public ImageView yJW;
    a yJX = a.DEFAULT;
    public int yJY = -1;
    public boolean yJZ;
    String yKa = null;
    public String yKb;
    public OnClickListener yKc = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(30735);
            new Intent().putExtra("composeType", 1);
            d.H(t.this.mContext, "qqmail", ".ui.ComposeUI");
            AppMethodBeat.o(30735);
        }
    };
    public OnClickListener yKd = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(30736);
            t tVar;
            switch (t.this.yJX) {
                case NEED_INSTALL:
                    h.pYm.e(11288, Integer.valueOf(7));
                    tVar = t.this;
                    ab.i("MicroMsg.ChattingQQMailFooterHandler", "dz[installQQMail]");
                    i.aC(tVar.mContext, tVar.yKa);
                    AppMethodBeat.o(30736);
                    return;
                case DOWNLOADING:
                    tVar = t.this;
                    ab.i("MicroMsg.ChattingQQMailFooterHandler", "dz[cancelDownload]");
                    com.tencent.mm.plugin.downloader.model.d.bij().hl(tVar.lwo);
                    tVar.dCs();
                    AppMethodBeat.o(30736);
                    return;
                case NEED_DOWNLOAD:
                    h.pYm.e(11288, Integer.valueOf(6));
                    t tVar2 = t.this;
                    if (!at.isConnected(tVar2.mContext)) {
                        com.tencent.mm.ui.base.h.a(tVar2.mContext, com.tencent.mm.bz.a.an(tVar2.mContext, R.string.ajh), "", com.tencent.mm.bz.a.an(tVar2.mContext, R.string.ajc), null);
                        AppMethodBeat.o(30736);
                        return;
                    } else if (at.isWifi(tVar2.mContext)) {
                        com.tencent.mm.ui.base.h.a(tVar2.mContext, (int) R.string.ajf, 0, (int) R.string.aja, (int) R.string.aj_, new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(30738);
                                t.b(t.this);
                                AppMethodBeat.o(30738);
                            }
                        }, null);
                        AppMethodBeat.o(30736);
                        return;
                    } else {
                        com.tencent.mm.ui.base.h.a(tVar2.mContext, (int) R.string.aje, 0, (int) R.string.aja, (int) R.string.aj_, new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(30737);
                                t.b(t.this);
                                AppMethodBeat.o(30737);
                            }
                        }, null);
                        AppMethodBeat.o(30736);
                        return;
                    }
                case INSTALLED:
                    Intent launchIntentForPackage;
                    h.pYm.e(11288, Integer.valueOf(5));
                    t tVar3 = t.this;
                    ab.i("MicroMsg.ChattingQQMailFooterHandler", "dz[openQQMail]");
                    ab.i("MicroMsg.ChattingQQMailFooterHandler", "mQQMailScheme = %s", tVar3.yKb);
                    if (bo.isNullOrNil(tVar3.yKb)) {
                        launchIntentForPackage = tVar3.mContext.getPackageManager().getLaunchIntentForPackage("com.tencent.androidqqmail");
                    } else {
                        launchIntentForPackage = new Intent();
                        launchIntentForPackage.setData(Uri.parse(tVar3.yKb));
                        launchIntentForPackage.addFlags(268435456);
                        if (VERSION.SDK_INT >= 11) {
                            launchIntentForPackage.addFlags(32768);
                        }
                        if (!bo.k(tVar3.mContext, launchIntentForPackage)) {
                            launchIntentForPackage = tVar3.mContext.getPackageManager().getLaunchIntentForPackage("com.tencent.androidqqmail");
                        }
                    }
                    ab.i("MicroMsg.ChattingQQMailFooterHandler", "intent = %s", launchIntentForPackage);
                    com.tencent.mm.ce.a.post(new AnonymousClass5(launchIntentForPackage));
                    AppMethodBeat.o(30736);
                    return;
                case NO_URL:
                    if (t.this.yJZ) {
                        t.a(t.this);
                        break;
                    }
                    break;
            }
            AppMethodBeat.o(30736);
        }
    };
    private com.tencent.mm.pluginsdk.ui.tools.j.a yKe = new com.tencent.mm.pluginsdk.ui.tools.j.a() {
        public final void onSuccess(int i) {
            AppMethodBeat.i(30742);
            t.this.yJY = i;
            t.this.dCt();
            AppMethodBeat.o(30742);
        }

        public final void ccH() {
            AppMethodBeat.i(30743);
            t.this.yJV.setText(R.string.ajk);
            AppMethodBeat.o(30743);
        }
    };

    /* renamed from: com.tencent.mm.ui.chatting.t$5 */
    class AnonymousClass5 implements Runnable {
        final /* synthetic */ Intent pAc;

        AnonymousClass5(Intent intent) {
            this.pAc = intent;
        }

        public final void run() {
            AppMethodBeat.i(30739);
            g.a(t.this.mContext, this.pAc, t.this.mContext.getString(R.string.ajk), null, null);
            AppMethodBeat.o(30739);
        }
    }

    enum a {
        DEFAULT,
        NEED_DOWNLOAD,
        DOWNLOADING,
        NEED_INSTALL,
        INSTALLED,
        NO_URL;

        static {
            AppMethodBeat.o(30747);
        }
    }

    public t(ChatFooterCustom chatFooterCustom) {
        AppMethodBeat.i(30748);
        this.mContext = chatFooterCustom.getContext();
        this.yJS = chatFooterCustom;
        AppMethodBeat.o(30748);
    }

    public final void dCr() {
        AppMethodBeat.i(30749);
        if (this.yJX == a.INSTALLED) {
            this.yJW.setImageResource(R.raw.promo_icon_qqmail);
            AppMethodBeat.o(30749);
            return;
        }
        this.yJW.setImageResource(R.raw.promo_icon_qqmail_uninstall);
        AppMethodBeat.o(30749);
    }

    public final void dCt() {
        AppMethodBeat.i(30751);
        if (this.yJY == 0) {
            this.yJV.setText(R.string.ajk);
            AppMethodBeat.o(30751);
        } else if (this.yJY > 99) {
            this.yJV.setText(R.string.ajj);
            AppMethodBeat.o(30751);
        } else {
            this.yJV.setText(String.format(com.tencent.mm.bz.a.an(this.mContext, R.string.aji), new Object[]{Integer.valueOf(this.yJY)}));
            AppMethodBeat.o(30751);
        }
    }

    public final void dCs() {
        a aVar;
        AppMethodBeat.i(30750);
        if (!p.u(this.mContext, "com.tencent.androidqqmail")) {
            this.ehZ = this.mContext.getSharedPreferences("QQMAIL", com.tencent.mm.compatible.util.h.Mu());
            this.lwo = this.ehZ.getLong("qqmail_downloadid", -1);
            if (this.lwo >= 0) {
                FileDownloadTaskInfo hm = com.tencent.mm.plugin.downloader.model.d.bij().hm(this.lwo);
                int i = hm.status;
                this.yKa = hm.path;
                switch (i) {
                    case 1:
                        aVar = a.DOWNLOADING;
                        break;
                    case 3:
                        if (!e.ct(this.yKa)) {
                            if (!bo.isNullOrNil(this.pzJ)) {
                                aVar = a.NEED_DOWNLOAD;
                                break;
                            } else {
                                aVar = a.NO_URL;
                                break;
                            }
                        }
                        aVar = a.NEED_INSTALL;
                        break;
                    default:
                        if (!bo.isNullOrNil(this.pzJ)) {
                            aVar = a.NEED_DOWNLOAD;
                            break;
                        } else {
                            aVar = a.NO_URL;
                            break;
                        }
                }
            } else if (bo.isNullOrNil(this.pzJ)) {
                aVar = a.NO_URL;
            } else {
                aVar = a.NEED_DOWNLOAD;
            }
        } else {
            aVar = a.INSTALLED;
        }
        this.yJX = aVar;
        dCr();
        ab.i("MicroMsg.ChattingQQMailFooterHandler", "dz[initRightBtnTv: status:%s]", this.yJX.toString());
        switch (this.yJX) {
            case NEED_INSTALL:
                this.yJV.setText(R.string.ajd);
                AppMethodBeat.o(30750);
                return;
            case DOWNLOADING:
                this.yJV.setText(R.string.ajb);
                AppMethodBeat.o(30750);
                return;
            case NEED_DOWNLOAD:
            case INSTALLED:
            case NO_URL:
                j.a(this.yKe);
                AppMethodBeat.o(30750);
                return;
            default:
                j.a(this.yKe);
                AppMethodBeat.o(30750);
                return;
        }
    }

    static /* synthetic */ void a(t tVar) {
        AppMethodBeat.i(30752);
        ab.i("MicroMsg.ChattingQQMailFooterHandler", "dz[handleNoUrl]");
        com.tencent.mm.ui.base.h.a(tVar.mContext, com.tencent.mm.bz.a.an(tVar.mContext, R.string.ajg), "", com.tencent.mm.bz.a.an(tVar.mContext, R.string.ajc), null);
        AppMethodBeat.o(30752);
    }

    static /* synthetic */ void b(t tVar) {
        AppMethodBeat.i(30753);
        ab.i("MicroMsg.ChattingQQMailFooterHandler", "dz[initQQMailDownloadUrlAndMD5]");
        com.tencent.mm.sdk.g.d.post(new Runnable() {
            /* JADX WARNING: Removed duplicated region for block: B:21:0x0098  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                Throwable e;
                AppMethodBeat.i(30741);
                HttpURLConnection httpURLConnection = null;
                try {
                    HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(t.this.pzJ).openConnection();
                    try {
                        httpURLConnection2.setInstanceFollowRedirects(false);
                        httpURLConnection2.connect();
                        t.this.pzK = httpURLConnection2.getHeaderField("Location");
                        InputStream inputStream = httpURLConnection2.getInputStream();
                        int headerFieldInt = httpURLConnection2.getHeaderFieldInt("Content-Length", -1);
                        if (headerFieldInt <= 0) {
                            ab.e("MicroMsg.ChattingQQMailFooterHandler", "error content-length");
                            inputStream.close();
                        } else {
                            byte[] bArr = new byte[headerFieldInt];
                            inputStream.read(bArr);
                            inputStream.close();
                            byte[] a = m.a(Base64.decode(bArr, 0), m.r(t.this.mContext, "rsa_public_key_forwx.pem"));
                            t.this.pzL = new String(a);
                            al.d(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(30740);
                                    if (bo.isNullOrNil(t.this.pzK) || bo.isNullOrNil(t.this.pzL)) {
                                        t.a(t.this);
                                        AppMethodBeat.o(30740);
                                        return;
                                    }
                                    t tVar = t.this;
                                    ab.i("MicroMsg.ChattingQQMailFooterHandler", "dz[downloadQQMail]");
                                    com.tencent.mm.plugin.downloader.model.e.a aVar = new com.tencent.mm.plugin.downloader.model.e.a();
                                    aVar.It(tVar.pzK);
                                    aVar.Iv(tVar.mContext.getResources().getString(R.string.b6y));
                                    aVar.Iw(tVar.pzL);
                                    aVar.ga(true);
                                    aVar.tN(1);
                                    tVar.lwo = com.tencent.mm.plugin.downloader.model.d.bij().a(aVar.kNl);
                                    if (tVar.lwo > 0) {
                                        tVar.ehZ = tVar.mContext.getSharedPreferences("QQMAIL", com.tencent.mm.compatible.util.h.Mu());
                                        tVar.ehZ.edit().putLong("qqmail_downloadid", tVar.lwo).apply();
                                        tVar.dCs();
                                    }
                                    AppMethodBeat.o(30740);
                                }
                            });
                        }
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                            AppMethodBeat.o(30741);
                            return;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        httpURLConnection = httpURLConnection2;
                    } catch (Throwable th) {
                        e = th;
                        httpURLConnection = httpURLConnection2;
                        if (httpURLConnection != null) {
                        }
                        AppMethodBeat.o(30741);
                        throw e;
                    }
                } catch (Exception e3) {
                    e = e3;
                    try {
                        ab.printErrStackTrace("MicroMsg.ChattingQQMailFooterHandler", e, "", new Object[0]);
                        t.a(t.this);
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                            AppMethodBeat.o(30741);
                            return;
                        }
                        AppMethodBeat.o(30741);
                    } catch (Throwable e32) {
                        e = e32;
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        AppMethodBeat.o(30741);
                        throw e;
                    }
                }
                AppMethodBeat.o(30741);
            }
        }, "QQMailDownloadUrlAndMD5");
        AppMethodBeat.o(30753);
    }
}
