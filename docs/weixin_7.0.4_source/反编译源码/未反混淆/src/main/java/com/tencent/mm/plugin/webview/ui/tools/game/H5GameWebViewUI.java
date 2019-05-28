package com.tencent.mm.plugin.webview.ui.tools.game;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.k;
import com.tencent.mm.plugin.webview.ui.tools.k.b;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.a;

@a(19)
public class H5GameWebViewUI extends GameWebViewUI {
    private int otH;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(8777);
        super.onCreate(bundle);
        ab.i("MicroMsg.H5GameWebViewUI", "onCreate");
        this.uvn = false;
        this.otH = this.screenOrientation;
        AppMethodBeat.o(8777);
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(8778);
        ab.i("MicroMsg.H5GameWebViewUI", "onNewIntent");
        super.onNewIntent(intent);
        boolean booleanExtra = getIntent().getBooleanExtra("show_full_screen", false);
        setIntent(intent);
        String stringExtra = intent.getStringExtra("rawUrl");
        ab.d("MicroMsg.H5GameWebViewUI", "url = ".concat(String.valueOf(stringExtra)));
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
                    this.icz = new k((JsapiPermissionWrapper) getIntent().getParcelableExtra("hardcode_jspermission"), (GeneralControlWrapper) getIntent().getParcelableExtra("hardcode_general_ctrl"), new b() {
                        public final String aYj() {
                            AppMethodBeat.i(8776);
                            String url = H5GameWebViewUI.this.pzf.getUrl();
                            AppMethodBeat.o(8776);
                            return url;
                        }
                    });
                } else {
                    this.icz.a(stringExtra, null, null);
                }
                this.pzf.loadUrl("about:blank");
                as(this.cOG, false);
                AppMethodBeat.o(8778);
                return;
            }
        }
        AppMethodBeat.o(8778);
    }

    public void onResume() {
        AppMethodBeat.i(8779);
        aBS();
        super.onResume();
        AppMethodBeat.o(8779);
    }

    public final boolean dab() {
        return false;
    }

    public final boolean aYc() {
        return false;
    }
}
