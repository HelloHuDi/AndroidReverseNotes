package com.tencent.p177mm.plugin.webview.p580ui.tools;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.modelstat.C26483d;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.p191a.C25815a;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p230g.p231a.C45327gw;
import com.tencent.p177mm.p230g.p231a.C45330h;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMFragmentActivity.C5206a;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.downloader.model.C11511k;
import com.tencent.p177mm.plugin.downloader.model.C2886b;
import com.tencent.p177mm.plugin.downloader.model.C2896d;
import com.tencent.p177mm.plugin.downloader.model.C2900e.C2901a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.WebViewDownloadUI */
public class WebViewDownloadUI extends MMActivity {
    private long hxO;
    private TextView kGq;
    private int kNb;
    private Context mContext;
    private boolean ump;
    private Button utd;
    private TextView ute;
    private C43937a utf;
    private String utg;
    private TextView uth;
    private int uti;
    private C11511k utj = new C45784();

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.WebViewDownloadUI$4 */
    class C45784 implements C11511k {
        C45784() {
        }

        public final void onTaskStarted(long j, String str) {
            AppMethodBeat.m2504i(7597);
            C4990ab.m7417i("MicroMsg.WebViewDownloadUI", "onTaskStarted id=%d, savedFilePath=%s", Long.valueOf(j), str);
            AppMethodBeat.m2505o(7597);
        }

        /* renamed from: b */
        public final void mo7665b(long j, String str, boolean z) {
            AppMethodBeat.m2504i(7598);
            C4990ab.m7417i("MicroMsg.WebViewDownloadUI", "onTaskFinished id=%d, savedFilePath=%s, hasChangeUrl=%b", Long.valueOf(j), str, Boolean.valueOf(z));
            Toast.makeText(WebViewDownloadUI.this.mController.ylL, WebViewDownloadUI.this.getString(C25738R.string.fy8), 1).show();
            WebViewDownloadUI.this.finish();
            AppMethodBeat.m2505o(7598);
        }

        /* renamed from: b */
        public final void mo7664b(long j, int i, boolean z) {
            AppMethodBeat.m2504i(7599);
            C4990ab.m7417i("MicroMsg.WebViewDownloadUI", "onTaskFailed id=%d, errCode=%d, hasChangeUrl=%b", Long.valueOf(j), Integer.valueOf(i), Boolean.valueOf(z));
            Toast.makeText(WebViewDownloadUI.this.mController.ylL, WebViewDownloadUI.this.getString(C25738R.string.fy5), 1).show();
            WebViewDownloadUI.this.finish();
            AppMethodBeat.m2505o(7599);
        }

        public final void onTaskRemoved(long j) {
            AppMethodBeat.m2504i(7600);
            C4990ab.m7417i("MicroMsg.WebViewDownloadUI", "onTaskRemoved id=%d", Long.valueOf(j));
            WebViewDownloadUI.this.finish();
            AppMethodBeat.m2505o(7600);
        }

        public final void onTaskPaused(long j) {
            AppMethodBeat.m2504i(7601);
            C4990ab.m7417i("MicroMsg.WebViewDownloadUI", "onTaskPaused id=%d", Long.valueOf(j));
            AppMethodBeat.m2505o(7601);
        }

        /* renamed from: gm */
        public final void mo7667gm(long j) {
        }

        /* renamed from: i */
        public final void mo7669i(long j, String str) {
            AppMethodBeat.m2504i(7602);
            C4990ab.m7417i("MicroMsg.WebViewDownloadUI", "onTaskResumed id=%d, savedFilePath=%s", Long.valueOf(j), str);
            AppMethodBeat.m2505o(7602);
        }

        /* renamed from: gn */
        public final void mo7668gn(long j) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.WebViewDownloadUI$1 */
    class C439361 implements OnMenuItemClickListener {
        C439361() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(7592);
            WebViewDownloadUI.this.finish();
            AppMethodBeat.m2505o(7592);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.WebViewDownloadUI$a */
    enum C43937a {
        TO_DOWNLOAD,
        DOWNLOADING;

