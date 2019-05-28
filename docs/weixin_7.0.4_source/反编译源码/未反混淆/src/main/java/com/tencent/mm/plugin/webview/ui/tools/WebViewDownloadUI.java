package com.tencent.mm.plugin.webview.ui.tools;

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
import com.tencent.mm.R;
import com.tencent.mm.at.o;
import com.tencent.mm.g.a.gw;
import com.tencent.mm.plugin.downloader.model.b;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;

public class WebViewDownloadUI extends MMActivity {
    private long hxO;
    private TextView kGq;
    private int kNb;
    private Context mContext;
    private boolean ump;
    private Button utd;
    private TextView ute;
    private a utf;
    private String utg;
    private TextView uth;
    private int uti;
    private k utj = new k() {
        public final void onTaskStarted(long j, String str) {
            AppMethodBeat.i(7597);
            ab.i("MicroMsg.WebViewDownloadUI", "onTaskStarted id=%d, savedFilePath=%s", Long.valueOf(j), str);
            AppMethodBeat.o(7597);
        }

        public final void b(long j, String str, boolean z) {
            AppMethodBeat.i(7598);
            ab.i("MicroMsg.WebViewDownloadUI", "onTaskFinished id=%d, savedFilePath=%s, hasChangeUrl=%b", Long.valueOf(j), str, Boolean.valueOf(z));
            Toast.makeText(WebViewDownloadUI.this.mController.ylL, WebViewDownloadUI.this.getString(R.string.fy8), 1).show();
            WebViewDownloadUI.this.finish();
            AppMethodBeat.o(7598);
        }

        public final void b(long j, int i, boolean z) {
            AppMethodBeat.i(7599);
            ab.i("MicroMsg.WebViewDownloadUI", "onTaskFailed id=%d, errCode=%d, hasChangeUrl=%b", Long.valueOf(j), Integer.valueOf(i), Boolean.valueOf(z));
            Toast.makeText(WebViewDownloadUI.this.mController.ylL, WebViewDownloadUI.this.getString(R.string.fy5), 1).show();
            WebViewDownloadUI.this.finish();
            AppMethodBeat.o(7599);
        }

        public final void onTaskRemoved(long j) {
            AppMethodBeat.i(7600);
            ab.i("MicroMsg.WebViewDownloadUI", "onTaskRemoved id=%d", Long.valueOf(j));
            WebViewDownloadUI.this.finish();
            AppMethodBeat.o(7600);
        }

        public final void onTaskPaused(long j) {
            AppMethodBeat.i(7601);
            ab.i("MicroMsg.WebViewDownloadUI", "onTaskPaused id=%d", Long.valueOf(j));
            AppMethodBeat.o(7601);
        }

        public final void gm(long j) {
        }

        public final void i(long j, String str) {
            AppMethodBeat.i(7602);
            ab.i("MicroMsg.WebViewDownloadUI", "onTaskResumed id=%d, savedFilePath=%s", Long.valueOf(j), str);
            AppMethodBeat.o(7602);
        }

        public final void gn(long j) {
        }
    };

    enum a {
        TO_DOWNLOAD,
        DOWNLOADING;

