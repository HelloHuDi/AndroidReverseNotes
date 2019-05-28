package com.tencent.p177mm.plugin.freewifi.p418ui;

import android.content.Intent;
import android.net.NetworkInfo.State;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.freewifi.C34189m;
import com.tencent.p177mm.plugin.freewifi.model.C11976j;
import com.tencent.p177mm.plugin.freewifi.model.C39113g.C20800b;
import com.tencent.p177mm.plugin.freewifi.model.C45957d;
import com.tencent.p177mm.plugin.freewifi.p416d.C28075a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

@Deprecated
/* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiActivateAuthStateUI */
public class FreeWifiActivateAuthStateUI extends FreeWifiActivateStateUI {

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiActivateAuthStateUI$1 */
    class C391161 implements OnClickListener {
        C391161() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(20889);
            String string = FreeWifiActivateAuthStateUI.this.getString(C25738R.string.c07);
            Intent intent = new Intent();
            intent.putExtra("rawUrl", string);
            intent.putExtra("showShare", false);
            intent.putExtra("show_bottom", false);
            C25985d.m41467b(FreeWifiActivateAuthStateUI.this, "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.m2505o(20889);
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiActivateAuthStateUI$2 */
    class C391172 implements C20800b {

        /* renamed from: com.tencent.mm.plugin.freewifi.ui.FreeWifiActivateAuthStateUI$2$1 */
        class C280841 implements C1202f {
            C280841() {
            }

            public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
                AppMethodBeat.m2504i(20890);
                C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiActivateAuthStateUI", "errType : %d, errCode : %d, errMsg : %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                FreeWifiActivateAuthStateUI.this.mxY = false;
                if (i == 0 && i2 == 0) {
                    C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiActivateAuthStateUI", "authUrl : %s", ((C28075a) c1207m).bze());
                    C11976j.bzb().mo7394a(FreeWifiActivateAuthStateUI.this.ssid, r0, FreeWifiActivateAuthStateUI.this.getIntent());
                    AppMethodBeat.m2505o(20890);
                } else if (i2 == -2014) {
                    C45957d.m85352a(FreeWifiActivateAuthStateUI.this.ssid, -2014, FreeWifiActivateAuthStateUI.this.getIntent());
                    AppMethodBeat.m2505o(20890);
                } else {
                    C45957d.m85352a(FreeWifiActivateAuthStateUI.this.ssid, 3, FreeWifiActivateAuthStateUI.this.getIntent());
                    AppMethodBeat.m2505o(20890);
                }
            }
        }

        C391172() {
        }

        /* renamed from: ci */
        public final void mo36090ci(String str, int i) {
            AppMethodBeat.m2504i(20891);
            C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiActivateAuthStateUI", "get ap auth data : %s, url : %s, mac : %s", str, FreeWifiActivateAuthStateUI.this.jUg, C45957d.byK());
            if (!C5046bo.isNullOrNil(str)) {
                String str2 = str;
                new C28075a(FreeWifiActivateAuthStateUI.this.jUg, FreeWifiActivateAuthStateUI.this.ssid, r3, FreeWifiActivateAuthStateUI.this.mxW, str2, "", i, C34189m.m56063V(FreeWifiActivateAuthStateUI.this.getIntent())).mo68619c(new C280841());
            }
            AppMethodBeat.m2505o(20891);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(20892);
        super.onCreate(bundle);
        if (this.cvd != 2) {
            C45957d.m85352a(this.ssid, 1, getIntent());
        }
        C4990ab.m7416i("MicroMsg.FreeWifi.FreeWifiActivateAuthStateUI", "now it is from qrcode, try to auth");
        AppMethodBeat.m2505o(20892);
    }

    public final void initView() {
        AppMethodBeat.m2504i(20893);
        super.initView();
        this.mxV = (Button) findViewById(2131824143);
        this.mxV.setOnClickListener(new C391161());
        setMMTitle((int) C25738R.string.c0t);
        AppMethodBeat.m2505o(20893);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(20894);
        super.onDestroy();
        AppMethodBeat.m2505o(20894);
    }

    /* renamed from: a */
    public final void mo17587a(State state) {
        AppMethodBeat.m2504i(20895);
        C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiActivateAuthStateUI", "now network state : %s", state.toString());
        if (state == State.CONNECTED && C45957d.m85348MD(this.ssid)) {
            bzD();
            bzF();
        }
        AppMethodBeat.m2505o(20895);
    }

    /* Access modifiers changed, original: protected|final */
    public final void aqU() {
        AppMethodBeat.m2504i(20896);
        C11976j.bzb().mo7393a(this.ssid, new C391172(), this.cdf, getIntent());
        AppMethodBeat.m2505o(20896);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bzy() {
        AppMethodBeat.m2504i(20897);
        bzC();
        C45957d.m85349ME(this.ssid);
        AppMethodBeat.m2505o(20897);
    }

    /* Access modifiers changed, original: protected|final */
    public final int bzz() {
        AppMethodBeat.m2504i(20898);
        C11976j.byV();
        int MC = C45957d.m85347MC(this.ssid);
        AppMethodBeat.m2505o(20898);
        return MC;
    }
}
