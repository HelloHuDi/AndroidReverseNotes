package com.tencent.mm.plugin.freewifi.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.freewifi.j;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.l;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.model.i;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.q.b;
import com.tencent.ttpic.FilterEnum4Shaka;

public class FreeWifiSuccWebViewUI extends WebViewUI implements f {
    private String cBb;
    private int cIb;
    private String csB;
    private String mAa;
    private boolean mAl = false;
    private String mwH;
    private int mzZ;
    private String signature;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @TargetApi(11)
    public void onDestroy() {
        AppMethodBeat.i(21100);
        super.onDestroy();
        aw.Rg().b(1703, (f) this);
        AppMethodBeat.o(21100);
    }

    public final void aMh() {
        AppMethodBeat.i(21101);
        super.aMh();
        AppMethodBeat.o(21101);
    }

    public void finish() {
        AppMethodBeat.i(21102);
        super.finish();
        AppMethodBeat.o(21102);
    }

    public void onBackPressed() {
        AppMethodBeat.i(21103);
        super.onBackPressed();
        AppMethodBeat.o(21103);
    }

    public final void initView() {
        AppMethodBeat.i(21104);
        super.initView();
        pP(false);
        a(0, getString(R.string.c08), (OnMenuItemClickListener) new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(21097);
                FreeWifiSuccWebViewUI.this.finish();
                FreeWifiSuccWebViewUI.a(FreeWifiSuccWebViewUI.this);
                AppMethodBeat.o(21097);
                return true;
            }
        }, b.TRANSPARENT_GREEN_TEXT);
        AppMethodBeat.o(21104);
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        AppMethodBeat.i(21105);
        if (!getString(R.string.c08).equals((String) menu.getItem(0).getTitle())) {
            a(0, getString(R.string.c08), (OnMenuItemClickListener) new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(21098);
                    FreeWifiSuccWebViewUI.this.finish();
                    FreeWifiSuccWebViewUI.a(FreeWifiSuccWebViewUI.this);
                    AppMethodBeat.o(21098);
                    return true;
                }
            }, b.TRANSPARENT_GREEN_TEXT);
        }
        boolean onPrepareOptionsMenu = super.onPrepareOptionsMenu(menu);
        AppMethodBeat.o(21105);
        return onPrepareOptionsMenu;
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(21106);
        ab.i("MicroMsg.FreeWifi.FreeWifiSuccWebViewUI", "onSceneEnd, scnee type = %d, errType = %d, errCode = %d", Integer.valueOf(mVar.getType()), Integer.valueOf(i), Integer.valueOf(i2));
        aw.Rg().b(1703, (f) this);
        AppMethodBeat.o(21106);
    }

    public void onCreate(Bundle bundle) {
        String str;
        String bB;
        AppMethodBeat.i(21099);
        j.userName = "";
        j.type = 0;
        ab.i("MicroMsg.FreeWifi.FreeWifiSuccWebViewUI", "qinghuaiUrl=%s", getIntent().getStringExtra("free_wifi_qinghuai_url"));
        getIntent().putExtra("rawUrl", str);
        getIntent().putExtra("showShare", false);
        super.onCreate(bundle);
        this.csB = getIntent().getStringExtra("free_wifi_appid");
        this.mwH = getIntent().getStringExtra("free_wifi_app_nickname");
        this.cBb = getIntent().getStringExtra("free_wifi_app_username");
        this.mzZ = getIntent().getIntExtra("free_wifi_finish_actioncode", 0);
        this.mAa = getIntent().getStringExtra("free_wifi_finish_url");
        this.signature = getIntent().getStringExtra("free_wifi_signature");
        this.cIb = com.tencent.mm.plugin.freewifi.m.Y(getIntent());
        if (this.cIb == 10) {
            str = q.eth.etR;
            bB = q.bB(this.mController.ylL);
            if (!(com.tencent.mm.plugin.freewifi.m.isEmpty(str) || com.tencent.mm.plugin.freewifi.m.isEmpty(bB))) {
                this.mAa = Uri.parse(this.mAa).buildUpon().appendQueryParameter("manufacturer", bB).appendQueryParameter("manufacturerUsername", str).toString();
            }
        }
        ab.i("MicroMsg.FreeWifi.FreeWifiSuccWebViewUI", "get from intent, appid = %s, appNickName = %s, appUserName = %s, finishActionCode = %d, finishUrl = %s, signature = %s", this.csB, this.mwH, this.cBb, Integer.valueOf(this.mzZ), this.mAa, this.signature);
        a byo = k.byo();
        bB = com.tencent.mm.plugin.freewifi.m.Mz("MicroMsg.FreeWifi.FreeWifiSuccWebViewUI");
        byo.ssid = at.gE(ah.getContext());
        byo.bssid = at.gF(ah.getContext());
        byo.cuI = bB;
        byo.cuH = getIntent().getStringExtra("free_wifi_ap_key");
        byo.mud = this.csB;
        byo.kBq = com.tencent.mm.plugin.freewifi.m.V(getIntent());
        byo.mue = com.tencent.mm.plugin.freewifi.m.X(getIntent());
        byo.muf = k.b.GetBackPage.muQ;
        byo.mug = k.b.GetBackPage.name;
        byo.cIb = com.tencent.mm.plugin.freewifi.m.Y(getIntent());
        byo.muh = this.cBb;
        byo.byq().byp();
        AppMethodBeat.o(21099);
    }

    static /* synthetic */ void a(FreeWifiSuccWebViewUI freeWifiSuccWebViewUI) {
        AppMethodBeat.i(21107);
        String str = j.userName;
        if (bo.isNullOrNil(freeWifiSuccWebViewUI.cBb) || !freeWifiSuccWebViewUI.cBb.equals(str)) {
            freeWifiSuccWebViewUI.mAl = false;
        } else {
            freeWifiSuccWebViewUI.mAl = true;
        }
        if (!(!freeWifiSuccWebViewUI.mAl || bo.isNullOrNil(freeWifiSuccWebViewUI.csB) || (t.mZ(freeWifiSuccWebViewUI.cBb) && t.mY(freeWifiSuccWebViewUI.cBb)))) {
            aw.Rg().a(1703, (f) freeWifiSuccWebViewUI);
            aw.Rg().a(new i(freeWifiSuccWebViewUI.csB, freeWifiSuccWebViewUI.getIntent().getStringExtra("free_wifi_ap_key"), freeWifiSuccWebViewUI.getIntent().getIntExtra("free_wifi_channel_id", 0), com.tencent.mm.plugin.freewifi.m.V(freeWifiSuccWebViewUI.getIntent())), 0);
        }
        l.b(d.byN(), freeWifiSuccWebViewUI.getIntent().getStringExtra("free_wifi_ap_key"), freeWifiSuccWebViewUI.getIntent().getIntExtra("free_wifi_protocol_type", 0), freeWifiSuccWebViewUI.mAl);
        a byo = k.byo();
        String Mz = com.tencent.mm.plugin.freewifi.m.Mz("MicroMsg.FreeWifi.FreeWifiSuccWebViewUI");
        byo.ssid = at.gE(ah.getContext());
        byo.bssid = at.gF(ah.getContext());
        byo.cuI = Mz;
        byo.cuH = com.tencent.mm.plugin.freewifi.m.Z(freeWifiSuccWebViewUI.getIntent());
        byo.mud = freeWifiSuccWebViewUI.csB;
        byo.kBq = com.tencent.mm.plugin.freewifi.m.V(freeWifiSuccWebViewUI.getIntent());
        byo.mue = com.tencent.mm.plugin.freewifi.m.X(freeWifiSuccWebViewUI.getIntent());
        byo.muf = k.b.QinghuaiBackpageFinished.muQ;
        byo.mug = k.b.QinghuaiBackpageFinished.name;
        byo.cIb = com.tencent.mm.plugin.freewifi.m.Y(freeWifiSuccWebViewUI.getIntent());
        byo.muh = freeWifiSuccWebViewUI.cBb;
        byo.byq().byp();
        Mz = freeWifiSuccWebViewUI.getIntent().getStringExtra("free_wifi_finish_url");
        if (freeWifiSuccWebViewUI.mzZ != 1 || bo.isNullOrNil(Mz)) {
            if (freeWifiSuccWebViewUI.mzZ == 3 && !bo.isNullOrNil(Mz)) {
                ((com.tencent.mm.plugin.appbrand.service.f) g.K(com.tencent.mm.plugin.appbrand.service.f.class)).b(freeWifiSuccWebViewUI, Mz, FilterEnum4Shaka.MIC_WEISHI_v4_4_NORMAL, null);
                ab.i("MicroMsg.FreeWifi.FreeWifiSuccWebViewUI", "jump to wxa after connect wifi success, url is : %s", Mz);
            }
            AppMethodBeat.o(21107);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("rawUrl", Uri.parse(Mz).buildUpon().appendQueryParameter("lang", aa.g(freeWifiSuccWebViewUI.getSharedPreferences(ah.doA(), 0))).build().toString());
        intent.putExtra("show_bottom", false);
        intent.putExtra("stastic_scene", 7);
        intent.putExtra("neverBlockLocalRequest", true);
        com.tencent.mm.bp.d.b((Context) freeWifiSuccWebViewUI, "webview", ".ui.tools.WebViewUI", intent);
        ab.i("MicroMsg.FreeWifi.FreeWifiSuccWebViewUI", "jump to ad page after connect wifi success, url is : %s", intent.getStringExtra("rawUrl"));
        AppMethodBeat.o(21107);
    }
}
