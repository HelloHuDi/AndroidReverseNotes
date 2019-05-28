package com.tencent.p177mm.plugin.webview.p580ui.tools;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.compatible.util.C1445f;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelstat.C26483d;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.p191a.C25815a;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p230g.p231a.C45327gw;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMFragmentActivity.C5206a;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.webview.modeltools.C35618a;
import com.tencent.p177mm.pluginsdk.model.app.C35799p;
import com.tencent.p177mm.pluginsdk.model.app.C35800q;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.xweb.p685x5.sdk.C24544d;
import java.util.HashMap;

@C5271a(2)
/* renamed from: com.tencent.mm.plugin.webview.ui.tools.WebViewDownloadWithX5UI */
public class WebViewDownloadWithX5UI extends MMActivity {
    private Context mContext;
    private Button utd;
    private final C35618a utt = new C35618a();

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.WebViewDownloadWithX5UI$1 */
    class C145681 implements OnMenuItemClickListener {
        C145681() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(7612);
            WebViewDownloadWithX5UI.this.finish();
            AppMethodBeat.m2505o(7612);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.WebViewDownloadWithX5UI$3 */
    class C402873 implements ValueCallback<String> {
        C402873() {
        }

        public final /* synthetic */ void onReceiveValue(Object obj) {
            AppMethodBeat.m2504i(7616);
            C4990ab.m7417i("MicroMsg.WebViewDownloadWithX5UI", "onReceiveValue Value = %s", (String) obj);
            if ("closeMiniQb".equals((String) obj)) {
                WebViewDownloadWithX5UI.this.finish();
            }
            AppMethodBeat.m2505o(7616);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public WebViewDownloadWithX5UI() {
        AppMethodBeat.m2504i(7617);
        AppMethodBeat.m2505o(7617);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(7618);
        super.onCreate(bundle);
        this.mContext = this;
        setMMTitle(getString(C25738R.string.fya));
        setBackBtn(new C145681());
        overridePendingTransition(C5206a.ync, C5206a.ynd);
        this.utd = (Button) findViewById(2131829167);
        ImageView imageView = (ImageView) findViewById(2131829164);
        TextView textView = (TextView) findViewById(2131829165);
        final String stringExtra = getIntent().getStringExtra("task_url");
        String stringExtra2 = getIntent().getStringExtra("title");
        final long longExtra = getIntent().getLongExtra("task_size", 0);
        final String stringExtra3 = getIntent().getStringExtra("page_url");
        C4990ab.m7417i("MicroMsg.WebViewDownloadWithX5UI", "onCreate: url=%s,taskSize=%d, thumbUrl=%s", stringExtra, Long.valueOf(longExtra), getIntent().getStringExtra("thumb_url"));
        if (longExtra > 0) {
            String my = C5046bo.m7580my(longExtra);
            this.utd.setText(getString(C25738R.string.fy2, new Object[]{my}));
        }
        if (C1720g.m3531RK()) {
            C25815a ahp = C32291o.ahp();
            C17927a c17927a = new C17927a();
            c17927a.ePT = C1318a.webview_download_thumb_unknown;
            c17927a.ePH = true;
            ahp.mo43766a(r7, imageView, c17927a.ahG());
        } else {
            imageView.setImageResource(C1318a.webview_download_thumb_unknown);
        }
        textView.setVisibility(0);
        if (C5046bo.isNullOrNil(stringExtra2)) {
            textView.setText(getString(C25738R.string.fy_));
        } else {
            textView.setText(stringExtra2);
        }
        C7060h.pYm.mo8381e(14217, "", Integer.valueOf(1), stringExtra3, stringExtra, Integer.valueOf(1));
        this.utd.setOnClickListener(new OnClickListener() {

            /* renamed from: com.tencent.mm.plugin.webview.ui.tools.WebViewDownloadWithX5UI$2$1 */
            class C356371 implements DialogInterface.OnClickListener {
                C356371() {
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(7613);
                    C7060h.pYm.mo8381e(14217, "", Integer.valueOf(5), stringExtra3, stringExtra, Integer.valueOf(1));
                    WebViewDownloadWithX5UI.m69083a(WebViewDownloadWithX5UI.this, stringExtra, stringExtra3);
                    dialogInterface.dismiss();
                    AppMethodBeat.m2505o(7613);
                }
            }

            /* renamed from: com.tencent.mm.plugin.webview.ui.tools.WebViewDownloadWithX5UI$2$2 */
            class C356392 implements DialogInterface.OnClickListener {
                C356392() {
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(7614);
                    C7060h.pYm.mo8381e(14217, "", Integer.valueOf(6), stringExtra3, stringExtra, Integer.valueOf(1));
                    dialogInterface.dismiss();
                    AppMethodBeat.m2505o(7614);
                }
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(7615);
                if (!C5023at.isNetworkConnected(WebViewDownloadWithX5UI.this.mContext)) {
                    Toast.makeText(WebViewDownloadWithX5UI.this.mContext, WebViewDownloadWithX5UI.this.getString(C25738R.string.c5d), 0).show();
                    C4990ab.m7416i("MicroMsg.WebViewDownloadWithX5UI", "startDownload fail, network not ready");
                    AppMethodBeat.m2505o(7615);
                } else if (!C1720g.m3536RP().isSDCardAvailable()) {
                    Toast.makeText(WebViewDownloadWithX5UI.this.mContext, WebViewDownloadWithX5UI.this.getString(C25738R.string.c5h), 0).show();
                    C4990ab.m7416i("MicroMsg.WebViewDownloadWithX5UI", "startDownload fail, sdcard not ready");
                    AppMethodBeat.m2505o(7615);
                } else if (longExtra > 0 && !C1445f.m3072eW(longExtra)) {
                    Toast.makeText(WebViewDownloadWithX5UI.this.mContext, WebViewDownloadWithX5UI.this.getString(C25738R.string.c5e), 0).show();
                    C4990ab.m7416i("MicroMsg.WebViewDownloadWithX5UI", "startDownload fail, not enough space, require size = " + longExtra);
                    AppMethodBeat.m2505o(7615);
                } else if (C5023at.isWifi(WebViewDownloadWithX5UI.this.mContext)) {
                    WebViewDownloadWithX5UI.m69083a(WebViewDownloadWithX5UI.this, stringExtra, stringExtra3);
                    AppMethodBeat.m2505o(7615);
                } else {
                    C7060h.pYm.mo8381e(14217, "", Integer.valueOf(4), stringExtra3, stringExtra, Integer.valueOf(1));
                    C30379h.m48446a(WebViewDownloadWithX5UI.this, WebViewDownloadWithX5UI.this.getString(C25738R.string.fy6), WebViewDownloadWithX5UI.this.getString(C25738R.string.fy7), WebViewDownloadWithX5UI.this.getString(C25738R.string.fy1), WebViewDownloadWithX5UI.this.getString(C25738R.string.f9076or), false, new C356371(), new C356392(), (int) C25738R.color.a61);
                    AppMethodBeat.m2505o(7615);
                }
            }
        });
        AppMethodBeat.m2505o(7618);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(7619);
        super.onDestroy();
        AppMethodBeat.m2505o(7619);
    }

    public final int getLayoutId() {
        return 2130971212;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(7620);
        super.onActivityResult(i, i2, intent);
        if (C35618a.m58462d(this, i, i2, intent)) {
            if (-1 == i2) {
                finish();
            }
            AppMethodBeat.m2505o(7620);
            return;
        }
        AppMethodBeat.m2505o(7620);
    }

    public void startActivity(Intent intent) {
        AppMethodBeat.m2504i(7621);
        if (C5046bo.isEqual(intent.getType(), "application/vnd.android.package-archive")) {
            C35800q.m58697a(C4996ah.getContext(), intent.getData(), null);
            AppMethodBeat.m2505o(7621);
            return;
        }
        super.startActivity(intent);
        AppMethodBeat.m2505o(7621);
    }

    /* renamed from: a */
    static /* synthetic */ void m69083a(WebViewDownloadWithX5UI webViewDownloadWithX5UI, String str, String str2) {
        int i;
        AppMethodBeat.m2504i(7622);
        C45327gw c45327gw = new C45327gw();
        c45327gw.cBC.url = str;
        c45327gw.cBC.cvZ = "";
        c45327gw.cBC.extInfo = "";
        c45327gw.cBC.appId = "";
        C4879a.xxA.mo10055m(c45327gw);
        C7060h.pYm.mo8381e(14217, "", Integer.valueOf(2), str2, str, Integer.valueOf(1));
        C26483d.m42196b(10, "WebViewDownloadWithX5UI_startDownload", webViewDownloadWithX5UI.hashCode());
        int tbsVersion = C24544d.getTbsVersion(webViewDownloadWithX5UI);
        if (C1720g.m3531RK()) {
            String str3 = (String) C1720g.m3536RP().mo5239Ry().get(274528, (Object) "");
            if (TextUtils.isEmpty(str3) || !C35799p.m58695u(webViewDownloadWithX5UI.mController.ylL, str3)) {
                i = 0;
            } else {
                C4990ab.m7417i("MicroMsg.WebViewDownloadWithX5UI", "use always option PackageName is %s", str3);
                i = 1;
            }
        } else {
            i = 0;
        }
        if (i != 0 || tbsVersion <= 0) {
            C35618a.m58463e(webViewDownloadWithX5UI, str);
            AppMethodBeat.m2505o(7622);
            return;
        }
        HashMap hashMap = new HashMap(2);
        hashMap.put(QbSdk.LOGIN_TYPE_KEY_PARTNER_ID, "com.tencent.mm");
        hashMap.put(QbSdk.LOGIN_TYPE_KEY_PARTNER_CALL_POS, "9");
        C4990ab.m7417i("MicroMsg.WebViewDownloadWithX5UI", "startQbOrMiniQBToLoadUrl ret = %b", Boolean.valueOf(C24544d.m38199a(webViewDownloadWithX5UI, str, hashMap, new C402873())));
        if (!C24544d.m38199a(webViewDownloadWithX5UI, str, hashMap, new C402873())) {
            C35618a.m58463e(webViewDownloadWithX5UI, str);
        }
        AppMethodBeat.m2505o(7622);
    }
}
