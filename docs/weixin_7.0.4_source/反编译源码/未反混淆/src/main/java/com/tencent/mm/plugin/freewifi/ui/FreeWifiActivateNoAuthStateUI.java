package com.tencent.mm.plugin.freewifi.ui;

import android.net.NetworkInfo.State;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.ab;

@Deprecated
public abstract class FreeWifiActivateNoAuthStateUI extends FreeWifiActivateStateUI {
    private String gDC;
    private int mxP;
    private boolean mxQ;

    public abstract String bzA();

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        this.mxP = getIntent().getIntExtra("free_wifi_encrypt_type", 0);
        this.gDC = getIntent().getStringExtra("free_wifi_passowrd");
        this.mxQ = getIntent().getBooleanExtra("free_wifi_hide_ssid", false);
        super.onCreate(bundle);
        d.a(this.ssid, 1, getIntent());
        ab.i("MicroMsg.FreeWifi.FreeWifiActivateNoAuthStateUI", "Comes from webview, do auth");
    }

    public final void initView() {
        super.initView();
        this.mxV.setVisibility(0);
        setMMTitle(bzA());
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void a(State state) {
        ab.i("MicroMsg.FreeWifi.FreeWifiActivateNoAuthStateUI", "now network state : %s", state.toString());
        if (state == State.CONNECTED && d.MD(this.ssid)) {
            bzD();
            this.mxY = false;
            d.a(this.ssid, 2, getIntent());
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void aqU() {
        bzy();
    }

    /* Access modifiers changed, original: protected|final */
    public final void bzy() {
        if (this.mxY) {
            ab.i("MicroMsg.FreeWifi.FreeWifiActivateNoAuthStateUI", "it is authing now");
            return;
        }
        this.mxY = true;
        bzC();
        d.c(this.ssid, this.gDC, this.mxP, this.mxQ);
    }

    /* Access modifiers changed, original: protected */
    public int bzz() {
        if (!d.MD(this.ssid)) {
            return 1;
        }
        d.a(this.ssid, 2, getIntent());
        return 2;
    }
}