        static {
            AppMethodBeat.o(7606);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WebViewDownloadUI() {
        AppMethodBeat.i(7607);
        AppMethodBeat.o(7607);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(7608);
        super.onCreate(bundle);
        this.mContext = this;
        setMMTitle(getString(R.string.fya));
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(7592);
                WebViewDownloadUI.this.finish();
                AppMethodBeat.o(7592);
                return true;
            }
        });
        overridePendingTransition(com.tencent.mm.ui.MMFragmentActivity.a.ync, com.tencent.mm.ui.MMFragmentActivity.a.ynd);
        this.utd = (Button) findViewById(R.id.fk3);
        this.ute = (TextView) findViewById(R.id.fk5);
        TextView textView = (TextView) findViewById(R.id.fk1);
        this.uth = (TextView) findViewById(R.id.fk2);
        ImageView imageView = (ImageView) findViewById(R.id.fk0);
        this.kGq = (TextView) findViewById(R.id.fk4);
        a(a.TO_DOWNLOAD);
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
        h.pYm.e(14217, stringExtra7, Integer.valueOf(1), stringExtra11, stringExtra2, Integer.valueOf(0));
        this.kNb = bo.getInt(stringExtra6, 1);
        if (bo.isNullOrNil(stringExtra10)) {
            stringExtra10 = bo.nullAsNil(stringExtra);
        }
        if (!bo.isNullOrNil(stringExtra10)) {
            textView.setText(stringExtra10);
            textView.setVisibility(0);
        }
        if (longExtra > 0) {
            this.utg = bo.my(longExtra);
            this.uth.setText(this.utg);
            this.utd.setText(getString(R.string.fy2, new Object[]{this.utg}));
        }
        com.tencent.mm.at.a.a ahp = o.ahp();
        com.tencent.mm.at.a.a.c.a aVar = new com.tencent.mm.at.a.a.c.a();
        aVar.ePT = R.raw.webview_download_thumb_unknown;
        aVar.ePH = true;
        ahp.a(stringExtra9, imageView, aVar.ahG());
        this.utd.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(7595);
                ab.i("MicroMsg.WebViewDownloadUI", "downloadOpBtn.onClick state=%s", WebViewDownloadUI.this.utf);
                switch (WebViewDownloadUI.this.utf) {
                    case TO_DOWNLOAD:
                        if (!at.isNetworkConnected(WebViewDownloadUI.this.mContext)) {
                            Toast.makeText(WebViewDownloadUI.this.mContext, WebViewDownloadUI.this.getString(R.string.c5d), 0).show();
                            ab.i("MicroMsg.WebViewDownloadUI", "startDownload fail, network not ready");
                            AppMethodBeat.o(7595);
                            return;
                        } else if (at.isWifi(WebViewDownloadUI.this.mContext)) {
                            WebViewDownloadUI.a(WebViewDownloadUI.this, stringExtra2, stringExtra4, stringExtra5, stringExtra7, stringExtra3, stringExtra11, stringExtra, stringExtra8, intExtra);
                            AppMethodBeat.o(7595);
                            return;
                        } else {
                            h.pYm.e(14217, stringExtra7, Integer.valueOf(4), stringExtra11, stringExtra2, Integer.valueOf(0));
                            com.tencent.mm.ui.base.h.a(WebViewDownloadUI.this, WebViewDownloadUI.this.getString(R.string.fy6), WebViewDownloadUI.this.getString(R.string.fy7), WebViewDownloadUI.this.getString(R.string.fy1), WebViewDownloadUI.this.getString(R.string.or), false, new DialogInterface.OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.i(7593);
                                    h.pYm.e(14217, stringExtra7, Integer.valueOf(5), stringExtra11, stringExtra2, Integer.valueOf(0));
                                    WebViewDownloadUI.a(WebViewDownloadUI.this, stringExtra2, stringExtra4, stringExtra5, stringExtra7, stringExtra3, stringExtra11, stringExtra, stringExtra8, intExtra);
                                    dialogInterface.dismiss();
                                    AppMethodBeat.o(7593);
                                }
                            }, new DialogInterface.OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.i(7594);
                                    h.pYm.e(14217, stringExtra7, Integer.valueOf(6), stringExtra11, stringExtra2, Integer.valueOf(0));
                                    dialogInterface.dismiss();
                                    AppMethodBeat.o(7594);
                                }
                            }, (int) R.color.a61);
                            AppMethodBeat.o(7595);
                            return;
                        }
                    default:
                        ab.e("MicroMsg.WebViewDownloadUI", "downloadOpBtn.onClick unexpected download state");
                        AppMethodBeat.o(7595);
                        return;
                }
            }
        });
        this.ute.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(7596);
                ab.i("MicroMsg.WebViewDownloadUI", "doCancelDownloadTask, downloadId = %d, state=%s", Long.valueOf(WebViewDownloadUI.this.hxO), WebViewDownloadUI.this.utf);
                h.pYm.e(14217, stringExtra7, Integer.valueOf(3), stringExtra11, stringExtra2, Integer.valueOf(0));
                if (WebViewDownloadUI.this.hxO <= 0) {
                    ab.e("MicroMsg.WebViewDownloadUI", "doCancelDownloadTask fail, unexpected branch! ");
                } else {
                    ab.i("MicroMsg.WebViewDownloadUI", "doCancelDownloadTask, ret = %d", Integer.valueOf(d.bij().hl(WebViewDownloadUI.this.hxO)));
                    if (d.bij().hl(WebViewDownloadUI.this.hxO) > 0) {
                        Toast.makeText(WebViewDownloadUI.this.mController.ylL, WebViewDownloadUI.this.getString(R.string.fy4), 1).show();
                        WebViewDownloadUI.this.finish();
                        AppMethodBeat.o(7596);
                        return;
                    }
                }
                Toast.makeText(WebViewDownloadUI.this.mController.ylL, WebViewDownloadUI.this.getString(R.string.fy3), 1).show();
                AppMethodBeat.o(7596);
            }
        });
        d.bij();
        b.a(this.utj);
        AppMethodBeat.o(7608);
    }

    public void onDestroy() {
        AppMethodBeat.i(7609);
        super.onDestroy();
        ab.i("MicroMsg.WebViewDownloadUI", "onDestroy hasCallback=%b", Boolean.valueOf(this.ump));
        if (!this.ump) {
            com.tencent.mm.g.a.h hVar = new com.tencent.mm.g.a.h();
            hVar.crX.crY = true;
            hVar.crX.scene = this.uti;
            com.tencent.mm.sdk.b.a.xxA.m(hVar);
            this.ump = true;
        }
        d.bij();
        b.b(this.utj);
        AppMethodBeat.o(7609);
    }

    public final int getLayoutId() {
        return R.layout.b7b;
    }

    private void a(a aVar) {
        AppMethodBeat.i(7610);
        ab.i("MicroMsg.WebViewDownloadUI", "setDownloadState old=%s new=%s", this.utf, aVar);
        this.utf = aVar;
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
                if (!bo.isNullOrNil(this.utg)) {
                    this.uth.setVisibility(0);
                    AppMethodBeat.o(7610);
                    return;
                }
                break;
            default:
                AppMethodBeat.o(7610);
        }
        this.uth.setVisibility(8);
        AppMethodBeat.o(7610);
    }

    static /* synthetic */ void a(WebViewDownloadUI webViewDownloadUI, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i) {
        AppMethodBeat.i(7611);
        gw gwVar = new gw();
        gwVar.cBC.url = str;
        gwVar.cBC.cvZ = str2;
        gwVar.cBC.extInfo = str3;
        gwVar.cBC.appId = str4;
        com.tencent.mm.sdk.b.a.xxA.m(gwVar);
        h.pYm.e(14217, str4, Integer.valueOf(2), str6, str, Integer.valueOf(0));
        com.tencent.mm.plugin.downloader.model.e.a aVar = new com.tencent.mm.plugin.downloader.model.e.a();
        aVar.It(str);
        aVar.Iu(str5);
        aVar.Iv(str7);
        aVar.Iw(str2);
        aVar.setAppId(str4);
        aVar.cY(str8);
        aVar.ga(true);
        aVar.tN(webViewDownloadUI.kNb);
        aVar.Ix(str3);
        aVar.setScene(i);
        long a = d.bij().a(aVar.kNl);
        ab.i("MicroMsg.WebViewDownloadUI", "downloadOpBtn.onClick, lastDownloadId = %d, downloadId=%d", Long.valueOf(webViewDownloadUI.hxO), Long.valueOf(a));
        webViewDownloadUI.hxO = a;
        com.tencent.mm.g.a.h hVar = new com.tencent.mm.g.a.h();
        hVar.crX.crZ = a;
        hVar.crX.crY = false;
        hVar.crX.scene = webViewDownloadUI.uti;
        com.tencent.mm.sdk.b.a.xxA.m(hVar);
        webViewDownloadUI.ump = true;
        if (a <= 0) {
            Toast.makeText(webViewDownloadUI.mController.ylL, webViewDownloadUI.getString(R.string.fy5), 1).show();
            webViewDownloadUI.finish();
            AppMethodBeat.o(7611);
            return;
        }
        Toast.makeText(webViewDownloadUI.mController.ylL, webViewDownloadUI.getString(R.string.fy0), 1).show();
        webViewDownloadUI.a(a.DOWNLOADING);
        com.tencent.mm.modelstat.d.b(10, "WebViewDownloadUI_startDownload", webViewDownloadUI.hashCode());
        AppMethodBeat.o(7611);
    }
}
