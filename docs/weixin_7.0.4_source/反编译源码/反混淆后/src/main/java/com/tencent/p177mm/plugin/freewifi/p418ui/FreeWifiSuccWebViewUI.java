package com.tencent.p177mm.plugin.freewifi.p418ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.C5536q.C5535b;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.service.C42687f;
import com.tencent.p177mm.plugin.freewifi.C11966k;
import com.tencent.p177mm.plugin.freewifi.C11966k.C11967a;
import com.tencent.p177mm.plugin.freewifi.C11966k.C11968b;
import com.tencent.p177mm.plugin.freewifi.C11970l;
import com.tencent.p177mm.plugin.freewifi.C3138j;
import com.tencent.p177mm.plugin.freewifi.C34189m;
import com.tencent.p177mm.plugin.freewifi.model.C11972i;
import com.tencent.p177mm.plugin.freewifi.model.C45957d;
import com.tencent.p177mm.plugin.webview.p580ui.tools.WebViewUI;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.FilterEnum4Shaka;

/* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiSuccWebViewUI */
public class FreeWifiSuccWebViewUI extends WebViewUI implements C1202f {
    private String cBb;
    private int cIb;
    private String csB;
    private String mAa;
    private boolean mAl = false;
    private String mwH;
    private int mzZ;
    private String signature;

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiSuccWebViewUI$1 */
    class C342001 implements OnMenuItemClickListener {
        C342001() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(21097);
            FreeWifiSuccWebViewUI.this.finish();
            FreeWifiSuccWebViewUI.m56083a(FreeWifiSuccWebViewUI.this);
            AppMethodBeat.m2505o(21097);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiSuccWebViewUI$2 */
    class C342012 implements OnMenuItemClickListener {
        C342012() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(21098);
            FreeWifiSuccWebViewUI.this.finish();
            FreeWifiSuccWebViewUI.m56083a(FreeWifiSuccWebViewUI.this);
            AppMethodBeat.m2505o(21098);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    @TargetApi(11)
    public void onDestroy() {
        AppMethodBeat.m2504i(21100);
        super.onDestroy();
        C9638aw.m17182Rg().mo14546b(1703, (C1202f) this);
        AppMethodBeat.m2505o(21100);
    }

    public final void aMh() {
        AppMethodBeat.m2504i(21101);
        super.aMh();
        AppMethodBeat.m2505o(21101);
    }

    public void finish() {
        AppMethodBeat.m2504i(21102);
        super.finish();
        AppMethodBeat.m2505o(21102);
    }

    public void onBackPressed() {
        AppMethodBeat.m2504i(21103);
        super.onBackPressed();
        AppMethodBeat.m2505o(21103);
    }

    public final void initView() {
        AppMethodBeat.m2504i(21104);
        super.initView();
        mo17427pP(false);
        mo17379a(0, getString(C25738R.string.c08), (OnMenuItemClickListener) new C342001(), C5535b.TRANSPARENT_GREEN_TEXT);
        AppMethodBeat.m2505o(21104);
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        AppMethodBeat.m2504i(21105);
        if (!getString(C25738R.string.c08).equals((String) menu.getItem(0).getTitle())) {
            mo17379a(0, getString(C25738R.string.c08), (OnMenuItemClickListener) new C342012(), C5535b.TRANSPARENT_GREEN_TEXT);
        }
        boolean onPrepareOptionsMenu = super.onPrepareOptionsMenu(menu);
        AppMethodBeat.m2505o(21105);
        return onPrepareOptionsMenu;
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(21106);
        C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiSuccWebViewUI", "onSceneEnd, scnee type = %d, errType = %d, errCode = %d", Integer.valueOf(c1207m.getType()), Integer.valueOf(i), Integer.valueOf(i2));
        C9638aw.m17182Rg().mo14546b(1703, (C1202f) this);
        AppMethodBeat.m2505o(21106);
    }

    public void onCreate(Bundle bundle) {
        String str;
        String bB;
        AppMethodBeat.m2504i(21099);
        C3138j.userName = "";
        C3138j.type = 0;
        C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiSuccWebViewUI", "qinghuaiUrl=%s", getIntent().getStringExtra("free_wifi_qinghuai_url"));
        getIntent().putExtra("rawUrl", str);
        getIntent().putExtra("showShare", false);
        super.onCreate(bundle);
        this.csB = getIntent().getStringExtra("free_wifi_appid");
        this.mwH = getIntent().getStringExtra("free_wifi_app_nickname");
        this.cBb = getIntent().getStringExtra("free_wifi_app_username");
        this.mzZ = getIntent().getIntExtra("free_wifi_finish_actioncode", 0);
        this.mAa = getIntent().getStringExtra("free_wifi_finish_url");
        this.signature = getIntent().getStringExtra("free_wifi_signature");
        this.cIb = C34189m.m56066Y(getIntent());
        if (this.cIb == 10) {
            str = C1427q.eth.etR;
            bB = C1427q.m3045bB(this.mController.ylL);
            if (!(C34189m.isEmpty(str) || C34189m.isEmpty(bB))) {
                this.mAa = Uri.parse(this.mAa).buildUpon().appendQueryParameter("manufacturer", bB).appendQueryParameter("manufacturerUsername", str).toString();
            }
        }
        C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiSuccWebViewUI", "get from intent, appid = %s, appNickName = %s, appUserName = %s, finishActionCode = %d, finishUrl = %s, signature = %s", this.csB, this.mwH, this.cBb, Integer.valueOf(this.mzZ), this.mAa, this.signature);
        C11967a byo = C11966k.byo();
        bB = C34189m.m56061Mz("MicroMsg.FreeWifi.FreeWifiSuccWebViewUI");
        byo.ssid = C5023at.m7474gE(C4996ah.getContext());
        byo.bssid = C5023at.m7475gF(C4996ah.getContext());
        byo.cuI = bB;
        byo.cuH = getIntent().getStringExtra("free_wifi_ap_key");
        byo.mud = this.csB;
        byo.kBq = C34189m.m56063V(getIntent());
        byo.mue = C34189m.m56065X(getIntent());
        byo.muf = C11968b.GetBackPage.muQ;
        byo.mug = C11968b.GetBackPage.name;
        byo.cIb = C34189m.m56066Y(getIntent());
        byo.muh = this.cBb;
        byo.byq().byp();
        AppMethodBeat.m2505o(21099);
    }