        static {
            AppMethodBeat.m2505o(7606);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public WebViewDownloadUI() {
        AppMethodBeat.m2504i(7607);
        AppMethodBeat.m2505o(7607);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(7608);
        super.onCreate(bundle);
        this.mContext = this;
        setMMTitle(getString(C25738R.string.fya));
        setBackBtn(new C439361());
        overridePendingTransition(C5206a.ync, C5206a.ynd);
        this.utd = (Button) findViewById(2131829167);
        this.ute = (TextView) findViewById(2131829169);
        TextView textView = (TextView) findViewById(2131829165);
        this.uth = (TextView) findViewById(2131829166);
        ImageView imageView = (ImageView) findViewById(2131829164);
        this.kGq = (TextView) findViewById(2131829168);
        m78841a(C43937a.TO_DOWNLOAD);
        final String stringExtra = getIntent().getStringExtra("task_name");
        final String stringExtra2 = getIntent().getStringExtra("task_url");
        final String stringExtra3 = getIntent().getStringExtra("alternative_url");
        long longExtra = getIntent().getLongExtra("task_size", 0);
        final String stringExtra4 = getIntent().getStringExtra("file_md5");
        final String stringExtra5 = getIntent().getStringExtra(IssueStorage.COLUMN_EXT_INFO);
        String stringExtra6 = getIntent().getStringExtra("fileType");
        final String stringExtra7 = getIntent().getStringExtra("appid");
        final String stringExtra8 = getIntent().getStringExtra("package_name");
        String stringExtra9 = getIntent().getStringExtra("thumb_url");
        String stringExtra10 = getIntent().getStringExtra("title");
        final String stringExtra11 = getIntent().getStringExtra("page_url");
        final int intExtra = getIntent().getIntExtra("task_scene", 0);
        this.uti = getIntent().getIntExtra("page_scene", 0);
        C7060h.pYm.mo8381e(14217, stringExtra7, Integer.valueOf(1), stringExtra11, stringExtra2, Integer.valueOf(0));
        this.kNb = C5046bo.getInt(stringExtra6, 1);
        if (C5046bo.isNullOrNil(stringExtra10)) {
            stringExtra10 = C5046bo.nullAsNil(stringExtra);
        }
        if (!C5046bo.isNullOrNil(stringExtra10)) {
            textView.setText(stringExtra10);
            textView.setVisibility(0);
        }
        if (longExtra > 0) {
            this.utg = C5046bo.m7580my(longExtra);
            this.uth.setText(this.utg);
            this.utd.setText(getString(C25738R.string.fy2, new Object[]{this.utg}));
        }
        C25815a ahp = C32291o.ahp();
        C17927a c17927a = new C17927a();
        c17927a.ePT = C1318a.webview_download_thumb_unknown;
        c17927a.ePH = true;
        ahp.mo43766a(stringExtra9, imageView, c17927a.ahG());
        this.utd.setOnClickListener(new OnClickListener() {

            /* renamed from: com.tencent.mm.plugin.webview.ui.tools.WebViewDownloadUI$2$1 */
            class C229261 implements DialogInterface.OnClickListener {
                C229261() {
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(7593);
                    C7060h.pYm.mo8381e(14217, stringExtra7, Integer.valueOf(5), stringExtra11, stringExtra2, Integer.valueOf(0));
                    WebViewDownloadUI.m78842a(WebViewDownloadUI.this, stringExtra2, stringExtra4, stringExtra5, stringExtra7, stringExtra3, stringExtra11, stringExtra, stringExtra8, intExtra);
                    dialogInterface.dismiss();
                    AppMethodBeat.m2505o(7593);
                }
            }

            /* renamed from: com.tencent.mm.plugin.webview.ui.tools.WebViewDownloadUI$2$2 */
            class C229272 implements DialogInterface.OnClickListener {
                C229272() {
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(7594);
                    C7060h.pYm.mo8381e(14217, stringExtra7, Integer.valueOf(6), stringExtra11, stringExtra2, Integer.valueOf(0));
                    dialogInterface.dismiss();
                    AppMethodBeat.m2505o(7594);
                }
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(7595);
                C4990ab.m7417i("MicroMsg.WebViewDownloadUI", "downloadOpBtn.onClick state=%s", WebViewDownloadUI.this.utf);
                switch (WebViewDownloadUI.this.utf) {
                    case TO_DOWNLOAD:
                        if (!C5023at.isNetworkConnected(WebViewDownloadUI.this.mContext)) {
                            Toast.makeText(WebViewDownloadUI.this.mContext, WebViewDownloadUI.this.getString(C25738R.string.c5d), 0).show();
                            C4990ab.m7416i("MicroMsg.WebViewDownloadUI", "startDownload fail, network not ready");
                            AppMethodBeat.m2505o(7595);
                            return;
                        } else if (C5023at.isWifi(WebViewDownloadUI.this.mContext)) {
                            WebViewDownloadUI.m78842a(WebViewDownloadUI.this, stringExtra2, stringExtra4, stringExtra5, stringExtra7, stringExtra3, stringExtra11, stringExtra, stringExtra8, intExtra);
                            AppMethodBeat.m2505o(7595);
                            return;
                        } else {
                            C7060h.pYm.mo8381e(14217, stringExtra7, Integer.valueOf(4), stringExtra11, stringExtra2, Integer.valueOf(0));
                            C30379h.m48446a(WebViewDownloadUI.this, WebViewDownloadUI.this.getString(C25738R.string.fy6), WebViewDownloadUI.this.getString(C25738R.string.fy7), WebViewDownloadUI.this.getString(C25738R.string.fy1), WebViewDownloadUI.this.getString(C25738R.string.f9076or), false, new C229261(), new C229272(), (int) C25738R.color.a61);
                            AppMethodBeat.m2505o(7595);
                            return;
                        }
                    default:
                        C4990ab.m7412e("MicroMsg.WebViewDownloadUI", "downloadOpBtn.onClick unexpected download state");
                        AppMethodBeat.m2505o(7595);
                        return;
                }
            }
        });
        this.ute.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(7596);
                C4990ab.m7417i("MicroMsg.WebViewDownloadUI", "doCancelDownloadTask, downloadId = %d, state=%s", Long.valueOf(WebViewDownloadUI.this.hxO), WebViewDownloadUI.this.utf);
                C7060h.pYm.mo8381e(14217, stringExtra7, Integer.valueOf(3), stringExtra11, stringExtra2, Integer.valueOf(0));
                if (WebViewDownloadUI.this.hxO <= 0) {
                    C4990ab.m7412e("MicroMsg.WebViewDownloadUI", "doCancelDownloadTask fail, unexpected branch! ");
                } else {
                    C4990ab.m7417i("MicroMsg.WebViewDownloadUI", "doCancelDownloadTask, ret = %d", Integer.valueOf(C2896d.bij().mo7047hl(WebViewDownloadUI.this.hxO)));
                    if (C2896d.bij().mo7047hl(WebViewDownloadUI.this.hxO) > 0) {
                        Toast.makeText(WebViewDownloadUI.this.mController.ylL, WebViewDownloadUI.this.getString(C25738R.string.fy4), 1).show();
                        WebViewDownloadUI.this.finish();
                        AppMethodBeat.m2505o(7596);
                        return;
                    }
                }
                Toast.makeText(WebViewDownloadUI.this.mController.ylL, WebViewDownloadUI.this.getString(C25738R.string.fy3), 1).show();
                AppMethodBeat.m2505o(7596);
            }
        });
        C2896d.bij();
        C2886b.m5129a(this.utj);
        AppMethodBeat.m2505o(7608);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(7609);
        super.onDestroy();
        C4990ab.m7417i("MicroMsg.WebViewDownloadUI", "onDestroy hasCallback=%b", Boolean.valueOf(this.ump));
        if (!this.ump) {
            C45330h c45330h = new C45330h();
            c45330h.crX.crY = true;
            c45330h.crX.scene = this.uti;
            C4879a.xxA.mo10055m(c45330h);
            this.ump = true;
        }
        C2896d.bij();
        C2886b.m5130b(this.utj);
        AppMethodBeat.m2505o(7609);
    }

