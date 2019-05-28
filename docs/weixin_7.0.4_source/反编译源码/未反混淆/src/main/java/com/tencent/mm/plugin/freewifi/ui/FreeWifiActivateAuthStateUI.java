package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.net.NetworkInfo.State;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.plugin.freewifi.d.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.model.g.b;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

@Deprecated
public class FreeWifiActivateAuthStateUI extends FreeWifiActivateStateUI {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(20892);
        super.onCreate(bundle);
        if (this.cvd != 2) {
            d.a(this.ssid, 1, getIntent());
        }
        ab.i("MicroMsg.FreeWifi.FreeWifiActivateAuthStateUI", "now it is from qrcode, try to auth");
        AppMethodBeat.o(20892);
    }

    public final void initView() {
        AppMethodBeat.i(20893);
        super.initView();
        this.mxV = (Button) findViewById(R.id.bw_);
        this.mxV.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(20889);
                String string = FreeWifiActivateAuthStateUI.this.getString(R.string.c07);
                Intent intent = new Intent();
                intent.putExtra("rawUrl", string);
                intent.putExtra("showShare", false);
                intent.putExtra("show_bottom", false);
                com.tencent.mm.bp.d.b(FreeWifiActivateAuthStateUI.this, "webview", ".ui.tools.WebViewUI", intent);
                AppMethodBeat.o(20889);
            }
        });
        setMMTitle((int) R.string.c0t);
        AppMethodBeat.o(20893);
    }

    public void onDestroy() {
        AppMethodBeat.i(20894);
        super.onDestroy();
        AppMethodBeat.o(20894);
    }

    public final void a(State state) {
        AppMethodBeat.i(20895);
        ab.i("MicroMsg.FreeWifi.FreeWifiActivateAuthStateUI", "now network state : %s", state.toString());
        if (state == State.CONNECTED && d.MD(this.ssid)) {
            bzD();
            bzF();
        }
        AppMethodBeat.o(20895);
    }

    /* Access modifiers changed, original: protected|final */
    public final void aqU() {
        AppMethodBeat.i(20896);
        j.bzb().a(this.ssid, new b() {
            public final void ci(String str, int i) {
                AppMethodBeat.i(20891);
                ab.i("MicroMsg.FreeWifi.FreeWifiActivateAuthStateUI", "get ap auth data : %s, url : %s, mac : %s", str, FreeWifiActivateAuthStateUI.this.jUg, d.byK());
                if (!bo.isNullOrNil(str)) {
                    String str2 = str;
                    new a(FreeWifiActivateAuthStateUI.this.jUg, FreeWifiActivateAuthStateUI.this.ssid, r3, FreeWifiActivateAuthStateUI.this.mxW, str2, "", i, m.V(FreeWifiActivateAuthStateUI.this.getIntent())).c(new f() {
                        public final void onSceneEnd(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
                            AppMethodBeat.i(20890);
                            ab.i("MicroMsg.FreeWifi.FreeWifiActivateAuthStateUI", "errType : %d, errCode : %d, errMsg : %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                            FreeWifiActivateAuthStateUI.this.mxY = false;
                            if (i == 0 && i2 == 0) {
                                ab.i("MicroMsg.FreeWifi.FreeWifiActivateAuthStateUI", "authUrl : %s", ((a) mVar).bze());
                                j.bzb().a(FreeWifiActivateAuthStateUI.this.ssid, r0, FreeWifiActivateAuthStateUI.this.getIntent());
                                AppMethodBeat.o(20890);
                            } else if (i2 == -2014) {
                                d.a(FreeWifiActivateAuthStateUI.this.ssid, -2014, FreeWifiActivateAuthStateUI.this.getIntent());
                                AppMethodBeat.o(20890);
                            } else {
                                d.a(FreeWifiActivateAuthStateUI.this.ssid, 3, FreeWifiActivateAuthStateUI.this.getIntent());
                                AppMethodBeat.o(20890);
                            }
                        }
                    });
                }
                AppMethodBeat.o(20891);
            }
        }, this.cdf, getIntent());
        AppMethodBeat.o(20896);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bzy() {
        AppMethodBeat.i(20897);
        bzC();
        d.ME(this.ssid);
        AppMethodBeat.o(20897);
    }

    /* Access modifiers changed, original: protected|final */
    public final int bzz() {
        AppMethodBeat.i(20898);
        j.byV();
        int MC = d.MC(this.ssid);
        AppMethodBeat.o(20898);
        return MC;
    }
}
