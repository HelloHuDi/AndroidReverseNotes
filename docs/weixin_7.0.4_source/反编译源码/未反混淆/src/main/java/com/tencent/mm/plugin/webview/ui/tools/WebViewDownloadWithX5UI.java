package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.ValueCallback;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.at.a.a.c;
import com.tencent.mm.at.o;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.g.a.gw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelstat.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.smtt.sdk.QbSdk;
import java.util.HashMap;

@a(2)
public class WebViewDownloadWithX5UI extends MMActivity {
    private Context mContext;
    private Button utd;
    private final com.tencent.mm.plugin.webview.modeltools.a utt = new com.tencent.mm.plugin.webview.modeltools.a();

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WebViewDownloadWithX5UI() {
        AppMethodBeat.i(7617);
        AppMethodBeat.o(7617);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(7618);
        super.onCreate(bundle);
        this.mContext = this;
        setMMTitle(getString(R.string.fya));
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(7612);
                WebViewDownloadWithX5UI.this.finish();
                AppMethodBeat.o(7612);
                return true;
            }
        });
        overridePendingTransition(MMFragmentActivity.a.ync, MMFragmentActivity.a.ynd);
        this.utd = (Button) findViewById(R.id.fk3);
        ImageView imageView = (ImageView) findViewById(R.id.fk0);
        TextView textView = (TextView) findViewById(R.id.fk1);
        final String stringExtra = getIntent().getStringExtra("task_url");
        String stringExtra2 = getIntent().getStringExtra("title");
        final long longExtra = getIntent().getLongExtra("task_size", 0);
        final String stringExtra3 = getIntent().getStringExtra("page_url");
        ab.i("MicroMsg.WebViewDownloadWithX5UI", "onCreate: url=%s,taskSize=%d, thumbUrl=%s", stringExtra, Long.valueOf(longExtra), getIntent().getStringExtra("thumb_url"));
        if (longExtra > 0) {
            String my = bo.my(longExtra);
            this.utd.setText(getString(R.string.fy2, new Object[]{my}));
        }
        if (g.RK()) {
            com.tencent.mm.at.a.a ahp = o.ahp();
            c.a aVar = new c.a();
            aVar.ePT = R.raw.webview_download_thumb_unknown;
            aVar.ePH = true;
            ahp.a(r7, imageView, aVar.ahG());
        } else {
            imageView.setImageResource(R.raw.webview_download_thumb_unknown);
        }
        textView.setVisibility(0);
        if (bo.isNullOrNil(stringExtra2)) {
            textView.setText(getString(R.string.fy_));
        } else {
            textView.setText(stringExtra2);
        }
        h.pYm.e(14217, "", Integer.valueOf(1), stringExtra3, stringExtra, Integer.valueOf(1));
        this.utd.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(7615);
                if (!at.isNetworkConnected(WebViewDownloadWithX5UI.this.mContext)) {
                    Toast.makeText(WebViewDownloadWithX5UI.this.mContext, WebViewDownloadWithX5UI.this.getString(R.string.c5d), 0).show();
                    ab.i("MicroMsg.WebViewDownloadWithX5UI", "startDownload fail, network not ready");
                    AppMethodBeat.o(7615);
                } else if (!g.RP().isSDCardAvailable()) {
                    Toast.makeText(WebViewDownloadWithX5UI.this.mContext, WebViewDownloadWithX5UI.this.getString(R.string.c5h), 0).show();
                    ab.i("MicroMsg.WebViewDownloadWithX5UI", "startDownload fail, sdcard not ready");
                    AppMethodBeat.o(7615);
                } else if (longExtra > 0 && !f.eW(longExtra)) {
                    Toast.makeText(WebViewDownloadWithX5UI.this.mContext, WebViewDownloadWithX5UI.this.getString(R.string.c5e), 0).show();
                    ab.i("MicroMsg.WebViewDownloadWithX5UI", "startDownload fail, not enough space, require size = " + longExtra);
                    AppMethodBeat.o(7615);
                } else if (at.isWifi(WebViewDownloadWithX5UI.this.mContext)) {
                    WebViewDownloadWithX5UI.a(WebViewDownloadWithX5UI.this, stringExtra, stringExtra3);
                    AppMethodBeat.o(7615);
                } else {
                    h.pYm.e(14217, "", Integer.valueOf(4), stringExtra3, stringExtra, Integer.valueOf(1));
                    com.tencent.mm.ui.base.h.a(WebViewDownloadWithX5UI.this, WebViewDownloadWithX5UI.this.getString(R.string.fy6), WebViewDownloadWithX5UI.this.getString(R.string.fy7), WebViewDownloadWithX5UI.this.getString(R.string.fy1), WebViewDownloadWithX5UI.this.getString(R.string.or), false, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(7613);
                            h.pYm.e(14217, "", Integer.valueOf(5), stringExtra3, stringExtra, Integer.valueOf(1));
                            WebViewDownloadWithX5UI.a(WebViewDownloadWithX5UI.this, stringExtra, stringExtra3);
                            dialogInterface.dismiss();
                            AppMethodBeat.o(7613);
                        }
                    }, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(7614);
                            h.pYm.e(14217, "", Integer.valueOf(6), stringExtra3, stringExtra, Integer.valueOf(1));
                            dialogInterface.dismiss();
                            AppMethodBeat.o(7614);
                        }
                    }, (int) R.color.a61);
                    AppMethodBeat.o(7615);
                }
            }
        });
        AppMethodBeat.o(7618);
    }

    public void onDestroy() {
        AppMethodBeat.i(7619);
        super.onDestroy();
        AppMethodBeat.o(7619);
    }

    public final int getLayoutId() {
        return R.layout.b7b;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(7620);
        super.onActivityResult(i, i2, intent);
        if (com.tencent.mm.plugin.webview.modeltools.a.d(this, i, i2, intent)) {
            if (-1 == i2) {
                finish();
            }
            AppMethodBeat.o(7620);
            return;
        }
        AppMethodBeat.o(7620);
    }

    public void startActivity(Intent intent) {
        AppMethodBeat.i(7621);
        if (bo.isEqual(intent.getType(), "application/vnd.android.package-archive")) {
            q.a(ah.getContext(), intent.getData(), null);
            AppMethodBeat.o(7621);
            return;
        }
        super.startActivity(intent);
        AppMethodBeat.o(7621);
    }

    static /* synthetic */ void a(WebViewDownloadWithX5UI webViewDownloadWithX5UI, String str, String str2) {
        int i;
        AppMethodBeat.i(7622);
        gw gwVar = new gw();
        gwVar.cBC.url = str;
        gwVar.cBC.cvZ = "";
        gwVar.cBC.extInfo = "";
        gwVar.cBC.appId = "";
        com.tencent.mm.sdk.b.a.xxA.m(gwVar);
        h.pYm.e(14217, "", Integer.valueOf(2), str2, str, Integer.valueOf(1));
        d.b(10, "WebViewDownloadWithX5UI_startDownload", webViewDownloadWithX5UI.hashCode());
        int tbsVersion = com.tencent.xweb.x5.sdk.d.getTbsVersion(webViewDownloadWithX5UI);
        if (g.RK()) {
            String str3 = (String) g.RP().Ry().get(274528, (Object) "");
            if (TextUtils.isEmpty(str3) || !p.u(webViewDownloadWithX5UI.mController.ylL, str3)) {
                i = 0;
            } else {
                ab.i("MicroMsg.WebViewDownloadWithX5UI", "use always option PackageName is %s", str3);
                i = 1;
            }
        } else {
            i = 0;
        }
        if (i != 0 || tbsVersion <= 0) {
            com.tencent.mm.plugin.webview.modeltools.a.e(webViewDownloadWithX5UI, str);
            AppMethodBeat.o(7622);
            return;
        }
        HashMap hashMap = new HashMap(2);
        hashMap.put(QbSdk.LOGIN_TYPE_KEY_PARTNER_ID, "com.tencent.mm");
        hashMap.put(QbSdk.LOGIN_TYPE_KEY_PARTNER_CALL_POS, "9");
        ab.i("MicroMsg.WebViewDownloadWithX5UI", "startQbOrMiniQBToLoadUrl ret = %b", Boolean.valueOf(com.tencent.xweb.x5.sdk.d.a(webViewDownloadWithX5UI, str, hashMap, new ValueCallback<String>() {
            public final /* synthetic */ void onReceiveValue(Object obj) {
                AppMethodBeat.i(7616);
                ab.i("MicroMsg.WebViewDownloadWithX5UI", "onReceiveValue Value = %s", (String) obj);
                if ("closeMiniQb".equals((String) obj)) {
                    WebViewDownloadWithX5UI.this.finish();
                }
                AppMethodBeat.o(7616);
            }
        })));
        if (!com.tencent.xweb.x5.sdk.d.a(webViewDownloadWithX5UI, str, hashMap, /* anonymous class already generated */)) {
            com.tencent.mm.plugin.webview.modeltools.a.e(webViewDownloadWithX5UI, str);
        }
        AppMethodBeat.o(7622);
    }
}