    /* renamed from: a */
    static /* synthetic */ void m56083a(FreeWifiSuccWebViewUI freeWifiSuccWebViewUI) {
        AppMethodBeat.m2504i(21107);
        String str = C3138j.userName;
        if (C5046bo.isNullOrNil(freeWifiSuccWebViewUI.cBb) || !freeWifiSuccWebViewUI.cBb.equals(str)) {
            freeWifiSuccWebViewUI.mAl = false;
        } else {
            freeWifiSuccWebViewUI.mAl = true;
        }
        if (!(!freeWifiSuccWebViewUI.mAl || C5046bo.isNullOrNil(freeWifiSuccWebViewUI.csB) || (C1855t.m3913mZ(freeWifiSuccWebViewUI.cBb) && C1855t.m3912mY(freeWifiSuccWebViewUI.cBb)))) {
            C9638aw.m17182Rg().mo14539a(1703, (C1202f) freeWifiSuccWebViewUI);
            C9638aw.m17182Rg().mo14541a(new C11972i(freeWifiSuccWebViewUI.csB, freeWifiSuccWebViewUI.getIntent().getStringExtra("free_wifi_ap_key"), freeWifiSuccWebViewUI.getIntent().getIntExtra("free_wifi_channel_id", 0), C34189m.m56063V(freeWifiSuccWebViewUI.getIntent())), 0);
        }
        C11970l.m19873b(C45957d.byN(), freeWifiSuccWebViewUI.getIntent().getStringExtra("free_wifi_ap_key"), freeWifiSuccWebViewUI.getIntent().getIntExtra("free_wifi_protocol_type", 0), freeWifiSuccWebViewUI.mAl);
        C11967a byo = C11966k.byo();
        String Mz = C34189m.m56061Mz("MicroMsg.FreeWifi.FreeWifiSuccWebViewUI");
        byo.ssid = C5023at.m7474gE(C4996ah.getContext());
        byo.bssid = C5023at.m7475gF(C4996ah.getContext());
        byo.cuI = Mz;
        byo.cuH = C34189m.m56067Z(freeWifiSuccWebViewUI.getIntent());
        byo.mud = freeWifiSuccWebViewUI.csB;
        byo.kBq = C34189m.m56063V(freeWifiSuccWebViewUI.getIntent());
        byo.mue = C34189m.m56065X(freeWifiSuccWebViewUI.getIntent());
        byo.muf = C11968b.QinghuaiBackpageFinished.muQ;
        byo.mug = C11968b.QinghuaiBackpageFinished.name;
        byo.cIb = C34189m.m56066Y(freeWifiSuccWebViewUI.getIntent());
        byo.muh = freeWifiSuccWebViewUI.cBb;
        byo.byq().byp();
        Mz = freeWifiSuccWebViewUI.getIntent().getStringExtra("free_wifi_finish_url");
        if (freeWifiSuccWebViewUI.mzZ != 1 || C5046bo.isNullOrNil(Mz)) {
            if (freeWifiSuccWebViewUI.mzZ == 3 && !C5046bo.isNullOrNil(Mz)) {
                ((C42687f) C1720g.m3528K(C42687f.class)).mo68090b(freeWifiSuccWebViewUI, Mz, FilterEnum4Shaka.MIC_WEISHI_v4_4_NORMAL, null);
                C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiSuccWebViewUI", "jump to wxa after connect wifi success, url is : %s", Mz);
            }
            AppMethodBeat.m2505o(21107);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("rawUrl", Uri.parse(Mz).buildUpon().appendQueryParameter("lang", C4988aa.m7402g(freeWifiSuccWebViewUI.getSharedPreferences(C4996ah.doA(), 0))).build().toString());
        intent.putExtra("show_bottom", false);
        intent.putExtra("stastic_scene", 7);
        intent.putExtra("neverBlockLocalRequest", true);
        C25985d.m41467b((Context) freeWifiSuccWebViewUI, "webview", ".ui.tools.WebViewUI", intent);
        C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiSuccWebViewUI", "jump to ad page after connect wifi success, url is : %s", intent.getStringExtra("rawUrl"));
        AppMethodBeat.m2505o(21107);
    }
}
