package com.tencent.p177mm.p612ui.chatting;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.compatible.util.C1448h;
import com.tencent.p177mm.p1378ce.C26006a;
import com.tencent.p177mm.p178a.C37431m;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.downloader.model.C2896d;
import com.tencent.p177mm.plugin.downloader.model.C2900e.C2901a;
import com.tencent.p177mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.model.app.C35799p;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.pluginsdk.p1079f.C30035i;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C46509j;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C46509j.C35896a;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* renamed from: com.tencent.mm.ui.chatting.t */
public final class C44327t {
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
    C44326a yJX = C44326a.DEFAULT;
    public int yJY = -1;
    public boolean yJZ;
    String yKa = null;
    public String yKb;
    public OnClickListener yKc = new C305731();
    public OnClickListener yKd = new C305742();
    private C35896a yKe = new C443257();

    /* renamed from: com.tencent.mm.ui.chatting.t$3 */
    class C157133 implements DialogInterface.OnClickListener {
        C157133() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(30737);
            C44327t.m80111b(C44327t.this);
            AppMethodBeat.m2505o(30737);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.t$1 */
    class C305731 implements OnClickListener {
        C305731() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(30735);
            new Intent().putExtra("composeType", 1);
            C25985d.m41448H(C44327t.this.mContext, "qqmail", ".ui.ComposeUI");
            AppMethodBeat.m2505o(30735);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.t$2 */
    class C305742 implements OnClickListener {
        C305742() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(30736);
            C44327t c44327t;
            switch (C44327t.this.yJX) {
                case NEED_INSTALL:
                    C7060h.pYm.mo8381e(11288, Integer.valueOf(7));
                    c44327t = C44327t.this;
                    C4990ab.m7416i("MicroMsg.ChattingQQMailFooterHandler", "dz[installQQMail]");
                    C30035i.m47536aC(c44327t.mContext, c44327t.yKa);
                    AppMethodBeat.m2505o(30736);
                    return;
                case DOWNLOADING:
                    c44327t = C44327t.this;
                    C4990ab.m7416i("MicroMsg.ChattingQQMailFooterHandler", "dz[cancelDownload]");
                    C2896d.bij().mo7047hl(c44327t.lwo);
                    c44327t.dCs();
                    AppMethodBeat.m2505o(30736);
                    return;
                case NEED_DOWNLOAD:
                    C7060h.pYm.mo8381e(11288, Integer.valueOf(6));
                    C44327t c44327t2 = C44327t.this;
                    if (!C5023at.isConnected(c44327t2.mContext)) {
                        C30379h.m48443a(c44327t2.mContext, C1338a.m2858an(c44327t2.mContext, C25738R.string.ajh), "", C1338a.m2858an(c44327t2.mContext, C25738R.string.ajc), null);
                        AppMethodBeat.m2505o(30736);
                        return;
                    } else if (C5023at.isWifi(c44327t2.mContext)) {
                        C30379h.m48428a(c44327t2.mContext, (int) C25738R.string.ajf, 0, (int) C25738R.string.aja, (int) C25738R.string.aj_, new C443284(), null);
                        AppMethodBeat.m2505o(30736);
                        return;
                    } else {
                        C30379h.m48428a(c44327t2.mContext, (int) C25738R.string.aje, 0, (int) C25738R.string.aja, (int) C25738R.string.aj_, new C157133(), null);
                        AppMethodBeat.m2505o(30736);
                        return;
                    }
                case INSTALLED:
                    Intent launchIntentForPackage;
                    C7060h.pYm.mo8381e(11288, Integer.valueOf(5));
                    C44327t c44327t3 = C44327t.this;
                    C4990ab.m7416i("MicroMsg.ChattingQQMailFooterHandler", "dz[openQQMail]");
                    C4990ab.m7417i("MicroMsg.ChattingQQMailFooterHandler", "mQQMailScheme = %s", c44327t3.yKb);
                    if (C5046bo.isNullOrNil(c44327t3.yKb)) {
                        launchIntentForPackage = c44327t3.mContext.getPackageManager().getLaunchIntentForPackage("com.tencent.androidqqmail");
                    } else {
                        launchIntentForPackage = new Intent();
                        launchIntentForPackage.setData(Uri.parse(c44327t3.yKb));
                        launchIntentForPackage.addFlags(268435456);
                        if (VERSION.SDK_INT >= 11) {
                            launchIntentForPackage.addFlags(32768);
                        }
                        if (!C5046bo.m7572k(c44327t3.mContext, launchIntentForPackage)) {
                            launchIntentForPackage = c44327t3.mContext.getPackageManager().getLaunchIntentForPackage("com.tencent.androidqqmail");
                        }
                    }
                    C4990ab.m7417i("MicroMsg.ChattingQQMailFooterHandler", "intent = %s", launchIntentForPackage);
                    C26006a.post(new C408055(launchIntentForPackage));
                    AppMethodBeat.m2505o(30736);
                    return;
                case NO_URL:
                    if (C44327t.this.yJZ) {
                        C44327t.m80110a(C44327t.this);
                        break;
                    }
                    break;
            }
            AppMethodBeat.m2505o(30736);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.t$5 */
    class C408055 implements Runnable {
        final /* synthetic */ Intent pAc;

