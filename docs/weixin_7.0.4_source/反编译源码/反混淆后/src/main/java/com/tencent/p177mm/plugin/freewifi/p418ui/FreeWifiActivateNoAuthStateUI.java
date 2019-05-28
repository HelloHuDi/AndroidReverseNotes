package com.tencent.p177mm.plugin.freewifi.p418ui;

import android.net.NetworkInfo.State;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.freewifi.model.C45957d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

@Deprecated
/* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiActivateNoAuthStateUI */
public abstract class FreeWifiActivateNoAuthStateUI extends FreeWifiActivateStateUI {
    private String gDC;
    private int mxP;
    private boolean mxQ;

    public abstract String bzA();

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        this.mxP = getIntent().getIntExtra("free_wifi_encrypt_type", 0);
        this.gDC = getIntent().getStringExtra("free_wifi_passowrd");
        this.mxQ = getIntent().getBooleanExtra("free_wifi_hide_ssid", false);
        super.onCreate(bundle);
        C45957d.m85352a(this.ssid, 1, getIntent());
        C4990ab.m7416i("MicroMsg.FreeWifi.FreeWifiActivateNoAuthStateUI", "Comes from webview, do auth");
    }

    public final void initView() {
        super.initView();
        this.mxV.setVisibility(0);
        setMMTitle(bzA());
    }

    public void onDestroy() {
        super.onDestroy();
    }

    /* renamed from: a */
    public void mo17587a(State state) {
        C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiActivateNoAuthStateUI", "now network state : %s", state.toString());
        if (state == State.CONNECTED && C45957d.m85348MD(this.ssid)) {
            bzD();
            this.mxY = false;
            C45957d.m85352a(this.ssid, 2, getIntent());
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void aqU() {
        bzy();
    }

    /* Access modifiers changed, original: protected|final */
    public final void bzy() {
        if (this.mxY) {
            C4990ab.m7416i("MicroMsg.FreeWifi.FreeWifiActivateNoAuthStateUI", "it is authing now");
            return;
        }
        this.mxY = true;
        bzC();
        C45957d.m85353c(this.ssid, this.gDC, this.mxP, this.mxQ);
    }

    /* Access modifiers changed, original: protected */
    public int bzz() {
        if (!C45957d.m85348MD(this.ssid)) {
            return 1;
        }
        C45957d.m85352a(this.ssid, 2, getIntent());
        return 2;
    }
}