    public final int getLayoutId() {
        return 2130971212;
    }

    /* renamed from: a */
    private void m78841a(C43937a c43937a) {
        AppMethodBeat.m2504i(7610);
        C4990ab.m7417i("MicroMsg.WebViewDownloadUI", "setDownloadState old=%s new=%s", this.utf, c43937a);
        this.utf = c43937a;
        switch (this.utf) {
            case TO_DOWNLOAD:
                this.utd.setVisibility(0);
                this.kGq.setVisibility(8);
                this.ute.setVisibility(8);
                break;
            case DOWNLOADING:
                this.utd.setVisibility(8);
                this.ute.setVisibility(0);
                this.kGq.setVisibility(0);
                if (!C5046bo.isNullOrNil(this.utg)) {
                    this.uth.setVisibility(0);
                    AppMethodBeat.m2505o(7610);
                    return;
                }
                break;
            default:
                AppMethodBeat.m2505o(7610);
        }
        this.uth.setVisibility(8);
        AppMethodBeat.m2505o(7610);
    }

    /* renamed from: a */
    static /* synthetic */ void m78842a(WebViewDownloadUI webViewDownloadUI, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i) {
        AppMethodBeat.m2504i(7611);
        C45327gw c45327gw = new C45327gw();
        c45327gw.cBC.url = str;
        c45327gw.cBC.cvZ = str2;
        c45327gw.cBC.extInfo = str3;
        c45327gw.cBC.appId = str4;
        C4879a.xxA.mo10055m(c45327gw);
        C7060h.pYm.mo8381e(14217, str4, Integer.valueOf(2), str6, str, Integer.valueOf(0));
        C2901a c2901a = new C2901a();
        c2901a.mo7055It(str);
        c2901a.mo7056Iu(str5);
        c2901a.mo7057Iv(str7);
        c2901a.mo7058Iw(str2);
        c2901a.setAppId(str4);
        c2901a.mo7062cY(str8);
        c2901a.mo7063ga(true);
        c2901a.mo7069tN(webViewDownloadUI.kNb);
        c2901a.mo7059Ix(str3);
        c2901a.setScene(i);
        long a = C2896d.bij().mo7042a(c2901a.kNl);
        C4990ab.m7417i("MicroMsg.WebViewDownloadUI", "downloadOpBtn.onClick, lastDownloadId = %d, downloadId=%d", Long.valueOf(webViewDownloadUI.hxO), Long.valueOf(a));
        webViewDownloadUI.hxO = a;
        C45330h c45330h = new C45330h();
        c45330h.crX.crZ = a;
        c45330h.crX.crY = false;
        c45330h.crX.scene = webViewDownloadUI.uti;
        C4879a.xxA.mo10055m(c45330h);
        webViewDownloadUI.ump = true;
        if (a <= 0) {
            Toast.makeText(webViewDownloadUI.mController.ylL, webViewDownloadUI.getString(C25738R.string.fy5), 1).show();
            webViewDownloadUI.finish();
            AppMethodBeat.m2505o(7611);
            return;
        }
        Toast.makeText(webViewDownloadUI.mController.ylL, webViewDownloadUI.getString(C25738R.string.fy0), 1).show();
        webViewDownloadUI.m78841a(C43937a.DOWNLOADING);
        C26483d.m42196b(10, "WebViewDownloadUI_startDownload", webViewDownloadUI.hashCode());
        AppMethodBeat.m2505o(7611);
    }
}