        C408055(Intent intent) {
            this.pAc = intent;
        }

        public final void run() {
            AppMethodBeat.m2504i(30739);
            C46494g.m87725a(C44327t.this.mContext, this.pAc, C44327t.this.mContext.getString(C25738R.string.ajk), null, null);
            AppMethodBeat.m2505o(30739);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.t$6 */
    class C443246 implements Runnable {

        /* renamed from: com.tencent.mm.ui.chatting.t$6$1 */
        class C408061 implements Runnable {
            C408061() {
            }

            public final void run() {
                AppMethodBeat.m2504i(30740);
                if (C5046bo.isNullOrNil(C44327t.this.pzK) || C5046bo.isNullOrNil(C44327t.this.pzL)) {
                    C44327t.m80110a(C44327t.this);
                    AppMethodBeat.m2505o(30740);
                    return;
                }
                C44327t c44327t = C44327t.this;
                C4990ab.m7416i("MicroMsg.ChattingQQMailFooterHandler", "dz[downloadQQMail]");
                C2901a c2901a = new C2901a();
                c2901a.mo7055It(c44327t.pzK);
                c2901a.mo7057Iv(c44327t.mContext.getResources().getString(C25738R.string.b6y));
                c2901a.mo7058Iw(c44327t.pzL);
                c2901a.mo7063ga(true);
                c2901a.mo7069tN(1);
                c44327t.lwo = C2896d.bij().mo7042a(c2901a.kNl);
                if (c44327t.lwo > 0) {
                    c44327t.ehZ = c44327t.mContext.getSharedPreferences("QQMAIL", C1448h.m3078Mu());
                    c44327t.ehZ.edit().putLong("qqmail_downloadid", c44327t.lwo).apply();
                    c44327t.dCs();
                }
                AppMethodBeat.m2505o(30740);
            }
        }

        C443246() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:21:0x0098  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            Throwable e;
            AppMethodBeat.m2504i(30741);
            HttpURLConnection httpURLConnection = null;
            try {
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(C44327t.this.pzJ).openConnection();
                try {
                    httpURLConnection2.setInstanceFollowRedirects(false);
                    httpURLConnection2.connect();
                    C44327t.this.pzK = httpURLConnection2.getHeaderField("Location");
                    InputStream inputStream = httpURLConnection2.getInputStream();
                    int headerFieldInt = httpURLConnection2.getHeaderFieldInt("Content-Length", -1);
                    if (headerFieldInt <= 0) {
                        C4990ab.m7412e("MicroMsg.ChattingQQMailFooterHandler", "error content-length");
                        inputStream.close();
                    } else {
                        byte[] bArr = new byte[headerFieldInt];
                        inputStream.read(bArr);
                        inputStream.close();
                        byte[] a = C37431m.m63088a(Base64.decode(bArr, 0), C37431m.m63089r(C44327t.this.mContext, "rsa_public_key_forwx.pem"));
                        C44327t.this.pzL = new String(a);
                        C5004al.m7441d(new C408061());
                    }
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                        AppMethodBeat.m2505o(30741);
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
                    AppMethodBeat.m2505o(30741);
                    throw e;
                }
            } catch (Exception e3) {
                e = e3;
                try {
                    C4990ab.printErrStackTrace("MicroMsg.ChattingQQMailFooterHandler", e, "", new Object[0]);
                    C44327t.m80110a(C44327t.this);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                        AppMethodBeat.m2505o(30741);
                        return;
                    }
                    AppMethodBeat.m2505o(30741);
                } catch (Throwable e32) {
                    e = e32;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    AppMethodBeat.m2505o(30741);
                    throw e;
                }
            }
            AppMethodBeat.m2505o(30741);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.t$7 */
    class C443257 implements C35896a {
        C443257() {
        }

        public final void onSuccess(int i) {
            AppMethodBeat.m2504i(30742);
            C44327t.this.yJY = i;
            C44327t.this.dCt();
            AppMethodBeat.m2505o(30742);
        }

        public final void ccH() {
            AppMethodBeat.m2504i(30743);
            C44327t.this.yJV.setText(C25738R.string.ajk);
            AppMethodBeat.m2505o(30743);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.t$a */
    enum C44326a {
        DEFAULT,
        NEED_DOWNLOAD,
        DOWNLOADING,
        NEED_INSTALL,
        INSTALLED,
        NO_URL;

        static {
            AppMethodBeat.m2505o(30747);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.t$4 */
    class C443284 implements DialogInterface.OnClickListener {
        C443284() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(30738);
            C44327t.m80111b(C44327t.this);
            AppMethodBeat.m2505o(30738);
        }
    }

    public C44327t(ChatFooterCustom chatFooterCustom) {
        AppMethodBeat.m2504i(30748);
        this.mContext = chatFooterCustom.getContext();
        this.yJS = chatFooterCustom;
        AppMethodBeat.m2505o(30748);
    }

    public final void dCr() {
        AppMethodBeat.m2504i(30749);
        if (this.yJX == C44326a.INSTALLED) {
            this.yJW.setImageResource(C1318a.promo_icon_qqmail);
            AppMethodBeat.m2505o(30749);
            return;
        }
        this.yJW.setImageResource(C1318a.promo_icon_qqmail_uninstall);
        AppMethodBeat.m2505o(30749);
    }

    public final void dCt() {
        AppMethodBeat.m2504i(30751);
        if (this.yJY == 0) {
            this.yJV.setText(C25738R.string.ajk);
            AppMethodBeat.m2505o(30751);
        } else if (this.yJY > 99) {
            this.yJV.setText(C25738R.string.ajj);
            AppMethodBeat.m2505o(30751);
        } else {
            this.yJV.setText(String.format(C1338a.m2858an(this.mContext, C25738R.string.aji), new Object[]{Integer.valueOf(this.yJY)}));
            AppMethodBeat.m2505o(30751);
        }
    }

    public final void dCs() {
        C44326a c44326a;
        AppMethodBeat.m2504i(30750);
        if (!C35799p.m58695u(this.mContext, "com.tencent.androidqqmail")) {
            this.ehZ = this.mContext.getSharedPreferences("QQMAIL", C1448h.m3078Mu());
            this.lwo = this.ehZ.getLong("qqmail_downloadid", -1);
            if (this.lwo >= 0) {
                FileDownloadTaskInfo hm = C2896d.bij().mo7048hm(this.lwo);
                int i = hm.status;
                this.yKa = hm.path;
                switch (i) {
                    case 1:
                        c44326a = C44326a.DOWNLOADING;
                        break;
                    case 3:
                        if (!C5730e.m8628ct(this.yKa)) {
                            if (!C5046bo.isNullOrNil(this.pzJ)) {
                                c44326a = C44326a.NEED_DOWNLOAD;
                                break;
                            } else {
                                c44326a = C44326a.NO_URL;
                                break;
                            }
                        }
                        c44326a = C44326a.NEED_INSTALL;
                        break;
                    default:
                        if (!C5046bo.isNullOrNil(this.pzJ)) {
                            c44326a = C44326a.NEED_DOWNLOAD;
                            break;
                        } else {
                            c44326a = C44326a.NO_URL;
                            break;
                        }
                }
            } else if (C5046bo.isNullOrNil(this.pzJ)) {
                c44326a = C44326a.NO_URL;
            } else {
                c44326a = C44326a.NEED_DOWNLOAD;
            }
        } else {
            c44326a = C44326a.INSTALLED;
        }
        this.yJX = c44326a;
        dCr();
        C4990ab.m7417i("MicroMsg.ChattingQQMailFooterHandler", "dz[initRightBtnTv: status:%s]", this.yJX.toString());
        switch (this.yJX) {
            case NEED_INSTALL:
                this.yJV.setText(C25738R.string.ajd);
                AppMethodBeat.m2505o(30750);
                return;
            case DOWNLOADING:
                this.yJV.setText(C25738R.string.ajb);
                AppMethodBeat.m2505o(30750);
                return;
            case NEED_DOWNLOAD:
            case INSTALLED:
            case NO_URL:
                C46509j.m87799a(this.yKe);
                AppMethodBeat.m2505o(30750);
                return;
            default:
                C46509j.m87799a(this.yKe);
                AppMethodBeat.m2505o(30750);
                return;
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m80110a(C44327t c44327t) {
        AppMethodBeat.m2504i(30752);
        C4990ab.m7416i("MicroMsg.ChattingQQMailFooterHandler", "dz[handleNoUrl]");
        C30379h.m48443a(c44327t.mContext, C1338a.m2858an(c44327t.mContext, C25738R.string.ajg), "", C1338a.m2858an(c44327t.mContext, C25738R.string.ajc), null);
        AppMethodBeat.m2505o(30752);
    }

    /* renamed from: b */
    static /* synthetic */ void m80111b(C44327t c44327t) {
        AppMethodBeat.m2504i(30753);
        C4990ab.m7416i("MicroMsg.ChattingQQMailFooterHandler", "dz[initQQMailDownloadUrlAndMD5]");
        C7305d.post(new C443246(), "QQMailDownloadUrlAndMD5");
        AppMethodBeat.m2505o(30753);
    }
}
