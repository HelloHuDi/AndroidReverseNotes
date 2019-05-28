package com.tencent.p177mm.plugin.freewifi.p418ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.NetworkInfo.State;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.modelgeo.C26443d;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.freewifi.C11966k;
import com.tencent.p177mm.plugin.freewifi.C11966k.C11967a;
import com.tencent.p177mm.plugin.freewifi.C11966k.C11968b;
import com.tencent.p177mm.plugin.freewifi.C34189m;
import com.tencent.p177mm.plugin.freewifi.model.C45957d;
import com.tencent.p177mm.pluginsdk.permission.C35805b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

@Deprecated
/* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiNoAuthStateUI */
public abstract class FreeWifiNoAuthStateUI extends FreeWifiStateUI {
    private String gDC;
    private int mxP;
    private boolean mxQ;
    private boolean myf = true;

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiNoAuthStateUI$1 */
    class C79801 implements OnClickListener {
        C79801() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(21054);
            C26443d.m42103bX(FreeWifiNoAuthStateUI.this);
            AppMethodBeat.m2505o(21054);
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiNoAuthStateUI$2 */
    class C79812 implements OnClickListener {
        C79812() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(21055);
            FreeWifiNoAuthStateUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
            FreeWifiNoAuthStateUI.this.finish();
            AppMethodBeat.m2505o(21055);
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiNoAuthStateUI$3 */
    class C79823 implements OnClickListener {
        C79823() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(21056);
            FreeWifiNoAuthStateUI.this.finish();
            AppMethodBeat.m2505o(21056);
        }
    }

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
        C45957d.m85352a(this.ssid, 4, getIntent());
        C4990ab.m7416i("MicroMsg.FreeWifi.FreeWifiNoAuthStateUI", "Comes from webview, do auth");
    }

    public final void initView() {
        super.initView();
        setMMTitle(bzA());
    }

    /* JADX WARNING: Missing block: B:3:0x0024, code skipped:
            if (com.tencent.p177mm.pluginsdk.permission.C35805b.m58707a(r8, "android.permission.ACCESS_COARSE_LOCATION", 77, null, null) == false) goto L_0x0026;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onResume() {
        int i = false;
        super.onResume();
        if (this.myf) {
            C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiNoAuthStateUI", "summerper checkPermission checkLocation [%b]", Boolean.valueOf(C35805b.m58707a(this, "android.permission.ACCESS_COARSE_LOCATION", 77, null, null)));
        }
        if (C35805b.m58714o(this, "android.permission.ACCESS_COARSE_LOCATION")) {
            if (C26443d.agA()) {
                i = 1;
            } else {
                C30379h.m48445a((Context) this, getString(C25738R.string.c9z), getString(C25738R.string.f9238tz), getString(C25738R.string.ckr), getString(C25738R.string.f9076or), false, new C79801(), null);
            }
        }
        if (i == 0) {
            C4990ab.m7416i("MicroMsg.FreeWifi.FreeWifiNoAuthStateUI", "check permission not passed!");
        }
    }

    public void onDestroy() {
        super.onDestroy();
    }

    /* renamed from: a */
    public void mo17587a(State state) {
        C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiNoAuthStateUI", "now network state : %s", state.toString());
        if (state == State.CONNECTED && C45957d.m85348MD(this.ssid)) {
            bzD();
            this.mxY = false;
            C45957d.m85352a(this.ssid, 2, getIntent());
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (iArr == null || iArr.length <= 0) {
            C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiNoAuthStateUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()));
            return;
        }
        C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiNoAuthStateUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 77:
                if (iArr.length > 0 && iArr[0] == -1) {
                    this.myf = false;
                    C30379h.m48445a((Context) this, getString(C25738R.string.dby), getString(C25738R.string.dc8), getString(C25738R.string.ckr), getString(C25738R.string.abx), false, new C79812(), new C79823());
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
            C4990ab.m7416i("MicroMsg.FreeWifi.FreeWifiNoAuthStateUI", "it is authing now");
            return;
        }
        this.mxY = true;
        bzC();
        int c = C45957d.m85353c(this.ssid, this.gDC, this.mxP, this.mxQ);
        C11967a byo = C11966k.byo();
        byo.ssid = this.ssid;
        byo.cuH = this.cuH;
        byo.kBq = C34189m.m56063V(getIntent());
        byo.mue = C34189m.m56065X(getIntent());
        byo.muf = C11968b.AddNetwork.muQ;
        byo.mug = C11968b.AddNetwork.name;
        byo.result = c;
        byo.cIb = C34189m.m56066Y(getIntent());
        byo.mud = this.csB;
        byo.muh = this.cBb;
        byo.byq().byp();
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
