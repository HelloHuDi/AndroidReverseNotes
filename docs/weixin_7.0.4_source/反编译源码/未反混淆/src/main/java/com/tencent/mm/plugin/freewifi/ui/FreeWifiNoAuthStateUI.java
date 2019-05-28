package com.tencent.mm.plugin.freewifi.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.NetworkInfo.State;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.h;

@Deprecated
public abstract class FreeWifiNoAuthStateUI extends FreeWifiStateUI {
    private String gDC;
    private int mxP;
    private boolean mxQ;
    private boolean myf = true;

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
        d.a(this.ssid, 4, getIntent());
        ab.i("MicroMsg.FreeWifi.FreeWifiNoAuthStateUI", "Comes from webview, do auth");
    }

    public final void initView() {
        super.initView();
        setMMTitle(bzA());
    }

    /* JADX WARNING: Missing block: B:3:0x0024, code skipped:
            if (com.tencent.mm.pluginsdk.permission.b.a(r8, "android.permission.ACCESS_COARSE_LOCATION", 77, null, null) == false) goto L_0x0026;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onResume() {
        int i = false;
        super.onResume();
        if (this.myf) {
            ab.i("MicroMsg.FreeWifi.FreeWifiNoAuthStateUI", "summerper checkPermission checkLocation [%b]", Boolean.valueOf(b.a(this, "android.permission.ACCESS_COARSE_LOCATION", 77, null, null)));
        }
        if (b.o(this, "android.permission.ACCESS_COARSE_LOCATION")) {
            if (com.tencent.mm.modelgeo.d.agA()) {
                i = 1;
            } else {
                h.a((Context) this, getString(R.string.c9z), getString(R.string.tz), getString(R.string.ckr), getString(R.string.or), false, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(21054);
                        com.tencent.mm.modelgeo.d.bX(FreeWifiNoAuthStateUI.this);
                        AppMethodBeat.o(21054);
                    }
                }, null);
            }
        }
        if (i == 0) {
            ab.i("MicroMsg.FreeWifi.FreeWifiNoAuthStateUI", "check permission not passed!");
        }
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void a(State state) {
        ab.i("MicroMsg.FreeWifi.FreeWifiNoAuthStateUI", "now network state : %s", state.toString());
        if (state == State.CONNECTED && d.MD(this.ssid)) {
            bzD();
            this.mxY = false;
            d.a(this.ssid, 2, getIntent());
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (iArr == null || iArr.length <= 0) {
            ab.i("MicroMsg.FreeWifi.FreeWifiNoAuthStateUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()));
            return;
        }
        ab.i("MicroMsg.FreeWifi.FreeWifiNoAuthStateUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 77:
                if (iArr.length > 0 && iArr[0] == -1) {
                    this.myf = false;
                    h.a((Context) this, getString(R.string.dby), getString(R.string.dc8), getString(R.string.ckr), getString(R.string.abx), false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(21055);
                            FreeWifiNoAuthStateUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            FreeWifiNoAuthStateUI.this.finish();
                            AppMethodBeat.o(21055);
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(21056);
                            FreeWifiNoAuthStateUI.this.finish();
                            AppMethodBeat.o(21056);
                        }
                    });
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void aqU() {
        bzy();
    }

    /* Access modifiers changed, original: protected|final */
    public final void bzy() {
        if (this.mxY) {
            ab.i("MicroMsg.FreeWifi.FreeWifiNoAuthStateUI", "it is authing now");
            return;
        }
        this.mxY = true;
        bzC();
        int c = d.c(this.ssid, this.gDC, this.mxP, this.mxQ);
        a byo = k.byo();
        byo.ssid = this.ssid;
        byo.cuH = this.cuH;
        byo.kBq = m.V(getIntent());
        byo.mue = m.X(getIntent());
        byo.muf = k.b.AddNetwork.muQ;
        byo.mug = k.b.AddNetwork.name;
        byo.result = c;
        byo.cIb = m.Y(getIntent());
        byo.mud = this.csB;
        byo.muh = this.cBb;
        byo.byq().byp();
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
