package com.tencent.p177mm.plugin.webview.p580ui.tools.game;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.webview.p580ui.tools.C40344k;
import com.tencent.p177mm.plugin.webview.p580ui.tools.C40344k.C40343b;
import com.tencent.p177mm.protocal.GeneralControlWrapper;
import com.tencent.p177mm.protocal.JsapiPermissionWrapper;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

@C5271a(19)
/* renamed from: com.tencent.mm.plugin.webview.ui.tools.game.H5GameWebViewUI */
public class H5GameWebViewUI extends GameWebViewUI {
    private int otH;

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.game.H5GameWebViewUI$1 */
    class C46131 implements C40343b {
        C46131() {
        }

        public final String aYj() {
            AppMethodBeat.m2504i(8776);
            String url = H5GameWebViewUI.this.pzf.getUrl();
            AppMethodBeat.m2505o(8776);
            return url;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(8777);
        super.onCreate(bundle);
        C4990ab.m7416i("MicroMsg.H5GameWebViewUI", "onCreate");
        this.uvn = false;
        this.otH = this.screenOrientation;
        AppMethodBeat.m2505o(8777);
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.m2504i(8778);
        C4990ab.m7416i("MicroMsg.H5GameWebViewUI", "onNewIntent");
        super.onNewIntent(intent);
        boolean booleanExtra = getIntent().getBooleanExtra("show_full_screen", false);
        setIntent(intent);
        String stringExtra = intent.getStringExtra("rawUrl");
        C4990ab.m7410d("MicroMsg.H5GameWebViewUI", "url = ".concat(String.valueOf(stringExtra)));
        if (!this.uvm.equals(stringExtra)) {
            if (stringExtra.startsWith("http://game.weixin.qq.com/cgi-bin/h5/static/gameloading/index.html")) {
                this.uvm = stringExtra;
            }
            if (this.cOG.equals(stringExtra)) {
                this.screenOrientation = this.otH;
                getIntent().putExtra("show_full_screen", booleanExtra);
                dak();
            } else {
                this.cOG = stringExtra;
                this.screenOrientation = getIntent().getIntExtra("screen_orientation", -1);
                this.uvR.jVi = this.cOG;
                if (this.icz == null) {
                    this.icz = new C40344k((JsapiPermissionWrapper) getIntent().getParcelableExtra("hardcode_jspermission"), (GeneralControlWrapper) getIntent().getParcelableExtra("hardcode_general_ctrl"), new C46131());
                } else {
                    this.icz.mo63705a(stringExtra, null, null);
                }
                this.pzf.loadUrl("about:blank");
                mo30966as(this.cOG, false);
                AppMethodBeat.m2505o(8778);
                return;
            }
        }
        AppMethodBeat.m2505o(8778);
    }

    public void onResume() {
        AppMethodBeat.m2504i(8779);
        aBS();
        super.onResume();
        AppMethodBeat.m2505o(8779);
    }

    public final boolean dab() {
        return false;
    }

    public final boolean aYc() {
        return false;
    }
}
